package cn.admin.modules.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.core.common.controller.BaseCRUDController;
import cn.admin.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.admin.modules.test.entity.SingleTable;

/**   
 * @Title: 单表测试
 * @Description: 单表测试
 * @author jeeadmin
 * @date 2017-07-24 11:59:21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/test/singletable")
@RequiresPathPermission("test:singletable")
public class SingleTableController extends BaseCRUDController<SingleTable, String> {

}
