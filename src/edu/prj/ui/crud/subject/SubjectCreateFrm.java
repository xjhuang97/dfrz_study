package edu.prj.ui.crud.subject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.manager.*;
import edu.util.Data;

@SuppressWarnings("serial")
public class SubjectCreateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 科目名称信息面板 */
	private JPanel pnlSubjectName;
	/** 教师名称信息面板 */
	private JPanel pnlTeacherName;
	/** 按钮操作面板 */
	private JPanel pnlBtnOpearator;
	/** 科目名称标签 */
	private JLabel lblSubjectName;
	/** 教师名称标签 */
	private JLabel lblTeacherName;
	/** 教师名称下拉框 */
	private JComboBox<String> cboTeacher;
	/** 科目名称文本框 */
	private JTextField txtSubjectName;
	/** 提交按钮 */
	private JButton btnSubmit;
	/** 重置按钮 */
	private JButton btnReset;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(100, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(200, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 当前年级管理面板 */
	public SubjectManagePnl subjectManagePnl = null;
	/** 当前管理员对象 */
	@SuppressWarnings("unused")
	private UserBean bean;
	
	public SubjectCreateFrm(UserBean bean) {
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
		pnlBtnOpearator = new JPanel();
		pnlTeacherName = new JPanel();
		pnlSubjectName = new JPanel();
		lblTitle = new JLabel("科目添加");
		lblSubjectName = new JLabel("科目名称：");
		lblTeacherName = new JLabel("教师：");
		txtSubjectName = new JTextField();
		btnSubmit = new JButton("提交");
		btnReset = new JButton("重置");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("新增科目");
		
		// 设置大小
		setSize(new Dimension(500, 300));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(4, 1));
		
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
		configurePnlTeacherName();
		configurePnlSubjectName();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblTeacherName();
		configureCboTeacher();
		configureLblSubjectName();
		configureTxtSubjectName();
		configureBtnSubmit();
		configureBtnReset();
		refresh();
	}

	/**
	 * <p>Description: 配置教师名称信息面板</p>
	 * <p>Title: configurePnlTeacherName</p>
	 */
	private void configurePnlTeacherName() {
		pnlTeacherName.setLayout(new FlowLayout());
		pnlTeacherName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置科目名称信息面板</p>
	 * <p>Title: configurePnlSubjectName</p>
	 */
	private void configurePnlSubjectName() {
		pnlSubjectName.setLayout(new FlowLayout());
		pnlSubjectName.setPreferredSize(pnlDimension);
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
	 * <p>Description: 配置科目名称标签</p>
	 * <p>Title: configureLblSubjectName</p>
	 */
	private void configureLblSubjectName() {
		lblSubjectName.setFont(font);
		lblSubjectName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置教师名称标签</p>
	 * <p>Title: configureLblSubjectName</p>
	 */
	private void configureLblTeacherName() {
		lblTeacherName.setFont(font);
		lblTeacherName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置科目名称文本框</p>
	 * <p>Title: configureTxtSubjectName</p>
	 */
	private void configureTxtSubjectName() {
		txtSubjectName.setFont(font);
		txtSubjectName.setPreferredSize(txtDimension);
	}
	
	/**
	 * <p>Description: 配置提交按钮</p>
	 * <p>Title: configureBtnSubmit</p>
	 */
	private void configureBtnSubmit() {
		btnSubmit.setFont(font);
		btnSubmit.setPreferredSize(btnDimension);
		btnSubmit.setFocusable(false);
	}

	/**
	 * <p>Description: 配置重置按钮</p>
	 * <p>Title: configureBtnReset</p>
	 */
	private void configureBtnReset() {
		btnReset.setFont(font);
		btnReset.setPreferredSize(btnDimension);
		btnReset.setFocusable(false);
	}

	/**
	 * <p>Description: 配置教师下拉框</p>
	 * <p>Title: configureCboSubject</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configureCboTeacher() {
		cboTeacher = new JComboBox(Data.teachers);
		cboTeacher.setPreferredSize(txtDimension);
		cboTeacher.setFont(font);
	}
	
	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);
		pnlTeacherName.add(lblTeacherName);
		pnlTeacherName.add(cboTeacher);
		pnlSubjectName.add(lblSubjectName);
		pnlSubjectName.add(txtSubjectName);
		pnlBtnOpearator.add(btnSubmit);
		pnlBtnOpearator.add(btnReset);
	
		container.add(pnlTeacherName);
		container.add(pnlSubjectName);
		container.add(pnlBtnOpearator);
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
		btnSubmit.addActionListener(e->{
			btnSubmitOnClickListener(e);
		});
		btnReset.addActionListener(e->{
			btnResetOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否退出编辑？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	/**
	 * <p>Description: 提交按钮点击事件监听器</p>
	 * <p>Title: btnSubmitOnClickListener</p>
	 * @param e
	 */
	private void btnSubmitOnClickListener(ActionEvent e) {
		SubjectService subjectService = new SubjectServiceImpl();
		String subjectName = txtSubjectName.getText().trim();
		Long teacherID = Long.valueOf(cboTeacher.getSelectedIndex());
		if (cboTeacher.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "请选择教师！");
			return;
		} else if (subjectName == null || subjectName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入不能为空！");
			return;
		} else if (subjectService.loadByDoubleName(subjectName, teacherID) == null){
			SubjectBean subjectBean = new SubjectBean();
			subjectBean.setSubjectName(subjectName);
			subjectBean.setTeacherID(teacherID);
			if (subjectService.insert(subjectBean) > 0) {
				JOptionPane.showMessageDialog(null, "新增成功！");
				this.subjectManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "新增失败！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "已存在！");
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
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtSubjectName.setText("");
		cboTeacher.setSelectedIndex(0);
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

}
