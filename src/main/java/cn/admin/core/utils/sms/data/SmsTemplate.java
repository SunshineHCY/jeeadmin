package cn.admin.core.utils.sms.data;

import java.io.Serializable;

/**
 * 
 
 * 
 * @title: Sms.java
 * @package cn.admin.core.utils.sms.data
 * @description: 发送的信息
* @author: lichao
 * @date: 2017年6月7日 下午10:17:52
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
@SuppressWarnings("serial")
public class SmsTemplate implements Serializable {
	private String templateId;
	private String templateContent;

	public SmsTemplate() {

	}

	public SmsTemplate(String templateId, String templateContent) {
		this.templateId = templateId;
		this.templateContent = templateContent;
	}

	public static SmsTemplate newTemplateById(String templateId) {
		SmsTemplate smsTemplate = new SmsTemplate();
		smsTemplate.setTemplateId(templateId);
		return smsTemplate;
	}

	public static SmsTemplate newTemplate(String templateId, String templateContent) {
		SmsTemplate smsTemplate = new SmsTemplate();
		smsTemplate.setTemplateId(templateId);
		smsTemplate.setTemplateContent(templateContent);
		return smsTemplate;
	}

	public static SmsTemplate newTemplateByContent(String templateContent) {
		SmsTemplate smsTemplate = new SmsTemplate();
		smsTemplate.setTemplateContent(templateContent);
		return smsTemplate;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

}
