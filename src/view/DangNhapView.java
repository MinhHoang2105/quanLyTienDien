package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class DangNhapView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_taiKhoan;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
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
	public DangNhapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Đăng Nhập");
		this.setLocation(400, 200);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_DangNhap = new JLabel("Đăng Nhập");
		lb_DangNhap.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lb_DangNhap.setBounds(171, 10, 185, 54);
		contentPane.add(lb_DangNhap);
		
		JLabel lb_DangNhap_1 = new JLabel("Tài Khoản:");
		lb_DangNhap_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lb_DangNhap_1.setBounds(29, 92, 129, 39);
		contentPane.add(lb_DangNhap_1);
		
		JLabel lb_DangNhap_1_1 = new JLabel("Mật Khẩu:");
		lb_DangNhap_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lb_DangNhap_1_1.setBounds(29, 158, 142, 39);
		contentPane.add(lb_DangNhap_1_1);
		
		textField_taiKhoan = new JTextField();
		textField_taiKhoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_taiKhoan.setBounds(181, 92, 242, 39);
		contentPane.add(textField_taiKhoan);
		textField_taiKhoan.setColumns(10);
		
		JButton btn_dangNhap = new JButton("Đăng Nhập");
		btn_dangNhap.setBackground(SystemColor.info);
		btn_dangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_dangNhap.setBounds(213, 241, 166, 39);
		contentPane.add(btn_dangNhap);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBounds(181, 152, 242, 39);
		contentPane.add(passwordField);
		
		JToggleButton tglbtn_hienThi = new JToggleButton("Hiển Thị");
		tglbtn_hienThi.setBackground(SystemColor.info);
		tglbtn_hienThi.setFont(new Font("Tahoma", Font.BOLD, 15));
		tglbtn_hienThi.setBounds(444, 165, 107, 27);
		contentPane.add(tglbtn_hienThi);
		
		tglbtn_hienThi.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (tglbtn_hienThi.isSelected()) {
		            passwordField.setEchoChar((char) 0);
		        } else {
		            passwordField.setEchoChar('\u2022');
		        }
		    }
		});
		
		String username = "abc";
		String password = "123";

		btn_dangNhap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String inputUsername = textField_taiKhoan.getText();
		        String inputPassword = new String(passwordField.getPassword());

		        if (inputUsername.equals(username) && inputPassword.equals(password)) {
		            // Đăng nhập thành công
					BienLaiView frame = new BienLaiView();
		        } else {
		            // Đăng nhập không thành công
		            JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản hoặc mật khẩu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		this.setVisible(true);
	}
}
