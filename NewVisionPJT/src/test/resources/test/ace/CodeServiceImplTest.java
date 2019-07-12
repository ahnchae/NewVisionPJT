package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeService;
import com.vision.erp.service.domain.Code;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class CodeServiceImplTest{

	@Resource(name = "codeServiceImpl")
	private CodeService codeService;
	
	//@Test
	public void getGroupCodeListTest() throws Exception{
		List<Code> list = codeService.getGroupCodeList();
		for(Code code : list) {
			System.out.println(code);
		}
		System.out.println("CodeServiceImplTest.getGroupCodeListTest() 완료");
	}
	
	//@Test
	public void addCodeTest() throws Exception{
		Code code = new Code("test", "테스트", "02", "테스트02", "Y");
		codeService.addCode(code);
		System.out.println("CodeServiceImplTest.addCodeTest() 완료");
	}
	
	//@Test
	public void getCodeList() throws Exception{
		Search search = new Search();
		search.setSearchCondition("0");
		search.setSearchKeyword("depart");
		List<Code> list = codeService.getCodeList(search);
		for(Code code : list) {
			System.out.println(code);
		}
		System.out.println("CodeServiceImplTest.getCodeList() 완료");
	}
	
	//@Test
	public void modifyCodeTest() throws Exception{
		Code code = new Code("test", "테스트", "02", "테스트02수정", "Y");
		codeService.modifyCode(code);
		System.out.println("CodeServiceImplTest.modifyCodeTest() 완료");
	}
	
	@Test
	public void checkDuplicateCodeTest() throws Exception{
		Code code = new Code("test", "테스트", "02", "테스트02수정", "Y");
		Code resultCode = codeService.checkDuplicateCodeNo(code);
		System.out.println(resultCode);
		System.out.println("CodeServiceImplTest.checkDuplicateCodeTest() 완료");
	}
	
	
}