package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.BrowseTop;
import com.seu.LexianSystem.po.SaleTop;
import com.seu.LexianSystem.vo.TopQueryVo;

public interface StatisticsDao {
   public List<SaleTop>  findSaleTop(TopQueryVo topQueryVo);
   
   public List<BrowseTop> findBrowseTop(TopQueryVo browseTopVo);
}
