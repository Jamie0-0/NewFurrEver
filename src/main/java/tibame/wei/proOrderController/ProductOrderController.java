package tibame.wei.proOrderController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tibame.wei.model.GbOrder;
import tibame.wei.model.PersonOrderDetial;
import tibame.wei.model.ProductDetial;
import tibame.wei.model.Product_order;
import tibame.wei.service.ProductOrderService;

@RestController
@RequestMapping("/backEnd")
public class ProductOrderController {

	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("order-listValue")
	public ResponseEntity<List<Product_order>> getProductOrderById(@RequestParam Integer so_m_id) {
	    List<Product_order> productOrder = productOrderService.getProduct_orderById(so_m_id);
	    if (productOrder != null) {
	        return ResponseEntity.ok(productOrder);
	    }
	    return ResponseEntity.notFound().build();
	}

	@PostMapping("order-Search")
	public ResponseEntity<List<Product_order>> getProductSearchById(@RequestParam Integer so_m_id, Integer order_s, Integer order_id) {
	    List<Product_order> productOrder = productOrderService.getProductSearchById(so_m_id,order_s,order_id);
	    if (productOrder != null) {
	        return ResponseEntity.ok(productOrder);
	    }
	    return null;
	}
	
	
	
	@PostMapping("detial-Search")
	public ResponseEntity<List<ProductDetial>> getDetailSearchById(@RequestParam Integer so_m_id, Integer order_uid, Integer order_s, Integer order_id){
	    List<ProductDetial> productDetial = productOrderService.getDetailSearchById(so_m_id, order_uid, order_s, order_id);
	    if (productDetial != null) {
	        return ResponseEntity.ok(productDetial);
	    }
	    return null;
	}

	@PostMapping("personal-Search")
	public ResponseEntity<List<PersonOrderDetial>> getPersonInfo(@RequestParam Integer so_m_id, Integer order_uid, Integer order_s, Integer order_id){
	    List<PersonOrderDetial> productDetial = productOrderService.getPersonInfo(so_m_id, order_uid, order_s, order_id);
	    if (productDetial != null) {
	        return ResponseEntity.ok(productDetial);
	    }
	    return null;
	}
	
	@PostMapping("update-Status")
	public ResponseEntity<Integer> updateStatus(@RequestParam Integer order_id){
		Integer success = productOrderService.updateStatus(order_id);
	    if (success > 0) {
	        return ResponseEntity.ok(success);
	    }
	    return null;
	}
	
	
	
	@PostMapping("gb-listValue")
	public ResponseEntity<List<GbOrder>> getGbOrderById(@RequestParam Integer p_m_id) {
	    List<GbOrder> gbOrder = productOrderService.getGbOrderById(p_m_id);
	    if (gbOrder != null) {
	        return ResponseEntity.ok(gbOrder);
	    }
	    return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("gb-Search")
	public ResponseEntity<List<GbOrder>> getGbSearchById(@RequestParam Integer p_m_id,Integer gb_id,Integer gb_s) {
	    List<GbOrder> gbOrder = productOrderService.getGbSearchById(p_m_id,gb_id,gb_s);
	    if (gbOrder != null) {
	        return ResponseEntity.ok(gbOrder);
	    }
	    return ResponseEntity.notFound().build();
	}
}
