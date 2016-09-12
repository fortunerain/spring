package com.minho.study.board.service;

import java.sql.SQLException;
import java.util.List;

import com.minho.study.board.vo.BoardVO;
import com.minho.study.common.exception.BizException;

public interface BoardService {
	
	public void addBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	
	public void modifyBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	
	public void removeBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
	
	public BoardVO getBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
	
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException, ClassNotFoundException;

	public List<BoardVO> getBoardListAll() throws SQLException, ClassNotFoundException;
	
	public BoardVO isValideNumPwd(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
}