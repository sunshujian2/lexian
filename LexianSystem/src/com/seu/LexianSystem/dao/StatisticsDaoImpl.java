package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.StatisticsDao;
import com.seu.LexianSystem.po.BrowseTop;
import com.seu.LexianSystem.po.SaleTop;
import com.seu.LexianSystem.vo.TopQueryVo;

@Repository
public class StatisticsDaoImpl extends BaseDao implements StatisticsDao {
	@Override
	public List<SaleTop> findSaleTop(TopQueryVo topQueryVo) {
		return selectList("findSaleTop",topQueryVo);
	}
	
	@Override
	public List<BrowseTop> findBrowseTop(TopQueryVo browseTopVo) {
		return selectList("findBrowseTop",browseTopVo);
	}
}
