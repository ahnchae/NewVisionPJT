package com.vision.erp.service.approval;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;

public interface ApprovalService {
	
	////////////////////////결재서/////////////////////////////
	//결재양식목록 가져오기
	public List<ApprovalForm> getApprovalFormList() throws Exception;
	
	//결재양식 등록, 복제하기
	public void addApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//결재양식 수정하기
	public void modifyApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//결재양식 상세보기
	public ApprovalForm getApprovalFormDetail(String approvalFormNo) throws Exception;
	
	//결재양식 삭제하기
	public void convertApprovalFrom(ApprovalForm approvalForm) throws Exception;
	

	///////////////////////결재///////////////////////////////
	//결재 등록하기
	public void addApproval(Approval approval) throws Exception;
	
	//결재목록 가져오기
	public List<Approval> getApprovalList(Search search) throws Exception;
	
	//결재 상세보기
	public Approval getApprovalDetail(String approvalNo) throws Exception;
	
	//결재자가 승인/반려하고 결재서상태 변경하기
	//결재서에 결재자까지 채워져있어야함
	public void modifyApprovalStatus(Approval approval, String employeeNo, String approvalOrReturn) throws Exception;
	
}
