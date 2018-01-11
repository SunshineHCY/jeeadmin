package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.UserRole;
import cn.admin.modules.sys.service.IUserRoleService;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRole> implements IUserRoleService {

}
