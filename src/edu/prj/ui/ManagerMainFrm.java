package edu.prj.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.ui.function.manager.*;

@SuppressWarnings("serial")
public class ManagerMainFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 菜单栏 */
	private JMenuBar menuBar;
	/** 个人菜单 */
	private JMenu menuPersonal;
	/** 功能菜单 */
	private JMenu menuFunction;
	/** 帮助菜单 */
	private JMenu menuHelp;
	/** 个人信息选项 */
	private JMenuItem menuItemInfo;
	/** 注销选项 */
	private JMenuItem menuItemLogout;
	/** 退出选项 */
	private JMenuItem menuItemQuit;
	/** grade年级管理选项 */
	private JMenuItem menuItemGradeManage;
	/** classroom班级管理选项 */
	private JMenuItem menuItemClassRoomManage;
	/** subject科目管理选项 */
	private JMenuItem menuItemSubjectManage;
	/** 用户管理 */
	private JMenu menuUserManage;
	/** 管理员管理选项 */
	private JMenuItem menuItemManagerManage;
	/** 教师管理选项 */
	private JMenuItem menuItemTeacherManage;
	/** 学生管理选项 */
	private JMenuItem menuItemStudentManage;
	/** 关于选项 */
	private JMenuItem menuItemAbout;
	/** 状态面板 */
	private JPanel pnlStatus;
	/** 状态标签 */
	private JLabel lblStatus;
	/** 默认字体 */
	private static Font font = new Font("微软雅黑", Font.BOLD, 16);
	/** 当前状态信息 */
	private String lblStatusNow = "  状态栏：";
	/** 当前登录窗口 */
	public LoginFrm loginFrm = null;
	/** 当前管理员对象 */
	public ManagerBean bean = null;
	/** 当前显示面板 */
	private JPanel pnlNow = null;
	
	public ManagerMainFrm() {
		// UIManager为单例对象，和构造一样只会执行一次
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
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
		pnlNow = new JPanel();
		menuBar = new JMenuBar();
		menuPersonal = new JMenu("个人(P)");
		menuFunction = new JMenu("功能(F)");
		menuHelp = new JMenu("帮助(H)");
		menuItemInfo = new JMenuItem("信息(I)");
		menuItemLogout = new JMenuItem("注销(L)");
		menuItemQuit = new JMenuItem("退出(Q)");
		menuItemGradeManage = new JMenuItem("年级管理(G)");
		menuItemClassRoomManage = new JMenuItem("班级管理(C)");
		menuItemSubjectManage = new JMenuItem("科目管理(S)");
		menuUserManage = new JMenu("用户管理");
		menuItemManagerManage = new JMenuItem("管理员管理(M)");
		menuItemTeacherManage = new JMenuItem("教师管理(T)");
		menuItemStudentManage = new JMenuItem("学生管理(N)");
		menuItemAbout = new JMenuItem("关于(A)");
		pnlStatus = new JPanel();
		lblStatus = new JLabel(lblStatusNow);
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("管理员操作");
		
		// 设置大小
		setSize(new Dimension(800, 600));
		
		// 设置菜单栏
		setJMenuBar(menuBar);
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置窗口布局
		setLayout(new BorderLayout());
				
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
		configureMenuShortcuts();
		configurePnlStatus();
		configureLblStatus();
	}

	/**
	 * <p>Description: 配置菜单快捷键</p>
	 * <p>Title: configureMenuShortcuts</p>
	 */
	private void configureMenuShortcuts() {
		menuPersonal.setMnemonic(KeyEvent.VK_P);
		menuFunction.setMnemonic(KeyEvent.VK_F);
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		menuItemInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		menuItemLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		menuItemGradeManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		menuItemClassRoomManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		menuItemSubjectManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		menuItemManagerManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		menuItemTeacherManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
		menuItemStudentManage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
	}

	/**
	 * <p>Description: 配置状态栏面板</p>
	 * <p>Title: configurePnlStatus</p>
	 */
	private void configurePnlStatus() {
		pnlStatus.setLayout(new BorderLayout());
		pnlStatus.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	/**
	 * <p>Description: 配置状态栏标签</p>
	 * <p>Title: configureLblStatus</p>
	 */
	private void configureLblStatus() {
		lblStatus.setFont(font);
		lblStatus.setPreferredSize(new Dimension(this.getWidth(), 40));
	}

	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		// 添加个人菜单选项
		menuPersonal.add(menuItemInfo);
		menuPersonal.add(menuItemLogout);
		menuPersonal.add(menuItemQuit);
				
		// 添加用户管理子菜单选项
		menuUserManage.add(menuItemManagerManage);
		menuUserManage.add(menuItemTeacherManage);
		menuUserManage.add(menuItemStudentManage);
		
		// 添加功能菜单选项
		menuFunction.add(menuItemGradeManage);
		menuFunction.add(menuItemClassRoomManage);
		menuFunction.add(menuItemSubjectManage);
		menuFunction.add(menuUserManage);
		
		// 添加帮助菜单选项
		menuHelp.add(menuItemAbout);
		
		// 添加菜单栏菜单
		menuBar.add(menuPersonal);
		menuBar.add(menuFunction);
		menuBar.add(menuHelp);
		
		// 添加整体窗口组件
		pnlStatus.add(lblStatus, BorderLayout.WEST);
		container.add(pnlNow, BorderLayout.NORTH);
		container.add(pnlStatus, BorderLayout.SOUTH);
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
		installMenuListener();
	}
	
	/**
	 * <p>Description: 安装菜单事件监听器</p>
	 * <p>Title: installMenuListener</p>
	 */
	private void installMenuListener() {
		menuItemInfo.addActionListener(e->{
			menuItemInfoOnClickListener(e);
		});
		menuItemLogout.addActionListener(e->{
			menuItemLogoutOnClickListener(e);
		});
		menuItemQuit.addActionListener(e->{
			menuItemQuitOnClickListener(e);
		});
		menuItemGradeManage.addActionListener(e->{
			menuItemGradeManageOnClickListener(e);
		});
		menuItemClassRoomManage.addActionListener(e->{
			menuItemClassRoomManageOnClickListener(e);
		});
		menuItemSubjectManage.addActionListener(e->{
			menuItemSubjectManageOnClickListener(e);
		});
		menuItemManagerManage.addActionListener(e->{
			menuItemManagerManageOnClickListener(e);
		});
		menuItemTeacherManage.addActionListener(e->{
			menuItemTeacherManageOnClickListener(e);
		});
		menuItemStudentManage.addActionListener(e->{
			menuItemStudentManageOnClickListener(e);
		});
		menuItemAbout.addActionListener(e->{
			menuItemAboutOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 个人信息选项点击事件监听器</p>
	 * <p>Title: menuItemInfoOnClickListener</p>
	 * @param e
	 */
	private void menuItemInfoOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：个人信息";
		refreshStatus();
		removePnl();
		ManagerInfoPnl managerInfoPnl = new ManagerInfoPnl(bean);
		pnlNow = managerInfoPnl;
		addPnl();
	}

	/**
	 * <p>Description: 注销选项点击事件监听器</p>
	 * <p>Title: menuItemLogoutOnClickListener</p>
	 * @param e
	 */
	private void menuItemLogoutOnClickListener(ActionEvent e) {
		lblStatus.setText("  当前状态：准备注销");

		int option = JOptionPane.showConfirmDialog(this, "是否注销系统", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			if (loginFrm != null) {
				this.dispose();
				loginFrm.showFrm();
			}
		} else {
			refreshStatus();
		}
	}

	/**
	 * <p>Description: 退出选项点击事件监听器</p>
	 * <p>Title: menuItemQuitOnClickListener</p>
	 * @param e
	 */
	private void menuItemQuitOnClickListener(ActionEvent e) {
		lblStatus.setText("  当前状态：即将退出");
		int option = JOptionPane.showConfirmDialog(this, "是否退出系统", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			if (loginFrm != null) {
				this.dispose();
				loginFrm.dispose();
			}
		} else {
			refreshStatus();
		}
	}

	/**
	 * <p>Description: 年级管理选项点击事件监听器</p>
	 * <p>Title: menuItemGradeManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：年级管理";
		refreshStatus();
		removePnl();
		GradeManagePnl gradeManagePnl = new GradeManagePnl();
		gradeManagePnl.bean = this.bean;
		pnlNow = gradeManagePnl;
		addPnl();
	}

	/**
	 * <p>Description: 班级管理选项点击事件监听器</p>
	 * <p>Title: menuItemClassRoomManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemClassRoomManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：班级管理";
		refreshStatus();
		removePnl();
		ClassroomManagePnl classroomManagePnl = new ClassroomManagePnl();
		classroomManagePnl.bean = this.bean;
		pnlNow = classroomManagePnl;
		addPnl();
	}

	/**
	 * <p>Description: 科目管理选项点击事件监听器</p>
	 * <p>Title: menuItemSubjectManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemSubjectManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：科目管理";
		refreshStatus();
		removePnl();
		SubjectManagePnl subjectManagePnl = new SubjectManagePnl();
		subjectManagePnl.bean = this.bean;
		pnlNow = subjectManagePnl;
		addPnl();
	}

	/**
	 * <p>Description: 管理员管理选项点击事件监听器</p>
	 * <p>Title: menuItemUserManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemManagerManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：管理员管理";
		refreshStatus();
		removePnl();
		ManagerManagePnl managerManagePnl = new ManagerManagePnl();
		managerManagePnl.bean = this.bean;
		pnlNow = managerManagePnl;
		addPnl();
	}

	/**
	 * <p>Description: 教师管理选项点击事件监听器</p>
	 * <p>Title: menuItemTeacherManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemTeacherManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：教师管理";
		refreshStatus();
		removePnl();
		TeacherManagePnl teacherManagePnl = new TeacherManagePnl();
		teacherManagePnl.bean = this.bean;
		pnlNow = teacherManagePnl;
		addPnl();
	}
	
	/**
	 * <p>Description: 学生管理选项点击事件监听器</p>
	 * <p>Title: menuItemStudentManageOnClickListener</p>
	 * @param e
	 */
	private void menuItemStudentManageOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：学生管理";
		refreshStatus();
		removePnl();
		StudentManagePnl studentManagePnl = new StudentManagePnl();
		studentManagePnl.bean = this.bean;
		pnlNow = studentManagePnl;
		addPnl();
	}

	/**
	 * <p>Description: 关于选项点击事件监听器</p>
	 * <p>Title: menuItemAboutOnClickListener</p>
	 * @param e
	 */
	private void menuItemAboutOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：关于";
		refreshStatus();
	}

	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		lblStatus.setText("  当前状态：即将退出");
		
		int option = JOptionPane.showConfirmDialog(this, "是否退出系统", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			if (loginFrm != null) {
				this.dispose();
				loginFrm.dispose();
			}
		} else {
			refreshStatus();
		}
	}
	
	/**
	 * <p>Description: 更新状态栏显示信息</p>
	 * <p>Title: refreshStatus</p>
	 */
	private void refreshStatus() {
		lblStatus.setText(lblStatusNow);
	}
	
	/**
	 * <p>Description: 从内容面板移除当前显示面板</p>
	 * <p>Title: removePnl</p>
	 */
	private void removePnl() {
		container.remove(pnlNow);
	}
	
	/**
	 * <p>Description: 向内容面板添加当前显示面板</p>
	 * <p>Title: addPnl</p>
	 */
	private void addPnl() {
		container.add(pnlNow);
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
