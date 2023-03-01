package test;

import java.util.ArrayList;

import dao.BienLaiDAO;
import model.BienLaiModel;

public class testBienLaiDAO {
	public static void main(String[] args) {
		BienLaiModel bl1 = new BienLaiModel(1, "Hoang Van Minh", "0772447726", "Dak Nong", 123, 284, 88000, 1); 
		BienLaiModel bl2 = new BienLaiModel(2, "Hua Quang Thanh","0734447726", "Dak Nong", 234, 384, 69000, 2); 
		BienLaiModel bl3 = new BienLaiModel(3, "Nguyen Duc Thao","0772447566", "Quang Tri", 153, 284, 99000, 12); 
		BienLaiModel bl4 = new BienLaiModel(4, "Le Quoc Trieu","0772237726", "Quang Ngai", 129, 134, 77000, 13); 
		
//		BienLaiDAO.getInstance().insert(bl4);
		
		BienLaiDAO.getInstance().update(bl1);
		BienLaiDAO.getInstance().update(bl2);
		BienLaiDAO.getInstance().update(bl3);
		BienLaiDAO.getInstance().update(bl4);

//		BienLaiDAO.getInstance().delete(bl1);
		
//		
		ArrayList<BienLaiModel> ds = BienLaiDAO.getInstance().selectAll();
		for (BienLaiModel bienLai : ds) {
			System.out.println(bienLai.toString());
		}
//		System.out.println("=======================");
//		
//		BienLai bl = new BienLai();
//		bl.setMaSoCongTo(3);
//		BienLai bl2 = BienLaiDAO.getInstance().selectById(bl);
//		System.out.println(bl2.toString());
//		
//		System.out.println("=======================");
//		
//
//		ArrayList<BienLai> ds2 = BienLaiDAO.getInstance().selectByCondition("soTienPhaiTra < 99000");
//		for (BienLai bienLai : ds2) {
//			System.out.println(bienLai.toString());
//		}
	}
}
