package com.seu.LexianSystem.service;

import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.vo.OrderQueryVo;

public interface OrderService {
	public ResultHelper findOrders(OrderQueryVo queryVo);

	public ResultHelper findOrder(String orderNo);

	public ResultHelper deliverOrder(String orderNo);
}
