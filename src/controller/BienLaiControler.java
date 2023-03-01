package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.BienLaiDAO;
import view.BienLaiView;

public class BienLaiControler implements ActionListener {
	private BienLaiView bienLaiView;
	public BienLaiControler(BienLaiView bienLaiView) {
		this.bienLaiView = bienLaiView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String action = e.getActionCommand();
			if (action.equals("Thêm")) {
				this.bienLaiView.themVaoCSDL_quanLy();
				this.bienLaiView.themVaoJtable_quanLy();
				this.bienLaiView.xoaForm();
			} else if(action.equals("Xóa")) {
				this.bienLaiView.xoakhoiCSDL_quanLy();
				this.bienLaiView.xoaKhoiJtable_quanLy();
				this.bienLaiView.xoaForm();
			} else if(action.equals("Sửa")) {
				this.bienLaiView.xoakhoiCSDL_quanLy();
				this.bienLaiView.xoaKhoiJtable_quanLy();
				this.bienLaiView.themVaoCSDL_quanLy();
				this.bienLaiView.themVaoJtable_quanLy();
				this.bienLaiView.xoaForm();
			} else if(action.equals("Thanh Toán")) {
				this.bienLaiView.themVaoCSDL_daThanhToan();
				this.bienLaiView.themVaoJtable_daThanhToan();
				this.bienLaiView.xoakhoiCSDL_chuaThanhToan();
				this.bienLaiView.xoaKhoiJtable_chuaThanhToan();
				this.bienLaiView.xoaFormTrangChu();
			} else if(action.equals("Chưa Thanh Toán")) {
//				int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn thực hiện sự kiện này không?");
				int option = JOptionPane.showConfirmDialog(
					    null,
					    "Có phải hóa đơn này chưa thanh toán?",
					    "Hóa đơn chưa thanh toán",
					    JOptionPane.YES_NO_OPTION);
		        if (option == JOptionPane.OK_OPTION) {
		            // thực hiện sự kiện khi người dùng chọn OK
		        	this.bienLaiView.themVaoCSDL_chuaThanhToan();
					this.bienLaiView.themVaoJtable_chuaThanhToan();
					this.bienLaiView.xoakhoiCSDL_daThanhToan();
					this.bienLaiView.xoaKhoiJtable_daThanhToan();
					this.bienLaiView.xoaFormTrangChu();	
		        } else {
		            // không thực hiện sự kiện khi người dùng chọn Cancel
		        }
			} else if(action.equals("Tìm Kiếm")) {
				this.bienLaiView.timKiemChuaThanhToan();
			} else if(action.equals("Hủy Tìm")) {
				this.bienLaiView.huyTimChuaThanhToan();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
