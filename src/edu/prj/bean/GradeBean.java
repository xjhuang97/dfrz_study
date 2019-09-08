package edu.prj.bean;

/**
 * <p>Title: GradeBean</p>
 * <p>Description: 年级bean类</p>
 * @author xj_huang
 * @version v1.0
 * @data 2019年8月28日
 */
public class GradeBean {
	/** 年级ID */
	private Long gradeID;
	/** 年级名称 */
	private String gradeName;
	/** 创建日期，datetime用String处理 */
	private String createOn;
	/** 创建人员ID */
	private Long createBy;
	/** 修改日期，datetime用String处理 */
	private String updateOn;
	/** 修改人员ID */
	private Long updateBy;
	
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
	public String getCreateOn() {
		return createOn;
	}
	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public String getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(String updateOn) {
		this.updateOn = updateOn;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	
}
