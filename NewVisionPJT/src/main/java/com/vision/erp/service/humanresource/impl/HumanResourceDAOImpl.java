package com.vision.erp.service.humanresource.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Appointment;
import com.vision.erp.service.domain.Commute;
import com.vision.erp.service.domain.Department;
import com.vision.erp.service.domain.DutyHours;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.domain.WorkAttitude;
import com.vision.erp.service.domain.WorkAttitudeCode;
import com.vision.erp.service.humanresource.HumanResourceDAO;

@Repository("humanResourceDAOImpl")
public class HumanResourceDAOImpl implements HumanResourceDAO {
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public void insertHumanResourceCard(HumanResourceCard humanResourceCard) throws Exception {
		sqlSession.insert("HumanResourceCardMapper.insertHumanResourceCard", humanResourceCard);
	}

	@Override
	public List<HumanResourceCard> selectHumanResourceCardList(Search search) throws Exception {
		
		return sqlSession.selectList("HumanResourceCardMapper.selectHumanResourceCardList", search);
	}

	@Override
	public HumanResourceCard selectHumanResourceCardDetailByEmployeeNo(String employeeNo) throws Exception {
		
		return sqlSession.selectOne
				("HumanResourceCardMapper.selectHumanResourceCardDetailByEmployeeNo"
						, employeeNo);
	}

	@Override
	public SimpleHumanResourceCard selectSimpleHumanResourceCardByEmployeeNo(String employeeNo) throws Exception {
		
		return sqlSession.selectOne
				("HumanResourceCardMapper.selectSimpleHumanResourceCardByEmployeeNo"
						, employeeNo);
	}

	@Override
	public List<SimpleHumanResourceCard> selectSimpleHumanResourceCardList(Search search) throws Exception {
		
		return sqlSession.selectList
				("HumanResourceCardMapper.selectSimpleHumanResourceCardList", search);
	}
	
	@Override
	public void updateHumanResourceCard(HumanResourceCard humanResourceCard) throws Exception {
		
		sqlSession.update
				("HumanResourceCardMapper.updateHumanResourceCard", humanResourceCard);
	}

	@Override
	public void insertWorkAttitude(WorkAttitude workAttitude) throws Exception {
		
		sqlSession.insert("WorkAttitudeMapper.insertWorkAttitude", workAttitude);
	}

	@Override
	public List<WorkAttitude> selectWorkAttitudeList(Search search) throws Exception {

		return sqlSession.selectList("WorkAttitudeMapper.selectWorkAttitudeList", search);
	}

	@Override
	public void updateWorkAttitude(WorkAttitude workAttitude) throws Exception {

		sqlSession.update("WorkAttitudeMapper.updateWorkAttitude", workAttitude);
	}

	@Override
	public void updateWorkAttitudeUsageStatus(String workAttitudeNo, String usageStatus) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("workAttitudeNo", workAttitudeNo);
		map.put("usageStatus", usageStatus);
		sqlSession.update("WorkAttitudeMapper.updateWorkAttitudeUsageStatus", map);
	}

	@Override
	public void insertWorkAttitudeCode(WorkAttitudeCode workAttitudeCode) throws Exception {

		sqlSession.insert("WorkAttitudeCodeMapper.insertWorkAttitudeCode", workAttitudeCode);
	}

	@Override
	public List<WorkAttitudeCode> selectWorkAttitudeCodeList(Search search) throws Exception {

		return sqlSession.selectList("WorkAttitudeCodeMapper.selectWorkAttitudeCodeList", search);
	}

	@Override
	public void updateWorkAttitudeCode(WorkAttitudeCode workAttitudeCode) throws Exception {
		
		sqlSession.update("WorkAttitudeCodeMapper.updateWorkAttitudeCode", workAttitudeCode);
	}

	@Override
	public void updateWorkAttitudeCodeUsageStatus(String workAttitudeCodeNo, String usageStatus) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("workAttitudeCodeNo", workAttitudeCodeNo);
		map.put("usageStatus",usageStatus);
		
		sqlSession.update
				("WorkAttitudeCodeMapper.updateWorkAttitudeCodeUsageStatus"
						, map);
	}

	@Override
	public void insertAppointment(Appointment appointment) throws Exception {

		sqlSession.insert("AppointmentMapper.insertAppointment", appointment);
	}

	@Override
	public List<Appointment> selectAppointmentList(Search search) throws Exception {

		return sqlSession.selectList("AppointmentMapper.selectAppointmentList", search);
	}

	@Override
	public Appointment selectAppointmentDetailByAppointNo(String appointNo) throws Exception {

		return sqlSession.selectOne("AppointmentMapper.selectAppointmentDetail", appointNo);
	}
	
	@Override
	public void updateAppointment(Appointment appointment) throws Exception {

		sqlSession.update("AppointmentMapper.updateAppointment", appointment);
	}

	@Override
	public void updateAppointmentStatus(String appointmentNo, String status) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("appointmentNo",appointmentNo);
		map.put("status",status);
		
		sqlSession.update("AppointmentMapper.updateAppointmentStatus", map);
	}

	@Override
	public void insertDepartment(Department department) throws Exception {

		sqlSession.insert("DepartmentMapper.insertDepartmnet", department);
	}

	@Override
	public List<Department> selectDepartmentList(Search search) throws Exception {

		return sqlSession.selectList("DepartmentMapper.selectDepartmentList", search);
	}

	@Override
	public void updateDepartment(Department department) throws Exception {

		sqlSession.update("DepartmentMapper.updateDepartment", department);
	}

	@Override
	public void updateDepartmentUsageStatus(String departCodeNo, String status) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departCodeNo", departCodeNo);
		map.put("status",status);
		
		sqlSession.update("DepartmentMapper.updateDepartmentUsageStatus", map);
	}


	@Override
	public void insertCommute(Commute commute) throws Exception {

		sqlSession.insert("CommuteMapper.insertCommute", commute);
	}
	
	@Override
	public List<Commute> selectCommuteList(String employeeNo) throws Exception {
		
		return sqlSession.selectList("CommuteMapper.selectCommuteList", employeeNo);
	}
	
	@Override
	public void updateCommuteForLeaveWorkTime(Commute commute) throws Exception {

		sqlSession.update("CommuteMapper.updateCommuteForLeaveWorkTime", commute);
	}

	@Override
	public void insertDutyHours(DutyHours dutyHours) throws Exception {

		sqlSession.insert("CommuteMapper.insertDutyHours", dutyHours);
	}


	//미정//////////////////////////////////
	@Override
	public String selectSignatureImageByEmployeeNo(String employeeNo) throws Exception {
		return null;
	}

	

	

	

}
