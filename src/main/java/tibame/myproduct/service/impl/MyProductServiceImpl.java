package tibame.myproduct.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.myproduct.dao.MyProductDao;
import tibame.myproduct.dao.MyProductJdbcDao;
import tibame.myproduct.dao.MyProductLikeDao;
import tibame.myproduct.service.MyProductService;
import tibame.myproduct.vo.MyProduct;




@Component
public class MyProductServiceImpl implements MyProductService {

	@Autowired
	private MyProductDao productDao;

	@Autowired
	private MyProductLikeDao productLikeDao;
	
	@Autowired
	private MyProductJdbcDao productJdbcDao;
	
	
	@Override
	public List<MyProduct> showMyProduct(Integer uid) {
		return productDao.findByUid(uid);
	}
	
	@Transactional
	@Override
	public Integer deleteMyProductLike(Integer plUid, Integer plPId) {
		return productLikeDao.deledeleteByplUidAndplPId(plUid, plPId);
	}
	
	public List<MyProduct> selectMyProduct(Integer uid){
		return productJdbcDao.findMyProductByUid(uid);
	}
}
