package test.hjh;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.branch.BranchDAO;
import com.vision.erp.service.businesssupport.BusinessSupportDAO;
import com.vision.erp.service.domain.Branch;
import com.vision.erp.service.domain.BranchDailySales;
import com.vision.erp.service.domain.SalesProduct;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class BranchDAOTest{

	@Resource(name = "branchDAOImpl")
	private BranchDAO branchDAO;
	
	private SalesProduct salesProduct;
	private List<SalesProduct> salesProductList;
	private List<BranchDailySales> branchDailySalesList;
	private BranchDailySales branchDailySales;
	
	//@Test
	public void testIsertDailySales() throws Exception {
		
		salesProduct = new SalesProduct();
		
		salesProduct.setBranchNo("b1003");
		salesProduct.setSalesDate("2019/06/08");
		salesProduct.setMenuNo("1");
		salesProduct.setSalesAmount("125000");
		salesProduct.setSalesQuantity("9");
		
		branchDAO.insertDailySales(salesProduct);
		
		salesProduct.setBranchNo("b1003");
		salesProduct.setSalesDate("2019/06/08");
		salesProduct.setMenuNo("2");
		salesProduct.setSalesAmount("160000");
		salesProduct.setSalesQuantity("10");
		
		branchDAO.insertDailySales(salesProduct);
		
		salesProductList 
			= (List<SalesProduct>)branchDAO.selectDailySalesDetail("b1003", "2019/06/08");
		
		for(int i = 0; i<salesProductList.size(); i++) {
			SalesProduct salesProduct = salesProductList.get(i);
			System.out.println(salesProduct);
		}
		
	}
	
	//@Test
	public void testSelectDailySalesDetail() throws Exception {
		
		String branchNo = "b1003";
		String salesDate = "2019/06/08";
		List<SalesProduct> list
			= (List<SalesProduct>)branchDAO.selectDailySalesDetail(branchNo, salesDate);
		
		for(int i = 0; i<list.size(); i++) {
			salesProduct = list.get(i);
			System.out.println(salesProduct);
		}
		
	}
	
	@Test
	public void testSelectBranchDailySalesList() throws Exception {
		
		String branchNo = "b1003";
		
		branchDailySalesList = 
				(List<BranchDailySales>)branchDAO.selectDailySalesList(branchNo);
		
		for(int i = 0; i<branchDailySalesList.size(); i++) {
			branchDailySales = branchDailySalesList.get(i);
			System.out.println(branchDailySales);
		}				
		
	}
	

}
