package cn.admin.core.common.controller;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

import cn.admin.core.common.entity.AbstractEntity;
import cn.admin.core.common.entity.tree.BootstrapTreeHelper;
import cn.admin.core.common.entity.tree.BootstrapTreeNode;
import cn.admin.core.common.entity.tree.TreeNode;
import cn.admin.core.common.entity.tree.TreeSortUtil;
import cn.admin.core.common.service.ICommonService;
import cn.admin.core.common.service.ITreeCommonService;
import cn.admin.core.model.PageJson;
import cn.admin.core.query.data.PropertyPreFilterable;
import cn.admin.core.query.data.QueryPropertyPreFilter;
import cn.admin.core.query.data.Queryable;
import cn.admin.core.utils.ObjectUtils;
import cn.admin.core.utils.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseTreeController<Entity extends AbstractEntity<ID> & TreeNode<ID>, ID extends Serializable>
		extends BaseCRUDController<Entity, ID> {

	ITreeCommonService<Entity, ID> treeCommonService;

	@Autowired
	public void treeCommonService(ITreeCommonService<Entity, ID> treeCommonService) {
		this.treeCommonService = treeCommonService;
		setCommonService((ICommonService<Entity>) treeCommonService);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public void treeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		List<Entity> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = commonService.listWithNoPage(queryable, detachedCriteria);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				detachedCriteria.add(Restrictions.isNull("parentId"));
			} else {
				detachedCriteria.add(Restrictions.eq("parentId", nodeid));
			}
			treeNodeList = commonService.listWithNoPage(queryable, detachedCriteria);
			TreeSortUtil.create().sync(treeNodeList);
		}
		PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
		propertyPreFilterable.addQueryProperty("id", "name", "expanded", "hasChildren", "leaf", "loaded", "level",
				"parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxTreeList", method = RequestMethod.GET)
	private void ajaxTreeList(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response, PropertyPreFilterable propertyPreFilterable)
			throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		preAjaxList(queryable, detachedCriteria, request, response);

		List<Entity> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = commonService.listWithNoPage(queryable, detachedCriteria);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				detachedCriteria.add(Restrictions.isNull("parentId"));
			} else {
				detachedCriteria.add(Restrictions.eq("parentId", nodeid));
			}
			treeNodeList = commonService.listWithNoPage(queryable, detachedCriteria);
			TreeSortUtil.create().sync(treeNodeList);
		}
		propertyPreFilterable.addQueryProperty("id", "expanded", "hasChildren", "leaf", "loaded", "level", "parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "bootstrapTreeData")
	private void bootstrapTreeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") ID nodeid, HttpServletRequest request,
			HttpServletResponse response, PropertyPreFilterable propertyPreFilterable) throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		List<Entity> treeNodeList = commonService.listWithNoPage(queryable, detachedCriteria);
		List<BootstrapTreeNode> bootstrapTreeNodes = BootstrapTreeHelper.create().sort(treeNodeList);
		propertyPreFilterable.addQueryProperty("text", "href", "tags", "nodes");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		String content = JSON.toJSONString(bootstrapTreeNodes, filter);
		StringUtils.printJson(response, content);
	}

}
