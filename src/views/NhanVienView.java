package views;

import config.HandleDraw;
import controller.QuanLyNhanVien;

public class NhanVienView {
    QuanLyNhanVien quanLyNhanVien;

    public NhanVienView(QuanLyNhanVien quanLyNhanVien) {
        this.quanLyNhanVien = quanLyNhanVien;
    }

    public void showNhanVienMenu() {        
        quanLyNhanVien.themNhanVien();
        HandleDraw.handleEndline(1);
        HandleDraw.handleSystemTxt( "Xin chao, " + quanLyNhanVien.getTenNhanVien() + "!");
    }
}
