package edu.prj.bean.exam;

public class PaperScoreBean {
	/** 成绩ID */
	private Long scoreID;
	/** 试卷ID */
	private Long paperID;
	/** 试卷名称 */
	private String paperName;
	/** 科目ID */
	private Long subjectID;
	/** 所属科目 */
	private String subjectName;
	/** 学生ID */
	private Long studentID;
	/** 学生姓名 */
	private String studentName;
	/** 成绩 */
	private Double score;
	/** 班级 */
	private String classroom;
	/** 年级 */
	private String grade;
	/** 考试状态 */
	private Integer status;
	/** 有效开始日期 */
	private String startOn;
	/** 有效结束日期 */
	private String endOn;
	/** 题目一答案选项 */
	private String oneAnswer;
	/** 题目二答案选项 */
	private String twoAnswer;
	/** 题目三答案选项 */
	private String threeAnswer;
	/** 题目四答案选项 */
	private String fourAnswer;
	/** 题目五答案选项 */
	private String fiveAnswer;
	
	public Long getScoreID() {
		return scoreID;
	}
	public void setScoreID(Long scoreID) {
		this.scoreID = scoreID;
	}
	public Long getPaperID() {
		return paperID;
	}
	public void setPaperID(Long paperID) {
		this.paperID = paperID;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
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
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getOneAnswer() {
		return oneAnswer;
	}
	public void setOneAnswer(String oneAnswer) {
		this.oneAnswer = oneAnswer;
	}
	public String getTwoAnswer() {
		return twoAnswer;
	}
	public void setTwoAnswer(String twoAnswer) {
		this.twoAnswer = twoAnswer;
	}
	public String getThreeAnswer() {
		return threeAnswer;
	}
	public void setThreeAnswer(String threeAnswer) {
		this.threeAnswer = threeAnswer;
	}
	public String getFourAnswer() {
		return fourAnswer;
	}
	public void setFourAnswer(String fourAnswer) {
		this.fourAnswer = fourAnswer;
	}
	public String getFiveAnswer() {
		return fiveAnswer;
	}
	public void setFiveAnswer(String fiveAnswer) {
		this.fiveAnswer = fiveAnswer;
	}
	
}
