package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.CommodityPicturePo;
import com.seu.LexianSystem.po.CommodityPo;
import com.seu.LexianSystem.po.CommoditySpecPo;
import com.seu.LexianSystem.po.CommodityCategoryPo;
import com.seu.LexianSystem.vo.CommodityInfoVo;
import com.seu.LexianSystem.vo.CommodityQueryVo;

public interface CommodityDao {
	public List<CommodityPo> getCommodityList(CommodityQueryVo commodityQueryVo);

	public Boolean hasExistedCommodityNo(String commodityNo);

	public void addCommodityInfo(CommodityPo po);
	
	public CommodityPo getCommodity(String commodityNo);

	public List<CommodityPicturePo> getCommodityPictures(String commodityNo);

	public CommodityCategoryPo getCommodityCategories(int categoryId);

	public void updateCommodityInfo(CommodityInfoVo civ);

	public void updateMainPicture(CommodityPicturePo cpp);

	public void addSubPicture(CommodityPicturePo cpp);

	public void deleteSubPicture(int id);

	public List<CommoditySpecPo> getCommoditySpecs(String commodityNo);

	public void deleteSpec(int specId);

	public void addSpec(CommoditySpecPo specPo);
}
