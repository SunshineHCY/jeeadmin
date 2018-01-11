package cn.admin.modules.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.test.entity.SingleTable;
import cn.admin.modules.test.service.ISingleTableService;

/**   
 * @Title: 单表测试
 * @Description: 单表测试
 * @author jeeadmin
 * @date 2017-07-24 11:59:21
 * @version V1.0   
 *
 */
@Transactional
@Service("singleTableService")
public class SingleTableServiceImpl  extends CommonServiceImpl<SingleTable> implements  ISingleTableService {

}
