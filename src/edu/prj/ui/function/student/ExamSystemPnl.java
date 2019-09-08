package edu.prj.ui.function.student;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;

import java.util.Date;
import java.util.List;
import com.liuvei.common.win.ATableModel;

import edu.prj.bean.exam.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;

@SuppressWarnings("serial")
public class ExamSystemPnl extends JPanel{
	/** 标题面板 */
	private JPanel pnlTitle;
	/** 标题标签 */
	private JLabel lblTitle;
	/** 查询操作面板 */
	private JPanel pnlOpearator;
	/** 表格 */
	private JTable tblObj;
	/** 表格右键菜单 */
	private JPopupMenu tblObjMenu;
	/** 查询标签 */
	private JLabel lblSearch;
	/** 查询文本框 */
	private JTextField txtSearch;
	/** 查询按钮 */
	private JButton btnSearch;
	/** 重置按钮 */
	private JButton btnReset;
	// 下拉排序  按ID、昵称、
	private JComboBox<String> cboSort;
	/** 默认字体 */
	private Font font = new Font("微软雅黑", Font.BOLD, 17);
	/** 标签尺寸 */
	private Dimension lblDimension = new Dimension(60, 40);
	/** 文本框尺寸 */
	private Dimension txtDimension = new Dimension(200, 40);
	/** 按钮尺寸 */
	private Dimension btnDimension = new Dimension(100, 40);
	/** 面板尺寸 */
	private Dimension pnlDimension = new Dimension(this.getWidth(), 60);
	/** 当前用户对象 */
	public UserBean bean = null;
	/** 按ID升序 */
	private static final String SORT_ASC_BY_ID = "按ID升序";
	/** 按ID降序 */
	private static final String SORT_DESC_BY_ID = "按ID降序";
	/** 按昵称升序 */
	private static final String SORT_ASC_BY_PAPER_NAME = "按名称升序";
	/** 按昵称降序 */
	private static final String SORT_DESC_BY_PAPER_NAME = "按名称降序";
	/** 按科目升序 */
	private static final String SORT_ASC_BY_SUBJECT_NAME = "按科目升序";
	/** 按科目降序 */
	private static final String SORT_DESC_BY_SUBJECT_NAME = "按科目降序";

	public ExamSystemPnl(StudentBean bean) {
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
		pnlTitle = new JPanel();
		lblTitle = new JLabel("考试系统");
		pnlOpearator = new JPanel();
		lblSearch = new JLabel("查询：");
		txtSearch = new JTextField();
		btnSearch = new JButton("查询");
		btnReset = new JButton("重置");
		tblObj = new JTable();
		tblObjMenu = new JPopupMenu();
	}

	/**
	 * <p>Description: 初始化面板</p>
	 * <p>Title: initPanel</p>
	 */
	private void initPanel() {
		// 设置布局
		setLayout(new BorderLayout());
	}

	/**
	 * <p>Description: 配置组件</p>
	 * <p>Title: configureCompents</p>
	 */
	private void configureCompents() {
		configurePnlTitle();
		configureLblTitle();
		configurePnlOpearator();
		configureLblSearch();
		configureTxtSearch();
		configureBtnSearch();
		configureBtnReset();
		configureCboSort();
		configureTblObj();
		configureTblObjMenu();
	}

	/**
	 * <p>Description: 配置标题面板</p>
	 * <p>Title: configurePnlTitle</p>
	 */
	private void configurePnlTitle() {
		pnlTitle.setLayout(new FlowLayout());
		pnlTitle.setPreferredSize(pnlDimension);	
	}

	/**
	 * <p>Description: 配置标题标签</p>
	 * <p>Title: configureLblTitle</p>
	 */
	private void configureLblTitle() {
		lblTitle.setFont(new Font("微软雅黑", Font.BOLD, 27));
		lblTitle.setPreferredSize(new Dimension(this.getWidth(), 40));
		// 设置标签居中
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * <p>Description: 配置查询操作面板</p>
	 * <p>Title: configurePnlOpearator</p>
	 */
	private void configurePnlOpearator() {
		pnlOpearator.setLayout(new FlowLayout());
		pnlOpearator.setPreferredSize(pnlDimension);		
	}

	/**
	 * <p>Description: 配置查询标签</p>
	 * <p>Title: configureLblSearch</p>
	 */
	private void configureLblSearch() {
		lblSearch.setFont(font);
		lblSearch.setPreferredSize(lblDimension);
	}

	/**
	 * <p>Description: 配置查询文本框</p>
	 * <p>Title: configureTxtSearch</p>
	 */
	private void configureTxtSearch() {
		txtSearch.setFont(font);
		txtSearch.setPreferredSize(txtDimension);
	}

	/**
	 * <p>Description: 配置查询按钮</p>
	 * <p>Title: configureBtnSearch</p>
	 */
	private void configureBtnSearch() {
		btnSearch.setFont(font);
		btnSearch.setPreferredSize(btnDimension);
		btnSearch.setFocusable(false);
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
	 * <p>Description: 配置排序下拉框</p>
	 * <p>Title: configureCboSort</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configureCboSort() {
		String[] sorts = {"按ID升序", "按ID降序", "按名称升序", "按名称降序", "按科目升序", "按科目降序"};
		cboSort = new JComboBox(sorts);
		cboSort.setPreferredSize(new Dimension(120, 40));
		cboSort.setFont(font);
	}
	
	/**
	 * <p>Description: 配置表格</p>
	 * <p>Title: configureTblObj</p>
	 */
	private void configureTblObj() {
		// 设置表头宽高、字体大小
		tblObj.getTableHeader().setPreferredSize(new Dimension(tblObj.getTableHeader().getWidth(), 35));
		tblObj.getTableHeader().setFont(font);
		// 设置行字体、行高
		tblObj.setFont(font);
		tblObj.setRowHeight(30);
		showListData();
	}
	
	/**
	 * <p>Description: 配置表格右键菜单</p>
	 * <p>Title: configureTblObjMenu</p>
	 */
	private void configureTblObjMenu() {		
		JMenuItem menuItemExam = new JMenuItem("开始考试");
		menuItemExam.setFont(font);
		tblObjMenu.add(menuItemExam);
		menuItemExam.addActionListener(e->{
			menuItemExamOnClickListener(e);
		});
		
		tblObj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 判定点击的是鼠标右键
				if (e.getButton() == MouseEvent.BUTTON3) {
					// 获取鼠标所在位置对应的表格行号
					int focusedRowIndex = tblObj.rowAtPoint(e.getPoint());
					// 如果行号为-1，则说明鼠标位置在行数据
					if (focusedRowIndex == -1) {
						return;
					}
					// 如果鼠标位置在数据行上，则选中该行
					tblObj.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
					// 调用相关方法，显示右键菜单
					tblObjMenu.show(tblObj, e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * <p>Description: 表格右键菜单开始考试选项事件监听器</p>
	 * <p>Title: menuItemExamOnClickListener</p>
	 * @param e
	 */
	private void menuItemExamOnClickListener(ActionEvent e) {
		int index = tblObj.getSelectedRow();
		if (index != -1) {
			TableModel model = tblObj.getModel();
			// 获得当前行id
			Object obj = model.getValueAt(index, 0);
			Long id = Long.valueOf(obj+"");
			// 获得当前行试卷生成情况
			Object isGenerate = model.getValueAt(index, 9);
			String isExam = isGenerate.toString();
			if (isExam.equals("未生成")) {
				JOptionPane.showMessageDialog(null, "试卷未生成，暂时无法考试！");
				return;
			}
			if (id > 0) {
				// 根据id找到对象
				PaperService paperService = new PaperServiceImpl();
				PaperScoreService paperScoreService = new PaperScoreServiceImpl();
				Long result = paperScoreService.searchExamStatus(id, bean.getID());
				PaperBean paperBean = paperService.loadById(id);
				String startOn = paperBean.getStartOn();
				String endOn = paperBean.getEndOn();
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "您已经考过该场考试！");
					return;
				}
				if (verifyDate(startOn, endOn)) {	
					int option = JOptionPane.showConfirmDialog(this, "是否开始考试？", "系统提示", JOptionPane.YES_NO_OPTION);
		
					if (option == JOptionPane.YES_OPTION) {
						ExamFrm examFrm = new ExamFrm(paperBean);
						examFrm.studentBean = (StudentBean)bean;
						examFrm.examSystemPnl = this;
						examFrm.showFrm();
					} 
				}
			}
		}
	}
	
	/**
	 * <p>Description: 安装组件</p>
	 * <p>Title: installCompents</p>
	 */
	private void installCompents() {
		add(lblTitle, BorderLayout.NORTH);
		pnlOpearator.add(lblSearch);
		pnlOpearator.add(txtSearch);
		pnlOpearator.add(btnSearch);
		pnlOpearator.add(btnReset);
		pnlOpearator.add(cboSort);
		add(createScrollPane(tblObj), BorderLayout.CENTER);
		add(pnlOpearator, BorderLayout.SOUTH);
	}

	/**
	 * <p>Description: 安装事件监听器</p>
	 * <p>Title: installListener</p>
	 */
	private void installListener() {
		cboSort.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				refreshData();
			}
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				refreshData();				
			}
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				refreshData();				
			}
		});
		btnSearch.addActionListener(e->{
			btnSearchOnClickListener(e);
		});
		btnReset.addActionListener(e->{
			btnResetOnClickListener(e);
		});
	}

	/**
	 * <p>Description: 查询按钮点击事件监听器</p>
	 * <p>Title: btnSearchOnClickListener</p>
	 * @param e
	 */
	private void btnSearchOnClickListener(ActionEvent e) {
		refreshData();
	}

	/**
	 * <p>Description: 重置按钮点击事件监听器</p>
	 * <p>Title: btnResetOnClickListener</p>
	 * @param e
	 */
	private void btnResetOnClickListener(ActionEvent e) {
		refresh();
		refreshData();
	}

	/**
	 * <p>Description: 重置文本框</p>
	 * <p>Title: refresh</p>
	 */
	private void refresh() {
		txtSearch.setText("");
		cboSort.setSelectedIndex(0);
	}
	
	/**
	 * <p>Description: 更新表格数据</p>
	 * <p>Title: refreshData</p>
	 */
	public void refreshData() {
		showListData();
	}
	
	/**
	 * <p>Description: 显示列表数据</p>
	 * <p>Title: showListData</p>
	 */
	private void showListData() {
		PaperService paperService = new PaperServiceImpl();
		List<PaperBean> list = null;
		
		String search = txtSearch.getText().trim().toString();
		if (cboSortIsSelected().equals(SORT_ASC_BY_ID)){
			list = paperService.listByIDAsc(search);
		} else if (cboSortIsSelected().equals(SORT_DESC_BY_ID)) {
			list = paperService.listByIDDesc(search);
		} else if (cboSortIsSelected().equals(SORT_ASC_BY_PAPER_NAME)) {
			list = paperService.listByPaperNameAsc(search);
		} else if (cboSortIsSelected().equals(SORT_DESC_BY_PAPER_NAME)) {
			list = paperService.listByPaperNameDesc(search);
		} else if (cboSortIsSelected().equals(SORT_ASC_BY_SUBJECT_NAME)) {
			list = paperService.listBySubjectNameAsc(search);
		}  else if (cboSortIsSelected().equals(SORT_DESC_BY_SUBJECT_NAME)) {
			list = paperService.listBySubjectNameDesc(search);
		} else {
			list = paperService.listBySearch(search);
		}
		
		ATableModel<PaperBean> tableModel = null;
		
		tableModel = new ATableModel<PaperBean>(list, 10) {

			@Override
			public Object getPropValue(PaperBean bean, int columnIndex) {
				if (columnIndex == 0) {
					return bean.getPaperID();
				} else if (columnIndex == 1) {
					return bean.getSubjectName();
				} else if (columnIndex == 2) {
					return bean.getPaperName();
				} else if (columnIndex == 3) {
					return bean.getTotalScore();
				} else if (columnIndex == 4) {
					return bean.getPerScore();
				} else if (columnIndex == 5) {
					return bean.getQuestionNum();
				} else if (columnIndex == 6) {
					return bean.getExamMinute();
				} else if (columnIndex == 7) {
					return bean.getStartOn();
				} else if (columnIndex == 8) {
					return bean.getEndOn();
				} else if (columnIndex == 9) {
					return generateChange(bean.getHasGenerate());
				}
				return null;	
			}

			@Override
			public String getTitle(int columnIndex) {
				if (columnIndex == 0) {
					return "ID";
				} else if (columnIndex == 1) {
					return "科目";
				} else if (columnIndex == 2) {
					return "卷名";
				} else if (columnIndex == 3) {
					return "总分";
				} else if (columnIndex == 4) {
					return "每题分数";
				} else if (columnIndex == 5) {
					return "题数";
				} else if (columnIndex == 6) {
					return "考试时间";
				} else if (columnIndex == 7) {
					return "有效开始日期";
				} else if (columnIndex == 8) {
					return "有效结束日期";
				} else if (columnIndex == 9) {
					return "是否已生成";
				}
				return null;
			}
			
		};
		
		tblObj.setModel(tableModel);
		
		Integer widthPaperName = 200;
		// 设置有效结束日期列表宽度
		tblObj.getColumnModel().getColumn(2).setPreferredWidth(widthPaperName);   
		tblObj.getColumnModel().getColumn(2).setWidth(widthPaperName);   
		tblObj.getColumnModel().getColumn(2).setMaxWidth(widthPaperName);
		tblObj.getColumnModel().getColumn(2).setMinWidth(widthPaperName);
		
		Integer widthDate = 145;
		// 设置有效开始日期列表宽度
		tblObj.getColumnModel().getColumn(7).setPreferredWidth(widthDate);   
		tblObj.getColumnModel().getColumn(7).setWidth(widthDate);   
		tblObj.getColumnModel().getColumn(7).setMaxWidth(widthDate);
		tblObj.getColumnModel().getColumn(7).setMinWidth(widthDate);
		
		// 设置有效结束日期列表宽度
		tblObj.getColumnModel().getColumn(8).setPreferredWidth(widthDate);   
		tblObj.getColumnModel().getColumn(8).setWidth(widthDate);   
		tblObj.getColumnModel().getColumn(8).setMaxWidth(widthDate);
		tblObj.getColumnModel().getColumn(8).setMinWidth(widthDate);
		
	}
	
	/**
	 * <p>Description: 创建轮滑框</p>
	 * <p>Title: createScrollPane</p>
	 * @param textArea
	 * @return
	 */
	private JScrollPane createScrollPane(JTable table) {
		// 轮滑框 
		JScrollPane jscrollPane = new JScrollPane(table);
		// 去掉边框
		jscrollPane.setBorder(BorderFactory.createEmptyBorder());
		jscrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		return jscrollPane;
	}

	/**
	 * <p>Description: 返回当前下拉框的选项</p>
	 * <p>Title: cboSortIsSelected</p>
	 * @return
	 */
	private String cboSortIsSelected() {
		if (cboSort.getSelectedIndex() == 0) {
			return SORT_ASC_BY_ID;
		} else if (cboSort.getSelectedIndex() == 1) {
			return SORT_DESC_BY_ID;
		} else if (cboSort.getSelectedIndex() == 2) {
			return SORT_ASC_BY_PAPER_NAME;
		} else if (cboSort.getSelectedIndex() == 3) {
			return SORT_DESC_BY_PAPER_NAME;
		} else if (cboSort.getSelectedIndex() == 4){
			return SORT_ASC_BY_SUBJECT_NAME;
		} else if (cboSort.getSelectedIndex() == 5){
			return SORT_DESC_BY_SUBJECT_NAME;
		} else {
			return null;
		}
	}
	
	/**
	 * <p>Description: 验证日期</p>
	 * <p>Title: verifyDate</p>
	 * @param startOn
	 * @param endOn
	 * @return
	 */
	private Boolean verifyDate(String startOn, String endOn) {
		Boolean isOk = false;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startOnDate = simpleDateFormat.parse(startOn);
			Date endOnDate = simpleDateFormat.parse(endOn);
			if (date.after(endOnDate)) {
				JOptionPane.showMessageDialog(null, "考试有效日期已过！");
			} else if (date.before(startOnDate)) {
				JOptionPane.showMessageDialog(null, "考试还未开启！");
			} else {
				isOk = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isOk;
	}

	/**
	 * <p>Description: 是否生成字符串转换</p>
	 * <p>Title: generateChange</p>
	 * @param generate
	 * @return
	 */
	private String generateChange(Integer generate) {
		if (generate == 0) {
			return "未生成";
		} else if (generate == 1){
			return "已生成";
		} else {
			return "未知";
		}
	}

}
