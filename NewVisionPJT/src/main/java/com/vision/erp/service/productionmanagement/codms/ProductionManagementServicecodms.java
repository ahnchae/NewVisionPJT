package com.vision.erp.service.productionmanagement.codms;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;

public interface ProductionManagementServicecodms {
	
	//[지점] 주문서등록
	public void addOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception;
	
	//[본사, 지점]주문서상태변경(주문취소요청, 주문취소확정, 주문완료), 주문취소확정시 주문물품상태 출하취소로 변경
	public void modifyOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception;
	
	//[본사, 지점]주문서리스트 가져오기(주문물품 채워서) 지점번호 searchKeyword에 채우기
	public List<OrderFromBranch> getOrderFromBranchList(Search search) throws Exception;
	
	//[본사, 지점]주문서 상세보기
	public OrderFromBranch getOrderFromBranchDetail(Search search) throws Exception;
	
	//[본사] 주문물품 상태변경(출하완료, 출하대기, 출하취소)
	public void modifyOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception;
	
}
