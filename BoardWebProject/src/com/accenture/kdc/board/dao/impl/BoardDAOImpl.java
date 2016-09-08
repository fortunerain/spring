package com.accenture.kdc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.accenture.kdc.board.dao.BoardDAO;
import com.accenture.kdc.board.vo.BoardVO;
import com.accenture.kdc.common.util.JDBCUtil;

@Repository
public class BoardDAOImpl implements BoardDAO {
	private static Log log = LogFactory.getLog(BoardDAOImpl.class);
	
	// SQL ��ɾ��
	//private final String BOARD_ADD = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_ADD = "insert into board(title, writer, content) values(?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_LIST_TITLE = "select * from board where title like ? order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like ? order by seq desc";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST_ALL = "select * from board";
	
	@Override
	public void insertBoard(BoardVO vo) throws SQLException, ClassNotFoundException {
		log.debug("insertBoard start");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_ADD);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		log.debug("insertBoard end");
	}
	
	@Override
	public void updateBoard(BoardVO vo) throws SQLException, ClassNotFoundException{
		log.debug("updateBoard start");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		log.debug("updateBoard end");
	}	
	
	@Override
	public void deleteBoard(BoardVO vo) throws SQLException, ClassNotFoundException{
		log.debug("deleteBoard start");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		log.debug("deleteBoard end");
	}
	
	@Override
	public BoardVO selectBoard(BoardVO vo) throws SQLException, ClassNotFoundException{
		log.debug("selectBoard start");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();		
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()){
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				board.setPassword(rs.getString("PASSWORD"));
				
			}	
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		log.debug("selectBoard end");
		return board;
	}
	
	@Override
	public List<BoardVO> selectBoardList(BoardVO vo) throws SQLException, ClassNotFoundException{
		log.debug("selectBoardList start");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();	
			if(vo.getSearchCondition().equals("TITLE")){
				stmt = conn.prepareStatement(BOARD_LIST_TITLE);
			}else if(vo.getSearchCondition().equals("CONTENT")){
				stmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			}
			stmt.setString(1, "%"+vo.getSearchKeyword()+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		log.debug("selectBoardList end");
		return boardList;
	}
	
	@Override
	public List<BoardVO> selectBoardListAll() throws SQLException, ClassNotFoundException {
		log.debug("selectBoardListAll start");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();	
			stmt = conn.prepareStatement(BOARD_LIST_ALL);
			rs = stmt.executeQuery();
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		log.debug("selectBoardListAll end");
		return boardList;
	}
}
