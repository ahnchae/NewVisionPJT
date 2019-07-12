package com.vision.erp.service.accounting.impl;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingDAO;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.Card;
import com.vision.erp.service.domain.Salary;
import com.vision.erp.service.domain.Statement;
import com.vision.erp.service.domain.Vendor;

public class AccountingDAOImpl implements AccountingDAO {

	@Override
	public void insertVendor(Vendor vendor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendor selectVendorDetail(String vendorNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVendor(Vendor vendor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVendorUsageStatus(String vendorUsageStatusCodeNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendor> selectVendorList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account selectAccountDetail(String accountRegNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(Account account) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountUsageStatus(String accountUsageStatusCodeNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> selectAccountList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account checkDuplicateAccount(String accountNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salary selectSalaryDetail(String salaryNumbering) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSalary(Salary salary) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalaryStatus(String salaryStatusCodeNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Salary> selectSalaryList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> calculateSalary(String salaryDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salary checkDuplicateSalaryDate(String salaryDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salary selectSalaryBookList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStatement(Statement statement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statement selectStatementDetail(String statementNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatement(Statement statement) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatementUsageStatus(String statementUsageStatusCodeNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Statement> selectStatementList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCard(Card card) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card selectCardDetail(String cardRegNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCard(Card card) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCardUsageStatus(String cardUsageStatusCodeNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> selectCardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account checkDuplicateCard(String cardNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
