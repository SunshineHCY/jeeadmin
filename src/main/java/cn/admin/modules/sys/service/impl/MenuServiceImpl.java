package cn.admin.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.admin.core.common.service.impl.TreeCommonServiceImpl;
import cn.admin.modules.sys.entity.Menu;
import cn.admin.modules.sys.service.IMenuService;

@Transactional
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<Menu, String> implements IMenuService {
	
	@Override
	public List<Menu> findTopMenuByUserId(String userId) {
		return listByHql("from Menu m where m.parentId is null and  m.id in (SELECT rm.menuId from RoleMenu rm WHERE rm.roleId in (SELECT ur.roleId from UserRole ur WHERE ur.userId=?)) ORDER BY sort ASC", userId);
	}
	@Override
	public List<Menu> findMenuByUserId(String userId) {
		return listByHql("from Menu m where  m.id in (SELECT rm.menuId from RoleMenu rm WHERE rm.roleId in (SELECT ur.roleId from UserRole ur WHERE ur.userId=?))  ORDER BY sort ASC", userId);
	}

	@Override
	public List<Menu> findMenuByRoleId(String roleId) {
		return listByHql("from Menu m  WHERE m.id in (SELECT rm.menuId from RoleMenu rm WHERE rm.roleId=?)", roleId);
	}

	

}
