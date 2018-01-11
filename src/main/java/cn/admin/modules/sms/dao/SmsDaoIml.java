package cn.admin.modules.sms.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.admin.core.disruptor.sms.SmsDao;
import cn.admin.core.disruptor.sms.SmsData;
import cn.admin.core.utils.StringUtils;
import cn.admin.core.utils.sms.data.SmsResult;
import cn.admin.modules.sms.entity.SmsSendLog;
import cn.admin.modules.sms.entity.SmsTemplate;
import cn.admin.modules.sms.service.ISmsSendLogService;
import cn.admin.modules.sms.service.ISmsTemplateService;

/**
 * 
 
 * 
 * @title: SmsDaoIml.java
 * @package cn.admin.modules.sms.dao
 * @description: 短信信息返回
* @author: lichao
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
public class SmsDaoIml implements SmsDao {
	@Autowired
	private ISmsSendLogService smsSendLogService;
	@Autowired
	private ISmsTemplateService smsTemplateService;

	@Override
	public void doStart() {

	}

	@Override
	public void doSend(String eventId, SmsData smsData) {
		SmsSendLog smsSendLog = new SmsSendLog();
		smsSendLog.setId(eventId);
		String templateId = smsData.getSmsTemplate().getTemplateId();
		try {
			SmsTemplate smsTemplateEntity = smsTemplateService.get("templateId", templateId);
			if (smsTemplateEntity != null) {
				smsSendLog.setBusinessType(smsTemplateEntity.getBusinessType());
				// smsSendLog.setCode(smsTemplateEntity.getCode());
			} else {
				smsSendLog.setBusinessType("99");
			}
		} catch (Exception e) {
			smsSendLog.setBusinessType("99");
		}

		smsSendLog.setTemplateContent(smsData.getSmsTemplate().getTemplateContent());
		smsSendLog.setTemplateId(smsData.getSmsTemplate().getTemplateId());
		smsSendLog.setPhone(smsData.getPhone());
		smsSendLog.setSenddata(StringUtils.join(smsData.getDatas(), ","));
		smsSendLog.setStatus("0");
		smsSendLogService.save(smsSendLog);
	}

	@Override
	public void doResult(String eventId, SmsData smsData, SmsResult smsResult) {
		SmsSendLog smsSendLog = smsSendLogService.get(eventId);
		smsSendLog.setCode(smsResult.getCode());
		smsSendLog.setMsg(smsResult.getMsg());
		smsSendLog.setSmsid(smsResult.getSmsid());
		if (smsResult.isSuccess()) {
			smsSendLog.setStatus("1");
		} else {
			smsSendLog.setStatus("0");
		}
		smsSendLog.setResponseDate(new Date());
		smsSendLogService.merge(smsSendLog);
	}

	@Override
	public void doShutdown() {

	}

}
