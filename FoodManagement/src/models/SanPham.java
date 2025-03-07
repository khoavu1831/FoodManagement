package models;

public class SanPham {
    private String tenSanPham;
    private int soLuong;
    private double giaNhap;

    public SanPham(String tenSanPham, int soLuong, double giaNhap) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

}
