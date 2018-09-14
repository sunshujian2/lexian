package com.seu.LexianSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seu.LexianSystem.service.BaseService;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.constant.StatisticsConstant;
import com.seu.LexianSystem.dao.StatisticsDao;
import com.seu.LexianSystem.service.StatisticsService;
import com.seu.LexianSystem.vo.TopQueryVo;

@Service
@Transactional
public class StatisticsServiceImpl extends BaseService implements StatisticsService {
	private StatisticsDao statisticsDao;

	@Autowired
	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	@Override
	public ResultHelper findSaleTop(TopQueryVo topQueryVo) {
		return new ResultHelper(Constant.success_code, StatisticsConstant.success, 
				statisticsDao.findSaleTop(topQueryVo),
				topQueryVo.getTotal());
	}

	@Override
	public ResultHelper findBrowseTop(TopQueryVo browseTopVo) {
		return new ResultHelper(Constant.success_code, StatisticsConstant.success, 
				statisticsDao.findBrowseTop(browseTopVo),
				browseTopVo.getTotal());
	}
}
