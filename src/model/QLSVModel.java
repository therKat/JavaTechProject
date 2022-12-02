package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<SinhVien> dsSinhVien;
	private String luaChon;
	private String tenFile;

	public QLSVModel() {
		this.dsSinhVien = new ArrayList<SinhVien>();
		this.luaChon = "";
		this.tenFile="";
	}

	public QLSVModel(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public void insert(SinhVien sinhVien) {
		this.dsSinhVien.add(sinhVien);
	}
	
	public void delete(SinhVien sinhVien) {
		int i = 0;
		for(SinhVien x : this.dsSinhVien) {
			
			if(x.getMaSinhVien() == sinhVien.getMaSinhVien()) {
				break;
			}
			i++;
		}
		this.dsSinhVien.remove(i);
	}
	
	public void update(SinhVien sinhVien) {
		for(SinhVien x : this.dsSinhVien) {
			if(x.getMaSinhVien() == sinhVien.getMaSinhVien()) {
				x.setTenSinhVien(sinhVien.getTenSinhVien());
				x.setQueQuan(sinhVien.getQueQuan());
				x.setNgaySinh(sinhVien.getNgaySinh());
				x.setGioiTinh(sinhVien.isGioiTinh());
				x.setDiemMon1(sinhVien.getDiemMon1());
				x.setDiemMon2(sinhVien.getDiemMon2());
				x.setDiemMon3(sinhVien.getDiemMon3());
				break;
			}
		}
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(SinhVien sv) {
		for(SinhVien SinhVien: dsSinhVien) {
			if(SinhVien.getMaSinhVien() == sv.getMaSinhVien())
				return true;
		}
		return false;
	}
	
	
}