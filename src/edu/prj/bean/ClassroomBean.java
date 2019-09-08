package edu.prj.bean;

/**
 * <p>Title: ClassRoomBean</p>
 * <p>Description: 班级bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class ClassroomBean {
	/** 班级ID */
	private Long roomID;
	/** 班级名称 */
	private String roomName;
	/** 年级ID */
	private Long gradeID;
	/** 年级名称 */
	private String gradeName;
	
	public Long getRoomID() {
		return roomID;
	}
	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Long getGradeID() {
		return gradeID;
	}
	public void setGradeID(Long gradeID) {
		this.gradeID = gradeID;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	
}
