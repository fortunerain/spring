package com.minho.study.board.constant;

import com.minho.study.common.constant.ICodeEnum;

public enum BoardEnum implements ICodeEnum{
	NOT_EXIST_NUM("notMatchNum","�ش� �۹�ȣ�� �������� ����"),
	NOT_MATCH_PASSWORD("notMatchPassword","��й�ȣ�� ��ġ ���� ����"),
	INSERT_SUCCESS("insertSuccess","�߰��Ǿ����ϴ�."),
	UPDATE_SUCCESS("updateSuccess","����Ǿ����ϴ�."),
	DELETE_SUCCESS("deleteSuccess","�����Ǿ����ϴ�."),
	SEARCH_SUCCESS("searchSuccess","��ȸ�Ǿ����ϴ�."),
	FAILURE("failure","����");
	
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
