package com.minho.study.board.constant;

import com.minho.study.common.constant.ICodeEnum;

public enum BoardEnum implements ICodeEnum{
	NOT_EXIST_NUM("notMatchNum","해당 글번호가 존재하지 않음"),
	NOT_MATCH_PASSWORD("notMatchPassword","비밀번호가 일치 하지 않음"),
	INSERT_SUCCESS("insertSuccess","추가되었습니다."),
	UPDATE_SUCCESS("updateSuccess","변경되었습니다."),
	DELETE_SUCCESS("deleteSuccess","삭제되었습니다."),
	SEARCH_SUCCESS("searchSuccess","조회되었습니다."),
	FAILURE("failure","실패");
	
	private String code;
	private String desc;
	
	private BoardEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
