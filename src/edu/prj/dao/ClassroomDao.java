package edu.prj.dao;

import java.util.List;
import edu.prj.bean.*;

/**
 * <p>Title: ClassroomDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface ClassroomDao {
	/** 添加对象 */
	Long insert(ClassroomBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(ClassroomBean bean);
	
	/** 遍历 */
	List<ClassroomBean> list();
	
	/** 通过查询条件遍历 */
	List<ClassroomBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<ClassroomBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<ClassroomBean> listByIDDesc(String search);
	
	/** 按名称升序遍历 */
	List<ClassroomBean> listByClassroomNameAsc(String search);
	
	/** 按名称降序遍历 */
	List<ClassroomBean> listByClassroomNameDesc(String search);
		
	/** 根据id加载对象 */
	ClassroomBean loadById(Long id);
	
	/** 根据名称加载对象 */
	ClassroomBean loadByClassroomName(String classroomName);
	
	/** 根据两个信息加载对象 */
	ClassroomBean loadByDoubleName(String classroomName, Long gradeID);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByClassroomName(String classroomName);
}
