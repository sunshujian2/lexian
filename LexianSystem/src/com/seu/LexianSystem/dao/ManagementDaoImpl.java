package com.seu.LexianSystem.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.po.PrivilegePo;
import com.seu.LexianSystem.po.RoleMenuPo;
import com.seu.LexianSystem.po.RolePo;
import com.seu.LexianSystem.po.RolePrivilegePo;
import com.seu.LexianSystem.vo.ManagerVo;
import com.seu.LexianSystem.vo.MenuVo;
import com.seu.LexianSystem.vo.PrivilegeVo;
import com.seu.LexianSystem.vo.RoleVo;
import com.seu.LexianSystem.dao.ManagementDao;
import com.seu.LexianSystem.po.ManagerPo;
import com.seu.LexianSystem.po.ManagerRolePo;
import com.seu.LexianSystem.po.MenuPo;

@Repository
public class ManagementDaoImpl extends BaseDao implements ManagementDao {
	@Override
	public List<PrivilegePo> findPrivileges(PrivilegeVo privilegeVo) {
		return selectList("findPrivileges", privilegeVo);
	}

	@Override
	public List<MenuPo> findMenus(MenuVo menuVo) {
		return selectList("findMenus", menuVo);
	}

	@Override
	public void updateMenu(MenuPo menuPo) {
		update("updateMenu", menuPo);
	}

	@Override
	public List<RolePo> findRoles(RoleVo roleVo) {
		return selectList("findRoles", roleVo);
	}

	@Override
	public RolePo findRoleByName(String name) {
		return selectOne("findRoleByName", name);
	}

	@Override
	public void updateRole(RolePo rolePo) {
		update("updateRole", rolePo);
	}

	@Override
	public void addRole(RolePo rolepo) {
		insert("addRole", rolepo);
	}

	@Override
	public void deletePrivilegeInRole(int roleId) {
		delete("deletePrivilegeInRole", roleId);
	}

	@Override
	public void addPrivilegeToRole(RolePrivilegePo rp) {
		insert("addPrivilegeToRole", rp);
	}

	@Override
	public List<RoleMenuPo> findRoleMenus(int roleId) {
		return selectList("findRoleMenus", roleId);
	}

	@Override
	public void deleteRoleMenus(int roleId) {
		delete("deleteRoleMenus", roleId);
	}

	@Override
	public void addRolesMenus(HashMap<String, Object> map) {
		insert("addRoleMenus",map);
	}

	@Override
	public List<ManagerPo> findManagers(ManagerVo managerVo) {
		return selectList("findManagers", managerVo);
	}

	@Override
	public void addManager(ManagerPo po) {
		insert("addManager", po);
	}

	@Override
	public void addManagerRole(ManagerRolePo mr) {
		insert("addManagerRole", mr);
	}

	@Override
	public void updateManager(ManagerPo po) {
		update("updateManager", po);
		
	}

	@Override
	public void deleteManagerRoles(int managerId) {
		delete("deleteManagerRoles", managerId);
	}

	@Override
	public List<RolePo> findManagerRoles(int managerId) {
		return selectList("findManagerRoles", managerId);
	}

	@Override
	public void deleteManager(int managerId) {
		delete("deleteManager", managerId);
	}

	@Override
	public void updateManagerState(ManagerPo po) {
		update("updateManagerState", po);
	}

	@Override
	public void resetPassword(ManagerPo po) {
		update("resetPassword", po);
	}
}
