package edu.prj.ui.crud.paperItem;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

import edu.prj.bean.exam.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.student.*;
import edu.prj.ui.function.teacher.*;
import edu.util.Data;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class PaperResultFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 试卷信息面板 */
	private JPanel pnlMessage;
	/** 题目一面板 */
	private JPanel pnlQuestionOne;
	/** 题目二面板 */
	private JPanel pnlQuestionTwo;
	/** 题目三面板 */
	private JPanel pnlQuestionThree;
	/** 题目四面板 */
	private JPanel pnlQuestionFour;
	/** 题目五面板 */
	private JPanel pnlQuestionFive;
	/** 题目一下拉框 */
	private JPanel pnlQuestionOneCbo;
	/** 题目二下拉框 */
	private JPanel pnlQuestionTwoCbo;
	/** 题目三下拉框 */
	private JPanel pnlQuestionThreeCbo;
	/** 题目四下拉框 */
	private JPanel pnlQuestionFourCbo;
	/** 题目五下拉框 */
	private JPanel pnlQuestionFiveCbo;
	/** 题目一信息面板 */
	private JPanel pnlQuestionOneInfo;
	/** 题目二信息面板 */
	private JPanel pnlQuestionTwoInfo;
	/** 题目三信息面板 */
	private JPanel pnlQuestionThreeInfo;
	/** 题目四信息面板 */
	private JPanel pnlQuestionFourInfo;
	/** 题目五信息面板 */
	private JPanel pnlQuestionFiveInfo;
	/** 按钮操作信息面板 */
	private JPanel pnlBtnOpearator;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 题目一题目信息标签 */
	private JLabel lblQuestionOne;
	/** 题目二题目信息标签 */
	private JLabel lblQuestionTwo;
	/** 题目三题目信息标签 */
	private JLabel lblQuestionThree;
	/** 题目四题目信息标签 */
	private JLabel lblQuestionFour;
	/** 题目五题目信息标签 */
	private JLabel lblQuestionFive;
	/** 考试信息标签 */
	private JLabel lblMessage;
	/** 题目一答案选项 */
	private JRadioButton rdoQuestionOneItemA;
	private JRadioButton rdoQuestionOneItemB;
	private JRadioButton rdoQuestionOneItemC;
	private JRadioButton rdoQuestionOneItemD;
	private ButtonGroup btngrpQuestionOneItem = new ButtonGroup();
	/** 题目二答案选项 */
	private JRadioButton rdoQuestionTwoItemA;
	private JRadioButton rdoQuestionTwoItemB;
	private JRadioButton rdoQuestionTwoItemC;
	private JRadioButton rdoQuestionTwoItemD;
	private ButtonGroup btngrpQuestionTwoItem;
	/** 题目三答案选项 */
	private JRadioButton rdoQuestionThreeItemA;
	private JRadioButton rdoQuestionThreeItemB;
	private JRadioButton rdoQuestionThreeItemC;
	private JRadioButton rdoQuestionThreeItemD;
	private ButtonGroup btngrpQuestionThreeItem;
	/** 题目四答案选项 */
	private JRadioButton rdoQuestionFourItemA;
	private JRadioButton rdoQuestionFourItemB;
	private JRadioButton rdoQuestionFourItemC;
	private JRadioButton rdoQuestionFourItemD;
	private ButtonGroup btngrpQuestionFourItem;
	/** 题目五答案选项 */
	private JRadioButton rdoQuestionFiveItemA;
	private JRadioButton rdoQuestionFiveItemB;
	private JRadioButton rdoQuestionFiveItemC;
	private JRadioButton rdoQuestionFiveItemD;
	private ButtonGroup btngrpQuestionFiveItem;
	
	/** 题目一下拉框 */
	private JComboBox<String> cboQuestionOne;
	/** 题目二下拉框 */
	private JComboBox<String> cboQuestionTwo;
	/** 题目三下拉框 */
	private JComboBox<String> cboQuestionThree;
	/** 题目四下拉框 */
	private JComboBox<String> cboQuestionFour;
	/** 题目五下拉框 */
	private JComboBox<String> cboQuestionFive;
	/** 题号数组 */
	private String[] questions = Data.questionIDs;
	/** 关闭按钮 */
	private JButton btnClose;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(500, 40);
	/** 文本框尺寸 */
	@SuppressWarnings("unused")
	private Dimension txtDimension = new Dimension(200, 40);
	/** 下拉框尺寸 */
	private Dimension cboDimension = new Dimension(120, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 100);
	/** 当前考试系统面板 */
	public ExamSystemPnl examSystemPnl = null;
	/** 当前试卷对象 */
	private PaperBean paperBean;
	/** 题目业务 */
	private QuestionService questionService = new QuestionServiceImpl();
	/** 当前考试学生对象 */
	public StudentBean studentBean; 
	/** 试卷管理面板 */
	public PaperManagePnl paperManagePnl = null;
	/** 试卷题目业务 */
	private PaperItemService paperItemService = new PaperItemServiceImpl();
	/** 学生试卷业务 */
	private PaperScoreService paperScoreService = new PaperScoreServiceImpl();
	/** 当前学生的试卷 */
	private PaperScoreBean paperScoreBean;
	
	public PaperResultFrm(PaperBean bean, Long studentID) {
		this.paperBean = bean;
		paperScoreBean = paperScoreService.loadById(bean.getPaperID(), studentID);
		initUI();
		initFrame();
		configureCompents();
		installCompents();
		installListener();
	}
	
	/**
	 * <p>Description: 初始化组件</p>
	 * <p>Title: initUI</p>
	 */
	private void initUI() {
		// 加载试卷题目
		container = new JPanel();
		
		pnlQuestionOne = new JPanel();
		pnlQuestionTwo = new JPanel();
		pnlQuestionThree = new JPanel();
		pnlQuestionFour = new JPanel();
		pnlQuestionFive = new JPanel();
		
		pnlQuestionOneCbo = new JPanel();
		pnlQuestionTwoCbo = new JPanel();
		pnlQuestionThreeCbo = new JPanel();
		pnlQuestionFourCbo = new JPanel();
		pnlQuestionFiveCbo = new JPanel();
		
		pnlMessage = new JPanel();
		pnlQuestionOneInfo = new JPanel();
		pnlQuestionTwoInfo = new JPanel();
		pnlQuestionThreeInfo = new JPanel();
		pnlQuestionFourInfo = new JPanel();
		pnlQuestionFiveInfo = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("考试");
		lblQuestionOne = new JLabel("1.");
		lblQuestionTwo = new JLabel("2.");
		lblQuestionThree = new JLabel("3.");
		lblQuestionFour = new JLabel("4.");
		lblQuestionFive = new JLabel("5.");
		
		rdoQuestionOneItemA = new JRadioButton("A");
		rdoQuestionOneItemB = new JRadioButton("B");
		rdoQuestionOneItemC = new JRadioButton("C");
		rdoQuestionOneItemD = new JRadioButton("D");
		btngrpQuestionOneItem = new ButtonGroup();
		
		rdoQuestionTwoItemA = new JRadioButton();
		rdoQuestionTwoItemB = new JRadioButton();
		rdoQuestionTwoItemC = new JRadioButton();
		rdoQuestionTwoItemD = new JRadioButton();
		btngrpQuestionTwoItem = new ButtonGroup();
		
		rdoQuestionThreeItemA = new JRadioButton("A");
		rdoQuestionThreeItemB = new JRadioButton("B");
		rdoQuestionThreeItemC = new JRadioButton("C");
		rdoQuestionThreeItemD = new JRadioButton("D");
		btngrpQuestionThreeItem = new ButtonGroup();
		
		rdoQuestionFourItemA = new JRadioButton("A");
		rdoQuestionFourItemB = new JRadioButton("B");
		rdoQuestionFourItemC = new JRadioButton("C");
		rdoQuestionFourItemD = new JRadioButton("D");
		btngrpQuestionFourItem = new ButtonGroup();
		
		rdoQuestionFiveItemA = new JRadioButton("A");
		rdoQuestionFiveItemB = new JRadioButton("B");
		rdoQuestionFiveItemC = new JRadioButton("C");
		rdoQuestionFiveItemD = new JRadioButton("D");
		btngrpQuestionFiveItem = new ButtonGroup();
		
		
		lblMessage = new JLabel();
		StringBuilder sb = new StringBuilder();
		sb.append("  科目："+paperBean.getSubjectName());
		sb.append("   考试时间："+paperBean.getExamMinute() +" 分钟 ");
		lblMessage.setText(sb.toString());
		
		btnClose = new JButton("关闭");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("考试");
		
		// 设置大小
		setSize(new Dimension(1200, 900));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(8,1));
		
		// 设置窗口相对居中
		setLocationRelativeTo(null);
		
		// 设置退出
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		
		// 设置窗口不可伸缩
		setResizable(false);
	}
	
	/**
	 * <p>Description: 配置组件</p>
	 * <p>Title: configureCompents</p>
	 */
	private void configureCompents() {
		configurePnlMessage();
		
		configurePnlQuestionOne();
		configurePnlQuestionTwo();
		configurePnlQuestionThree();
		configurePnlQuestionFour();
		configurePnlQuestionFive();
		
		configurePnlQuestionOneCbo();
		configurePnlQuestionTwoCbo();
		configurePnlQuestionThreeCbo();
		configurePnlQuestionFourCbo();
		configurePnlQuestionFiveCbo();
		
		configurePnlQuestionOneInfo();
		configurePnlQuestionTwoInfo();
		configurePnlQuestionThreeInfo();
		configurePnlQuestionFourInfo();
		configurePnlQuestionFiveInfo();
		configureLblQuestionOne();
		configureLblQuestionTwo();
		configureLblQuestionThree();
		configureLblQuestionFour();
		configureLblQuestionFive();
		configureItemQuestionOne();
		configureItemQuestionTwo();
		configureItemQuestionThree();
		configureItemQuestionFour();
		configureItemQuestionFive();
		
		configurePnlBtnOpearator();
		configureExamMessage();
		configureCboQuestionOne();
		configureCboQuestionTwo();
		configureCboQuestionThree();
		configureCboQuestionFour();
		configureCboQuestionFive();
		configureLblTitle();
		configureBtnClose();
		
		refresh();
	}

	/**
	 * <p>Description: 配置题目一题目标签</p>
	 * <p>Title: configureLblQuestionOne</p>
	 */
	private void configureLblQuestionOne() {
		lblQuestionOne.setFont(font);
		lblQuestionOne.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目二题目标签</p>
	 * <p>Title: configureLblQuestionTwo</p>
	 */
	private void configureLblQuestionTwo() {
		lblQuestionTwo.setFont(font);
		lblQuestionTwo.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目三题目标签</p>
	 * <p>Title: configureLblQuestionThree</p>
	 */
	private void configureLblQuestionThree() {
		lblQuestionThree.setFont(font);
		lblQuestionThree.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目四题目标签</p>
	 * <p>Title: configureLblQuestionFour</p>
	 */
	private void configureLblQuestionFour() {
		lblQuestionFour.setFont(font);
		lblQuestionFour.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目五题目标签</p>
	 * <p>Title: configureLblQuestionFive</p>
	 */
	private void configureLblQuestionFive() {
		lblQuestionFive.setFont(font);
		lblQuestionFive.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目一答案选项</p>
	 * <p>Title: configureItemQuestionOne</p>
	 */
	private void configureItemQuestionOne() {
		rdoQuestionOneItemA.setFont(font);
		rdoQuestionOneItemA.setFocusable(false);
		rdoQuestionOneItemB.setFont(font);
		rdoQuestionOneItemB.setFocusable(false);
		rdoQuestionOneItemC.setFont(font);
		rdoQuestionOneItemC.setFocusable(false);
		rdoQuestionOneItemD.setFont(font);
		rdoQuestionOneItemD.setFocusable(false);
	}

	/**
	 * <p>Description: 配置题目二答案选项</p>
	 * <p>Title: configureItemQuestionTwo</p>
	 */
	private void configureItemQuestionTwo() {
		rdoQuestionTwoItemA.setFont(font);
		rdoQuestionTwoItemA.setFocusable(false);
		rdoQuestionTwoItemB.setFont(font);
		rdoQuestionTwoItemB.setFocusable(false);
		rdoQuestionTwoItemC.setFont(font);
		rdoQuestionTwoItemC.setFocusable(false);
		rdoQuestionTwoItemD.setFont(font);
		rdoQuestionTwoItemD.setFocusable(false);
	}

	/**
	 * <p>Description: 配置题目三答案选项</p>
	 * <p>Title: configureItemQuestionThree</p>
	 */
	private void configureItemQuestionThree() {	
		rdoQuestionThreeItemA.setFont(font);
		rdoQuestionThreeItemA.setFocusable(false);
		rdoQuestionThreeItemB.setFont(font);
		rdoQuestionThreeItemB.setFocusable(false);
		rdoQuestionThreeItemC.setFont(font);
		rdoQuestionThreeItemC.setFocusable(false);
		rdoQuestionThreeItemD.setFont(font);
		rdoQuestionThreeItemD.setFocusable(false);
	}

	/**
	 * <p>Description: 配置题目四答案选项</p>
	 * <p>Title: configureItemQuestionFour</p>
	 */
	private void configureItemQuestionFour() {
		rdoQuestionFourItemA.setFont(font);
		rdoQuestionFourItemA.setFocusable(false);
		rdoQuestionFourItemB.setFont(font);
		rdoQuestionFourItemB.setFocusable(false);
		rdoQuestionFourItemC.setFont(font);
		rdoQuestionFourItemC.setFocusable(false);
		rdoQuestionFourItemD.setFont(font);
		rdoQuestionFourItemD.setFocusable(false);
	}

	/**
	 * <p>Description: 配置题目五答案选项</p>
	 * <p>Title: configureItemQuestionFive</p>
	 */
	private void configureItemQuestionFive() {
		rdoQuestionFiveItemA.setFont(font);
		rdoQuestionFiveItemA.setFocusable(false);
		rdoQuestionFiveItemB.setFont(font);
		rdoQuestionFiveItemB.setFocusable(false);
		rdoQuestionFiveItemC.setFont(font);
		rdoQuestionFiveItemC.setFocusable(false);
		rdoQuestionFiveItemD.setFont(font);
		rdoQuestionFiveItemD.setFocusable(false);
	}

	/**
	 * <p>Description: 配置题目一操作面板</p>
	 * <p>Title: configurePnlQuestionOne</p>
	 */
	private void configurePnlQuestionOne() {
		pnlQuestionOne.setLayout(new BorderLayout());
		pnlQuestionOne.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目二操作面板</p>
	 * <p>Title: configurePnlQuestionTwo</p>
	 */
	private void configurePnlQuestionTwo() {
		pnlQuestionTwo.setLayout(new BorderLayout());
		pnlQuestionTwo.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目三操作面板</p>
	 * <p>Title: configurePnlQuestionThree</p>
	 */
	private void configurePnlQuestionThree() {
		pnlQuestionThree.setLayout(new BorderLayout());
		pnlQuestionThree.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目四操作面板</p>
	 * <p>Title: configurePnlQuestionFour</p>
	 */
	private void configurePnlQuestionFour() {
		pnlQuestionFour.setLayout(new BorderLayout());
		pnlQuestionFour.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description:  配置题目五操作面板</p>
	 * <p>Title: configurePnlQuestionFive</p>
	 */
	private void configurePnlQuestionFive() {
		pnlQuestionFive.setLayout(new BorderLayout());
		pnlQuestionFive.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description:  配置题目一下拉框面板</p>
	 * <p>Title: configurePnlQuestionOneCbo</p>
	 */
	private void configurePnlQuestionOneCbo() {
		pnlQuestionOneCbo.setLayout(new FlowLayout());
//		pnlQuestionOneCbo.setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * <p>Description:  配置题目二下拉框面板</p>
	 * <p>Title: configurePnlQuestionTwoCbo</p>
	 */
	private void configurePnlQuestionTwoCbo() {
		pnlQuestionTwoCbo.setLayout(new FlowLayout());
//		pnlQuestionTwoCbo.setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * <p>Description:  配置题目三下拉框面板</p>
	 * <p>Title: configurePnlQuestionThreeCbo</p>
	 */
	private void configurePnlQuestionThreeCbo() {
		pnlQuestionThreeCbo.setLayout(new FlowLayout());
//		pnlQuestionThreeCbo.setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * <p>Description:  配置题目四下拉框面板</p>
	 * <p>Title: configurePnlQuestionFourCbo</p>
	 */
	private void configurePnlQuestionFourCbo() {
		pnlQuestionFourCbo.setLayout(new FlowLayout());
//		pnlQuestionFourCbo.setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * <p>Description: 配置题目五下拉框面板</p>
	 * <p>Title: configurePnlQuestionFiveCbo</p>
	 */
	private void configurePnlQuestionFiveCbo() {
		pnlQuestionFiveCbo.setLayout(new FlowLayout());
//		pnlQuestionFiveCbo.setPreferredSize(new Dimension(100, 100));
	}

	/**
	 * <p>Description: 配置题目一下拉框</p>
	 * <p>Title: configureCboQuestionOne</p>
	 */
	private void configureCboQuestionOne() {
		cboQuestionOne = new JComboBox(questions);
		cboQuestionOne.setPreferredSize(cboDimension);
		cboQuestionOne.setFont(font);
		cboQuestionOne.setEnabled(false);
		cboQuestionOne.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目二下拉框</p>
	 * <p>Title: configureCboQuestionTwo</p>
	 */
	private void configureCboQuestionTwo() {
		cboQuestionTwo = new JComboBox(questions);
		cboQuestionTwo.setPreferredSize(cboDimension);
		cboQuestionTwo.setFont(font);
		cboQuestionTwo.setEnabled(false);
		cboQuestionTwo.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目三下拉框</p>
	 * <p>Title: configureCboQuestionThree</p>
	 */
	private void configureCboQuestionThree() {
		cboQuestionThree = new JComboBox(questions);
		cboQuestionThree.setPreferredSize(cboDimension);
		cboQuestionThree.setFont(font);
		cboQuestionThree.setEnabled(false);
		cboQuestionThree.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目四下拉框</p>
	 * <p>Title: configureCboQuestionFour</p>
	 */
	private void configureCboQuestionFour() {
		cboQuestionFour = new JComboBox(questions);
		cboQuestionFour.setPreferredSize(cboDimension);
		cboQuestionFour.setFont(font);
		cboQuestionFour.setEnabled(false);
		cboQuestionFour.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目五下拉框</p>
	 * <p>Title: configureCboQuestionFive</p>
	 */
	private void configureCboQuestionFive() {
		cboQuestionFive = new JComboBox(questions);
		cboQuestionFive.setPreferredSize(cboDimension);
		cboQuestionFive.setFont(font);
		cboQuestionFive.setEnabled(false);
		cboQuestionFive.setVisible(false);
	}

	/**
	 * <p>Description: 配置考试信息面板</p>
	 * <p>Title: configurePnlMessage</p>
	 */
	private void configurePnlMessage() {
		pnlMessage.setLayout(new FlowLayout());
		pnlMessage.setPreferredSize(pnlDimension);	
	}

	/**
	 * <p>Description: 配置题目一信息面板</p>
	 * <p>Title: configurePnlQuestionOne</p>
	 */
	private void configurePnlQuestionOneInfo() {
		pnlQuestionOneInfo.setLayout(new GridLayout(5, 1));
	}

	/**
	 * <p>Description: 配置题目二信息面板</p>
	 * <p>Title: configurePnlQuestionTwo</p>
	 */
	private void configurePnlQuestionTwoInfo() {
		pnlQuestionTwoInfo.setLayout(new GridLayout(5, 1));
	}

	/**
	 * <p>Description: 配置题目三信息面板</p>
	 * <p>Title: configurePnlQuestionThree</p>
	 */
	private void configurePnlQuestionThreeInfo() {
		pnlQuestionThreeInfo.setLayout(new GridLayout(5, 1));
	}

	/**
	 * <p>Description: 配置题目四信息面板</p>
	 * <p>Title: configurePnlQuestionFour</p>
	 */
	private void configurePnlQuestionFourInfo() {
		pnlQuestionFourInfo.setLayout(new GridLayout(5, 1));
	}

	/**
	 * <p>Description: 配置题目五信息面板</p>
	 * <p>Title: configurePnlQuestionFive</p>
	 */
	private void configurePnlQuestionFiveInfo() {
		pnlQuestionFiveInfo.setLayout(new GridLayout(5, 1));
		pnlQuestionFiveInfo.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置按钮操作面板</p>
	 * <p>Title: configurePnlBtnOpearator</p>
	 */
	private void configurePnlBtnOpearator() {
		pnlBtnOpearator.setLayout(new FlowLayout());
		pnlBtnOpearator.setPreferredSize(new Dimension(this.getWidth(), 60));
	}

	/**
	 * <p>Description: 配置题目一信息标签文本</p>
	 * <p>Title: configureLblQuestionOne</p>
	 */
	private void configureLblQuestionOne(QuestionBean bean, Boolean isOk) {
		StringBuilder sb = new StringBuilder();
		sb.append("1. ( "+typeChange(bean.getQType())+" ) ");
		sb.append(bean.getQuestion());
		sb.append("  ( "+paperBean.getPerScore()+" )");
		sb.append("    "+verifyCurrent(isOk));
		lblQuestionOne.setText(sb.toString());
	}

	/**
	 * <p>Description: 配置题目二信息标签文本</p>
	 * <p>Title: configureLblQuestionTwo</p>
	 */
	private void configureLblQuestionTwo(QuestionBean bean, Boolean isOk) {
		StringBuilder sb = new StringBuilder();
		sb.append("2. ( "+typeChange(bean.getQType())+" ) ");
		sb.append(bean.getQuestion());
		sb.append("  ( "+paperBean.getPerScore()+" )");
		sb.append("    "+verifyCurrent(isOk));
		lblQuestionTwo.setText(sb.toString());
	}

	/**
	 * <p>Description: 配置题目三信息标签文本</p>
	 * <p>Title: configureLblQuestionThree</p>
	 */
	private void configureLblQuestionThree(QuestionBean bean, Boolean isOk) {
		StringBuilder sb = new StringBuilder();
		sb.append("3. ( "+typeChange(bean.getQType())+" ) ");
		sb.append(bean.getQuestion());
		sb.append("  ( "+paperBean.getPerScore()+" )");
		sb.append("    "+verifyCurrent(isOk));
		lblQuestionThree.setText(sb.toString());	
	}

	/**
	 * <p>Description: 配置题目四信息标签文本</p>
	 * <p>Title: configureLblQuestionFour</p>
	 */
	private void configureLblQuestionFour(QuestionBean bean, Boolean isOk) {
		StringBuilder sb = new StringBuilder();
		sb.append("4. ( "+typeChange(bean.getQType())+" ) ");
		sb.append(bean.getQuestion());
		sb.append("  ( "+paperBean.getPerScore()+" )");
		sb.append("    "+verifyCurrent(isOk));
		lblQuestionFour.setText(sb.toString());
	}

	/**
	 * <p>Description: 配置题目五信息标签文本</p>
	 * <p>Title: configureLblQuestionFive</p>
	 */
	private void configureLblQuestionFive(QuestionBean bean, Boolean isOk) {
		StringBuilder sb = new StringBuilder();
		sb.append("5. ( "+typeChange(bean.getQType())+" ) ");
		sb.append(bean.getQuestion());
		sb.append("  ( "+paperBean.getPerScore()+" )");
		sb.append("    "+verifyCurrent(isOk));
		lblQuestionFive.setText(sb.toString());
	}
	
	/**
	 * <p>Description: 配置题目一答案选项文本</p>
	 * <p>Title: configureItemQuestionOne</p>
	 */
	private void configureItemQuestionOne(QuestionBean bean) {
		rdoQuestionOneItemA.setText(bean.getItemA());
		rdoQuestionOneItemB.setText(bean.getItemB());
		rdoQuestionOneItemC.setText(bean.getItemC());
		rdoQuestionOneItemD.setText(bean.getItemD());
	}

	/**
	 * <p>Description: 配置题目二答案选项文本</p>
	 * <p>Title: configureItemQuestionTwo</p>
	 */
	private void configureItemQuestionTwo(QuestionBean bean) {
		rdoQuestionTwoItemA.setText(bean.getItemA());
		rdoQuestionTwoItemB.setText(bean.getItemB());
		rdoQuestionTwoItemC.setText(bean.getItemC());
		rdoQuestionTwoItemD.setText(bean.getItemD());
	}

	/**
	 * <p>Description: 配置题目三答案选项文本</p>
	 * <p>Title: configureItemQuestionThree</p>
	 */
	private void configureItemQuestionThree(QuestionBean bean) {
		rdoQuestionThreeItemA.setText(bean.getItemA());
		rdoQuestionThreeItemB.setText(bean.getItemB());
		rdoQuestionThreeItemC.setText(bean.getItemC());
		rdoQuestionThreeItemD.setText(bean.getItemD());
	}

	/**
	 * <p>Description: 配置题目四答案选项文本</p>
	 * <p>Title: configureItemQuestionFour</p>
	 */
	private void configureItemQuestionFour(QuestionBean bean) {
		rdoQuestionFourItemA.setText(bean.getItemA());
		rdoQuestionFourItemB.setText(bean.getItemB());
		rdoQuestionFourItemC.setText(bean.getItemC());
		rdoQuestionFourItemD.setText(bean.getItemD());
	}

	/**
	 * <p>Description: 配置题目五答案选项文本</p>
	 * <p>Title: configureItemQuestionFive</p>
	 */
	private void configureItemQuestionFive(QuestionBean bean) {
		rdoQuestionFiveItemA.setText(bean.getItemA());
		rdoQuestionFiveItemB.setText(bean.getItemB());
		rdoQuestionFiveItemC.setText(bean.getItemC());
		rdoQuestionFiveItemD.setText(bean.getItemD());
	}
	
	/**
	 * <p>Description: 配置考试信息标签</p>
	 * <p>Title: configureLblMessage</p>
	 */
	private void configureExamMessage() {
		lblMessage.setFont(font);
		lblMessage.setPreferredSize(lblDimension);
	}
	
	/**
	 * <p>Description: 配置关闭按钮</p>
	 * <p>Title: configureBtnClose</p>
	 */
	private void configureBtnClose() {
		// 设置字体
		btnClose.setFont(font);
		// 设置大小
		btnClose.setPreferredSize(btnDimension);
		// 设置文本聚焦
		btnClose.setFocusable(false);
	}
	
	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);	
		pnlBtnOpearator.add(btnClose);
		
		// 题目标签
		pnlQuestionOneInfo.add(lblQuestionOne);
		pnlQuestionTwoInfo.add(lblQuestionTwo);
		pnlQuestionThreeInfo.add(lblQuestionThree);
		pnlQuestionFourInfo.add(lblQuestionFour);
		pnlQuestionFiveInfo.add(lblQuestionFive);
		
		// 题目一答案选项
		btngrpQuestionOneItem.add(rdoQuestionOneItemA);
		btngrpQuestionOneItem.add(rdoQuestionOneItemB);
		btngrpQuestionOneItem.add(rdoQuestionOneItemC);
		btngrpQuestionOneItem.add(rdoQuestionOneItemD);
		pnlQuestionOneInfo.add(rdoQuestionOneItemA);
		pnlQuestionOneInfo.add(rdoQuestionOneItemB);
		pnlQuestionOneInfo.add(rdoQuestionOneItemC);
		pnlQuestionOneInfo.add(rdoQuestionOneItemD);
		
		pnlQuestionOneCbo.add(cboQuestionOne);
		pnlQuestionOne.add(pnlQuestionOneCbo, BorderLayout.WEST);
		pnlQuestionOne.add(pnlQuestionOneInfo, BorderLayout.CENTER);
		
		// 题目二答案选项
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemA);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemB);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemC);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemD);
		pnlQuestionTwoInfo.add(rdoQuestionTwoItemA);
		pnlQuestionTwoInfo.add(rdoQuestionTwoItemB);
		pnlQuestionTwoInfo.add(rdoQuestionTwoItemC);
		pnlQuestionTwoInfo.add(rdoQuestionTwoItemD);
		
		pnlQuestionTwoCbo.add(cboQuestionTwo);
		pnlQuestionTwo.add(pnlQuestionTwoCbo, BorderLayout.WEST);
		pnlQuestionTwo.add(pnlQuestionTwoInfo, BorderLayout.CENTER);
		
		// 题目三答案选项
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemA);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemB);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemC);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemD);
		pnlQuestionThreeInfo.add(rdoQuestionThreeItemA);
		pnlQuestionThreeInfo.add(rdoQuestionThreeItemB);
		pnlQuestionThreeInfo.add(rdoQuestionThreeItemC);
		pnlQuestionThreeInfo.add(rdoQuestionThreeItemD);
		
		pnlQuestionThreeCbo.add(cboQuestionThree);
		pnlQuestionThree.add(pnlQuestionThreeCbo, BorderLayout.WEST);
		pnlQuestionThree.add(pnlQuestionThreeInfo, BorderLayout.CENTER);
		
		// 题目四答案选项
		btngrpQuestionFourItem.add(rdoQuestionFourItemA);
		btngrpQuestionFourItem.add(rdoQuestionFourItemB);
		btngrpQuestionFourItem.add(rdoQuestionFourItemC);
		btngrpQuestionFourItem.add(rdoQuestionFourItemD);
		pnlQuestionFourInfo.add(rdoQuestionFourItemA);
		pnlQuestionFourInfo.add(rdoQuestionFourItemB);
		pnlQuestionFourInfo.add(rdoQuestionFourItemC);
		pnlQuestionFourInfo.add(rdoQuestionFourItemD);
		
		pnlQuestionFourCbo.add(cboQuestionFour);
		pnlQuestionFour.add(pnlQuestionFourCbo, BorderLayout.WEST);
		pnlQuestionFour.add(pnlQuestionFourInfo, BorderLayout.CENTER);
		
		// 题目五答案选项
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemA);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemB);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemC);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemD);
		pnlQuestionFiveInfo.add(rdoQuestionFiveItemA);
		pnlQuestionFiveInfo.add(rdoQuestionFiveItemB);
		pnlQuestionFiveInfo.add(rdoQuestionFiveItemC);
		pnlQuestionFiveInfo.add(rdoQuestionFiveItemD);
		
		pnlQuestionFiveCbo.add(cboQuestionFive);
		pnlQuestionFive.add(pnlQuestionFiveCbo, BorderLayout.WEST);
		pnlQuestionFive.add(pnlQuestionFiveInfo, BorderLayout.CENTER);
		
		pnlMessage.add(lblMessage);
		container.add(pnlMessage);
		container.add(pnlQuestionOne);
		container.add(pnlQuestionTwo);
		container.add(pnlQuestionThree);
		container.add(pnlQuestionFour);
		container.add(pnlQuestionFive);
		container.add(pnlBtnOpearator);
	}
	
	/**
	 * <p>Description: 配置标题标签</p>
	 * <p>Title: configureLblTitle</p>
	 */
	private void configureLblTitle() {
		lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 23));
		lblTitle.setPreferredSize(new Dimension(this.getWidth(), 40));
		// 设置标签居中
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setText(paperBean.getPaperName());
	}
	
	/**
	 * <p>Description: 安装监听器</p>
	 * <p>Title: installListener</p>
	 */
	private void installListener() {
		// 窗口关闭事件监听器
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowCloseOnClickListener(e);
			}
		});
		btnClose.addActionListener(e->{
			btnCloseOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		close();
	}
	
	/**
	 * <p>Description: 关闭按钮点击事件监听器</p>
	 * <p>Title: btnCloseOnClickListener</p>
	 * @param e
	 */
	private void btnCloseOnClickListener(ActionEvent e) {
		close();
	}
	
	/**
	 * <p>Description: 窗口关闭</p>
	 * <p>Title: close</p>
	 */
	private void close() {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否关闭？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	/**
	 * <p>Description: 窗口可见</p>
	 * <p>Title: showMainFrm</p>
	 */
	public void showFrm() {
		setVisible(true);
	}
	
	/**
	 * <p>Description: 窗口隐藏</p>
	 * <p>Title: hideMFrm</p>
	 */
	public void hideFrm() {
		setVisible(false);
	}
	
	/**
	 * <p>Description: 题目类型字符串转换</p>
	 * <p>Title: typeChange</p>
	 * @param type
	 * @return
	 */
	private String typeChange(Integer type) {
		if (type == 1) {
			return "单选题";
		} else if (type == 2) {
			return "多选题";
		} else if (type == 3) {
			return "判断题";
		} else {
			return "未知";
		}
		
	}

	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		List<PaperItemBean> list = paperItemService.loadPaper(paperBean.getPaperID());
		Integer length = list.size();
		if (length > 0 && list.get(0) != null) {
			PaperItemBean bean = list.get(0);
			QuestionBean questionBean = questionService.loadById(bean.getQuestionID());
			cboQuestionOne.setSelectedIndex(Integer.valueOf(questionBean.getQuestionID()+""));
			configureItemQuestionOne(questionBean);
			if (rdoQuestionOneItemA.getText().equals(paperScoreBean.getOneAnswer())) {
				rdoQuestionOneItemA.setSelected(true);
				if (rdoQuestionOneItemA.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionOne(questionBean, true);
				} else {
					configureLblQuestionOne(questionBean, false);
				}
			} else if (rdoQuestionOneItemB.getText().equals(paperScoreBean.getOneAnswer())) {
				rdoQuestionOneItemB.setSelected(true);
				if (rdoQuestionOneItemB.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionOne(questionBean, true);
				} else {
					configureLblQuestionOne(questionBean, false);
				}
			} else if (rdoQuestionOneItemC.getText().equals(paperScoreBean.getOneAnswer())) {
				rdoQuestionOneItemC.setSelected(true);
				if (rdoQuestionOneItemC.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionOne(questionBean, true);
				} else {
					configureLblQuestionOne(questionBean, false);
				}
			} else if (rdoQuestionOneItemD.getText().equals(paperScoreBean.getOneAnswer())) {
				rdoQuestionOneItemD.setSelected(true);
				if (rdoQuestionOneItemD.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionOne(questionBean, true);
				} else {
					configureLblQuestionOne(questionBean, false);
				}
			}	
		} else {
			cboQuestionOne.setSelectedIndex(0);
		}
		
		if (length > 1 && list.get(1) != null) {
			PaperItemBean bean = list.get(1);
			QuestionBean questionBean = questionService.loadById(bean.getQuestionID());
			cboQuestionTwo.setSelectedIndex(Integer.valueOf(questionBean.getQuestionID()+""));
			configureItemQuestionTwo(questionBean);
			if (rdoQuestionTwoItemA.getText().equals(paperScoreBean.getTwoAnswer())) {
				rdoQuestionTwoItemA.setSelected(true);
				if (rdoQuestionTwoItemA.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionTwo(questionBean, true);
				} else {
					configureLblQuestionTwo(questionBean, false);
				}
			} else if (rdoQuestionTwoItemB.getText().equals(paperScoreBean.getTwoAnswer())) {
				rdoQuestionTwoItemB.setSelected(true);
				if (rdoQuestionTwoItemB.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionTwo(questionBean, true);
				} else {
					configureLblQuestionTwo(questionBean, false);
				}
			} else if (rdoQuestionTwoItemC.getText().equals(paperScoreBean.getTwoAnswer())) {
				rdoQuestionTwoItemC.setSelected(true);
				if (rdoQuestionTwoItemC.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionTwo(questionBean, true);
				} else {
					configureLblQuestionTwo(questionBean, false);
				}
			} else if (rdoQuestionTwoItemD.getText().equals(paperScoreBean.getTwoAnswer())) {
				rdoQuestionTwoItemD.setSelected(true);
				if (rdoQuestionTwoItemD.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionTwo(questionBean, true);
				} else {
					configureLblQuestionTwo(questionBean, false);
				}
			}	
		} else {
			cboQuestionTwo.setSelectedIndex(0);
		}
		
		if (length > 2 && list.get(2) != null) {
			PaperItemBean bean = list.get(2);
			QuestionBean questionBean = questionService.loadById(bean.getQuestionID());
			cboQuestionThree.setSelectedIndex(Integer.valueOf(questionBean.getQuestionID()+""));
			configureItemQuestionThree(questionBean);
			if (rdoQuestionThreeItemA.getText().equals(paperScoreBean.getThreeAnswer())) {
				rdoQuestionThreeItemA.setSelected(true);
				if (rdoQuestionThreeItemA.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionThree(questionBean, true);
				} else {
					configureLblQuestionThree(questionBean, false);
				}
			} else if (rdoQuestionThreeItemB.getText().equals(paperScoreBean.getThreeAnswer())) {
				rdoQuestionThreeItemB.setSelected(true);
				if (rdoQuestionThreeItemB.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionThree(questionBean, true);
				} else {
					configureLblQuestionThree(questionBean, false);
				}
			} else if (rdoQuestionThreeItemC.getText().equals(paperScoreBean.getThreeAnswer())) {
				rdoQuestionThreeItemC.setSelected(true);
				if (rdoQuestionThreeItemC.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionThree(questionBean, true);
				} else {
					configureLblQuestionThree(questionBean, false);
				}
			} else if (rdoQuestionThreeItemD.getText().equals(paperScoreBean.getThreeAnswer())) {
				rdoQuestionThreeItemD.setSelected(true);
				if (rdoQuestionThreeItemD.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionThree(questionBean, true);
				} else {
					configureLblQuestionThree(questionBean, false);
				}
			}	
		} else {
			cboQuestionThree.setSelectedIndex(0);
		}
		
		if (length > 3 && list.get(3) != null) {
			PaperItemBean bean = list.get(3);
			QuestionBean questionBean = questionService.loadById(bean.getQuestionID());
			cboQuestionFour.setSelectedIndex(Integer.valueOf(questionBean.getQuestionID()+""));
			configureItemQuestionFour(questionBean);
			if (rdoQuestionFourItemA.getText().equals(paperScoreBean.getFourAnswer())) {
				rdoQuestionFourItemA.setSelected(true);
				if (rdoQuestionFourItemA.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFour(questionBean, true);
				} else {
					configureLblQuestionFour(questionBean, false);
				}
			} else if (rdoQuestionFourItemB.getText().equals(paperScoreBean.getFourAnswer())) {
				rdoQuestionFourItemB.setSelected(true);
				if (rdoQuestionFourItemB.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFour(questionBean, true);
				} else {
					configureLblQuestionFour(questionBean, false);
				}
			} else if (rdoQuestionFourItemC.getText().equals(paperScoreBean.getFourAnswer())) {
				rdoQuestionFourItemC.setSelected(true);
				if (rdoQuestionFourItemC.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFour(questionBean, true);
				} else {
					configureLblQuestionFour(questionBean, false);
				}
			} else if (rdoQuestionFourItemD.getText().equals(paperScoreBean.getFourAnswer())) {
				rdoQuestionFourItemD.setSelected(true);
				if (rdoQuestionFourItemD.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFour(questionBean, true);
				} else {
					configureLblQuestionFour(questionBean, false);
				}
			}	
		} else {
			cboQuestionFour.setSelectedIndex(0);
		}
		
		if (length > 4 && list.get(4) != null) {
			PaperItemBean bean = list.get(4);
			QuestionBean questionBean = questionService.loadById(bean.getQuestionID());
			cboQuestionFive.setSelectedIndex(Integer.valueOf(questionBean.getQuestionID()+""));	
			configureItemQuestionFive(questionBean);
			if (rdoQuestionFiveItemA.getText().equals(paperScoreBean.getFiveAnswer())) {
				rdoQuestionFiveItemA.setSelected(true);
				if (rdoQuestionFiveItemA.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFive(questionBean, true);
				} else {
					configureLblQuestionFive(questionBean, false);
				}
			} else if (rdoQuestionFiveItemB.getText().equals(paperScoreBean.getFiveAnswer())) {
				rdoQuestionFiveItemB.setSelected(true);
				if (rdoQuestionFiveItemB.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFive(questionBean, true);
				} else {
					configureLblQuestionFive(questionBean, false);
				}
			} else if (rdoQuestionFiveItemC.getText().equals(paperScoreBean.getFiveAnswer())) {
				rdoQuestionFiveItemC.setSelected(true);
				if (rdoQuestionFiveItemC.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFive(questionBean, true);
				} else {
					configureLblQuestionFive(questionBean, false);
				}
			} else if (rdoQuestionFiveItemD.getText().equals(paperScoreBean.getFiveAnswer())) {
				rdoQuestionFiveItemD.setSelected(true);
				if (rdoQuestionFiveItemD.getText().equals(questionBean.getAnswer())) {
					configureLblQuestionFive(questionBean, true);
				} else {
					configureLblQuestionFive(questionBean, false);
				}
			}	
		} else {
			cboQuestionFive.setSelectedIndex(0);
		}	
	}
	
	/**
	 * <p>Description: 验证答案正确性</p>
	 * <p>Title: verifyCurrent</p>
	 * @param isOk
	 * @return
	 */
	private String verifyCurrent(Boolean isOk) {
		if (isOk) {
			return "正确√";
		} else if (isOk == false){
			return "错误X";
		} else {
			return "";
		}
	}
}
