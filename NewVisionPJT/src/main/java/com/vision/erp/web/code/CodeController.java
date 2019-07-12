package com.vision.erp.web.code;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vision.erp.common.Search;
import com.vision.erp.service.code.CodeService;
import com.vision.erp.service.domain.Code;

@RestController
public class CodeController {
	//field
	@Resource(name = "codeServiceImpl")
	private CodeService codeService;

	//constructor
	public CodeController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//method
	//[그룹코드조회] - 그룹코드목록조회 
	//조건 없이 다 가져옴
	@RequestMapping(value=" /code/getGroupCodeList")
	public List<Code> getGroupCodeList() throws Exception{
		return codeService.getGroupCodeList();
	}
	
	//[그룹코드조회] - 코드 그룹별조회(사용중, 삭제 조건)
	//searchKeyword = 그룹코드
	//searchCondition = 0 : 사용중, = 1 : 삭제
	@RequestMapping(value="/code/getCodeList")
	public List<Code> getCodeList(@RequestBody Search search) throws Exception{
		return codeService.getCodeList(search);
	}
	
	//[코드그룹별조회] - 코드 삭제/복구하기 그룹코드, 코드번호, 코드사용상태 필요
	//codeUsageStatus = Y : 복구, N : 삭제
	@RequestMapping(value="/code/convertCodeUsageStatus")
	public void convertCodeUsageStatus(@RequestBody Code code) throws Exception{
		codeService.convertCodeUsageStatus(code);
	}
	
	//[코드그룹별조회] - 코드 등록요청시 코드번호 자동생성
	//등록하려는 그룹코드 가져오기
	@RequestMapping(value="/code/addCodePreparing")
	public void addCodePreparing(String groupCode) throws Exception{
		codeService.generateCodeNo(groupCode);
	}
	
	//[코드그룹별조회] - 코드명 중복확인 그룹코드, 코드명 필요
	@RequestMapping(value="/code/checkDuplicateCodeName")
	public boolean checkDuplicateCodeName(@RequestBody Code code) throws Exception {
		Code dbCode = codeService.checkDuplicateCodeNo(code);
		if(dbCode==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//[코드그룹별조회] - 코드 등록하기 그룹코드, 코드번호, 코드명 필요
	@RequestMapping(value="/code/addCode")
	public void addCode(@RequestBody Code code) throws Exception{
		codeService.addCode(code);
	}
	
	//[코드그룹별조회] - 코드수정하기
	@RequestMapping(value="/code/modifyCode")
	public void modifyCode(@RequestBody Code code) throws Exception{
		codeService.modifyCode(code);
	}

}
