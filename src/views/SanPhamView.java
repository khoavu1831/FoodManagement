package views;

import controller.QuanLySanPham;

public class SanPhamView {
    private QuanLySanPham quanLySanPham;

    public SanPhamView(QuanLySanPham quanLySanPham) {
        this.quanLySanPham = quanLySanPham;
    }

    public void showDanhSachSanPham() {
        quanLySanPham.xemDanhSachSanPham();
    }

    public void showSuaSanPham() {
        quanLySanPham.suaSanPham();
    }

    public void showXoaSanPham() {
        quanLySanPham.xoaSanPham();
    }
}