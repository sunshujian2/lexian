package com.seu.LexianSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ParamValidateUtil;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.util.ParamValidateUtil.ParamNotValidException;
import com.seu.LexianSystem.constant.StoreConstant;
import com.seu.LexianSystem.service.StoreService;
import com.seu.LexianSystem.vo.AreaVo;
import com.seu.LexianSystem.vo.StoreCommodityQueryVo;
import com.seu.LexianSystem.vo.StoreCommodityVo;
import com.seu.LexianSystem.vo.StoreVo;

@Controller
@RequestMapping("/store")
public class StoreController extends BaseController {
	private StoreService storeService;

	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	// 分页查找门店信息
	@RequestMapping("/findStores.do")
	@ResponseBody
	public Object findStores(StoreVo StoreVo) {
		return storeService.findStore(StoreVo).getRows();
	}
	
	// 更新门店状�??
	@RequestMapping("/updateStoreStatus.do")
	@ResponseBody
	public ResultHelper updateStoreStatus(StoreVo storeVo) {
		try {
			ParamValidateUtil.validateEmpty(storeVo.getId(), StoreConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(storeVo.getStatus(), StoreConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return storeService.updateStore(storeVo);
	}
	
	// 查找省�?�市、区信息
	@RequestMapping("/findArea.do")
	@ResponseBody
	public Object findArea(AreaVo areaVo) {
		return storeService.findArea(areaVo);
	}

	// 添加门店
	@RequestMapping("/addStore.do")
	@ResponseBody
	public Object addStore(StoreVo storeVo) {
		try {
			ParamValidateUtil.validateNull(storeVo, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateNull(storeVo.getCitysId(), StoreConstant.invalid_arguments);
			ParamValidateUtil.validateMaxLength(storeVo.getStoreAddress(), 100, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateMaxLength(storeVo.getIntroduce(), 100, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMaxlatitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMaxlongitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMinlatitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMinlongitude(), null, 20, StoreConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			logger.warn(e.getMessage());
			return new ResultHelper(Constant.failed_code, e.getMessage());

		}
		return storeService.addStore(storeVo);

	}

	// 修改门店信息
	@RequestMapping("/updateStore.do")
	@ResponseBody
	public Object updateStore(@ModelAttribute StoreVo storeVo) {
		try {
			ParamValidateUtil.validateNull(storeVo, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateNull(storeVo.getCitysId(), StoreConstant.invalid_arguments);
			ParamValidateUtil.validateMaxLength(storeVo.getStoreAddress(), 100, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateMaxLength(storeVo.getIntroduce(), 100, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMaxlatitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMaxlongitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMinlatitude(), null, 20, StoreConstant.invalid_arguments);
			ParamValidateUtil.validateDoubleLength(storeVo.getMinlongitude(), null, 20, StoreConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			logger.warn(e.getMessage());
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return storeService.updateStore(storeVo);
	}

	// 获取门店下商品信息列�?
	@RequestMapping("/getCommodities.do")
	@ResponseBody
	public Object getCommodities(StoreCommodityQueryVo queryVo){
		return storeService.getCommodities(queryVo);
	}
	
	// 修改门店商品价格
	@RequestMapping("/changeCommodityPrice.do")
	@ResponseBody
	public Object changeCommodityPrice(StoreCommodityVo vo){
		return storeService.changeCommodityPrice(vo);
	}
	
	// 更新门店商品上下架信�?
	@RequestMapping("/updateShelfStatus.do")
	@ResponseBody
	public Object updateShelfStatus(StoreCommodityVo vo){
		return storeService.updateShelfStatus(vo);
	}
	
	// 修改门店商品困村
	@RequestMapping("/updateCommodityStock.do")
	@ResponseBody
	public Object updateCommodityStock(StoreCommodityVo vo){
		return storeService.updateCommodityStock(vo);
	}
	
	// 项门店中注册商品
	@RequestMapping("/registerCommodities.do")
	@ResponseBody
	public Object registerCommodities(String storeNo, String commodityNoArrayStr){
		String[] commodityNos = commodityNoArrayStr.split(",");
		return storeService.registerCommodities(storeNo, commodityNos);
	}

	// 删除门店
	@RequestMapping("/deleteStore.do")
	@ResponseBody
	public Object deleteStore(@RequestParam String storeId) {
		try {
			ParamValidateUtil.validationStringIsNumber(StoreConstant.split_string, storeId,
					StoreConstant.invalid_arguments);
			ParamValidateUtil.validateEmpty(storeId, StoreConstant.invalid_arguments);
		} catch (ParamNotValidException e) {
			return new ResultHelper(Constant.failed_code, e.getMessage());
		}
		return storeService.deleteStore(storeId);
	}

	@RequestMapping("/addchangeStore.do")
	@ResponseBody
	public Object deleteStore(@ModelAttribute StoreVo storeVo) {
		return storeService.addchangeStore(storeVo);
	}

	@RequestMapping("/findlocalStore.do")
	@ResponseBody
	public Object findlocalStore() {
		return storeService.findlocalStore();
	}
}
