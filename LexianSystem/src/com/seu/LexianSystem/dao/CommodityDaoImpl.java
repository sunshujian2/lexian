package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.CommodityDao;
import com.seu.LexianSystem.po.CommodityCategoryPo;
import com.seu.LexianSystem.po.CommodityPicturePo;
import com.seu.LexianSystem.po.CommodityPo;
import com.seu.LexianSystem.po.CommoditySpecPo;
import com.seu.LexianSystem.vo.CommodityInfoVo;
import com.seu.LexianSystem.vo.CommodityQueryVo;
import com.seu.LexianSystem.dao.BaseDao;

@Repository
public class CommodityDaoImpl extends BaseDao implements CommodityDao {

	@Override
	public List<CommodityPo> getCommodityList(CommodityQueryVo commodityQueryVo) {
		return selectList("getCommodityList", commodityQueryVo);
	}

	@Override
	public Boolean hasExistedCommodityNo(String commodityNo) {
		Boolean result = (Boolean)selectOne("hasExistedCommodityNo", commodityNo);
		return result;
	}

	@Override
	public void addCommodityInfo(CommodityPo po) {
		insert("addCommodity", po);
	}

	@Override
	public CommodityPo getCommodity(String commodityNo) {
		return selectOne("getCommodityInfo", commodityNo);
	}

	@Override
	public List<CommodityPicturePo> getCommodityPictures(String commodityNo) {
		return selectList("getCommodityPictures", commodityNo);
	}

	@Override
	public CommodityCategoryPo getCommodityCategories(int categoryId) {
		return selectOne("getCommodityCategories", categoryId);
	}

	@Override
	public void updateCommodityInfo(CommodityInfoVo civ) {
		update("updateCommodityInfo", civ);
	}

	@Override
	public void updateMainPicture(CommodityPicturePo cpp) {
		update("updateMainPicture", cpp);
	}

	@Override
	public void addSubPicture(CommodityPicturePo cpp) {
		insert("addSubPicture", cpp);
		int maxId = (int)selectOne("getMaxSubPictureId");
		cpp.setId(maxId);
	}

	@Override
	public void deleteSubPicture(int id) {
		delete("deleteSubPicture", id);
	}

	@Override
	public List<CommoditySpecPo> getCommoditySpecs(String commodityNo) {
		return selectList("getCommoditySpecs", commodityNo);
	}

	@Override
	public void deleteSpec(int specId) {
		delete("deleteSpec", specId);
	}

	@Override
	public void addSpec(CommoditySpecPo specPo) {
		insert("addSpec", specPo);
		int maxId = (int)selectOne("getMaxSpecId");
		specPo.setSpecid(maxId);
	}
}
