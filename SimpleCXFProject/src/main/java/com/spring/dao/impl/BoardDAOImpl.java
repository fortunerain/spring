package com.spring.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.spring.common.exception.NonBizException;
import com.spring.dao.BoardDAO;
import com.spring.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	private static Log log = LogFactory.getLog(BoardDAOImpl.class);
	
	//@Resource
	@Autowired
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void insertBoard(BoardVO vo) {
		
		try {
			int n=1/0;
			this.sqlSession.insert("board.insertBoard", vo);
		} catch (Exception e) {
			Gson gson = new Gson();
			log.error(gson.toJson(vo));
			throw new NonBizException("123","insert error!!");
		}
	}
	public void updateBoard(BoardVO vo) {
		this.sqlSession.update("board.updateBoard", vo);
	}
	public void deleteBoard(BoardVO vo) {
		this.sqlSession.delete("board.deleteBoard", vo);
	}
	public BoardVO selectBoard(BoardVO vo) {
		return this.sqlSession.selectOne("board.selectBoard", vo);
	}
	public List<BoardVO> selectBoardList(BoardVO vo) {
		return this.sqlSession.selectList("board.selectBoardList", vo);
	}
	public List<BoardVO> selectBoardListAll() {
		return this.sqlSession.selectList("board.selectBoardListAll");
	}
	
}