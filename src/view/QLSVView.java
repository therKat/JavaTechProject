package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.SinhVien;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaSV_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox comboBox_queQuan_timKiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		setIconImage(new ImageIcon("asset/icon2.png").getImage());
		
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 818);
		setLocationRelativeTo(null);

		Action action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(38, 21, 15));
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(38, 21, 15));
		setJMenuBar(menuBar);
		

		JMenu menuFile = new JMenu("File");
//		menuFile.setForeground(new Color(242, 242, 242));
		menuFile.setFont(new Font("Monospaced", Font.BOLD, 17));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		
		JMenuItem menuNew = new JMenuItem("New");
		menuNew.addActionListener(action);
		menuNew.setFont(new Font("Monospaced", Font.BOLD, 19));
		menuFile.add(menuNew);
		menuOpen.setFont(new Font("Monospaced", Font.BOLD, 19));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Monospaced", Font.BOLD, 19));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Monospaced", Font.BOLD, 19));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
//		menuAbout.setForeground(new Color(242, 242, 242));
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Monospaced", Font.BOLD, 17));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Monospaced", Font.BOLD, 19));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(166, 162, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//-------------------------------------------------
		
		JLabel labelTieuDe = new JLabel("Phần mềm quản lý Sinh viên");
		labelTieuDe.setForeground(Color.BLACK);
		labelTieuDe.setOpaque(true);
		labelTieuDe.setBackground(new Color(166, 162, 143));
		labelTieuDe.setFont(new Font("Dialog", Font.BOLD, 35));
		labelTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		labelTieuDe.setBounds(250, 13, 534, 42);
		contentPane.add(labelTieuDe);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(9, 34, 1020, 2);
		contentPane.add(separator_1);
		
		JLabel label_QueQuan = new JLabel("Qu\u00EA qu\u00E1n");
		label_QueQuan.setFont(new Font("Dialog", Font.PLAIN, 22));
		label_QueQuan.setBounds(9, 80, 92, 29);
		contentPane.add(label_QueQuan);

		JLabel lblMSinhVin = new JLabel("Mã sinh viên");
		lblMSinhVin.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblMSinhVin.setBounds(324, 80, 128, 29);
		contentPane.add(lblMSinhVin);

		textField_MaSV_TimKiem = new JTextField();
		textField_MaSV_TimKiem.setBackground(new Color(255, 255, 255));
		textField_MaSV_TimKiem.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_MaSV_TimKiem.setColumns(10);
		textField_MaSV_TimKiem.setBounds(462, 80, 168, 29);
		contentPane.add(textField_MaSV_TimKiem);

		comboBox_queQuan_timKiem = new JComboBox();
		comboBox_queQuan_timKiem.setBackground(new Color(255, 255, 255));
		comboBox_queQuan_timKiem.setFont(new Font("Dialog", Font.PLAIN, 20));
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(111, 81, 168, 29);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(785, 74, 117, 40);
		contentPane.add(btnTim);
		btnTim.setBackground(new Color(217, 194, 173));
		btnTim.addActionListener(action);
		btnTim.setBorder(new LineBorder(Color.BLACK));
		btnTim.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.setBackground(new Color(217, 194, 173));
		btnHuyTim.addActionListener(action);
		btnHuyTim.setBorder(new LineBorder(Color.BLACK));
		btnHuyTim.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnHuyTim.setBounds(912, 74, 117, 40);
		contentPane.add(btnHuyTim);
		
		//----------------------------------
		JLabel lblDSSV = new JLabel("Danh sách sinh viên");
		lblDSSV.setBackground(new Color(166, 162, 143));
		lblDSSV.setOpaque(true);
		lblDSSV.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDSSV.setBounds(9, 139, 312, 40);
		contentPane.add(lblDSSV);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(9, 162, 1020, 2);
		contentPane.add(separator_2);

		table = new JTable();
		table.getTableHeader().setPreferredSize(new Dimension(50,30));
		table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
		table.setBackground(new Color(217, 232, 252));
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã SV", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));

		table.setRowHeight(30);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(326);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(UIManager.getBorder("CheckBox.border"));
		scrollPane.setBounds(9, 206, 1020, 270);
		contentPane.add(scrollPane);
		
		scrollPane.getVerticalScrollBar().setBackground(new Color(166, 162, 143));
		scrollPane.getHorizontalScrollBar().setBackground(new Color(166, 162, 143));
		
		//----------------------------		
		JLabel lblThngTinSinh = new JLabel("Thông tin sinh viên");
		lblThngTinSinh.setBackground(new Color(166, 162, 143));
		lblThngTinSinh.setOpaque(true);
		lblThngTinSinh.setFont(new Font("Dialog", Font.BOLD, 30));
		lblThngTinSinh.setBounds(9, 487, 294, 40);
		contentPane.add(lblThngTinSinh);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(9, 507, 683, 2);
		contentPane.add(separator_3);

		JLabel lblMSinhVin_1 = new JLabel("Mã sinh viên");
		lblMSinhVin_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblMSinhVin_1.setBounds(9, 553, 127, 29);
		contentPane.add(lblMSinhVin_1);

		textField_ID = new JTextField();
		textField_ID.setForeground(new Color(113, 115, 106));
		textField_ID.setBackground(new Color(255, 255, 255));
		textField_ID.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_ID.setColumns(10);
		textField_ID.setBounds(181, 553, 219, 29);
		contentPane.add(textField_ID);

		JLabel label_HoVaTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		label_HoVaTen.setFont(new Font("Dialog", Font.BOLD, 22));
		label_HoVaTen.setBounds(9, 598, 98, 29);
		contentPane.add(label_HoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setForeground(new Color(113, 115, 106));
		textField_HoVaTen.setBackground(new Color(255, 255, 255));
		textField_HoVaTen.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(181, 598, 219, 29);
		contentPane.add(textField_HoVaTen);

		JLabel label_HoVaTen_1 = new JLabel("Qu\u00EA qu\u00E1n");
		label_HoVaTen_1.setFont(new Font("Dialog", Font.BOLD, 22));
		label_HoVaTen_1.setBounds(9, 643, 99, 29);
		contentPane.add(label_HoVaTen_1);

		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.setForeground(new Color(113, 115, 106));
		comboBox_queQuan.setBackground(new Color(255, 255, 255));
		comboBox_queQuan.setFont(new Font("Dialog", Font.PLAIN, 18));
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}

		comboBox_queQuan.setBounds(181, 644, 219, 29);
		contentPane.add(comboBox_queQuan);

		JLabel label_NgaySinh = new JLabel("Ng\u00E0y sinh");
		label_NgaySinh.setFont(new Font("Dialog", Font.BOLD, 22));
		label_NgaySinh.setBounds(9, 688, 101, 29);
		contentPane.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setForeground(new Color(113, 115, 106));
		textField_NgaySinh.setBackground(new Color(255, 255, 255));
		textField_NgaySinh.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(181, 688, 219, 29);
		contentPane.add(textField_NgaySinh);

		JLabel label_ID_1 = new JLabel("Gi\u1EDBi t\u00EDnh");
		label_ID_1.setFont(new Font("Dialog", Font.BOLD, 22));
		label_ID_1.setBounds(431, 553, 87, 29);
		contentPane.add(label_ID_1);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBackground(new Color(166, 162, 143));
		radioButton_nam.setFont(new Font("Dialog", Font.PLAIN, 22));
		radioButton_nam.setBounds(548, 553, 82, 27);
		contentPane.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBackground(new Color(166, 162, 143));
		radioButton_nu.setFont(new Font("Dialog", Font.PLAIN, 22));
		radioButton_nu.setBounds(632, 553, 61, 27);
		contentPane.add(radioButton_nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		JLabel label_HoVaTen_2 = new JLabel("M\u00F4n 1");
		label_HoVaTen_2.setFont(new Font("Dialog", Font.BOLD, 22));
		label_HoVaTen_2.setBounds(431, 598, 61, 29);
		contentPane.add(label_HoVaTen_2);

		textField_Mon1 = new JTextField();
		textField_Mon1.setForeground(new Color(113, 115, 106));
		textField_Mon1.setBackground(new Color(255, 255, 255));
		textField_Mon1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(552, 598, 141, 29);
		contentPane.add(textField_Mon1);

		JLabel label_HoVaTen_2_1 = new JLabel("M\u00F4n 2");
		label_HoVaTen_2_1.setFont(new Font("Dialog", Font.BOLD, 22));
		label_HoVaTen_2_1.setBounds(431, 643, 61, 29);
		contentPane.add(label_HoVaTen_2_1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setForeground(new Color(113, 115, 106));
		textField_Mon2.setBackground(new Color(255, 255, 255));
		textField_Mon2.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(552, 643, 141, 29);
		contentPane.add(textField_Mon2);

		JLabel label_Mon3 = new JLabel("M\u00F4n 3");
		label_Mon3.setFont(new Font("Dialog", Font.BOLD, 22));
		label_Mon3.setBounds(431, 688, 61, 29);
		contentPane.add(label_Mon3);

		textField_Mon3 = new JTextField();
		textField_Mon3.setForeground(new Color(113, 115, 106));
		textField_Mon3.setBackground(new Color(255, 255, 255));
		textField_Mon3.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(552, 688, 141, 29);
		contentPane.add(textField_Mon3);
		
		JPanel panel_DieuKhien = new JPanel();
		panel_DieuKhien.setBackground(new Color(166, 126, 111));
		panel_DieuKhien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_DieuKhien.setBounds(711, 485, 318, 233);
		contentPane.add(panel_DieuKhien);
		panel_DieuKhien.setLayout(null);
		
		//-------------------------------------------------
		
		JLabel lbliuKhin = new JLabel("Điều khiển");
		lbliuKhin.setHorizontalAlignment(SwingConstants.CENTER);
		lbliuKhin.setFont(new Font("Dialog", Font.BOLD, 25));
		lbliuKhin.setBounds(10, 11, 298, 34);
		panel_DieuKhien.add(lbliuKhin);
		
				JButton btnThem = new JButton("Th\u00EAm");
				btnThem.setBounds(20, 56, 117, 40);
				panel_DieuKhien.add(btnThem);
				btnThem.setBackground(new Color(217, 194, 173));
				btnThem.addActionListener(action);
				btnThem.setBorder(new LineBorder(new Color(38, 21, 15)));
				btnThem.setFont(new Font("Monospaced", Font.BOLD, 17));
				
				JButton btnLuu = new JButton("L\u01B0u");
				btnLuu.setBounds(178, 56, 117, 40);
				panel_DieuKhien.add(btnLuu);
				btnLuu.setBackground(new Color(217, 194, 173));
				btnLuu.addActionListener(action);
				btnLuu.setBorder(new LineBorder(new Color(38, 21, 15)));
				btnLuu.setFont(new Font("Monospaced", Font.BOLD, 17));
				
				JButton btnHuyBo = new JButton("H\u1EE7y b\u1ECF");
				btnHuyBo.setBounds(100, 170, 117, 40);
				panel_DieuKhien.add(btnHuyBo);
				btnHuyBo.setBackground(new Color(217, 194, 173));
				btnHuyBo.addActionListener(action);
				btnHuyBo.setBorder(new LineBorder(new Color(38, 21, 15)));
				btnHuyBo.setFont(new Font("Monospaced", Font.BOLD, 17));
						
				JButton btnXoa = new JButton("X\u00F3a");
				btnXoa.setBounds(178, 113, 117, 40);
				panel_DieuKhien.add(btnXoa);
				btnXoa.setBackground(new Color(217, 194, 173));
				btnXoa.addActionListener(action);
				btnXoa.setBorder(new LineBorder(new Color(38, 21, 15)));
				btnXoa.setFont(new Font("Monospaced", Font.BOLD, 17));
								
				JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
				btnCapNhat.setBounds(20, 113, 117, 40);
				panel_DieuKhien.add(btnCapNhat);
				btnCapNhat.setBackground(new Color(217, 194, 173));
				btnCapNhat.addActionListener(action);
				btnCapNhat.setBorder(new LineBorder(new Color(38, 21, 15)));
				btnCapNhat.setFont(new Font("Monospaced", Font.BOLD, 17));
									
		
										
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(9, 729, 1020, 2);
		contentPane.add(separator_4);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaSV_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { sv.getMaSinhVien() + "", sv.getTenSinhVien(), sv.getQueQuan().getTenTinh(),
				sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
						+ (sv.getNgaySinh().getYear() + 1900),
				(sv.isGioiTinh() ? "Nam" : "Nữ"), sv.getDiemMon1() + "", sv.getDiemMon2() + "",
				sv.getDiemMon3() + "", });
	}

	public void themHoacCapNhatSinhVien(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(sv)) {
			this.model.insert(sv);
			this.themSinhVienVaoTable(sv);
		} else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sv.getMaSinhVien() + "")) {
					model_table.setValueAt(sv.getMaSinhVien() + "", i, 0);
					model_table.setValueAt(sv.getTenSinhVien() + "", i, 1);
					model_table.setValueAt(sv.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
							+ (sv.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((sv.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(sv.getDiemMon1() + "", i, 5);
					model_table.setValueAt(sv.getDiemMon2() + "", i, 6);
					model_table.setValueAt(sv.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public SinhVien getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenSinhVien = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return sv;
	}

	public void hienThiThongTinSinhVienDaChon() {
		SinhVien sv = getSinhVienDangChon();

		this.textField_ID.setText(sv.getMaSinhVien() + "");
		this.textField_HoVaTen.setText(sv.getTenSinhVien() + "");
		this.comboBox_queQuan.setSelectedItem(sv.getQueQuan().getTenTinh());
		String s_ngaySinh = sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
				+ (sv.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (sv.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(sv.getDiemMon1() + "");
		this.textField_Mon2.setText(sv.getDiemMon2() + "");
		this.textField_Mon3.setText(sv.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVienDangChon();
			
			model_table.removeRow(i_row);
			this.model.delete(sv);		
		}
	}

	public void thucHienThemSinhVien() {
		// Get du lieu
		int maSinhVien = Integer.valueOf(this.textField_ID.getText());
		String tenSinhVien = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());

		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatSinhVien(sv);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		// Thuc hien tim kiem
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maSinhVienTimKiem = this.textField_MaSV_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
//			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
//				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
//					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SinhVien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh \n   Bài làm của: \n      -------------------"
				+ "\n      2055010183 Nguyễn Thái Nam\n      ------------------- \n      2055010231 Đinh Quốc Tiến");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!=null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
		this.model.setDsSinhVien(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
	public void thucHienNew(){
		dispose();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSVView();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}