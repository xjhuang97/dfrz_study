package edu.util;

import java.util.ArrayList;
import java.util.List;

import edu.prj.bean.*;
import edu.prj.bean.exam.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.LoginFrm;

public class Data {
	/** 年份数组 */
	public static String[] years = {"请选择年份", "2019", "2020", "2021"};
	/** 月份数组 */
	public static String[] months = {"请选择月份", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	/** 日期数组 */
	public static String[] days = {"请选择日期", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", 
			"23", "24", "25", "26", "27", "28", "29", "30", "31"};
	/** 年级数组 */
	public static String[] grades = {"请选择年级", "高一", "高二", "高三"};
	/** 班级数组 */
	public static String[] classrooms = {"请选择班级", "一班", "二班", "三班"};
	/** 题目类型数组 */
	public static String[] types = {"请选择类型", "单选题", "多选题", "判断题"};
	/** 科目数组 */
	public static String[] subjects;
	/** 题号数组 */
	public static String[] questionIDs;
	/** 教师数组 */
	public static String[] teachers;
	/** 科目集合 */
	private static List<String> subjectList = new ArrayList<>();
	/** 教师姓名集合 */
	private static List<String> teacherList = new ArrayList<>();
	/** 题库题目ID集合 */
	private static List<String> questionIDList = new ArrayList<>();
	
	static {
		loadSubject();
		loadTeacher();
		loadQuestionID();
	}
	
	/**
	 * <p>Description: 运行</p>
	 * <p>Title: run</p>
	 */
	public static void run() {
		LoginFrm frm = new LoginFrm();
		frm.showFrm();
	}
	
	/**
	 * <p>Description: 加载老师姓名数据</p>
	 * <p>Title: loadTeacher</p>
	 */
	private static void loadTeacher() {
		TeacherService teacherService = new TeacherServiceImpl();
		for (TeacherBean t : teacherService.list()) {
			teacherList.add(t.getNickname());
		}
		Integer length = teacherList.size()+1;
		teachers = new String[length];
		teachers[0] = "请选择教师";
		for (int i = 1; i < length; i++) {
			teachers[i] = teacherList.get(i-1);
		}
	}
	
	/**
	 * <p>Description: 加载题库题目ID数据</p>
	 * <p>Title: loadQuestionID</p>
	 */
	private static void loadQuestionID() {
		QuestionService questionService = new QuestionServiceImpl();
		for (QuestionBean q : questionService.list()) {
			questionIDList.add(q.getQuestionID()+"");
		}
		Integer length = questionIDList.size()+1;
		questionIDs = new String[length];
		questionIDs[0] = "请选择题号";
		for (int i = 1; i < length; i++) {
			questionIDs[i] = questionIDList.get(i-1);
		}
	}
	
	/**
	 * <p>Description: 加载科目名称数据</p>
	 * <p>Title: loadSubject</p>
	 */
	private static void loadSubject() {
		SubjectService subjectService = new SubjectServiceImpl();
		for (SubjectBean s : subjectService.list()) {
			subjectList.add(s.getSubjectName());
		}
		Integer length = subjectList.size()+1;
		subjects = new String[length];
		subjects[0] = "请选择科目";
		for (int i = 1; i < length; i++) {
			subjects[i] = subjectList.get(i-1);
		}
	}
}
