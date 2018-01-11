package cn.admin.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseTreeController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.sys.entity.Organization;

@Controller
@RequestMapping("${admin.url.prefix}/sys/organization")
@RequiresPathPermission("sys:organization")
public class OrganizationController extends BaseTreeController<Organization, String> {
	
}
