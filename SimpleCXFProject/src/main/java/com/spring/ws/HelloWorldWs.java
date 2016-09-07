package com.spring.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.vo.UserVO;

@WebService
public interface HelloWorldWs {
	public String getHelloWorldWs(@WebParam(name="user") UserVO user);
}
