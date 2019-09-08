package edu.prj.bean.user;

/**
 * <p>Title: StudentBean</p>
 * <p>Description: 学生bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class StudentBean extends UserBean{
	/** 年级ID */
	private Long gradeID;
	/** 班级ID */
	private Long classRoomID;
	/** 年级名称 */
	private String gradeName;
	/** 班级名称 */
	private String classRoomName;
	
	public Long getGradeID() {
		return gradeID;
	}

	public void setGradeID(Long gradeID) {
		this.gradeID = gradeID;
	}

	public Long getClassRoomID() {
		return classRoomID;
	}

	public void setClassRoomID(Long classRoomID) {
		this.classRoomID = classRoomID;
	}
	
	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}

	/**
	 * <p>Description: 获得学生ID</p>
	 * <p>Title: getStudentID</p>
	 * @return
	 */
	public Long getStudentID() {
		return this.getID();
	}
	
	/**
	 * <p>Description: 设置学生ID</p>
	 * <p>Title: setStudentID</p>
	 * @param studentID
	 */
	public void setStudentID(Long studentID) {
		this.setID(studentID);
	}
	
	/**
	 * <p>Description: 介绍</p>
	 * <p>Title: introduce</p>
	 */
	public void introduce() {
		System.out.println("【学生】"+this.getNickname());
	}
}
