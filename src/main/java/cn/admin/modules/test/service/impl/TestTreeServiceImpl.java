package cn.admin.modules.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.TreeCommonServiceImpl;
import cn.admin.modules.test.entity.TestTree;
import cn.admin.modules.test.service.ITestTreeService;

/**   
 * @Title: 测试数
 * @Description: 测试数
 * @author jeeadmin
 * @date 2017-07-24 12:00:32
 * @version V1.0   
 *
 */
@Transactional
@Service("testTreeService")
public class TestTreeServiceImpl  extends TreeCommonServiceImpl<TestTree,String> implements  ITestTreeService {

}
