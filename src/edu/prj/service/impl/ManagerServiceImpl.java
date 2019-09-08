package edu.prj.service.impl;

import java.util.List;

import edu.prj.bean.user.*;
import edu.prj.dao.*;
import edu.prj.dao.impl.*;
import edu.prj.service.*;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao = new ManagerDaoImpl();

	@Override
	public Long insert(ManagerBean bean) {
		return managerDao.insert(bean);
	}

	@Override
	public Long delete(Long id) {
		return managerDao.delete(id);
	}

	@Override
	public Long update(ManagerBean bean) {
		return managerDao.update(bean);
	}

	@Override
	public List<ManagerBean> list() {
		return managerDao.list();
	}

	@Override
	public List<ManagerBean> listBySearch(String search) {
		return managerDao.listBySearch(search);
	}

	@Override
	public ManagerBean loadById(Long id) {
		return managerDao.loadById(id);
	}

	@Override
	public ManagerBean loadByLoginName(String loginName) {
		return managerDao.loadByLoginName(loginName);
	}

	@Override
	public Long count() {
		return managerDao.count();
	}

	@Override
	public Long countByNickname(String nickname) {
		return managerDao.countByNickname(nickname);
	}

	@Override
	public List<ManagerBean> listByIDAsc(String search) {
		return managerDao.listByIDAsc(search);
	}

	@Override
	public List<ManagerBean> listByIDDesc(String search) {
		return managerDao.listByIDDesc(search);
	}

	@Override
	public List<ManagerBean> listByNicknameAsc(String search) {
		return managerDao.listByNicknameAsc(search);
	}

	@Override
	public List<ManagerBean> listByNicknameDesc(String search) {
		return managerDao.listByNicknameDesc(search);
	}

}
