package com.accenture.kdc.board.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.accenture.kdc.board.dao.BoardDAO;
import com.accenture.kdc.board.vo.BoardVO;
import com.google.gson.Gson;

//@Repository
public class BoardDAOImpl implements BoardDAO {
	private static Log log = LogFactory.getLog(BoardDAOImpl.class);
	
	//@Resource
	@Inject
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertBoard(BoardVO vo) {
		
		try {
		//	int n=1/0;
			this.sqlSession.insert("board.insertBoard", vo);
		} catch (Exception e) {
			Gson gson = new Gson();
			log.error(gson.toJson(vo));
			//throw new NonBizException("insert error!!",e);
		}
	}
	@Override
	public void updateBoard(BoardVO vo) {
		this.sqlSession.update("board.updateBoard", vo);
	}
	@Override
	public void deleteBoard(BoardVO vo) {
		this.sqlSession.delete("board.deleteBoard", vo);
	}
	@Override
	public BoardVO selectBoard(BoardVO vo) {
		return this.sqlSession.selectOne("board.selectBoard", vo);
	}
	@Override
	public List<BoardVO> selectBoardList(BoardVO vo) {
		return this.sqlSession.selectList("board.selectBoardList", vo);
	}
	@Override
	public List<BoardVO> selectBoardListAll() {
		return this.sqlSession.selectList("board.selectBoardListAll");
	}
	
}