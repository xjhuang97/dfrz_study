package edu.prj.service;

import java.util.List;

import edu.prj.bean.user.*;

public interface StudentService {
	/** 添加对象 */
	Long insert(StudentBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(StudentBean bean);
	
	/** 遍历 */
	List<StudentBean> list();
	
	/** 通过账号遍历 */
	List<StudentBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<StudentBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<StudentBean> listByIDDesc(String search);
	
	/** 按昵称升序遍历 */
	List<StudentBean> listByNicknameAsc(String search);
	
	/** 按昵称降序遍历 */
	List<StudentBean> listByNicknameDesc(String search);
	
	/** 按ID升序遍历 */
	List<StudentBean> listByIDAsc(String search, Long gradeID, Long classroomID);
	
	/** 按ID降序遍历 */
	List<StudentBean> listByIDDesc(String search, Long gradeID, Long classroomID);
	
	/** 按昵称升序遍历 */
	List<StudentBean> listByNicknameAsc(String search, Long gradeID, Long classroomID);
	
	/** 按昵称降序遍历 */
	List<StudentBean> listByNicknameDesc(String search, Long gradeID, Long classroomID);
	
	/** 根据id加载对象 */
	StudentBean loadById(Long id);
	
	/** 根据账号加载对象 */
	StudentBean loadByLoginName(String loginName);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByNickname(String nickname);
}
