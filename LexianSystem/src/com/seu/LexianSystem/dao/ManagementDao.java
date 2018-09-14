package com.seu.LexianSystem.dao;

import java.util.HashMap;
import java.util.List;

import com.seu.LexianSystem.po.PrivilegePo;
import com.seu.LexianSystem.po.RoleMenuPo;
import com.seu.LexianSystem.po.RolePo;
import com.seu.LexianSystem.po.RolePrivilegePo;
import com.seu.LexianSystem.vo.ManagerVo;
import com.seu.LexianSystem.vo.MenuVo;
import com.seu.LexianSystem.vo.PrivilegeVo;
import com.seu.LexianSystem.vo.RoleVo;
import com.seu.LexianSystem.po.ManagerPo;
import com.seu.LexianSystem.po.ManagerRolePo;
import com.seu.LexianSystem.po.MenuPo;

public interface ManagementDao {
	public List<PrivilegePo> findPrivileges(PrivilegeVo privilegeVo);
	
	public List<MenuPo> findMenus(MenuVo menuVo);
	
	public void updateMenu(MenuPo menuPo);
	
	public List<RolePo> findRoles(RoleVo roleVo);
	
	public RolePo findRoleByName(String name);

	public void updateRole(RolePo rolepo);

	public void addRole(RolePo rolepo);

	public void deletePrivilegeInRole(int roleId);

	public void addPrivilegeToRole(RolePrivilegePo rp);

	public List<RoleMenuPo> findRoleMenus(int roleId);

	public void deleteRoleMenus(int roleId);

	public void addRolesMenus(HashMap<String, Object> map);

	public List<ManagerPo> findManagers(ManagerVo managerVo);

	public void addManager(ManagerPo po);

	public void addManagerRole(ManagerRolePo mr);

	public void updateManager(ManagerPo po);

	public void deleteManagerRoles(int managerId);

	public List<RolePo> findManagerRoles(int managerId);

	public void deleteManager(int managerId);

	public void updateManagerState(ManagerPo po);

	public void resetPassword(ManagerPo po);
}
