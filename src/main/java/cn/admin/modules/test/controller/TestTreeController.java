package cn.admin.modules.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseTreeController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.test.entity.TestTree;

/**   
 * @Title: 测试数
 * @Description: 测试数
 * @author jeeadmin
 * @date 2017-07-24 12:00:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/test/testtree")
@RequiresPathPermission("test:testtree")
public class TestTreeController extends BaseTreeController<TestTree, String> {

}
