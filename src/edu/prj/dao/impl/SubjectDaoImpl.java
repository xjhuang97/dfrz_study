package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: SubjectDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class SubjectDaoImpl implements SubjectDao {

	@Override
	public Long insert(SubjectBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into subject ");
		sb.append(" 	(SubjectName, TeacherID) ");
		sb.append(" values ");
		sb.append(" 	(?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getSubjectName());
		paramsList.add(bean.getTeacherID());
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
		sb.append(" delete from subject ");
		sb.append(" where 1=1 ");
		sb.append("		and SubjectID = ? ");
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
	public Long update(SubjectBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update subject set ");
		sb.append("		SubjectName = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and SubjectID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getSubjectName());
		paramsList.add(bean.getSubjectID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<SubjectBean> list() {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		SubjectID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				SubjectBean bean = toBean(rs);
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
	public List<SubjectBean> listBySearch(String search) {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName like ? ");
		sb.append("		or t.Nickname like ? ");
		sb.append(" order by ");
		sb.append("		SubjectID ");
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
				SubjectBean bean = toBean(rs);
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
	public List<SubjectBean> listByIDAsc(String search) {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName like ? ");
		sb.append("		or t.Nickname like ? ");
		sb.append(" order by ");
		sb.append("		SubjectID asc ");
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
				SubjectBean bean = toBean(rs);
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
	public List<SubjectBean> listByIDDesc(String search) {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName like ? ");
		sb.append("		or t.Nickname like ? ");
		sb.append(" order by ");
		sb.append("		SubjectID desc ");
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
				SubjectBean bean = toBean(rs);
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
	public List<SubjectBean> listBySubjectNameAsc(String search) {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName like ? ");
		sb.append("		or t.Nickname like ? ");
		sb.append(" order by ");
		sb.append("		SubjectName asc ");
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
				SubjectBean bean = toBean(rs);
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
	public List<SubjectBean> listBySubjectNameDesc(String search) {
		List<SubjectBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName like ? ");
		sb.append("		or t.Nickname like ? ");
		sb.append(" order by ");
		sb.append("		SubjectName desc ");
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
				SubjectBean bean = toBean(rs);
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
	public SubjectBean loadById(Long id) {
		SubjectBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectID = ? ");
		sb.append(" order by ");
		sb.append("		SubjectID ");
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
	public SubjectBean loadBySubjectName(String subjectName) {
		SubjectBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName = ? ");
		sb.append(" order by ");
		sb.append("		SubjectID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(subjectName);
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
	public SubjectBean loadByDoubleName(String subjectName, Long teacherID) {
		SubjectBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, t.Nickname as TeacherName ");
		sb.append("	from subject s ");
		sb.append("		left join teacher t on s.TeacherID=t.TeacherID ");
		sb.append("	where 1=1 ");
		sb.append("		and SubjectName = ? ");
		sb.append("		and t.TeacherID = ? ");
		sb.append(" order by ");
		sb.append("		SubjectID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(subjectName);
		paramsList.add(teacherID);
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
		sb.append(" select count(*) from subject ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countBySubjectName(String subjectName) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from subject ");
		sb.append(" where 1=1 ");
		sb.append("		and SubjectName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(subjectName);
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
	private SubjectBean toBean(ResultSet rs) throws SQLException {
		SubjectBean bean = new SubjectBean();
		bean.setSubjectID(rs.getLong("SubjectID"));
		bean.setSubjectName(rs.getString("SubjectName"));
		bean.setTeacherID(rs.getLong("TeacherID"));
		bean.setTeacherName(rs.getString("TeacherName"));
		bean.setStatus(rs.getString("Status"));
		return bean;
	}

}
