package test.pkj;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.service.domain.Product;
import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementDAOrudwn;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class ProductTest{

	@Resource(name = "productionManagementDAOImplrudwn")
	private ProductionManagementDAOrudwn productDAO;
	
	@Test
	public void testSelectDetailProduct() throws Exception {
		Product product = new Product();
		String productNo = "10006";
		
		product = productDAO.selectDetailProduct(productNo);
		
		System.out.println(product);
		
	}

}
