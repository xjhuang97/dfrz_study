package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.user.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: StudentDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public Long insert(StudentBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into student ");
		sb.append(" 	(LoginName, LoginPass, Nickname, GradeID, ClassRoomID) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?,?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getLoginName());
		paramsList.add(bean.getLoginPass());
		paramsList.add(bean.getNickname());
		paramsList.add(bean.getGradeID());
		paramsList.add(bean.getClassRoomID());
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
		sb.append(" delete from student ");
		sb.append(" where 1=1 ");
		sb.append("		and StudentID = ? ");
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
	public Long update(StudentBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update student set ");
		sb.append("		LoginName = ?, ");
		sb.append("		LoginPass = ?, ");
		sb.append("		Nickname = ?, ");
		sb.append("		IsDisabled = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and StudentID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getLoginName());
		paramsList.add(bean.getLoginPass());
		paramsList.add(bean.getNickname());
		paramsList.add(bean.getIsDisabled());
		paramsList.add(bean.getStudentID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<StudentBean> list() {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("	order by s.StudentID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listBySearch(String search) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("	order by s.StudentID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByIDAsc(String search) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("	order by s.StudentID asc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByIDDesc(String search) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("	order by s.StudentID desc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByNicknameAsc(String search) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("	order by s.Nickname asc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByNicknameDesc(String search) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and LoginName like ? ");
		sb.append("		or Nickname like ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("	order by s.Nickname desc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByIDAsc(String search, Long gradeID, Long classroomID) {
		List<StudentBean> list = new ArrayList<>();

		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and s.GradeID like ? ");
		sb.append("		and c.RoomID like ? ");
		sb.append("		and (LoginName like ? ");
		sb.append("		or Nickname like ? ) ");
		sb.append("	order by s.StudentID asc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(gradeID);
		paramsList.add(classroomID);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByIDDesc(String search, Long gradeID, Long classroomID) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and s.GradeID like ? ");
		sb.append("		and c.RoomID like ? ");
		sb.append("		and (LoginName like ? ");
		sb.append("		or Nickname like ? ) ");
		sb.append("	order by s.StudentID desc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(gradeID);
		paramsList.add(classroomID);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByNicknameAsc(String search, Long gradeID, Long classroomID) {
		List<StudentBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and s.GradeID like ? ");
		sb.append("		and c.RoomID like ? ");
		sb.append("		and (LoginName like ? ");
		sb.append("		or Nickname like ? ) ");
		sb.append("	order by s.Nickname asc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(gradeID);
		paramsList.add(classroomID);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public List<StudentBean> listByNicknameDesc(String search, Long gradeID, Long classroomID) {
		List<StudentBean> list = new ArrayList<>();

		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and s.GradeID like ? ");
		sb.append("		and c.RoomID like ? ");
		sb.append("		and (LoginName like ? ");
		sb.append("		or Nickname like ? ) ");
		sb.append("	order by s.Nickname desc");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		search = "%" + search + "%";
		paramsList.add(gradeID);
		paramsList.add(classroomID);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				StudentBean bean = toBean(rs);
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
	public StudentBean loadById(Long id) {
		StudentBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
		sb.append(" where 1=1 ");
		sb.append("		and StudentID = ? ");
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
	public StudentBean loadByLoginName(String loginName) {
		StudentBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select s.*, g.GradeName as GradeName, c.RoomName as RoomName ");
		sb.append(" from student s ");
		sb.append("		left join grade g on s.GradeID = g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomId=c.RoomID ");
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
		sb.append(" select count(*) from student ");
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
		sb.append(" select count(*) from student ");
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
	private StudentBean toBean(ResultSet rs) throws SQLException {
		StudentBean bean = new StudentBean();
		bean.setStudentID(rs.getLong("StudentID"));
		bean.setLoginName(rs.getString("LoginName"));
		bean.setLoginPass(rs.getString("LoginPass"));
		bean.setNickname(rs.getString("Nickname"));
		bean.setGradeID(rs.getLong("GradeID"));
		bean.setGradeName(rs.getString("GradeName"));
		bean.setClassRoomID(rs.getLong("ClassRoomID"));
		bean.setClassRoomName(rs.getString("RoomName"));
		bean.setIsDisabled(rs.getInt("IsDisabled"));
		return bean;
	}


}
