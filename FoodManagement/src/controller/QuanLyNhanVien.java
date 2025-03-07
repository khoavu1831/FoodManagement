package controller;

import java.util.Scanner;

// Tam thoi bo qua models.NhanVien
public class QuanLyNhanVien {
    Scanner sc = new Scanner(System.in);

    private String tenNv;

    public void themNhanVien() {
        System.out.print(">Nhap ten nhan vien: ");
        tenNv = sc.nextLine();
    }

    public String getTenNhanVien() {
        return tenNv;
    }
}
