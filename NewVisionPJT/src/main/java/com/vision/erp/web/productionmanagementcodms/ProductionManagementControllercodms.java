package com.vision.erp.web.productionmanagementcodms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.productionmanagement.codms.ProductionManagementServicecodms;
import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementServicerudwn;

@RestController
public class ProductionManagementControllercodms {

	//field
	@Resource(name = "productionManagementServiceImplcodms")
	private ProductionManagementServicecodms codmsService;
	
//	@Resource(name = "productionManagementServiceImplrudwn")
	private ProductionManagementServicerudwn rudwnService;
	
//	@Resource(name = "accountingServiceImpl")
//	private AccountingServiceImpl accountingService;


	//constructor
	public ProductionManagementControllercodms() {
		super();
		// TODO Auto-generated constructor stub
	}

	//method
	//[주문서목록조회] - 주문서 목록조회(지점, 본사) SearchKeyword에 지점번호
	@RequestMapping(value="/pm/getOrderFromBranchList")
	public List<OrderFromBranch> getOrderFromBranchList(@RequestBody Search search) throws Exception{
		return codmsService.getOrderFromBranchList(search);
	}
	
	//[주문서목록조회] - 주문서 상세조회(지점, 본사) SearchKeyword에 주문서번호
	@RequestMapping(value="/pm/getOrderFromBranchDetail")
	public OrderFromBranch getOrderFromBranchDetail(@RequestBody Search search) throws Exception{
		return codmsService.getOrderFromBranchDetail(search);
	}
	
	//[주문서목록조회] - 주문취소/취소확정(지점, 본사) 
	//주문서번호, 주문서상태코드 (주문대기01, 주문완료02, 주문진행03, 취소요청04, 취소확정05) 필요
	@RequestMapping(value="/pm/modifyOrderFromBranchStatus")
	public void modifyOrderFromBranchStatus(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
		codmsService.modifyOrderFromBranchStatus(orderFromBranch);
	}
	
	//[주문요청] - 준비화면 띄우기 : 계좌번호 가져오기, 물품목록 가져오기
	@RequestMapping(value="/pm/addOrderFromBranchPreparing")
	public Map addOrderFromBranchPreparing() throws Exception{
		Map map = new HashMap();
		//물품목록 가져오기
//		map.put("productList", rudwnService.getProductList());
		
		//계좌번호 가져오기
		Search search = new Search();
		//계좌 사용처 02주문
//		search.setSearchKeyword("02");
//		map.put("accountList", accountService.getAccountList(search));
		
		return map;
	}
	
	//[주문요청] - 주문하기
	//branchNo, orderDate, orderFromBranchProductList(productNo, orderFromBranchProductQuantity) 필요
	@RequestMapping(value="/pm/addOrderFromBranch")
	public void addOrderFromBranch(@RequestBody OrderFromBranch orderFromBranch) throws Exception{
		codmsService.addOrderFromBranch(orderFromBranch);
	}
	
	//[주문서상세조회] - 주문물품 상태변경(출하완료02)
	//orderFromBranchNo, productNo 필요
	@RequestMapping(value=" /pm/modifyOrderFromBranchProductStatus")
	public void modifyOrderFromBranchProductStatus(@RequestBody OrderFromBranchProduct orderFromBranchProduct) throws Exception{
		codmsService.modifyOrderFromBranchProductStatus(orderFromBranchProduct);
	}
}
