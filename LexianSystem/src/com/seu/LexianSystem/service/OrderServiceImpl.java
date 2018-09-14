package com.seu.LexianSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seu.LexianSystem.service.BaseService;
import com.seu.LexianSystem.util.Constant;
import com.seu.LexianSystem.util.ResultHelper;
import com.seu.LexianSystem.constant.OrderConstant;
import com.seu.LexianSystem.dao.OrderDao;
import com.seu.LexianSystem.po.OrderPo;
import com.seu.LexianSystem.service.OrderService;
import com.seu.LexianSystem.vo.OrderItemVo;
import com.seu.LexianSystem.vo.OrderQueryVo;
import com.seu.LexianSystem.vo.OrderVo;

@Service
@Transactional
public class OrderServiceImpl extends BaseService implements OrderService {
	private OrderDao orderDao;
   
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Override
	public ResultHelper findOrders(OrderQueryVo queryVo) {
		List<OrderPo> pos = orderDao.findOrders(queryVo);
		List<OrderVo> vos = new ArrayList<OrderVo>();
		for(OrderPo po : pos){
			OrderVo vo = new OrderVo(po);
			vos.add(vo);
		}
		return new ResultHelper(Constant.success_code, OrderConstant.success,
				vos, queryVo.getTotal());
	}

	@Override
	public ResultHelper findOrder(String orderNo) {
		OrderPo po = orderDao.findOrder(orderNo);
		OrderVo vo = new OrderVo(po);
		List<OrderItemVo> itemsVo = orderDao.findOrderItems(vo.getId());
		vo.setOrderItems(itemsVo);
		
		return new ResultHelper(Constant.success_code, OrderConstant.success, vo);
	}

	@Override
	public ResultHelper deliverOrder(String orderNo) {
		OrderPo po = orderDao.findOrder(orderNo);
		po.setStates(3);   // 已发货状态
		orderDao.updateStates(po);
		
		return new ResultHelper(Constant.success_code, OrderConstant.success); 
	}
}
