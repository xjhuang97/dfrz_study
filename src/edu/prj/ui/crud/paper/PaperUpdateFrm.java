package edu.prj.ui.crud.paper;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.exam.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.teacher.*;
import edu.util.*;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class PaperUpdateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 试卷名称信息面板 */
	private JPanel pnlPaperName;
	/** 科目信息面板 */
	private JPanel pnlSubjectName;
	/** 总分信息面板 */
	private JPanel pnlTotalScore;
	/** 每题分数面板 */
	private JPanel pnlPerScore;
	/** 题目数量面板 */
	private JPanel pnlQuestionNum;
	/** 考试时间信息面板 */
	private JPanel pnlExamMinute;
	/** 有效开始日期信息面板 */
	private JPanel pnlStartOn;
	/** 有效结束日期信息面板 */
	private JPanel pnlEndOn;
	/** 按钮操作信息面板 */
	private JPanel pnlBtnOpearator;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 试卷名称标签 */
	private JLabel lblPaperName;
	/** 所属科目标签 */
	private JLabel lblSubjectName;
	/** 总分标签 */
	private JLabel lblTotalScore;
	/** 每天分数标签 */
	private JLabel lblPerScore;
	/** 题目数量标签 */
	private JLabel lblQuestionNum;
	/** 考试时间标签 */
	private JLabel lblExamMinute;
	/** 有效开始日期标签 */
	private JLabel lblStartOn;
	/** 有效结束日期标签 */
	private JLabel lblEndOn;
	/** 试卷名称文本框 */
	private JTextField txtPaperName;
	/** 所属科目下拉框 */
	private JComboBox<String> cboSubject;
	/** 总分文本框 */
	private JTextField txtTotalScore;
	/** 每题分数文本框 */
	private JTextField txtPerScore;
	/** 题目数量文本框 */
	private JTextField txtQuestionNum;
	/** 考试时间文本框 */
	private JTextField txtExamMinute;
	/** 年标签 */
	private JLabel lblStartOnYear;
	/** 年标签 */
	private JLabel lblEndOnYear;
	/** 月标签 */
	private JLabel lblStartOnMonth;
	/** 月标签 */
	private JLabel lblEndOnMonth;
	/** 日标签 */
	private JLabel lblStartOnDay;
	/** 日标签 */
	private JLabel lblEndOnDay;
	/** 有效开始日期年份下拉框 */
	private JComboBox<String> cboStartOnYear;
	/** 有效开始日期月份下拉框 */
	private JComboBox<String> cboStartOnMonth;
	/** 有效开始日期日期下拉框 */
	private JComboBox<String> cboStartOnDay;
	/** 有效结束日期年份下拉框 */
	private JComboBox<String> cboEndOnYear;
	/** 有效结束日期月份下拉框 */
	private JComboBox<String> cboEndOnMonth;
	/** 有效结束日期日期下拉框 */
	private JComboBox<String> cboEndOnDay;
	/** 修改按钮 */
	private JButton btnUpdate;
	/** 保存按钮 */
	private JButton btnSave;
	/** 取消按钮 */
	private JButton btnReset;
	/** 取消按钮 */
	private JButton btnCancel;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(150, 40);
	/** 年、月、日标签尺寸 */
	private Dimension dateDimension = new Dimension(20, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(200, 40);
	/** 年、月、日下拉框尺寸  */
	private Dimension cboDateDimension = new Dimension(150, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 年份数组 */
	private String[] years = Data.years;
	/** 月份数组 */
	private String[] months = Data.months;
	/** 日期数组 */
	private String[] days = Data.days;
	/** 当前试卷对象 */
	private PaperBean bean;
	/** 试卷管理面板 */
	public PaperManagePnl paperManagePnl = null;
	
	public PaperUpdateFrm(PaperBean bean) {
		this.bean = bean;
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
		container = new JPanel();
		pnlPaperName = new JPanel();
		pnlSubjectName = new JPanel();
		pnlTotalScore = new JPanel();
		pnlPerScore = new JPanel();
		pnlQuestionNum = new JPanel();
		pnlExamMinute = new JPanel();
		pnlStartOn = new JPanel();
		pnlEndOn = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblPaperName = new JLabel("试卷名称：");
		lblSubjectName = new JLabel("所属科目：");
		lblTotalScore = new JLabel("总分：");
		lblPerScore = new JLabel("每题分数：");
		lblQuestionNum = new JLabel("题目数量：");
		lblExamMinute = new JLabel("考试时间：");
		lblStartOn = new JLabel("有效开始日期：");
		lblEndOn = new JLabel("有效结束日期：");
		lblStartOnYear = new JLabel("年");
		lblEndOnYear = new JLabel("年");
		lblStartOnMonth = new JLabel("月");
		lblEndOnMonth = new JLabel("月");
		lblStartOnDay = new JLabel("日");
		lblEndOnDay = new JLabel("日");
		txtPaperName = new JTextField();
		txtTotalScore = new JTextField();
		txtPerScore = new JTextField();
		txtQuestionNum = new JTextField();
		txtExamMinute = new JTextField();
		
		lblTitle = new JLabel("试卷信息");
		btnUpdate = new JButton("修改");
		btnSave = new JButton("保存");
		btnReset = new JButton("重置");
		btnCancel = new JButton("取消");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("试卷信息");
		
		// 设置大小
		setSize(new Dimension(750, 750));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(10, 1));
		
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
		configureLblTitle();
		configurePnlPaperName();
		configurePnlSubjectName();
		configurePnlTotalScore();
		configurePnlPerScore();
		configurePnlQuestionNum();
		configurePnlExamMinute();
		configurePnlStartOn();
		configurePnlEndOn();
		configurePnlBtnOpearator();
		configureLblPaperName();
		configureLblSubjectName();
		configureLblTotalScore();
		configureLblPerScore();
		configureLblQuestionNum();
		configureLblExamMinute();
		configureLblStartOn();
		configureLblEndOn();
		configureLblYear();
		configureLblMonth();
		configureLblDay();
		configureTxtPaperName();
		configureCboSubject();
		configureTxtTotalScore();
		configureTxtPerScore();
		configureTxtQuestionNum();
		configureTxtExamMinute();
		configureCboStartOnYear();
		configureCboStartOnMonth();
		configureCboStartOnDay();
		configureCboEndOnYear();
		configureCboEndOnMonth();
		configureCboEndOnDay();
		configureBtnReset();
		
		configureBtnUpdate();
		configureBtnSave();
		configureBtnReset();
		configureBtnCancel();
		
		setEditableFalse();
		refresh();
	}

	/**
	 * <p>Description: 配置试卷名称信息面板</p>
	 * <p>Title: configurePnlPaperName</p>
	 */
	private void configurePnlPaperName() {
		pnlPaperName.setLayout(new FlowLayout());
		pnlPaperName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置所属科目信息面板</p>
	 * <p>Title: configurePnlSubjectName</p>
	 */
	private void configurePnlSubjectName() {
		pnlSubjectName.setLayout(new FlowLayout());
		pnlSubjectName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置总分信息面板</p>
	 * <p>Title: configurePnlTotalScore</p>
	 */
	private void configurePnlTotalScore() {
		pnlTotalScore.setLayout(new FlowLayout());
		pnlTotalScore.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置每题分数信息面板</p>
	 * <p>Title: configurePnlPerScore</p>
	 */
	private void configurePnlPerScore() {
		pnlPerScore.setLayout(new FlowLayout());
		pnlPerScore.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目数量信息面板</p>
	 * <p>Title: configurePnlQuestionNum</p>
	 */
	private void configurePnlQuestionNum() {
		pnlQuestionNum.setLayout(new FlowLayout());
		pnlQuestionNum.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置考试时间信息面板</p>
	 * <p>Title: configurePnlExamMinute</p>
	 */
	private void configurePnlExamMinute() {
		pnlExamMinute.setLayout(new FlowLayout());
		pnlExamMinute.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置有效开始日期信息面板</p>
	 * <p>Title: configurePnlStartOn</p>
	 */
	private void configurePnlStartOn() {
		pnlStartOn.setLayout(new FlowLayout());
		pnlStartOn.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置有效结束日期信息面板</p>
	 * <p>Title: configurePnlEndOn</p>
	 */
	private void configurePnlEndOn() {
		pnlEndOn.setLayout(new FlowLayout());
		pnlEndOn.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置按钮操作面板</p>
	 * <p>Title: configurePnlBtnOpearator</p>
	 */
	private void configurePnlBtnOpearator() {
		pnlBtnOpearator.setLayout(new FlowLayout());
		pnlBtnOpearator.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置试卷名称标签</p>
	 * <p>Title: configureLblPaperName</p>
	 */
	private void configureLblPaperName() {
		lblPaperName.setFont(font);
		lblPaperName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置所属科目标签</p>
	 * <p>Title: configureLblSubjectName</p>
	 */
	private void configureLblSubjectName() {
		lblSubjectName.setFont(font);
		lblSubjectName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置总分标签</p>
	 * <p>Title: configureLblTotalScore</p>
	 */
	private void configureLblTotalScore() {
		lblTotalScore.setFont(font);
		lblTotalScore.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置每题分数标签</p>
	 * <p>Title: configureLblPerScore</p>
	 */
	private void configureLblPerScore() {
		lblPerScore.setFont(font);
		lblPerScore.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目数量标签</p>
	 * <p>Title: configureLblQuestionNum</p>
	 */
	private void configureLblQuestionNum() {
		lblQuestionNum.setFont(font);
		lblQuestionNum.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置考试时间标签</p>
	 * <p>Title: configureLblExamMinute</p>
	 */
	private void configureLblExamMinute() {
		lblExamMinute.setFont(font);
		lblExamMinute.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置有效开始日期标签</p>
	 * <p>Title: configureLblStartOn</p>
	 */
	private void configureLblStartOn() {
		lblStartOn.setFont(font);
		lblStartOn.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置有效结束日期标签</p>
	 * <p>Title: configureLblEndOn</p>
	 */
	private void configureLblEndOn() {
		lblEndOn.setFont(font);
		lblEndOn.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置年份标签</p>
	 * <p>Title: configureLblYear</p>
	 */
	private void configureLblYear() {
		lblStartOnYear.setFont(font);
		lblStartOnYear.setPreferredSize(dateDimension);
		lblEndOnYear.setFont(font);
		lblEndOnYear.setPreferredSize(dateDimension);
	}

	/**
	 * <p>Description: 配置月份标签</p>
	 * <p>Title: configureLblMonth</p>
	 */
	private void configureLblMonth() {
		lblStartOnMonth.setFont(font);
		lblStartOnMonth.setPreferredSize(dateDimension);
		lblEndOnMonth.setFont(font);
		lblEndOnMonth.setPreferredSize(dateDimension);
	}

	/**
	 * <p>Description: 配置日期标签</p>
	 * <p>Title: configureLblDay</p>
	 */
	private void configureLblDay() {
		lblStartOnDay.setFont(font);
		lblStartOnDay.setPreferredSize(dateDimension);
		lblEndOnDay.setFont(font);
		lblEndOnDay.setPreferredSize(dateDimension);
	}

	/**
	 * <p>Description: 配置试卷名称文本框</p>
	 * <p>Title: configureTxtPaperName</p>
	 */
	private void configureTxtPaperName() {
		txtPaperName.setFont(font);
		txtPaperName.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置所属科目下拉框</p>
	 * <p>Title: configureCboSubject</p>
	 */
	private void configureCboSubject() {
		cboSubject = new JComboBox(Data.subjects);
		cboSubject.setPreferredSize(txtDimension);
		cboSubject.setFont(font);
	}

	/**
	 * <p>Description: 配置总分文本框</p>
	 * <p>Title: configureTxtTotalScore</p>
	 */
	private void configureTxtTotalScore() {
		txtTotalScore.setFont(font);
		txtTotalScore.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置每题分数文本框</p>
	 * <p>Title: configureTxtPerScore</p>
	 */
	private void configureTxtPerScore() {
		txtPerScore.setFont(font);
		txtPerScore.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置题目数量文本框</p>
	 * <p>Title: configureTxtQuestionNum</p>
	 */
	private void configureTxtQuestionNum() {
		txtQuestionNum.setFont(font);
		txtQuestionNum.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置考试时间文本框</p>
	 * <p>Title: configureTxtExamMinute</p>
	 */
	private void configureTxtExamMinute() {
		txtExamMinute.setFont(font);
		txtExamMinute.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置有效开始日期年份下拉框</p>
	 * <p>Title: configureCboStartOnYear</p>
	 */
	private void configureCboStartOnYear() {
		cboStartOnYear = new JComboBox(years);
		cboStartOnYear.setPreferredSize(cboDateDimension);
		cboStartOnYear.setFont(font);
	}

	/**
	 * <p>Description: 配置有效开始日期月份下拉框</p>
	 * <p>Title: configureCboStartOnMonth</p>
	 */
	private void configureCboStartOnMonth() {
		cboStartOnMonth = new JComboBox(months);
		cboStartOnMonth.setPreferredSize(cboDateDimension);
		cboStartOnMonth.setFont(font);
	}

	/**
	 * <p>Description: 配置有效开始日期日期下拉框</p>
	 * <p>Title: configureCboStartOnDay</p>
	 */
	private void configureCboStartOnDay() {
		cboStartOnDay = new JComboBox(days);
		cboStartOnDay.setPreferredSize(cboDateDimension);
		cboStartOnDay.setFont(font);
	}

	/**
	 * <p>Description: 配置有效结束日期年份下拉框</p>
	 * <p>Title: configureCboEndOnYear</p>
	 */
	private void configureCboEndOnYear() {
		cboEndOnYear = new JComboBox(years);
		cboEndOnYear.setPreferredSize(cboDateDimension);
		cboEndOnYear.setFont(font);
	}

	/**
	 * <p>Description: 配置有效结束日期月份下拉框</p>
	 * <p>Title: configureCboEndOnMonth</p>
	 */
	private void configureCboEndOnMonth() {
		cboEndOnMonth = new JComboBox(months);
		cboEndOnMonth.setPreferredSize(cboDateDimension);
		cboEndOnMonth.setFont(font);
	}

	/**
	 * <p>Description: 配置有效结束日期日期下拉框</p>
	 * <p>Title: configureCboEndOnDay</p>
	 */
	private void configureCboEndOnDay() {	
		cboEndOnDay = new JComboBox(days);
		cboEndOnDay.setPreferredSize(cboDateDimension);
		cboEndOnDay.setFont(font);
	}

	/**
	 * <p>Description: 配置修改按钮</p>
	 * <p>Title: configureBtnUpdate</p>
	 */
	private void configureBtnUpdate() {
		btnUpdate.setFont(font);
		btnUpdate.setPreferredSize(btnDimension);
		btnUpdate.setFocusable(false);
	}
	
	/**
	 * <p>Description: 配置保存按钮</p>
	 * <p>Title: configureBtnSave</p>
	 */
	private void configureBtnSave() {
		btnSave.setFont(font);
		btnSave.setPreferredSize(btnDimension);
		btnSave.setFocusable(false);
		btnSave.setVisible(false);
	}
	
	/**
	 * <p>Description: 配置重置按钮</p>
	 * <p>Title: configureBtnReset</p>
	 */
	private void configureBtnReset() {
		btnReset.setFont(font);
		btnReset.setPreferredSize(btnDimension);
		btnReset.setFocusable(false);
		btnReset.setVisible(false);
	}

	/**
	 * <p>Description: 配置取消按钮</p>
	 * <p>Title: configureBtnCancel</p>
	 */
	private void configureBtnCancel() {
		btnCancel.setFont(font);
		btnCancel.setPreferredSize(btnDimension);
		btnCancel.setFocusable(false);
		btnCancel.setVisible(false);
	}
	
	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);
		pnlPaperName.add(lblPaperName);
		pnlPaperName.add(txtPaperName);
		
		pnlSubjectName.add(lblSubjectName);
		pnlSubjectName.add(cboSubject);
		
		pnlTotalScore.add(lblTotalScore);
		pnlTotalScore.add(txtTotalScore);
		
		pnlPerScore.add(lblPerScore);
		pnlPerScore.add(txtPerScore);
		
		pnlQuestionNum.add(lblQuestionNum);
		pnlQuestionNum.add(txtQuestionNum);
		
		pnlExamMinute.add(lblExamMinute);
		pnlExamMinute.add(txtExamMinute);
		
		pnlStartOn.add(lblStartOn);
		pnlStartOn.add(cboStartOnYear);
		pnlStartOn.add(lblStartOnYear);
		pnlStartOn.add(cboStartOnMonth);
		pnlStartOn.add(lblStartOnMonth);
		pnlStartOn.add(cboStartOnDay);
		pnlStartOn.add(lblStartOnDay);
		
		pnlEndOn.add(lblEndOn);
		pnlEndOn.add(cboEndOnYear);
		pnlEndOn.add(lblEndOnYear);
		pnlEndOn.add(cboEndOnMonth);
		pnlEndOn.add(lblEndOnMonth);
		pnlEndOn.add(cboEndOnDay);
		pnlEndOn.add(lblEndOnDay);
		
		pnlBtnOpearator.add(btnUpdate);
		pnlBtnOpearator.add(btnSave);
		pnlBtnOpearator.add(btnReset);
		pnlBtnOpearator.add(btnCancel);
		
		container.add(pnlPaperName);
		container.add(pnlSubjectName);
		container.add(pnlTotalScore);
		container.add(pnlPerScore);
		container.add(pnlQuestionNum);
		container.add(pnlExamMinute);
		container.add(pnlStartOn);
		container.add(pnlEndOn);
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
		btnUpdate.addActionListener(e->{
			btnUpdateOnClickListener(e);
		});
		btnSave.addActionListener(e->{
			btnSaveOnClickListener(e);
		});	
		btnReset.addActionListener(e->{
			btnResetOnClickListener(e);
		});
		btnCancel.addActionListener(e->{
			btnCancelOnClickListener(e);
		});
	}


	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否退出编辑", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	/**
	 * <p>Description: 修改按钮点击事件监听器</p>
	 * <p>Title: btnUpdateOnClickListener</p>
	 * @param e
	 */
	private void btnUpdateOnClickListener(ActionEvent e) {
		setEditableTrue();
	}
	
	/**
	 * <p>Description: 保存按钮点击事件监听器</p>
	 * <p>Title: btnSubmitOnClickListener</p>
	 * @param e
	 */
	private void btnSaveOnClickListener(ActionEvent e) {
		PaperService paperService = new PaperServiceImpl();
		
		String paperName = txtPaperName.getText().trim();
		Double totalScore = Double.valueOf(txtTotalScore.getText().trim());
		Double perScore = Double.valueOf(txtPerScore.getText().trim());
		Integer questionNum = Integer.valueOf(txtQuestionNum.getText().trim());
		Integer examMinute = Integer.valueOf(txtExamMinute.getText().trim());
		if (paperName == null || paperName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "试卷名称不能为空！");
			return;
		} else if (cboSubject.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "请选择科目！");
			return;
		} else if (totalScore == null || totalScore == 0) {
			JOptionPane.showMessageDialog(null, "总分不能为空！");
			return;
		} else if (perScore == null || perScore == 0) {
			JOptionPane.showMessageDialog(null, "每题分数不能为空！");
			return;
		} else if (questionNum == null || questionNum == 0) {
			JOptionPane.showMessageDialog(null, "题目数量不能为空！");
			return;
		} else if (examMinute == null || examMinute == 0) {
			JOptionPane.showMessageDialog(null, "考试时间不能为空！");
			return;
		} else if (cboStartOnYear.getSelectedIndex()==0 || 
				cboStartOnMonth.getSelectedIndex()==0 || 
				cboStartOnDay.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "请选择有效开始日期！");
			return;
		} else if (cboEndOnYear.getSelectedIndex()==0 ||
				cboEndOnMonth.getSelectedIndex()==0 ||
				cboEndOnDay.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "请选择有效结束日期！");
			return;
		} else {
			bean.setSubjectID(Long.valueOf(cboSubject.getSelectedIndex()));
			bean.setPaperName(paperName);
			bean.setTotalScore(totalScore);
			bean.setPerScore(perScore);
			bean.setQuestionNum(questionNum);
			bean.setExamMinute(examMinute);
			StringBuilder sbStart = new StringBuilder();
			sbStart.append(years[cboStartOnYear.getSelectedIndex()]);
			sbStart.append("-");
			sbStart.append(months[cboStartOnMonth.getSelectedIndex()]);
			sbStart.append("-");
			sbStart.append(days[cboStartOnDay.getSelectedIndex()]);
			String startOn = sbStart.toString();
			bean.setStartOn(startOn);
			
			StringBuilder sbEnd = new StringBuilder();
			sbEnd.append(years[cboEndOnYear.getSelectedIndex()]);
			sbEnd.append("-");
			sbEnd.append(months[cboEndOnMonth.getSelectedIndex()]);
			sbEnd.append("-");
			sbEnd.append(days[cboEndOnDay.getSelectedIndex()]);
			String endOn = sbEnd.toString();
			bean.setEndOn(endOn);
			
			if (paperService.update(bean) > 0) {
				JOptionPane.showMessageDialog(null, "保存成功！");
				paperManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "保存失败！");
				return;
			}
		}
	}	
	
	/**
	 * <p>Description: 重置按钮点击事件监听器</p>
	 * <p>Title: btnResetOnClickListener</p>
	 * @param e
	 */
	private void btnResetOnClickListener(ActionEvent e) {
		refresh();
	}
	
	/**
	 * <p>Description: 取消按钮事件监听器</p>
	 * <p>Title: btnCancelOnClickListener</p>
	 * @param e
	 */
	private void btnCancelOnClickListener(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(this, "是否取消修改？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			refresh();
			setEditableFalse();
		}
		
	}
	
	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtPaperName.setText(bean.getPaperName());
		cboSubject.setSelectedIndex(Integer.valueOf(bean.getSubjectID()+""));
		txtTotalScore.setText(bean.getTotalScore()+"");
		txtPerScore.setText(bean.getPerScore()+"");
		txtQuestionNum.setText(bean.getQuestionNum()+"");
		txtExamMinute.setText(bean.getExamMinute()+"");
		String[] startOn = bean.getStartOn().split("-");
		cboStartOnYear.setSelectedIndex(getYearArrayIndex(startOn[0]));
		cboStartOnMonth.setSelectedIndex(getMonthArrayIndex(startOn[1]));
		cboStartOnDay.setSelectedIndex(getDayArrayIndex(startOn[2]));
		
		String[] endOn = bean.getEndOn().split("-");
		cboEndOnYear.setSelectedIndex(getYearArrayIndex(endOn[0]));
		cboEndOnMonth.setSelectedIndex(getMonthArrayIndex(endOn[1]));
		cboEndOnDay.setSelectedIndex(getDayArrayIndex(endOn[2]));
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
	 * <p>Description: 获得年份数组下标</p>
	 * <p>Title: getYearArrayIndex</p>
	 * @param str
	 * @return
	 */
	private Integer getYearArrayIndex(String str) {
		Integer index = -1;
		for (int i = 0; i < years.length; i++) {
			if (str.equals(years[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * <p>Description: 获得月份数组下标</p>
	 * <p>Title: getMonthArrayIndex</p>
	 * @param str
	 * @return
	 */
	private Integer getMonthArrayIndex(String str) {
		Integer index = -1;
		for (int i = 0; i < months.length; i++) {
			if (str.equals(months[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * <p>Description: 获得日期数组下标</p>
	 * <p>Title: getDayArrayIndex</p>
	 * @param str
	 * @return
	 */
	private Integer getDayArrayIndex(String str) {
		Integer index = -1;
		for (int i = 0; i < days.length; i++) {
			if (str.equals(days[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * <p>Description: 设置不可编辑</p>
	 * <p>Title: setEditableTrue</p>
	 */
	private void setEditableFalse() {
		txtPaperName.setEditable(false);
		cboSubject.setEnabled(false);
		txtTotalScore.setEditable(false);
		txtPerScore.setEditable(false);
		txtQuestionNum.setEditable(false);
		txtExamMinute.setEditable(false);
		cboStartOnYear.setEnabled(false);
		cboStartOnMonth.setEnabled(false);
		cboStartOnDay.setEnabled(false);
		cboEndOnYear.setEnabled(false);
		cboEndOnMonth.setEnabled(false);
		cboEndOnDay.setEnabled(false);
		btnUpdate.setVisible(true);
		btnSave.setVisible(false);
		btnReset.setVisible(false);
		btnCancel.setVisible(false);
	}
	
	/**
	 * <p>Description: 设置可编辑</p>
	 * <p>Title: setEditableTrue</p>
	 */
	private void setEditableTrue() {
		txtPaperName.setEditable(true);
		cboSubject.setEnabled(true);
		txtTotalScore.setEditable(true);
		txtPerScore.setEditable(true);
		txtQuestionNum.setEditable(true);
		txtExamMinute.setEditable(true);
		cboStartOnYear.setEnabled(true);
		cboStartOnMonth.setEnabled(true);
		cboStartOnDay.setEnabled(true);
		cboEndOnYear.setEnabled(true);
		cboEndOnMonth.setEnabled(true);
		cboEndOnDay.setEnabled(true);
		btnUpdate.setVisible(false);
		btnSave.setVisible(true);
		btnReset.setVisible(true);
		btnCancel.setVisible(true);
	}
}
