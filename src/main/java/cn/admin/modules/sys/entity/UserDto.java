package cn.admin.modules.sys.entity;

import cn.admin.core.common.entity.AbstractEntity;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2017  
 * Company:		拍财富
 * Author:		admin
 * Version:		1.0  
 * Create at:	2017年12月29日 上午10:16:01  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */

public class UserDto extends AbstractEntity<String> {

	private static final long serialVersionUID = -5973655341996154874L;
	/** 主键 */
	private String id;
	/** 部门名称 */
	private String deptName;
	/** 部门编号 */
	private String deptNo;

	private String ipone;
	private String userName;
	private String realname;
	private String num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getIpone() {
		return ipone;
	}

	public void setIpone(String ipone) {
		this.ipone = ipone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

}
