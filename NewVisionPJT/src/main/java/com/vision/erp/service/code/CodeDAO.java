package com.vision.erp.service.code;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.Code;

public interface CodeDAO {
	//그룹코드리스트 전체 가져오기, Searchkeyword로 그룹코드로 그룹코드명 가져올 수 있음
	public List<Code> selectGroupCodeList(Search search) throws Exception;
	
	//코드 등록
	public int insertCode(Code code) throws Exception;
	
	//그룹코드에 해당하는 코드리스트 가져오기
	public List<Code> selectCodeList(Search search) throws Exception;
	
	//코드 수정(코드명 수정)
	public int updateCode(Code code) throws Exception;

	//코드 하나만 가져오기, 코드명 중복확인
	public Code selectDuplicateCodeNo(Code code) throws Exception;
	
	//그룹코드 내에서 코드번호 자동생성
	public Code selectLatestCodeNo(String groupCode) throws Exception;

	//코드 삭제/복구
	public int updateCodeUsageStatus(Code code) throws Exception;
	
}
