package cn.admin.modules.dept.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.dept.entity.Dept;

@Controller
@RequestMapping("${admin.url.prefix}/dept/deptmanage")
@RequiresPathPermission("dept:deptmanage")
public class DeptController extends BaseCRUDController<Dept, String> {

}
