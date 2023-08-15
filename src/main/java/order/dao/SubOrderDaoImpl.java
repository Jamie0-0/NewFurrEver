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

import order.vo.SubOrder;
@Repository
public class SubOrderDaoImpl implements SubOrderDao {
	private DataSource ds;
//	private Session getSession() {
//	return HibernateUtil.getSessionFactory().getCurrentSession();
//}

	@PersistenceContext
    private EntityManager entityManager;
	
	public SubOrderDaoImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FurrEver");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertSubOrder(SubOrder subOrder) {
//		getSession().persist(subOrder);
		 entityManager.persist(subOrder);
		return subOrder.getSo_order_id();
	}

	@Override
	public List<SubOrder> selectBySoOrderNum(int so_order_num) {
		String sql = "select so_order_num, so_order_id from sub_order where so_order_num = ?";
		var list = new ArrayList<SubOrder>();

		try (Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, so_order_num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubOrder subOrder = new SubOrder();
				subOrder.setSo_order_num(so_order_num);
				subOrder.setSo_order_id(rs.getInt("so_order_id"));

				list.add(subOrder);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
