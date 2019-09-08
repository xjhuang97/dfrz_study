package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: ClassroomDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class ClassroomDaoImpl implements ClassroomDao {

	@Override
	public Long insert(ClassroomBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into classroom ");
		sb.append(" 	(RoomName, GradeID) ");
		sb.append(" values ");
		sb.append(" 	(?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getRoomName());
		paramsList.add(bean.getGradeID());
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
		sb.append(" delete from classroom ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomID = ? ");
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
	public Long update(ClassroomBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update classroom set ");
		sb.append("		RoomName = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getRoomName());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<ClassroomBean> list() {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		RoomID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				ClassroomBean bean = toBean(rs);
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
	public List<ClassroomBean> listBySearch(String search) {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append("		and RoomName like ? ");
		sb.append(" order by ");
		sb.append("		RoomID ");
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
				ClassroomBean bean = toBean(rs);
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
	public List<ClassroomBean> listByIDAsc(String search) {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append("		and RoomName like ? ");
		sb.append(" order by ");
		sb.append("		RoomID asc ");
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
				ClassroomBean bean = toBean(rs);
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
	public List<ClassroomBean> listByIDDesc(String search) {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append("		and RoomName like ? ");
		sb.append(" order by ");
		sb.append("		RoomID desc ");
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
				ClassroomBean bean = toBean(rs);
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
	public List<ClassroomBean> listByClassroomNameAsc(String search) {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append("		and RoomName like ? ");
		sb.append(" order by ");
		sb.append("		RoomName asc ");
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
				ClassroomBean bean = toBean(rs);
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
	public List<ClassroomBean> listByClassroomNameDesc(String search) {
		List<ClassroomBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append("	where 1=1 ");
		sb.append("		and RoomName like ? ");
		sb.append(" order by ");
		sb.append("		RoomName desc ");
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
				ClassroomBean bean = toBean(rs);
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
	public ClassroomBean loadById(Long id) {
		ClassroomBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomID = ? ");
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
	public ClassroomBean loadByClassroomName(String classroomName) {
		ClassroomBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(classroomName);
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
	public ClassroomBean loadByDoubleName(String classroomName, Long gradeID) {
		ClassroomBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select c.*, g.GradeName as GradeName ");
		sb.append("	from classroom c ");
		sb.append("		left join Grade g on c.GradeID=g.GradeID ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomName = ? ");
		sb.append("		and c.GradeID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(classroomName);
		paramsList.add(gradeID);
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
		sb.append(" select count(*) from classroom ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countByClassroomName(String classroomName) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from classroom ");
		sb.append(" where 1=1 ");
		sb.append("		and RoomName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(classroomName);
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
	private ClassroomBean toBean(ResultSet rs) throws SQLException {
		ClassroomBean bean = new ClassroomBean();
		bean.setRoomID(rs.getLong("RoomId"));
		bean.setRoomName(rs.getString("RoomName"));
		bean.setGradeID(rs.getLong("GradeID"));
		bean.setGradeName(rs.getString("GradeName"));
		return bean;
	}

}
