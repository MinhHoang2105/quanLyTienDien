package model;

import java.util.ArrayList;

public class QuanLyBienLaiModel {
	private ArrayList<BienLaiModel> dsBienLai;

	public QuanLyBienLaiModel() {
		this.dsBienLai = new ArrayList<BienLaiModel>();
	}

	public QuanLyBienLaiModel(ArrayList<BienLaiModel> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}

	public ArrayList<BienLaiModel> getDsBienLai() {
		return dsBienLai;
	}

	public void setDsBienLai(ArrayList<BienLaiModel> dsBienLai) {
		this.dsBienLai = dsBienLai;
	}
	
}
