package com.accenture.kdc.board.dao;

import java.util.List;

import com.accenture.kdc.board.vo.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO selectBoard(BoardVO vo);
	public List<BoardVO> selectBoardList(BoardVO vo);
	public List<BoardVO> selectBoardListAll();
}