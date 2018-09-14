package com.seu.LexianSystem.service;

import java.util.List;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.po.AreaPo;
import com.seu.LexianSystem.po.StorePo;
import com.seu.LexianSystem.vo.AreaVo;
import com.seu.LexianSystem.vo.StoreCommodityQueryVo;
import com.seu.LexianSystem.vo.StoreCommodityVo;
import com.seu.LexianSystem.vo.StoreVo;

public interface StoreService {
	public ResultHelper addStore(StoreVo storeVo);

	public ResultHelper addchangeStore(StoreVo storeVo);

	public ResultHelper updateStore(StoreVo storeVo);

	public ResultHelper findStore(StoreVo StoreVo);

	public ResultHelper deleteStore(String id);

	public List<StorePo> findlocalStore();

	public List<AreaPo> findArea(AreaVo areaVo);

	public Object getCommodities(StoreCommodityQueryVo queryVo);

	public Object changeCommodityPrice(StoreCommodityVo vo);

	public Object updateShelfStatus(StoreCommodityVo vo);

	public Object updateCommodityStock(StoreCommodityVo vo);

	public Object registerCommodities(String storeNo, String[] commodityNos);
}
