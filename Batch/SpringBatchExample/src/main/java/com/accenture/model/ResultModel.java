package com.accenture.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class ResultModel {
	private String result;
//	private ArrayList<ResponseModel> response;
	
	@XmlAttribute(name = "result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
//	public ArrayList<ResponseModel> getResponse() {
//		return response;
//	}
//	public void setResponse(ArrayList<ResponseModel> response) {
//		this.response = response;
//	}
//	
}
