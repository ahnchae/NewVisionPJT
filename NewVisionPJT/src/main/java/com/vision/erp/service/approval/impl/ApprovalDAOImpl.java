package com.vision.erp.service.approval.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalDAO;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;

@Repository("approvalDAOImpl")
public class ApprovalDAOImpl implements ApprovalDAO {
	
	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//constructor
	public ApprovalDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/////////////////////결재서양식//////////////////////////
	//결재서양식 리스트 가져오기
	@Override
	public List<ApprovalForm> selectApprovalFormList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalFormMapper.selectApprovalFormList");
	}

	//결재서양식 등록하기, 복제하기
	@Override
	public int insertApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("ApprovalFormMapper.insertApprovalForm", approvalForm);
	}

	//결재서양식 수정하기
	@Override
	public int updateApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalForm", approvalForm);
	}

	//결재서양식 상세보기
	@Override
	public ApprovalForm selectApprovalFormDetail(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ApprovalFormMapper.selectApprovalFormDetail", approvalFormNo);
	}

	//결재서양식 삭제하기
	@Override
	public int updateApprovalFormUsageStatus(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalFormUsageStatus", approvalForm);
	}

	//결재서양식 useCount 올리기
	@Override
	public int updateApprovalFormUseCount(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalFormMapper.updateApprovalFormUseCount", approvalFormNo);
	}

	
	/////////////////////결재/////////////////////////////
	//결재상신
	@Override
	public int insertApproval(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(approval);
		return sqlSession.insert("ApprovalMapper.insertApproval", approval);
	}

	//결재자 등록하기
	@Override
	public int insertApprover(Approver approver) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("ApprovalMapper.insertApprover", approver);
	}

	//결재자 가져오기
	@Override
	public List<Approver> selectApproverList(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalMapper.selectApproverList", approvalNo);
	}

	//결재목록 가져오기(진행2, 반려3, 완료4, 대기도 02 다만 자기차례일뿐)
	@Override
	public List<Approval> selectApprovalList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ApprovalMapper.selectApprovalList", search);
	}

	//결재서 상세보기
	@Override
	public Approval selectApprovalDetail(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ApprovalMapper.selectApprovalDetail", approvalNo);
	}

	//결재서상태 변경하기(진행, 완료, 반려)
	@Override
	public int updateApprovalStatus(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApprovalStatus", approval);
	}

	//결재자의 결재상태 변경하기(미완0, 승인1)
	@Override
	public int updateApproverStatus(Approver approver) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApproverStatus", approver);
	}
	
	//승인한결재자수 변경하기
	@Override
	public int updateApproverCountFromApproval(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ApprovalMapper.updateApproverCountFromApproval", approvalNo);
	}

	//결재 완료할 수 있는지 확인하기(승인한결재자=총결재자수)
	@Override
	public boolean isApprovalEnd(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		Approval approval = selectApprovalDetail(approvalNo);
		if(approval.getApproverCount().equals(approval.getTotalApproverCount())) {
			return true;
		}
		return false;
	}
	

}
