package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();

	@Override
	public Long insert(PaperBean bean) {
		return paperDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return paperDao.delete(id);
	}

	@Override
	public Long update(PaperBean bean) {
		return paperDao.update(bean);
	}

	@Override
	public List<PaperBean> list() {
		return paperDao.list();
	}

	@Override
	public List<PaperBean> listBySearch(String search) {
		return paperDao.listBySearch(search);
	}

	@Override
	public List<PaperBean> listByIDAsc(String search) {
		return paperDao.listByIDAsc(search);
	}

	@Override
	public List<PaperBean> listByIDDesc(String search) {
		return paperDao.listByIDDesc(search);
	}

	@Override
	public List<PaperBean> listByPaperNameAsc(String search) {
		return paperDao.listByPaperNameAsc(search);
	}

	@Override
	public List<PaperBean> listByPaperNameDesc(String search) {
		return paperDao.listByPaperNameDesc(search);
	}

	@Override
	public List<PaperBean> listBySubjectNameAsc(String search) {
		return paperDao.listBySubjectNameAsc(search);
	}

	@Override
	public List<PaperBean> listBySubjectNameDesc(String search) {
		return paperDao.listBySubjectNameDesc(search);
	}

	@Override
	public PaperBean loadById(Long id) {
		return paperDao.loadById(id);
	}

	@Override
	public PaperBean loadByPaperName(String paperName) {
		return paperDao.loadByPaperName(paperName);
	}

	@Override
	public Long count() {
		return paperDao.count();
	}

	@Override
	public Long countByPaperName(String paperName) {
		return paperDao.countByPaperName(paperName);
	}

	@Override
	public Long countBySubjectName(String subjectName) {
		return paperDao.countBySubjectName(subjectName);
	}

	@Override
	public Long generatePaper(PaperBean bean, Long studentID) {
		return paperDao.generatePaper(bean, studentID);
	}

	@Override
	public void generatePapers(PaperBean bean) {
		paperDao.generatePapers(bean);
	}

}
