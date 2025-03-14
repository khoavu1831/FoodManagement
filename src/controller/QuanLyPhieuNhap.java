package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.FileHandler;
import config.HandleDraw;
import config.Logic;
import models.PhieuNhap;
import models.SanPham;

public class QuanLyPhieuNhap {
    Scanner sc = new Scanner(System.in);
    private List<PhieuNhap> danhSachPhieuNhap;
    private QuanLySanPham quanLySanPham;

    public QuanLyPhieuNhap(QuanLySanPham quanLySanPham) {
        this.quanLySanPham = quanLySanPham;
        this.danhSachPhieuNhap = FileHandler.readPhieuNhap();
    }

    public void themPhieuNhap(PhieuNhap phieuNhap) {
        this.danhSachPhieuNhap.add(phieuNhap);
        FileHandler.writePhieuNhap(danhSachPhieuNhap);
    }

    public void xoaPhieuNhap(String maPhieuNhap) {
        danhSachPhieuNhap.removeIf(phieuNhap -> phieuNhap.getMaPhieuNhap().equals(maPhieuNhap));
        FileHandler.writePhieuNhap(danhSachPhieuNhap);
    }

    public List<PhieuNhap> getDanhSachPhieuNhap() {
        return danhSachPhieuNhap;
    }

    public void taoPhieuNhap(QuanLyNhanVien quanLyNhanVien, QuanLyPhieuNhap quanLyPhieuNhap) {
        HandleDraw.handleReplyTxt("Ma phieu nhap");
        String maPhieuNhap = Logic.autoCreateID("PN", danhSachPhieuNhap);
        HandleDraw.handlePrintln(maPhieuNhap, HandleDraw.GREEN);
        HandleDraw.handleReplyTxt("Nhap ten nha cung cap");
        String tenNcc = sc.nextLine().trim();
        String tenNv = quanLyNhanVien.getTenNhanVien();
        HandleDraw.handleReplyTxt("Nhan Vien nhap: ");
        HandleDraw.handlePrint(tenNv, HandleDraw.WHITE);
    
        List<SanPham> danhSachSanPham = new ArrayList<>();
        boolean isNhapSanPham = true;
        while (isNhapSanPham) {
            HandleDraw.handleEndline(2);
            HandleDraw.handleSystemTxt("Nhap thong tin san pham");
            HandleDraw.handleReplyTxt("Nhap ten san pham");
            String tenSanPham = sc.nextLine();
            HandleDraw.handleReplyTxt("Nhap so luong");
            int soLuong = Integer.parseInt(sc.nextLine());
            HandleDraw.handleReplyTxt("Nhap gia nhap");
            double giaNhap = Double.parseDouble(sc.nextLine());
    
            SanPham sanPham = new SanPham(tenSanPham, soLuong, giaNhap);
    
            // Luu san pham vao danh sach san pham cua phieu nhap
            danhSachSanPham.add(sanPham);
    
            // Them san pham vao danh sach san pham tong trong QuanLySanPham
            quanLySanPham.themSanPham(sanPham);
    
            HandleDraw.handleReplyTxt("Ban co muon nhap san pham khac khong? (y/n)");
            String chon = sc.nextLine();
            isNhapSanPham = chon.equalsIgnoreCase("y");
        }
    
        PhieuNhap phieuNhap = new PhieuNhap(maPhieuNhap, tenNcc, tenNv, danhSachSanPham);
        quanLyPhieuNhap.themPhieuNhap(phieuNhap);
    
        // Sau khi tao phieu nhap, ghi lai san pham tong vao file
        FileHandler.writeSanPham(quanLySanPham.getDanhSachSanPham());
    
        HandleDraw.handleSystemTxt("Da tao phieu nhap thanh cong!");
    }

    public void xuatDanhSachPhieuNhap(QuanLyPhieuNhap quanLyPhieuNhap) {
        if (quanLyPhieuNhap.getDanhSachPhieuNhap().isEmpty()) {
            HandleDraw.handleSystemTxt("Danh sach phieu nhap rong!");
            return;
        }
        HandleDraw.handleTitleYellowTxt("Danh sach phieu nhap", 6);
        quanLyPhieuNhap.getDanhSachPhieuNhap().forEach(phieuNhap -> {
            HandleDraw.handleTitleList("Ma phieu nhap:", phieuNhap.getMaPhieuNhap());
            HandleDraw.handleTitleList("Nha cung cap:", phieuNhap.getTenNhaCungCap());
            HandleDraw.handleTitleList("Nhan vien nhap:", phieuNhap.getTenNhanVienNhap());
            HandleDraw.handleTitleList("Danh sach san pham:", "");
            phieuNhap.getDanhSachSanPham().forEach(sanPham -> {
                HandleDraw.handleChildTitleList("Ten san pham: ", sanPham.getTenSanPham());
                HandleDraw.handleChildTitleList("So luong: ", String.valueOf(sanPham.getSoLuongNhap()));
                HandleDraw.handleChildTitleList("Gia nhap: ", String.valueOf(sanPham.getGiaNhap()));
                HandleDraw.handleChildTitleList("Thanh tien = ",
                        String.format("%.2f", sanPham.getGiaNhap() * sanPham.getSoLuongNhap()));
                HandleDraw.handlePrintln("     ----------------------", "");
            });
            HandleDraw.handleTitleList("Tong tien:", String.valueOf(phieuNhap.tongTien()));
            HandleDraw.handlePrintln("----------------------------------", "");
            HandleDraw.handleEndline(1);
        });
    }

    public void xoaDanhSachPhieuNhap(QuanLyPhieuNhap quanLyPhieuNhap) {
        HandleDraw.handleEndline(1);
        HandleDraw.handleReplyTxt("Nhap ma phieu nhap can xoa");
        String maPhieuNhap = sc.nextLine();
        if (quanLyPhieuNhap.getDanhSachPhieuNhap().stream()
                .noneMatch(phieuNhap -> phieuNhap.getMaPhieuNhap().equals(maPhieuNhap))) {
            HandleDraw.handleSystemTxt("Khong tim thay phieu nhap!");
            return;
        }
        quanLyPhieuNhap.xoaPhieuNhap(maPhieuNhap);
        HandleDraw.handleSystemTxt("Da xoa phieu nhap thanh cong!");
    }
}