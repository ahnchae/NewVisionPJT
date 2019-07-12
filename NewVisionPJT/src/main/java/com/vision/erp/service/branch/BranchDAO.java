package com.vision.erp.service.branch;

import java.util.List;

import com.vision.erp.service.domain.BranchDailySales;
import com.vision.erp.service.domain.SalesMenu;
import com.vision.erp.service.domain.SalesProduct;

public interface BranchDAO {
	
	public void insertDailySales(SalesProduct salesProduct) throws Exception;
	
	public List<SalesProduct> selectDailySalesDetail(String branchNo, String salesDate) throws Exception;
	
	public List<BranchDailySales> selectDailySalesList(String branchNo) throws Exception;
	
	public void updateSalesProduct(SalesProduct salesProduct) throws Exception;
	
	public List<SalesMenu> selectSalesMenuList() throws Exception;

}
