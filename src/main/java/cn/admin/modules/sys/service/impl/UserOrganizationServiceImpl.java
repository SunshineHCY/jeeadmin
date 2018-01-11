package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.UserOrganization;
import cn.admin.modules.sys.service.IUserOrganizationService;

@Transactional
@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends CommonServiceImpl<UserOrganization>
		implements IUserOrganizationService {

}
