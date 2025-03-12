package views;

import controller.QuanLyNhanVien;
import controller.QuanLyPhieuXuat;
import controller.QuanLySanPham;

public class PhieuXuatView {
    private QuanLyNhanVien quanLyNhanVien;
    private QuanLyPhieuXuat quanLyPhieuXuat;

    public PhieuXuatView(QuanLyNhanVien quanLyNhanVien, QuanLySanPham quanLySanPham) {
        this.quanLyNhanVien = quanLyNhanVien;
        this.quanLyPhieuXuat = new QuanLyPhieuXuat(quanLySanPham);
    }

    public void showPhieuXuatMenu() {
        quanLyPhieuXuat.taoPhieuXuat(quanLyNhanVien, quanLyPhieuXuat);
    }

    public void showDanhSachPhieuXuat() {
        quanLyPhieuXuat.xuatDanhSachPhieuXuat(quanLyPhieuXuat);
    }
}
