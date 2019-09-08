package edu.prj.ui.crud.subject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.manager.*;
import edu.util.Data;

@SuppressWarnings("serial")
public class SubjectUpdateFrm extends JFrame{
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
	private Dimension btnDimension = new Dimension(120, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 当前修改对象 */
	private SubjectBean bean = null;
	/** 科目管理面板 */
	public SubjectManagePnl subjectManagePnl = null;
	
	public SubjectUpdateFrm(SubjectBean bean) {
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
		pnlSubjectName = new JPanel();
		pnlTeacherName = new JPanel();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("科目信息");
		lblSubjectName = new JLabel("科目：");
		lblTeacherName = new JLabel("教师：");
		txtSubjectName = new JTextField();
		btnUpdate = new JButton("修改");
		btnSave = new JButton("保存");
		btnCancel = new JButton("取消");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("科目信息");
		
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
		configureLblTitle();
		configurePnlSubjectName();
		configurePnlTeacherName();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblSubjectName();
		configureLblTeacherName();
		configureTxtSubjectName();
		configureCboTeacher();
		configureBtnUpdate();
		configureBtnSave();
		configureBtnCancel();
		
		refresh();
	}
	
	/**
	 * <p>Description: 配置科目文本框</p>
	 * <p>Title: configureTextSubjectName</p>
	 */
	private void configureTxtSubjectName() {
		txtSubjectName.setFont(font);
		txtSubjectName.setPreferredSize(txtDimension);
		txtSubjectName.setEditable(false);
	}

	/**
	 * <p>Description: 配置科目信息面板</p>
	 * <p>Title: configurePnlSubjectName</p>
	 */
	private void configurePnlSubjectName() {
		pnlSubjectName.setFont(font);
		pnlSubjectName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置教师信息面板</p>
	 * <p>Title: configurePnlTeacherName</p>
	 */
	private void configurePnlTeacherName() {
		pnlTeacherName.setFont(font);
		pnlTeacherName.setPreferredSize(pnlDimension);
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
	 * <p>Title: configureLblTeacherName</p>
	 */
	private void configureLblTeacherName() {
		lblTeacherName.setFont(font);
		lblTeacherName.setPreferredSize(lblDimension);
	}
	
	/**
	 * <p>Description: 配置教师下拉框</p>
	 * <p>Title: configureCboTeacher</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configureCboTeacher() {
		cboTeacher = new JComboBox(Data.teachers);
		cboTeacher.setPreferredSize(txtDimension);
		cboTeacher.setFont(font);
		cboTeacher.setEnabled(false);
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
		container.add(lblTitle);
		pnlSubjectName.add(lblSubjectName);
		pnlSubjectName.add(txtSubjectName);
		pnlTeacherName.add(lblTeacherName);
		pnlTeacherName.add(cboTeacher);
		pnlBtnOpearator.add(btnUpdate);
		pnlBtnOpearator.add(btnSave);
		pnlBtnOpearator.add(btnCancel);
		
		container.add(pnlTeacherName);
		container.add(pnlSubjectName);
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
	}

	/**
	 * <p>Description: 修改按钮点击事件监听器</p>
	 * <p>Title: btnUpdateOnClickListener</p>
	 * @param e
	 */
	private void btnUpdateOnClickListener(ActionEvent e) {
		txtSubjectName.setEditable(true);
		cboTeacher.setEnabled(true);
		btnUpdate.setVisible(false);
		btnCancel.setVisible(true);
		btnSave.setVisible(true);
	}

	/**
	 * <p>Description: 保存按钮点击事件监听器</p>
	 * <p>Title: btnSaveOnClickListener</p>
	 * @param e
	 */
	private void btnSaveOnClickListener(ActionEvent e) {
		SubjectService subjectService = new SubjectServiceImpl();
		String subjectName = txtSubjectName.getText().trim();
		Long teacherID = Long.valueOf(cboTeacher.getSelectedIndex());
		if (cboTeacher.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "请选择教师！");
			return;
		} else if (subjectName == null || subjectName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入不能为空！");
			return;
		} else if (subjectName.equals(bean.getSubjectName()) && teacherID == bean.getTeacherID()){
			// 未修改保存，不做处理
			JOptionPane.showMessageDialog(null, "保存成功！");
		} else if (subjectService.loadByDoubleName(subjectName, teacherID) == null){
			bean.setSubjectName(subjectName);
			bean.setTeacherID(teacherID);
			if (subjectService.update(bean) > 0) {
				JOptionPane.showMessageDialog(null, "保存成功！");
				this.subjectManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "保存失败！");
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "已存在该教师的科目！");
			return;
		}
		refresh();
		txtSubjectName.setEditable(false);
		cboTeacher.setEnabled(false);
		btnUpdate.setVisible(true);
		btnCancel.setVisible(false);
		btnSave.setVisible(false);
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
			txtSubjectName.setEditable(false);
			cboTeacher.setEnabled(false);
			btnUpdate.setVisible(true);
			btnCancel.setVisible(false);
			btnSave.setVisible(false);
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
		cboTeacher.setSelectedIndex(Integer.valueOf(bean.getTeacherID()+""));
		txtSubjectName.setText(bean.getSubjectName());
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
