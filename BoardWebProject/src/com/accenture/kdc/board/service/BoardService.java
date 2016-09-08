package com.accenture.kdc.board.service;

import java.sql.SQLException;
import java.util.List;

import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.exception.BizException;

public interface BoardService {
	
	public void addBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	
	public void modifyBoard(BoardVO vo) throws SQLException, ClassNotFoundException;
	
	public void removeBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
	
	public BoardVO getBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
	
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException, ClassNotFoundException;

	public List<BoardVO> getBoardListAll() throws SQLException, ClassNotFoundException;
	
	public BoardVO isValideNumPwd(BoardVO vo) throws BizException, SQLException, ClassNotFoundException;
}