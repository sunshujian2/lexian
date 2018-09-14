package com.seu.LexianSystem.dao;

import java.util.List;

import com.seu.LexianSystem.po.OrderPo;
import com.seu.LexianSystem.vo.OrderItemVo;
import com.seu.LexianSystem.vo.OrderQueryVo;

public interface OrderDao {
	List<OrderPo> findOrders(OrderQueryVo vo);

	OrderPo findOrder(String orderNo);

	List<OrderItemVo> findOrderItems(int orderId);

	void updateStates(OrderPo po);
}
