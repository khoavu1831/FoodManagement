package models;

public class NhanVien {
    private String tenNv;

    public NhanVien() {
    }

    public NhanVien(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }
}