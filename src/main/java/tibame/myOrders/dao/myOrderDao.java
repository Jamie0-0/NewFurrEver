package tibame.myOrders.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import tibame.myOrders.vo.ProductOrder;


@Component
public interface myOrderDao extends JpaRepository<ProductOrder, Integer>{

	List<ProductOrder> findAll();
}
