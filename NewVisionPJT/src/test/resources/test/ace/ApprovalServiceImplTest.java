package test.ace;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalService;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})

public class ApprovalServiceImplTest{

	@Resource(name = "approvalServiceImpl")
	private ApprovalService approvalService;
	
	////////////////////////결재서/////////////////////////////
	//결재양식목록 가져오기
	//@Test
	public void getApprovalFormListTest() throws Exception{
		List<ApprovalForm> list = approvalService.getApprovalFormList();
		for(ApprovalForm af : list) {
			System.out.println(af);
		}
	}
	
	//결재양식 등록, 복제하기
	//@Test
	public void addApprovalFormTest() throws Exception{
		ApprovalForm af = new ApprovalForm("시말서", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">시말서</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">소속</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">직위</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">성명</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">내용</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">년 월 일</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">위원인 :&nbsp;</td> </tr> </tbody> </table>", "1001", "안채은");
		approvalService.addApprovalForm(af);
	}
	
	//결재양식 수정하기
	//@Test
	public void modifyApprovalFormTest() throws Exception{
		ApprovalForm af = new ApprovalForm("기본기안서", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">기본기안서</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">협의</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">제목</td> <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">내용</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 66.0pt;\" colspan=\"4\" rowspan=\"4\" height=\"88\">&nbsp;</td> </tr> </tbody> </table>", "1001", "안채은");
		af.setApprovalFormNo("10001");
		approvalService.modifyApprovalForm(af);
	}
	
	//결재양식 상세보기
	//@Test
	public void getApprovalFormDetailTest() throws Exception{
		ApprovalForm af = approvalService.getApprovalFormDetail("10001");
		System.out.println(af);
	}
	
	//결재양식 삭제하기(결재서양식번호, 사용상태코드 필요)
	//@Test
	public void convertApprovalFromTest() throws Exception{
		ApprovalForm af = new ApprovalForm();
		af.setApprovalFormUsageStatusCodeNo("02");
		af.setApprovalFormNo("10020");
		approvalService.convertApprovalFrom(af);
	}
	
	///////////////////////결재///////////////////////////////
	//결재 등록하기
	//테스트 미완성 humanResourceCard 수정 후 다시 확인
	//@Test
	public void addApprovalTest() throws Exception{
		Approval approval = new Approval("안채은_시말서", "<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspa<table style=\"width: 216pt;\" border=\"0\" width=\"288\" cellspacing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">시말서</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">협의</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">제송함다</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt; width: 70.2188px;\" height=\"22\">제목</td> <td class=\"xl63\" style=\"width: 189.219px;\" colspan=\"3\">젭라조퇴ㅜ</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">내용</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 273.219px;\" colspan=\"4\" height=\"22\">중포여도 됩니당.... 하지만 진심은 아니에여</td> </tr> </tbody> </table> <p>&nbsp;</p>cing=\"0\" cellpadding=\"0\"><colgroup><col style=\"width: 54pt;\" span=\"4\" width=\"72\" /> </colgroup> <tbody> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt; width: 216pt;\" colspan=\"4\" width=\"288\" height=\"22\">기본기안서</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">협의</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td style=\"height: 16.5pt;\" height=\"22\">제목</td> <td class=\"xl63\" colspan=\"3\">&nbsp;</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">내용</td> </tr> <tr style=\"height: 16.5pt;\"> <td class=\"xl63\" style=\"height: 16.5pt;\" colspan=\"4\" height=\"22\">&nbsp;</td> </tr> </tbody> </table>", "10001", "02", "1");
		Approver first = new Approver();
		first.setOrdinal("0");
		first.setEmployeeNo("1001");
		Approver second = new Approver();
		second.setOrdinal("1");
		second.setEmployeeNo("1002");
		Approver third = new Approver();
		third.setOrdinal("2");
		third.setEmployeeNo("1000");
		approval.setFirstApprover(first);
		approval.setSecondApprover(second);
		approval.setThirdApprover(third);
		approval.setApprovalFormNo("10022");
		
		approvalService.addApproval(approval);
	}

	//결재목록 가져오기, SearchCondition에는 진행2, 반려3, 완료4, 대기도 02/ SearchKeyword에는 사원번호 들어와있는지 확인하기
	//@Test
	public void getApprovalListTest() throws Exception{
		Search search = new Search();
		search.setSearchKeyword("1000");
		search.setSearchCondition("1");
		List<Approval> list = approvalService.getApprovalList(search);
		for(Approval ap : list) {
			System.out.println(ap);
		}
	}
	
	//결재 상세보기
	//@Test
	public void getApprovalDetailTest() throws Exception{
		Approval approval = approvalService.getApprovalDetail("10022");
		System.out.println(approval);
	}
	
	//결재자가 승인/반려하고 결재서상태 변경하기
	//결재서에 결재자까지 채워져있어야함
	//@Test
	public void modifyApprovalStatusTest() throws Exception{
		Approval approval = approvalService.getApprovalDetail("10022");
		approvalService.modifyApprovalStatus(approval, "1002", "approval");
	}
	
	
}