package views;

import controller.QuanLyNhanVien;
import controller.QuanLyPhieuNhap;
import controller.QuanLySanPham;
import java.util.Scanner;

public class PhieuNhapView {
    Menu menu;
    Scanner sc = new Scanner(System.in);
    QuanLyPhieuNhap quanLyPhieuNhap = new QuanLyPhieuNhap();
    QuanLySanPham quanLySanPham = new QuanLySanPham();
    QuanLyNhanVien quanLyNhanVien;

    public PhieuNhapView(Menu menu, QuanLyNhanVien quanLyNhanVien) {
        this.menu = menu;
        this.quanLyNhanVien = quanLyNhanVien;
        this.quanLyPhieuNhap = new QuanLyPhieuNhap();
        this.quanLySanPham = new QuanLySanPham();
    }

    public void showTaoPhieuNhap() {
        String showNhapString = "        TAO PHIEU NHAP        ";
        menu.handleDrawBoard(showNhapString);
        menu.handleEndline(1);

        // Nhap thong tin phieu nhap
        quanLyPhieuNhap.taoPhieuNhap(quanLyNhanVien, menu, quanLyPhieuNhap);
    }

    public void showDanhSachPhieuNhap() {
        String showNhapString = "        DANH SACH PHIEU NHAP        ";
        menu.handleDrawBoard(showNhapString);
        menu.handleEndline(1);

        // In danh sach phieu nhap
        quanLyPhieuNhap.xuatDanhSachPhieuNhap(quanLyPhieuNhap, menu);
    }
}
