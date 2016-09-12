package com.minho.study.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.minho.study.board.vo.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	public void updateBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	public void deleteBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	public BoardVO selectBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	public List<BoardVO> selectBoardList(BoardVO vo) throws SQLException, ClassNotFoundException;
	public List<BoardVO> selectBoardListAll() throws SQLException, ClassNotFoundException;
}