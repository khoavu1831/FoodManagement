package models;

import java.util.List;

public class PhieuXuat implements Interface{
    private String maPhieuXuat;
    private String tenNhanVienXuat;
    private List<SanPham> danhSachSanPham;

    public PhieuXuat(String maPhieuXuat, String tenNhanVienXuat, List<SanPham> danhSachSanPham) {
        this.maPhieuXuat = maPhieuXuat;
        this.tenNhanVienXuat = tenNhanVienXuat;
        this.danhSachSanPham = danhSachSanPham;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getTenNhanVienXuat() {
        return tenNhanVienXuat;
    }

    public void setTenNhanVienXuat(String tenNhanVienXuat) {
        this.tenNhanVienXuat = tenNhanVienXuat;
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public double TongTien() {
        double tongTien = 0;
        for (SanPham sanPham : danhSachSanPham) {
            tongTien += sanPham.getGiaBan() * sanPham.getSoLuongXuat();
        }
        return tongTien;
    }

    @Override
    public String getId() {
        return maPhieuXuat;
    }

}
