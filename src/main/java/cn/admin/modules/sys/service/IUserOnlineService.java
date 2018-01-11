package cn.admin.modules.sys.service;

import java.util.Date;
import java.util.List;

import cn.admin.core.common.service.ICommonService;
import cn.admin.core.query.data.Page;
import cn.admin.modules.sys.entity.UserOnline;

public interface IUserOnlineService extends ICommonService<UserOnline> {

	/**
	 * 上线
	 *
	 * @param userOnline
	 */
	public void online(UserOnline userOnline);

	/**
	 * 下线
	 *
	 * @param sid
	 */
	public void offline(String sid);

	/**
	 * 批量下线
	 *
	 * @param needOfflineIdList
	 */
	public void batchOffline(List<?> needOfflineIdList);

	/**
	 * 无效的UserOnline
	 *
	 * @return
	 */
	public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, int page, int rows);

}
