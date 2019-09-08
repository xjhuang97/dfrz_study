package edu.prj.service;

import java.util.List;

import edu.prj.bean.user.*;

public interface ManagerService {
	/** 添加对象 */
	Long insert(ManagerBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(ManagerBean bean);
	
	/** 遍历 */
	List<ManagerBean> list();
	
	/** 通过账号遍历 */
	List<ManagerBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<ManagerBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<ManagerBean> listByIDDesc(String search);
	
	/** 按昵称升序遍历 */
	List<ManagerBean> listByNicknameAsc(String search);
	
	/** 按昵称降序遍历 */
	List<ManagerBean> listByNicknameDesc(String search);
	
	/** 根据id加载对象 */
	ManagerBean loadById(Long id);
	
	/** 根据账号加载对象 */
	ManagerBean loadByLoginName(String loginName);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByNickname(String nickname);
}
