package tibame.wei.dao;

import java.util.List;

import tibame.wei.model.GbOrder;
import tibame.wei.model.PersonOrderDetial;
import tibame.wei.model.ProductDetial;
import tibame.wei.model.Product_order;

public interface ProductOrderDAO {

	List<Product_order> getProduct_orderById(Integer so_m_id);
	List<Product_order> getProductSearchById(Integer so_m_id, Integer order_s, Integer order_id);
	List<ProductDetial> getDetailSearchById(Integer so_m_id, Integer order_uid, Integer order_s, Integer order_id);
	List<PersonOrderDetial> getPersonInfo(Integer so_m_id, Integer order_uid, Integer order_s, Integer order_id);
	Integer updateStatus(Integer order_id);
	List<GbOrder> getGbOrderById(Integer p_m_id);
	List<GbOrder> getGbSearchById(Integer p_m_id, Integer gb_id, Integer gb_s);
}
