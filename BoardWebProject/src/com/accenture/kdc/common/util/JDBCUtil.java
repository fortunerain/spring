package com.accenture.kdc.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JDBCUtil {
	private static Log log = LogFactory.getLog(JDBCUtil.class);
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Configuration configuration = Configuration.getInstance();
		String jdbcUrl = configuration.getProperties("jdbcUrl");
		String userId = configuration.getProperties("userId");
		String password = configuration.getProperties("password");
		String jdbcDriver = configuration.getProperties("jdbcDriver");
		
		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(jdbcUrl, userId, password); 
			
		return conn;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
