package com.minho.study.board.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.minho.study.board.constant.BoardEnum;
import com.minho.study.board.vo.BoardVO;



public class BoardViewer {
	Scanner scan = new Scanner(System.in);
	
	public int printMenu(){
		System.out.println("===========================");
		System.out.println("0. 글 리스트 보기");
		System.out.println("1. 글 쓰기");
		System.out.println("2. 글 조회");
		System.out.println("3. 글 변경");
		System.out.println("4. 글 삭제 기능");
		System.out.println("===========================");
		System.out.print("위 명령 중 하나를 선택하세요?  ");
		int menuNum = scan.nextInt();scan.nextLine();
		System.out.println("===========================");
		
		return menuNum;
	}
	public void printExit(){
		System.out.println("===========================");
		System.out.println("종료합니다.");
		System.out.println("===========================");
	}
	
	public void printBoardListAll(List<BoardVO> boardList){
		System.out.println("--------------------------------------------------------------------");
		System.out.println("NO\ttitle\t\t\twriter\t\tregDate");
		System.out.println("--------------------------------------------------------------------");
		for (int i = 0; i < boardList.size(); i++) {
			int seq = boardList.get(i).getSeq();
			String title = boardList.get(i).getTitle();
			String writer = boardList.get(i).getWriter();
			String regDate = boardList.get(i).getRegDate().toString();
			
			System.out.println(seq+"\t"+title+"\t\t"+writer+"\t\t"+regDate);
			System.out.println("--------------------------------------------------------------------");
			
		}
	}
	
	public BoardVO printAddBoard(){
		System.out.print("Title : ");
		String title = scan.nextLine();
		System.out.print("Writer : ");
		String writer = scan.nextLine();
		System.out.print("Password : ");
		String password = scan.nextLine();
		System.out.print("Contents : ");
		String contents = scan.nextLine();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setPassword(password);
		boardVO.setContent(contents);
		return boardVO;
	}
	
	public BoardVO printModifyBoard(int seq){
		System.out.print("Title : ");
		String title = scan.nextLine();
		System.out.print("Contents : ");
		String contents = scan.nextLine();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(seq);
		boardVO.setTitle(title);
		boardVO.setContent(contents);
		return boardVO;
	}
	
	public BoardVO printNumPassword(){
		System.out.println("--------------------------------------------------------------------");
		System.out.println("No : ");
		int seq = scan.nextInt();scan.nextLine();
		System.out.println("Password : ");
		String password = scan.nextLine();
		System.out.println("--------------------------------------------------------------------");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setPassword(password);
		return vo;
		
	}
	
	public void printRemoveBoard(ArrayList<BoardVO> boardList){
		System.out.println("--------------------------------------------------------------------");
		System.out.println("NO\ttitle\t\t\twriter\t\tregDate");
		System.out.println("--------------------------------------------------------------------");
		for (int i = 0; i < boardList.size(); i++) {
			int seq = boardList.get(i).getSeq();
			String title = boardList.get(i).getTitle();
			String writer = boardList.get(i).getWriter();
			String regDate = boardList.get(i).getRegDate().toString();
			
			System.out.println(seq+"\t"+title+"\t\t"+writer+"\t\t"+regDate);
			System.out.println("--------------------------------------------------------------------");
			
		}
	}
	
	public void printGetBoard(BoardVO vo){
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Writer : "+vo.getWriter());
		System.out.println("Contents : "+vo.getContent());
		System.out.println("--------------------------------------------------------------------");
	}
	
	public int printInputNum() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("No : ");
		int seq = scan.nextInt();scan.nextLine();
		System.out.println("--------------------------------------------------------------------");
		return seq;
	}
	
	public void printResultStatus(BoardEnum msg){
		System.out.println(msg.getDesc());
	}
}
