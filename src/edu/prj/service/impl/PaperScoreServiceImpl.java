package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class PaperScoreServiceImpl implements PaperScoreService {
	private PaperScoreDao paperScoreDao = new PaperScoreDaoImpl();
	
	@Override
	public Long insert(PaperScoreBean bean) {
		return paperScoreDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return paperScoreDao.delete(id);
	}

	@Override
	public Long update(PaperScoreBean bean) {
		return paperScoreDao.update(bean);
	}

	@Override
	public List<PaperScoreBean> list() {
		return paperScoreDao.list();
	}

	@Override
	public List<PaperScoreBean> listBySearch(String search) {
		return paperScoreDao.listBySearch(search);
	}

	@Override
	public List<PaperScoreBean> listByIDAsc(String search) {
		return paperScoreDao.listByIDAsc(search);
	}

	@Override
	public List<PaperScoreBean> listByIDDesc(String search) {
		return paperScoreDao.listByIDDesc(search);
	}

	@Override
	public List<PaperScoreBean> listByPaperNameAsc(String search) {
		return paperScoreDao.listByPaperNameAsc(search);
	}

	@Override
	public List<PaperScoreBean> listByPaperNameDesc(String search) {
		return paperScoreDao.listByPaperNameDesc(search);
	}

	@Override
	public List<PaperScoreBean> listByScoreAsc(String search) {
		return paperScoreDao.listByScoreAsc(search);
	}

	@Override
	public List<PaperScoreBean> listByScoreDesc(String search) {
		return paperScoreDao.listByScoreDesc(search);
	}

	@Override
	public PaperScoreBean loadById(Long id) {
		return paperScoreDao.loadById(id);
	}

	@Override
	public PaperScoreBean loadById(Long paperID, Long studentID) {
		return paperScoreDao.loadById(paperID, studentID);
	}

	@Override
	public Long count() {
		return paperScoreDao.count();
	}

	@Override
	public Long countByPaperID(Long id) {
		return paperScoreDao.countByPaperID(id);
	}

	@Override
	public List<PaperScoreBean> listBySearch(String search, Long studentID) {
		return paperScoreDao.listBySearch(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByIDAsc(String search, Long studentID) {
		return paperScoreDao.listByIDAsc(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByIDDesc(String search, Long studentID) {
		return paperScoreDao.listByIDDesc(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByPaperNameAsc(String search, Long studentID) {
		return paperScoreDao.listByPaperNameAsc(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByPaperNameDesc(String search, Long studentID) {
		return paperScoreDao.listByPaperNameDesc(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByScoreAsc(String search, Long studentID) {
		return paperScoreDao.listByScoreAsc(search, studentID);
	}

	@Override
	public List<PaperScoreBean> listByScoreDesc(String search, Long studentID) {
		return paperScoreDao.listByScoreDesc(search, studentID);
	}

	@Override
	public Long searchExamStatus(Long paperID, Long studentID) {
		return paperScoreDao.searchExamStatus(paperID, studentID);
	}
}
