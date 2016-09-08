package com.accenture.kdc.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.accenture.kdc.board.service.BoardService;
import com.accenture.kdc.board.view.BoardViewer;
import com.accenture.kdc.board.vo.BoardVO;

@Controller
public class BoardInsertController extends AbstractController{
	private static Log log = LogFactory.getLog(BoardInsertController.class);
	
	@Autowired
	private BoardService boardService;
	private BoardViewer boardViewer = new BoardViewer();
	private BoardVO boardVo = new BoardVO();
	
	public void setBoardViewer(BoardViewer boardViewer) {
		this.boardViewer = boardViewer;
	}
	

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		log.debug("여기로 타는건가?");
		return new ModelAndView("writeForm");
	}
	
	
	
	
}
