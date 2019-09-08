package edu.prj.ui.crud.manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.user.*;

@SuppressWarnings("serial")
public class ManagerShowInfoFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 图片面板 */
	private JPanel pnlPicture;
	/** 图片 */
	private JLabel lblPicture;
	/** 信息面板 */
	private JPanel pnlInfo;
	/** 标题标签 */
	private JLabel lblTitle;
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
	/** 更换图片按钮 */
	private JButton btnUpdatePic;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(100, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(200, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(130, 40);
	/** 当前管理员对象 */
	private ManagerBean bean = null;
	
	public ManagerShowInfoFrm(ManagerBean bean) {
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
		pnlPicture = new JPanel();
		lblPicture = new JLabel();
		pnlInfo = new JPanel();
		lblTitle = new JLabel("基本信息");
		lblID = new JLabel("ID：");
		lblLoginName = new JLabel("账号：");
		lblNickname = new JLabel("昵称：");
		lblIsDisabled = new JLabel("是否禁用：");
		txtID = new JTextField();
		txtLoginName = new JTextField();
		txtNickname = new JTextField();
		txtIsDisabled = new JTextField();
		btnUpdatePic = new JButton("修改图片");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("用户信息");
		
		// 设置大小
		setSize(new Dimension(650, 400));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
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
		configureLblTitle();
		configurePnlPicture();
		configureLblPicture();
		configurePnlInfo();
		configureLblID();
		configureLblLoginName();
		configureLblNickname();
		configureLblIsDisabled();
		configureTxtID();
		configureTxtLoginName();
		configureTxtNickname();
		configureTxtIsDisabled();
		configureBtnUpdatePic();
		
		refresh();
	}

	/**
	 * <p>Description: 配置图片标签</p>
	 * <p>Title: configureLblPicture</p>
	 */
	private void configureLblPicture() {
		int width = 220;
		int height = 300;
		lblPicture.setFont(font);
		lblPicture.setPreferredSize(new Dimension(width, height));
		String path = "picture/manager/admin2.jpg";
		ImageIcon icon = new ImageIcon(path); 
		icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
		lblPicture.setIcon(icon);
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER); 
	}

	/**
	 * <p>Description: 配置标题标签</p>
	 * <p>Title: configureLblTitle</p>
	 */
	private void configureLblTitle() {
		lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 23));
		lblTitle.setPreferredSize(new Dimension(400, 40));
		// 设置标签居中
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * <p>Description: 配置图片面板</p>
	 * <p>Title: configurePnlPicture</p>
	 */
	private void configurePnlPicture() {
		pnlPicture.setPreferredSize(new Dimension(220, this.getHeight()));
		pnlPicture.setLayout(new FlowLayout());
	}

	/**
	 * <p>Description: 配置信息面板</p>
	 * <p>Title: configurePnlInfo</p>
	 */
	private void configurePnlInfo() {
		pnlInfo.setPreferredSize(new Dimension(400, this.getHeight()));
		pnlInfo.setLayout(new FlowLayout());
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
	 * <p>Description: 配置修改图片按钮</p>
	 * <p>Title: configureBtnUpdatePic</p>
	 */
	private void configureBtnUpdatePic() {
		btnUpdatePic.setFont(font);
		btnUpdatePic.setPreferredSize(btnDimension);
		btnUpdatePic.setFocusable(false);
	}

	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		pnlPicture.add(lblPicture);
		pnlPicture.add(btnUpdatePic);
		
		pnlInfo.add(lblTitle);
		pnlInfo.add(lblID);
		pnlInfo.add(txtID);
		pnlInfo.add(lblLoginName);
		pnlInfo.add(txtLoginName);
		pnlInfo.add(lblNickname);
		pnlInfo.add(txtNickname);
		pnlInfo.add(lblIsDisabled);
		pnlInfo.add(txtIsDisabled);
		
		container.add(pnlPicture, BorderLayout.WEST);
		container.add(pnlInfo, BorderLayout.EAST);
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
		btnUpdatePic.addActionListener(e->{
			btnUpdatePicOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 窗口点击关闭事件监听器</p>
	 * <p>Title: windowCloseOnClickListener</p>
	 * @param e
	 */
	private void windowCloseOnClickListener(WindowEvent e) {
		// 这里是编写窗体关闭时的代码
		int option = JOptionPane.showConfirmDialog(this, "是否关闭", "系统提示", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
	
	/**
	 * <p>Description: 修改图片按钮点击事件监听器</p>
	 * <p>Title: btnUpdatePicOnClickListener</p>
	 * @param e
	 */
	private void btnUpdatePicOnClickListener(ActionEvent e) {
		// 打开文件对话框，获得图片路径
		String[] name = openFileDialog("发送图片");
		// 如果有选择文件，就显示到输入框中
		if (name != null) {
			String picturePath = name[0].toString() + name[1].toString();
			int width = 220;
			int height = 300;
			ImageIcon icon = new ImageIcon(picturePath); 
			icon.setImage(icon.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT ));
			lblPicture.setIcon(icon);
		}
	}
	
	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtID.setText(bean.getManagerID()+"");
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
	
	/**
	 * 	打开文件对话框，返回一个路径
	 */
	public String[] openFileDialog(String title) {
		String[] name = new String[2];
		// 创建文件对话框
		FileDialog openFile = new FileDialog(this, title, FileDialog.LOAD);
		// 设为可见
		openFile.setVisible(true);
		// 设置相对位置居中
		openFile.setLocationRelativeTo(null);
		// 获得路径前缀(不包含文件名)
		String dirName = openFile.getDirectory();
		// 获得文件名
		String fileName = openFile.getFile();
		// 获得文件的绝对路径
//		String path = dirName + fileName;
		name[0] = dirName;
		name[1] = fileName;
		// 判断是否为空
		if(name[0] != null && name[1] != null) { 
			return name;
		}else {
			return null;
		}
	}
}
