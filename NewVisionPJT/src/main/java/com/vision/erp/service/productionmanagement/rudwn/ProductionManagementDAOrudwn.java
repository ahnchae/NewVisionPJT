package com.vision.erp.service.productionmanagement.rudwn;

import java.util.List;

import com.vision.erp.service.domain.Product;

public interface ProductionManagementDAOrudwn {
	
	public void addProduct(Product product)throws Exception;
	
	public void updateProduct(Product product)throws Exception;
	
	public void updateUsageStatus(Product product)throws Exception;
	
	public List<Product> selectProductList() throws Exception;
	
	public Product selectDetailProduct(String productNo) throws Exception;

}
