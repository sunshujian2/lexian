package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.SpecialCommodityPo;
import com.seu.LexianSystem.po.SpecialPo;
import com.seu.LexianSystem.vo.SpecialCommodityVo;

public interface SpecialDao {

	public void addSpecial(String specialName);
	public void deleteSpecial(String specialId);
	public void updateSpecial(SpecialPo specialPo);
	public List<SpecialPo> selectSpecial(SpecialPo specialPo);
	public List<SpecialCommodityPo> findSpecialCommodity(SpecialCommodityVo specialCommodityVo);
	public void addSpecialCommodity(SpecialCommodityVo specialCommodityVo);
	public void deleteSpecialCommodity(SpecialCommodityVo specialCommodityVo);
}
