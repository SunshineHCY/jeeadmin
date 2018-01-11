package cn.admin.modules.dept.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import cn.admin.core.common.entity.AbstractEntity;

@Entity
@Table(name = "sys_dept")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class Dept extends AbstractEntity<String> {
	/** 主键 */
	private String id;
	/** 部门名称 */
	private String deptName;
	/** 部门编号 */
	private String deptNo;

	/**
	 * 获取 id
	 * 
	 * @return: String 主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false, length = 32, scale = 0)
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "dept_name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_no")
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

}
