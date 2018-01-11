package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sys.entity.UserLastOnline;
import cn.admin.modules.sys.service.IUserLastOnlineService;

/**   
 * @Title: 最后在线情况
 * @Description: 最后在线情况
 * @author jeeadmin
 * @date 2017-05-15 08:18:21
 * @version V1.0   
 *
 */
@Transactional
@Service("userLastOnlineService")
public class UserLastOnlineServiceImpl  extends CommonServiceImpl<UserLastOnline> implements  IUserLastOnlineService {

}
