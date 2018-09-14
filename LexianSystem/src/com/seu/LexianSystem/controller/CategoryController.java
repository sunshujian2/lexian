package com.seu.LexianSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seu.LexianSystem.constant.CategoryConstant;
import com.seu.LexianSystem.service.CategoryService;
import com.seu.LexianSystem.vo.CategoryVo;
import com.seu.LexianSystem.controller.BaseController;
import com.seu.LexianSystem.util.ParamValidateUtil;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.util.ParamValidateUtil.ParamNotValidException;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	// 获取商品逐级分类信息
	@RequestMapping( "/findCategories.do")
	@ResponseBody
	public Object findCategories(CategoryVo categoryVo) {
		return categoryService.findCategories(categoryVo);
	}
	
	// 获取某个类别下的所有商品信息
	@RequestMapping("/findCategoryCommodities.do")
	@ResponseBody
	public Object findCategoryCommodities(int categoryId){
		return categoryService.findCategoryCommodities(categoryId).getRows();
	}
	
	// 修改类别名称
	@RequestMapping("/updateCategory.do")
	@ResponseBody
	public Object updateCategory(CategoryVo categoryVo){
		return categoryService.updateCategory(categoryVo);
	}
	
	// 添加新类别
	@RequestMapping("/addCategory.do")
	@ResponseBody
	public Object addCategory(CategoryVo categoryPo) {
		try {
			ParamValidateUtil.validateEmpty(categoryPo.getCategoryName(), CategoryConstant.categoryname_null);
			ParamValidateUtil.validateMaxLength(categoryPo.getCategoryName(), 40, CategoryConstant.categoryname_max_length);
		} catch (ParamNotValidException e) {
			return new ResultHelper(e.getCode(), e.getMessage());
		}
		return categoryService.addCategory(categoryPo);
	}

	// 删除商品分类
	@RequestMapping("/deleteCategory.do")
	@ResponseBody
	public ResultHelper deleteCatetory(int categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
}
