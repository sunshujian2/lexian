package com.seu.LexianSystem.service;

import com.seu.LexianSystem.vo.CategoryVo;
import com.seu.LexianSystem.util.ResultHelper;

public interface CategoryService {
	public ResultHelper findCategories(CategoryVo categoryVo);
	
	public ResultHelper findCategoryCommodities(int categoryId);
	
	public ResultHelper updateCategory(CategoryVo categoryVo);
	
	public ResultHelper addCategory(CategoryVo categoryVo);
	
	public ResultHelper deleteCategory(int categoryId);
}
