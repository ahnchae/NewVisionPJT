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
	private SqlSession sqlsession;

	@Override
	public void insertBranch(Branch branch) throws Exception {
		sqlsession.insert("BranchMapper.insertBranch", branch);				
	}

	@Override
	public Branch selectBranchDetail(String branchNo) throws Exception {
		System.out.println("yyyyselectBranchDetail");
		return sqlsession.selectOne("BranchMapper.selectBranchDetail",branchNo);
	}

	@Override
	public void updateBranchUsageStatus(String branchNo) throws Exception {
		sqlsession.update("BranchMapper.updateBranchUsageCode", branchNo);
	}

	@Override
	public void updateBranch(String branchNo) throws Exception {
		sqlsession.update("BranchMapper.updateBranch", branchNo);		
	}

	@Override
	public List<Branch> selectBranchList(Search saerch) throws Exception {
		System.out.println("ttttselectBranchList");
		return sqlsession.selectList("BranchMapper.selectBranchList");
	}

}
