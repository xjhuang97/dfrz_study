package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class SubjectServiceImpl implements SubjectService {
	private SubjectDao subjectDao = new SubjectDaoImpl();

	@Override
	public Long insert(SubjectBean bean) {
		return subjectDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return subjectDao.delete(id);
	}

	@Override
	public Long update(SubjectBean bean) {
		return subjectDao.update(bean);
	}

	@Override
	public List<SubjectBean> list() {
		return subjectDao.list();
	}

	@Override
	public List<SubjectBean> listBySearch(String search) {
		return subjectDao.listBySearch(search);
	}

	@Override
	public SubjectBean loadById(Long id) {
		return subjectDao.loadById(id);
	}

	@Override
	public SubjectBean loadBySubjectName(String subjectName) {
		return subjectDao.loadBySubjectName(subjectName);
	}

	@Override
	public SubjectBean loadByDoubleName(String subjectName, Long teacherID) {
		return subjectDao.loadByDoubleName(subjectName, teacherID);
	}

	@Override
	public Long count() {
		return subjectDao.count();
	}

	@Override
	public Long countBySubjectName(String subjectName) {
		return subjectDao.countBySubjectName(subjectName);
	}

	@Override
	public List<SubjectBean> listByIDAsc(String search) {
		return subjectDao.listByIDAsc(search);
	}

	@Override
	public List<SubjectBean> listByIDDesc(String search) {
		return subjectDao.listByIDDesc(search);
	}

	@Override
	public List<SubjectBean> listBySubjectNameAsc(String search) {
		return subjectDao.listBySubjectNameAsc(search);
	}

	@Override
	public List<SubjectBean> listBySubjectNameDesc(String search) {
		return subjectDao.listBySubjectNameDesc(search);
	}


}
