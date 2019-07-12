package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Code;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.codms.impl.ProductionManagementDAOImplcodms;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class ProductManagementDAOImplcodmsTest{

	@Resource(name = "productionManagementDAOImplcodms")
	private ProductionManagementDAOImplcodms codmsDAO;
	
	//[지점]주문요청-주문서등록
	//@Test
	public void insertOrderFromBranchTest() throws Exception{
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		int i = codmsDAO.insertOrderFromBranch(ofb);
		System.out.println(i+", "+ofb.getOrderFromBranchNo());
	}
	
	
	//[지점]주문요청-주문물품등록
	//@Test
	public void insertOrderFromBranchProductTest() throws Exception{
		OrderFromBranchProduct ofbp = new OrderFromBranchProduct("10005", "300", "10005", "2", "600");
		int i = codmsDAO.insertOrderFromBranchProduct(ofbp);
		System.out.println(i);
	}
	
	
	//[본사, 지점]주문서상태변경(주문취소요청, 주문취소확정, 주문완료)
	//@Test
	public void updateOrderFromBranchStatusTest() throws Exception{
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		ofb.setOrderFromBranchNo("10005");
		ofb.setOrderFromBranchStatusCodeNo("04");
		int i = codmsDAO.updateOrderFromBranchStatus(ofb);
		System.out.println(i);
	}
	
	//[본사, 지점]주문서리스트 가져오기(주문물품 채워서) 지점번호 searchKeyword에 채우기
	//@Test
	public void selectOrderFromBranchTest() throws Exception{
		Search search = new Search();
		List<OrderFromBranch> list = codmsDAO.selectOrderFromBranchList(search);
		for(OrderFromBranch ofb : list) {
			System.out.println(ofb);
		}
	}
	
	//[본사]주문물품 상태변경(출하완료, 출하대기, 출하취소)
	//@Test
	public void updateOrderFromBranchProductStatusTest() throws Exception{
		OrderFromBranchProduct ofbp = new OrderFromBranchProduct("10005", "300", "10005", "2", "600");
		ofbp.setNumbering("10001");
		ofbp.setOrderFromBranchProductStatusCodeNo("03");
		int i = codmsDAO.updateOrderFromBranchProductStatus(ofbp);
		System.out.println(i);
	}
	
	
	//[본사]주문물품 모두 출하완료인지 확인, 출하대기인 상품개수 return
	//@Test
	public void selectOrderFromBranchProduct() throws Exception {
		OrderFromBranch ofb = new OrderFromBranch("1001", "400", "b1003", "1111/11/11");
		ofb.setOrderFromBranchNo("10005");
		int i = codmsDAO.selectOrderFromBranchProduct(ofb.getOrderFromBranchNo());
		System.out.println("출하대기인 상품개수 : "+i);
	}
	
	
}