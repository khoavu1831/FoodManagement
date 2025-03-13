package controller;

import java.util.List;

import config.HandleDraw;
import models.PhieuNhap;
import models.PhieuXuat;
import models.ThongKe;

public class QuanLyThongKe {
    QuanLyPhieuNhap quanLyPhieuNhap;
    QuanLyPhieuXuat quanLyPhieuXuat;
    private Double tongTienNhap = 0.0;
    private Double tongTienXuat = 0.0;
    private ThongKe thongKe;

    public QuanLyThongKe(QuanLyPhieuNhap quanLyPhieuNhap, QuanLyPhieuXuat quanLyPhieuXuat) {
        this.quanLyPhieuNhap = quanLyPhieuNhap;
        this.quanLyPhieuXuat = quanLyPhieuXuat;
        this.thongKe = new ThongKe(0.0);
        tinhTongTienNhap();
        tinhTongTienXuat();
        tinhLoiNhuan();
    }

    public Double getTongTienNhap() {
        return tongTienNhap;
    }

    public Double getTongTienXuat() {
        return tongTienXuat;
    }

    public void tinhTongTienNhap() {
        if (quanLyPhieuNhap == null) {
            System.err.println("Warning: quanLyPhieuNhap is null, cannot calculate tongTienNhap.");
            tongTienNhap = 0.0;
            return;
        }
        List<PhieuNhap> danhSachPhieuNhap = quanLyPhieuNhap.getDanhSachPhieuNhap();
        if (danhSachPhieuNhap == null) {
            System.err.println("Warning: danhSachPhieuNhap is null.");
            tongTienNhap = 0.0;
            return;
        }
        tongTienNhap = 0.0;
        for (PhieuNhap phieuNhap : danhSachPhieuNhap) {
            tongTienNhap += phieuNhap.tongTien();
        }
    }

    public void tinhTongTienXuat() {
        if (quanLyPhieuXuat == null) {
            System.err.println("Warning: quanLyPhieuXuat is null, cannot calculate tongTienXuat.");
            tongTienXuat = 0.0;
            return;
        }
        List<PhieuXuat> danhSachPhieuXuat = quanLyPhieuXuat.getDanhSachPhieuXuat();
        if (danhSachPhieuXuat == null) {
            System.err.println("Warning: danhSachPhieuXuat is null.");
            tongTienXuat = 0.0;
            return;
        }
        tongTienXuat = 0.0;
        for (PhieuXuat phieuXuat : danhSachPhieuXuat) {
            tongTienXuat += phieuXuat.tongTien();
        }
    }

    public void tinhLoiNhuan() {
        Double loiNhuan = tongTienXuat - tongTienNhap;
        thongKe = new ThongKe(loiNhuan);
    }

    public void xuatThongKe() {
        String xuatMenuString = "        BAO CAO TAI CHINH        ";
        HandleDraw.handleDrawBoard(xuatMenuString, HandleDraw.TITLE_TXT);
        HandleDraw.handleTitleList("Tong tien nhap:", String.format("%.2f", tongTienNhap));
        HandleDraw.handleTitleList("Tong tien xuat:", String.format("%.2f", tongTienXuat));
        String loiNhuanStr = String.format("%.2f", thongKe.getLoiNhuan());
        String color = thongKe.getLoiNhuan() >= 0 ? HandleDraw.GREEN : HandleDraw.RED;
        HandleDraw.handlePrint("+ Loi nhuan:", HandleDraw.PURPLE);
        HandleDraw.handlePrintln(loiNhuanStr, color);
        HandleDraw.handlePrintln("----------------------------------", "");
    }

    // Thêm getter để lấy ThongKe
    public ThongKe getThongKe() {
        return thongKe;
    }
}