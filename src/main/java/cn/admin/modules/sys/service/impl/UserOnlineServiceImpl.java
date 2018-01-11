package cn.admin.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import cn.admin.core.common.service.impl.CommonServiceImpl;
import cn.admin.core.query.data.Page;
import cn.admin.core.query.data.PageImpl;
import cn.admin.core.query.data.PageRequest;
import cn.admin.core.query.data.Pageable;
import cn.admin.core.utils.IpUtils;
import cn.admin.core.utils.ServletUtils;
import cn.admin.core.utils.StringUtils;
import cn.admin.modules.sys.entity.UserOnline;
import cn.admin.modules.sys.security.shiro.realm.UserRealm.Principal;
import cn.admin.modules.sys.service.IUserOnlineService;
import cn.admin.modules.sys.utils.UserUtils;

import java.util.Date;
import java.util.List;

@Service("userOnlineService")
public class UserOnlineServiceImpl extends CommonServiceImpl<UserOnline> implements IUserOnlineService {

	/**
	 * 上线
	 *
	 * @param userOnline
	 */
	public void online(UserOnline userOnline) {
		if (StringUtils.isEmpty(userOnline.getHost())) {
			String hostIp = IpUtils.getIpAddr(ServletUtils.getRequest());
			userOnline.setHost(hostIp);
		}
		Principal principal = UserUtils.getPrincipal(); // 如果已经登录，则跳转到管理首页
		userOnline.setUsername(principal.getUsername());
		userOnline.setUserId(principal.getId());
		UserOnline oldOnline = get(userOnline.getId());
		if (oldOnline != null) {
			merge(userOnline);
		} else {
			save(userOnline);
		}
	}

	/**
	 * 下线
	 *
	 * @param sid
	 */
	public void offline(String sid) {
		UserOnline userOnline = get(sid);
		if (userOnline != null) {
			delete(userOnline);
		}
	}

	/**
	 * 批量下线
	 *
	 * @param needOfflineIdList
	 */
	public void batchOffline(List<?> needOfflineIdList) {
		batchDeleteById(needOfflineIdList);
	}

	/**
	 * 无效的UserOnline
	 *
	 * @return
	 */
	public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, int page, int rows) {
		String hql = "from UserOnline o where o.lastAccessTime < ? order by o.lastAccessTime asc";
		Long total = countByHql("select count(*)  " + hql, expiredDate);
		Pageable pageable = new PageRequest(page, rows);
		List<UserOnline> content = listByHql(hql, expiredDate);
		return new PageImpl<UserOnline>(content, pageable, total);
	}

}
