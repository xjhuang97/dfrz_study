package edu.prj.bean.exam;

public class PaperBean {
	/** 试卷ID */
	private Long PaperID;
	/** 科目ID */
	private Long subjectID;
	/** 科目名称 */
	private String subjectName;
	/** 试卷名称 */
	private String paperName;
	/** 总分 */
	private Double totalScore;
	/** 题目分数 */
	private Double perScore;
	/** 题目数 */
	private Integer questionNum;
	/** 考试分钟 */
	private Integer examMinute;
	/** 有效开始日期 */
	private String startOn;
	/** 有效结束日期 */
	private String endOn;
	/** 是否已生成 */
	private Integer hasGenerate;
	
	public Long getPaperID() {
		return PaperID;
	}
	public void setPaperID(Long paperID) {
		PaperID = paperID;
	}
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
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public Double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	public Double getPerScore() {
		return perScore;
	}
	public void setPerScore(Double perScore) {
		this.perScore = perScore;
	}
	public Integer getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}
	public Integer getExamMinute() {
		return examMinute;
	}
	public void setExamMinute(Integer examMinute) {
		this.examMinute = examMinute;
	}
	public String getStartOn() {
		return startOn;
	}
	public void setStartOn(String startOn) {
		this.startOn = startOn;
	}
	public String getEndOn() {
		return endOn;
	}
	public void setEndOn(String endOn) {
		this.endOn = endOn;
	}
	/**
	 * <p>Description: 获得是否已生成状态</p>
	 * <p>Title: getHasGrnerate</p>
	 * @return
	 */
	public Integer getHasGenerate() {
		return hasGenerate;
	}
	/**
	 * <p>Description: 设置是否已生成状态</p>
	 * <p>Title: setHasGrnerate</p>
	 * @param hasGrnerate
	 */
	public void setHasGenerate(Integer hasGenerate) {
		this.hasGenerate = hasGenerate;
	}
	
}
