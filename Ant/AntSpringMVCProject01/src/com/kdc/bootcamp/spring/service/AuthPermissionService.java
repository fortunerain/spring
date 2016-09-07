package com.kdc.bootcamp.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kdc.bootcamp.spring.dao.AuthUserDao;

/*
 * 1. reusable business logic <== service
 * 
 */
//@Component
@Service("authPermissionService")
public class AuthPermissionService {
	
	@Resource
	//@Autowired
	private AuthUserDao dao;
	
	public List<UserVO> selectAuthPermissionList(String name){
		return this.dao.selectAuthPermissionList(name);
	}
}
