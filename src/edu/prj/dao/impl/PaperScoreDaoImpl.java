package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.util.DbPub;

public class PaperScoreDaoImpl implements PaperScoreDao {

	@Override
	public Long insert(PaperScoreBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into paperScore ");
		sb.append(" 	(PaperID, SubjectID, StudentID, Score, OneAnswer, TwoAnswer, ThreeAnswer, FourAnswer, FiveAnswer) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?,?,?,?,?,?,?) ");
		String sql = sb.toString();
		
		// 验证该试卷是否已经存在该题目
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getPaperID());
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getStudentID());
		paramsList.add(bean.getScore());
		paramsList.add(bean.getOneAnswer());
		paramsList.add(bean.getTwoAnswer());
		paramsList.add(bean.getThreeAnswer());
		paramsList.add(bean.getFourAnswer());
		paramsList.add(bean.getFiveAnswer());
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
		sb.append(" delete from paperScore ");
		sb.append(" where 1=1 ");
		sb.append("		and ScoreID = ? ");
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
	public Long update(PaperScoreBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update paperScore set ");
		sb.append("		PaperID = ?, ");
		sb.append("		SubjectID = ?, ");
		sb.append("		StudentID = ?, ");
		sb.append("		Score = ?, ");
		sb.append("		Status = ?, ");
		sb.append("		OneAnswer = ?, ");
		sb.append("		TwoAnswer = ?, ");
		sb.append("		ThreeAnswer = ?, ");
		sb.append("		FourAnswer = ?, ");
		sb.append("		FiveAnswer = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and ScoreID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getPaperID());
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getStudentID());
		paramsList.add(bean.getScore());
		paramsList.add(bean.getStatus());
		paramsList.add(bean.getOneAnswer());
		paramsList.add(bean.getTwoAnswer());
		paramsList.add(bean.getThreeAnswer());
		paramsList.add(bean.getFourAnswer());
		paramsList.add(bean.getFiveAnswer());
		paramsList.add(bean.getScoreID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<PaperScoreBean> list() {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomNames , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		ScoreID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listBySearch(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		ScoreID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByIDAsc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		ScoreID asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByIDDesc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		ScoreID desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByPaperNameAsc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		p.PaperName asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByPaperNameDesc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		p.PaperName desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByScoreAsc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		Score asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByScoreDesc(String search) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		Score desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public PaperScoreBean loadById(Long id) {
		PaperScoreBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ScoreID = ? ");
		sb.append(" order by ");
		sb.append("		ScoreID ");
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
	public PaperScoreBean loadById(Long paperID, Long studentID) {
		PaperScoreBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and ps.PaperID = ? ");
		sb.append("		and ps.StudentID = ? ");
		sb.append(" order by ");
		sb.append("		ScoreID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(paperID);
		paramsList.add(studentID);
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
		sb.append(" select count(*) from paperScore ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countByPaperID(Long id) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from paperScore ");
		sb.append(" where 1=1 ");
		sb.append("		and PaperID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(id);
		Object[] params = paramsList.toArray();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql, params);
		DbPub.close(conn);
	
		return result;
	}

	/**
	 * <p>Description: 获得bean对象</p>
	 * <p>Title: toBean</p>
	 * @param rs
	 * @return
	 * @throws SQLException 
	 */
	private PaperScoreBean toBean(ResultSet rs) throws SQLException {
		PaperScoreBean bean = new PaperScoreBean();
		bean.setScoreID(rs.getLong("ScoreID"));
		bean.setPaperID(rs.getLong("PaperID"));
		bean.setPaperName(rs.getString("PaperName"));
		bean.setSubjectID(rs.getLong("SubjectID"));
		bean.setSubjectName(rs.getString("SubjectName"));
		bean.setStudentID(rs.getLong("StudentID"));
		bean.setStudentName(rs.getString("StudentName"));
		bean.setScore(rs.getDouble("Score"));
		bean.setClassroom(rs.getString("RoomName"));
		bean.setGrade(rs.getString("GradeName"));
		bean.setStartOn(rs.getString("StartOn"));
		bean.setEndOn(rs.getString("EndOn"));
		bean.setOneAnswer(rs.getString("OneAnswer"));
		bean.setTwoAnswer(rs.getString("TwoAnswer"));
		bean.setThreeAnswer(rs.getString("ThreeAnswer"));
		bean.setFourAnswer(rs.getString("FourAnswer"));
		bean.setFiveAnswer(rs.getString("FiveAnswer"));
		bean.setStatus(rs.getInt("Status"));
		return bean;
	}

	@Override
	public List<PaperScoreBean> listBySearch(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		ScoreID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByIDAsc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		ScoreID asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByIDDesc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		ScoreID desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByPaperNameAsc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		p.PaperName asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByPaperNameDesc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		p.PaperName desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByScoreAsc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		Score asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public List<PaperScoreBean> listByScoreDesc(String search, Long studentID) {
		List<PaperScoreBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select ps.*, g.GradeName as GradeName, c.RoomName as RoomName , p.PaperName as PaperName ");
		sb.append("	, s.Nickname as StudentName, su.SubjectName as SubjectName ");
		sb.append("	, p.StartOn as StartOn, p.EndOn as EndOn ");
		sb.append("	from paperScore ps ");
		sb.append("		left join student s on s.StudentID=ps.StudentID ");
		sb.append("		left join paper p on p.PaperID=ps.PaperID ");
		sb.append("		left join subject su on su.SubjectID=ps.SubjectID ");
		sb.append("		left join grade g on s.GradeID=g.GradeID ");
		sb.append("		left join classroom c on s.ClassRoomID=c.RoomID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.StudentID = ? ");
		sb.append("		and (ps.Status = ? ");
		sb.append("		or GradeName like ? ");
		sb.append("		or RoomName like ? ");
		sb.append("		or PaperName like ? ");
		sb.append("		or s.Nickname like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		) ");
		sb.append(" order by ");
		sb.append("		Score desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(studentID);
		paramsList.add(statusChange(search));
		search = "%" + search + "%";
		paramsList.add(search);
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
				PaperScoreBean bean = toBean(rs);
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
	public Long searchExamStatus(Long paperID, Long studentID) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select * from paperScore ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperID = ? ");
		sb.append("		and StudentID = ? ");
		sb.append("		and Status = 1 ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(paperID);
		paramsList.add(studentID);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}
	
	/**
	 * <p>Description: 状态整型转换</p>
	 * <p>Title: statusChange</p>
	 * @param status
	 * @return
	 */
	private Integer statusChange(String status) {
		if ("未考".contains(status)) {
			return 0;
		} else if ("已考".contains(status)) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
