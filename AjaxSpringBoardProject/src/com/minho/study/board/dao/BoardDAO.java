package com.minho.study.board.dao;

import java.util.List;

import com.minho.study.board.vo.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO selectBoard(BoardVO vo);
	public List<BoardVO> selectBoardList(BoardVO vo);
	public List<BoardVO> selectBoardListAll();
}