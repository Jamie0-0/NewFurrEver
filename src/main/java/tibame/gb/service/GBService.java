package tibame.gb.service;

import java.util.List;

import tibame.gb.vo.GbAndProductVO;
import tibame.gb.vo.GbOrderVO;
import tibame.gb.vo.GbVO;
import tibame.gb.vo.ProductAndMasterVO;



public interface GBService {
	void addGb(GbVO gbVO);

	void updateGb(GbVO gbVO);

	void deleteGb(Integer gb_id);

	GbVO getGbByPrimaryKey(Integer gb_id);

	List<GbVO> getAllGb();
	
	List<GbAndProductVO> getAllGbJoinProduct(); 
	
	List<GbAndProductVO> getAllGbJoinProductWithBase64();
	
	//product join master
	List<ProductAndMasterVO> getProductsAndMasters();
	
	//gb join gborder
	List<GbOrderVO> getAllGbOrdersWithGbDetails();

	boolean insertGbOrder(GbOrderVO gbOrder); 
	
	int getTotalPNumForOrderId(int orderId);
	
	Integer updateGbStatusToZero(int gbId);
}