package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.exam.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class PaperItemServiceImpl implements PaperItemService {
	private PaperItemDao paperItemDao = new PaperItemDaoImpl();
	
	@Override
	public Long insert(PaperItemBean bean) {
		return paperItemDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return paperItemDao.delete(id);
	}

	@Override
	public Long update(PaperItemBean bean) {
		return paperItemDao.update(bean);
	}

	@Override
	public List<PaperItemBean> list() {
		return paperItemDao.list();
	}

	@Override
	public List<PaperItemBean> listBySearch(String search) {
		return paperItemDao.listBySearch(search);
	}

	@Override
	public List<PaperItemBean> listByIDAsc(String search) {
		return paperItemDao.listByIDAsc(search);
	}

	@Override
	public List<PaperItemBean> listByIDDesc(String search) {
		return paperItemDao.listByIDAsc(search);
	}

	@Override
	public List<PaperItemBean> listByPaperNameAsc(String search) {
		return paperItemDao.listByPaperNameAsc(search);
	}

	@Override
	public List<PaperItemBean> listByPaperNameDesc(String search) {
		return paperItemDao.listByPaperNameDesc(search);
	}

	@Override
	public List<PaperItemBean> listByScoreAsc(String search) {
		return paperItemDao.listByScoreAsc(search);
	}

	@Override
	public List<PaperItemBean> listByScoreDesc(String search) {
		return paperItemDao.listByScoreDesc(search);
	}

	@Override
	public PaperItemBean loadById(Long id) {
		return paperItemDao.loadById(id);
	}

	@Override
	public Long count() {
		return paperItemDao.count();
	}

	@Override
	public Long countByPaperID(Long id) {
		return paperItemDao.countByPaperID(id);
	}

	@Override
	public List<PaperItemBean> loadPaper(Long id) {
		return paperItemDao.loadPaper(id);
	}

}
