package com.accenture.kdc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.kdc.board.constant.BoardEnum;
import com.accenture.kdc.board.dao.BoardDAO;
import com.accenture.kdc.board.service.BoardService;
import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.exception.BizException;
import com.mysql.jdbc.StringUtils;

@Service
public class BoardServiceImpl implements BoardService {
	private static Log log = LogFactory.getLog(BoardServiceImpl.class);
	
	//BoardDAOImpl 
	@Autowired
	private BoardDAO boardDAOImpl;
//	private BoardDAO boardDAO = new BoardDAOImpl();
	
	public BoardDAO getBoardDAO() {
		return boardDAOImpl;
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAOImpl = boardDAO;
	}
	
	@Override
	public void addBoard(BoardVO vo) throws SQLException, ClassNotFoundException {
		boardDAOImpl.insertBoard(vo);
	}

	@Override
	public void modifyBoard(BoardVO vo) throws SQLException, ClassNotFoundException {
		boardDAOImpl.updateBoard(vo);
	}

	@Override
	public void removeBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException {
		boardDAOImpl.deleteBoard(isValideNumPwd(vo));
	}

	@Override
	public BoardVO getBoard(BoardVO vo) throws BizException, SQLException, ClassNotFoundException {
		return isValideNumPwd(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException, ClassNotFoundException {
		vo.setSearchKeyword("%"+vo.getSearchKeyword()+"%");
		return boardDAOImpl.selectBoardList(vo);
	}
	
	@Override
	public List<BoardVO> getBoardListAll() throws SQLException, ClassNotFoundException {
		return boardDAOImpl.selectBoardListAll();
	}

	@Override
	public BoardVO isValideNumPwd(BoardVO vo) throws BizException, SQLException, ClassNotFoundException {
		//해당 글이 있는지
		log.debug("############ 게시판 글 조회");
		BoardVO boardVo = boardDAOImpl.selectBoard(vo);
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