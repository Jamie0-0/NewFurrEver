package order.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import order.vo.SubProduct;

@Repository
public class SubProductDaoImpl implements SubProductDao {
	
//	private Session getSession() {
//	return HibernateUtil.getSessionFactory().getCurrentSession();
//}

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public int insertSubProduct(SubProduct subProduct) {
//		getSession().persist(subProduct);
		entityManager.persist(subProduct);
		return 0;
	}
}
