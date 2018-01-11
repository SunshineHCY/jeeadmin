package cn.admin.modules.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.test.entity.TestOrderMain;

/**   
 * @Title: 订单主表
 * @Description: 订单主表
 * @author jeeadmin
 * @date 2017-07-24 12:10:30
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/test/testordermain")
@RequiresPathPermission("test:testordermain")
public class TestOrderMainController extends BaseCRUDController<TestOrderMain, String> {

}
