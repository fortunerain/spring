package com.spring.ws.impl;

import javax.jws.WebService;

import com.spring.vo.UserVO;
import com.spring.ws.HelloWorldWs;

//WebService 어노테이션을 안적으면 namespace가 랜덤?하게 되기 때문에 명시적으로 적어줌으로써 동일하게 한다.
@WebService(endpointInterface = "com.spring.ws.HelloWorldWs", serviceName = "HelloWorld", portName="HelloPort", targetNamespace="http://ws.spring.com")
public class HelloWorldWsImpl implements HelloWorldWs{

	public String getHelloWorldWs(UserVO user) {
		// TODO Auto-generated method stub
		return "User id = "+user.getId() + "User name = "+user.getName()+" test!!";
	}
}
