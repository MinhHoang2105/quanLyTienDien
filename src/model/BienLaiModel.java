package model;

import java.util.Objects;

public class BienLaiModel {
	private int maSoCongTo;
	private String hoTenChuNha, soDienThoai, diaChi;
	private int chiSoCu, chiSoMoi;
	private double soTienPhaiTra;
	private int thang;
	
	public BienLaiModel() {
		super();
	}

	public BienLaiModel(int maSoCongTo, String hoTenChuNha, String soDienThoai, String diaChi, int chiSoCu, int chiSoMoi,
			double soTienPhaiTra, int thang) {
		super();
		this.maSoCongTo = maSoCongTo;
		this.hoTenChuNha = hoTenChuNha;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.soTienPhaiTra = soTienPhaiTra;
		this.thang = thang;
	}

	public int getMaSoCongTo() {
		return maSoCongTo;
	}

	public void setMaSoCongTo(int maSoCongTo) {
		this.maSoCongTo = maSoCongTo;
	}

	public String getHoTenChuNha() {
		return hoTenChuNha;
	}

	public void setHoTenChuNha(String hoTenChuNha) {
		this.hoTenChuNha = hoTenChuNha;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public double getSoTienPhaiTra() {
		return soTienPhaiTra;
	}

	public void setSoTienPhaiTra(double soTienPhaiTra) {
		this.soTienPhaiTra = soTienPhaiTra;
	}
	public double soTienPhaitra() {
		int tieuThu = this.chiSoMoi - this.chiSoCu;
		if (tieuThu <= 50) {
			return tieuThu * 450;
		} else {
			return (50 * 450) + ((tieuThu - 50) * 800);
		}
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chiSoCu, chiSoMoi, diaChi, hoTenChuNha, maSoCongTo, soDienThoai, soTienPhaiTra, thang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BienLaiModel other = (BienLaiModel) obj;
		return chiSoCu == other.chiSoCu && chiSoMoi == other.chiSoMoi && Objects.equals(diaChi, other.diaChi)
				&& Objects.equals(hoTenChuNha, other.hoTenChuNha) && maSoCongTo == other.maSoCongTo
				&& Objects.equals(soDienThoai, other.soDienThoai)
				&& Double.doubleToLongBits(soTienPhaiTra) == Double.doubleToLongBits(other.soTienPhaiTra)
				&& thang == other.thang;
	}

	@Override
	public String toString() {
		return "BienLai [maSoCongTo=" + maSoCongTo + ", hoTenChuNha=" + hoTenChuNha + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", soTienPhaiTra="
				+ soTienPhaiTra + ", thang=" + thang + "]";
	}
	
	
}
