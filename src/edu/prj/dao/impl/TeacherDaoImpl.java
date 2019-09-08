package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.user.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: TeacherDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class TeacherDaoImpl implements TeacherDao {

	@Override
	public Long insert(TeacherBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into teacher ");
		sb.append(" 	(LoginName, LoginPass, Nickname) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getLoginName());
		paramsList.add(bean.getLoginPass());
		paramsList.add(bean.getNickname());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public Long delete(Long id) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and TeacherID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(id);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public Long update(TeacherBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update teacher set ");
		sb.append("		LoginName = ?, ");
		sb.append("		LoginPass = ?, ");
		sb.append("		Nickname = ?, ");
		sb.append("		IsDisabled = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and TeacherID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getLoginName());
		paramsList.add(bean.getLoginPass());
		paramsList.add(bean.getNickname());
		paramsList.add(bean.getIsDisabled());
		paramsList.add(bean.getTeacherID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<TeacherBean> list() {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		}
		
		return list;
	}

	@Override
	public List<TeacherBean> listBySearch(String search) {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		} 
		
		return list;
	}
	
	@Override
	public List<TeacherBean> listByIDAsc(String search) {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append(" order by ");
		sb.append("		TeacherID asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		} 
		
		return list;
	}

	@Override
	public List<TeacherBean> listByIDDesc(String search) {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("order by ");
		sb.append("		TeacherID desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		} 
		
		return list;
	}

	@Override
	public List<TeacherBean> listByNicknameAsc(String search) {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("order by ");
		sb.append("		Nickname asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		} 
		
		return list;
	}

	@Override
	public List<TeacherBean> listByNicknameDesc(String search) {
		List<TeacherBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("order by ");
		sb.append("		Nickname desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				TeacherBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		} 
		
		return list;
	}

	@Override
	public TeacherBean loadById(Long id) {
		TeacherBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and TeacherID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(id);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				bean = toBean(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		}
		
		return bean;
	}

	@Override
	public TeacherBean loadByLoginName(String loginName) {
		TeacherBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(loginName);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				bean = toBean(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		}
		
		return bean;
	}

	@Override
	public Long count() {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from teacher ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countByNickname(String nickname) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from teacher ");
		sb.append(" where 1=1 ");
		sb.append("		and Nickname = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(nickname);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql, params);
		DbPub.close(conn);
	
		return result;
	}
	
	/**
	 * <p>Description: bean对象生成</p>
	 * <p>Title: toBean</p>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private TeacherBean toBean(ResultSet rs) throws SQLException {
		TeacherBean bean = new TeacherBean();
		bean.setTeacherID(rs.getLong("TeacherId"));
		bean.setLoginName(rs.getString("LoginName"));
		bean.setLoginPass(rs.getString("LoginPass"));
		bean.setNickname(rs.getString("Nickname"));
		bean.setIsDisabled(rs.getInt("IsDisabled"));
		return bean;
	}
}
