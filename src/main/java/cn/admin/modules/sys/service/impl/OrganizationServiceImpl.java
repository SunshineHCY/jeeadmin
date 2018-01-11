package cn.admin.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.TreeCommonServiceImpl;
import cn.admin.modules.sys.entity.Organization;
import cn.admin.modules.sys.service.IOrganizationService;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return listByHql(
				"from Organization o where  o.id in (SELECT uo.organizationId from UserOrganization uo WHERE uo.userId = ?)",
				userid);
	}

}
