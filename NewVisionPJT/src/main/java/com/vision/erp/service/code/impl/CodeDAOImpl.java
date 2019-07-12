package com.vision.erp.service.code.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.domain.Code;

@Repository("codeDAOImpl")
public class CodeDAOImpl implements CodeDAO {

	//field
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	//그룹코드리스트 전체 가져오기
	@Override
	public List<Code> selectGroupCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CodeMapper.selectGroupCodeList");
	}

	//코드 등록
	@Override
	public int insertCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("CodeMapper.insertCode", code);
	}

	//그룹코드에 해당하는 코드리스트 가져오기, searchKeyword = group_code, searchCondition=0=사용중/1=삭제
	@Override
	public List<Code> selectCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CodeMapper.selectCodeList", search);
	}

	//코드 수정(코드명 수정)
	@Override
	public int updateCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("CodeMapper.updateCode", code);
	}

	//코드 하나만 가져오기, 코드명 중복확인
	@Override
	public Code selectDuplicateCodeNo(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CodeMapper.selectDuplicateCodeNo", code);
	}

	//그룹코드 내에서 코드번호 자동생성
	@Override
	public Code selectLatestCodeNo(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CodeMapper.selectLatestCodeNo", groupCode);
	}

	//코드 삭제N/복구Y
	@Override
	public int updateCodeUsageStatus(Code code) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("CodeMapper.updateCodeUsageStatus", code);
	}

}
