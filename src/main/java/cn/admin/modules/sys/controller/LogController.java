package cn.admin.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.sys.entity.Log;

/**
 * 
 
 * 
 * @title: 系统日志
 * @package cn.admin.modules.sys.controller
 * @description: 系统日志
* @author: lichao
 * @date: 2017年5月29日 下午11:35:26
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/log")
@RequiresPathPermission("sys:log")
public class LogController extends BaseCRUDController<Log, String> {

}
