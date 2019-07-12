package com.vision.erp.service.approval;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

public interface ApprovalDAO {

	/////////////////////결재서양식//////////////////////////
	//결재서양식 리스트 가져오기
	public List<ApprovalForm> selectApprovalFormList() throws Exception;
	
	//결재서양식 등록하기, 복제하기
	public int insertApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//결재서양식 수정하기
	public int updateApprovalForm(ApprovalForm approvalForm) throws Exception;
	
	//결재서양식 상세보기
	public ApprovalForm selectApprovalFormDetail(String approvalFormNo) throws Exception;
	
	//결재서양식 삭제하기
	public int updateApprovalFormUsageStatus(ApprovalForm approvalForm) throws Exception;

	//결재서양식 useCount 올리기
	public int updateApprovalFormUseCount(String approvalFormNo) throws Exception;
	
	/////////////////////결재/////////////////////////////
	//결재상신
	public int insertApproval(Approval approval) throws Exception;
	
	//결재자 등록하기
	public int insertApprover(Approver approver) throws Exception;
	
	//결재자 가져오기
	public List<Approver> selectApproverList(String approvalNo) throws Exception;
	
	//결재목록 가져오기(진행2, 반려3, 완료4, 대기도 02 다만 자기차례일뿐)
	public List<Approval> selectApprovalList(Search search) throws Exception;
	
	//결재서 상세보기
	public Approval selectApprovalDetail(String approvalNo) throws Exception;
	
	//결재서상태 변경하기(진행, 완료, 반려)
	public int updateApprovalStatus(Approval approval) throws Exception;
	
	//결재자의 결재상태 변경하기(미완0, 결재1)
	public int updateApproverStatus(Approver approver) throws Exception;
	
	//승인한결재자수 변경하기
	public int updateApproverCountFromApproval(String approvalNo) throws Exception;
	
	//결재 완료할 수 있는지 확인하기(승인한결재자=총결재자수)
	public boolean isApprovalEnd(String approvalNo) throws Exception;
}
