package edu.prj.ui.crud.manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.manager.*;

@SuppressWarnings("serial")
public class ManagerCreateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 账号信息面板 */
	private JPanel pnlLoginName;
	/** 密码信息面板 */
	private JPanel pnlLoginPass;
	/** 确认密码信息面板 */
	private JPanel pnlConfirmPass;
	/** 昵称信息面板 */
	private JPanel pnlNickname;
	/** 按钮操作面板 */
	private JPanel pnlBtnOpearator;
	/** 账号标签 */
	private JLabel lblLoginName;
	/** 密码标签 */
	private JLabel lblLoginPass;
	/** 确认密码标签 */
	private JLabel lblConfirmPass;
	/** 昵称标签 */
	private JLabel lblNickname;
	/** 账号文本框 */
	private JTextField txtLoginName;
	/** 密码文本框 */
	private JPasswordField txtLoginPass;
	/** 确认密码文本框 */
	private JPasswordField txtConfirmPass;
	/** 昵称文本框 */
	private JTextField txtNickname;
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
	/** 当前管理员管理面板 */
	public ManagerManagePnl managerManagePnl = null;
	
	public ManagerCreateFrm() {
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
		pnlLoginName = new JPanel();
		pnlLoginPass = new JPanel();
		pnlConfirmPass = new JPanel();
		pnlNickname = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("管理员添加");
		lblLoginName = new JLabel("账号：");
		lblLoginPass = new JLabel("密码：");
		lblConfirmPass = new JLabel("确认密码：");
		lblNickname = new JLabel("昵称：");
		txtLoginName = new JTextField();
		txtLoginPass = new JPasswordField();
		txtConfirmPass = new JPasswordField();
		txtNickname = new JTextField();

		btnSubmit = new JButton("提交");
		btnReset = new JButton("重置");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("新增用户");
		
		// 设置大小
		setSize(new Dimension(500, 400));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(6, 1));
		
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
		configurePnlLoginName();
		configurePnlLoginPass();
		configurePnlNickname();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblLoginName();
		configureLblLoginPass();
		configureLblNickname();
		configureTxtLoginName();
		configureTxtLoginPass();
		configureTxtNickname();
		
		configurePnlConfirmPass();
		configureLblConfirmPass();
		configureTxtConfirmPass();
		
		configureBtnSubmit();
		configureBtnReset();
		
		refresh();
	}

	/**
	 * <p>Description: 配置确认密码信息面板</p>
	 * <p>Title: configurePnlConfirmPass</p>
	 */
	private void configurePnlConfirmPass() {
		pnlConfirmPass.setLayout(new FlowLayout());
		pnlConfirmPass.setPreferredSize(pnlDimension);
		pnlConfirmPass.setVisible(true);
	}

	/**
	 * <p>Description: 配置确认密码标签</p>
	 * <p>Title: configureLblConfirmPass</p>
	 */
	private void configureLblConfirmPass() {
		lblConfirmPass.setFont(font);
		lblConfirmPass.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置确认密码文本框</p>
	 * <p>Title: configureTxtConfirmPass</p>
	 */
	private void configureTxtConfirmPass() {
		txtConfirmPass.setFont(font);
		txtConfirmPass.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置账号信息面板</p>
	 * <p>Title: configurePnlLoginName</p>
	 */
	private void configurePnlLoginName() {
		pnlLoginName.setLayout(new FlowLayout());
		pnlLoginName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置密码信息面板</p>
	 * <p>Title: configurePnlLoginPass</p>
	 */
	private void configurePnlLoginPass() {
		pnlLoginPass.setLayout(new FlowLayout());
		pnlLoginPass.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置昵称信息面板</p>
	 * <p>Title: configurePnlNickname</p>
	 */
	private void configurePnlNickname() {
		pnlNickname.setLayout(new FlowLayout());
		pnlNickname.setPreferredSize(pnlDimension);
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
	 * <p>Description: 配置昵称标签</p>
	 * <p>Title: configureLblNickname</p>
	 */
	private void configureLblNickname() {
		lblNickname.setFont(font);
		lblNickname.setPreferredSize(lblDimension);
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
	 * <p>Description: 配置昵称文本框</p>
	 * <p>Title: configureTxtNickname</p>
	 */
	private void configureTxtNickname() {
		txtNickname.setFont(font);
		txtNickname.setPreferredSize(txtDimension);
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
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		container.add(lblTitle);
		pnlLoginName.add(lblLoginName);
		pnlLoginName.add(txtLoginName);
		pnlLoginPass.add(lblLoginPass);
		pnlLoginPass.add(txtLoginPass);
		pnlConfirmPass.add(lblConfirmPass);
		pnlConfirmPass.add(txtConfirmPass);
		pnlNickname.add(lblNickname);
		pnlNickname.add(txtNickname);
		pnlBtnOpearator.add(btnSubmit);
		pnlBtnOpearator.add(btnReset);
		container.add(pnlLoginName);
		container.add(pnlLoginPass);
		container.add(pnlConfirmPass);
		container.add(pnlNickname);
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
		int option = JOptionPane.showConfirmDialog(this, "是否退出？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	/**
	 * <p>Description: 提交按钮点击事件监听器</p>
	 * <p>Title: btnSubmitOnClickListener</p>
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	private void btnSubmitOnClickListener(ActionEvent e) {
		ManagerService managerService = new ManagerServiceImpl();
		String loginName = txtLoginName.getText().trim();
		String loginPass = txtLoginPass.getText().trim();
		String confirmPass = txtConfirmPass.getText().trim();
		String nickname = txtNickname.getText().trim();	
		if (loginName == null || loginName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "账号不能为空！");
			return;
		} else if (loginPass == null || loginPass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		} else if (confirmPass == null || confirmPass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空！");
			return;
		} else if (nickname == null || nickname.isEmpty()) {
			JOptionPane.showMessageDialog(null, "昵称不能为空！");
			return;
		} else if (managerService.loadByLoginName(loginName) == null){
			if (!loginPass.equals(confirmPass)) {
				JOptionPane.showMessageDialog(null, "两次密码输入不一致！");
				return;
			}
			ManagerBean bean = new ManagerBean();
			bean.setLoginName(loginName);
			bean.setLoginPass(loginPass);
			bean.setNickname(nickname);
			if (managerService.insert(bean) > 0) {
				JOptionPane.showMessageDialog(null, "新增成功！");
				this.managerManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "新增失败！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "该账号已存在！");
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
		txtLoginName.setText("");
		txtLoginPass.setText("");
		txtConfirmPass.setText("");
		txtNickname.setText("");
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
