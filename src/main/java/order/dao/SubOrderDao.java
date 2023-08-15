package order.dao;

import java.util.List;

import order.vo.SubOrder;

public interface SubOrderDao {

	int insertSubOrder(SubOrder subOrder);
	
	List<SubOrder> selectBySoOrderNum(int so_order_num);

}