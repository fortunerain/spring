package com.spring.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.common.exception.BizException;
import com.spring.vo.BoardVO;

@WebService
public interface BoardWs {
	
	public List<BoardVO> getBoardList(@WebParam(name="board") BoardVO vo);
	public List<BoardVO> getBoardListAll();
	public String addBoard(@WebParam(name="board") BoardVO vo);
	public void modifyBoard(@WebParam(name="board") BoardVO vo);
	public void removeBoard(@WebParam(name="board") BoardVO vo) throws BizException;
	public BoardVO getBoard(@WebParam(name="board") BoardVO vo) throws BizException;
	public BoardVO isValideNumPwd(@WebParam(name="board") BoardVO vo) throws BizException;
}