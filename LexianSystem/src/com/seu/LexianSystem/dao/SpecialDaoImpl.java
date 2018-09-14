package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.SpecialDao;
import com.seu.LexianSystem.po.SpecialCommodityPo;
import com.seu.LexianSystem.po.SpecialPo;
import com.seu.LexianSystem.vo.SpecialCommodityVo;

@Repository
public class SpecialDaoImpl extends BaseDao implements SpecialDao {

	@Override
	public void addSpecial(String specialName) {
		insert("addSpecial", specialName);
	}

	@Override
	public void deleteSpecial(String specialId) {
		delete("deleteSpecial", specialId);
	}

	@Override
	public void updateSpecial(SpecialPo specialPo) {
		update("updateSpecial", specialPo);
	}

	@Override
	public List<SpecialPo> selectSpecial(SpecialPo specialPo) {
		return selectList("selectSpecial", specialPo);
	}

	@Override
	public List<SpecialCommodityPo> findSpecialCommodity(SpecialCommodityVo specialCommodityVo) {
		return selectList("findSpecialCommodity", specialCommodityVo);
	}

	@Override
	public void addSpecialCommodity(SpecialCommodityVo specialCommodityVo) {
		insert("addSpecialCommodity", specialCommodityVo);
	}

	@Override
	public void deleteSpecialCommodity(SpecialCommodityVo specialCommodityVo) {
		delete("deleteSpecialCommodity", specialCommodityVo);
	}

}
