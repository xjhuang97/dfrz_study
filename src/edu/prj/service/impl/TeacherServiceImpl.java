package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.user.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherDao = new TeacherDaoImpl();

	@Override
	public Long insert(TeacherBean bean) {
		return teacherDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return teacherDao.delete(id);
	}

	@Override
	public Long update(TeacherBean bean) {
		return teacherDao.update(bean);
	}

	@Override
	public List<TeacherBean> list() {
		return teacherDao.list();
	}

	@Override
	public List<TeacherBean> listBySearch(String search) {
		return teacherDao.listBySearch(search);
	}

	@Override
	public TeacherBean loadById(Long id) {
		return teacherDao.loadById(id);
	}

	@Override
	public TeacherBean loadByLoginName(String loginName) {
		return teacherDao.loadByLoginName(loginName);
	}

	@Override
	public Long count() {
		return teacherDao.count();
	}

	@Override
	public Long countByNickname(String nickname) {
		return teacherDao.countByNickname(nickname);
	}
	
	@Override
	public List<TeacherBean> listByIDAsc(String search) {
		return teacherDao.listByIDAsc(search);
	}

	@Override
	public List<TeacherBean> listByIDDesc(String search) {
		return teacherDao.listByIDDesc(search);
	}

	@Override
	public List<TeacherBean> listByNicknameAsc(String search) {
		return teacherDao.listByNicknameAsc(search);
	}

	@Override
	public List<TeacherBean> listByNicknameDesc(String search) {
		return teacherDao.listByNicknameDesc(search);
	}

}
