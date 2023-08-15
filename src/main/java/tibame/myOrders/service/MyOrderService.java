package tibame.myOrders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.myOrders.dao.MyGbDao;
import tibame.myOrders.dao.myOrderDao;
import tibame.myOrders.vo.MyGb;
import tibame.myOrders.vo.MyProductOrder;

@Component
public class MyOrderService {
	
	@Autowired
	private myOrderDao myOrderDao;
	
	@Autowired
	private MyGbDao myGbDao;
	
	public List<MyProductOrder> findAll(Integer orderUid){
		return myOrderDao.findAllByorderUid(orderUid);
	}
	
//	public List<GBOrder> finGbOrders(Integer uId) {
//		return myGbDao.findAllByuId(uId);
//	}
	
	public List<MyGb> finGbOrder(Integer uid) {
		return myGbDao.findAllByuId(uid);
	}
	
}
