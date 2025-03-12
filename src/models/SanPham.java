package models;

public class SanPham {
    private String tenSanPham;
    private int soLuongNhap;
    private int soLuongXuat;
    private double giaNhap;
    private double giaBan;

    public SanPham(String tenSanPham, int soLuongNhap, double giaNhap) {
        this.tenSanPham = tenSanPham;
        this.soLuongNhap = soLuongNhap;
        this.giaNhap = giaNhap;
        this.soLuongXuat = 0;
        this.giaBan = 0;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }
}