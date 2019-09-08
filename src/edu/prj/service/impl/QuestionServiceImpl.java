package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class QuestionServiceImpl implements QuestionService {
	private QuestionDao questionDao = new QuestionDaoImpl();
	@Override
	public Long insert(QuestionBean bean) {
		return questionDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return questionDao.delete(id);
	}

	@Override
	public Long update(QuestionBean bean) {
		return questionDao.update(bean);
	}

	@Override
	public List<QuestionBean> list() {
		return questionDao.list();
	}

	@Override
	public List<QuestionBean> listBySearch(String search) {
		return questionDao.listBySearch(search);
	}

	@Override
	public List<QuestionBean> listByIDAsc(String search) {
		return questionDao.listByIDAsc(search);
	}

	@Override
	public List<QuestionBean> listByIDDesc(String search) {
		return questionDao.listByIDDesc(search);
	}

	@Override
	public List<QuestionBean> listByQTypeAsc(String search) {
		return questionDao.listByQTypeAsc(search);
	}

	@Override
	public List<QuestionBean> listByQTypeDesc(String search) {
		return questionDao.listByQTypeDesc(search);
	}

	@Override
	public List<QuestionBean> listBySubjectNameAsc(String search) {
		return questionDao.listBySubjectNameAsc(search);
	}

	@Override
	public List<QuestionBean> listBySubjectNameDesc(String search) {
		return questionDao.listBySubjectNameDesc(search);
	}

	@Override
	public QuestionBean loadById(Long id) {
		return questionDao.loadById(id);
	}

	@Override
	public Long count() {
		return questionDao.count();
	}

	@Override
	public Long countByQType(String qType) {
		return questionDao.countByQType(qType);
	}

	@Override
	public Long countBySubjectName(String subjectName) {
		return questionDao.countBySubjectName(subjectName);
	}

}
