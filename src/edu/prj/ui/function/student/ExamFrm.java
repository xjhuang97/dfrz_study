package edu.prj.ui.function.student;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;

import edu.prj.bean.exam.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;

@SuppressWarnings("serial")
public class ExamFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 试卷信息面板 */
	private JPanel pnlMessage;
	/** 题目一信息面板 */
	private JPanel pnlQuestionOne;
	/** 题目二信息面板 */
	private JPanel pnlQuestionTwo;
	/** 题目三信息面板 */
	private JPanel pnlQuestionThree;
	/** 题目四信息面板 */
	private JPanel pnlQuestionFour;
	/** 题目五信息面板 */
	private JPanel pnlQuestionFive;
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
	
	/** 开始按钮 */
	private JButton btnStart;
	/** 提交按钮 */
	private JButton btnSubmit;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(600, 40);
	/** 文本框尺寸 */
	@SuppressWarnings("unused")
	private Dimension txtDimension = new Dimension(200, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 100);
	/** 当前考试系统面板 */
	public ExamSystemPnl examSystemPnl = null;
	/** 当前试卷对象 */
	private PaperBean paperBean;
	/** 当前试卷题目 */
	private List<PaperItemBean> paperItems = null;
	/** 题目业务 */
	private QuestionService questionService = new QuestionServiceImpl();
	private PaperScoreService paperScoreService = new PaperScoreServiceImpl();

	/** 定时器 */
	private Timer timer;
	/** 考试时间 */
	private Integer time;
	/** 当前考试学生对象 */
	public StudentBean studentBean; 
	
	public ExamFrm(PaperBean bean) {
		this.paperBean = bean;
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
		PaperItemService paperItemService = new PaperItemServiceImpl();
		paperItems = paperItemService.loadPaper(paperBean.getPaperID());
		container = new JPanel();
		pnlMessage = new JPanel();
		pnlQuestionOne = new JPanel();
		pnlQuestionTwo = new JPanel();
		pnlQuestionThree = new JPanel();
		pnlQuestionFour = new JPanel();
		pnlQuestionFive = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("考试");
		lblQuestionOne = new JLabel();
		lblQuestionTwo = new JLabel();
		lblQuestionThree = new JLabel();
		lblQuestionFour = new JLabel();
		lblQuestionFive = new JLabel();
		
		rdoQuestionOneItemA = new JRadioButton();
		rdoQuestionOneItemB = new JRadioButton();
		rdoQuestionOneItemC = new JRadioButton();
		rdoQuestionOneItemD = new JRadioButton();
		btngrpQuestionOneItem = new ButtonGroup();
		
		rdoQuestionTwoItemA = new JRadioButton();
		rdoQuestionTwoItemB = new JRadioButton();
		rdoQuestionTwoItemC = new JRadioButton();
		rdoQuestionTwoItemD = new JRadioButton();
		btngrpQuestionTwoItem = new ButtonGroup();
		
		rdoQuestionThreeItemA = new JRadioButton();
		rdoQuestionThreeItemB = new JRadioButton();
		rdoQuestionThreeItemC = new JRadioButton();
		rdoQuestionThreeItemD = new JRadioButton();
		btngrpQuestionThreeItem = new ButtonGroup();
		
		rdoQuestionFourItemA = new JRadioButton();
		rdoQuestionFourItemB = new JRadioButton();
		rdoQuestionFourItemC = new JRadioButton();
		rdoQuestionFourItemD = new JRadioButton();
		btngrpQuestionFourItem = new ButtonGroup();
		
		rdoQuestionFiveItemA = new JRadioButton();
		rdoQuestionFiveItemB = new JRadioButton();
		rdoQuestionFiveItemC = new JRadioButton();
		rdoQuestionFiveItemD = new JRadioButton();
		btngrpQuestionFiveItem = new ButtonGroup();
		
		
		
		lblMessage = new JLabel();
		StringBuilder sb = new StringBuilder();
		sb.append("  科目："+paperBean.getSubjectName());
		sb.append("   考试时间："+paperBean.getExamMinute() +" 分钟 ");
		lblMessage.setText(sb.toString());
		
		btnStart = new JButton("开始");
		btnSubmit = new JButton("提交");
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
		configurePnlBtnOpearator();
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
		configureExamMessage();
		configureLblTitle();
		configureBtnStart();
		configureBtnSubmit();
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
	private void configurePnlQuestionOne() {
		pnlQuestionOne.setLayout(new GridLayout(5, 1));
		pnlQuestionOne.setPreferredSize(pnlDimension);	
		pnlQuestionOne.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目二信息面板</p>
	 * <p>Title: configurePnlQuestionTwo</p>
	 */
	private void configurePnlQuestionTwo() {
		pnlQuestionTwo.setLayout(new GridLayout(5, 1));
		pnlQuestionTwo.setPreferredSize(pnlDimension);
		pnlQuestionTwo.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目三信息面板</p>
	 * <p>Title: configurePnlQuestionThree</p>
	 */
	private void configurePnlQuestionThree() {
		pnlQuestionThree.setLayout(new GridLayout(5, 1));
		pnlQuestionThree.setPreferredSize(pnlDimension);
		pnlQuestionThree.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目四信息面板</p>
	 * <p>Title: configurePnlQuestionFour</p>
	 */
	private void configurePnlQuestionFour() {
		pnlQuestionFour.setLayout(new GridLayout(5, 1));
		pnlQuestionFour.setPreferredSize(pnlDimension);
		pnlQuestionFour.setVisible(false);
	}

	/**
	 * <p>Description: 配置题目五信息面板</p>
	 * <p>Title: configurePnlQuestionFive</p>
	 */
	private void configurePnlQuestionFive() {
		pnlQuestionFive.setLayout(new GridLayout(5, 1));
		pnlQuestionFive.setPreferredSize(pnlDimension);
		pnlQuestionFive.setVisible(false);
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
	 * <p>Description: 配置题目一信息标签</p>
	 * <p>Title: configureLblQuestionOne</p>
	 */
	private void configureLblQuestionOne() {
		lblQuestionOne.setFont(font);
		lblQuestionOne.setPreferredSize(lblDimension);
		if (paperItems.get(0) != null) {
			PaperItemBean bean = paperItems.get(0);
			StringBuilder sb = new StringBuilder();
			sb.append("1. ( "+typeChange(bean.getQType())+" ) ");
			sb.append(bean.getQuestion());
			sb.append("  ( "+bean.getScore()+" )");
			lblQuestionOne.setText(sb.toString());
		}
		pnlQuestionOne.add(lblQuestionOne);
	}

	/**
	 * <p>Description: 配置题目二信息标签</p>
	 * <p>Title: configureLblQuestionTwo</p>
	 */
	private void configureLblQuestionTwo() {
		lblQuestionTwo.setFont(font);
		lblQuestionTwo.setPreferredSize(lblDimension);
		if (paperItems.get(1) != null) {
			PaperItemBean bean = paperItems.get(1);
			StringBuilder sb = new StringBuilder();
			sb.append("2. ( "+typeChange(bean.getQType())+" ) ");
			sb.append(bean.getQuestion());
			sb.append("  ( "+bean.getScore()+" )");
			lblQuestionTwo.setText(sb.toString());
		}
		pnlQuestionTwo.add(lblQuestionTwo);
	}

	/**
	 * <p>Description: 配置题目三信息标签</p>
	 * <p>Title: configureLblQuestionThree</p>
	 */
	private void configureLblQuestionThree() {
		lblQuestionThree.setFont(font);
		lblQuestionThree.setPreferredSize(lblDimension);
		if (paperItems.get(2) != null) {
			PaperItemBean bean = paperItems.get(2);
			StringBuilder sb = new StringBuilder();
			sb.append("3. ( "+typeChange(bean.getQType())+" ) ");
			sb.append(bean.getQuestion());
			sb.append("  ( "+bean.getScore()+" )");
			lblQuestionThree.setText(sb.toString());
		}
		pnlQuestionThree.add(lblQuestionThree);
	}

	/**
	 * <p>Description: 配置题目四信息标签</p>
	 * <p>Title: configureLblQuestionFour</p>
	 */
	private void configureLblQuestionFour() {
		lblQuestionFour.setFont(font);
		lblQuestionFour.setPreferredSize(lblDimension);
		if (paperItems.get(3) != null) {
			PaperItemBean bean = paperItems.get(3);
			StringBuilder sb = new StringBuilder();
			sb.append("4. ( "+typeChange(bean.getQType())+" ) ");
			sb.append(bean.getQuestion());
			sb.append("  ( "+bean.getScore()+" )");
			lblQuestionFour.setText(sb.toString());
		}
		pnlQuestionFour.add(lblQuestionFour);
	}

	/**
	 * <p>Description: 配置题目五信息标签</p>
	 * <p>Title: configureLblQuestionFive</p>
	 */
	private void configureLblQuestionFive() {
		lblQuestionFive.setFont(font);
		lblQuestionFive.setPreferredSize(lblDimension);
		if (paperItems.get(4) != null) {
			PaperItemBean bean = paperItems.get(4);
			StringBuilder sb = new StringBuilder();
			sb.append("5. ( "+typeChange(bean.getQType())+" ) ");
			sb.append(bean.getQuestion());
			sb.append("  ( "+bean.getScore()+" )");
			lblQuestionFive.setText(sb.toString());
		}
		pnlQuestionFive.add(lblQuestionFive);
	}
	
	/**
	 * <p>Description: 配置题目一答案选项</p>
	 * <p>Title: configureItemQuestionOne</p>
	 */
	private void configureItemQuestionOne() {
		if (paperItems.get(0) != null) {
			PaperItemBean paperItemBean = paperItems.get(0);
			QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
			rdoQuestionOneItemA.setText(questionBean.getItemA());
			rdoQuestionOneItemB.setText(questionBean.getItemB());
			rdoQuestionOneItemC.setText(questionBean.getItemC());
			rdoQuestionOneItemD.setText(questionBean.getItemD());
		}
		rdoQuestionOneItemA.setFont(font);
		rdoQuestionOneItemA.setFocusable(false);
		rdoQuestionOneItemB.setFont(font);
		rdoQuestionOneItemB.setFocusable(false);
		rdoQuestionOneItemC.setFont(font);
		rdoQuestionOneItemC.setFocusable(false);
		rdoQuestionOneItemD.setFont(font);
		rdoQuestionOneItemD.setFocusable(false);
		btngrpQuestionOneItem.add(rdoQuestionOneItemA);
		btngrpQuestionOneItem.add(rdoQuestionOneItemB);
		btngrpQuestionOneItem.add(rdoQuestionOneItemC);
		btngrpQuestionOneItem.add(rdoQuestionOneItemD);
		pnlQuestionOne.add(rdoQuestionOneItemA);
		pnlQuestionOne.add(rdoQuestionOneItemB);
		pnlQuestionOne.add(rdoQuestionOneItemC);
		pnlQuestionOne.add(rdoQuestionOneItemD);
	}

	/**
	 * <p>Description: 配置题目二答案选项</p>
	 * <p>Title: configureItemQuestionTwo</p>
	 */
	private void configureItemQuestionTwo() {
		if (paperItems.get(1) != null) {
			PaperItemBean paperItemBean = paperItems.get(1);
			QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
			rdoQuestionTwoItemA.setText(questionBean.getItemA());
			rdoQuestionTwoItemB.setText(questionBean.getItemB());
			rdoQuestionTwoItemC.setText(questionBean.getItemC());
			rdoQuestionTwoItemD.setText(questionBean.getItemD());
		}
		rdoQuestionTwoItemA.setFont(font);
		rdoQuestionTwoItemA.setFocusable(false);
		rdoQuestionTwoItemB.setFont(font);
		rdoQuestionTwoItemB.setFocusable(false);
		rdoQuestionTwoItemC.setFont(font);
		rdoQuestionTwoItemC.setFocusable(false);
		rdoQuestionTwoItemD.setFont(font);
		rdoQuestionTwoItemD.setFocusable(false);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemA);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemB);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemC);
		btngrpQuestionTwoItem.add(rdoQuestionTwoItemD);
		pnlQuestionTwo.add(rdoQuestionTwoItemA);
		pnlQuestionTwo.add(rdoQuestionTwoItemB);
		pnlQuestionTwo.add(rdoQuestionTwoItemC);
		pnlQuestionTwo.add(rdoQuestionTwoItemD);
	}

	/**
	 * <p>Description: 配置题目三答案选项</p>
	 * <p>Title: configureItemQuestionThree</p>
	 */
	private void configureItemQuestionThree() {
		if (paperItems.get(2) != null) {
			PaperItemBean paperItemBean = paperItems.get(2);
			QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
			rdoQuestionThreeItemA.setText(questionBean.getItemA());
			rdoQuestionThreeItemB.setText(questionBean.getItemB());
			rdoQuestionThreeItemC.setText(questionBean.getItemC());
			rdoQuestionThreeItemD.setText(questionBean.getItemD());
		}
		rdoQuestionThreeItemA.setFont(font);
		rdoQuestionThreeItemA.setFocusable(false);
		rdoQuestionThreeItemB.setFont(font);
		rdoQuestionThreeItemB.setFocusable(false);
		rdoQuestionThreeItemC.setFont(font);
		rdoQuestionThreeItemC.setFocusable(false);
		rdoQuestionThreeItemD.setFont(font);
		rdoQuestionThreeItemD.setFocusable(false);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemA);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemB);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemC);
		btngrpQuestionThreeItem.add(rdoQuestionThreeItemD);
		pnlQuestionThree.add(rdoQuestionThreeItemA);
		pnlQuestionThree.add(rdoQuestionThreeItemB);
		pnlQuestionThree.add(rdoQuestionThreeItemC);
		pnlQuestionThree.add(rdoQuestionThreeItemD);
	}

	/**
	 * <p>Description: 配置题目四答案选项</p>
	 * <p>Title: configureItemQuestionFour</p>
	 */
	private void configureItemQuestionFour() {
		if (paperItems.get(3) != null) {
			PaperItemBean paperItemBean = paperItems.get(3);
			QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
			rdoQuestionFourItemA.setText(questionBean.getItemA());
			rdoQuestionFourItemB.setText(questionBean.getItemB());
			rdoQuestionFourItemC.setText(questionBean.getItemC());
			rdoQuestionFourItemD.setText(questionBean.getItemD());
		}
		rdoQuestionFourItemA.setFont(font);
		rdoQuestionFourItemA.setFocusable(false);
		rdoQuestionFourItemB.setFont(font);
		rdoQuestionFourItemB.setFocusable(false);
		rdoQuestionFourItemC.setFont(font);
		rdoQuestionFourItemC.setFocusable(false);
		rdoQuestionFourItemD.setFont(font);
		rdoQuestionFourItemD.setFocusable(false);
		btngrpQuestionFourItem.add(rdoQuestionFourItemA);
		btngrpQuestionFourItem.add(rdoQuestionFourItemB);
		btngrpQuestionFourItem.add(rdoQuestionFourItemC);
		btngrpQuestionFourItem.add(rdoQuestionFourItemD);
		pnlQuestionFour.add(rdoQuestionFourItemA);
		pnlQuestionFour.add(rdoQuestionFourItemB);
		pnlQuestionFour.add(rdoQuestionFourItemC);
		pnlQuestionFour.add(rdoQuestionFourItemD);
	}

	/**
	 * <p>Description: 配置题目五答案选项</p>
	 * <p>Title: configureItemQuestionFive</p>
	 */
	private void configureItemQuestionFive() {
		if (paperItems.get(4) != null) {
			PaperItemBean paperItemBean = paperItems.get(4);
			QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
			rdoQuestionFiveItemA.setText(questionBean.getItemA());
			rdoQuestionFiveItemB.setText(questionBean.getItemB());
			rdoQuestionFiveItemC.setText(questionBean.getItemC());
			rdoQuestionFiveItemD.setText(questionBean.getItemD());
		}
		rdoQuestionFiveItemA.setFont(font);
		rdoQuestionFiveItemA.setFocusable(false);
		rdoQuestionFiveItemB.setFont(font);
		rdoQuestionFiveItemB.setFocusable(false);
		rdoQuestionFiveItemC.setFont(font);
		rdoQuestionFiveItemC.setFocusable(false);
		rdoQuestionFiveItemD.setFont(font);
		rdoQuestionFiveItemD.setFocusable(false);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemA);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemB);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemC);
		btngrpQuestionFiveItem.add(rdoQuestionFiveItemD);
		pnlQuestionFive.add(rdoQuestionFiveItemA);
		pnlQuestionFive.add(rdoQuestionFiveItemB);
		pnlQuestionFive.add(rdoQuestionFiveItemC);
		pnlQuestionFive.add(rdoQuestionFiveItemD);
	}
	
	/**
	 * <p>Description: 配置考试信息标签</p>
	 * <p>Title: configureLblMessage</p>
	 */
	private void configureExamMessage() {
		lblMessage.setFont(font);
		lblMessage.setPreferredSize(lblDimension);
		time = paperBean.getExamMinute() * 60;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timerAutoListener(e);
			}
			private void timerAutoListener(ActionEvent e) {
				if (time == 0) {
					timer.stop();
//					JOptionPane.showMessageDialog(null, "考试时间到！");
					calcScore();
					ExamFrm.this.dispose();
				}
				try {
					Thread.sleep(1000);
					time--;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Integer hour = time / 60 / 60;
				Integer minute = (time - hour * 60 * 60) / 60;
				Integer seconds = (time - hour * 60 * 60 - minute * 60);
				StringBuilder sb = new StringBuilder();
				sb.append("  科目："+paperBean.getSubjectName());
				sb.append("   考试时间："+paperBean.getExamMinute() +" 分钟 ");
				sb.append("   考试时间剩余："+hour + " 时 " + minute + " 分 " + seconds + " 秒");
				lblMessage.setText(sb.toString());
			}
		});
	}
	
	/**
	 * <p>Description: 配置提交按钮</p>
	 * <p>Title: configureBtnSubmit</p>
	 */
	private void configureBtnSubmit() {
		// 设置字体
		btnSubmit.setFont(font);
		// 设置大小
		btnSubmit.setPreferredSize(btnDimension);
		// 设置文本聚焦
		btnSubmit.setFocusable(false);
		btnSubmit.setVisible(false);
	}

	/**
	 * <p>Description: 配置开始按钮</p>
	 * <p>Title: configureBtnStart</p>
	 */
	private void configureBtnStart() {
		// 设置字体
		btnStart.setFont(font);
		// 设置大小
		btnStart.setPreferredSize(btnDimension);
		// 设置文本聚焦
		btnStart.setFocusable(false);
	}
	
	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);	
		pnlBtnOpearator.add(btnStart);
		pnlBtnOpearator.add(btnSubmit);
		
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
		btnStart.addActionListener(e->{
			btnStartOnClickListener(e);
		});
		btnSubmit.addActionListener(e->{
			btnSubmitOnClickListener(e);
		});
	}
	
	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "中途考试退出成绩为零，确认退出吗？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			timer.stop();
			PaperScoreService paperScoreService = new PaperScoreServiceImpl();
			PaperScoreBean paperScoreBean = new PaperScoreBean();
			paperScoreBean.setPaperID(paperBean.getPaperID());
			paperScoreBean.setSubjectID(paperBean.getSubjectID());
			paperScoreBean.setStudentID(studentBean.getStudentID());
			paperScoreBean.setScore(0.0);
			paperScoreService.insert(paperScoreBean);
			this.dispose();
		}
	}

	/**
	 * <p>Description: 开始按钮点击事件监听器</p>
	 * <p>Title: btnStartOnClickListener</p>
	 * @param e
	 */
	private void btnStartOnClickListener(ActionEvent e) {
		btnStart.setVisible(false);
		btnSubmit.setVisible(true);
		pnlQuestionOne.setVisible(true);
		pnlQuestionTwo.setVisible(true);
		pnlQuestionThree.setVisible(true);
		pnlQuestionFour.setVisible(true);
		pnlQuestionFive.setVisible(true);
		timer.start();
	}
	
	/**
	 * <p>Description: 提交按钮点击事件监听器</p>
	 * <p>Title: btnSubmitOnClickListener</p>
	 * @param e
	 */
	private void btnSubmitOnClickListener(ActionEvent e) {
		calcScore();
	}
	
	/**
	 * <p>Description: 计算成绩</p>
	 * <p>Title: calcScore</p>
	 */
	private void calcScore() {
		PaperScoreBean paperScoreBean = paperScoreService.loadById(paperBean.getPaperID(), studentBean.getStudentID());
		Double score = 0.0;
		String questionOneAnswer = "";
		String questionTwoAnswer = "";
		String questionThreeAnswer = "";
		String questionFourAnswer = "";
		String questionFiveAnswer = "";
		Enumeration<AbstractButton> radioBtnsQuestionOne = btngrpQuestionOneItem.getElements();
		while(radioBtnsQuestionOne.hasMoreElements()) {
			AbstractButton btn = radioBtnsQuestionOne.nextElement();
			if (btn.isSelected()) {
				questionOneAnswer = btn.getText();
				paperScoreBean.setOneAnswer(questionOneAnswer);
				PaperItemBean paperItemBean = paperItems.get(0);
				QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
				if (questionOneAnswer.equals(questionBean.getAnswer())) {
					score += 20;
				}
			}
		}
		Enumeration<AbstractButton> radioBtnsQuestionTwo = btngrpQuestionTwoItem.getElements();
		while(radioBtnsQuestionTwo.hasMoreElements()) {
			AbstractButton btn = radioBtnsQuestionTwo.nextElement();
			if (btn.isSelected()) {
				questionTwoAnswer = btn.getText();
				paperScoreBean.setTwoAnswer(questionTwoAnswer);
				PaperItemBean paperItemBean = paperItems.get(1);
				QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
				if (questionTwoAnswer.equals(questionBean.getAnswer())) {
					score += 20;
				}
			}
		}
		Enumeration<AbstractButton> radioBtnsQuestionThree = btngrpQuestionThreeItem.getElements();
		while(radioBtnsQuestionThree.hasMoreElements()) {
			AbstractButton btn = radioBtnsQuestionThree.nextElement();
			if (btn.isSelected()) {
				questionThreeAnswer = btn.getText();
				paperScoreBean.setThreeAnswer(questionThreeAnswer);
				PaperItemBean paperItemBean = paperItems.get(2);
				QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
				if (questionThreeAnswer.equals(questionBean.getAnswer())) {
					score += 20;
				}
			}
		}
		Enumeration<AbstractButton> radioBtnsQuestionFour = btngrpQuestionFourItem.getElements();
		while(radioBtnsQuestionFour.hasMoreElements()) {
			AbstractButton btn = radioBtnsQuestionFour.nextElement();
			if (btn.isSelected()) {
				questionFourAnswer = btn.getText();
				paperScoreBean.setFourAnswer(questionFourAnswer);
				PaperItemBean paperItemBean = paperItems.get(3);
				QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
				if (questionFourAnswer.equals(questionBean.getAnswer())) {
					score += 20;
				}
			}
		}
		Enumeration<AbstractButton> radioBtnsQuestionFive = btngrpQuestionFiveItem.getElements();
		while(radioBtnsQuestionFive.hasMoreElements()) {
			AbstractButton btn = radioBtnsQuestionFive.nextElement();
			if (btn.isSelected()) {
				questionFiveAnswer = btn.getText();
				paperScoreBean.setFiveAnswer(questionFiveAnswer);
				PaperItemBean paperItemBean = paperItems.get(4);
				QuestionBean questionBean = questionService.loadById(paperItemBean.getQuestionID());
				if (questionFiveAnswer.equals(questionBean.getAnswer())) {
					score += 20;
				}
			}
		}
		
		if (questionOneAnswer == "" && time != 0) {
			JOptionPane.showMessageDialog(null, "第一题还未作答！");
			return;
		} else if (questionTwoAnswer == "" && time != 0) {
			JOptionPane.showMessageDialog(null, "第二题还未作答！");
			return;
		} else if (questionThreeAnswer == "" && time != 0) {
			JOptionPane.showMessageDialog(null, "第三题还未作答！");
			return;
		} else if (questionFourAnswer == "" && time != 0) {
			JOptionPane.showMessageDialog(null, "第四题还未作答！");
			return;
		} else if (questionFiveAnswer == "" && time != 0) {
			JOptionPane.showMessageDialog(null, "第五题还未作答！");
			return;
		} else if (time == 0) {
			JOptionPane.showMessageDialog(null, "考试时间到！");
			timer.stop();
			paperScoreBean.setPaperID(paperBean.getPaperID());
			paperScoreBean.setSubjectID(paperBean.getSubjectID());
			paperScoreBean.setStudentID(studentBean.getStudentID());
			paperScoreBean.setScore(score);
			paperScoreBean.setStatus(1);
			paperScoreService.update(paperScoreBean);
			this.dispose();
		} else {
			int option = JOptionPane.showConfirmDialog(this, "是否提交试卷？", "系统提示", JOptionPane.YES_NO_OPTION);
			
			if (option == JOptionPane.YES_OPTION) {		
				timer.stop();
				PaperScoreService paperScoreService = new PaperScoreServiceImpl();
				paperScoreBean.setPaperID(paperBean.getPaperID());
				paperScoreBean.setSubjectID(paperBean.getSubjectID());
				paperScoreBean.setStudentID(studentBean.getStudentID());
				paperScoreBean.setScore(score);
				paperScoreBean.setStatus(1);
				paperScoreService.update(paperScoreBean);
				this.dispose();
			}
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
}
