package order.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import order.vo.SubOrder;
@Repository
public class SubOrderDaoImpl implements SubOrderDao {

//	private Session getSession() {
//	return HibernateUtil.getSessionFactory().getCurrentSession();
//}

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public int insertSubOrder(SubOrder subOrder) {
//		getSession().persist(subOrder);
		 entityManager.persist(subOrder);
		return subOrder.getSo_order_id();
	}
}
