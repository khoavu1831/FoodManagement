package views;

import java.util.Scanner;

import config.HandleDraw;
import controller.QuanLyNhanVien;

public class NhanVienView {
    Scanner sc = new Scanner(System.in);
    QuanLyNhanVien quanLyNhanVien;
    Menu menu;

    public NhanVienView(Menu menu, QuanLyNhanVien quanLyNhanVien) {
        this.menu = menu;
        this.quanLyNhanVien = quanLyNhanVien;
    }

    public void showNhanVienMenu() {        
        quanLyNhanVien.themNhanVien();
        HandleDraw.handleEndline(1);
        
        // In ra menu chao nhan vien
        String chaoNvString = "Xin chao, " + quanLyNhanVien.getTenNhanVien() + "!";
        HandleDraw.handleSystemTxt(chaoNvString);
    }
}
