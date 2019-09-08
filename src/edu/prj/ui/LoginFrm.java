package edu.prj.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;

@SuppressWarnings("serial")
public class LoginFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 账号标签 */
	private JLabel lblLoginName;
	/** 密码标签 */
	private JLabel lblLoginPass;
	/** 使用者标签 */
	private JLabel lblUser;
	/** 登录消息标签 */
	private JLabel lblMessage;
	/** 账号文本框 */
	private JTextField txtLoginName;
	/** 密码文本框 */
	private JPasswordField txtLoginPass;
	/** 提交按钮 */
	private JButton btnSubmit;
	/** 重置按钮 */
	private JButton btnReset;
	/** 使用者单选组合 */
	private ButtonGroup btngrpUser;
	/** 学生单选按钮 */
	private JRadioButton rdoUserStudent;
	/** 教师单选按钮 */
	private JRadioButton rdoUserTeacher;
	/** 管理员单选按钮 */
	private JRadioButton rdoUserManager;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(100, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(220, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 单选按钮尺寸 */
	private Dimension rdoDimension = new Dimension(80, 40);
	/** 当前登录对象 */
	public UserBean bean = null;
	/** 使用者为管理员 */
	private static final String USER_MANAGER = "管理员";
	/** 使用者为教师 */
	private static final String USER_TEACHER = "教师";
	/** 使用者为学生 */
	private static final String USER_STUDENT = "学生";
	
	public LoginFrm() {
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
		lblTitle = new JLabel("欢迎登录");
		lblLoginName = new JLabel("账号：");
		lblLoginPass = new JLabel("密码：");
		lblUser = new JLabel("身份：");
		lblMessage = new JLabel("提示登录信息");
		txtLoginName = new JTextField();
		txtLoginPass = new JPasswordField();
		btngrpUser = new ButtonGroup();
		rdoUserStudent = new JRadioButton("学生");
		rdoUserTeacher = new JRadioButton("教师");
		rdoUserManager = new JRadioButton("管理员");
		btnSubmit = new JButton("登录");
		btnReset = new JButton("重置");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("登录");
		
		// 设置大小
		setSize(new Dimension(400, 330));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new FlowLayout());
		
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
		configureLblLoginName();
		configureLblLoginPass();
		configureLblUser();
		configureTxtLoginName();
		configureTxtLoginPass();
		configureRdoUserStudent();
		configureRdoUserTeacher();
		configureRdoUserManager();
		configureBtnSubmit();
		configureBtnReset();
		configureLblMessage();
	}

	/**
	 * <p>Description: 配置账号标签</p>
	 * <p>Title: configureLblLoginName</p>
	 */
	private void configureLblLoginName() {
		lblLoginName.setFont(font);
		lblLoginName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置密码标签</p>
	 * <p>Title: configureLblLoginPass</p>
	 */
	private void configureLblLoginPass() {
		lblLoginPass.setFont(font);
		lblLoginPass.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置账号文本框</p>
	 * <p>Title: configureTxtLoginName</p>
	 */
	private void configureTxtLoginName() {
		txtLoginName.setFont(font);
		txtLoginName.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置密码文本框</p>
	 * <p>Title: configureTxtLoginPass</p>
	 */
	private void configureTxtLoginPass() {
		txtLoginPass.setFont(font);
		txtLoginPass.setPreferredSize(txtDimension);
	}
	
	/**
	 * <p>Description: 配置使用者标签</p>
	 * <p>Title: configureLblUser</p>
	 */
	private void configureLblUser() {
		lblUser.setFont(font);
		lblUser.setPreferredSize(lblDimension);
	}
	
	/**
	 * <p>Description: 配置学生单选按钮</p>
	 * <p>Title: configureRdoUserStudent</p>
	 */
	private void configureRdoUserStudent() {
		rdoUserStudent.setFont(font);
		rdoUserStudent.setPreferredSize(rdoDimension);
		rdoUserStudent.setFocusable(false);	
	}

	/**
	 * <p>Description: 配置教师单选按钮</p>
	 * <p>Title: configureRdoUserTeacher</p>
	 */
	private void configureRdoUserTeacher() {
		rdoUserTeacher.setFont(font);
		rdoUserTeacher.setPreferredSize(rdoDimension);
		rdoUserTeacher.setFocusable(false);
	}

	/**
	 * <p>Description: 配置管理员单选按钮</p>
	 * <p>Title: configureRdoUserManager</p>
	 */
	private void configureRdoUserManager() {
		rdoUserManager.setFont(font);
		rdoUserManager.setPreferredSize(rdoDimension);
		rdoUserManager.setFocusable(false);
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
	 * <p>Description: 配置登录消息标签</p>
	 * <p>Title: configureLblMessage</p>
	 */
	private void configureLblMessage() {
		lblMessage.setFont(font);
		lblMessage.setPreferredSize(new Dimension(400, 40));
		// 设置标签居中
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		// 设置前景颜色
		lblMessage.setForeground(Color.RED);
	}
	
	/**
	 * <p>Description: 配置标题标签</p>
	 * <p>Title: configureLblTitle</p>
	 */
	private void configureLblTitle() {
		lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 27));
		lblTitle.setPreferredSize(new Dimension(400, 60));
		// 设置标签居中
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);
		container.add(lblLoginName);
		container.add(txtLoginName);
		container.add(lblLoginPass);
		container.add(txtLoginPass);
		
		
		btngrpUser.add(rdoUserStudent);
		btngrpUser.add(rdoUserTeacher);
		btngrpUser.add(rdoUserManager);
		rdoUserStudent.setSelected(true);
		container.add(lblUser);
		container.add(rdoUserStudent);
		container.add(rdoUserTeacher);
		container.add(rdoUserManager);
		
		container.add(btnSubmit);
		container.add(btnReset);
		container.add(lblMessage);
	}

	/**
	 * <p>Description: 安装监听器</p>
	 * <p>Title: installListener</p>
	 */
	private void installListener() {
		// 监听窗口关闭
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				windowCloseOnClickListener(e);
			}
		});
		// 监听提交按钮
		btnSubmit.addActionListener(e->{
			btnSubmitOnClickListener(e);
		});
		// 监听重置按钮
		btnReset.addActionListener(e->{
			btnResetOnClickListener(e);
		});
	}
	
	/**
	 * <p>Description: 提交按钮点击事件监听器</p>
	 * <p>Title: btnSubmitOnClickListener</p>
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	private void btnSubmitOnClickListener(ActionEvent e) {
		String loginName = txtLoginName.getText().trim();
		String loginPass = txtLoginPass.getText().trim();
		String user = buttonGroupIsSelect();
		if (loginName == null || loginName.isEmpty()) {
			String attention = "账号不能为空！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
			return;
		} else if (loginPass == null || loginPass.isEmpty()) {
			String attention = "密码不能为空！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
			return;
		} else if (user == null) {
			String attention = "请选择登录身份！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
			return;
		} else {
			switch(user) {
				case USER_MANAGER:
					managerLogin(loginName, loginPass);
					break;
				case USER_TEACHER:
					teacherLogin(loginName, loginPass);
					break;
				case USER_STUDENT:
					studentLogin(loginName, loginPass);
					break;
				default:
					JOptionPane.showMessageDialog(null, "请重新输入！");
					break;
			}
		}	
	}
	
	/**
	 * <p>Description: 管理员登录处理</p>
	 * <p>Title: managerLogin</p>
	 */
	private void managerLogin(String loginName, String loginPass) {
		ManagerService managerService = new ManagerServiceImpl();
		ManagerBean bean = managerService.loadByLoginName(loginName);
		// 验证密码
		if (bean == null) {
			String attention = "账号不存在！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else if (!bean.getLoginPass().equals(loginPass)) {
			String attention = "密码输入不正确！"; 
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else {
			ManagerMainFrm managerMainFrm = new ManagerMainFrm();
			managerMainFrm.loginFrm = this;
			managerMainFrm.bean = bean;
			JOptionPane.showMessageDialog(null, "欢迎回来！"+bean.getNickname());
			managerMainFrm.showFrm();
			this.hideFrm();
		}
	}
	
	/**
	 * <p>Description: 教师登录处理</p>
	 * <p>Title: teacherLogin</p>
	 * @param loginName
	 * @param loginPass
	 */
	private void teacherLogin(String loginName, String loginPass) {
		TeacherService teacherService = new TeacherServiceImpl();
		TeacherBean bean = teacherService.loadByLoginName(loginName);
		// 验证密码
		if (bean == null) {
			String attention = "账号不存在！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else if (!bean.getLoginPass().equals(loginPass)) {
			String attention = "密码输入不正确！"; 
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else {
			TeacherMainFrm teacherMainFrm = new TeacherMainFrm();
			teacherMainFrm.loginFrm = this;
			teacherMainFrm.bean = bean;
			JOptionPane.showMessageDialog(null, "欢迎回来！"+bean.getNickname());
			teacherMainFrm.showFrm();
			this.hideFrm();
		}	
	}
	
	/**
	 * <p>Description: 学生登录处理</p>
	 * <p>Title: StudentLogin</p>
	 * @param loginName
	 * @param loginPass
	 */
	private void studentLogin(String loginName, String loginPass) {
		StudentService studentService = new StudentServiceImpl();
		StudentBean bean = studentService.loadByLoginName(loginName);
		// 验证密码
		if (bean == null) {
			String attention = "账号不存在！";
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else if (!bean.getLoginPass().equals(loginPass)) {
			String attention = "密码输入不正确！"; 
			JOptionPane.showMessageDialog(null, attention);
			lblMessage.setText(attention);
		} else {
			StudentMainFrm studentMainFrm = new StudentMainFrm();
			studentMainFrm.loginFrm = this;
			studentMainFrm.bean = bean;
			JOptionPane.showMessageDialog(null, "欢迎回来！"+bean.getNickname());
			studentMainFrm.showFrm();
			this.hideFrm();
		}	
	}
	
	/**
	 * <p>Description: 获得当前单选按钮组的值</p>
	 * <p>Title: buttonGroupIsSelect</p>
	 * @return
	 */
	private String buttonGroupIsSelect() {
		if (rdoUserManager.isSelected()) {
			return USER_MANAGER;
		} else if (rdoUserTeacher.isSelected()) {
			return USER_TEACHER;
		} else if (rdoUserStudent.isSelected()) {
			return USER_STUDENT;
		} else {
			return null;
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
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否退出系统？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtLoginName.setText("");
		txtLoginPass.setText("");
		btngrpUser.clearSelection();
	}

	/**
	 * <p>Description: 窗口可见</p>
	 * <p>Title: showMainFrm</p>
	 */
	public void showFrm() {
		refresh();
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
