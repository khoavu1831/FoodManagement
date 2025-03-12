package views;

import controller.QuanLyNhanVien;
import controller.QuanLyPhieuNhap;
import controller.QuanLySanPham;

public class PhieuNhapView {
    private QuanLyNhanVien quanLyNhanVien;
    private QuanLyPhieuNhap quanLyPhieuNhap;

    public PhieuNhapView(QuanLyNhanVien quanLyNhanVien, QuanLySanPham quanLySanPham) {
        this.quanLyNhanVien = quanLyNhanVien;
        this.quanLyPhieuNhap = new QuanLyPhieuNhap(quanLySanPham);
    }

    public void showTaoPhieuNhap() {
        quanLyPhieuNhap.taoPhieuNhap(quanLyNhanVien, quanLyPhieuNhap);
    }

    public void showDanhSachPhieuNhap() {
        quanLyPhieuNhap.xuatDanhSachPhieuNhap(quanLyPhieuNhap);
    }

    public void showXoaPhieuNhap() {
        quanLyPhieuNhap.xoaDanhSachPhieuNhap(quanLyPhieuNhap);
    }
}