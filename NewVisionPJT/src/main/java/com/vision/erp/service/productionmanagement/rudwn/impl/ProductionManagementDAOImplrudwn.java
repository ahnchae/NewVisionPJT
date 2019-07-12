package com.vision.erp.service.productionmanagement.rudwn.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vision.erp.service.domain.Product;
import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementDAOrudwn;


@Repository
public class ProductionManagementDAOImplrudwn implements ProductionManagementDAOrudwn {

	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	public void addProduct(Product product) throws Exception {
		sqlSession.insert("ProductMapper.insertProduct", product);
		
	}

	@Override
	public Product selectDetailProduct(String productNo) throws Exception {
		
		return sqlSession.selectOne("ProductMapper.selectDetailProduct", productNo);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", product);
		
	}

	@Override
	public void updateUsageStatus(Product product) throws Exception {
		sqlSession.update("ProductMapper.updateUsageStatus", product);
		
	}

	@Override
	public List<Product> selectProductList() throws Exception {
		
		return sqlSession.selectList("ProductMapper.selectproductList");
	}

}
