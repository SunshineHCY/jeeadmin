package cn.admin.core.disruptor.sms;

import com.lmax.disruptor.EventFactory;

/**
 * 
 
 * 
 * @title: LongEventFactory.java
 * @package cn.admin.core.disruptor.sms
 * @description: 定义事件工厂
* @author: lichao
 * @date: 2017年6月7日 下午11:18:32
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
public class SmsEventFactory implements EventFactory<SmsEvent> {
	public SmsEvent newInstance() {
		return new SmsEvent();
	}
}