package tibame.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.product.dao.ProductDao;
import tibame.product.dao.ProductJdbcDao;
import tibame.product.dao.ProductLikeDao;
import tibame.product.service.ProductService;
import tibame.product.vo.Product;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductLikeDao productLikeDao;
	
	@Autowired
	private ProductJdbcDao productJdbcDao;
	
	
	@Override
	public List<Product> showMyProduct(Integer uid) {
		return productDao.findByUid(uid);
	}
	
	@Transactional
	@Override
	public Integer deleteMyProductLike(Integer plUid, Integer plPId) {
		return productLikeDao.deledeleteByplUidAndplPId(plUid, plPId);
	}
	
	public List<Product> selectMyProduct(Integer uid){
		return productJdbcDao.findMyProductByUid(uid);
	}
}
