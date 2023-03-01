package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomeView extends JFrame {
	private JButton jButton_home;
	private JButton jButton_addCus;
	private JButton jButton_cusMana;
	private JButton jButton_statistical;
	private JButton jButton_unSubmitted;
	private JButton jButton_submitted;
	private JButton jButton_search;
	private JButton jButton_invoice_Printing;
	private JTextField jTextField_center;
	private JTextField jTextField_search;
	
	public HomeView(){
		this.Init();
		this.setVisible(true);
	}

	private void Init() {
		this.setTitle("Home");
		this.setLocation(200, 100);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		thanh cửa sổ phía trên
		jButton_home = new JButton("Home");
		jButton_addCus = new JButton("Add customer");
		jButton_cusMana = new JButton("Customer management");
		jButton_statistical = new JButton("Statistical");
		JPanel jPanel_north = new JPanel();
		jPanel_north.setLayout(new GridLayout(1, 4, 2, 50));
		jPanel_north.add(jButton_home);
		jPanel_north.add(jButton_addCus);
		jPanel_north.add(jButton_cusMana);
		jPanel_north.add(jButton_statistical);
		
		
//		nút hiển thị nộp tiền và chưa nộp tiền
		jButton_unSubmitted = new JButton("Unsubmitted");
		jButton_submitted = new JButton("Submitted");
		JPanel jPanel_east = new JPanel();
		jPanel_east.setLayout(new FlowLayout());
		jPanel_east.add(jButton_unSubmitted);
		jPanel_east.add(jButton_submitted);
		
		
//		tìm kiếm và in hóa đơn
		jButton_search = new JButton("Search");
		jTextField_search = new JTextField();
		jButton_invoice_Printing = new JButton("Invoice Printing");
		JPanel jPanel_south = new JPanel();
		jPanel_south.setLayout(new GridLayout(1, 3));
		jPanel_south.add(jButton_search);
		jPanel_south.add(jTextField_search);
		jPanel_south.add(jButton_invoice_Printing);
		
//		bảng dữ liệu ở giữa 
		jTextField_center = new JTextField();
		
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_north, BorderLayout.NORTH);
		this.add(jPanel_east, BorderLayout.EAST);
		this.add(jPanel_south, BorderLayout.SOUTH);
		this.add(jTextField_center, BorderLayout.CENTER);
		
	}
	
}































