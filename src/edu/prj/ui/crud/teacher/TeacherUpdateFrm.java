package edu.prj.ui.crud.teacher;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.manager.*;

@SuppressWarnings("serial")
public class TeacherUpdateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 标题标签 */
	private JLabel lblTitle;
	/** ID信息面板 */
	private JPanel pnlID;
	/** 账号信息面板 */
	private JPanel pnlLoginName;
	/** 昵称信息面板 */
	private JPanel pnlNickname;
	/** 是否禁用信息面板 */
	private JPanel pnlIsDisabled;
	/** 按钮操作面板 */
	private JPanel pnlBtnOpearator;
	/** ID标签 */
	private JLabel lblID;
	/** 账号标签 */
	private JLabel lblLoginName;
	/** 昵称标签 */
	private JLabel lblNickname;
	/** 是否禁用 */
	private JLabel lblIsDisabled;
	/** ID文本框 */
	private JTextField txtID;
	/** 账号文本框 */
	private JTextField txtLoginName;
	/** 昵称文本框 */
	private JTextField txtNickname;
	/** 是否禁用文本框 */
	private JTextField txtIsDisabled;
	/** 修改按钮 */
	private JButton btnUpdate;
	/** 保存按钮 */
	private JButton btnSave;
	/** 取消按钮 */
	private JButton btnCancel;
	/** 重置密码按钮 */
	private JButton btnResetPass;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(100, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(200, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(120, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 当前修改对象 */
	private TeacherBean bean = null;
	/** 教师管理面板 */
	public TeacherManagePnl teacherManagePnl = null;
	/** 教师业务 */
	private TeacherService teacherService = new TeacherServiceImpl();
	
	public TeacherUpdateFrm(TeacherBean bean) {
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
		pnlID = new JPanel();
		pnlLoginName = new JPanel();
		pnlNickname = new JPanel();
		pnlIsDisabled = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("用户信息");
		lblID = new JLabel("ID：");
		lblLoginName = new JLabel("账号：");
		lblNickname = new JLabel("昵称：");
		lblIsDisabled = new JLabel("是否禁用：");
		txtID = new JTextField();
		txtLoginName = new JTextField();
		txtNickname = new JTextField();
		txtIsDisabled = new JTextField();
		btnUpdate = new JButton("修改");
		btnResetPass = new JButton("重置密码");
		btnSave = new JButton("保存");
		btnCancel = new JButton("取消");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("用户信息");
		
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
		configureLblTitle();
		configurePnlID();
		configurePnlLoginName();
		configurePnlNickname();
		configurePnlIsDisabled();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblID();
		configureLblLoginName();
		configureLblNickname();
		configureLblIsDisabled();
		configureTxtID();
		configureTxtLoginName();
		configureTxtNickname();
		configureTxtIsDisabled();
		configureBtnResetPass();
		configureBtnUpdate();
		configureBtnSave();
		configureBtnCancel();
		
		refresh();
	}

	/**
	 * <p>Description: 配置ID信息面板</p>
	 * <p>Title: configurePnlID</p>
	 */
	private void configurePnlID() {
		pnlID.setLayout(new FlowLayout());
		pnlID.setPreferredSize(pnlDimension);
		pnlID.setVisible(true);
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
	 * <p>Description: 配置昵称信息面板</p>
	 * <p>Title: configurePnlNickname</p>
	 */
	private void configurePnlNickname() {
		pnlNickname.setLayout(new FlowLayout());
		pnlNickname.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置是否禁用信息面板</p>
	 * <p>Title: configurePnlIsDisabled</p>
	 */
	private void configurePnlIsDisabled() {
		pnlIsDisabled.setLayout(new FlowLayout());
		pnlIsDisabled.setPreferredSize(pnlDimension);
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
	 * <p>Description: 配置ID标签</p>
	 * <p>Title: configureLblID</p>
	 */
	private void configureLblID() {
		lblID.setFont(font);
		lblID.setPreferredSize(lblDimension);
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
	 * <p>Description: 配置昵称标签</p>
	 * <p>Title: configureLblNickname</p>
	 */
	private void configureLblNickname() {
		lblNickname.setFont(font);
		lblNickname.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置是否禁用标签</p>
	 * <p>Title: configureLblIsDisabled</p>
	 */
	private void configureLblIsDisabled() {
		lblIsDisabled.setFont(font);
		lblIsDisabled.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置ID文本框</p>
	 * <p>Title: configureTxtID</p>
	 */
	private void configureTxtID() {
		txtID.setFont(font);
		txtID.setPreferredSize(txtDimension);
		txtID.setEditable(false);
	}

	/**
	 * <p>Description: 配置账号文本框</p>
	 * <p>Title: configureTxtLoginName</p>
	 */
	private void configureTxtLoginName() {
		txtLoginName.setFont(font);
		txtLoginName.setPreferredSize(txtDimension);
		txtLoginName.setEditable(false);
	}
	
	/**
	 * <p>Description: 配置昵称文本框</p>
	 * <p>Title: configureTxtNickname</p>
	 */
	private void configureTxtNickname() {
		txtNickname.setFont(font);
		txtNickname.setPreferredSize(txtDimension);
		txtNickname.setEditable(false);
	}

	/**
	 * <p>Description: 配置是否禁用文本框</p>
	 * <p>Title: configureTxtIsDisabled</p>
	 */
	private void configureTxtIsDisabled() {
		txtIsDisabled.setFont(font);
		txtIsDisabled.setPreferredSize(txtDimension);
		txtIsDisabled.setEditable(false);
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
	 * <p>Description: 配置重置密码按钮</p>
	 * <p>Title: configureBtnResetPass</p>
	 */
	private void configureBtnResetPass() {
		btnResetPass.setFont(font);
		btnResetPass.setPreferredSize(btnDimension);
		btnResetPass.setFocusable(false);
		btnResetPass.setVisible(false);
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
		
		pnlID.add(lblID);
		pnlID.add(txtID);
		pnlLoginName.add(lblLoginName);
		pnlLoginName.add(txtLoginName);
		pnlNickname.add(lblNickname);
		pnlNickname.add(txtNickname);
		pnlIsDisabled.add(lblIsDisabled);
		pnlIsDisabled.add(txtIsDisabled);
		pnlBtnOpearator.add(btnUpdate);
		pnlBtnOpearator.add(btnSave);
		pnlBtnOpearator.add(btnResetPass);
		pnlBtnOpearator.add(btnCancel);
	
		container.add(pnlID);
		container.add(pnlLoginName);
		container.add(pnlNickname);
		container.add(pnlIsDisabled);
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
		btnCancel.addActionListener(e->{
			btnCancelOnClickListener(e);
		});
		btnResetPass.addActionListener(e->{
			btnResetPassOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 修改按钮点击事件监听器</p>
	 * <p>Title: btnUpdateOnClickListener</p>
	 * @param e
	 */
	private void btnUpdateOnClickListener(ActionEvent e) {
		txtNickname.setEditable(true);
		btnUpdate.setVisible(false);
		btnCancel.setVisible(true);
		btnSave.setVisible(true);
		btnResetPass.setVisible(true);
	}

	/**
	 * <p>Description: 保存按钮点击事件监听器</p>
	 * <p>Title: btnSaveOnClickListener</p>
	 * @param e
	 */
	private void btnSaveOnClickListener(ActionEvent e) {
		String nickname = txtNickname.getText().trim().toString();
		if (nickname == null || nickname.isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入不能为空！");
			return;
		} else {
			bean.setNickname(nickname);
			if (teacherService.update(bean) > 0) {
				JOptionPane.showMessageDialog(null, "保存成功！");
				teacherManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "保存失败！");
				return;
			}
		}
		refresh();
		txtNickname.setEditable(false);
		btnUpdate.setVisible(true);
		btnCancel.setVisible(false);
		btnSave.setVisible(false);
		btnResetPass.setVisible(false);
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
			txtNickname.setEditable(false);
			btnUpdate.setVisible(true);
			btnCancel.setVisible(false);
			btnSave.setVisible(false);
			btnResetPass.setVisible(false);
		}
		
	}

	/**
	 * <p>Description: 重置密码点击事件监听器</p>
	 * <p>Title: btnResetPassOnClickListener</p>
	 * @param e
	 */
	private void btnResetPassOnClickListener(ActionEvent e) {
		int option = JOptionPane.showConfirmDialog(this, "是否重置密码？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			// 修改密码
			bean.setLoginPass("123456");
			if (teacherService.update(bean) > 0) {
				JOptionPane.showMessageDialog(null, "重置成功！");
			} else {
				JOptionPane.showMessageDialog(null, "重置失败！");
			}
		}
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
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtID.setText(bean.getTeacherID()+"");
		txtLoginName.setText(bean.getLoginName());
		txtNickname.setText(bean.getNickname());
		txtIsDisabled.setText(isDisabled(bean.getIsDisabled()));
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
	 * <p>Description: 是否禁用字符串</p>
	 * <p>Title: isDisabled</p>
	 * @param isDisabled
	 * @return
	 */
	private String isDisabled(Integer isDisabled) {
		return isDisabled==0?"否":"是";
	}

}
