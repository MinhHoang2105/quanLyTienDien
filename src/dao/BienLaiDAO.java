package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import database.JDBCUtil;
import model.BienLaiModel;

public class BienLaiDAO implements DAOInterface<BienLaiModel> {
	public static BienLaiDAO getInstance() {
		return new BienLaiDAO();
	}

	@Override
	public int insert(BienLaiModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO bienlai (maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang) "+
						" VALUES ('"+t.getMaSoCongTo()+"' "
								+ ", '"+t.getHoTenChuNha()+"' "
								+ ", '"+t.getSoDienThoai()+"' "
								+ ", '"+t.getDiaChi()+"' "
								+ ", '"+t.getChiSoCu()+"' "
								+ ", '"+t.getChiSoMoi()+"' "
								+ ", '"+t.getSoTienPhaiTra()+"' "
								+ ", '"+t.getThang()+"')";

			ketQua = st.executeUpdate(sql);
			
			// Bước 4:  sử lí kết quả đầu ra
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5: ngắt kết nối với CSDL
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

//	@Override
//	public void update(BienLaiModel t) {
//		this.delete(t);
//		this.insert(t);
//		int ketQua = 0;
//		try {
//			// Bước 1: tạo kết nối đến CSDL
//			Connection con = JDBCUtil.getConnection();
//			
//			// Bước 2: tạo ra đối tượng statement
//			Statement st = con.createStatement();
//			
//			// Bước 3: thực thi câu lệnh SQL
//			
//			String sql = "UPDATE bienlai "+
//						 " SET " +
//						 " hoTenChuNha='"+ t.getHoTenChuNha()+"'"
//						 +", chiSoCu='"+ t.getChiSoCu()+"'"
//		 				 +", soDienThoai='"+ t.getSoDienThoai()+"'"
//		 				 +", diaChi='"+ t.getDiaChi()+"'"
//						 +", chiSoMoi='"+ t.getChiSoMoi()+ "'"
//						 +", SoTienPhaiTra='"+ t.getSoTienPhaiTra()+ "'"
//						 +", SoTienPhaiTra='"+ t.getThang()+ "'"
//						 +" WHERE maSoCongTo='"+t.getMaSoCongTo()+"\'";
//			
//			System.out.println(sql);
//			ketQua = st.executeUpdate(sql);
//			
//			// Bước 4:
//			System.out.println("Bạn đã thực thi: "+ sql);
//			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
//			
//			// Bước 5:
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return ketQua;
//	}
	@Override
	public int update(BienLaiModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE bienlai "+
						 " SET " +
						 " hoTenChuNha='"+ t.getHoTenChuNha()+"'"
						 +", chiSoCu='"+ t.getChiSoCu()+"'"
		 				 +", soDienThoai='"+ t.getSoDienThoai()+"'"
		 				 +", diaChi='"+ t.getDiaChi()+"'"
						 +", chiSoMoi='"+ t.getChiSoMoi()+ "'"
						 +", SoTienPhaiTra='"+ t.getSoTienPhaiTra()+ "'"
						 +", SoTienPhaiTra='"+ t.getThang()+ "'"
						 +" WHERE maSoCongTo='"+t.getMaSoCongTo()+"\'";
			
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	@Override
	public int delete(BienLaiModel t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from bienlai " + "WHERE maSoCongTo = '" + t.getMaSoCongTo() + "'" + " AND thang = '" + t.getThang() + "'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<BienLaiModel> selectAll() {
		ArrayList<BienLaiModel> ketQua = new ArrayList<BienLaiModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM bienlai";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maSoCongTo = rs.getInt("maSoCongTo");
				String hoTenChuNha = rs.getString("hoTenChuNha");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int chiSoCu = rs.getInt("chiSoCu");
				int chiSoMoi = rs.getInt("chiSoMoi");
				double soTienPhaiTra = rs.getDouble("SoTienPhaiTra");
				int thang = rs.getInt("thang");
				
				BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
				ketQua.add(bienLai);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public BienLaiModel selectById(BienLaiModel t) {
		BienLaiModel ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM bienlai WHERE maSoCongTo = '" + t.getMaSoCongTo() + "'";
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maSoCongTo = rs.getInt("maSoCongTo");
				String hoTenChuNha = rs.getString("hoTenChuNha");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int chiSoCu = rs.getInt("chiSoCu");
				int chiSoMoi = rs.getInt("chiSoMoi");
				double soTienPhaiTra = rs.getDouble("SoTienPhaiTra");
				int thang = rs.getInt("thang");
				
				ketQua = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<BienLaiModel> selectByCondition(String condition) {
		ArrayList<BienLaiModel> ketQua = new ArrayList<BienLaiModel>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM bienlai WHERE " + condition;
			
			System.out.println(sql);
			ResultSet rs  = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int maSoCongTo = rs.getInt("maSoCongTo");
				String hoTenChuNha = rs.getString("hoTenChuNha");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChi = rs.getString("diaChi");
				int chiSoCu = rs.getInt("chiSoCu");
				int chiSoMoi = rs.getInt("chiSoMoi");
				double soTienPhaiTra = rs.getDouble("SoTienPhaiTra");
				int thang = rs.getInt("thang");
				
				BienLaiModel bienLai = new BienLaiModel(maSoCongTo, hoTenChuNha, soDienThoai, diaChi, chiSoCu, chiSoMoi, soTienPhaiTra, thang);
				ketQua.add(bienLai);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
