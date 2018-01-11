package cn.admin.modules.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.dao.ICommonDao;
import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.core.query.data.Queryable;
import cn.admin.core.utils.StringUtils;
import cn.admin.modules.sys.entity.UserDto;
import cn.admin.modules.sys.service.KaifaService;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2017  
 * Company:		拍财富
 * Author:		admin
 * Version:		1.0  
 * Create at:	2017年12月29日 上午9:30:16  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
@Transactional
@Service("kaifaService")
public class kaifaServiceImpl extends CommonServiceImpl<UserDto> implements KaifaService {

	@Autowired
	ICommonDao commonDao;

	@Override
	public List list(Queryable queryable) {

		String hql = " SELECT su.id as id,su.realname as realname,su.username as userName,so.name as deptName,so.id as deptNo,su.phone AS ipone "
				+ "FROM User su,Organization so, UserOrganization suo WHERE suo.organizationId = so.id"
				+ " AND suo.userId = su.id";

		Map<String, Object> params = new HashMap<String, Object>();
		if (queryable.getCondition() != null) {
			if (queryable.getCondition().getFilterFor("ipone") != null) {
				String ipone = queryable.getValue("ipone").toString();
				hql += " and su.phone = ? ";
				params.put("iphone", ipone);
			}
			if (queryable.getCondition().getFilterFor("realname") != null) {
				String name = queryable.getValue("realname").toString();
				hql += " and su.realname = ? ";
				params.put("name", name);
			}
		}

		Object[] params1 = params.values().toArray();

		int pagea = queryable.getPageable().getPageNumber();
		int sizes = queryable.getPageable().getPageSize();

		return listByHql(hql, pagea, sizes, params1);

	}

	/*
	 * (non-Javadoc) 下载
	 * 
	 * @see
	 * cn.admin.modules.sys.service.KaifaService#exportList(cn.admin.modules
	 * .sys.entity.UserDto)
	 */
	@Override
	public List exportList(UserDto dto) {
		String hql = " SELECT su.id as id,su.realname as realname,su.username as userName,so.name as deptName,so.id as deptNo,su.phone AS ipone "
				+ "FROM User su,Organization so, UserOrganization suo WHERE suo.organizationId = so.id"
				+ " AND suo.userId = su.id";
		Map<String, Object> params = new HashMap<String, Object>();
		if (dto != null) {
			if (StringUtils.isNotBlank(dto.getIpone())) {
				String ipone = dto.getIpone();
				hql += " and su.phone = :iphone ";
				params.put("iphone", ipone);
			}
			if (StringUtils.isNotBlank(dto.getRealname())) {
				String name = dto.getRealname();
				hql += " and su.realname = :name ";
				params.put("name", name);
			}
		}
		return listByAliasHql(hql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.admin.modules.sys.service.KaifaService#getNum()
	 */
	@Override
	public Integer getNum(Queryable queryable) {
		String hql = " SELECT count(*) as num "
				+ " FROM sys_User su,sys_Organization so, sys_User_Organization suo WHERE suo.organization_Id = so.id"
				+ " AND suo.user_Id = su.id";
		Map<String, Object> params = new HashMap<String, Object>();
		if (queryable.getCondition() != null) {
			if (queryable.getCondition().getFilterFor("ipone") != null) {
				String ipone = queryable.getValue("ipone").toString();
				hql += " and su.phone = ? ";
				params.put("iphone", ipone);
			}
			if (queryable.getCondition().getFilterFor("realname") != null) {
				String name = queryable.getValue("realname").toString();
				hql += " and su.realname = ? ";
				params.put("name", name);
			}
		}
		Object[] params1 = params.values().toArray();
		return countBySql(hql, params1);
	}
}
