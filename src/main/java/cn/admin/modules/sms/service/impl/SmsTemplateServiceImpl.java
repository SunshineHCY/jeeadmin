package cn.admin.modules.sms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.modules.sms.entity.SmsTemplate;
import cn.admin.modules.sms.service.ISmsTemplateService;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeadmin
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@Transactional
@Service("smsTemplateService")
public class SmsTemplateServiceImpl extends CommonServiceImpl<SmsTemplate> implements ISmsTemplateService {
}
