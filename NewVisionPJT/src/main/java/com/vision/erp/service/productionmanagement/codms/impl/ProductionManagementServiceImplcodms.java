package com.vision.erp.service.productionmanagement.codms.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingDAO;
import com.vision.erp.service.domain.OrderFromBranch;
import com.vision.erp.service.domain.OrderFromBranchProduct;
import com.vision.erp.service.domain.Product;
import com.vision.erp.service.domain.Statement;
import com.vision.erp.service.productionmanagement.codms.ProductionManagementDAOcodms;
import com.vision.erp.service.productionmanagement.codms.ProductionManagementServicecodms;
import com.vision.erp.service.productionmanagement.rudwn.ProductionManagementDAOrudwn;

@Service("productionManagementServiceImplcodms")
public class ProductionManagementServiceImplcodms implements ProductionManagementServicecodms {

	//field
	@Resource(name="productionManagementDAOImplcodms")
	private ProductionManagementDAOcodms productionManagementDAOcodms;
	
	@Resource(name="productionManagementDAOImplrudwn")
	private ProductionManagementDAOrudwn productionManagementDAOrudwn;
	
	//@Resource(name="accountingDAOImpl")
	private AccountingDAO accountingDAO;
	
	//[지점] 주문서등록
	@Override
	public void addOrderFromBranch(OrderFromBranch orderFromBranch) throws Exception {
		
		//물건 가격 계산하고 주문서에 저장하기
		List<OrderFromBranchProduct> finalList = new ArrayList<OrderFromBranchProduct>(); 
		int orderFromBranchTotalAmount = 0;
		for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
			OrderFromBranchProduct resultOp = calculateOrderFromBranchProduct(op);
			finalList.add(resultOp);
			orderFromBranchTotalAmount += Integer.parseInt(op.getPrice());
		}
		orderFromBranch.setOrderFromBranchProductList(finalList);
		orderFromBranch.setOrderFromBranchTotalAmount(""+orderFromBranchTotalAmount);
		
		//전표등록하고 주문서에 전표번호 저장하기
		orderFromBranch.setStatementNo(addStatement(orderFromBranch).getStatementNo());
		
		//주문서 등록
		//지점번호, 전표번호, 총가격이 있어야함
		productionManagementDAOcodms.insertOrderFromBranch(orderFromBranch);
		
		//주문물품 등록
		//주문서번호, 물품번호, 수량, 가격, 금액이 있어야함
		for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
			productionManagementDAOcodms.insertOrderFromBranchProduct(op.setOrderFromBranchNo(orderFromBranch.getOrderFromBranchNo()));
		}
		
	}
	
	//[본사, 지점]주문서상태변경(주문대기01, 주문완료02, 주문진행03, 취소요청04, 취소확정05)
	@Override
	public void modifyOrderFromBranchStatus(OrderFromBranch orderFromBranch) throws Exception {
		//주문서상태 변경하기
		productionManagementDAOcodms.updateOrderFromBranchStatus(orderFromBranch);
		
		//주문취소시 주문물품 출하철회하기
		if(orderFromBranch.getOrderFromBranchStatusCodeNo()=="04") {
			for(OrderFromBranchProduct op : orderFromBranch.getOrderFromBranchProductList()) {
				//주문물품상태(출하대기01, 출하완료02, 출하철회03)
				op.setOrderFromBranchProductStatusCodeNo("03");
				productionManagementDAOcodms.updateOrderFromBranchProductStatus(op);
			}
		}
	}

	//[본사, 지점]주문서리스트 가져오기(주문물품 채워서) 지점번호 searchKeyword에 채우기
	@Override
	public List<OrderFromBranch> getOrderFromBranchList(Search search) throws Exception {
		return productionManagementDAOcodms.selectOrderFromBranchList(search);
	}

	//[본사, 지점]주문서 상세보기
	@Override
	public OrderFromBranch getOrderFromBranchDetail(Search search) throws Exception {
		// TODO Auto-generated method stub
		return productionManagementDAOcodms.selectOrderFromBranchDetail(search);
	}

	//[본사] 주문물품 상태변경(출하대기01, 출하완료02, 출하철회03)
	//주문서번호, 물품번호 있어야함
	@Override
	public void modifyOrderFromBranchProductStatus(OrderFromBranchProduct orderFromBranchProduct) throws Exception {
		// TODO Auto-generated method stub
		//물품상태변경하기
		productionManagementDAOcodms.updateOrderFromBranchProductStatus(orderFromBranchProduct);
		
		//주문서의 물품이 전부 출하완료라면 주문서상태 변경
		if(orderFromBranchProduct.getOrderFromBranchProductStatusCodeNo().equals("02")) {
			int notDeliveredYet = productionManagementDAOcodms.selectOrderFromBranchProduct(orderFromBranchProduct.getOrderFromBranchNo());
			if(notDeliveredYet==0) {
				OrderFromBranch ob = new OrderFromBranch();
				ob.setOrderFromBranchStatusCodeNo("02");
				ob.setOrderFromBranchNo(orderFromBranchProduct.getOrderFromBranchNo());
				productionManagementDAOcodms.updateOrderFromBranchStatus(ob);
			}
		}
	}

	//주문물품 금액 계산하기
	private OrderFromBranchProduct calculateOrderFromBranchProduct(OrderFromBranchProduct op) throws Exception{
		Product product = productionManagementDAOrudwn.selectDetailProduct(op.getProductNo());
		op.setPrice(product.getSalesPrice());
		op.setOrderFromBranchProductAmount(""+(Integer.parseInt(product.getSalesPrice())*Integer.parseInt(op.getOrderFromBranchProductAmount())));
		return op;
	}
	
	//전표 등록하기
	private Statement addStatement(OrderFromBranch orderFromBranch) throws Exception {
		Statement statement = new Statement();
		statement.setTradeDate(orderFromBranch.getOrderDate());
		statement.setTradeTargetName(orderFromBranch.getBranchName());
		statement.setStatementCategoryCodeNo("01");
		statement.setStatementDetail("주문");
		statement.setAccountNo(orderFromBranch.getAccountNo());
		statement.setTradeAmount(orderFromBranch.getOrderFromBranchTotalAmount());
		accountingDAO.insertStatement(statement);
		
		return statement;
	}
}
