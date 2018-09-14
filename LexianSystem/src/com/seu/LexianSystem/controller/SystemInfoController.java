package com.seu.LexianSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.service.SystemInfoServiceImpl;

@Controller
@RequestMapping("/systemInfo")
public class SystemInfoController extends BaseController{

	private SystemInfoServiceImpl systemInfoServiceImpl;
	
	public void setSystemInfoServiceImpl(SystemInfoServiceImpl systemInfoServiceImpl) {
		this.systemInfoServiceImpl = systemInfoServiceImpl;
	}
	
	@RequestMapping("/getSystemInfo.do")
	public Object getSystemInfo(@RequestParam("keys") String keys)
	{
		return systemInfoServiceImpl.getSystemInfo(keys);
	}
}
