package tibame.myOrders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.myOrders.dao.myOrderDao;
import tibame.myOrders.vo.ProductOrder;

@Component
public class MyOrderService {
	
	@Autowired
	private myOrderDao myOrderDao;
	
	public List<ProductOrder> findAllById(Integer orderId){
		System.out.println("456");
		return myOrderDao.findAll();
	}
}
