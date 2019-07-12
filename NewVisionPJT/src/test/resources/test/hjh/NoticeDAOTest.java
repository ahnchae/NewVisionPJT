package test.hjh;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Notice;
import com.vision.erp.service.domain.NoticeHeader;
import com.vision.erp.service.notice.NoticeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:config/root-context.xml",
		"classpath:config/aspect-context.xml",
		"classpath:config/servlet-context.xml",
		"classpath:config/transaction-context.xml"
})
public class NoticeDAOTest{

	@Resource(name = "noticeDAOImpl")
	private NoticeDAO noticeDAO;
	
	private Notice notice;
	private Search search;
	private NoticeHeader noticeHeader;
	private List<Notice> noticeList;
	private List<NoticeHeader> noticeHeaderList;
	
	
	//@Test
	public void testInsertNotice() throws Exception{
		
		notice = new Notice();
		
		notice.setNoticeTitle("test01");
		notice.setContent("test01");
		notice.setEmployeeNo("1002");
		notice.setReadAuthority("01");
		
		String noticeNo = noticeDAO.insertNotice(notice);
		
		notice = noticeDAO.selectNoticeDetail(noticeNo);
		
		System.out.println(notice);
	}
		
	@Test
	public void testSelectToitalCount() throws Exception {
		
		search = new Search();
		search.setSearchCondition("1");
		search.setSearchKeyword("박");
		int totalNo = noticeDAO.selectTotalCount(search);
		
		System.out.println("totalNo = "+totalNo);
		
		
	}
	
	//@Test
	public void testSelectNoticeList() throws Exception {
		
		search = new Search();
		
		search.setSearchCondition("1");
		search.setSearchKeyword("한");
		noticeList = (List<Notice>)noticeDAO.selectNoticeList(search);
		
		for(int i = 0; i<noticeList.size(); i++) {
			notice = noticeList.get(i);
			System.out.println(notice);
		}
		
	}
	
	//@Test
	public void testSelectNoticeDetail()  throws Exception{
		
		notice = new Notice();
		
		notice = noticeDAO.selectNoticeDetail("1");
		
		System.out.println(notice);
	}
	
	//@Test
	public void testSelectHeaderNameList() throws Exception {
		
		noticeHeader = new NoticeHeader();
		
		noticeHeaderList = (List<NoticeHeader>)noticeDAO.selectHeaderNameList();
		
		for(int i = 0; i<noticeHeaderList.size(); i++) {
			noticeHeader = noticeHeaderList.get(i);
			System.out.println(noticeHeader);
		}
		
	}
	
	//@Test
	public void testUpdateNotice() throws Exception {
		
		notice = new Notice();
		
		notice.setNoticeNo("22");
		notice.setEmployeeNo("1000");
		notice.setNoticeTitle("updateTest01");
		notice.setContent("업데이트테스트01");
		notice.setReadAuthority("1");
		
		noticeDAO.updateNotice(notice);
		
		notice = noticeDAO.selectNoticeDetail("22");
		
		System.out.println("notice update 내용확인 : "+notice);
		
	}
	
	//@Test
	public void testUpdateUsageStatusCode() throws Exception {
		
		notice = new Notice();
		
		notice.setNoticeNo("22");
		notice.setNoticeStatusCodeNo("02");
		
		noticeDAO.updateNoticeUsageCode(notice);
		
		notice = noticeDAO.selectNoticeDetail("22");
		
		System.out.println(notice);
		
	}
	
	//@Test
	public void testUpdateViewCount() throws Exception {
		
		notice = new Notice();
		
		notice = noticeDAO.selectNoticeDetail("22");
		
		String noticeView = notice.getViewCount();
		
		System.out.println("조회수 변경 전: "+noticeView);
		noticeView = Integer.toString(Integer.parseInt(noticeView) + 1);
		System.out.println("조회수 변경 후: "+noticeView);
		
		notice.setViewCount(noticeView);
		
		noticeDAO.updateNoticeViewCount(notice);
		notice = noticeDAO.selectNoticeDetail("22");
		
		System.out.println(notice);
		
	}
	

}
