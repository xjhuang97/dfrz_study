package edu.prj.ui.function.manager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;

@SuppressWarnings("serial")
public class ManagerInfoPnl extends JPanel{
	/** 标题标签 */
	private JLabel lblTitle;
	/** ID信息面板 */
	private JPanel pnlID;
	/** 账号信息面板 */
	private JPanel pnlLoginName;
	/** 密码信息面板 */
	private JPanel pnlLoginPass;
	/** 新密码信息面板 */
	private JPanel pnlNewPass;
	/** 确认密码信息面板 */
	private JPanel pnlConfirmPass;
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
	/** 密码标签 */
	private JLabel lblLoginPass;
	/** 新密码标签 */
	private JLabel lblNewPass;
	/** 确认密码标签 */
	private JLabel lblConfirmPass;
	/** 昵称标签 */
	private JLabel lblNickname;
	/** 是否禁用 */
	private JLabel lblIsDisabled;
	/** ID文本框 */
	private JTextField txtID;
	/** 账号文本框 */
	private JTextField txtLoginName;
	/** 密码文本框 */
	private JPasswordField txtLoginPass;
	/** 新密码文本框 */
	private JPasswordField txtNewPass;
	/** 确认密码文本框 */
	private JPasswordField txtConfirmPass;
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
	/** 当前管理员对象 */
	public ManagerBean bean = null;
	/** 管理员业务 */
	private ManagerService managerService = new ManagerServiceImpl();

	public ManagerInfoPnl(ManagerBean bean) {
		this.bean = bean;
		initUI();
		initPanel();
		configureCompents();
		installCompents();
		installListener();
	}

	/**
	 * <p>Description: 初始化组件</p>
	 * <p>Title: initUI</p>
	 */
	private void initUI() {
		lblTitle = new JLabel("个人信息");
		pnlID = new JPanel();
		pnlLoginName = new JPanel();
		pnlLoginPass = new JPanel();
		pnlNickname = new JPanel();
		pnlIsDisabled = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblID = new JLabel("ID：");
		lblLoginName = new JLabel("账号：");
		lblLoginPass = new JLabel("原密码：");
		lblNickname = new JLabel("昵称：");
		lblIsDisabled = new JLabel("是否禁用：");
		txtID = new JTextField();
		txtLoginName = new JTextField();
		txtLoginPass = new JPasswordField();
		txtNickname = new JTextField();
		txtIsDisabled = new JTextField();
		btnUpdate = new JButton("修改");
		btnSave = new JButton("保存");
		btnCancel = new JButton("取消");
		
		pnlNewPass = new JPanel();
		lblNewPass = new JLabel("新密码：");
		txtNewPass = new JPasswordField();
		
		pnlConfirmPass = new JPanel();
		lblConfirmPass = new JLabel("确认密码：");
		txtConfirmPass = new JPasswordField();
	}

	/**
	 * <p>Description: 初始化面板</p>
	 * <p>Title: initPanel</p>
	 */
	private void initPanel() {
		// 设置布局
		setLayout(new GridLayout(9, 1));
	}

	/**
	 * <p>Description: 配置组件</p>
	 * <p>Title: configureCompents</p>
	 */
	private void configureCompents() {
		configurePnlID();
		configurePnlLoginName();
		configurePnlLoginPass();
		configurePnlNickname();
		configurePnlIsDisabled();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblID();
		configureLblLoginName();
		configureLblLoginPass();
		configureLblNickname();
		configureLblIsDisabled();
		configureTxtID();
		configureTxtLoginName();
		configureTxtLoginPass();
		configureTxtNickname();
		configureTxtIsDisabled();
		configureBtnUpdate();
		configureBtnSave();
		configureBtnCancel();
		
		configurePnlNewPass();
		configureLblNewPass();
		configureTxtNewPass();
		
		configurePnlConfirmPass();
		configureLblConfirmPass();
		configureTxtConfirmPass();
		
		refresh();
	}

	/**
	 * <p>Description: 配置新密码信息面板</p>
	 * <p>Title: configurePnlNewPass</p>
	 */
	private void configurePnlNewPass() {
		pnlNewPass.setLayout(new FlowLayout());
		pnlNewPass.setPreferredSize(pnlDimension);
		pnlNewPass.setVisible(true);
	}

	/**
	 * <p>Description: 配置新密码标签</p>
	 * <p>Title: configureLblNewPass</p>
	 */
	private void configureLblNewPass() {
		lblNewPass.setFont(font);
		lblNewPass.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置新密码文本框</p>
	 * <p>Title: configureTxtNewPass</p>
	 */
	private void configureTxtNewPass() {
		txtNewPass.setFont(font);
		txtNewPass.setPreferredSize(txtDimension);
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
	 * <p>Description: 配置密码文本框</p>
	 * <p>Title: configureTxtLoginPass</p>
	 */
	private void configureTxtLoginPass() {
		txtLoginPass.setFont(font);
		txtLoginPass.setPreferredSize(txtDimension);
		txtLoginPass.setEditable(false);
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
		add(lblTitle);
		
		pnlID.add(lblID);
		pnlID.add(txtID);
		pnlLoginName.add(lblLoginName);
		pnlLoginName.add(txtLoginName);
		pnlLoginPass.add(lblLoginPass);
		pnlLoginPass.add(txtLoginPass);
		pnlNickname.add(lblNickname);
		pnlNickname.add(txtNickname);
		pnlIsDisabled.add(lblIsDisabled);
		pnlIsDisabled.add(txtIsDisabled);
		pnlBtnOpearator.add(btnUpdate);
		pnlBtnOpearator.add(btnSave);
		pnlBtnOpearator.add(btnCancel);
		
		pnlNewPass.add(lblNewPass);
		pnlNewPass.add(txtNewPass);
		
		pnlConfirmPass.add(lblConfirmPass);
		pnlConfirmPass.add(txtConfirmPass);
		
		add(pnlID);
		add(pnlLoginName);
		add(pnlLoginPass);
		add(pnlNickname);
		add(pnlIsDisabled);
		add(pnlBtnOpearator);
	}

	/**
	 * <p>Description: 安装事件监听器</p>
	 * <p>Title: installListener</p>
	 */
	private void installListener() {
		btnUpdate.addActionListener(e->{
			btnUpdateOnClickListener(e);
		});
		btnSave.addActionListener(e->{
			btnSaveOnClickListener(e);
		});
		btnCancel.addActionListener(e->{
			btnCancelOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 修改按钮点击事件监听器</p>
	 * <p>Title: btnUpdateOnClickListener</p>
	 * @param e
	 */
	private void btnUpdateOnClickListener(ActionEvent e) {
		txtLoginPass.setText("");
		add(pnlNewPass, 4);
		add(pnlConfirmPass, 5);
		txtLoginPass.setEditable(true);
		txtNickname.setEditable(true);
		btnUpdate.setVisible(false);
		btnCancel.setVisible(true);
		btnSave.setVisible(true);
	}

	/**
	 * <p>Description: 保存按钮点击事件监听器</p>
	 * <p>Title: btnSaveOnClickListener</p>
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	private void btnSaveOnClickListener(ActionEvent e) {
		// 原密码
		String loginPass = txtLoginPass.getText().trim();
		// 新密码
		String newPass = txtNewPass.getText().trim();
		// 确认密码
		String confirmPass = txtConfirmPass.getText().trim();
		
		if (!loginPass.equals(bean.getLoginPass())) { // 原密码验证
			JOptionPane.showMessageDialog(null, "原密码输入不正确！");
			return;
		} else if (newPass.equals(confirmPass)) { // 两次密码验证
			String nickname = txtNickname.getText().trim();
			bean.setLoginPass(newPass);
			bean.setNickname(nickname);
			managerService.update(bean);
			JOptionPane.showMessageDialog(null, "保存成功！");
			remove(pnlNewPass);
			remove(pnlConfirmPass);
			refresh();
			txtLoginPass.setEditable(false);
			txtNickname.setEditable(false);
			btnUpdate.setVisible(true);
			btnCancel.setVisible(false);
			btnSave.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "两次密码输入不相同！");
		}
	}
	
	/**
	 * <p>Description: 取消按钮事件监听器</p>
	 * <p>Title: btnCancelOnClickListener</p>
	 * @param e
	 */
	private void btnCancelOnClickListener(ActionEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否取消修改？", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			remove(pnlNewPass);
			remove(pnlConfirmPass);
			refresh();
			txtLoginPass.setEditable(false);
			txtNickname.setEditable(false);
			btnUpdate.setVisible(true);
			btnCancel.setVisible(false);
			btnSave.setVisible(false);
		}
	}

	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtID.setText(bean.getManagerID()+"");
		txtLoginName.setText(bean.getLoginName());
		txtLoginPass.setText(bean.getLoginPass());
		txtNickname.setText(bean.getNickname());
		txtConfirmPass.setText("");
		txtIsDisabled.setText(isDisabled(bean.getIsDisabled()));
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
