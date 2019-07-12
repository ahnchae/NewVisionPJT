package test.hjh;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.businesssupport.BusinessSupportDAO;
import com.vision.erp.service.domain.Branch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class BusinessSupportDAOTest{

	@Resource(name = "businessSupportDAOImpl")
	private BusinessSupportDAO businessSupportDAO;
	
	private Branch branch;
	private Search search;
	private List<Branch> branchList;
	
	
	//@Test
	public void testInsertBranch() throws Exception {
		
		branch = new Branch();
		
		branch.setBranchName("Test03");
		branch.setZipCode("12345");
		branch.setAddress("Test03");
		branch.setDetailAdress("1111");
		branch.setBusinessLicenseNo("123-12-12343");	//UNIQUE
		branch.setBranchTel("111-111-1113");			//UNIQUE
		branch.setBranchManagerPhone("010-1111-1113");		//UNIQUE
		branch.setBranchManagerName("test02");
		branch.setLocalCodeNo("05");
		branch.setBranchStatusCodeNo("01");
		
		String branchNo = businessSupportDAO.insertBranch(branch);
		
		branch = businessSupportDAO.selectBranchDetail(branchNo);
		System.out.println("insert«— selectBranchDetail : " +branch);
		
	}
	
	//@Test
	public void testSelectBranchList() throws Exception {
		
		search = new Search();
		
		branchList 
				= (List<Branch>)businessSupportDAO.selectBranchList(search);
		
		for(int i = 0; i<branchList.size(); i++) {
			branch = branchList.get(i);
			System.out.println(branch);
		}
		
	}
	
	//@Test
	public void testSelectBranchDetail() throws Exception {
		
		branch = new Branch();
		
		String branchNo = "b1003";
		
		branch = businessSupportDAO.selectBranchDetail(branchNo);		
		System.out.println("BranchDtail : "+branch);
		
	}
	
	//@Test
	public void testUpdateBranch() throws Exception {
		
		branch = new Branch();
		
		branch.setBranchNo("b1024");
		branch.setBranchName("Test03");
		branch.setZipCode("12345");
		branch.setAddress("Test03");
		branch.setDetailAdress("1111");
		branch.setBusinessLicenseNo("123-12-12343");	//UNIQUE
		branch.setBranchTel("111-111-1113");			//UNIQUE
		branch.setBranchManagerPhone("010-1111-1113");		//UNIQUE
		branch.setBranchManagerName("test02");
		branch.setLocalCodeNo("05");
		branch.setBranchStatusCodeNo("01");
		
		businessSupportDAO.updateBranch(branch);
		
		branch = businessSupportDAO.selectBranchDetail("b1024");
		
		System.out.println(branch);	
		
		
	}
	
	//@Test
	public void testUpdateBranchUsageCode() throws Exception {
		
		branch = new Branch();
		
		branch.setBranchNo("b1024");
		branch.setBranchStatusCodeNo("02");
		
		businessSupportDAO.updateBranchUsageStatus(branch);
		
		branch = businessSupportDAO.selectBranchDetail("b1024");
		
		System.out.println(branch);
		
	}
	
	@Test
	public void testSelectTotalCount() throws Exception {
		
		search = new Search();
		
		search.setSearchCondition("1");
		search.setSearchKeyword("est");
		
		System.out.println(search);
		int totalCount = businessSupportDAO.selectTotalCount(search);
		
		System.out.println("totalCount : "+totalCount);
		
	}

}
