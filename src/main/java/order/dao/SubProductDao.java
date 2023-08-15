package order.dao;

import java.util.List;

import order.vo.SubProduct;

public interface SubProductDao {

	int insertSubProduct(SubProduct subProduct);
	
	List<SubProduct> selectByOrderId(int order_id);

}