package cn.admin.core.quartz.factory;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.admin.core.quartz.data.ScheduleJob;
import cn.admin.core.quartz.utils.TaskUtils;

/**
 * 
 * <pre>
 * Description  计划任务执行处 无状态
 * Copyright:	Copyright (c) 2017  
 * Company:		拍财富
 * Author:		lichao
 * Version:		1.0  
 * Create at:	2017年12月27日 下午1:58:29  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------
 * 
 * </pre>
 */
public class QuartzJobFactory implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		TaskUtils.invokMethod(scheduleJob);
	}
}