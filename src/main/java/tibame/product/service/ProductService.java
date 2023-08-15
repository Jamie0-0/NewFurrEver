package tibame.product.service;

import java.util.List;

import tibame.product.vo.Product;

public interface ProductService {

	List<Product> showMyProduct(Integer uid);
	
	Integer deleteMyProductLike(Integer plUid, Integer plPId);
	
	List<Product> selectMyProduct(Integer uid);
}
