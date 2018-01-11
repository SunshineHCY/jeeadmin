package cn.admin.modules.sys.service;

import java.util.List;

import cn.admin.core.common.service.ICommonService;
import cn.admin.modules.sys.entity.Role;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:15
 * @version V1.0
 *
 */
public interface IRoleService extends ICommonService<Role> {
	/**
	 * 通过用户ID查找角色
	 */
	public List<Role> findListByUserId(String userid);
}
