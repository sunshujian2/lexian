package com.seu.LexianSystem.service;

import com.seu.LexianSystem.vo.CommodityInfoVo;
import com.seu.LexianSystem.vo.CommodityPictureVo;
import com.seu.LexianSystem.vo.CommodityQueryVo;
import com.seu.LexianSystem.vo.CommoditySpecVo;
import com.seu.LexianSystem.vo.Fckeditor;
import com.seu.LexianSystem.util.ResultHelper;

public interface CommodityService {
	public ResultHelper getCommodityList(CommodityQueryVo commodityQueryVo);

	public ResultHelper getCommodityInfo(String commodityNo);

	public String uploadFckPicture(Fckeditor fckeditor);

	public Object updateCommodityInfo(CommodityInfoVo civ);

	public Object updateMainPicture(CommodityPictureVo cpv);

	public Object updateSubPicture(CommodityPictureVo cpv);

	public Object deleteSubPicture(CommodityPictureVo cpv);

	public Object deleteSpec(int specId);

	public Object addSpec(CommoditySpecVo specVo);

	public Object addCommodityInfo(CommodityInfoVo vo);
}
