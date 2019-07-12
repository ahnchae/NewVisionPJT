package com.vision.erp.service.notice;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Notice;
import com.vision.erp.service.domain.NoticeHeader;

public interface NoticeDAO {
	
	public String insertNotice(Notice notice) throws Exception;
	
	public Notice selectNoticeDetail(String noticeNo) throws Exception;
	
	public List<Notice> selectNoticeList(Search search) throws Exception;
	
	public void updateNotice(Notice notice) throws Exception;
	
	public void updateNoticeUsageCode(Notice notice) throws Exception;
	
	public void updateNoticeViewCount(Notice notice) throws Exception;
	
	public List<NoticeHeader> selectHeaderNameList() throws Exception;
	
	public int selectTotalCount(Search search) throws Exception;

}
