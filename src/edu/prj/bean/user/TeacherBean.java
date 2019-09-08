package edu.prj.bean.user;

/**
 * <p>Title: TeacherBean</p>
 * <p>Description: 教师bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class TeacherBean extends UserBean{
	/**
	 * <p>Description: 获得教师ID</p>
	 * <p>Title: getTeacherID</p>
	 * @return
	 */
	public Long getTeacherID() {
		return this.getID();
	}
	
	/**
	 * <p>Description: 设置教师ID</p>
	 * <p>Title: setTeacherID</p>
	 * @param teacherID
	 */
	public void setTeacherID(Long teacherID) {
		this.setID(teacherID);
	}
	
	/**
	 * <p>Description: 介绍</p>
	 * <p>Title: introduce</p>
	 */
	public void introduce() {
		System.out.println("【教师】"+this.getNickname());
	}
}
