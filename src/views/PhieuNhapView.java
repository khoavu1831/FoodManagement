package views;

import controller.QuanLyNhanVien;
import controller.QuanLyPhieuNhap;
import controller.QuanLySanPham;

public class PhieuNhapView {
    private Menu menu;
    private QuanLyNhanVien quanLyNhanVien;
    private QuanLyPhieuNhap quanLyPhieuNhap;
    private QuanLySanPham quanLySanPham;

    public PhieuNhapView(Menu menu, QuanLyNhanVien quanLyNhanVien, QuanLySanPham quanLySanPham) {
        this.menu = menu;
        this.quanLyNhanVien = quanLyNhanVien;
        this.quanLyPhieuNhap = new QuanLyPhieuNhap(quanLySanPham);
        this.quanLySanPham = quanLySanPham;
    }

    public void showTaoPhieuNhap() {
        quanLyPhieuNhap.taoPhieuNhap(quanLyNhanVien, menu, quanLyPhieuNhap);
    }

    public void showDanhSachPhieuNhap() {
        quanLyPhieuNhap.xuatDanhSachPhieuNhap(quanLyPhieuNhap, menu);
    }

    public void showXoaPhieuNhap() {
        quanLyPhieuNhap.xoaDanhSachPhieuNhap(quanLyPhieuNhap, menu);
    }
}