package views;

import controller.QuanLySanPham;

public class SanPhamView {
    private Menu menu;
    private QuanLySanPham quanLySanPham;

    public SanPhamView(Menu menu, QuanLySanPham quanLySanPham) {
        this.menu = menu;
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