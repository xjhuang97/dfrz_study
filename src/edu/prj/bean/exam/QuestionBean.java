package edu.prj.bean.exam;

public class QuestionBean {
	/** 题目ID */
	private Long questionID;
	/** 题目类型 */
	private Integer qType;
	/** 题目内容 */
	private String question;
	/** 选项A内容 */
	private String itemA;
	/** 选项B内容 */
	private String itemB;
	/** 选项C内容 */
	private String itemC;
	/** 选项D内容 */
	private String itemD;
	/** 选项E内容 */
	private String itemE;
	/** 选项F内容 */
	private String itemF;
	/** 答案 */
	private String answer;
	/** 所属科目ID */
	private Long subjectID;
	/** 所属科目 */
	private String subjectName;
	/** 标签 */
	private String tag;
	
	public Long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}
	public Integer getQType() {
		return qType;
	}
	public void setQType(Integer qType) {
		this.qType = qType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getItemA() {
		return itemA;
	}
	public void setItemA(String itemA) {
		this.itemA = itemA;
	}
	public String getItemB() {
		return itemB;
	}
	public void setItemB(String itemB) {
		this.itemB = itemB;
	}
	public String getItemC() {
		return itemC;
	}
	public void setItemC(String itemC) {
		this.itemC = itemC;
	}
	public String getItemD() {
		return itemD;
	}
	public void setItemD(String itemD) {
		this.itemD = itemD;
	}
	public String getItemE() {
		return itemE;
	}
	public void setItemE(String itemE) {
		this.itemE = itemE;
	}
	public String getItemF() {
		return itemF;
	}
	public void setItemF(String itemF) {
		this.itemF = itemF;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
