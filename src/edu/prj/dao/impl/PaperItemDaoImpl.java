package edu.prj.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.util.DbPub;

public class PaperItemDaoImpl implements PaperItemDao {

	@Override
	public Long insert(PaperItemBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into paperItem ");
		sb.append(" 	(PaperID, QuestionID, Answer, Score) ");
		sb.append(" values ");
		sb.append(" 	(?,?,?,?) ");
		String sql = sb.toString();
		
		// 验证该试卷是否已经存在该题目
		if (questionIsRepeat(bean.getPaperID(), bean.getQuestionID()) > 0) {
			return 0L;
		}
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getPaperID());
		paramsList.add(bean.getQuestionID());
		paramsList.add(bean.getAnswer());
		paramsList.add(bean.getScore());
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
		sb.append(" delete from paperItem ");
		sb.append(" where 1=1 ");
		sb.append("		and ItemID = ? ");
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
	public Long update(PaperItemBean bean) {
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" update paperItem set ");
		sb.append("		PaperID = ?, ");
		sb.append("		QuestionID = ?, ");
		sb.append("		Answer = ?, ");
		sb.append("		Score = ?, ");
		sb.append(" where 1=1 ");
		sb.append("		and ItemID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();
		paramsList.add(bean.getPaperID());
		paramsList.add(bean.getQuestionID());
		paramsList.add(bean.getAnswer());
		paramsList.add(bean.getScore());
		paramsList.add(bean.getItemID());
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.update(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

	@Override
	public List<PaperItemBean> list() {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append(" order by ");
		sb.append("		ItemID ");
		String sql = sb.toString();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		ResultSet rs = DbPub.query(conn, sql);
		try {
			while(rs.next()) {
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listBySearch(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
		sb.append(" order by ");
		sb.append("		ItemID ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByIDAsc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
		sb.append(" order by ");
		sb.append("		ItemID asc ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByIDDesc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
		sb.append(" order by ");
		sb.append("		ItemID desc ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByPaperNameAsc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByPaperNameDesc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByScoreAsc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
		sb.append(" order by ");
		sb.append("		Score asc ");
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
				PaperItemBean bean = toBean(rs);
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
	public List<PaperItemBean> listByScoreDesc(String search) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and PaperName like ? ");
		sb.append("		or Question like ? ");
		sb.append(" order by ");
		sb.append("		Score desc ");
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
				PaperItemBean bean = toBean(rs);
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
	public PaperItemBean loadById(Long id) {
		PaperItemBean bean = null;
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and ItemID = ? ");
		sb.append(" order by ");
		sb.append("		ItemID ");
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
		sb.append(" select count(*) from paperItem ");
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
		sb.append(" select count(*) from paperItem ");
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
	
	@Override
	public List<PaperItemBean> loadPaper(Long id) {
		List<PaperItemBean> list = new ArrayList<>();
		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and p.PaperID = ? ");
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
				PaperItemBean bean = toBean(rs);
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPub.close(conn, rs);
		}
		
		return list;
	}
	
	/**
	 * <p>Description: 获得bean对象</p>
	 * <p>Title: toBean</p>
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private PaperItemBean toBean(ResultSet rs) throws SQLException {
		PaperItemBean bean = new PaperItemBean();
		bean.setItemID(rs.getLong("ItemID"));
		bean.setPaperID(rs.getLong("PaperID"));
		bean.setPaperName(rs.getString("PaperName"));
		bean.setQuestionID(rs.getLong("QuestionID"));
		bean.setQuestion(rs.getString("Question"));
		bean.setAnswer(rs.getString("Answer"));
		bean.setScore(rs.getDouble("Score"));
		bean.setQType(rs.getInt("QType"));
		return bean;
	}

	
	/**
	 * <p>Description: 验证同一张试卷是否出现重复题目</p>
	 * <p>Title: questionIsRepeat</p>
	 * @param paperID
	 * @param questionID
	 * @return
	 */
	private Long questionIsRepeat(Long paperID, Long questionID) {		
		// sql语句
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.*, p.PaperName as PaperName, q.Question as Question, q.QType as QType ");
		sb.append(" from paperItem pi ");
		sb.append(" 	left join paper p on p.PaperID=pi.PaperID ");
		sb.append(" 	left join question q on q.QuestionID=pi.questionID ");
		sb.append("	where 1=1 ");
		sb.append("		and pi.PaperID = ? ");
		sb.append("		and pi.QuestionID = ? ");
		String sql = sb.toString();
		
		// 占位符对应参数数组
		List<Object> paramsList = new ArrayList<>();		
		paramsList.add(paperID);
		paramsList.add(questionID);
		Object[] params = paramsList.toArray();
		
		// 更新MySQL
		Connection conn = DbPub.getConnection();
		Long result = DbPub.queryScalarLong(conn, sql, params);
		DbPub.close(conn);
		
		return result;
	}

}
