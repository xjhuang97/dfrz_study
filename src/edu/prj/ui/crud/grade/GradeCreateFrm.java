package edu.prj.ui.crud.grade;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.manager.*;

@SuppressWarnings("serial")
public class GradeCreateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 年级名称信息面板 */
	private JPanel pnlGradeName;
	/** 按钮操作面板 */
	private JPanel pnlBtnOpearator;
	/** 年级名称标签 */
	private JLabel lblGradeName;
	/** 年级名称文本框 */
	private JTextField txtGradeName;
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
	public GradeManagePnl gradeManagePnl = null;
	/** 当前管理员对象 */
	private ManagerBean bean;
	
	public GradeCreateFrm(ManagerBean bean) {
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
		pnlGradeName = new JPanel();
		lblTitle = new JLabel("年级添加");
		lblGradeName = new JLabel("年级名称：");
		txtGradeName = new JTextField();
		btnSubmit = new JButton("提交");
		btnReset = new JButton("重置");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("新增年级");
		
		// 设置大小
		setSize(new Dimension(500, 200));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(3, 1));
		
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
		configurePnlGradeName();
		configurePnlBtnOpearator();
		configureLblTitle();
		configureLblGradeName();
		configureTxtGradeName();
		configureBtnSubmit();
		configureBtnReset();
		
		refresh();
	}

	/**
	 * <p>Description: 配置年级名称信息面板</p>
	 * <p>Title: configurePnlGradeName</p>
	 */
	private void configurePnlGradeName() {
		pnlGradeName.setLayout(new FlowLayout());
		pnlGradeName.setPreferredSize(pnlDimension);
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
	 * <p>Description: 配置年级名称标签</p>
	 * <p>Title: configureLblGradeName</p>
	 */
	private void configureLblGradeName() {
		lblGradeName.setFont(font);
		lblGradeName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置年级名称文本框</p>
	 * <p>Title: configureTxtGradeName</p>
	 */
	private void configureTxtGradeName() {
		txtGradeName.setFont(font);
		txtGradeName.setPreferredSize(txtDimension);
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
		pnlGradeName.add(lblGradeName);
		pnlGradeName.add(txtGradeName);
		pnlBtnOpearator.add(btnSubmit);
		pnlBtnOpearator.add(btnReset);
	
		container.add(pnlGradeName);
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
		GradeService gradeService = new GradeServiceImpl();
		String gradeName = txtGradeName.getText().trim();
		if (gradeName == null || gradeName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "输入不能为空！");
			return;
		} else if (gradeService.loadByLoginName(gradeName) == null){
			GradeBean gradeBean = new GradeBean();
			gradeBean.setGradeName(gradeName);
			gradeBean.setCreateBy(bean.getManagerID());
			gradeBean.setUpdateBy(bean.getManagerID());
			if (gradeService.insert(gradeBean) > 0) {
				JOptionPane.showMessageDialog(null, "新增成功！");
				this.gradeManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "新增失败！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "该年级已存在！");
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
		txtGradeName.setText("");
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
