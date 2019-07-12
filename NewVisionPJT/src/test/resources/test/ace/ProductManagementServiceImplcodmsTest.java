package test.ace;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.codms.ProductionManagementServicecodms;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class ProductManagementServiceImplcodmsTest{

	@Resource(name = "productionManagementServiceImplcodms")
	private ProductionManagementServicecodms codmsService;
	
	//주문서등록
	//@Test
	public void addOrderFromBranchTest() throws Exception{
		OrderFromBranch ob = new OrderFromBranch();
		ob.setOrderFromBranchTotalAmount("1300");
		ob.setBranchNo("b1004");
		List<OrderFromBranchProduct> list = new ArrayList<OrderFromBranchProduct>();
		OrderFromBranchProduct op1 = new OrderFromBranchProduct("10005", "300", null, "3", "900");
		OrderFromBranchProduct op2 = new OrderFromBranchProduct("10006", "400", null, "1", "400");
		list.add(op1);
		list.add(op2);
		ob.setOrderFromBranchProductList(list);
		
		codmsService.addOrderFromBranch(ob);
	}
	
	//주문서 상태 변경
	@Test
	public void modifyOrderFromBranchStatusTest() throws Exception{
//		codmsService.modifyOrderFromBranchStatus(orderFromBranch);
	}
}