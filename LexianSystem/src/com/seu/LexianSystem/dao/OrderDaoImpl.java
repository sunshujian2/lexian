package com.seu.LexianSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seu.LexianSystem.dao.BaseDao;
import com.seu.LexianSystem.dao.OrderDao;
import com.seu.LexianSystem.po.OrderPo;
import com.seu.LexianSystem.vo.OrderItemVo;
import com.seu.LexianSystem.vo.OrderQueryVo;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao{
	@Override
	public List<OrderPo> findOrders(OrderQueryVo vo) {
		return selectList("findOrders", vo);
	}

	@Override
	public OrderPo findOrder(String orderNo) {
		return selectOne("findOrder", orderNo);
	}

	@Override
	public List<OrderItemVo> findOrderItems(int orderId) {
		return selectList("findOrderItems", orderId);
	}

	@Override
	public void updateStates(OrderPo po) {
		update("updateStates", po);
	}
	
}
