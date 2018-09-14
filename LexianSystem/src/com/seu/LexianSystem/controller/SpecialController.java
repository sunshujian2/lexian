package com.seu.LexianSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.util.ParamValidateUtil;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.util.ParamValidateUtil.ParamNotValidException;
import com.seu.LexianSystem.constant.SpecialConstant;
import com.seu.LexianSystem.po.SpecialPo;
import com.seu.LexianSystem.service.SpecialService;
import com.seu.LexianSystem.vo.SpecialCommodityVo;

@Controller
@RequestMapping("/special")
public class SpecialController extends BaseController{
	private SpecialService specialService;
	
	@Autowired
	public void setSpecialService(SpecialService specialService) {
		this.specialService = specialService;
	}
	
	// 查询特定活动列表
	@RequestMapping("/findSpecials.do")
	@ResponseBody
	public Object findSpecials(SpecialPo specialPo){
		return specialService.selectSpecial(specialPo);
	}
	
	// 添加活动
	@RequestMapping("/addSpecial.do")
	@ResponseBody
	public Object addSpecial(@RequestParam(value="specialName",defaultValue="")String specialName){
		try {
			ParamValidateUtil.validateEmpty(specialName, SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.addSpecial(specialName);
	}
	
	// 删除活动
	@RequestMapping("/deleteSpecial.do")
	@ResponseBody
	public Object deleteSpecial(@RequestParam(value="specialId",defaultValue="")String specialId){
		try {
			ParamValidateUtil.validateEmpty(specialId, SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.deleteSpecial(specialId);
	}
	
	// 更新活动
	@RequestMapping("/updateSpecial.do")
	@ResponseBody
	public Object updateSpecial(SpecialPo specialPo){
		try {
			ParamValidateUtil.validateEmpty(specialPo.getSpecialId(), SpecialConstant.paramNone);
			ParamValidateUtil.validateEmpty(specialPo.getSpecialName(), SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.updateSpecial(specialPo);
	}
	
	// 向活动中添加商品
	@RequestMapping("/addSpecialCommodity.do")
	@ResponseBody
	public Object addSpecialCommodity(SpecialCommodityVo specialCommodityVo){
		try {
			ParamValidateUtil.validateEmpty(specialCommodityVo.getCommodityNo(), SpecialConstant.paramNone);
			ParamValidateUtil.validateEmpty(specialCommodityVo.getSpecialId(), SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.addSpecialCommodity(specialCommodityVo);
	}
	
	// 从活动中删除商品
	@RequestMapping("/deleteSpecialCommodity.do")
	@ResponseBody
	public Object deleteSpecialCommodity(@ModelAttribute SpecialCommodityVo specialCommodityVo){
		try {
			ParamValidateUtil.validateEmpty(specialCommodityVo.getSpecialCommodityId(), SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.deleteSpecialCommodity(specialCommodityVo);
	}
	
	// 返回活动中的商品列表
	@RequestMapping("/findSpecialCommodities.do")
	@ResponseBody	
	public Object findSpecialCommodities(@ModelAttribute SpecialCommodityVo specialCommodityVo){
		try {
			ParamValidateUtil.validateEmpty(specialCommodityVo.getSpecialId(), SpecialConstant.paramNone);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(),e.getMessage());
		}
		return specialService.findSpecialCommodities(specialCommodityVo);
	}
	
	
}
