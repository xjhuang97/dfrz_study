package edu.prj.dao;

import java.util.List;
import edu.prj.bean.exam.*;

public interface PaperScoreDao {
	/** 添加对象 */
	Long insert(PaperScoreBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(PaperScoreBean bean);
	
	/** 遍历 */
	List<PaperScoreBean> list();
	
	/** 通过查询条件遍历 */
	List<PaperScoreBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<PaperScoreBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<PaperScoreBean> listByIDDesc(String search);
	
	/** 按试卷名称升序遍历 */
	List<PaperScoreBean> listByPaperNameAsc(String search);
	
	/** 按试卷名称降序遍历 */
	List<PaperScoreBean> listByPaperNameDesc(String search);
	
	/** 按分数升序遍历 */
	List<PaperScoreBean> listByScoreAsc(String search);
	
	/** 按分数降序遍历 */
	List<PaperScoreBean> listByScoreDesc(String search);
		
	/** 根据id加载对象 */
	PaperScoreBean loadById(Long id);
	
	/** 根据两个id加载对象 */
	PaperScoreBean loadById(Long paperID, Long studentID);
	
	/** 获得记录数量 */
	Long count();
	
	/** 根据试卷ID获得记录数量 */
	Long countByPaperID(Long id);

	/** 通过查询条件遍历 */
	List<PaperScoreBean> listBySearch(String search, Long studentID);
	
	/** 按ID升序遍历 */
	List<PaperScoreBean> listByIDAsc(String search, Long studentID);
	
	/** 按ID降序遍历 */
	List<PaperScoreBean> listByIDDesc(String search, Long studentID);
	
	/** 按试卷名称升序遍历 */
	List<PaperScoreBean> listByPaperNameAsc(String search, Long studentID);
	
	/** 按试卷名称降序遍历 */
	List<PaperScoreBean> listByPaperNameDesc(String search, Long studentID);
	
	/** 按分数升序遍历 */
	List<PaperScoreBean> listByScoreAsc(String search, Long studentID);
	
	/** 按分数降序遍历 */
	List<PaperScoreBean> listByScoreDesc(String search, Long studentID);
	
	/** 查看考试状态 */
	Long searchExamStatus(Long paperID, Long studentID);
}
