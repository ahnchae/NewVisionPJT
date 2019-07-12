package com.vision.erp.service.branch;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Branch;

public interface BranchDAO {
	
	public void insertBranch(Branch branch) throws Exception;
	
	public Branch selectBranchDetail(String branchNo) throws Exception;
	
	public void updateBranch(String branchNo) throws Exception;
	
	public void updateBranchUsageStatus(String branchNo) throws Exception;
	
	public List<Branch> selectBranchList(Search saerch) throws Exception;

}
