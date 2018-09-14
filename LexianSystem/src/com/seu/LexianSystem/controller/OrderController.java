package com.seu.LexianSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.seu.LexianSystem.service.OrderService;
import com.seu.LexianSystem.vo.OrderQueryVo;

@Controller
@RequestMapping("order")
public class OrderController {
	private OrderService orderService;

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// 搜索订单
	@RequestMapping("/findOrders.do")
	@ResponseBody
	public Object findOrders(OrderQueryVo queryVo){
		return orderService.findOrders(queryVo);
	}
	
	// 搜索单个订单详情
	@RequestMapping("/findOrder.do")
	@ResponseBody
	public Object findOrder(String orderNo){
		return orderService.findOrder(orderNo);
	}
	
	// 订单发货
	@RequestMapping("/deliverOrder.do")
	@ResponseBody
	public Object deliverOrder(String orderNo){
		return orderService.deliverOrder(orderNo);
	}
}
