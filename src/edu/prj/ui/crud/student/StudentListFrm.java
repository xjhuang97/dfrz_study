package edu.prj.ui.crud.student;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.ui.function.manager.*;

@SuppressWarnings("serial")
public class StudentListFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 菜单栏 */
	private JMenuBar menuBar;
	/** 班级菜单 */
	private JMenu menuClassroom;
	/** 关于菜单 */
	private JMenu menuAbout;
	/** 年级一菜单 */
	private JMenu menuGradeOne;
	/** 年级二菜单 */
	private JMenu menuGradeTwo;
	/** 年级三菜单 */
	private JMenu menuGradeThree;
	/** 年级一一班选项 */
	private JMenuItem menuItemGradeOneClassroomOne;
	/** 年级一二班选项 */
	private JMenuItem menuItemGradeOneClassroomTwo;
	/** 年级一三班选项 */
	private JMenuItem menuItemGradeOneClassroomThree;
	/** 年级二一班选项 */
	private JMenuItem menuItemGradeTwoClassroomOne;
	/** 年级二二班选项 */
	private JMenuItem menuItemGradeTwoClassroomTwo;
	/** 年级二三班选项 */
	private JMenuItem menuItemGradeTwoClassroomThree;
	/** 年级三一班选项 */
	private JMenuItem menuItemGradeThreeClassroomOne;
	/** 年级三二班选项 */
	private JMenuItem menuItemGradeThreeClassroomTwo;
	/** 年级三三班选项 */
	private JMenuItem menuItemGradeThreeClassroomThree;
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
	/** 当前管理员对象 */
	public UserBean bean = null;
	/** 获得学生管理面板 */
	private StudentManagePnl studentManagePnl = new StudentManagePnl();
	
	public StudentListFrm(Long gradeID, Long classroomID) {
		// UIManager为单例对象，和构造一样只会执行一次
		UIManager.put("MenuBar.font", font);
		UIManager.put("Menu.font", font);
		UIManager.put("MenuItem.font", font);
		initUI();
		initFrame();
		configureCompents();
		installCompents();
		installListener();
		studentManagePnl.studentListFrm = this;
		studentManagePnl.refreshData(gradeID, classroomID);
	}
	
	/**
	 * <p>Description: 初始化组件</p>
	 * <p>Title: initUI</p>
	 */
	private void initUI() {
		container = new JPanel();
		menuBar = new JMenuBar();
		menuClassroom = new JMenu("班级信息");
		menuAbout = new JMenu("关于");
		menuGradeOne = new JMenu("高一");
		menuItemGradeOneClassroomOne = new JMenuItem("一班");
		menuItemGradeOneClassroomTwo = new JMenuItem("二班");
		menuItemGradeOneClassroomThree = new JMenuItem("三班");
		menuGradeTwo = new JMenu("高二");
		menuItemGradeTwoClassroomOne = new JMenuItem("一班");
		menuItemGradeTwoClassroomTwo = new JMenuItem("二班");
		menuItemGradeTwoClassroomThree = new JMenuItem("三班");
		menuGradeThree = new JMenu("高三");
		menuItemGradeThreeClassroomOne = new JMenuItem("一班");
		menuItemGradeThreeClassroomTwo = new JMenuItem("二班");
		menuItemGradeThreeClassroomThree = new JMenuItem("三班");
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
		setTitle("学生管理");
		
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
		// 添加年级一菜单选项
		menuGradeOne.add(menuItemGradeOneClassroomOne);
		menuGradeOne.add(menuItemGradeOneClassroomTwo);
		menuGradeOne.add(menuItemGradeOneClassroomThree);
		
		// 添加年级二菜单选项
		menuGradeTwo.add(menuItemGradeTwoClassroomOne);
		menuGradeTwo.add(menuItemGradeTwoClassroomTwo);
		menuGradeTwo.add(menuItemGradeTwoClassroomThree);
		
		// 添加年级三菜单选项
		menuGradeThree.add(menuItemGradeThreeClassroomOne);
		menuGradeThree.add(menuItemGradeThreeClassroomTwo);
		menuGradeThree.add(menuItemGradeThreeClassroomThree);
		
		// 添加班级信息菜单选项
		menuClassroom.add(menuGradeOne);
		menuClassroom.add(menuGradeTwo);
		menuClassroom.add(menuGradeThree);
		
		// 添加关于菜单选项
		menuAbout.add(menuItemAbout);
		
		// 添加菜单栏菜单
		menuBar.add(menuClassroom);
		menuBar.add(menuAbout);

		// 添加整体窗口组件
		pnlStatus.add(lblStatus, BorderLayout.WEST);
		container.add(studentManagePnl, BorderLayout.NORTH);
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
		menuItemGradeOneClassroomOne.addActionListener(e->{
			menuItemGradeOneClassroomOneOnClickListener(e);
		});
		menuItemGradeOneClassroomTwo.addActionListener(e->{
			menuItemGradeOneClassroomTwoOnClickListener(e);
		});
		menuItemGradeOneClassroomThree.addActionListener(e->{
			menuItemGradeOneClassroomThreeOnClickListener(e);
		});
		menuItemGradeTwoClassroomOne.addActionListener(e->{
			menuItemGradeTwoClassroomOneOnClickListener(e);
		});
		menuItemGradeTwoClassroomTwo.addActionListener(e->{
			menuItemGradeTwoClassroomTwoOnClickListener(e);
		});
		menuItemGradeTwoClassroomThree.addActionListener(e->{
			menuItemGradeTwoClassroomThreeOnClickListener(e);
		});
		menuItemGradeThreeClassroomOne.addActionListener(e->{
			menuItemGradeThreeClassroomOneOnClickListener(e);
		});
		menuItemGradeThreeClassroomTwo.addActionListener(e->{
			menuItemGradeThreeClassroomTwoOnClickListener(e);
		});
		menuItemGradeThreeClassroomThree.addActionListener(e->{
			menuItemGradeThreeClassroomThreeOnClickListener(e);
		});
		menuItemAbout.addActionListener(e->{
			menuItemAboutOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 年级一一班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeOneClassroomOneOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeOneClassroomOneOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高一一班";
		refreshStatus();
		studentManagePnl.refreshData(1L, 1L);
	}

	/**
	 * <p>Description: 年级一二班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeOneClassroomTwoOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeOneClassroomTwoOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高一二班";
		refreshStatus();
		studentManagePnl.refreshData(1L, 2L);
	}

	/**
	 * <p>Description: 年级一三班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeOneClassroomThreeOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeOneClassroomThreeOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高一三班";
		refreshStatus();
		studentManagePnl.refreshData(1L, 3L);
	}

	/**
	 * <p>Description: 年级二一班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeTwoClassroomOneOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeTwoClassroomOneOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高二一班";
		refreshStatus();
		studentManagePnl.refreshData(2L, 1L);
	}

	/**
	 * <p>Description: 年级二二班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeTwoClassroomTwoOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeTwoClassroomTwoOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高二二班";
		refreshStatus();
		studentManagePnl.refreshData(2L, 2L);
	}

	/**
	 * <p>Description: 年级二三班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeTwoClassroomThreeOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeTwoClassroomThreeOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高二三班";
		refreshStatus();
		studentManagePnl.refreshData(2L, 3L);
	}

	/**
	 * <p>Description: 年级三一班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeThreeClassroomOneOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeThreeClassroomOneOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高三一班";
		refreshStatus();
		studentManagePnl.refreshData(3L, 1L);
	}

	/**
	 * <p>Description: 年级三二班选项点击事件监听器</p>
	 * <p>Title: menuItemGradeThreeClassroomTwoOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeThreeClassroomTwoOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高三二班";
		refreshStatus();
		studentManagePnl.refreshData(3L, 2L);
	}

	/**
	 * <p>Description: 年级三三班点击事件监听器</p>
	 * <p>Title: menuItemGradeThreeClassroomThreeOnClickListener</p>
	 * @param e
	 */
	private void menuItemGradeThreeClassroomThreeOnClickListener(ActionEvent e) {
		lblStatusNow = "  当前状态：高三三班";
		refreshStatus();
		studentManagePnl.refreshData(3L, 3L);
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
		
		int option = JOptionPane.showConfirmDialog(this, "是否关闭？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
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
