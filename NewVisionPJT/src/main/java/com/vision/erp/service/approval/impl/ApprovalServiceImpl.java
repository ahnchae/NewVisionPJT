package com.vision.erp.service.approval.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.approval.ApprovalDAO;
import com.vision.erp.service.approval.ApprovalService;
import com.vision.erp.service.domain.Approval;
import com.vision.erp.service.domain.ApprovalForm;
import com.vision.erp.service.domain.Approver;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.humanresource.HumanResourceDAO;

@Service("approvalServiceImpl")
public class ApprovalServiceImpl implements ApprovalService {

	//field
	@Resource(name="approvalDAOImpl")
	private ApprovalDAO approvalDAO;
	@Resource(name="humanResourceDAOImpl")
	private HumanResourceDAO humanResourceDAO;
	
	//constructor
	public ApprovalServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	////////////////////////���缭/////////////////////////////
	//�����ĸ�� ��������
	@Override
	public List<ApprovalForm> getApprovalFormList() throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalFormList();
	}

	//������ ���, �����ϱ�
	@Override
	public void addApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.insertApprovalForm(approvalForm);
	}

	//������ �����ϱ�
	@Override
	public void modifyApprovalForm(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.updateApprovalForm(approvalForm);
	}

	//������ �󼼺���
	@Override
	public ApprovalForm getApprovalFormDetail(String approvalFormNo) throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalFormDetail(approvalFormNo);
	}

	//������ �����ϱ�(���缭��Ĺ�ȣ, �������ڵ� �ʿ�)
	@Override
	public void convertApprovalFrom(ApprovalForm approvalForm) throws Exception {
		// TODO Auto-generated method stub
		approvalDAO.updateApprovalFormUsageStatus(approvalForm);
	}


	///////////////////////����///////////////////////////////
	//���� ����ϱ�
	@Override
	public void addApproval(Approval approval) throws Exception {
		// TODO Auto-generated method stub
		//���缭 ����ϱ�
		approvalDAO.insertApproval(approval);
		System.out.println("ApprovalServiceImpl.addApproval() : "+approval);
		
		//selectkey�� ���缭��ȣ �޾ƿ�
		String approvalNo = approval.getApprovalNo();
		
		//���缭 ��ȣ�� �´� ������ ����ϱ�, ȭ��� ����� ordinal �� ���Դ��� Ȯ���ϱ�
		//1�������� ���
		//approvalDAO.insertApprover(approval.getFirstApprover().setApprovalNo(approvalNo));
		approvalDAO.insertApprover(getFullApprover(approval.getFirstApprover(), approvalNo));
		//2�������� ���
		switch(approval.getTotalApproverCount()) {
		case "2" :	case "3" :	case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getSecondApprover(), approvalNo));
		}
		//3�������� ���
		switch(approval.getTotalApproverCount()) {
		case "3" :	case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getThirdApprover(), approvalNo));
		}
		//4�������� ���
		switch(approval.getTotalApproverCount()) {
		case "4" :	case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getFourthApprover(), approvalNo));
		}
		//5�������� ���
		switch(approval.getTotalApproverCount()) {
		case "5" :
			approvalDAO.insertApprover(getFullApprover(approval.getFifthApprover(), approvalNo));
		}
		
		//���缭��� ���Ƚ�� �ø���
		approvalDAO.updateApprovalFormUseCount(approval.getApprovalFormNo());
	}

	//������ ��������, SearchCondition���� ����, �ݷ�, �Ϸ�, ���/ SearchKeyword���� �����ȣ �����ִ��� Ȯ���ϱ�
	@Override
	public List<Approval> getApprovalList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return approvalDAO.selectApprovalList(search);
	}

	//���� �󼼺���
	@Override
	public Approval getApprovalDetail(String approvalNo) throws Exception {
		// TODO Auto-generated method stub
		//���缭 ������ ��������
		Approval approval = approvalDAO.selectApprovalDetail(approvalNo);
		
		//������ ä���
		List<Approver> list = approvalDAO.selectApproverList(approvalNo);
		String listSize = ""+list.size();
		//1�������� ä���
		approval.setFirstApprover(list.get(0));
		//2�������� ä���
		switch(listSize) {
		case "2" :	case "3" :	case "4" :	case "5" :
			approval.setSecondApprover(list.get(1));
		}
		//3�������� ä���
		switch(listSize) {
		case "3" :	case "4" :	case "5" :
			approval.setThirdApprover(list.get(2));
		}
		//4�������� ä���
		switch(listSize) {
		case "4" :	case "5" :
			approval.setFourthApprover(list.get(3));
		}
		//5�������� ä���
		switch(listSize) {
		case "5" :
			approval.setFifthApprover(list.get(4));
		}
		
		return approval;
	}

	//�����ڰ� ����/�ݷ��ϰ� ���缭���� �����ϱ�
	//���缭�� �����ڱ��� ä�����־����
	@Override
	public void modifyApprovalStatus(Approval approval, String employeeNo, String approvalOrReturn) throws Exception {
		// TODO Auto-generated method stub
		//�����ȣ�� �ش��ϴ� ����� �� �� ���������� �˾Ƴ���
		Approver approver = findApprover(approval, employeeNo);
		
		//���缭�� ���� ������ ������� update�ϱ�
		approvalDAO.updateApproverStatus(approver.setApprovalStatus("1"));
		
		if(approvalOrReturn.equals("return")) {
			
			//�ݷ��϶� ���缭���º����ϱ�(����2, �ݷ�3, �Ϸ�4)
			approval.setApprovalStatusCodeNo("03");
			approvalDAO.updateApprovalStatus(approval);
			
		}else if(approvalOrReturn.equals("approval")) {

			//���� �� ���缭 ������ ��� �� ������Ʈ�ϱ�
			approvalDAO.updateApproverCountFromApproval(approval.getApprovalNo());
			
			//���ν� ����Ϸ����� Ȯ���ϱ�
			boolean complete = approvalDAO.isApprovalEnd(approval.getApprovalNo());
			if(complete) {
				//�Ϸ��� �� ���缭 ���� �����ϱ�(����2, �ݷ�3, �Ϸ�4)
				approval.setApprovalStatusCodeNo("04");
				approvalDAO.updateApprovalStatus(approval);
				
			}
		}
	}

	//�����ȣ�� �ش��ϴ� ����� �� �� ���������� �˾Ƴ���
	public Approver findApprover(Approval approval, String employeeNo) throws Exception{
		
		if(employeeNo.equals(approval.getFirstApprover().getEmployeeNo())){
			return approval.getFifthApprover();
		}else if(employeeNo.equals(approval.getSecondApprover().getEmployeeNo())){
			return approval.getSecondApprover();
		}else if(employeeNo.equals(approval.getThirdApprover().getEmployeeNo())) {
			return approval.getThirdApprover();
		}else if(employeeNo.equals(approval.getFourthApprover().getEmployeeNo())) {
			return approval.getFourthApprover();
		}else if(employeeNo.equals(approval.getFifthApprover().getEmployeeNo())) {
			return approval.getFifthApprover();
		}
		
		return null;
	}
	
	//�����ȣ�� �������, ���޸� ��������
	public Approver getFullApprover(Approver approver, String approvalNo) throws Exception {
		System.out.println("ApprovalServiceImpl.getFullApprover() �����ȣ : "+Integer.parseInt(approver.getEmployeeNo()));
		SimpleHumanResourceCard shrc = humanResourceDAO.selectSimpleHumanResourceCardByEmployeeNo(Integer.parseInt(approver.getEmployeeNo()));
		System.out.println("ApprovalServiceImpl.getFullApprover() �λ�ī�� : "+shrc);
		approver.setEmployeeRankCodeName(shrc.getRankCodeName());
		approver.setEmployeeSignatureImage(shrc.getSignatureImage());
		
		return approver.setApprovalNo(approvalNo);
	}
}
