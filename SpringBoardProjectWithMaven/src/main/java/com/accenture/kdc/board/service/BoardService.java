package com.accenture.kdc.board.service;

import java.util.List;

import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.exception.BizException;

public interface BoardService {
	
	public void addBoard(BoardVO vo);
	
	public void modifyBoard(BoardVO vo);
	
	public void removeBoard(BoardVO vo) throws BizException;
	
	public BoardVO getBoard(BoardVO vo) throws BizException;
	
	public List<BoardVO> getBoardList(BoardVO vo);

	public List<BoardVO> getBoardListAll();
	
	public BoardVO isValideNumPwd(BoardVO vo) throws BizException;
}