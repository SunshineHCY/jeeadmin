package cn.admin.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.Role;
import cn.admin.modules.sys.service.IRoleService;

@Transactional
@Service("roleService")
public class RoleServiceImpl extends CommonServiceImpl<Role> implements IRoleService {

	@Override
	public List<Role> findListByUserId(String userid) {
		return listByHql("from Role r  WHERE r.id in (SELECT ur.roleId from UserRole ur WHERE ur.userId=?)", userid);
	}

}
