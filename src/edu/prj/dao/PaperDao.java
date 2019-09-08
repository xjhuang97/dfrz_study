package edu.prj.dao;

import java.util.List;
import edu.prj.bean.exam.*;

/**
 * <p>Title: PaperDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface PaperDao {
	/** 添加对象 */
	Long insert(PaperBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(PaperBean bean);
	
	/** 遍历 */
	List<PaperBean> list();
	
	/** 通过查询条件遍历 */
	List<PaperBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<PaperBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<PaperBean> listByIDDesc(String search);
	
	/** 按名称升序遍历 */
	List<PaperBean> listByPaperNameAsc(String search);
	
	/** 按名称降序遍历 */
	List<PaperBean> listByPaperNameDesc(String search);
	
	/** 按科目升序遍历 */
	List<PaperBean> listBySubjectNameAsc(String search);
	
	/** 按科目降序遍历 */
	List<PaperBean> listBySubjectNameDesc(String search);
		
	/** 根据id加载对象 */
	PaperBean loadById(Long id);
	
	/** 根据账号加载对象 */
	PaperBean loadByPaperName(String paperName);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByPaperName(String paperName);
	
	/** 通过科目获得记录数量 */
	Long countBySubjectName(String subjectName);
	
	/** 预生成试卷 */
	Long generatePaper(PaperBean bean, Long studentID);
	
	/** 为所有学生生成试卷 */
	void generatePapers(PaperBean bean);
}
