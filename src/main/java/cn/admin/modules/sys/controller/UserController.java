package cn.admin.modules.sys.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.model.AjaxJson;
import cn.admin.core.query.data.Queryable;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.core.utils.MyBeanUtils;
import cn.admin.core.utils.StringUtils;
import cn.admin.core.utils.jeeadminPropertiesUtil;
import cn.admin.modules.sys.entity.Organization;
import cn.admin.modules.sys.entity.Role;
import cn.admin.modules.sys.entity.User;
import cn.admin.modules.sys.entity.UserOrganization;
import cn.admin.modules.sys.entity.UserRole;
import cn.admin.modules.sys.service.IOrganizationService;
import cn.admin.modules.sys.service.IRoleService;
import cn.admin.modules.sys.service.IUserOrganizationService;
import cn.admin.modules.sys.service.IUserRoleService;
import cn.admin.modules.sys.service.IUserService;
import cn.admin.modules.sys.utils.UserUtils;

/**
 * 
 
 * 
 * @title: UserController.java
 * @package cn.admin.modules.sys.controller
 * @description: 用户操作控制器
* @author: lichao
 * @date: 2017年5月25日 上午9:52:20
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/user")
@RequiresPathPermission("sys:user")
public class UserController extends BaseCRUDController<User, String> {
	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IUserOrganizationService userOrganizationService;

	public UserController() {
		setCommonService(userService);
	}

	@Override
	public String showCreate(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		return display("create");
	}

	@RequestMapping(value = "{id}/changePassword", method = RequestMethod.GET)
	public String changePassword(@PathVariable("id") String id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = userService.get(id);
		model.addAttribute("data", user);
		return display("changePassword");
	}

	@RequestMapping(value = "{id}/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson changePassword(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("密码修改成功");
		if (jeeadminPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许修改密码！");
			return ajaxJson;
		}
		try {
			String password = request.getParameter("password");
			userService.changePassword(id, password);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("密码修改失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "{id}/avatar", method = RequestMethod.GET)
	public String avatar(@PathVariable("id") String id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = userService.get(id);
		model.addAttribute("data", user);
		return display("avatar");
	}

	@RequestMapping(value = "{id}/avatar", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson avatar(User user, HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("头像修改成功");
		try {
			User oldUser = commonService.get(user.getId());
			MyBeanUtils.copyBeanNotNull2Bean(user, oldUser);
			commonService.update(oldUser);
			String currentUserId = UserUtils.getUser().getId();
			if (currentUserId.equals(user.getId())) {
				UserUtils.clearCache();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("头像修改失败");
		}
		return ajaxJson;
	}

	@Override
	public void preEdit(User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		// 查询所有的角色List
		List<Role> allRoles = roleService.list();
		request.setAttribute("allRoles", allRoles);
		if (!StringUtils.isEmpty(user.getId())) {
			// 查找关联角色
			List<Role> userRoles = roleService.findListByUserId(user.getId());
			request.setAttribute("roleIdList", userRoles);
			List<Organization> organizations = organizationService.findListByUserId(user.getId());
			String organizationIds = "";
			String organizationNames = "";
			for (Organization organization : organizations) {
				if (!StringUtils.isEmpty(organizationIds)) {
					organizationIds += ",";
					organizationNames += ",";
				}
				String organizationId = organization.getId();
				organizationIds += organizationId;
				organizationNames += organization.getName();

			}
			request.setAttribute("organizationIds", organizationIds);
			request.setAttribute("organizationNames", organizationNames);
		}
	}

	@Override
	public void preAjaxList(Queryable queryable, DetachedCriteria detachedCriteria, HttpServletRequest request,
			HttpServletResponse response) {
		// 子查询
		String organizationid = request.getParameter("organizationid");
		if (!StringUtils.isEmpty(organizationid)) {
			DetachedCriteria userOrganizationCriteria = DetachedCriteria.forClass(UserOrganization.class);
			userOrganizationCriteria.setProjection(Property.forName("user.id"));
			userOrganizationCriteria.add(Restrictions.eq("organization.id", organizationid));
			detachedCriteria.add(Property.forName("id").in(userOrganizationCriteria));
		}

	}

	@Override
	public void preSave(User entity, HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void afterSave(User entity, HttpServletRequest request, HttpServletResponse response) {
		// 删除角色关联
		String[] roleIdList = request.getParameterValues("roleIdList");
		if (roleIdList != null && roleIdList.length > 0) {
			userRoleService.batchDeleteByProperty("userId", entity.getId());
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			for (String roleid : roleIdList) {
				UserRole userRole = new UserRole();
				userRole.setUserId(entity.getId());
				userRole.setRoleId(roleid);
				userRoleList.add(userRole);
			}
			userRoleService.batchSave(userRoleList);
		}

		// 删除部门关联
		String organizationIdListStr = request.getParameter("organizationIds");
		String[] organizationIdList = organizationIdListStr.split(",");
		if (organizationIdList != null && organizationIdList.length > 0) {
			userOrganizationService.batchDeleteByProperty("userId", entity.getId());
			List<UserOrganization> userOrganizationList = new ArrayList<UserOrganization>();
			for (String organizationId : organizationIdList) {
				UserOrganization userOrganization = new UserOrganization();
				userOrganization.setUserId(entity.getId());
				userOrganization.setOrganizationId(organizationId);
				userOrganizationList.add(userOrganization);
			}
			userOrganizationService.batchSave(userOrganizationList);
		}
	}

	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info(@RequestParam(required = false) String id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		User user = userService.get(id);
		model.addAttribute("data", user);
		return display("info");
	}
}