package edu.prj.dao;

import java.util.List;
import edu.prj.bean.exam.*;

/**
 * <p>Title: PaperItemDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface PaperItemDao {
	/** 添加对象 */
	Long insert(PaperItemBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(PaperItemBean bean);
	
	/** 遍历 */
	List<PaperItemBean> list();
	
	/** 通过查询条件遍历 */
	List<PaperItemBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<PaperItemBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<PaperItemBean> listByIDDesc(String search);
	
	/** 按试卷名称升序遍历 */
	List<PaperItemBean> listByPaperNameAsc(String search);
	
	/** 按试卷名称降序遍历 */
	List<PaperItemBean> listByPaperNameDesc(String search);
	
	/** 按分数升序遍历 */
	List<PaperItemBean> listByScoreAsc(String search);
	
	/** 按分数降序遍历 */
	List<PaperItemBean> listByScoreDesc(String search);
		
	/** 根据id加载对象 */
	PaperItemBean loadById(Long id);
	
	/** 获得记录数量 */
	Long count();
	
	/** 根据试卷ID获得记录数量 */
	Long countByPaperID(Long id);
	
	/** 加载试卷题目 */
	List<PaperItemBean> loadPaper(Long id);
	
}
