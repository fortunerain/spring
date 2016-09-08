package com.accenture.kdc.board.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.accenture.kdc.board.constant.BoardEnum;
import com.accenture.kdc.board.service.BoardService;
import com.accenture.kdc.board.view.BoardViewer;
import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.exception.BizException;

@Controller
public class BoardController {
	private static Log log = LogFactory.getLog(BoardController.class);
	
	@Autowired
	private BoardService boardService;
//	private BoardService boardService = new BoardServiceImpl();
	private BoardViewer boardViewer = new BoardViewer();
	private BoardVO boardVo = new BoardVO();
	
	public void setBoardViewer(BoardViewer boardViewer) {
		this.boardViewer = boardViewer;
	}
//	public void setBoardService(BoardService boardService) {
//		this.boardService = boardService;
//	}

	/*public void execute(){
		while (true) {
			int menuNum = boardViewer.printMenu();
			handleRequest(menuNum);
		}
		
	}*/
	/*private void handleRequest(int menuNum){
		switch (menuNum) {
		case 0:
			try {
				this.getBoardListAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 1:
			try {
				this.addBoard();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {
				this.getBoard();
			} catch (BizException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				this.modifyBoard();
			} catch (BizException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				this.removeBoard();
			} catch (BizException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			boardViewer.printExit();
			System.exit(0);
			break;
		}
	}*/

	public void removeBoard() throws BizException, SQLException, ClassNotFoundException {
		boardVo = boardViewer.printNumPassword();
		boardService.removeBoard(boardVo);
		boardViewer.printResultStatus(BoardEnum.DELETE_SUCCESS);
	}
	public void modifyBoard() throws BizException, SQLException, ClassNotFoundException {
		boardVo = boardViewer.printNumPassword();
		if(boardService.isValideNumPwd(boardVo) != null) {
			boardService.modifyBoard(boardViewer.printModifyBoard(boardVo.getSeq()));
			boardViewer.printResultStatus(BoardEnum.UPDATE_SUCCESS);
		}
	}
	public void getBoard() throws BizException, SQLException, ClassNotFoundException {
		int seq = boardViewer.printInputNum();
		boardVo.setSeq(seq);
		boardViewer.printGetBoard(boardService.getBoard(boardVo));
		boardViewer.printResultStatus(BoardEnum.SEARCH_SUCCESS);
	}
	
	@RequestMapping(value = "/writeForm.do", method = RequestMethod.GET) 
	public void addBoard() throws SQLException, ClassNotFoundException {
		//boardVo = boardViewer.printAddBoard();
		boardService.addBoard(boardVo);
		//boardViewer.printResultStatus(BoardEnum.INSERT_SUCCESS);
	}
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView getBoardListAll(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, ClassNotFoundException {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList = boardService.getBoardListAll();
		//boardViewer.printResultStatus(BoardEnum.SEARCH_SUCCESS);
		//boardViewer.printBoardListAll(boardList);
		
		ModelAndView modelandview = new ModelAndView("board");
		modelandview.addObject("list",boardList);
		return modelandview;
	}
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
//			HttpServletResponse arg1) throws Exception {
//		ModelAndView modelandview = new ModelAndView("board");
//		modelandview.addObject("list",this.getBoardListAll());
//		return modelandview;
//	}
	
}
