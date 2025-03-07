package views;

import java.util.Scanner;
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
        
        // In ra menu chao nhan vien
        menu.handleEndline(1);
        String chaoNvString = " Xin chao, " + quanLyNhanVien.getTenNhanVien() + "! ";
        menu.handleDrawBoard(chaoNvString);
        menu.handleEndline(1);
    }
}
