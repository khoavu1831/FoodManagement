package views;

import controller.QuanLyNhanVien;
import controller.QuanLyPhieuXuat;
import controller.QuanLySanPham;

public class PhieuXuatView {
    private Menu menu;
    private QuanLyNhanVien quanLyNhanVien;
    private QuanLyPhieuXuat quanLyPhieuXuat;

    public PhieuXuatView(Menu menu, QuanLyNhanVien quanLyNhanVien, QuanLySanPham quanLySanPham) {
        this.menu = menu;
        this.quanLyNhanVien = quanLyNhanVien;
        this.quanLyPhieuXuat = new QuanLyPhieuXuat(quanLySanPham);
    }

    public void showPhieuXuatMenu() {
        quanLyPhieuXuat.taoPhieuXuat(quanLyNhanVien, menu, quanLyPhieuXuat);
    }

    public void showDanhSachPhieuXuat() {
        quanLyPhieuXuat.xuatDanhSachPhieuXuat(quanLyPhieuXuat);
    }
}
