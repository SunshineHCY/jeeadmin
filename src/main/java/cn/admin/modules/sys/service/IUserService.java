package cn.admin.modules.sys.service;

import cn.admin.core.common.service.ICommonService;
import cn.admin.modules.sys.entity.User;

/**
 * 
 
 * 
 * @title: IUserService.java
 * @package cn.admin.modules.sys.service
 * @description: 用户
* @author: lichao
 * @date: 2017年7月11日 下午9:21:07
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
public interface IUserService extends ICommonService<User> {
	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(String userid, String newPassword);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 根据Email查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * 根据Email查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByPhone(String phone);

}
