package com.seu.LexianSystem.service;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.vo.TopQueryVo;

public interface StatisticsService {
   public ResultHelper  findSaleTop(TopQueryVo topQueryVo);
   
   public ResultHelper findBrowseTop(TopQueryVo browseTopVo);
}
