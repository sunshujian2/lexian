package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.AreaPo;
import com.seu.LexianSystem.po.StoreCommodityPo;
import com.seu.LexianSystem.po.StorePo;
import com.seu.LexianSystem.vo.AreaVo;
import com.seu.LexianSystem.vo.StoreCommodityQueryVo;

public interface StoreDao {
	public int addStore(StorePo storePo);

	public List<StorePo> findStore(StorePo storePo);

	public int deleteStore(String... id);

	public int updateStore(StorePo storePo);

	public int addchangeStore(StorePo storepo);

	public List<StorePo> findlocalStore();

	public List<AreaPo> findArea(AreaVo areaVo);
	
	public List<StoreCommodityPo> getCommodities(StoreCommodityQueryVo queryVo);

	public void changeCommodityPrice(StoreCommodityPo po);

	public void updateShelfStatus(StoreCommodityPo po);

	public void updateCommodityStock(StoreCommodityPo po);

	public List<String> getAllCommodityNos(String storeNo);

	public void registerCommodity(StoreCommodityPo po);
}
