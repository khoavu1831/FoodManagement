package controller;

import java.util.Scanner;

import views.HandleDraw;

// Tam thoi bo qua models.NhanVien
public class QuanLyNhanVien {
    Scanner sc = new Scanner(System.in);

    private String tenNv;

    public void themNhanVien() {
        HandleDraw.handlePrint(">Nhap ten nhan vien: ", HandleDraw.REPLY_TXT);
        tenNv = sc.nextLine();
    }

    public String getTenNhanVien() {
        return tenNv;
    }
}
