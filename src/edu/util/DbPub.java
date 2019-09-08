package edu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>Title: DbPub</p>
 * <p>Description: 数据库操作工具类</p>
 */
public class DbPub {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String fileName = "/app.properties";
	static {
		// 获得配置文件内容
		try {
			Properties prop = new Properties();
			prop.load(DbPub.class.getResourceAsStream(fileName));
			driver = prop.getProperty("DRIVER");
			url = prop.getProperty("URL");
			user = prop.getProperty("USER");
			password = prop.getProperty("PASSWORD");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 启动JDBC
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Description: 连接数据库</p>
	 * <p>Title: getConnection</p>
	 * @return 连接数据库成功的连接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * <p>Description: 查询</p>
	 * <p>Title: query</p>
	 * @param conn 连接对象
	 * @param sql SQL语句
	 * @param params 数组形式的SQL占位符对应的参数
	 * @return rs查询结果
	 */
	public static ResultSet query(Connection conn, String sql, Object...params) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		try {
			// 预编译
			pstmt = conn.prepareStatement(sql);
			// 如果有值开始给预编译赋值，因为传来的是Object类型，用setObject去接，万能
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行【"+sql+"】出现错误。");
		}
		return rs;
	}

	/**
	 * <p>Description: 更新</p>
	 * <p>Title: update</p>
	 * @param conn 连接对象
	 * @param sql SQL语句
	 * @param params 数组形式的SQL占位符对应的参数
	 * @return 受影响的行数
	 */
	public static Long update(Connection conn, String sql, Object...params) {
		Integer num = 0;
		PreparedStatement pstmt = null;
		
		try {
			// 预编译
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			// 受影响行数
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行【"+sql+"】出现错误。");
		}
		
		return num.longValue();
	}
	
	/**
	 * <p>Description: 查询结果行数</p>
	 * <p>Title: queryScalarLong</p>
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Long queryScalarLong(Connection conn, String sql, Object...params) {
		Long num = 0L;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 使用conn，创建pstmt
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				// 设置参数列表
				for (int i = 0; i < params.length; i++) {
					// 因为问好参数的索引是从1开始，所以是i+1
					// 后面加""，可以转为字符串形式
					// 将所有值都转换为字符串形式，好让 setObject 成功运行
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getLong(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("执行【"+sql+"】出现错误。");
		}
		return num;
	}
	
	/**
	 * <p>Description: 关闭数据库资源</p>
	 * <p>Title: close</p>
	 * @param conn 连接对象
	 * @param rs 查询结果
	 */
	public static void close(Connection conn, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Description: 关闭数据库资源</p>
	 * <p>Title: close</p>
	 * @param conn 连接对象
	 */
	public static void close(Connection conn) {
		close(conn, null);
	}
	
}
