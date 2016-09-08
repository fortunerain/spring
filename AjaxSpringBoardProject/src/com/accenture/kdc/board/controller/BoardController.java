package com.accenture.kdc.board.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.kdc.board.constant.BoardEnum;
import com.accenture.kdc.board.service.BoardService;
import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.exception.BizException;

@Controller
//public class BoardController extends AbstractController {
public class BoardController {
	private static Log log = LogFactory.getLog(BoardController.class);
	
	@Inject
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST) 
	public @ResponseBody Map<String, Object> removeBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnCode = BoardEnum.FAILURE.getCode(); 
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		BoardVO boardVo = new BoardVO();
		boardVo.setSeq(seq);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setPassword(password);
		
		try {
			boardService.removeBoard(boardVo);
			returnCode = BoardEnum.DELETE_SUCCESS.getCode();
		} catch (BizException e) {
			log.debug("BizException : " + e.getCode(), e);
			returnCode = e.getCode();
		} 
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("returnCode", returnCode);
		
		model.addAttribute("boardVo", boardVo);
		return result;
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST) 
	public @ResponseBody Map<String, Object> modifyBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnCode = BoardEnum.FAILURE.getCode(); 
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		
		BoardVO boardVo = new BoardVO();
		boardVo.setSeq(seq);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setPassword(password);
		
		try {
			//비밀번호 체크
			boardService.isValideNumPwd(boardVo);
			//글 수정
			boardService.modifyBoard(boardVo);
			returnCode = BoardEnum.UPDATE_SUCCESS.getCode(); 
		} catch (BizException e) {
			log.debug("BizException : " + e.getCode(), e);
			returnCode = e.getCode();
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("returnCode", returnCode);
		
		model.addAttribute("boardVo", boardVo);
		return result;
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST) 
	public @ResponseBody Map<String, Object> addBoard(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnCode = BoardEnum.FAILURE.getCode(); 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		
		BoardVO boardVo = new BoardVO();
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setWriter("관리자");
		boardVo.setPassword(password);
		
		boardService.addBoard(boardVo);
		returnCode = BoardEnum.INSERT_SUCCESS.getCode(); 
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("returnCode", returnCode);
		
		return result;
	}
	
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET) 
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/modifyForm", method = RequestMethod.POST) 
	public String modifyForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnCode = BoardEnum.FAILURE.getCode(); 
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardVO boardVo = null;
		
		try {
			boardVo = getBoard(seq);
			returnCode = BoardEnum.SEARCH_SUCCESS.getCode();
		} catch (BizException e) {
			log.debug("BizException : " + e.getCode(), e);
			returnCode = e.getCode();
		} 
		
		model.addAttribute("returnCode", returnCode);
		model.addAttribute("boardVo", boardVo);
		return "modifyForm";
	}
	
	@RequestMapping(value = "/detailForm", method = RequestMethod.POST) 
	public String detailForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		String returnCode = BoardEnum.FAILURE.getCode();
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardVO boardVo = null;
		
		try {
			boardVo = getBoard(seq);
		} catch (BizException e) {
			log.debug("BizException : " + e.getCode(), e);
			returnCode = e.getCode();
		}
		
		model.addAttribute("returnCode", returnCode);
		model.addAttribute("boardVo", boardVo);
		return "detailForm";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String getBoardListAll(Model model) {
		String returnCode = BoardEnum.FAILURE.getCode(); 
		List<BoardVO> boardList = null;
		
		boardList = boardService.getBoardListAll();
		returnCode = BoardEnum.SEARCH_SUCCESS.getCode();
		
		model.addAttribute("list", boardList);
		model.addAttribute("returnCode", returnCode);
		return "board";
	}
	
	public BoardVO getBoard(int seq) throws BizException {
		BoardVO boardVo = new BoardVO();
		boardVo.setSeq(seq);
		return boardService.getBoard(boardVo);
	}
	
	
	/*
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView modelandview = new ModelAndView("board");
		modelandview.addObject("list",this.getBoardListAll());
		return modelandview;
	}
	*/
}
