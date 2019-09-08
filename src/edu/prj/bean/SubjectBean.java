package edu.prj.bean;

/**
 * <p>Title: SubjectBean</p>
 * <p>Description: 科目bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class SubjectBean {
	/** 科目ID */
	private Long subjectID;
	/** 科目名称 */
	private String subjectName;
	/** 教师ID */
	private Long teacherID;
	/** 教师名称 */
	private String teacherName;
	/** 状态 */
	private String status;
	
	public Long getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(Long subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Long getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Long teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
