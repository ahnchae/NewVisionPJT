package com.vision.erp.web.humanresource;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Appointment;
import com.vision.erp.service.domain.Commute;
import com.vision.erp.service.domain.Department;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.domain.WorkAttitude;
import com.vision.erp.service.domain.WorkAttitudeCode;
import com.vision.erp.service.humanresource.HumanResourceService;


@RestController
public class HumanResourceController {

	@Resource(name = "humanResourceServiceImpl")
	private HumanResourceService humanResourceService;
	
	//인사카드 등록
	@RequestMapping(value = "/hr/addHumanResourceCard",method = RequestMethod.POST)
	public void addHumanResourceCard(@RequestBody HumanResourceCard humanResourceCard) throws Exception{
		System.out.println("/hr/addHumanResourceCard");
		
		//Accounting이 아직 미구현됨
		//User가 아직 미구현됨
		humanResourceService.addHumanResourceCard(humanResourceCard);
		
	}
	
	//인사카드 목록조회
	@RequestMapping(value = "/hr/getHumanResourceCardList", method = RequestMethod.POST)
	public List<HumanResourceCard> getHumanResourceCardList(@RequestBody Search search) throws Exception{
		System.out.println("/hr/getHumanResourceCardList");
		System.out.println(search);
		
		List<HumanResourceCard> list 
				= humanResourceService.getHumanResourceCardList(search);
		
		System.out.println(list);
		
		return list;
	}
	
	//인사카드 상세조회
	@RequestMapping(value = "/hr/getHumanResourceCardDetail/{employeeNo}", method = RequestMethod.GET)
	public HumanResourceCard getHumanResourceCardDetail(@PathVariable String employeeNo) throws Exception{
		System.out.println("hr/getHumanResourceCardDetail");
		
		System.out.println(employeeNo);
		
		HumanResourceCard humanResourceCard
					= humanResourceService.getHumanResourceCardDetailByEmployeeNo(employeeNo);
	
		return humanResourceCard;
	}
	
	//인사카드 목록조회 without 민감한 정보
	@RequestMapping(value = "/hr/getSimpleHumanResourceCardList", method = RequestMethod.POST)
	public List<SimpleHumanResourceCard> getSimpleHumanResourceCardList(
									@RequestBody Search search) throws Exception{
		
		List<SimpleHumanResourceCard> list
					= humanResourceService.getSimpleHumanResourceCardList(search);
		
		System.out.println(list);
		
		return list;
	}
	
	//인사카드 상세조회 without 민감한 정보
	@RequestMapping(value = "/hr/getSimpleHumanResourceCardDetail/{employeeNo}",method = RequestMethod.GET)
	public SimpleHumanResourceCard getSimpleHumanResourceCardDetail(
									@PathVariable String employeeNo) throws Exception{
		System.out.println("hr/getSimpleHumanResourceCardDetail/");
		
		SimpleHumanResourceCard simpleHumanResourceCard
					= humanResourceService.getSimpleHumanResourceCardByEmployeeNo(employeeNo);
		
		return simpleHumanResourceCard;
	}
	
	//인사카드 수정
	@RequestMapping(value = "/hr/modifyHumanResourceCard",method = RequestMethod.POST)
	public void modifyHumanResourceCard(HumanResourceCard humanResourceCard) throws Exception{
		System.out.println("hr/modifyHumanResourceCard");
		
		humanResourceService.modifyHumanResourceCard(humanResourceCard);
		
	}
	
	//근태 등록
	@RequestMapping(value = "/hr/addWorkAttitude", method = RequestMethod.POST)
	public void addWorkAttitude(WorkAttitude workAttitude) throws Exception{
		System.out.println("/hr/addWorkAttitude");
		
		humanResourceService.addWorkAttitude(workAttitude);
	}
	
	//근태 목록조회
	@RequestMapping(value = "/hr/getWorkAttitudeList", method = RequestMethod.POST)
	public List<WorkAttitude> getWorkAttitudeList(Search search) throws Exception{
		System.out.println("/hr/getWorkAttitudeList");
		
		List<WorkAttitude> list 
				=	humanResourceService.getWorkAttitudeList(search);
		
		return list;
	}
	
	//근태 수정
	@RequestMapping(value = "/hr/modifyWorkAttitude", method = RequestMethod.POST)
	public void modifyWorkAttitude(WorkAttitude workAttitude) throws Exception{
		System.out.println("/hr/modifyWorkAttitude");
		
		humanResourceService.modifyWorkAttitude(workAttitude);
	}
	
	//근태 사용상태 변경
	//Sample Data : [{"workAttitudeNo":"1"},{"usageStatus":"01"}]
	@RequestMapping(value = "/hr/convertWorkAttitudeUsageStatus", method = RequestMethod.POST)
	public void convertWorkAttitudeUsageStatus(@RequestBody Map<String, String>[] arrayMap) throws Exception{
		System.out.println("/hr/convertWorkAttitudeUsageStatus");
		
		humanResourceService.convertWorkAtttidueUsageStatus(arrayMap[0].get("workAttitudeNo")
													, arrayMap[1].get("usageStatus"));
	}
	
	//근태코드 등록
	@RequestMapping(value = "/hr/addWorkAttitudeCode", method = RequestMethod.POST)
	public void addWorkAttitudeCode(
				@RequestBody WorkAttitudeCode workAttitudeCode) throws Exception{
		System.out.println("/hr/addWorkAttitudeCode");
		
		humanResourceService.addWorkAttitudeCode(workAttitudeCode);
		
	}
	
	//근태코드 목록조회
	@RequestMapping(value = "/hr/getWorkAttitudeCodeList", method = RequestMethod.POST)
	public List<WorkAttitudeCode> getWorkAttitudeCodeList(Search search) throws Exception{
		System.out.println("/hr/getWorkAttitudeCodeList");
		
		List<WorkAttitudeCode> list = humanResourceService.getWorkAttitudeCodeList(search);
		
		return list;
	}
	
	//근태코드 수정
	@RequestMapping(value = "/hr/modifyWorkAttitudeCode", method = RequestMethod.POST)
	public void modifyWorkAttitudeCode(WorkAttitudeCode workAttitudeCode) throws Exception{
		System.out.println("/hr/modifyWorkAttitudeCode");
		
		humanResourceService.modifyWorkAttitudeCode(workAttitudeCode);
	}
	
	//근태코드 사용상태 변경
	@RequestMapping(value = "/hr/convertWorkAttitudeCodeUsageStatus", method = RequestMethod.GET)
	public void convertWorkAttitudeCodeUsageStatus(@RequestBody Map<String, String>[] arrayMap) throws Exception{
		System.out.println("/hr/convertWorkAttitudeCodeUsageStatus");
		
		humanResourceService.convertWorkAttitudeCodeUsageStatus(arrayMap[0].get("workAttitudeCodeNo"), arrayMap[1].get("usageStatus"));
	}
	
	//발령등록
	@RequestMapping(value = "/hr/addAppointment", method = RequestMethod.POST)
	public void addAppointment(Appointment appointment) throws Exception{
		System.out.println("/hr/addAppointment");
		
		humanResourceService.addAppointment(appointment);
	}
	
	//발령 목록조회
	@RequestMapping(value = "/hr/getAppointmentList", method = RequestMethod.GET)
	public List<Appointment> getAppointmentList(Search search) throws Exception{
		System.out.println("/hr/getAppointmentList");
		
		List<Appointment> list 
					= humanResourceService.getAppointmentList(search);
		
		return list;
	}
	
	//발령 수정
	@RequestMapping(value = "/hr/modifyAppointment", method = RequestMethod.POST)
	public void modifyAppointment(Appointment appointment) throws Exception{
		System.out.println("/hr/modifyAppointment");
		
		humanResourceService.modifyAppointment(appointment);
	}
	
	//발령상태 수정
	//Sample Data : [{"appointmentNo":"1"},{"status":"02"}]
	@RequestMapping(value = "/hr/modifyAppointmentStatus", method = RequestMethod.GET)
	public void modifyAppointmentStatus(@RequestBody Map<String, String>[] arrayMap) throws Exception{
		System.out.println("/hr/modifyAppointmentStatus");
	
		humanResourceService.convertAppointmentStatus(arrayMap[0].get("appointmentNo")
												, arrayMap[1].get("status"));
	}
	
	//발령 삭제
	@RequestMapping(value = "/hr/removeAppointment", method = RequestMethod.GET)
	public void removeAppointment(@RequestBody Appointment appointment) throws Exception{
		
	}
	
	//부서 등록
	@RequestMapping(value = "/hr/addDepartment", method = RequestMethod.POST)
	public void addDepartment(Department department) throws Exception{
		System.out.println("/hr/addDepartment");
		
		humanResourceService.addDepartment(department);
	}
	
	//부서 목록조회
	@RequestMapping(value = "/hr/getDepartmentList", method = RequestMethod.POST)
	public List<Department> getDepartmentList(Search search) throws Exception{
		System.out.println("/hr/getDepartmentList");
		
		List<Department> list = humanResourceService.getDepartmentList(search);
		
		return list;
	}
	
	//부서 수
	@RequestMapping(value = "/hr/modifyDepartment", method = RequestMethod.POST)
	public void modifyDepartment(Department department) throws Exception{
		System.out.println("/hr/modifyDepartment");
		
		humanResourceService.modifyDepartment(department);
	}
	
	//부서사용상태 변경
	@RequestMapping(value = "/hr/convertDepartmentUsageStatus", method = RequestMethod.POST)
	public void convertDepartmentUsageStatus(@RequestBody Map<String, String>[] arrayMap) throws Exception{
		System.out.println("/hr/convertDepartmentUsageStatus");
		
		humanResourceService.convertDepartmentUsageStatus(arrayMap[0].get("departCodeNo")
															,arrayMap[1].get("status") );
	}
	
	//근무시간 조회
	@RequestMapping(value = "/hr/getCommuteList/{employeeNo}", method = RequestMethod.GET)
	public List<Commute> getCommuteList(@PathVariable String employeeNo) throws Exception{
		System.out.println("/hr/getCommuteList");
		
		List<Commute> list = humanResourceService.getCommuteListByEmployeeNo(employeeNo);
		
		return list;
	}
	
	//출근시간 등록
	@RequestMapping(value = "/hr/addCommute", method = RequestMethod.POST)
	public void addCommute(Commute commute) throws Exception{
		System.out.println("/hr/addCommute");
		
		humanResourceService.addCommute(commute);
	}
}
