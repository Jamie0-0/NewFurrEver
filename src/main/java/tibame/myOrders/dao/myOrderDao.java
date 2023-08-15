package tibame.myOrders.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import tibame.myOrders.vo.MyProductOrder;


@Component
public interface myOrderDao extends JpaRepository<MyProductOrder, Integer>{

	List<MyProductOrder> findAllByorderUid(Integer orderUid);
	
}
