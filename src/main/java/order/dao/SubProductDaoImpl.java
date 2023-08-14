package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import order.vo.SubProduct;

@Repository
public class SubProductDaoImpl implements SubProductDao {
	private DataSource ds;
//	private Session getSession() {
//	return HibernateUtil.getSessionFactory().getCurrentSession();
//}

	@PersistenceContext
    private EntityManager entityManager;
	
	public SubProductDaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FurrEver");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertSubProduct(SubProduct subProduct) {
//		getSession().persist(subProduct);
		entityManager.persist(subProduct);
		return 0;
	}

	@Override
	public List<SubProduct> selectByOrderId(int order_id) {
		String sql = "select order_id, p_p_id, p_m_stock, p_m_price from sub_product where order_id = ?";
		var list = new ArrayList<SubProduct>();

		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, order_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubProduct subProduct = new SubProduct();
				subProduct.setOrder_id(order_id);
				subProduct.setP_p_id(rs.getInt("p_p_id"));
				subProduct.setP_m_stock(rs.getInt("p_m_stock"));
				subProduct.setP_m_price(rs.getInt("p_m_price"));

				list.add(subProduct);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
