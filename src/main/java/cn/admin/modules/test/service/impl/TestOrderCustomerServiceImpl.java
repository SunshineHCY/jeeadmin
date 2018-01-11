package cn.admin.modules.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.test.entity.TestOrderCustomer;
import cn.admin.modules.test.service.ITestOrderCustomerService;

/**   
 * @Title: 客户信息
 * @Description: 客户信息
 * @author jeeadmin
 * @date 2017-07-24 12:10:30
 * @version V1.0   
 *
 */
@Transactional
@Service("testOrderCustomerService")
public class TestOrderCustomerServiceImpl  extends CommonServiceImpl<TestOrderCustomer> implements  ITestOrderCustomerService {

}
