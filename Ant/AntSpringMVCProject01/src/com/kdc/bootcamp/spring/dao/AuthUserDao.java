package com.kdc.bootcamp.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kdc.bootcamp.spring.service.UserVO;


/*
 * 1, @Component, @Repository
 * 2, @Resource, @Autowired
 */
@Component
//@Repository
public class AuthUserDao {
	
	@Resource
	//@Autowired
	private SqlSession sqlSession;
	
	public List<UserVO> selectAuthPermissionList(String name){
		return this.sqlSession.selectList("authUser.selectUsers", name);
	}
}
