package cn.admin.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.model.AjaxJson;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.sys.entity.DictGroup;
import cn.admin.modules.sys.utils.DictUtils;

@Controller
@RequestMapping("${admin.url.prefix}/sys/dict/group")
@RequiresPathPermission("sys:dict")
public class DictGroupController extends BaseCRUDController<DictGroup, String> {

	@RequestMapping(value = "/forceRefresh", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson forceRefresh(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("字典刷新成功");
		try {
		    DictUtils.clear();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("字典刷新失败" + e.getMessage());
		}
		return ajaxJson;
	}
}
