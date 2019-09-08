package edu.prj.ui.function.manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;

import java.util.List;
import com.liuvei.common.win.ATableModel;

import edu.prj.bean.*;
import edu.prj.bean.user.*;
import edu.prj.service.*;
import edu.prj.service.impl.*;
import edu.prj.ui.crud.subject.*;

@SuppressWarnings("serial")
public class SubjectManagePnl extends JPanel{
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
	/** 添加按钮 */
	private JButton btnAdd;
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
	private static final String SORT_ASC_BY_SUBJECT_NAME = "按名称升序";
	/** 按昵称降序 */
	private static final String SORT_DESC_BY_SUBJECT_NAME = "按名称降序";

	public SubjectManagePnl() {
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
		lblTitle = new JLabel("科目管理");
		pnlOpearator = new JPanel();
		lblSearch = new JLabel("查询：");
		txtSearch = new JTextField();
		btnSearch = new JButton("查询");
		btnReset = new JButton("重置");
		btnAdd = new JButton("新增");	
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
		configureBtnAdd();
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
	 * <p>Description: 配置新增按钮</p>
	 * <p>Title: configureBtnAdd</p>
	 */
	private void configureBtnAdd() {
		btnAdd.setFont(font);
		btnAdd.setPreferredSize(btnDimension);
		btnAdd.setFocusable(false);
	}

	/**
	 * <p>Description: 配置排序下拉框</p>
	 * <p>Title: configureCboSort</p>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configureCboSort() {
		String[] sorts = {"按ID升序", "按ID降序", "按名称升序", "按名称降序"};
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
		JMenuItem deleteMenuItem = new JMenuItem("删除");
		deleteMenuItem.setFont(font);
		tblObjMenu.add(deleteMenuItem);
		deleteMenuItem.addActionListener(e -> {
			deleteMenuItemOnClickListener(e);
		});
		
		JMenuItem updateMenuItem = new JMenuItem("修改");
		updateMenuItem.setFont(font);
		tblObjMenu.add(updateMenuItem);
		updateMenuItem.addActionListener(e->{
			updateMenuItemOnClickListener(e);
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
	 * <p>Description: 表格右键菜单删除选项事件监听器</p>
	 * <p>Title: deleteMenuItemOnClickListener</p>
	 * @param e
	 */
	private void deleteMenuItemOnClickListener(ActionEvent e) {
		// 获取当前选择行的下标
		int index = tblObj.getSelectedRow();
		// 如果下标不为-1，则选中行为数据行
		if (index != -1) {
			// 取得表格对象的数据模型
			TableModel model = tblObj.getModel();
			// 在表格对象模型中，根据选中的行和列，获取对应的数据值
			Object obj = model.getValueAt(index, 0);
			Long id = Long.valueOf(obj+"");
			// 创建确认是否删除的弹窗
			String title = "系统提示";
			String message = "请确认是否删除选中的数据";
			// 对话框按钮类型
			int option = JOptionPane.YES_NO_OPTION;
			// 保存用户点击的按钮类型的值
			int buttonValue = JOptionPane.showConfirmDialog(null, message, title, option);
			
			// 如果点击的按钮为YES，进行删除数据
			if (buttonValue == JOptionPane.YES_OPTION) {
				SubjectService subjectService = new SubjectServiceImpl();
				// 获得删除结果
				Long result = subjectService.delete(id);
				if (result > 0) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					refreshData();
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}
		}
	}
	
	/**
	 * <p>Description: 表格右键菜单修改选项事件监听器</p>
	 * <p>Title: showMenuItemOnClickListener</p>
	 * @param e
	 */
	private void updateMenuItemOnClickListener(ActionEvent e) {
		int index = tblObj.getSelectedRow();
		if (index != -1) {
			TableModel model = tblObj.getModel();
			Object obj = model.getValueAt(index, 0);
			// 获得当前行id
			Long id = Long.valueOf(obj+"");
			
			if (id > 0) {
				// 根据id找到对象
				SubjectService subjectService = new SubjectServiceImpl();
				SubjectBean subjectBean = subjectService.loadById(id);
				SubjectUpdateFrm subjectUpdateFrm = new SubjectUpdateFrm(subjectBean);
				subjectUpdateFrm.subjectManagePnl = this;
				subjectUpdateFrm.showFrm();
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
		pnlOpearator.add(btnAdd);
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
		btnAdd.addActionListener(e->{
			btnAddOnClickListener(e);
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
	 * <p>Description: 新增按钮点击事件监听器</p>
	 * <p>Title: btnAddOnClickListener</p>
	 * @param e
	 */
	private void btnAddOnClickListener(ActionEvent e) {
		SubjectCreateFrm subjectCreateFrm = new SubjectCreateFrm(bean);
		subjectCreateFrm.subjectManagePnl = this;
		subjectCreateFrm.showFrm();
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
		SubjectService subjectService = new SubjectServiceImpl();
		List<SubjectBean> list = null;
		
		String search = txtSearch.getText().trim().toString();
		if (cboSortIsSelected().equals(SORT_ASC_BY_ID)){
			list = subjectService.listByIDAsc(search);
		} else if (cboSortIsSelected().equals(SORT_DESC_BY_ID)) {
			list = subjectService.listByIDDesc(search);
		} else if (cboSortIsSelected().equals(SORT_ASC_BY_SUBJECT_NAME)) {
			list = subjectService.listBySubjectNameAsc(search);
		} else if (cboSortIsSelected().equals(SORT_DESC_BY_SUBJECT_NAME)) {
			list = subjectService.listBySubjectNameDesc(search);
		} else {
			list = subjectService.listBySearch(search);
		}
		
		ATableModel<SubjectBean> tableModel = null;
		
		tableModel = new ATableModel<SubjectBean>(list, 4) {

			@Override
			public Object getPropValue(SubjectBean bean, int columnIndex) {
				if (columnIndex == 0) {
					return bean.getSubjectID();
				} else if (columnIndex == 1) {
					return bean.getSubjectName();
				} else if (columnIndex == 2) {
					return bean.getTeacherName();
				} else if (columnIndex == 3) {
					return bean.getStatus();
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
					return "教师";
				} else if (columnIndex == 3) {
					return "状态";
				}
				return null;
			}
			
		};
		
		tblObj.setModel(tableModel);
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
			return SORT_ASC_BY_SUBJECT_NAME;
		} else if (cboSort.getSelectedIndex() == 3) {
			return SORT_DESC_BY_SUBJECT_NAME;
		} else {
			return null;
		}
	}
		
}
