package test.mmh;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Account;
import com.vision.erp.service.domain.Appointment;
import com.vision.erp.service.domain.Commute;
import com.vision.erp.service.domain.Department;
import com.vision.erp.service.domain.DutyHours;
import com.vision.erp.service.domain.HumanResourceCard;
import com.vision.erp.service.domain.SimpleHumanResourceCard;
import com.vision.erp.service.domain.WorkAttitude;
import com.vision.erp.service.domain.WorkAttitudeCode;
import com.vision.erp.service.humanresource.HumanResourceDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class HumanResourceCardTest{

	@Resource(name = "humanResourceDAOImpl")
	private HumanResourceDAO humanResourceDAO;

	
	private HumanResourceCard humanResourceCard;
	private Search search;
	private Account account;
	private SimpleHumanResourceCard simpleHumanResourceCard;
	private Appointment appointment;
	private WorkAttitude workAttitude;
	private WorkAttitudeCode workAttitudeCode;
	private Department department;
	private Commute commute;
	private DutyHours dutyHours;
	
	//@Test
	public void testSelectHumanResourceCardList() throws Exception {
		
		search = new Search();
		search.setSearchKeyword("1020");
		
		List<HumanResourceCard> list 
				= (List<HumanResourceCard>)humanResourceDAO.selectHumanResourceCardList(search);
		
		for(int i = 0; i<list.size(); i++) {
			HumanResourceCard humanResourceCard = list.get(i);
			System.out.println(humanResourceCard);
		}
		
	}
	
	//@Test
	public void testInsertHumanResourceCard() throws Exception{
		
		humanResourceCard = new HumanResourceCard();
		account = new Account();
		
		//humanResourceCard.setAccount(account);
		humanResourceCard.setAddress("");
		humanResourceCard.setContractFile("");
		humanResourceCard.setDepartCodeNo("01");
		humanResourceCard.setDetailAddress("");
		humanResourceCard.setEmployeeEmail("qhdqhdekd261@gmail.com");
		humanResourceCard.setEmployeeName("");
		humanResourceCard.setEmployeePhone("010-2234-5566");
		humanResourceCard.setEmployeeTel("02-8897-2441");
		humanResourceCard.setJoinDate("2017/02/05");
		humanResourceCard.setProfileImage("");
		humanResourceCard.setRankCodeNo("03");
		humanResourceCard.setResignation("N");
		humanResourceCard.setRefer("");
		humanResourceCard.setSignatureImage("");
		humanResourceCard.setSsn("930424-1120394");
		humanResourceCard.setWage("13000");
		humanResourceCard.setZipCode("08790");
		
		//Insert
		humanResourceDAO.insertHumanResourceCard(humanResourceCard);
		
		//Select List
		search = new Search();
		
		List<HumanResourceCard> list 
				= (List<HumanResourceCard>)humanResourceDAO.selectHumanResourceCardList(search);
		
		for(int i = 0; i<list.size(); i++) {
			HumanResourceCard humanResourceCard = list.get(i);
			System.out.println(humanResourceCard);
		}
	}
	
	//@Test
	public void testSelectSimpleHumanResourceCardByEmployeeNo() throws Exception{
		
		simpleHumanResourceCard = 
				(SimpleHumanResourceCard)humanResourceDAO.selectSimpleHumanResourceCardByEmployeeNo("1001");
		
		System.out.println(simpleHumanResourceCard);
		
	}
	
	//@Test
	public void testUpdateHumanResourceCard() throws Exception{
		
		humanResourceCard = new HumanResourceCard();
		humanResourceCard = 
					(HumanResourceCard)humanResourceDAO.selectHumanResourceCardDetailByEmployeeNo("1001");
		
		humanResourceCard.setEmployeeName("");
		
		//System.out.println("Test :: "+humanResourceCard);
		humanResourceDAO.updateHumanResourceCard(humanResourceCard);
		
	}
	
	//@Test
	public void testInsertAppointment() throws Exception{
		
		humanResourceCard = 
				(HumanResourceCard)humanResourceDAO.selectHumanResourceCardDetailByEmployeeNo("1001");
		
		appointment = new Appointment();
		appointment.setAppointDate("2019/02/03");
		appointment.setAppointDepartCodeNo("02");
		appointment.setAppointmentStatusCodeNo("02");
		appointment.setAppointRankCodeNo("03");
		appointment.setEmployeeNo(humanResourceCard.getEmployeeNo());
		appointment.setPreDepartCodeNo(humanResourceCard.getDepartCodeNo());
		appointment.setPreRankCodeNo(humanResourceCard.getRankCodeNo());
		appointment.setReference("");
		
		humanResourceDAO.insertAppointment(appointment);
		
	}
	
	//@Test
	public void testSelectAppoinmentList() throws Exception{
		
		search = new Search();
		search.setSearchKeyword("1001");
		
		List<Appointment> list = (List<Appointment>)humanResourceDAO.selectAppointmentList(search);
		
		for(int i = 0; i<list.size(); i++) {
			appointment = list.get(i);
			System.out.println(appointment);
		}
		
	}
	
	//@Test
	public void testUpdateAppointment() throws Exception{
		
		appointment = humanResourceDAO.selectAppointmentDetailByAppointNo("21");
		
		appointment.setAppointDepartCodeNo("04");
		
		humanResourceDAO.updateAppointment(appointment);
		
	}
	
	//@Test
	public void testUpdateAppointmentStatus() throws Exception{
		
		appointment = new Appointment();
		appointment.setAppointDepartCodeNo("04");
		
		humanResourceDAO.updateAppointmentStatus("21", "01");
	}
	
	//@Test
	public void testInsertWorkAttitudeCode() throws Exception{
		
		workAttitudeCode = new WorkAttitudeCode();
		workAttitudeCode.setWorkAttitudeCodeName("소정근로");
		workAttitudeCode.setCommuteApplyCode("02");
		workAttitudeCode.setWorkType("01");
		workAttitudeCode.setWorkDayOfWeek("02");
		workAttitudeCode.setApplyStartTime("09:00");
		workAttitudeCode.setApplyEndTime("18:00");
		workAttitudeCode.setUsageStatusCode("01");
		
		humanResourceDAO.insertWorkAttitudeCode(workAttitudeCode);
	}
	
	//@Test
	public void testSelectWorkAttitudeCode() throws Exception{
		
		workAttitudeCode = new WorkAttitudeCode();
		workAttitudeCode.setWorkAttitudeCodeNo("100");
		workAttitudeCode.setWorkAttitudeCodeName("소정근로");
		workAttitudeCode.setCommuteApplyCode("02");
		workAttitudeCode.setWorkType("01");
		workAttitudeCode.setWorkDayOfWeek("02");
		workAttitudeCode.setApplyStartTime("09:00");
		workAttitudeCode.setApplyEndTime("18:00");
		workAttitudeCode.setUsageStatusCode("01");
		
		humanResourceDAO.updateWorkAttitudeCode(workAttitudeCode);
		
	}
	
	//@Test
	public void testSelectWorkAttitudeCodeList() throws Exception{
		
		search = new Search();
		search.setSearchKeyword("박");
		
		List<WorkAttitudeCode> list = humanResourceDAO.selectWorkAttitudeCodeList(search);
		
		for(int i = 0; i<list.size(); i++) {
			workAttitudeCode = list.get(i);
			System.out.println(workAttitudeCode);
		}
	}
	
	//@Test
	public void testUpdateWorkAttitudeCodeUsageStatus() throws Exception{
		
		humanResourceDAO.updateWorkAttitudeCodeUsageStatus("100", "01");		
	}
	
	//@Test
	public void testInsertWorkAttitude() throws Exception{
		
		workAttitude = new WorkAttitude();
		workAttitude.setEmployeeNo("1001");
		workAttitude.setWorkAttitudeDate("2019/05/07");
		workAttitude.setWorkAttitudeNo("1");
		workAttitude.setWorkAttitudeCodeNo("101");
		workAttitude.setWorkAttitudeTime("60");
		workAttitude.setUsageStatusCodeNo("01");
		
		humanResourceDAO.insertWorkAttitude(workAttitude);
		
	}
	
	//@Test
	public void testSelectWorkAttitudeList() throws Exception{
		
		search = new Search();
		search.setSearchKeyword("");
		
		List<WorkAttitude> list = humanResourceDAO.selectWorkAttitudeList(search);
		
		for(int i = 0; i<list.size(); i++) {
			workAttitude = list.get(i);
			System.out.println(workAttitude);
		}
		
	}
	
	//@Test
	public void testUpdateWorkAttitude() throws Exception{
		
		
		workAttitude = new WorkAttitude();
		workAttitude.setEmployeeNo("1000");
		workAttitude.setWorkAttitudeDate("2019/05/07");
		workAttitude.setWorkAttitudeNo("1");
		workAttitude.setWorkAttitudeCodeNo("101");
		workAttitude.setWorkAttitudeTime("60");
		
		humanResourceDAO.updateWorkAttitude(workAttitude);
		
	}
	
	//@Test
	public void testInsertCommute() throws Exception{
		
		commute = new Commute();
		commute.setCommuteDate("2019/05/08");
		commute.setEmployeeNo("1002");
		commute.setGoToWorkTime("2019/05/09 08:50:30");
		humanResourceDAO.insertCommute(commute);
		
	}
	
	//@Test
	public void testUpdateCommuteForLeaveWorkTime() throws Exception{
		
		commute = new Commute();
		commute.setCommuteDate("2019/07/11");
		commute.setEmployeeNo("1002");
		commute.setLeaveWorkTime("2019/05/09 18:50:30");
		
		humanResourceDAO.updateCommuteForLeaveWorkTime(commute);
		
	}
	
	//@Test
	public void testInsertDutyHours() throws Exception{
		
		dutyHours = new DutyHours();
		dutyHours.setEmployeeNo("1001");
		dutyHours.setRegularWorkTime("540");
		dutyHours.setExtendWorkTime("50");
		dutyHours.setWorkDate("2019/05/07");
		
		humanResourceDAO.insertDutyHours(dutyHours);
	}
	
	//@Test
	public void testSelectDepartmentList() throws Exception{
		
		search = new Search();
		search.setSearchCondition("02");
		
		List<Department> list = humanResourceDAO.selectDepartmentList(search);
		
		for(int i = 0; i<list.size(); i++) {
			department = list.get(i);
			System.out.println(department);
		}
		
	}

}
