package com.vision.erp.service.code.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeDAO;
import com.vision.erp.service.code.CodeService;
import com.vision.erp.service.domain.Code;

@Service("codeServiceImpl")
public class CodeServiceImpl implements CodeService {

	//field
	@Resource(name="codeDAOImpl")
	private CodeDAO codeDAO;
	
	//method
	//그룹코드리스트 전체 가져오기
	@Override
	public List<Code> getGroupCodeList() throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectGroupCodeList(null);
	}

	//코드 등록
	@Override
	public void addCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		
		//그룹코드명 가져오기
		Search search = new Search();
		search.setSearchKeyword(code.getGroupCode());
		
		codeDAO.insertCode(code.setGroupCodeName(codeDAO.selectGroupCodeList(search).get(0).getGroupCodeName()));
	}

	//그룹코드에 해당하는 코드리스트 가져오기
	//search condition은 사용하지 않음, search keyword는 그룹코드
	@Override
	public List<Code> getCodeList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectCodeList(search);
	}

	//코드 수정(코드명 수정)
	@Override
	public void modifyCode(Code code) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.updateCode(code);
	}

	//코드 하나만 가져오기, 코드명 중복확인
	@Override
	public Code checkDuplicateCodeNo(Code code) throws Exception {
		// TODO Auto-generated method stub
		return codeDAO.selectDuplicateCodeNo(code);
	}

	//그룹코드 내에서 코드번호 자동생성
	@Override
	public String generateCodeNo(String groupCode) throws Exception {
		// TODO Auto-generated method stub
		//String.format("바꿀 형식과 전달인자 정의법", "전달인자")
		//"%02d"==> % : 명령의 시작, 0 : 채워질 문자, 2 : 총 자리수, d : 십진 정수	[참고 : https://devbible.tistory.com/78]
		return String.format("%02d", Integer.parseInt(codeDAO.selectLatestCodeNo(groupCode).getCodeNo())+1);
	}

	//코드 삭제/복구
	@Override
	public void convertCodeUsageStatus(Code code) throws Exception {
		// TODO Auto-generated method stub
		codeDAO.updateCodeUsageStatus(code);
	}

}
