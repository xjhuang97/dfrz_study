package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class ClassroomServiceImpl implements ClassroomService {
	private ClassroomDao classroomDao = new ClassroomDaoImpl();

	@Override
	public Long insert(ClassroomBean bean) {
		return classroomDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return classroomDao.delete(id);
	}

	@Override
	public Long update(ClassroomBean bean) {
		return classroomDao.update(bean);
	}

	@Override
	public List<ClassroomBean> list() {
		return classroomDao.list();
	}

	@Override
	public List<ClassroomBean> listBySearch(String search) {
		return classroomDao.listBySearch(search);
	}

	@Override
	public ClassroomBean loadById(Long id) {
		return classroomDao.loadById(id);
	}

	@Override
	public ClassroomBean loadByClassroomName(String classroomName) {
		return classroomDao.loadByClassroomName(classroomName);
	}

	@Override
	public ClassroomBean loadByDoubleName(String classroomName, Long gradeID) {
		return classroomDao.loadByDoubleName(classroomName, gradeID);
	}

	@Override
	public Long count() {
		return classroomDao.count();
	}

	@Override
	public Long countByClassroomName(String classroomName) {
		return classroomDao.countByClassroomName(classroomName);
	}

	@Override
	public List<ClassroomBean> listByIDAsc(String search) {
		return classroomDao.listByIDAsc(search);
	}

	@Override
	public List<ClassroomBean> listByIDDesc(String search) {
		return classroomDao.listByIDDesc(search);
	}

	@Override
	public List<ClassroomBean> listByClassroomNameAsc(String search) {
		return classroomDao.listByClassroomNameAsc(search);
	}

	@Override
	public List<ClassroomBean> listByClassroomNameDesc(String search) {
		return classroomDao.listByClassroomNameDesc(search);
	}


}
