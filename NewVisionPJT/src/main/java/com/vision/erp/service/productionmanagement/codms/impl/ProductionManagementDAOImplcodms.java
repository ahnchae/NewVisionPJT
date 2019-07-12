package com.vision.erp.service.productionmanagement.codms.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.codms.ProductionManagementDAOcodms;

@Repository("productionManagementDAOImplcodms")
public class ProductionManagementDAOImplcodms implements ProductionManagementDAOcodms {
	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	//[지점]주문요청-주문서등록
	@Override
	public int insertOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("OrderFromBranchMapper.insertOrderFromBranch", orderFromBranch);
	}

	//[지점]주문요청-주문물품등록
	@Override
	public int insertOrderFromBranchProduct(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("OrderFromBranchMapper.insertOrderFromBranchProduct", orderFromBranchProduct);
	}

	//[본사, 지점]주문서상태변경(주문취소요청, 주문취소확정, 주문완료)
	@Override
	public int updateOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("OrderFromBranchMapper.updateOrderFromBranchStatus", orderFromBranch);
	}

	//[본사, 지점]주문서리스트 가져오기(주문물품 채워서) 지점번호 searchKeyword에 채우기
	@Override
	public List<OrderFromBranch> selectOrderFromBranchList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderFromBranchMapper.selectOrderFromBranch", search);
	}

	//[본사]주문물품 상태변경(출하완료, 출하대기, 출하취소)
	@Override
	public int updateOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("OrderFromBranchMapper.updateOrderFromBranchProductStatus", orderFromBranchProduct);
	}

	//[본사]주문물품 모두 출하완료인지 확인, 출하대기인 상품개수 return
	@Override
	public int selectOrderFromBranchProduct(String orderFromBranchNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("OrderFromBranchMapper.selectOrderFromBranchProduct", orderFromBranchNo).size();
	}

	//[본사, 지점]주문서 상세보기
	@Override
	public OrderFromBranch selectOrderFromBranchDetail(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("OrderFromBranchMapper.selectOrderFromBranchDetail", search);
	}

	
}
