package edu.prj.bean.exam;

public class PaperItemBean {
	/** 题目项目ID */
	private Long itemID;
	/** 试卷ID */
	private Long paperID;
	/** 试卷名称 */
	private String paperName;
	/** 题库ID */
	private Long questionID;
	/** 题目 */
	private String question;
	/** 答案 */
	private String answer;
	/** 分数 */
	private Double score;
	/** 题目类型 */
	private Integer qType;
	
	public Long getItemID() {
		return itemID;
	}
	public void setItemID(Long itemID) {
		this.itemID = itemID;
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
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getQType() {
		return qType;
	}
	public void setQType(Integer qType) {
		this.qType = qType;
	}
	
}
