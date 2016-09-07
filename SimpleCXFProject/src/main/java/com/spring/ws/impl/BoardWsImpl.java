package com.spring.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.StringUtils;
import com.spring.common.exception.BizException;
import com.spring.constant.BoardEnum;
import com.spring.dao.BoardDAO;
import com.spring.vo.BoardVO;
import com.spring.ws.BoardWs;

@WebService(endpointInterface = "com.spring.ws.BoardWs", serviceName = "board", portName="boardPort", targetNamespace="http://ws.spring.com")
public class BoardWsImpl implements BoardWs {
	private static Log log = LogFactory.getLog(BoardWsImpl.class);
	
	@Autowired
	BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public String addBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		return "Success";
	}
	
	public void modifyBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void removeBoard(BoardVO vo) throws BizException{
		boardDAO.deleteBoard(isValideNumPwd(vo));
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		vo.setSearchKeyword("%"+vo.getSearchKeyword()+"%");
		return boardDAO.selectBoardList(vo);
	}

	public List<BoardVO> getBoardListAll() {
		return boardDAO.selectBoardListAll();
	}
	
	public BoardVO isValideNumPwd(BoardVO vo) throws BizException{
		//해당 글이 있는지
		log.debug("############ 게시판 글 조회");
		BoardVO boardVo = boardDAO.selectBoard(vo);
		if(boardVo == null) {
			log.debug("############ NOT_EXIST_NUM");
			throw new BizException(BoardEnum.NOT_EXIST_NUM);
		}
		//비밀번호가 일치 하는지
		String inputPassword = vo.getPassword();
		if(!StringUtils.isEmptyOrWhitespaceOnly(inputPassword)) {
			String password = boardVo.getPassword();
			if(!inputPassword.equals(password)) {
				log.debug("###########inputPassword : "+inputPassword+" password : "+password);
				throw new BizException(BoardEnum.NOT_MATCH_PASSWORD);
			}
		}
		return boardVo;
	}

	public BoardVO getBoard(BoardVO vo) throws BizException{
		return isValideNumPwd(vo);
	}
	
}