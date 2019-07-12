package com.vision.erp.service.approval.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalDAO;
import com.vision.erp.service.approval.ApprovalService;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.humanresource.HumanResourceDAO;

@Service("approvalServiceImpl")
public class ApprovalServiceImpl implements ApprovalService {

	//field
	@Resource(name="approvalDAOImpl")
	private ApprovalDAO approvalDAO;
	@Resource(name="humanResourceDAOImpl")
	private HumanResourceDAO humanResourceDAO;
	
	//constructor
	public ApprovalServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	////////////////////////결재서/////////////////////////////
	//결재양식목록 가져오기
	@Override
	public List<ApprovalForm> getApprovalFormList() throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalFormList();
	}

	//결재양식 등록, 복제하기
	@Override
	public void addApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.insertApprovalForm(approvalForm);
	}

	//결재양식 수정하기
	@Override
	public void modifyApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.updateApprovalForm(approvalForm);
	}

	//결재양식 상세보기
	@Override
	public ApprovalForm getApprovalFormDetail(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalFormDetail(approvalFormNo);
	}

	//결재양식 삭제하기(결재서양식번호, 사용상태코드 필요)
	@Override
	public void convertApprovalFrom(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.updateApprovalFormUsageStatus(approvalForm);
	}


	///////////////////////결재///////////////////////////////
	//결재 등록하기
	@Override
	public void addApproval(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		//결재서 등록하기
		approvalDAO.insertApproval(approval);
		System.out.println("ApprovalServiceImpl.addApproval() : "+approval);
		
		//selectkey로 결재서번호 받아옴
		String approvalNo = approval.getApprovalNo();
		
		//결재서 번호에 맞는 결재자 등록하기, 화면과 연결시 ordinal 잘 들어왔는지 확인하기
		//1차결재자 등록
		//approvalDAO.insertApprover(approval.getFirstApprover().setApprovalNo(approvalNo));
		approvalDAO.insertApprover(getFullApprover(approval.getFirstApprover(), approvalNo));
		//2차결재자 등록
		switch(approval.getTotalApproverCount()) {
		case "2" :	case "3" :	case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getSecondApprover(), approvalNo));
		}
		//3차결재자 등록
		switch(approval.getTotalApproverCount()) {
		case "3" :	case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getThirdApprover(), approvalNo));
		}
		//4차결재자 등록
		switch(approval.getTotalApproverCount()) {
		case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getFourthApprover(), approvalNo));
		}
		//5차결재자 등록
		switch(approval.getTotalApproverCount()) {
		case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getFifthApprover(), approvalNo));
		}
		
		//결재서양식 사용횟수 올리기
		approvalDAO.updateApprovalFormUseCount(approval.getApprovalFormNo());
	}

	//결재목록 가져오기, SearchCondition에는 진행, 반려, 완료, 대기/ SearchKeyword에는 사원번호 들어와있는지 확인하기
	@Override
	public List<Approval> getApprovalList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalList(search);
	}

	//결재 상세보기
	@Override
	public Approval getApprovalDetail(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		//결재서 껍데기 가져오기
		Approval approval = approvalDAO.selectApprovalDetail(approvalNo);
		
		//결재자 채우기
		List<Approver> list = approvalDAO.selectApproverList(approvalNo);
		String listSize = ""+list.size();
		//1차결재자 채우기
		approval.setFirstApprover(list.get(0));
		//2차결재자 채우기
		switch(listSize) {
		case "2" :	case "3" :	case "4" :	case "5" :
			approval.setSecondApprover(list.get(1));
		}
		//3차결재자 채우기
		switch(listSize) {
		case "3" :	case "4" :	case "5" :
			approval.setThirdApprover(list.get(2));
		}
		//4차결재자 채우기
		switch(listSize) {
		case "4" :	case "5" :
			approval.setFourthApprover(list.get(3));
		}
		//5차결재자 채우기
		switch(listSize) {
		case "5" :
			approval.setFifthApprover(list.get(4));
		}
		
		return approval;
	}

	//결재자가 승인/반려하고 결재서상태 변경하기
	//결재서에 결재자까지 채워져있어야함
	@Override
	public void modifyApprovalStatus(Approval approval, String employeeNo, String approvalOrReturn) throws Exception {
		// TODO Auto-generated method stub
		//사원번호에 해당하는 사원이 몇 차 결재자인지 알아내기
		Approver approver = findApprover(approval, employeeNo);
		
		//결재서에 대한 개인의 결재상태 update하기
		approvalDAO.updateApproverStatus(approver.setApprovalStatus("1"));
		
		if(approvalOrReturn.equals("return")) {
			
			//반려일때 결재서상태변경하기(진행2, 반려3, 완료4)
			approval.setApprovalStatusCodeNo("03");
			approvalDAO.updateApprovalStatus(approval);
			
		}else if(approvalOrReturn.equals("approval")) {

			//승인 시 결재서 승인한 사람 수 업데이트하기
			approvalDAO.updateApproverCountFromApproval(approval.getApprovalNo());
			
			//승인시 결재완료인지 확인하기
			boolean complete = approvalDAO.isApprovalEnd(approval.getApprovalNo());
			if(complete) {
				//완료일 때 결재서 상태 변경하기(진행2, 반려3, 완료4)
				approval.setApprovalStatusCodeNo("04");
				approvalDAO.updateApprovalStatus(approval);
				
			}
		}
	}

	//사원번호에 해당하는 사원이 몇 차 결재자인지 알아내기
	public Approver findApprover(Approval approval, String employeeNo) throws Exception{
		
		if(employeeNo.equals(approval.getFirstApprover().getEmployeeNo())){
			return approval.getFifthApprover();
		}else if(employeeNo.equals(approval.getSecondApprover().getEmployeeNo())){
			return approval.getSecondApprover();
		}else if(employeeNo.equals(approval.getThirdApprover().getEmployeeNo())) {
			return approval.getThirdApprover();
		}else if(employeeNo.equals(approval.getFourthApprover().getEmployeeNo())) {
			return approval.getFourthApprover();
		}else if(employeeNo.equals(approval.getFifthApprover().getEmployeeNo())) {
			return approval.getFifthApprover();
		}
		
		return null;
	}
	
	//사원번호로 사원도장, 직급명 가져오기
	public Approver getFullApprover(Approver approver, String approvalNo) throws Exception {
		System.out.println("ApprovalServiceImpl.getFullApprover() 사원번호 : "+Integer.parseInt(approver.getEmployeeNo()));
		SimpleHumanResourceCard shrc = humanResourceDAO.selectSimpleHumanResourceCardByEmployeeNo(approver.getEmployeeNo());
		System.out.println("ApprovalServiceImpl.getFullApprover() 인사카드 : "+shrc);
		approver.setEmployeeRankCodeName(shrc.getRankCodeName());
		approver.setEmployeeSignatureImage(shrc.getSignatureImage());
		
		return approver.setApprovalNo(approvalNo);
	}
}
