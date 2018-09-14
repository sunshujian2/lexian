package com.seu.LexianSystem.vo;

import org.springframework.web.multipart.MultipartFile;

import com.seu.LexianSystem.util.PageHelper;
import com.seu.LexianSystem.po.MenuPo;

public class MenuVo extends PageHelper<MenuVo> {
	private int menuId;
	private String menuName;
	private String url;
	private long parentId;
	private String backUrl;
	
	// 菜单背景图片
	private MultipartFile file;
	
	public MenuVo(){
	}
	
	public MenuVo(MenuPo po){
		this.menuId = po.getId();
		this.menuName = po.getName();
		this.url = po.getUrl();
		this.parentId = po.getParentId();
		this.backUrl = po.getBackUrl();
	}
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
