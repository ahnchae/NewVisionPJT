package com.vision.erp.service.notice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Notice;
import com.vision.erp.service.domain.NoticeHeader;
import com.vision.erp.service.notice.NoticeDAO;

@Repository("noticeDAOImpl")
public class NoticeDAOImpl implements NoticeDAO{

	@Resource(name="sqlSession")
	private SqlSession sqlSession;

	@Override
	public String insertNotice(Notice notice) throws Exception {
		sqlSession.insert("NoticeMapper.insertNotice", notice);
		System.out.println("Notice Select Key »Æ¿Œ : "+notice.getNoticeNo());
		return notice.getNoticeNo();
	}

	@Override
	public Notice selectNoticeDetail(String noticeNo) throws Exception {
		return sqlSession.selectOne("NoticeMapper.selectNoticeDetail", noticeNo);
	}

	@Override
	public List<Notice> selectNoticeList(Search search) throws Exception {
		return sqlSession.selectList("NoticeMapper.selectNoticeList", search);
	}

	@Override
	public void updateNotice(Notice notice) throws Exception {
		sqlSession.update("NoticeMapper.updateNotice", notice);
		
	}

	@Override
	public void updateNoticeUsageCode(Notice notice) throws Exception {
		sqlSession.update("NoticeMapper.updateNoticeUsageCode", notice);
	}

	@Override
	public void updateNoticeViewCount(Notice notice) throws Exception {
		sqlSession.update("NoticeMapper.updateNoticeViewCount", notice);
		
	}

	
	public List<NoticeHeader> selectHeaderNameList() throws Exception{
		return sqlSession.selectList("NoticeMapper.selectHeaderNameList");
	}
	
	@Override
	public int selectTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("NoticeMapper.selectTotalCount", search);
	}
	
}
