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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class TestBranch{

	@Resource(name = "businessSupportDAOImpl")
	private BusinessSupportDAO businessSupportDAO;
	
	@Resource(name = "branchDAOImpl")
	private BranchDAO branchDAO;
	
	//@Test
	public void testSelectBranchList() throws Exception {
		
		System.out.println("4445555");
		Search search = new Search();
		
		List<Branch> list 
				= (List<Branch>)branchDAO.selectBranchList(search);
		
		for(int i = 0; i<list.size(); i++) {
			Branch branch = list.get(i);
			System.out.println(branch);
		}
		
	}
	
	@Test
	public void testSelectBranchDetail() throws Exception {
		
		Branch branch = new Branch();
		
		String branchNo = "b1003";
		
		branch = businessSupportDAO.selectBranchDetail(branchNo);		
		System.out.println("dfdfdfsfsfsafsdfsd");
		System.out.println("BranchDtail : "+branch);
		
	}

}
