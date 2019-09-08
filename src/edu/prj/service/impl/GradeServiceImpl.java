package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class GradeServiceImpl implements GradeService {
	private GradeDao gradeDao = new GradeDaoImpl();

	@Override
	public Long insert(GradeBean bean) {
		return gradeDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return gradeDao.delete(id);
	}

	@Override
	public Long update(GradeBean bean) {
		return gradeDao.update(bean);
	}

	@Override
	public List<GradeBean> list() {
		return gradeDao.list();
	}

	@Override
	public List<GradeBean> listBySearch(String search) {
		return gradeDao.listBySearch(search);
	}

	@Override
	public GradeBean loadById(Long id) {
		return gradeDao.loadById(id);
	}

	@Override
	public GradeBean loadByLoginName(String loginName) {
		return gradeDao.loadByLoginName(loginName);
	}

	@Override
	public Long count() {
		return gradeDao.count();
	}

	@Override
	public Long countByNickname(String nickname) {
		return gradeDao.countByNickname(nickname);
	}

	@Override
	public List<GradeBean> listByIDAsc(String search) {
		return gradeDao.listByIDAsc(search);
	}

	@Override
	public List<GradeBean> listByIDDesc(String search) {
		return gradeDao.listByIDDesc(search);
	}

	@Override
	public List<GradeBean> listByGradeNameAsc(String search) {
		return gradeDao.listByGradeNameAsc(search);
	}

	@Override
	public List<GradeBean> listByGradeNameDesc(String search) {
		return gradeDao.listByGradeNameDesc(search);
	}

}
