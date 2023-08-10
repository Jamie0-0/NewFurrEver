package tibame.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tibame.product.service.ProductService;
import tibame.product.vo.Product;

@RestController
@RequestMapping("findmyproduct")
public class FindMyProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> findMyProduct(HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		Map<String, Object> response = new HashMap<>();
		if (uid != null) {
			List<Product> products = productService.selectMyProduct(uid);
			if (products.isEmpty()) {
				response.put("noProduct", 0);
				return ResponseEntity.ok(response);
			}
			response.put("product", products);
			return ResponseEntity.ok(response);
		}
		response.put("noUser", 0);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
