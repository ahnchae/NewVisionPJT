package com.vision.erp.service.businesssupport.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.businesssupport.BusinessSupportDAO;
import com.vision.erp.service.domain.Branch;

@Repository("businessSupportDAOImpl")
public class BusinessSupportDAOImpl implements BusinessSupportDAO {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public String insertBranch(Branch branch) throws Exception {
		sqlSession.insert("BranchMapper.insertBranch", branch);
		System.out.println("Branch SelectKey : "+branch.getBranchNo());
		return branch.getBranchNo();
	}

	@Override
	public Branch selectBranchDetail(String branchNo) throws Exception {
		return sqlSession.selectOne("BranchMapper.selectBranchDetail",branchNo);
	}

	@Override
	public void updateBranchUsageStatus(Branch branch) throws Exception {
		sqlSession.update("BranchMapper.updateBranchUsageCode", branch);
	}

	@Override
	public void updateBranch(Branch branch) throws Exception {
		sqlSession.update("BranchMapper.updateBranch", branch);		
	}

	@Override
	public List<Branch> selectBranchList(Search saerch) throws Exception {
		return sqlSession.selectList("BranchMapper.selectBranchList");
	}

	@Override
	public int selectTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("BranchMapper.selectTotalCount", search);
	}

}
