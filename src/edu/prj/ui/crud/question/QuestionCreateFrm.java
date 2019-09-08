package edu.prj.ui.crud.question;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import edu.prj.bean.exam.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.function.teacher.*;
import edu.util.Data;

@SuppressWarnings("serial")
public class QuestionCreateFrm extends JFrame{
	/** 内容面板 */
	private JPanel container;
	/** 问题类型面板 */
	private JPanel pnlQType;
	/** 问题信息面板 */
	private JPanel pnlQuestion;
	/** 选项A信息面板 */
	private JPanel pnlItemA;
	/** 选项B信息面板 */
	private JPanel pnlItemB;
	/** 选项C信息面板 */
	private JPanel pnlItemC;
	/** 选项D信息面板 */
	private JPanel pnlItemD;
	/** 选项E信息面板 */
	private JPanel pnlItemE;
	/** 选项F信息面板 */
	private JPanel pnlItemF;
	/** 答案信息面板 */
	private JPanel pnlAnswer;
	/** 所属科目信息面板 */
	private JPanel pnlSubjectName;
	/** 标签信息面板 */
	private JPanel pnlTag;
	/** 按钮操作面板 */
	private JPanel pnlBtnOpearator;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 问题类型标签 */
	private JLabel lblQType;
	/** 问题标签 */
	private JLabel lblQuestion;
	/** 选项A标签 */
	private JLabel lblItemA;
	/** 选项B标签 */
	private JLabel lblItemB;
	/** 选项C标签 */
	private JLabel lblItemC;
	/** 选项D标签 */
	private JLabel lblItemD;
	/** 选项E标签 */
	private JLabel lblItemE;
	/** 选项F标签 */
	private JLabel lblItemF;
	/** 答案标签 */
	private JLabel lblAnswer;
	/** 所属科目标签 */
	private JLabel lblSubjectName;
	/** 标签标签 */
	private JLabel lblTag;
	/** 题目类型下拉框 */
	private JComboBox<String> cboQType;
	/** 题目文本框 */
	private JTextArea txtQuestion;
	/** 选项A文本框 */
	private JTextField txtItemA;
	/** 选项B文本框 */
	private JTextField txtItemB;
	/** 选项C文本框 */
	private JTextField txtItemC;
	/** 选项D文本框 */
	private JTextField txtItemD;
	/** 选项E文本框 */
	private JTextField txtItemE;
	/** 选项F文本框 */
	private JTextField txtItemF;
	/** 答案文本框 */
	private JTextField txtAnswer;
	/** 所属科目下拉框 */
	private JComboBox<String> cboSubject;
	/** 标签文本框 */
	private JTextField txtTag;
	/** 保存按钮 */
	private JButton btnSave;
	/** 重置按钮 */
	private JButton btnReset;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(100, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(500, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(120, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 当前用户对象 */
	@SuppressWarnings("unused")
	private UserBean bean = null;
	/** 题库管理面板 */
	public QuestionManagePnl questionManagePnl = null;
	/** 题目业务 */
	private QuestionService questionService = new QuestionServiceImpl();
	
	public QuestionCreateFrm(UserBean bean) {
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
		pnlQType = new JPanel();
		pnlQuestion = new JPanel();
		pnlItemA = new JPanel();
		pnlItemB = new JPanel();
		pnlItemC = new JPanel();
		pnlItemD = new JPanel();
		pnlItemE = new JPanel();
		pnlItemF = new JPanel();
		pnlAnswer = new JPanel();
		pnlSubjectName = new JPanel();
		pnlTag = new JPanel();
		lblQType = new JLabel("问题类型：");
		lblQuestion = new JLabel("问题：");
		lblItemA = new JLabel("选项A：");
		lblItemB = new JLabel("选项B：");
		lblItemC = new JLabel("选项C：");
		lblItemD = new JLabel("选项D：");
		lblItemE = new JLabel("选项E：");
		lblItemF = new JLabel("选项F：");
		lblAnswer = new JLabel("答案：");
		lblSubjectName = new JLabel("所属科目：");
		lblTag = new JLabel("标签：");
		txtQuestion = new JTextArea();
		txtItemA = new JTextField();
		txtItemB = new JTextField();
		txtItemC = new JTextField();
		txtItemD = new JTextField();
		txtItemE = new JTextField();
		txtItemF = new JTextField();
		txtAnswer = new JTextField();
		txtTag = new JTextField();
		pnlBtnOpearator = new JPanel();
		lblTitle = new JLabel("题目信息");
		btnReset = new JButton("重置");
		btnSave = new JButton("提交");
	}
	
	/**
	 * <p>Description: 初始化窗口</p>
	 * <p>Title: initFrame</p>
	 */
	private void initFrame() {
		// 设置标题
		setTitle("题目信息");
		
		// 设置大小
		setSize(new Dimension(800, 900));
		
		// 设置内容面板
		setContentPane(container);
		
		// 设置布局
		setLayout(new GridLayout(13, 1));
		
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
		configurePnlQType();
		configurePnlQuestion();
		configurePnlItemA();
		configurePnlItemB();
		configurePnlItemC();
		configurePnlItemD();
		configurePnlItemE();
		configurePnlItemF();
		configurePnlAnswer();
		configurePnlSubjectName();
		configurePnlTag();
		configureLblQType();
		configureLblQuestion();
		configureLblItemA();
		configureLblItemB();
		configureLblItemC();
		configureLblItemD();
		configureLblItemE();
		configureLblItemF();
		configureLblAnswer();
		configureLblSubjectName();
		configureLblTag();
		configureCboQType();
		configureTxtQuestion();
		configureTxtItemA();
		configureTxtItemB();
		configureTxtItemC();
		configureTxtItemD();
		configureTxtItemE();
		configureTxtItemF();
		configureTxtAnswer();
		configureCboSubject();
		configureTxtTag();
		configureLblTitle();
		configurePnlBtnOpearator();
		configureBtnReset();
		configureBtnSave();
		
		refresh();
	}

	/**
	 * <p>Description: 配置题目类型信息面板</p>
	 * <p>Title: configurePnlQType</p>
	 */
	private void configurePnlQType() {
		pnlQType.setLayout(new FlowLayout());
		pnlQType.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目信息面板</p>
	 * <p>Title: configurePnlQuestion</p>
	 */
	private void configurePnlQuestion() {
		pnlQuestion.setLayout(new FlowLayout());
		pnlQuestion.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项A信息面板</p>
	 * <p>Title: configurePnlItemA</p>
	 */
	private void configurePnlItemA() {
		pnlItemA.setLayout(new FlowLayout());
		pnlItemA.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项B信息面板</p>
	 * <p>Title: configurePnlItemB</p>
	 */
	private void configurePnlItemB() {
		pnlItemB.setLayout(new FlowLayout());
		pnlItemB.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项C信息面板</p>
	 * <p>Title: configurePnlItemC</p>
	 */
	private void configurePnlItemC() {
		pnlItemC.setLayout(new FlowLayout());
		pnlItemC.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项D信息面板</p>
	 * <p>Title: configurePnlItemD</p>
	 */
	private void configurePnlItemD() {
		pnlItemD.setLayout(new FlowLayout());
		pnlItemD.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项E信息面板</p>
	 * <p>Title: configurePnlItemE</p>
	 */
	private void configurePnlItemE() {
		pnlItemE.setLayout(new FlowLayout());
		pnlItemE.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置选项F信息面板</p>
	 * <p>Title: configurePnlItemF</p>
	 */
	private void configurePnlItemF() {
		pnlItemF.setLayout(new FlowLayout());
		pnlItemF.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置答案信息面板</p>
	 * <p>Title: configurePnlAnswer</p>
	 */
	private void configurePnlAnswer() {
		pnlAnswer.setLayout(new FlowLayout());
		pnlAnswer.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置所属科目信息面板</p>
	 * <p>Title: configurePnlSubjectName</p>
	 */
	private void configurePnlSubjectName() {
		pnlSubjectName.setLayout(new FlowLayout());
		pnlSubjectName.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置标签信息面板</p>
	 * <p>Title: configurePnlTag</p>
	 */
	private void configurePnlTag() {
		pnlTag.setLayout(new FlowLayout());
		pnlTag.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置题目类型标签</p>
	 * <p>Title: configureLblQType</p>
	 */
	private void configureLblQType() {
		lblQType.setFont(font);
		lblQType.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目标签</p>
	 * <p>Title: configureLblQuestion</p>
	 */
	private void configureLblQuestion() {
		lblQuestion.setFont(font);
		lblQuestion.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项A标签</p>
	 * <p>Title: configureLblItemA</p>
	 */
	private void configureLblItemA() {
		lblItemA.setFont(font);
		lblItemA.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项B标签</p>
	 * <p>Title: configureLblItemB</p>
	 */
	private void configureLblItemB() {
		lblItemB.setFont(font);
		lblItemB.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项C标签</p>
	 * <p>Title: configureLblItemC</p>
	 */
	private void configureLblItemC() {
		lblItemC.setFont(font);
		lblItemC.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项D标签</p>
	 * <p>Title: configureLblItemD</p>
	 */
	private void configureLblItemD() {
		lblItemD.setFont(font);
		lblItemD.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项E标签</p>
	 * <p>Title: configureLblItemE</p>
	 */
	private void configureLblItemE() {
		lblItemE.setFont(font);
		lblItemE.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置选项F标签</p>
	 * <p>Title: configureLblItemF</p>
	 */
	private void configureLblItemF() {
		lblItemF.setFont(font);
		lblItemF.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置答案标签</p>
	 * <p>Title: configureLblAnswer</p>
	 */
	private void configureLblAnswer() {
		lblAnswer.setFont(font);
		lblAnswer.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置所属科目标签</p>
	 * <p>Title: configureLblSubjectName</p>
	 */
	private void configureLblSubjectName() {
		lblSubjectName.setFont(font);
		lblSubjectName.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置标签标签</p>
	 * <p>Title: configureLblTag</p>
	 */
	private void configureLblTag() {
		lblTag.setFont(font);
		lblTag.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置题目类型下拉框</p>
	 * <p>Title: configureCboQType</p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void configureCboQType() {
		cboQType = new JComboBox(Data.types);
		cboQType.setPreferredSize(txtDimension);
		cboQType.setFont(font);
	}

	/**
	 * <p>Description: 配置题目文本框</p>
	 * <p>Title: configureTxtQuestion</p>
	 */
	private void configureTxtQuestion() {
		// 设置多行文本框自动换行
		txtQuestion.setLineWrap(true);	
		// 设置断行不断字
		txtQuestion.setWrapStyleWord(true);
		txtQuestion.setPreferredSize(new Dimension(500, 50));
		txtQuestion.setFont(font);
	}

	/**
	 * <p>Description: 配置选项A文本框</p>
	 * <p>Title: configureTxtItemA</p>
	 */
	private void configureTxtItemA() {
		txtItemA.setFont(font);
		txtItemA.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置选项B文本框</p>
	 * <p>Title: configureTxtItemB</p>
	 */
	private void configureTxtItemB() {
		txtItemB.setFont(font);
		txtItemB.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置选项C文本框</p>
	 * <p>Title: configureTxtItemC</p>
	 */
	private void configureTxtItemC() {
		txtItemC.setFont(font);
		txtItemC.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置选项D文本框</p>
	 * <p>Title: configureTxtItemD</p>
	 */
	private void configureTxtItemD() {
		txtItemD.setFont(font);
		txtItemD.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置选项E文本框</p>
	 * <p>Title: configureTxtItemE</p>
	 */
	private void configureTxtItemE() {
		txtItemE.setFont(font);
		txtItemE.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置选项F文本框</p>
	 * <p>Title: configureTxtItemF</p>
	 */
	private void configureTxtItemF() {
		txtItemF.setFont(font);
		txtItemF.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置答案文本框</p>
	 * <p>Title: configureTxtAnswer</p>
	 */
	private void configureTxtAnswer() {
		txtAnswer.setFont(font);
		txtAnswer.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置所属科目下拉框</p>
	 * <p>Title: configureCboSubject</p>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void configureCboSubject() {
		cboSubject = new JComboBox(Data.subjects);
		cboSubject.setPreferredSize(txtDimension);
		cboSubject.setFont(font);
	}

	/**
	 * <p>Description: 配置标签文本框</p>
	 * <p>Title: configureTxtTag</p>
	 */
	private void configureTxtTag() {
		txtTag.setFont(font);
		txtTag.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置按钮操作面板</p>
	 * <p>Title: configurePnlBtnOpearator</p>
	 */
	private void configurePnlBtnOpearator() {
		pnlBtnOpearator.setFont(font);
		pnlBtnOpearator.setPreferredSize(pnlDimension);
	}

	/**
	 * <p>Description: 配置保存按钮</p>
	 * <p>Title: configureBtnSave</p>
	 */
	private void configureBtnSave() {
		btnSave.setFont(font);
		btnSave.setPreferredSize(btnDimension);
		btnSave.setFocusable(false);
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
		pnlQType.add(lblQType);
		pnlQType.add(cboQType);
		pnlQuestion.add(lblQuestion);
		pnlQuestion.add(txtQuestion);
		pnlItemA.add(lblItemA);
		pnlItemA.add(txtItemA);
		pnlItemB.add(lblItemB);
		pnlItemB.add(txtItemB);
		pnlItemC.add(lblItemC);
		pnlItemC.add(txtItemC);
		pnlItemD.add(lblItemD);
		pnlItemD.add(txtItemD);
		pnlItemE.add(lblItemE);
		pnlItemE.add(txtItemE);
		pnlItemF.add(lblItemF);
		pnlItemF.add(txtItemF);
		pnlAnswer.add(lblAnswer);
		pnlAnswer.add(txtAnswer);
		pnlSubjectName.add(lblSubjectName);
		pnlSubjectName.add(cboSubject);
		pnlTag.add(lblTag);
		pnlTag.add(txtTag);
		pnlBtnOpearator.add(btnSave);
		pnlBtnOpearator.add(btnReset);
		container.add(pnlQType);
		container.add(pnlQuestion);
		container.add(pnlItemA);
		container.add(pnlItemB);
		container.add(pnlItemC);
		container.add(pnlItemD);
		container.add(pnlItemE);
		container.add(pnlItemF);
		container.add(pnlAnswer);
		container.add(pnlSubjectName);
		container.add(pnlTag);
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
		btnSave.addActionListener(e->{
			btnSaveOnClickListener(e);
		});
		btnReset.addActionListener(e->{
			btnResetOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 保存按钮点击事件监听器</p>
	 * <p>Title: btnSaveOnClickListener</p>
	 * @param e
	 */
	private void btnSaveOnClickListener(ActionEvent e) {
		String question = txtQuestion.getText().trim();
		String itemA = txtItemA.getText().trim();
		String itemB = txtItemB.getText().trim();
		String itemC = txtItemC.getText().trim();
		String itemD = txtItemD.getText().trim();
		String itemE = txtItemE.getText().trim();
		String itemF = txtItemF.getText().trim();
		String answer = txtAnswer.getText().trim();
		String tag = txtTag.getText().trim();
		if (question == null || question.isEmpty()) {
			JOptionPane.showMessageDialog(null, "问题不能为空！");
			return;
		} else if (itemA == null || itemA.isEmpty()) {
			JOptionPane.showMessageDialog(null, "选项A不能为空！");
			return;
		} else if (itemB == null || itemB.isEmpty()) {
			JOptionPane.showMessageDialog(null, "选项B不能为空！");
			return;
		} else if (answer == null || answer.isEmpty()) {
			JOptionPane.showMessageDialog(null, "答案不能为空！");
			return;
		} else if (cboQType.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "请选择题目类型！");
			return;
		} else if (cboSubject.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(null, "请选择科目！");
			return;
		} else {
			QuestionBean questionBean = new QuestionBean();
			questionBean.setQType(cboQType.getSelectedIndex());
			questionBean.setQuestion(question);
			questionBean.setItemA(itemA);
			questionBean.setItemB(itemB);
			questionBean.setItemC(itemC);
			questionBean.setItemD(itemD);
			questionBean.setItemE(itemE);
			questionBean.setItemF(itemF);
			questionBean.setAnswer(answer);
			questionBean.setSubjectID(Long.valueOf(cboSubject.getSelectedIndex()));
			questionBean.setTag(tag);
			if (questionService.insert(questionBean) > 0) {
				JOptionPane.showMessageDialog(null, "提交成功！");
				questionManagePnl.refreshData();
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "提交失败！");
				return;
			}
		}
		refresh();
	}

	/**
	 * <p>Description: 重置点击事件监听器</p>
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
		txtQuestion.setText("");
		cboQType.setSelectedIndex(0);
		txtItemA.setText("");
		txtItemB.setText("");
		txtItemC.setText("");
		txtItemD.setText("");
		txtItemE.setText("");
		txtItemF.setText("");
		txtAnswer.setText("");
		cboSubject.setSelectedIndex(0);
		txtTag.setText("");
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
