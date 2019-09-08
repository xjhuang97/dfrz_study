package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: GradeDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class GradeDaoImpl implements GradeDao {

	@Override
	public Long insert(GradeBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into grade ");
		sb.append(" 	(GradeName, CreateBy, UpdateBy) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getGradeName());
		paramsList.add(bean.getCreateBy());
		paramsList.add(bean.getUpdateBy());
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
		sb.append(" delete from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeID = ? ");
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
	public Long update(GradeBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update grade set ");
		sb.append("		UpdateOn = now(), ");
		sb.append("		UpdateBy = ?, ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getUpdateBy());
		paramsList.add(bean.getGradeID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<GradeBean> list() {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public List<GradeBean> listBySearch(String search) {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName like ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public List<GradeBean> listByIDAsc(String search) {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName like ? ");
		sb.append(" order by ");
		sb.append("		GradeID asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public List<GradeBean> listByIDDesc(String search) {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName like ? ");
		sb.append("order by ");
		sb.append("		GradeID desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public List<GradeBean> listByGradeNameAsc(String search) {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName like ? ");
		sb.append("order by ");
		sb.append("		GradeName asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public List<GradeBean> listByGradeNameDesc(String search) {
		List<GradeBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName like ? ");
		sb.append("order by ");
		sb.append("		GradeName desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				GradeBean bean = toBean(rs);
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
	public GradeBean loadById(Long id) {
		GradeBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeID = ? ");
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
	public GradeBean loadByLoginName(String loginName) {
		GradeBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from grade ");
		sb.append(" where 1=1 ");
		sb.append("		and GradeName = ? ");
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
		sb.append(" select count(*) from grade ");
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
		sb.append(" select count(*) from grade ");
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
	private GradeBean toBean(ResultSet rs) throws SQLException {
		GradeBean bean = new GradeBean();
		bean.setGradeID(rs.getLong("GradeId"));
		bean.setGradeName(rs.getString("GradeName"));
		bean.setCreateBy(rs.getLong("CreateBy"));
		bean.setCreateOn(rs.getString("CreateOn"));
		bean.setUpdateBy(rs.getLong("UpdateBy"));
		bean.setUpdateOn(rs.getString("UpdateOn"));
		return bean;
	}
}
