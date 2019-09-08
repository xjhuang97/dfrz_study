package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.util.DbPub;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public Long insert(QuestionBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into question ");
		sb.append(" 	(QType, Question, ItemA, ItemB, ItemC, ItemD, ItemE, ItemF, Answer, SubjectID, Tag) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?,?,?,?,?,?,?,?,?) ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getQType());
		paramsList.add(bean.getQuestion());
		paramsList.add(bean.getItemA());
		paramsList.add(bean.getItemB());
		paramsList.add(bean.getItemC());
		paramsList.add(bean.getItemD());
		paramsList.add(bean.getItemE());
		paramsList.add(bean.getItemF());
		paramsList.add(bean.getAnswer());
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getTag());
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
		sb.append(" delete from question ");
		sb.append(" where 1=1 ");
		sb.append("		and QuestionID = ? ");
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
	public Long update(QuestionBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update question set ");
		sb.append("		QType = ?, ");
		sb.append("		Question = ?, ");
		sb.append("		ItemA = ?, ");
		sb.append("		ItemB = ?, ");
		sb.append("		ItemC = ?, ");
		sb.append("		ItemD = ?, ");
		sb.append("		ItemE = ?, ");
		sb.append("		ItemF = ?, ");
		sb.append("		Answer = ?, ");
		sb.append("		SubjectID = ?, ");
		sb.append("		Tag = ? ");
		sb.append(" where 1=1 ");
		sb.append("		and QuestionID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getQType());
		paramsList.add(bean.getQuestion());
		paramsList.add(bean.getItemA());
		paramsList.add(bean.getItemB());
		paramsList.add(bean.getItemC());
		paramsList.add(bean.getItemD());
		paramsList.add(bean.getItemE());
		paramsList.add(bean.getItemF());
		paramsList.add(bean.getAnswer());
		paramsList.add(bean.getSubjectID());
		paramsList.add(bean.getTag());
		paramsList.add(bean.getQuestionID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<QuestionBean> list() {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		QuestionID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listBySearch(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");		
		sb.append(" order by ");
		sb.append("		QuestionID ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listByIDAsc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		QuestionID asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listByIDDesc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		QuestionID desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listByQTypeAsc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		QType asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listByQTypeDesc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		QType desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listBySubjectNameAsc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		s.SubjectName asc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public List<QuestionBean> listBySubjectNameDesc(String search) {
		List<QuestionBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QType = ? ");
		sb.append("		or Question like ? ");
		sb.append("		or SubjectName like ? ");
		sb.append("		or Tag like ? ");	
		sb.append(" order by ");
		sb.append("		s.SubjectName desc ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(search));
		search = "%" + search + "%";
		paramsList.add(search);
		paramsList.add(search);
		paramsList.add(search);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql, params);
		try {
			while(rs.next()) {
				QuestionBean bean = toBean(rs);
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
	public QuestionBean loadById(Long id) {
		QuestionBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select q.*, s.SubjectName as SubjectName ");
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
		sb.append("	where 1=1 ");
		sb.append("		and QuestionID = ? ");
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
	public Long count() {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from question ");
		sb.append(" where 1=1 ");
		String sql = sb.toString();
	
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql);
		DbPub.close(conn);
	
		return result;
	}
	

	@Override
	public Long countByQType(String qType) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) from question ");
		sb.append(" where 1=1 ");
		sb.append("		and QType = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(typeChangeInt(qType));
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
		sb.append("	from question q ");
		sb.append("		left join subject s on q.SubjectID=s.SubjectID ");
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
	
	
	/**
	 * <p>Description: 题目类型转换</p>
	 * <p>Title: typeChange</p>
	 * @param qType
	 * @return
	 */
	private Integer typeChangeInt(String qType) {
		// 1为单选题、2为多选题、3为判断题
		if ("单选题".contains(qType)) {
			return 1;
		} else if ("多选题".contains(qType)){
			return 2;
		} else if ("判断题".contains(qType)) {
			return 3;
		} else {
			return 0;
		}
	}	
	
	/**
	 * <p>Description: bean对象生成</p>
	 * <p>Title: toBean</p>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private QuestionBean toBean(ResultSet rs) throws SQLException {
		QuestionBean bean = new QuestionBean();
		bean.setQuestionID(rs.getLong("QuestionID"));
		bean.setQType(rs.getInt("QType"));
		bean.setQuestion(rs.getString("Question"));
		bean.setItemA(rs.getString("ItemA"));
		bean.setItemB(rs.getString("ItemB"));
		bean.setItemC(rs.getString("ItemC"));
		bean.setItemD(rs.getString("ItemD"));
		bean.setItemE(rs.getString("ItemE"));
		bean.setItemF(rs.getString("ItemF"));
		bean.setAnswer(rs.getString("Answer"));
		bean.setSubjectID(rs.getLong("SubjectID"));
		bean.setSubjectName(rs.getString("SubjectName"));
		bean.setTag(rs.getString("Tag"));
		return bean;
	}

}
