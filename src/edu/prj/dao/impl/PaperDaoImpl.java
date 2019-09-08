package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.util.DbPub;

/**
 * <p>Title: PaperDaoImpl</p>
 * <p>Description: Dao实现类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public class PaperDaoImpl implements PaperDao {

	@Override
	public Long insert(PaperBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into paper ");
		sb.append(" 	(SubjectID, PaperName, TotalScore, PerScore, QuestionNum, ExamMinute, StartOn, EndOn) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?,?,?,?,?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getPaperName());
		paramsList.add(bean.getTotalScore());
		paramsList.add(bean.getPerScore());
		paramsList.add(bean.getQuestionNum());
		paramsList.add(bean.getExamMinute());
		paramsList.add(bean.getStartOn());
		paramsList.add(bean.getEndOn());
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
		sb.append(" delete from paper ");
		sb.append(" where 1=1 ");
		sb.append("		and PaperID = ? ");
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
	public Long update(PaperBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update paper set ");
		sb.append("		SubjectID = ?, ");
		sb.append("		PaperName = ?, ");
		sb.append("		TotalScore = ?, ");
		sb.append("		PerScore = ?, ");
		sb.append("		QuestionNum = ?, ");
		sb.append("		ExamMinute = ?, ");
		sb.append("		StartOn = ?, ");
		sb.append("		EndOn = ?, ");
		sb.append("		HasGenerate = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and PaperID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getPaperName());
		paramsList.add(bean.getTotalScore());
		paramsList.add(bean.getPerScore());
		paramsList.add(bean.getQuestionNum());
		paramsList.add(bean.getExamMinute());
		paramsList.add(bean.getStartOn());
		paramsList.add(bean.getEndOn());
		paramsList.add(bean.getHasGenerate());
		paramsList.add(bean.getPaperID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<PaperBean> list() {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		PaperID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listBySearch(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		PaperID ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listByIDAsc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		PaperID asc ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listByIDDesc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		PaperID desc ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listByPaperNameAsc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		PaperName asc ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listByPaperNameDesc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		PaperName desc ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listBySubjectNameAsc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		s.SubjectName asc ");
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
				PaperBean bean = toBean(rs);
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
	public List<PaperBean> listBySubjectNameDesc(String search) {
		List<PaperBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and paperName like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append(" order by ");
		sb.append("		s.SubjectName desc ");
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
				PaperBean bean = toBean(rs);
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
	public PaperBean loadById(Long id) {
		PaperBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperID = ? ");
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
	public PaperBean loadByPaperName(String paperName) {
		PaperBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select p.*, s.SubjectName as SubjectName ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(paperName);
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
		sb.append(" select count(*) from paper ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countByPaperName(String paperName) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from paper ");
		sb.append(" where 1=1 ");
		sb.append("		and PaperName = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(paperName);
		Object[] params = paramsList.toArray();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql, params);
		DbPub.close(conn);
	
		return result;
	}

	@Override
	public Long countBySubjectName(String subjectName) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) ");
		sb.append("	from paper p ");
		sb.append("		left join subject s on p.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and s.SubjectName = ? ");
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
	
	@Override
	public Long generatePaper(PaperBean bean, Long studentID) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into paperScore ");
		sb.append(" 	(PaperID, SubjectID, StudentID) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?) ");
		String sql = sb.toString();
			
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getPaperID());
		paramsList.add(bean.getSubjectID());
		paramsList.add(studentID);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}
	
	@Override
	public void generatePapers(PaperBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append("	select StudentID from student ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				Long studentID = rs.getLong("StudentID");
				generatePaper(bean, studentID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbPub.close(conn, rs);
	}
	
	/**
	 * <p>Description: bean对象生成</p>
	 * <p>Title: toBean</p>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private PaperBean toBean(ResultSet rs) throws SQLException {
		PaperBean bean = new PaperBean();
		bean.setPaperID(rs.getLong("PaperID"));
		bean.setSubjectID(rs.getLong("SubjectID"));
		bean.setSubjectName(rs.getString("SubjectName"));
		bean.setPaperName(rs.getString("PaperName"));
		bean.setTotalScore(rs.getDouble("TotalScore"));
		bean.setPerScore(rs.getDouble("PerScore"));
		bean.setQuestionNum(rs.getInt("QuestionNum"));
		bean.setExamMinute(rs.getInt("ExamMinute"));
		bean.setStartOn(rs.getString("StartOn"));
		bean.setEndOn(rs.getString("EndOn"));
		bean.setHasGenerate(rs.getInt("HasGenerate"));
		return bean;
	}

}
