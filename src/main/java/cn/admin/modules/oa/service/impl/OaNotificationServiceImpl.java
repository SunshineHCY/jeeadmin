package cn.admin.modules.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.oa.entity.OaNotification;
import cn.admin.modules.oa.service.IOaNotificationService;

/**   
 * @Title: 通知公告
 * @Description: 通知公告
 * @author jeeadmin
 * @date 2017-06-10 17:15:17
 * @version V1.0   
 *
 */
@Transactional
@Service("oaNotificationService")
public class OaNotificationServiceImpl  extends CommonServiceImpl<OaNotification> implements  IOaNotificationService {

}
