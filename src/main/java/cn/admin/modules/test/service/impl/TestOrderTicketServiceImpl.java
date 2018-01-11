package cn.admin.modules.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.test.entity.TestOrderTicket;
import cn.admin.modules.test.service.ITestOrderTicketService;

/**   
 * @Title: 机票信息
 * @Description: 机票信息
 * @author jeeadmin
 * @date 2017-07-24 12:10:30
 * @version V1.0   
 *
 */
@Transactional
@Service("testOrderTicketService")
public class TestOrderTicketServiceImpl  extends CommonServiceImpl<TestOrderTicket> implements  ITestOrderTicketService {

}
