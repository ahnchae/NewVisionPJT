package com.vision.erp.service.productionmanagement.codms;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;

public interface ProductionManagementDAOcodms {
	//[지점]주문요청-주문서등록
	public int insertOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception;
	
	//[지점]주문요청-주문물품등록
	public int insertOrderFromBranchProduct(OrderFromBranchProduct orderFromBranchProduct) throws Exception;
		
	//[본사, 지점]주문서상태변경(주문취소요청, 주문취소확정, 주문완료)
	public int updateOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception;
	
	//[본사, 지점]주문서리스트 가져오기(주문물품 채워서) 지점번호 searchKeyword에 채우기
	public List<OrderFromBranch> selectOrderFromBranchList(Search search) throws Exception;
	
	//[본사, 지점]주문서 상세보기
	public OrderFromBranch selectOrderFromBranchDetail(Search search) throws Exception;
	
	//[본사]주문물품 상태변경(출하완료, 출하대기, 출하취소)
	public int updateOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception;
	
	//[본사]주문물품 모두 출하완료인지 확인, 출하대기인 상품개수 return
	public int selectOrderFromBranchProduct(String orderFromBranchNo) throws Exception;
	
}
