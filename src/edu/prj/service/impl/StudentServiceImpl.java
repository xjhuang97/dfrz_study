package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.user.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public Long insert(StudentBean bean) {
		return studentDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return studentDao.delete(id);
	}

	@Override
	public Long update(StudentBean bean) {
		return studentDao.update(bean);
	}

	@Override
	public List<StudentBean> list() {
		return studentDao.list();
	}

	@Override
	public List<StudentBean> listBySearch(String search) {
		return studentDao.listBySearch(search);
	}

	@Override
	public StudentBean loadById(Long id) {
		return studentDao.loadById(id);
	}

	@Override
	public StudentBean loadByLoginName(String loginName) {
		return studentDao.loadByLoginName(loginName);
	}

	@Override
	public Long count() {
		return studentDao.count();
	}

	@Override
	public Long countByNickname(String nickname) {
		return studentDao.countByNickname(nickname);
	}
	
	@Override
	public List<StudentBean> listByIDAsc(String search) {
		return studentDao.listByIDAsc(search);
	}

	@Override
	public List<StudentBean> listByIDDesc(String search) {
		return studentDao.listByIDDesc(search);
	}

	@Override
	public List<StudentBean> listByNicknameAsc(String search) {
		return studentDao.listByNicknameAsc(search);
	}

	@Override
	public List<StudentBean> listByNicknameDesc(String search) {
		return studentDao.listByNicknameDesc(search);
	}

	@Override
	public List<StudentBean> listByIDAsc(String search, Long gradeID, Long classroomID) {
		return studentDao.listByIDAsc(search, gradeID, classroomID);
	}

	@Override
	public List<StudentBean> listByIDDesc(String search, Long gradeID, Long classroomID) {
		return studentDao.listByIDDesc(search, gradeID, classroomID);
	}

	@Override
	public List<StudentBean> listByNicknameAsc(String search, Long gradeID, Long classroomID) {
		return studentDao.listByNicknameAsc(search, gradeID, classroomID);
	}

	@Override
	public List<StudentBean> listByNicknameDesc(String search, Long gradeID, Long classroomID) {
		return studentDao.listByNicknameDesc(search, gradeID, classroomID);
	}
}
