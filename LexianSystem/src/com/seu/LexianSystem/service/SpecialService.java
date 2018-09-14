package com.seu.LexianSystem.service;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.po.SpecialPo;
import com.seu.LexianSystem.vo.SpecialCommodityVo;

public interface SpecialService {

	public ResultHelper addSpecial(String specialName);
	public ResultHelper deleteSpecial(String specialId);
	public ResultHelper updateSpecial(SpecialPo specialPo);
	public ResultHelper selectSpecial(SpecialPo specialPo);
	public ResultHelper addSpecialCommodity(SpecialCommodityVo specialCommodityVo);
	public ResultHelper deleteSpecialCommodity(SpecialCommodityVo specialCommodityVo);
	public ResultHelper findSpecialCommodities(SpecialCommodityVo specialCommodityVo);
}
