package edu.prj.dao;

import java.util.List;
import edu.prj.bean.*;

/**
 * <p>Title: SubjectDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface SubjectDao {
	/** 添加对象 */
	Long insert(SubjectBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(SubjectBean bean);
	
	/** 遍历 */
	List<SubjectBean> list();
	
	/** 通过查询条件遍历 */
	List<SubjectBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<SubjectBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<SubjectBean> listByIDDesc(String search);
	
	/** 按名称升序遍历 */
	List<SubjectBean> listBySubjectNameAsc(String search);
	
	/** 按名称降序遍历 */
	List<SubjectBean> listBySubjectNameDesc(String search);
		
	/** 根据id加载对象 */
	SubjectBean loadById(Long id);
	
	/** 根据名称加载对象 */
	SubjectBean loadBySubjectName(String subjectName);
	
	/** 根据两个信息加载对象 */
	SubjectBean loadByDoubleName(String subjectName, Long teacherID);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countBySubjectName(String subjectName);
}
