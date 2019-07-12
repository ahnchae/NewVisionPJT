package com.vision.erp.service.humanresource.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.accounting.AccountingDAO;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.Appointment;
import com.vision.erp.service.domain.Code;
import com.vision.erp.service.domain.Commute;
import com.vision.erp.service.domain.Department;
import com.vision.erp.service.domain.DutyHours;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.domain.User;
import com.vision.erp.service.domain.WorkAttitude;
import com.vision.erp.service.domain.WorkAttitudeCode;
import com.vision.erp.service.humanresource.HumanResourceDAO;
import com.vision.erp.service.humanresource.HumanResourceService;
import com.vision.erp.service.user.UserDAO;

@Service("humanResourceServiceImpl")
public class HumanResourceServiceImpl implements HumanResourceService {

	@Resource(name = "humanResourceDAOImpl")
	private HumanResourceDAO humanResourceDAO;
	
	//@Resource(name = "accountingDAOImpl")
	private AccountingDAO accountingDAO;
	
	//@Resource(name = "userDAOImpl")
	private UserDAO userDAO;
	
	//@Resource(name = "codeDAOImpl")
	private CodeDAO codeDAO;
	
	
	//나중에 확인///////////////////////////////////////////////////
	@Override
	public void addHumanResourceCard(HumanResourceCard humanResourceCard) throws Exception {
		accountingDAO.insertAccount(humanResourceCard.getAccount());
		humanResourceCard.getAccount().getAccountNo();
		humanResourceDAO.insertHumanResourceCard(humanResourceCard);
		User user = new User();
		
		user.setEmployeeNo(humanResourceCard.getEmployeeNo());
		//user.setAccessMenuCodeNo(accessMenuCodeNo);
		user.setMemberCodeNo("01");
		user.setMemberUsageStatusCodeNo("01");
		user.setPassword("0000");
		user.setUserId("U"+humanResourceCard.getEmployeeName());
		userDAO.addUser(user);
	}

	@Override
	public List<HumanResourceCard> getHumanResourceCardList(Search search) throws Exception {
		return humanResourceDAO.selectHumanResourceCardList(search);
	}

	@Override
	public HumanResourceCard getHumanResourceCardDetailByEmployeeNo(String employeeNo) throws Exception {
		return humanResourceDAO.selectHumanResourceCardDetailByEmployeeNo(employeeNo);
	}

	@Override
	public SimpleHumanResourceCard getSimpleHumanResourceCardByEmployeeNo(String employeeNo) throws Exception {
		return humanResourceDAO.selectSimpleHumanResourceCardByEmployeeNo(employeeNo);
	}

	@Override
	public List<SimpleHumanResourceCard> getSimpleHumanResourceCardList(Search search) throws Exception {
		return humanResourceDAO.selectSimpleHumanResourceCardList(search);
	}

	@Override
	public void modifyHumanResourceCard(HumanResourceCard humanResourceCard) throws Exception {
		humanResourceDAO.updateHumanResourceCard(humanResourceCard);		
	}

	@Override
	public void addWorkAttitude(WorkAttitude workAttitude) throws Exception {
		humanResourceDAO.insertWorkAttitude(workAttitude);
	}

	@Override
	public List<WorkAttitude> getWorkAttitudeList(Search search) throws Exception {
		return humanResourceDAO.selectWorkAttitudeList(search);
	}

	@Override
	public void modifyWorkAttitude(WorkAttitude workAttitude) throws Exception {
		humanResourceDAO.updateWorkAttitude(workAttitude);
	}

	@Override
	public void convertWorkAtttidueUsageStatus(String workAttitudeNo, String usageStatus) throws Exception {
		humanResourceDAO.updateWorkAttitudeUsageStatus(workAttitudeNo, usageStatus);
	}

	@Override
	public void addWorkAttitudeCode(WorkAttitudeCode workAttitudeCode) throws Exception {
		humanResourceDAO.insertWorkAttitudeCode(workAttitudeCode);
	}

	@Override
	public List<WorkAttitudeCode> getWorkAttitudeCodeList(Search search) throws Exception {
		return humanResourceDAO.selectWorkAttitudeCodeList(search);
	}

	@Override
	public void modifyWorkAttitudeCode(WorkAttitudeCode workAttitudeCode) throws Exception {
		humanResourceDAO.updateWorkAttitudeCode(workAttitudeCode);
	}

	@Override
	public void convertWorkAttitudeCodeUsageStatus(String workAttitudeCodeNo, String usageStatus) throws Exception {
		humanResourceDAO.updateWorkAttitudeCodeUsageStatus(workAttitudeCodeNo, usageStatus);
	}

	@Override
	public void addAppointment(Appointment appointment) throws Exception {
		humanResourceDAO.insertAppointment(appointment);
	}

	@Override
	public List<Appointment> getAppointmentList(Search search) throws Exception {
		return humanResourceDAO.selectAppointmentList(search);
	}

	@Override
	public Appointment getAppointmentDetailByAppointNo(String appointNo) throws Exception {
		return humanResourceDAO.selectAppointmentDetailByAppointNo(appointNo);
	}

	@Override
	public void modifyAppointment(Appointment appointment) throws Exception {
		humanResourceDAO.updateAppointment(appointment);
	}

	@Override
	public void convertAppointmentStatus(String appointmentNo, String status) throws Exception {
		humanResourceDAO.updateAppointmentStatus(appointmentNo, status);
	}

	//////////////////////////////코드 자동생성 service 사용할 것!!//////////////////
	@Override
	public void addDepartment(Department department) throws Exception {
		
		Code code = new Code();
		code.setCodeName(department.getDepartCodeName());
		//code.setCodeNo(codeNo);
		code.setGroupCode("depart");
		code.setGroupCodeName("부서");
		code.setCodeUsageStatus("01");
		
		codeDAO.insertCode(code);
		humanResourceDAO.insertDepartment(department);
	}

	@Override
	public List<Department> getDepartmentList(Search search) throws Exception {
		return humanResourceDAO.selectDepartmentList(search);
	}

	@Override
	public void modifyDepartment(Department department) throws Exception {
		humanResourceDAO.updateDepartment(department);
	}

	@Override
	public void convertDepartmentUsageStatus(String departCodeNo, String status) throws Exception {
		humanResourceDAO.updateDepartmentUsageStatus(departCodeNo, status);
	}

	@Override
	public List<Commute> getCommuteListByEmployeeNo(String employeeNo) throws Exception {
		return humanResourceDAO.selectCommuteList(employeeNo);
	}

	@Override
	public void addCommute(Commute commute) throws Exception {
		humanResourceDAO.insertCommute(commute);
	}

	@Override
	public void modifyCommuteForLeaveWorkTime(Commute commute) throws Exception {
		humanResourceDAO.updateCommuteForLeaveWorkTime(commute);
	}

	@Override
	public void addDutyHours(DutyHours dutyHours) throws Exception {
		humanResourceDAO.insertDutyHours(dutyHours);
	}

}
