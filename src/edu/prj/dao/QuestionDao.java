package edu.prj.dao;

import java.util.List;
import edu.prj.bean.exam.*;

/**
 * <p>Title: QuestionDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface QuestionDao {
	/** 添加对象 */
	Long insert(QuestionBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(QuestionBean bean);
	
	/** 遍历 */
	List<QuestionBean> list();
	
	/** 通过查询条件遍历 */
	List<QuestionBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<QuestionBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<QuestionBean> listByIDDesc(String search);
	
	/** 按类型升序遍历 */
	List<QuestionBean> listByQTypeAsc(String search);
	
	/** 按类型降序遍历 */
	List<QuestionBean> listByQTypeDesc(String search);
	
	/** 按科目升序遍历 */
	List<QuestionBean> listBySubjectNameAsc(String search);
	
	/** 按科目降序遍历 */
	List<QuestionBean> listBySubjectNameDesc(String search);
		
	/** 根据id加载对象 */
	QuestionBean loadById(Long id);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过类型获得记录数量 */
	Long countByQType(String qType);
	
	/** 通过科目获得记录数量 */
	Long countBySubjectName(String subjectName);
	
}
