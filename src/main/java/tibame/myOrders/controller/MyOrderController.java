package tibame.myOrders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tibame.myOrders.service.MyOrderService;
import tibame.myOrders.vo.ProductOrder;



@RestController
@RequestMapping("myorder")
public class MyOrderController {

	@Autowired
	private MyOrderService myOrderService;
	
	@PostMapping
	public List<ProductOrder> add(@RequestParam Integer orderId) {
		System.out.println("123");
		return myOrderService.findAllById(orderId);
	}
}
