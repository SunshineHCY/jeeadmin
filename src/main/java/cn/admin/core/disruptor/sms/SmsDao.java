package cn.admin.core.disruptor.sms;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.utils.sms.data.SmsResult;

/**
 * 
 
 * 
 * @title: SmsDao.java
 * @package cn.admin.core.disruptor.sms
 * @description: 短信dao
* @author: lichao
 * @date: 2017年6月8日 上午8:42:47
 * @version V1.0
 \* @copyright: 2017 拍财富
 * 
 */
public interface SmsDao {
	/**
	 * 
	 * @title: doStart
	 * @description:初始化回调
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doStart();

	/**
	 * 
	 * @title: doShutdown
	 * @description:关闭
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doShutdown();

	/**
	 * 
	 * @title: doShutdown
	 * @description:发送短信
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doSend(String eventId, SmsData smsData);

	/**
	 * 
	 * @title: doShutdown
	 * @description:响应
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doResult(String eventId, SmsData smsData, SmsResult smsResult);
}