package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.PhieuNhap;
import models.SanPham;
import views.HandleDraw;
import views.Menu;

public class QuanLyPhieuNhap {
    Scanner sc = new Scanner(System.in);
    private List<PhieuNhap> danhSachPhieuNhap;

    public QuanLyPhieuNhap() {
        this.danhSachPhieuNhap = new ArrayList<>();
    }

    public void themPhieuNhap(PhieuNhap phieuNhap) {
        this.danhSachPhieuNhap.add(phieuNhap);
    }

    public void xoaPhieuNhap(String maPhieuNhap) {
        danhSachPhieuNhap.removeIf(phieuNhap -> phieuNhap.getMaPhieuNhap().equals(maPhieuNhap));
    }

    public List<PhieuNhap> getDanhSachPhieuNhap() {
        return danhSachPhieuNhap;
    }

    public void taoPhieuNhap(QuanLyNhanVien quanLyNhanVien, Menu menu, QuanLyPhieuNhap quanLyPhieuNhap) {
        // Nhap thong tin phieu nhap
        HandleDraw.handleReplyTxt("Nhap ma phieu nhap: ");
        String maPhieuNhap = sc.nextLine();
        HandleDraw.handleReplyTxt("Nhap ten nha cung cap: ");
        String tenNcc = sc.nextLine();
        String tenNv = quanLyNhanVien.getTenNhanVien();
        HandleDraw.handleReplyTxt("Nhan Vien nhap: " ); HandleDraw.handlePrint(tenNv, HandleDraw.WHITE);

        // Nhap danh sach san pham
        List<SanPham> danhSachSanPham = new ArrayList<>();
        boolean isNhapSanPham = true;
        while (isNhapSanPham) {
            HandleDraw.handleEndline(2);
            HandleDraw.handleSystemTxt("Nhap thong tin san pham");
            HandleDraw.handleReplyTxt("Nhap ten san pham: ");
            String tenSanPham = sc.nextLine();
            HandleDraw.handleReplyTxt("Nhap so luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());
            HandleDraw.handleReplyTxt("Nhap gia nhap: ");
            double giaNhap = Double.parseDouble(sc.nextLine());

            danhSachSanPham.add(new SanPham(tenSanPham, soLuong, giaNhap));

            HandleDraw.handleReplyTxt("Ban co muon nhap san pham khac khong? (y/n): ");
            String chon = sc.nextLine();
            isNhapSanPham = chon.equals("y") ? true : false;
        }

        // Tao phieu nhap va them vao danh sach
        PhieuNhap phieuNhap = new PhieuNhap(maPhieuNhap, tenNcc, tenNv, danhSachSanPham);
        quanLyPhieuNhap.themPhieuNhap(phieuNhap);
        HandleDraw.handleSystemTxt("Da tao phieu nhap thanh cong!");
    }

    public void xuatDanhSachPhieuNhap(QuanLyPhieuNhap quanLyPhieuNhap, Menu menu) {
        if (quanLyPhieuNhap.getDanhSachPhieuNhap().size() == 0) {
            HandleDraw.handleSystemTxt("Danh sach phieu nhap rong!");
            return;
        }

        quanLyPhieuNhap.getDanhSachPhieuNhap().forEach(phieuNhap -> {
            System.out.println("Ma phieu nhap: " + phieuNhap.getMaPhieuNhap());
            System.out.println("Nha cung cap: " + phieuNhap.getTenNhaCungCap());
            System.out.println("Nhan vien nhap: " + phieuNhap.getTenNhanVienNhap());
            System.out.println("Danh sach san pham: ");
            phieuNhap.getDanhSachSanPham().forEach(sanPham -> {
                System.out.println("     Ten san pham: " + sanPham.getTenSanPham());
                System.out.println("     So luong: " + sanPham.getSoLuong());
                System.out.println("     Gia nhap: " + sanPham.getGiaNhap());
                System.out.println("     Thanh tien cua San pham: " + sanPham.getTenSanPham() + " = " + sanPham.getGiaNhap() * sanPham.getSoLuong());
            });
            System.out.println("Tong tien: " + phieuNhap.tongTien());
            System.out.println("----------------------");
            HandleDraw.handleEndline(1);
        });
    }

    public void xoaDanhSachPhieuNhap(QuanLyPhieuNhap quanLyPhieuNhap, Menu menu) {
        HandleDraw.handleEndline(1);
        HandleDraw.handleReplyTxt("Nhap ma phieu nhap can xoa: ");
        String maPhieuNhap = sc.nextLine();
        if (quanLyPhieuNhap.getDanhSachPhieuNhap().stream().noneMatch(phieuNhap -> phieuNhap.getMaPhieuNhap().equals(maPhieuNhap))) {
            HandleDraw.handleSystemTxt("Khong tim thay phieu nhap!");
            return;
        }
        quanLyPhieuNhap.xoaPhieuNhap(maPhieuNhap);
        HandleDraw.handleSystemTxt("Da xoa phieu nhap thanh cong!");
    }


}
