package tibame.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import tibame.gb.utils.GBDatabaseUtil;
import tibame.gb.vo.GbAndProductVO;
import tibame.gb.vo.GbOrderVO;
import tibame.gb.vo.GbVO;
import tibame.gb.vo.ProductAndMasterVO;
import tibame.gb.vo.ProductVO;

public class GbDAOImpl implements GBDao {
	private static final String INSERT_GB_SQL = "INSERT INTO GB (gb_p_id, gb_s_price, gb_c_max, gb_time_start, gb_time_end, gb_status) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_GB_SQL = "UPDATE GB SET gb_p_id = ?, gb_s_price = ?, gb_c_max = ?, gb_time_start = ?, gb_time_end = ?, gb_status = ? WHERE gb_id = ?";
	private static final String DELETE_GB_SQL = "DELETE FROM GB WHERE gb_id = ?";
	private static final String SELECT_GB_BY_ID_SQL = "SELECT * FROM GB WHERE gb_id = ?";

	private static final String SELECT_ALL_GB_SQL = "SELECT * FROM GB";
	private static final String JOIN_PRODUCT_SQL = "SELECT gb.gb_id, gb.gb_p_id, gb.gb_s_price, gb.gb_c_max, gb.gb_time_start, gb.gb_time_end, gb.gb_satus, "
			+ "p.p_id, p.p_m_id, p.p_name, p.p_price, p.p_stock, p.p_count, p.p_type, p.p_class, p.p_upload_time, "
			+ "p.p_des, p.p_status, p.p_pic_one, p.p_pic_two, p.p_pic_three, p.p_pic_four, p.p_1, p.p_2, p.p_3 "
			+ "FROM gb gb JOIN product p ON gb.gb_p_id = p.p_id";
	private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (p_m_id, p_name, p_price, p_stock, p_count, p_type, p_class, p_upload_time, p_des, p_status, p_pic_one, p_pic_two, p_pic_three, p_pic_four, p_1, p_2, p_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private DataSource ds;

	public GbDAOImpl() {
		try {
			ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/FurrEver");
		} catch (Exception e) {
		}
	}

	@Override
	public void insert(GbVO gbVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GBDatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_GB_SQL);
			pstmt.setInt(1, gbVO.getGb_p_id());
			pstmt.setInt(2, gbVO.getGb_s_price());
			pstmt.setInt(3, gbVO.getGb_c_max());
			pstmt.setTimestamp(4, new Timestamp(gbVO.getGb_time_start().getTime()));
			pstmt.setTimestamp(5, new Timestamp(gbVO.getGb_time_end().getTime()));
			pstmt.setInt(6, gbVO.getGb_status());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GBDatabaseUtil.closeResources(conn, pstmt);
		}
	}

	@Override
	public void update(GbVO gbVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GBDatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_GB_SQL);
			pstmt.setInt(1, gbVO.getGb_p_id());
			pstmt.setInt(2, gbVO.getGb_s_price());
			pstmt.setInt(3, gbVO.getGb_c_max());
			pstmt.setTimestamp(4, new Timestamp(gbVO.getGb_time_start().getTime()));
			pstmt.setTimestamp(5, new Timestamp(gbVO.getGb_time_end().getTime()));

			pstmt.setInt(6, gbVO.getGb_status());
			pstmt.setInt(7, gbVO.getGb_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GBDatabaseUtil.closeResources(conn, pstmt);
		}
	}

	@Override
	public void delete(Integer gb_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GBDatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE_GB_SQL);
			pstmt.setInt(1, gb_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GBDatabaseUtil.closeResources(conn, pstmt);
		}
	}

	@Override
	public GbVO findByPrimaryKey(Integer gb_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GbVO gbVO = null;
		try {
			conn = GBDatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT_GB_BY_ID_SQL);
			pstmt.setInt(1, gb_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				gbVO = new GbVO();
				gbVO.setGb_id(rs.getInt("gb_id"));
				gbVO.setGb_p_id(rs.getInt("gb_p_id"));
				gbVO.setGb_s_price(rs.getInt("gb_s_price"));
				gbVO.setGb_c_max(rs.getInt("gb_c_max"));
				gbVO.setGb_time_start(rs.getTimestamp("gb_time_start"));
				gbVO.setGb_time_end(rs.getTimestamp("gb_time_end"));

				gbVO.setGb_status(rs.getInt("gb_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GBDatabaseUtil.closeResources(conn, pstmt, rs);
		}
		return gbVO;
	}

	@Override
	public List<GbVO> getAll() {
		ResultSet rs = null;
		List<GbVO> gbList = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_GB_SQL);) {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GbVO gbVO = new GbVO();
				gbVO.setGb_id(rs.getInt("gb_id"));
				gbVO.setGb_p_id(rs.getInt("gb_p_id"));
				gbVO.setGb_s_price(rs.getInt("gb_s_price"));
				gbVO.setGb_c_max(rs.getInt("gb_c_max"));
				gbVO.setGb_time_start(rs.getTimestamp("gb_time_start"));
				gbVO.setGb_time_end(rs.getTimestamp("gb_time_end"));
				gbVO.setGb_status(rs.getInt("gb_satus"));
				gbList.add(gbVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gbList;
	}

	// join product table
	@Override
	public List<GbAndProductVO> getGbAndProductJoin() {
		List<GbAndProductVO> result = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(JOIN_PRODUCT_SQL);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				GbVO gbVO = new GbVO();
				ProductVO productVO = new ProductVO();
				gbVO.setGb_id(rs.getInt("gb_id"));
				gbVO.setGb_p_id(rs.getInt("gb_p_id"));
				gbVO.setGb_s_price(rs.getInt("gb_s_price"));
				gbVO.setGb_c_max(rs.getInt("gb_c_max"));
				gbVO.setGb_time_start(rs.getTimestamp("gb_time_start"));
				gbVO.setGb_time_end(rs.getTimestamp("gb_time_end"));
				gbVO.setGb_status(rs.getInt("gb_satus"));

				productVO.setP_id(rs.getInt("p_id"));
				productVO.setP_m_id(rs.getInt("p_m_id"));
				productVO.setP_name(rs.getString("p_name"));
				productVO.setP_price(rs.getInt("p_price"));
				productVO.setP_stock(rs.getInt("p_stock"));
				productVO.setP_count(rs.getInt("p_count"));
				productVO.setP_type(rs.getInt("p_type"));
				productVO.setP_class(rs.getInt("p_class"));
				productVO.setP_upload_time(rs.getDate("p_upload_time"));
				productVO.setP_des(rs.getString("p_des"));
				productVO.setP_status(rs.getInt("p_status"));
				productVO.setP_pic_one(rs.getBytes("p_pic_one"));
				productVO.setP_pic_two(rs.getBytes("p_pic_two"));
				productVO.setP_pic_three(rs.getBytes("p_pic_three"));
				productVO.setP_pic_four(rs.getBytes("p_pic_four"));

				GbAndProductVO gbAndProductVO = new GbAndProductVO();
				gbAndProductVO.setGbVO(gbVO);
				gbAndProductVO.setProductVO(productVO);
				result.add(gbAndProductVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 以下圖片
	@Override
	public void insertProductWithImages(ProductVO product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GBDatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT_PRODUCT_SQL);
			// 設定圖片的值 // 省略 設定其他商品資料的值s
			String imageFolderPath = "/images/";
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GBDatabaseUtil.closeResources(conn, pstmt);
		}
	}

	private byte[] convertImageToBase64(String base64Data) {
		return Base64.getDecoder().decode(base64Data);
	}

	@Override
	public List<GbAndProductVO> selectByKeyWords(String how, String keywords) {
		String columnName = how;
		String query = "SELECT gb.gb_id, gb.gb_p_id, gb.gb_s_price, gb.gb_c_max, gb.gb_time_start, gb.gb_time_end, gb.gb_satus, "
				+ "p.p_id, p.p_m_id, p.p_name, p.p_price, p.p_stock, p.p_count, p.p_type, p.p_class, p.p_upload_time, "
				+ "p.p_des, p.p_status, p.p_pic_one, p.p_pic_two, p.p_pic_three, p.p_pic_four, p.p_1, p.p_2, p.p_3 "
				+ "FROM gb gb JOIN product p ON gb.gb_p_id = p.p_id " + "WHERE " + columnName + " = ?";
		List<GbAndProductVO> result = new ArrayList<>();
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, keywords);
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				GbVO gbVO = new GbVO();
				ProductVO productVO = new ProductVO();
				gbVO.setGb_id(rs.getInt("gb_id"));
				gbVO.setGb_p_id(rs.getInt("gb_p_id"));
				gbVO.setGb_s_price(rs.getInt("gb_s_price"));
				gbVO.setGb_c_max(rs.getInt("gb_c_max"));
				gbVO.setGb_time_start(rs.getTimestamp("gb_time_start"));
				gbVO.setGb_time_end(rs.getTimestamp("gb_time_end"));
				gbVO.setGb_status(rs.getInt("gb_satus"));

				productVO.setP_id(rs.getInt("p_id"));
				productVO.setP_m_id(rs.getInt("p_m_id"));
				productVO.setP_name(rs.getString("p_name"));
				productVO.setP_price(rs.getInt("p_price"));
				productVO.setP_stock(rs.getInt("p_stock"));
				productVO.setP_count(rs.getInt("p_count"));
				productVO.setP_type(rs.getInt("p_type"));
				productVO.setP_class(rs.getInt("p_class"));
				productVO.setP_upload_time(rs.getDate("p_upload_time"));
				productVO.setP_des(rs.getString("p_des"));
				productVO.setP_status(rs.getInt("p_status"));
				productVO.setP_pic_one(rs.getBytes("p_pic_one"));
				productVO.setP_pic_two(rs.getBytes("p_pic_two"));
				productVO.setP_pic_three(rs.getBytes("p_pic_three"));
				productVO.setP_pic_four(rs.getBytes("p_pic_four"));

				GbAndProductVO gbAndProductVO = new GbAndProductVO();
				gbAndProductVO.setGbVO(gbVO);
				gbAndProductVO.setProductVO(productVO);
				result.add(gbAndProductVO);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 以上圖片

	@Override
	public List<ProductAndMasterVO> getProductsAndMasters() {
		List<ProductAndMasterVO> products = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT p.*, m.* FROM product p " + "INNER JOIN master m ON p.p_m_id = m.m_id")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProductAndMasterVO productAndMaster = new ProductAndMasterVO();
				ProductVO productVO = new ProductVO();
				productAndMaster.setProductVO(productVO);
				productAndMaster.setMId(rs.getInt("m_id"));
				productAndMaster.setMName(rs.getString("m_name"));
				products.add(productAndMaster);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<GbOrderVO> getAllGbOrdersWithGbDetails() {
		List<GbOrderVO> gbOrders = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT o.*, g.* FROM gb_order o " + "INNER JOIN gb g ON o.gb_id = g.gb_id")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				GbOrderVO gbOrder = new GbOrderVO();
				GbVO gb = new GbVO();

				gbOrder.setGb_p_num(rs.getInt("gb_p_num"));
				gbOrder.setGb_pay(rs.getString("gb_pay"));
				gbOrder.setGb_order_id(rs.getInt("gb_order_id"));
				
				gb.setGb_id(rs.getInt("gb_id"));
				gbOrder.setGbVO(gb);
				gbOrders.add(gbOrder);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return gbOrders;
	}

	public boolean insertGbOrder(GbOrderVO gbOrder) {
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"INSERT INTO gb_order (uid, gb_order_id, gb_date, gb_t, gb_s, gb_pay, gb_p_num, gb_p_dfee) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS)) {
			System.out.println("123");
			pstmt.setInt(1, gbOrder.getUid()); // 會員編號
			pstmt.setInt(2, gbOrder.getGb_order_id()); // 團購編號
			System.out.println(gbOrder.getGb_order_id());
			java.util.Date gbDate = gbOrder.getGb_date();
			pstmt.setDate(3, new java.sql.Date(gbDate.getTime())); // 訂單日期
			pstmt.setInt(4, gbOrder.getGb_t()); // 訂單總金額
			pstmt.setString(5, "1"); // (0.已出貨、1.未出貨) 訂單狀態
			pstmt.setString(6, "1"); // (0.已付款、1.未付款) 付款狀態
			pstmt.setInt(7, gbOrder.getGb_p_num()); // 商品數量
			pstmt.setInt(8, 0); // 運費金額

			int rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					int generatedId = generatedKeys.getInt(1);
					gbOrder.setGb_id(generatedId);
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Integer updateGbStatusToZero(int gbId) {
		 try (Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(
	                     "UPDATE gb SET gb_satus = '0' WHERE gb_id = ?")) {
			 pstmt.setInt(1, gbId);
	          return  pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return 0;
	    }
	}

