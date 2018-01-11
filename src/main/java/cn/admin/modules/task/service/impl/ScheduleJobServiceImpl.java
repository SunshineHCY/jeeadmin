package cn.admin.modules.task.service.impl;

import java.io.Serializable;
import java.util.List;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.core.quartz.QuartzManager;
import cn.admin.modules.task.entity.ScheduleJob;
import cn.admin.modules.task.service.IScheduleJobService;
import cn.admin.modules.task.utils.ScheduleJobUtils;

/**
 * @Title: 任务
 * @Description: 任务
 * @author jeeadmin
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
@Transactional
@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends CommonServiceImpl<ScheduleJob> implements IScheduleJobService {
	private QuartzManager quartzManager;

	@Override
	public void updateCron(String jobId) throws SchedulerException {
		ScheduleJob scheduleJobEntity = get(jobId);
		if (scheduleJobEntity == null) {
			return;
		}
		if (cn.admin.core.quartz.data.ScheduleJob.STATUS_RUNNING.equals(scheduleJobEntity.getJobStatus())) {
			quartzManager.updateJobCron(ScheduleJobUtils.entityToData(scheduleJobEntity));
		}
		update(scheduleJobEntity);
	}

	@Override
	public void changeStatus(String jobId, String cmd) throws SchedulerException {
		ScheduleJob scheduleJobEntity = get(jobId);
		if (scheduleJobEntity == null) {
			return;
		}
		if ("stop".equals(cmd)) {
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(scheduleJobEntity));
			scheduleJobEntity.setJobStatus(cn.admin.core.quartz.data.ScheduleJob.STATUS_NOT_RUNNING);
		} else if ("start".equals(cmd)) {
			scheduleJobEntity.setJobStatus(cn.admin.core.quartz.data.ScheduleJob.STATUS_RUNNING);
			quartzManager.addJob(ScheduleJobUtils.entityToData(scheduleJobEntity));
		}
		update(scheduleJobEntity);
	}

	@Override
	public void delete(ScheduleJob entity) {
		try {
			quartzManager.deleteJob(ScheduleJobUtils.entityToData(entity));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		super.delete(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		delete(get(id));
	}

	@Override
	public void initSchedule() throws SchedulerException {
		// 这里获取任务信息数据
		quartzManager = new QuartzManager();
		List<ScheduleJob> jobList = list();
		for (ScheduleJob scheduleJobEntity : jobList) {
			quartzManager.addJob(ScheduleJobUtils.entityToData(scheduleJobEntity));
		}
	}

}
