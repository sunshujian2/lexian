package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.CategoryPo;
import com.seu.LexianSystem.vo.CategoryVo;
import com.seu.LexianSystem.po.CommodityPo;

public interface CategoryDao {
	public List<CategoryPo> findCategories(CategoryVo categoryVo);
	
	public List<CommodityPo> findCategoryCommodities(int categoryId);
	
	public CategoryPo findCategoryByName(String categoryName);
	
	public void updateCategory(CategoryPo categoryPo);
	
	public void addCategory(CategoryPo categoryPo);

	public void deleteCategory(int categoryId);
	
	public CategoryPo findCategoryById(int categoryId);

	public boolean existsCommodities(int categoryId);

	public boolean existsSubcategories(int categoryId);
}
