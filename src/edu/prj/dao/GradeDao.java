package edu.prj.dao;

import java.util.List;
import edu.prj.bean.*;

/**
 * <p>Title: GradeDao</p>
 * <p>Description: Dao接口</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月29日
 */
public interface GradeDao {
	/** 添加对象 */
	Long insert(GradeBean bean);
	
	/** 通过id删除对象 */
	Long delete(Long id);
	
	/** 修改对象 */
	Long update(GradeBean bean);
	
	/** 遍历 */
	List<GradeBean> list();
	
	/** 通过查询条件遍历 */
	List<GradeBean> listBySearch(String search);
	
	/** 按ID升序遍历 */
	List<GradeBean> listByIDAsc(String search);
	
	/** 按ID降序遍历 */
	List<GradeBean> listByIDDesc(String search);
	
	/** 按名称升序遍历 */
	List<GradeBean> listByGradeNameAsc(String search);
	
	/** 按名称降序遍历 */
	List<GradeBean> listByGradeNameDesc(String search);
		
	/** 根据id加载对象 */
	GradeBean loadById(Long id);
	
	/** 根据账号加载对象 */
	GradeBean loadByLoginName(String loginName);
	
	/** 获得记录数量 */
	Long count();
	
	/** 通过名称获得记录数量 */
	Long countByNickname(String nickname);
}
