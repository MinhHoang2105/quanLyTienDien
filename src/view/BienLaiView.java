package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.BienLaiControler;
import dao.BienLaiDAO;
import dao.BienLaiThanhToanDAO;
import database.JDBCUtil;
import model.BienLaiModel;
import model.QuanLyBienLaiModel;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JSlider;

public class BienLaiView extends JFrame {
	public BienLaiModel bienLaiModel;
	private JTable tableTrangChu_chuaThanhToan;
	private JTextField textField_timKiem;
	private JTextField tfMaSoCongTo;
	private JTextField tfHoTenChuNha;
	private JTextField tfSoDienThoai;
	private JTextField tfDiaChi;
	private JTextField tfChiSoCu;
	private JTextField tfChiSoMoi;
	private JTextField tfSoTienPhaiTra;
	private JTable tableQuanLy;
	private JTextField tfThang;
	private JTextField textField_MaSoCongTo;
	private JTextField textField_HotenChuNha;
	private JTextField textField_SoDienThoai;
	private JTextField textField_DiaChi;
	private JTextField textField_ChiSoCu;
	private JTextField textField_ChiSoMoi;
	private JTextField textField_SoTienPhaiTra;
	private JTextField textField_Thang;
	private JTable tableTrangChu_daThanhToan;
	public QuanLyBienLaiModel qlblmodel;
	private AbstractButton btnHuyTim;
//	private ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BienLaiView frame = new BienLaiView();
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
	public BienLaiView() {
		this.qlblmodel = new QuanLyBienLaiModel();
		
		setBackground(SystemColor.activeCaptionBorder);
		this.setSize(1080, 720);
		this.setLocation(200, 20);
		this.setTitle("Quản lý tiền điện");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}

	private void init() {
		
		ActionListener actionListener = new BienLaiControler(this);
		getContentPane().setLayout(null);
		this.loadData();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.setBounds(0, 0, 1076, 683);
		getContentPane().add(tabbedPane);
		
		
		Font fontTrangChu = new Font("Arial", Font.BOLD, 16);
		Font fontTrangChu_tf = new Font("Arial", Font.BOLD, 14);
		Font fontQuanLy = new Font("Arial", Font.BOLD, 16);
		Font fontQuanly_tf = new Font("Arial", Font.BOLD, 14);
		
//		Trang Chủ
		JPanel panelTrangChu = new JPanel();
		panelTrangChu.setBackground(SystemColor.activeCaptionBorder);
		panelTrangChu.setToolTipText("");
		tabbedPane.addTab("TRANG CHỦ", null, panelTrangChu, null);
		panelTrangChu.setSize(30, 10);
		panelTrangChu.setLayout(null);
		
		
		JLabel lbtimKiem = new JLabel("Tìm Kiếm:");
		lbtimKiem.setBounds(33, 531, 95, 31);
		lbtimKiem.setFont(fontTrangChu);
		panelTrangChu.add(lbtimKiem);
		
		String[] items = { "Mã công tơ", "Tên", "Đia chỉ", "Tháng"};
		
		textField_timKiem = new JTextField();
		textField_timKiem.setBackground(SystemColor.info);
		textField_timKiem.setBounds(196, 572, 283, 31);
		panelTrangChu.add(textField_timKiem);
		textField_timKiem.setColumns(10);
		
		JButton btntimKiem = new JButton("Tìm Kiếm");
		btntimKiem.setBackground(SystemColor.info);
		btntimKiem.setBounds(505, 570, 122, 31);
		btntimKiem.setFont(fontTrangChu);
		btntimKiem.addActionListener(actionListener);
		panelTrangChu.add(btntimKiem);
		
		btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.setFont(fontTrangChu);
		btnHuyTim.setBackground(SystemColor.info);
		btnHuyTim.setBounds(33, 572, 122, 31);
		btnHuyTim.addActionListener(actionListener);
		panelTrangChu.add(btnHuyTim);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBackground(SystemColor.info);
		btnThanhToan.setBounds(822, 532, 182, 61);
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 20));
		btnThanhToan.addActionListener(actionListener);
		panelTrangChu.add(btnThanhToan);
		
		JButton btnChuaThanhToan = new JButton("Chưa Thanh Toán");
		btnChuaThanhToan.setBackground(SystemColor.info);
		btnChuaThanhToan.setBounds(822, 603, 182, 31);
		btnChuaThanhToan.setFont(fontTrangChu);
		btnChuaThanhToan.addActionListener(actionListener);
		panelTrangChu.add(btnChuaThanhToan);
		
		Font font_tfTrangChu = new Font("Arial", Font.BOLD, 14);
		tfMaSoCongTo = new JTextField();
		tfMaSoCongTo.setBackground(SystemColor.info);
		tfMaSoCongTo.setBounds(20, 431, 95, 31);
		tfMaSoCongTo.setFont(font_tfTrangChu);
		tfMaSoCongTo.setColumns(10);
		panelTrangChu.add(tfMaSoCongTo);
		
		tfHoTenChuNha = new JTextField();
		tfHoTenChuNha.setBackground(SystemColor.info);
		tfHoTenChuNha.setColumns(10);
		tfHoTenChuNha.setBounds(125, 431, 143, 31);
		tfHoTenChuNha.setFont(font_tfTrangChu);
		panelTrangChu.add(tfHoTenChuNha);
		
		tfSoDienThoai = new JTextField();
		tfSoDienThoai.setBackground(SystemColor.info);
		tfSoDienThoai.setColumns(10);
		tfSoDienThoai.setBounds(278, 431, 95, 31);
		tfSoDienThoai.setFont(font_tfTrangChu);
		panelTrangChu.add(tfSoDienThoai);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setBackground(SystemColor.info);
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(410, 431, 95, 31);
		tfDiaChi.setFont(font_tfTrangChu);
		panelTrangChu.add(tfDiaChi);
		
		tfChiSoCu = new JTextField();
		tfChiSoCu.setBackground(SystemColor.info);
		tfChiSoCu.setColumns(10);
		tfChiSoCu.setBounds(542, 431, 95, 31);
		tfChiSoCu.setFont(font_tfTrangChu);
		panelTrangChu.add(tfChiSoCu);
		
		tfChiSoMoi = new JTextField();
		tfChiSoMoi.setBackground(SystemColor.info);
		tfChiSoMoi.setColumns(10);
		tfChiSoMoi.setBounds(666, 431, 95, 31);
		tfChiSoMoi.setFont(font_tfTrangChu);
		panelTrangChu.add(tfChiSoMoi);
		
		tfSoTienPhaiTra = new JTextField();
		tfSoTienPhaiTra.setBackground(SystemColor.info);
		tfSoTienPhaiTra.setColumns(10);
		tfSoTienPhaiTra.setBounds(799, 431, 95, 31);
		tfSoTienPhaiTra.setFont(font_tfTrangChu);
		panelTrangChu.add(tfSoTienPhaiTra);
		
		tfThang = new JTextField();
		tfThang.setBackground(SystemColor.info);
		tfThang.setColumns(10);
		tfThang.setBounds(928, 431, 76, 31);
		tfThang.setFont(font_tfTrangChu);
		panelTrangChu.add(tfThang);
		
		
		JTabbedPane tabbedPane_thanhToan = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_thanhToan.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane_thanhToan.setBounds(0, 0, 1071, 421);
		tabbedPane_thanhToan.setFont(fontTrangChu);
		panelTrangChu.add(tabbedPane_thanhToan);
		
		
//		Trang chủ chưa thanh toán		
		JPanel panel_chuaThanhToan = new JPanel();
		panel_chuaThanhToan.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane_thanhToan.addTab("Chưa thanh toán", null, panel_chuaThanhToan, null);
		panel_chuaThanhToan.setLayout(null);
		
		
		tableTrangChu_chuaThanhToan.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		JScrollPane scrollPaneTrangChu_chuaThanhToan = new JScrollPane(tableTrangChu_chuaThanhToan);
		scrollPaneTrangChu_chuaThanhToan.setBounds(10, 57, 1030, 364);
		panel_chuaThanhToan.add(scrollPaneTrangChu_chuaThanhToan);		

		JLabel lbQuanLyTienDien = new JLabel("QUẢN LÝ TIỀN ĐIỆN");
		lbQuanLyTienDien.setBounds(335, 10, 323, 37);
		lbQuanLyTienDien.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_chuaThanhToan.add(lbQuanLyTienDien);
		
		
//		Sự kiện click chuột trái lên 1 dòng trong JTable
		tableTrangChu_chuaThanhToan.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = tableTrangChu_chuaThanhToan.getSelectedRow();
		        tfMaSoCongTo.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 0).toString());
		        tfHoTenChuNha.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 1).toString());
		        tfSoDienThoai.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 2).toString());
		        tfDiaChi.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 3).toString());
		        tfChiSoCu.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 4).toString());
		        tfChiSoMoi.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 5).toString());
		        tfSoTienPhaiTra.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 6).toString());
		        tfThang.setText(tableTrangChu_chuaThanhToan.getValueAt(selectedRow, 7).toString());
		    }
		});
		
//		Trang chủ đã thanh toán
		
		tableTrangChu_daThanhToan.setFont(new Font("Arial", Font.BOLD, 14));
		JPanel panel_daThanhToan = new JPanel();
		panel_daThanhToan.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane_thanhToan.addTab("Đã thanh toán", null, panel_daThanhToan, null);
		panel_daThanhToan.setLayout(null);
		
		JScrollPane scrollPaneTrangChu_daThanhToan = new JScrollPane(tableTrangChu_daThanhToan);
		scrollPaneTrangChu_daThanhToan.setBounds(10, 57, 1030, 364);
		panel_daThanhToan.add(scrollPaneTrangChu_daThanhToan);
		
		JLabel lbQuanLyTienDien_1 = new JLabel("QUẢN LÝ TIỀN ĐIỆN");
		lbQuanLyTienDien_1.setBounds(335, 10, 323, 37);
		lbQuanLyTienDien_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		panel_daThanhToan.add(lbQuanLyTienDien_1);
		
		JSeparator separator_ngang = new JSeparator();
		separator_ngang.setForeground(Color.BLACK);
		separator_ngang.setBounds(0, 500, 1061, 2);
		panelTrangChu.add(separator_ngang);
		
		JSeparator separator_doc = new JSeparator();
		separator_doc.setForeground(Color.BLACK);
		separator_doc.setBounds(734, 500, 0, 134);
		panelTrangChu.add(separator_doc);
		
		
//		Sự kiện click chuột trái lên 1 dòng trong JTable
		tableTrangChu_daThanhToan.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = tableTrangChu_daThanhToan.getSelectedRow();
		        tfMaSoCongTo.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 0).toString());
		        tfHoTenChuNha.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 1).toString());
		        tfSoDienThoai.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 2).toString());
		        tfDiaChi.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 3).toString());
		        tfChiSoCu.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 4).toString());
		        tfChiSoMoi.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 5).toString());
		        tfSoTienPhaiTra.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 6).toString());
		        tfThang.setText(tableTrangChu_daThanhToan.getValueAt(selectedRow, 7).toString());
		    }
		});
		
		
		
		
//		Quản lý.
		JPanel panelQuanLy = new JPanel();
		panelQuanLy.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("QUẢN LÍ THÔNG TIN KHÁCH HÀNG", null, panelQuanLy, null);
		panelQuanLy.setLayout(null);
		
		
		JScrollPane scrollPaneQuanLy = new JScrollPane(tableQuanLy);
		scrollPaneQuanLy.setBounds(10, 10, 1041, 332);
		panelQuanLy.add(scrollPaneQuanLy);
		tableQuanLy.setFont(new Font("Arial", Font.BOLD, 14));
		
		textField_MaSoCongTo = new JTextField();
		textField_MaSoCongTo.setBounds(178, 437, 189, 26);
		panelQuanLy.add(textField_MaSoCongTo);
		textField_MaSoCongTo.setFont(fontQuanly_tf);
		textField_MaSoCongTo.setColumns(10);
		
		textField_HotenChuNha = new JTextField();
		textField_HotenChuNha.setBounds(178, 485, 189, 26);
		textField_HotenChuNha.setColumns(10);
		textField_HotenChuNha.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_HotenChuNha);
		
		textField_SoDienThoai = new JTextField();
		textField_SoDienThoai.setBounds(178, 533, 189, 26);
		textField_SoDienThoai.setColumns(10);
		textField_SoDienThoai.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_SoDienThoai);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setBounds(178, 581, 189, 26);
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_DiaChi);
		
		textField_ChiSoCu = new JTextField();
		textField_ChiSoCu.setColumns(10);
		textField_ChiSoCu.setBounds(564, 437, 189, 26);
		textField_ChiSoCu.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_ChiSoCu);
		
		textField_ChiSoMoi = new JTextField();
		textField_ChiSoMoi.setColumns(10);
		textField_ChiSoMoi.setBounds(564, 485, 189, 26);
		textField_ChiSoMoi.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_ChiSoMoi);
		
		textField_SoTienPhaiTra = new JTextField();
		textField_SoTienPhaiTra.setColumns(10);
		textField_SoTienPhaiTra.setBounds(564, 533, 189, 26);
		textField_SoTienPhaiTra.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_SoTienPhaiTra);
		
		textField_Thang = new JTextField();
		textField_Thang.setColumns(10);
		textField_Thang.setBounds(564, 581, 189, 26);
		textField_Thang.setFont(fontQuanly_tf);
		panelQuanLy.add(textField_Thang);
		
		JLabel lbMaCongTo = new JLabel("Mã Công tơ:");
		lbMaCongTo.setBounds(44, 437, 124, 26);
		lbMaCongTo.setFont(fontQuanLy);
		panelQuanLy.add(lbMaCongTo);
		
		JLabel lbHoTenChuNha = new JLabel("Họ tên chủ nhà:");
		lbHoTenChuNha.setBounds(44, 485, 124, 26);
		lbHoTenChuNha.setFont(fontQuanLy);
		panelQuanLy.add(lbHoTenChuNha);
		
		JLabel lbSoDienThoai = new JLabel("Số điện thoại:");
		lbSoDienThoai.setBounds(44, 533, 124, 26);
		lbSoDienThoai.setFont(fontQuanLy);
		panelQuanLy.add(lbSoDienThoai);

		JLabel lbDiaChi = new JLabel("Địa chỉ:");
		lbDiaChi.setBounds(44, 581, 124, 26);
		lbDiaChi.setFont(fontQuanLy);
		panelQuanLy.add(lbDiaChi);
		
		JLabel lbChiSoCu = new JLabel("Chỉ số cũ:");
		lbChiSoCu.setBounds(430, 437, 124, 26);
		lbChiSoCu.setFont(fontQuanLy);
		panelQuanLy.add(lbChiSoCu);
		
		JLabel lbChiSoMoi = new JLabel("Chỉ Số mới:");
		lbChiSoMoi.setBounds(430, 485, 124, 26);
		lbChiSoMoi.setFont(fontQuanLy);
		panelQuanLy.add(lbChiSoMoi);
		
		JLabel lbSoTienPhaiTra = new JLabel("Số Tiền phải trả:");
		lbSoTienPhaiTra.setBounds(430, 533, 134, 26);
		lbSoTienPhaiTra.setFont(fontQuanLy);
		panelQuanLy.add(lbSoTienPhaiTra);
		
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setBounds(430, 581, 96, 26);
		lblThang.setFont(fontQuanLy);
		panelQuanLy.add(lblThang);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(SystemColor.info);
		btnThem.setBounds(870, 425, 101, 44);
		btnThem.setFont(fontQuanLy);
		btnThem.addActionListener(actionListener);
		panelQuanLy.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(SystemColor.info);
		btnXoa.setBounds(870, 494, 101, 44);
		btnXoa.setFont(fontQuanLy);
		btnXoa.addActionListener(actionListener);
		panelQuanLy.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(SystemColor.info);
		btnSua.setBounds(870, 561, 101, 44);
		btnSua.setFont(fontQuanLy);
		btnSua.addActionListener(actionListener);
		panelQuanLy.add(btnSua);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 353, 1071, 2);
		panelQuanLy.add(separator);
		
		JLabel lblThngTin = new JLabel("Thông Tin:");
		lblThngTin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblThngTin.setBounds(20, 375, 124, 38);
		panelQuanLy.add(lblThngTin);

//		Sự kiện click chuột trái lên 1 dòng trong JTable
		tableQuanLy.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = tableQuanLy.getSelectedRow();
		        textField_MaSoCongTo.setText(tableQuanLy.getValueAt(selectedRow, 0).toString());
		        textField_HotenChuNha.setText(tableQuanLy.getValueAt(selectedRow, 1).toString());
		        textField_SoDienThoai.setText(tableQuanLy.getValueAt(selectedRow, 2).toString());
		        textField_DiaChi.setText(tableQuanLy.getValueAt(selectedRow, 3).toString());
		        textField_ChiSoCu.setText(tableQuanLy.getValueAt(selectedRow, 4).toString());
		        textField_ChiSoMoi.setText(tableQuanLy.getValueAt(selectedRow, 5).toString());
		        textField_SoTienPhaiTra.setText(tableQuanLy.getValueAt(selectedRow, 6).toString());
		        textField_Thang.setText(tableQuanLy.getValueAt(selectedRow, 7).toString());
		    }
		});
		
		

		
//		Thống kê
		JPanel panelThongke = new JPanel();
		panelThongke.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("THỐNG KÊ", null, panelThongke, null);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(this.tongTienThang(1), "", "Tháng 1");
        dataset.setValue(this.tongTienThang(2), "", "Tháng 2");
        dataset.setValue(this.tongTienThang(3), "", "Tháng 3");
        dataset.setValue(this.tongTienThang(4), "", "Tháng 4");
        dataset.setValue(this.tongTienThang(5), "", "Tháng 5");
        dataset.setValue(this.tongTienThang(6), "", "Tháng 6");
        dataset.setValue(this.tongTienThang(7), "", "Tháng 7");
        dataset.setValue(this.tongTienThang(8), "", "Tháng 8");
        dataset.setValue(this.tongTienThang(9), "", "Tháng 9");
        dataset.setValue(this.tongTienThang(10), "", "Tháng 10");
        dataset.setValue(this.tongTienThang(11), "", "Tháng 11");
        dataset.setValue(this.tongTienThang(12), "", "Tháng 12");
        JFreeChart chart = ChartFactory.createBarChart("Thông kê tiền điện", "Tháng", "vnd", dataset);
        panelThongke.setLayout(null);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBounds(0, 0, 1061, 667);
        panelThongke.add(chartPanel);
		
	}
	public void xoaForm() {
		textField_MaSoCongTo.setText("");
		textField_HotenChuNha.setText("");
		textField_SoDienThoai.setText("");
		textField_DiaChi.setText("");
		textField_ChiSoCu.setText("");
		textField_ChiSoMoi.setText("");
		textField_SoTienPhaiTra.setText("");
		textField_Thang.setText("");
	}
	public void xoaFormTrangChu() {
		tfMaSoCongTo.setText("");
		tfHoTenChuNha.setText("");
		tfSoDienThoai.setText("");
		tfDiaChi.setText("");
		tfChiSoCu.setText("");
		tfChiSoMoi.setText("");
		tfSoTienPhaiTra.setText("");
		tfThang.setText("");
	}
	public void suaCSDL() {
		try {
			int maSoCongTo = Integer.parseInt(textField_MaSoCongTo.getText());
			String hoTenChuNha = textField_HotenChuNha.getText();
			String soDienThoai = textField_SoDienThoai.getText();
			String diaChi = textField_DiaChi.getText();
			int chiSoCu = Integer.parseInt(textField_ChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(textField_ChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(textField_Thang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().insert(bienLai);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void suaJtable() {
			DefaultTableModel model = (DefaultTableModel) tableQuanLy.getModel();
			int selectedRow = tableQuanLy.getSelectedRow();
			if (selectedRow != -1) {
			    model.removeRow(selectedRow);
			}
			
			this.themVaoJtable_quanLy();
		}
	public double soTienPhaitra(int chiSoCu, int chiSoMoi) {
		int tieuThu = chiSoMoi - chiSoCu;
		if (tieuThu <= 50) {
			return tieuThu * 450;
		} else {
			return (50 * 450) + ((tieuThu - 50) * 800);
		}
	}
	public void xoaKhoiJtable_quanLy() {
		DefaultTableModel model = (DefaultTableModel) tableQuanLy.getModel();
		int selectedRow = tableQuanLy.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiJtable_chuaThanhToan() {
		DefaultTableModel model = (DefaultTableModel) tableTrangChu_chuaThanhToan.getModel();
		int selectedRow = tableTrangChu_chuaThanhToan.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void xoaKhoiJtable_daThanhToan() {
		DefaultTableModel model = (DefaultTableModel) tableTrangChu_daThanhToan.getModel();
		int selectedRow = tableTrangChu_daThanhToan.getSelectedRow();
		if (selectedRow != -1) {
		    model.removeRow(selectedRow);
		}
	}
	public void themVaoJtable_quanLy() {
		int maSoCongTo = Integer.parseInt(textField_MaSoCongTo.getText());
		String hoTenChuNha = textField_HotenChuNha.getText();
		String soDienThoai = textField_SoDienThoai.getText();
		String diaChi = textField_DiaChi.getText();
		int chiSoCu = Integer.parseInt(textField_ChiSoCu.getText());
		int chiSoMoi = Integer.parseInt(textField_ChiSoMoi.getText());
		double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
		int thang = Integer.parseInt(textField_Thang.getText());
		
		DefaultTableModel model = (DefaultTableModel) tableQuanLy.getModel();
		model.addRow(new Object[] {	maSoCongTo, 
									hoTenChuNha, 
									soDienThoai, 
									diaChi,  
									chiSoCu, 
									chiSoMoi, 
									soTienPhaiTra,
									thang});
	}
	public void themVaoJtable_chuaThanhToan() {
		int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
		String hoTenChuNha = tfHoTenChuNha.getText();
		String soDienThoai = tfSoDienThoai.getText();
		String diaChi = tfDiaChi.getText();
		int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
		int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
		double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
		int thang = Integer.parseInt(tfThang.getText());
		
		DefaultTableModel model = (DefaultTableModel) tableTrangChu_chuaThanhToan.getModel();
		model.addRow(new Object[] {	maSoCongTo, 
									hoTenChuNha, 
									soDienThoai, 
									diaChi,  
									chiSoCu, 
									chiSoMoi, 
									soTienPhaiTra,
									thang});
	}
	public void themVaoJtable_daThanhToan() {
		int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
		String hoTenChuNha = tfHoTenChuNha.getText();
		String soDienThoai = tfSoDienThoai.getText();
		String diaChi = tfDiaChi.getText();
		int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
		int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
		double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
		int thang = Integer.parseInt(tfThang.getText());
		
		DefaultTableModel model = (DefaultTableModel) tableTrangChu_daThanhToan.getModel();
		model.addRow(new Object[] {	maSoCongTo, 
									hoTenChuNha, 
									soDienThoai, 
									diaChi,  
									chiSoCu, 
									chiSoMoi, 
									soTienPhaiTra,
									thang});
	}
	public void themVaoCSDL_chuaThanhToan() {
		try {
			int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
			String hoTenChuNha = tfHoTenChuNha.getText();
			String soDienThoai = tfSoDienThoai.getText();
			String diaChi = tfDiaChi.getText();
			int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(tfThang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha + "", soDienThoai + "", diaChi + "", chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().insert(bienLai);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoCSDL_quanLy() {
		try {
			int maSoCongTo = Integer.parseInt(textField_MaSoCongTo.getText());
			String hoTenChuNha = textField_HotenChuNha.getText();
			String soDienThoai = textField_SoDienThoai.getText();
			String diaChi = textField_DiaChi.getText();
			int chiSoCu = Integer.parseInt(textField_ChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(textField_ChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(textField_Thang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().insert(bienLai);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void themVaoCSDL_daThanhToan() {
		try {
			int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
			String hoTenChuNha = tfHoTenChuNha.getText();
			String soDienThoai = tfSoDienThoai.getText();
			String diaChi = tfDiaChi.getText();
			int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(tfThang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha + "", soDienThoai + "", diaChi + "", chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiThanhToanDAO.getInstance().insert(bienLai);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void xoakhoiCSDL_daThanhToan() {
		try {
			int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
			String hoTenChuNha = tfHoTenChuNha.getText();
			String soDienThoai = tfSoDienThoai.getText();
			String diaChi = tfDiaChi.getText();
			int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(tfThang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha + "", soDienThoai + "", diaChi + "", chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiThanhToanDAO.getInstance().delete(bienLai);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void xoakhoiCSDL_chuaThanhToan() {
		try {
			int maSoCongTo = Integer.parseInt(tfMaSoCongTo.getText());
			String hoTenChuNha = tfHoTenChuNha.getText();
			String soDienThoai = tfSoDienThoai.getText();
			String diaChi = tfDiaChi.getText();
			int chiSoCu = Integer.parseInt(tfChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(tfChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(tfThang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().delete(bienLai);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void xoakhoiCSDL_quanLy() {
		try {
			int maSoCongTo = Integer.parseInt(textField_MaSoCongTo.getText());
			String hoTenChuNha = textField_HotenChuNha.getText();
			String soDienThoai = textField_SoDienThoai.getText();
			String diaChi = textField_DiaChi.getText();
			int chiSoCu = Integer.parseInt(textField_ChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(textField_ChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(textField_Thang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().delete(bienLai);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void suaCSDL_quanLy() {
		try {
			int maSoCongTo = Integer.parseInt(textField_MaSoCongTo.getText());
			String hoTenChuNha = textField_HotenChuNha.getText();
			String soDienThoai = textField_SoDienThoai.getText();
			String diaChi = textField_DiaChi.getText();
			int chiSoCu = Integer.parseInt(textField_ChiSoCu.getText());
			int chiSoMoi = Integer.parseInt(textField_ChiSoMoi.getText());
			double soTienPhaiTra = this.soTienPhaitra(chiSoCu, chiSoMoi);
			int thang = Integer.parseInt(textField_Thang.getText());
			
			BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			BienLaiDAO.getInstance().update(bienLai);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	public void loadDataToJTable_quanLy() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/quanlytiendien";
	    String user = "root";
	    String password = "";
	    String query = "SELECT * FROM bienlai";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("Mã Số Công Tơ", 0);
	      columns_name.setElementAt("Họ Tên chủ nhà", 1);
	      columns_name.setElementAt("Số điện Thoại", 2);
	      columns_name.setElementAt("Địa chỉ", 3);
	      columns_name.setElementAt("Chỉ Số cũ", 4);
	      columns_name.setElementAt("Chỉ số mới", 5);
	      columns_name.setElementAt("Số tiền phải trả", 6);
	      columns_name.setElementAt("Tháng", 7);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      tableQuanLy = new JTable(dtm);
	      tableQuanLy.setFont(new Font("Arial", Font.BOLD, 14));
	      tableTrangChu_chuaThanhToan = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	public void loadDataToJTable_daThanhToan() {
		Connection con = null;
	    String url = "jdbc:mysql://localhost:3306/quanlytiendien";
	    String user = "root";
	    String password = "";
	    String query = "SELECT * FROM bienlaithanhtoan";
	    try {
	      con = DriverManager.getConnection(url, user, password);
	      Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columns = rsmd.getColumnCount();
	      DefaultTableModel dtm = new DefaultTableModel();
	      Vector columns_name = new Vector();
	      Vector data_rows = new Vector();
	      for (int i = 1; i <= columns; i++) {
	        columns_name.addElement(rsmd.getColumnName(i));
	      }
	      columns_name.setElementAt("Mã Số Công Tơ", 0);
	      columns_name.setElementAt("Họ Tên chủ nhà", 1);
	      columns_name.setElementAt("Số điện Thoại", 2);
	      columns_name.setElementAt("Địa chỉ", 3);
	      columns_name.setElementAt("Chỉ Số cũ", 4);
	      columns_name.setElementAt("Chỉ số mới", 5);
	      columns_name.setElementAt("Số tiền phải trả", 6);
	      columns_name.setElementAt("Tháng", 7);
	      dtm.setColumnIdentifiers(columns_name);
	      while (rs.next()) {
	        data_rows = new Vector();
	        for (int j = 1; j <= columns; j++) {
	          data_rows.addElement(rs.getString(j));
	        }
	        dtm.addRow(data_rows);
	      }
	      tableTrangChu_daThanhToan = new JTable(dtm);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	}
	public void loadData() {
		this.loadDataToJTable_quanLy();
		this.loadDataToJTable_daThanhToan();
	}
	
	
	public void timKiemChuaThanhToan() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(tableTrangChu_chuaThanhToan.getModel());
		tableTrangChu_chuaThanhToan.setRowSorter(sorter1);

		TableRowSorter<TableModel> sorter2 = new TableRowSorter<>(tableTrangChu_daThanhToan.getModel());
		tableTrangChu_daThanhToan.setRowSorter(sorter2);
		
		String text = textField_timKiem.getText(); // Lấy từ khóa tìm kiếm từ JTextField
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter1.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		if (text.length() == 0) {
		    sorter2.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		} else {
		    sorter2.setRowFilter(RowFilter.regexFilter(text)); // Áp dụng bộ lọc với từ khóa tìm kiếm
		}
		
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		        sorter2.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});
	}
	
	public void huyTimChuaThanhToan() {
		TableRowSorter<TableModel> sorter1 = new TableRowSorter<>(tableTrangChu_chuaThanhToan.getModel());
		tableTrangChu_chuaThanhToan.setRowSorter(sorter1);

		TableRowSorter<TableModel> sorter2 = new TableRowSorter<>(tableTrangChu_daThanhToan.getModel());
		tableTrangChu_daThanhToan.setRowSorter(sorter2);
		
		String text = ""; // Xóa nội dung trong trường tìm kiếm
		if (text.length() == 0) {
		    sorter1.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		}if (text.length() == 0) {
		    sorter2.setRowFilter(null); // Nếu không có từ khóa tìm kiếm thì hiển thị toàn bộ dữ liệu
		}
		
		textField_timKiem.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        sortTable();
		    }

		    private void sortTable() {
		        sorter1.sort(); // Sắp xếp và lọc dữ liệu
		        sorter2.sort(); // Sắp xếp và lọc dữ liệu
		    }
		});

	}
	public double tongTienThang(int thang) {
	    double totalPrice = 0;
	    try {
	        // Kết nối tới cơ sở dữ liệu
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quanlytiendien", "root", "");

	        // Tạo đối tượng Statement và thực thi câu lệnh SQL
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT SUM(soTienPhaiTra) AS 'total_price' " +
	                                         "FROM bienlaithanhtoan " +
	                                         "WHERE thang = '"+ thang +"'");

	        // Truy xuất kết quả từ ResultSet
	        if (rs.next()) {
	            totalPrice = rs.getDouble("total_price");
//	            System.out.println("Tổng giá trị: " + totalPrice);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return totalPrice;
	}

}





