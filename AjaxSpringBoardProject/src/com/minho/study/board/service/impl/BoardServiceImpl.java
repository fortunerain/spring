package com.minho.study.board.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.accenture.kdc.board.constant.BoardEnum;
import com.accenture.kdc.board.service.BoardService;
import com.accenture.kdc.common.exception.BizException;
import com.minho.study.board.dao.BoardDAO;
import com.minho.study.board.vo.BoardVO;
import com.mysql.jdbc.StringUtils;

//@Service
public class BoardServiceImpl implements BoardService {
	private static Log log = LogFactory.getLog(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public void addBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void modifyBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void removeBoard(BoardVO vo) throws BizException{
		boardDAO.deleteBoard(isValideNumPwd(vo));
	}

	@Override
	public BoardVO getBoard(BoardVO vo) throws BizException{
		return isValideNumPwd(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		vo.setSearchKeyword("%"+vo.getSearchKeyword()+"%");
		return boardDAO.selectBoardList(vo);
	}
	
	@Override
	public List<BoardVO> getBoardListAll() {
		return boardDAO.selectBoardListAll();
	}

	@Override
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

}