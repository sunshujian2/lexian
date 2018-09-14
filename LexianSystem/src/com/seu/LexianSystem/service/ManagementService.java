package com.seu.LexianSystem.service;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.vo.PrivilegeVo;
import com.seu.LexianSystem.vo.ManagerVo;
import com.seu.LexianSystem.vo.MenuVo;
import com.seu.LexianSystem.vo.RoleVo;

public interface ManagementService {
	public ResultHelper findPrivileges(PrivilegeVo privilegeVo);
	
	public ResultHelper getMenus(MenuVo menuVo);
	
	public ResultHelper updateMenu(MenuVo menuVo);

	public ResultHelper findRoles(RoleVo roleVo);

	public ResultHelper updateRole(RoleVo rolevo);

	public ResultHelper addRole(RoleVo rolevo);

	public ResultHelper findRolePrivileges(PrivilegeVo privilegeVo);

	public ResultHelper changeRolePrivileges(int roleId, String privilegeIds);
	
	public ResultHelper addPrivilegeToRole(int roleId, String privilegeIds);

	public ResultHelper findRoleMenus(int roleId);

	public ResultHelper changeRoleMenus(int roleId, String menuIds);

	public ResultHelper findManagers(ManagerVo managerVo);

	public ResultHelper addManager(ManagerVo managerVo);

	public ResultHelper updateManager(ManagerVo managerVo);

	public ResultHelper updateManagerRoles(int managerId, String roleIds);

	public ResultHelper findManagerRoles(int managerId);

	public ResultHelper deleteManagement(int managerId);

	public ResultHelper updateStateToLogoff(int managerId);

	public ResultHelper updateStateToActivate(int managerId);

	public ResultHelper resetPassword(int managerId);

}
