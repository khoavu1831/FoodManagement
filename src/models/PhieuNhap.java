package models;

import java.util.List;

public class PhieuNhap {
    private String maPhieuNhap;
    private String tenNhaCungCap;
    private String tenNhanVienNhap;
    private List<SanPham> danhSachSanPham;

    public PhieuNhap(String maPhieuNhap, String tenNhaCungCap, String tenNhanVienNhap, List<SanPham> danhSachSanPham) {
        this.maPhieuNhap = maPhieuNhap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.tenNhanVienNhap = tenNhanVienNhap;
        this.danhSachSanPham = danhSachSanPham;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public String getTenNhanVienNhap() {
        return tenNhanVienNhap;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public double tongTien() {
        double tongTien = 0;
        for (SanPham sanPham : danhSachSanPham) {
            tongTien += sanPham.getGiaNhap() * sanPham.getSoLuongNhap();
        }
        return tongTien;
    }
}
