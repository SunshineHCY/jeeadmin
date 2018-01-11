package cn.admin.modules.sys.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.query.annotation.PageableDefaults;
import cn.admin.core.query.data.PropertyPreFilterable;
import cn.admin.core.query.data.Queryable;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.core.utils.ExcelUtil;
import cn.admin.modules.sys.entity.UserDto;
import cn.admin.modules.sys.service.KaifaService;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2017  
 * Company:		拍财富
 * Author:		admin
 * Version:		1.0  
 * Create at:	2017年12月29日 上午8:57:25  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Controller
@RequestMapping("${admin.url.prefix}/test/kaifa")
@RequiresPathPermission("test:kaifa")
public class kafaController extends BaseCRUDController<UserDto, String> {
	@Autowired
	private KaifaService kaifaService;

	/**
	 * 获取列表信息
	 * 
	 * @param queryable
	 * @param propertyPreFilterable
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "moreTableAjaxList", method = { RequestMethod.GET, RequestMethod.POST })
	@PageableDefaults(sort = "ipone=desc")
	public void moreTableAjaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable,
			HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		List list = kaifaService.list(queryable);
		Integer total = kaifaService.getNum(queryable);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserDto.class);
		moreTableAjaxList(queryable, propertyPreFilterable, detachedCriteria, request, response, list,
				Long.valueOf(total));
	}

	/**
	 * 条件下载
	 * 
	 * @param dto
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "orderExport", method = { RequestMethod.GET, RequestMethod.POST })
	public String export(@Valid @ModelAttribute("data") UserDto dto, HttpServletRequest request,
			HttpServletResponse response) {
		LinkedHashMap<String, String> title = new LinkedHashMap<String, String>();
		title.put("realname", "姓名");
		title.put("userName", "登录名");
		title.put("deptName", "部门名称");
		title.put("deptNo", "部门编号");
		title.put("ipone", "手机号码");

		String fileName = "kafa.xls";

		List<Object> listContent = new ArrayList<Object>();
		response.setHeader("Content-type", "textml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			List list = kaifaService.exportList(dto);
			Object[] obj = new Object[] {};
			List<UserDto> lists = new ArrayList<UserDto>();
			for (int i = 0; i < list.size(); i++) {
				UserDto dtos = new UserDto();
				obj = (Object[]) list.get(i);
				dtos.setId(obj[0] + "");
				dtos.setRealname(obj[1] + "");
				dtos.setUserName(obj[2] + "");
				dtos.setDeptName(obj[3] + "");
				dtos.setDeptNo(obj[4] + "");
				dtos.setIpone(obj[5] + "");
				lists.add(dtos);

			}
			List<?> data = lists;
			listContent.addAll(data);
			ExcelUtil.exportExcel(response, fileName, title, listContent);
		} catch (Exception e) {
			logger.error("导出列表错误：" + e.getMessage(), e);
		}
		return null;

	}

	/**
	 * 获取总条数
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "total")
	@ResponseBody
	public String total(Queryable queryable, Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String name = request.getParameter("realname");
		String ipone = request.getParameter("ipone");

		queryable.addCondition("realname", URLDecoder.decode(name, "UTF-8"));
		queryable.addCondition("ipone", URLDecoder.decode(ipone, "UTF-8"));

		Integer total = kaifaService.getNum(queryable);
		model.addAttribute("data", String.valueOf(total));
		return String.valueOf(total);
	}
}
