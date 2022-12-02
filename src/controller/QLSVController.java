package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.SinhVien;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements Action{
	public QLSVView view;
	
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienThemSinhVien();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(cm.equals("Cập nhật")) {
			this.view.hienThiThongTinSinhVienDaChon();
		}else if(cm.equals("Xóa")) {
			this.view.thucHienXoa();
		}else if(cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}
//  	Phần tìm kiếm
		else if(cm.equals("Tìm")) {
			this.view.thucHienTim();
		}else if(cm.equals("Hủy tìm")) {
			this.view.thucHienTaiLaiDuLieu();
		}
//		Xử lý ở thanh menu bar
		else if(cm.equals("About Me")) {
			this.view.hienThiAbout();
		}else if(cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if(cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
		else if(cm.equals("New")) {
			this.view.thucHienNew();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}