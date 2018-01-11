package cn.admin.modules.sys.service;

import java.util.List;

import cn.admin.core.common.service.ICommonService;
import cn.admin.core.query.data.Queryable;
import cn.admin.modules.sys.entity.UserDto;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2017  
 * Company:		拍财富
 * Author:		admin
 * Version:		1.0  
 * Create at:	2017年12月29日 上午9:27:56  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */

public interface KaifaService extends ICommonService<UserDto> {
	/**
	 * 获取列表
	 */
	public List<UserDto> list(Queryable queryable);

	/**
	 * 下载
	 * 
	 * @param dto
	 * @return
	 */
	public List exportList(UserDto dto);

	/**
	 * @return
	 */
	public Integer getNum(Queryable queryable);

}
