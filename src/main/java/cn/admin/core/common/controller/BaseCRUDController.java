package cn.admin.core.common.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.admin.core.common.data.DuplicateValid;
import cn.admin.core.common.entity.AbstractEntity;
import cn.admin.core.common.service.ICommonService;
import cn.admin.core.model.AjaxJson;
import cn.admin.core.model.PageJson;
import cn.admin.core.model.ValidJson;
import cn.admin.core.query.annotation.PageableDefaults;
import cn.admin.core.query.data.PropertyPreFilterable;
import cn.admin.core.query.data.Queryable;
import cn.admin.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.admin.core.utils.MyBeanUtils;
import cn.admin.core.utils.ObjectUtils;
import cn.admin.core.utils.StringUtils;
import cn.admin.core.utils.jeeadminPropertiesUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

public abstract class BaseCRUDController<Entity extends AbstractEntity<ID>, ID extends Serializable> extends
		BaseBeanController<Entity> {

	protected ICommonService<Entity> commonService;

	/**
	 * 设置基础service
	 *
	 * @param baseService
	 */
	@Autowired
	public void setCommonService(ICommonService<Entity> commonService) {
		this.commonService = commonService;
	}

	public Entity get(ID id) {
		if (!ObjectUtils.isNullOrEmpty(id)) {
			return commonService.get(id);
		} else {
			return newModel();
		}
	}

	/**
	 * list 运行之前
	 * 
	 * @param model
	 * @param request
	 * @param response
	 */
	public void preList(Model model, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequiresMethodPermissions("list")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
		preList(model, request, response);
		return display("list");
	}

	/**
	 * 在异步获取数据之前
	 * 
	 * @param model
	 * @param request
	 * @param response
	 */
	public void preAjaxList(Queryable queryable, DetachedCriteria detachedCriteria, HttpServletRequest request,
			HttpServletResponse response) {

	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
	@PageableDefaults(sort = "id=desc")
	private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		preAjaxList(queryable, detachedCriteria, request, response);
		propertyPreFilterable.addQueryProperty("id");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(commonService.list(queryable, detachedCriteria));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 多表查询list
	 * 
	 * @param queryable
	 * @param propertyPreFilterable
	 * @param detachedCriteria
	 * @param request
	 * @param response
	 * @param list
	 * @param total
	 * @throws IOException
	 */
	public void moreTableAjaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable,
			DetachedCriteria detachedCriteria, HttpServletRequest request, HttpServletResponse response, List list,
			Long total) throws IOException {
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(commonService.moreTableList(queryable, detachedCriteria, list,
				total));

		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	public String showView(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	/**
	 * 
	 * @title: _view
	 * @description: 查看
	 * @param model
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String _view(Model model, @PathVariable("id") ID id, HttpServletRequest request, HttpServletResponse response) {
		Entity entity = get(id);
		showUpdate(entity, model, request, response);
		model.addAttribute("data", entity);
		String showView = showView(newModel(), model, request, response);
		if (!StringUtils.isEmpty(showView)) {
			return display(showView);
		}
		return display("edit");
	}

	public void preEdit(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {

	}

	public String showCreate(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String _showCreate(Model model, HttpServletRequest request, HttpServletResponse response) {
		preEdit(newModel(), model, request, response);
		String creteaView = showCreate(newModel(), model, request, response);
		if (!model.containsAttribute("data")) {
			model.addAttribute("data", newModel());
		}
		if (!StringUtils.isEmpty(creteaView)) {
			return creteaView;
		}
		return display("edit");
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson create(Model model, @Valid @ModelAttribute("data") Entity entity, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	public String showUpdate(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String _showUpdate(@PathVariable("id") ID id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Entity entity = get(id);
		preEdit(entity, model, request, response);
		model.addAttribute("data", entity);
		String updateView = showUpdate(newModel(), model, request, response);
		if (!StringUtils.isEmpty(updateView)) {
			return updateView;
		}
		return display("edit");
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson update(Model model, @Valid @ModelAttribute("data") Entity entity, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	/**
	 * 保存数据之前
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 */
	public void preSave(Entity entity, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doSave(Entity entity, HttpServletRequest request, HttpServletResponse response, BindingResult result) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("保存成功");
		if (hasError(entity, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				ajaxJson.fail(errorMsg);
			} else {
				ajaxJson.fail("保存失败");
			}
			return ajaxJson;
		}
		try {
			preSave(entity, request, response);
			if (ObjectUtils.isNullOrEmpty(entity.getId())) {
				commonService.save(entity);
			} else {
				// FORM NULL不更新
				Entity oldEntity = commonService.get(entity.getId());
				MyBeanUtils.copyBeanNotNull2Bean(entity, oldEntity);
				commonService.update(oldEntity);
			}
			afterSave(entity, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
		}
		return ajaxJson;
	}

	/**
	 * 保存数据之后
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 */
	public void afterSave(Entity entity, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(@PathVariable("id") ID id) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		if (jeeadminPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许删除！");
			return ajaxJson;
		}
		try {
			commonService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) ID[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		if (jeeadminPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许删除！");
			return ajaxJson;
		}
		try {
			List<ID> idList = java.util.Arrays.asList(ids);
			commonService.batchDeleteById(idList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
		ValidJson validJson = new ValidJson();
		Boolean valid = Boolean.FALSE;
		try {
			valid = commonService.doValid(duplicateValid);

			if (valid) {
				validJson.setStatus("y");
				validJson.setInfo("验证通过!");
			} else {
				validJson.setStatus("n");
				if (!StringUtils.isEmpty(duplicateValid.getErrorMsg())) {
					validJson.setInfo(duplicateValid.getErrorMsg());
				} else {
					validJson.setInfo("当前信息重复!");
				}
			}
		} catch (Exception e) {
			validJson.setStatus("n");
			validJson.setInfo("验证异常，请检查字段是否正确!");
		}
		return validJson;
	}

}
