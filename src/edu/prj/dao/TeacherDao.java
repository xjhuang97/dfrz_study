package edu.prj.dao;

import java.util.List;
import edu.prj.bean.user.*;

/**
 * <p>Title: TeacherDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface TeacherDao {
	/** 添加对象 */
	Long insert(TeacherBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(TeacherBean bean);
	
	/** 遍历 */
	List<TeacherBean> list();
	
	/** 通过查询条件遍历 */
	List<TeacherBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<TeacherBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<TeacherBean> listByIDDesc(String search);
	
	/** 按昵称升序遍历 */
	List<TeacherBean> listByNicknameAsc(String search);
	
	/** 按昵称降序遍历 */
	List<TeacherBean> listByNicknameDesc(String search);
		
	/** 根据id加载对象 */
	TeacherBean loadById(Long id);
	
	/** 根据账号加载对象 */
	TeacherBean loadByLoginName(String loginName);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByNickname(String nickname);
}
