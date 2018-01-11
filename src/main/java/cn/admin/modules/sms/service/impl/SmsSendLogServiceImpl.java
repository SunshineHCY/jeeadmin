package cn.admin.modules.sms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sms.entity.SmsSendLog;
import cn.admin.modules.sms.service.ISmsSendLogService;

/**   
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeadmin
 * @date 2017-06-08 12:56:37
 * @version V1.0   
 *
 */
@Transactional
@Service("smsSendLogService")
public class SmsSendLogServiceImpl  extends CommonServiceImpl<SmsSendLog> implements  ISmsSendLogService {

}
