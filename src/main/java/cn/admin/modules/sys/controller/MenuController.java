package cn.admin.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseTreeController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.sys.entity.Menu;

@Controller
@RequestMapping("${admin.url.prefix}/sys/menu")
@RequiresPathPermission("sys:menu")
public class MenuController extends BaseTreeController<Menu, String> {

}
