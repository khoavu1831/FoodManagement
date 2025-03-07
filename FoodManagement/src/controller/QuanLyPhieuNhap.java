package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.PhieuNhap;
import models.SanPham;
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

    public List<PhieuNhap> getDanhSachPhieuNhap() {
        return danhSachPhieuNhap;
    }

    public void taoPhieuNhap(QuanLyNhanVien quanLyNhanVien, Menu menu, QuanLyPhieuNhap quanLyPhieuNhap) {
        // Nhap thong tin phieu nhap
        System.out.print(">Nhap ma phieu nhap: ");
        String maPhieuNhap = sc.nextLine();
        System.out.print(">Nhap ten nha cung cap: ");
        String tenNcc = sc.nextLine();
        String tenNv = quanLyNhanVien.getTenNhanVien();
        System.out.print(">Nhan vien nhap: " + tenNv);

        // Nhap danh sach san pham
        List<SanPham> danhSachSanPham = new ArrayList<>();
        boolean isNhapSanPham = true;
        while (isNhapSanPham) {
            menu.handleEndline(2);
            System.out.println("     <Nhap thong tin san pham>");
            System.out.print(">Nhap ten san pham: ");
            String tenSanPham = sc.nextLine();
            System.out.print(">Nhap so luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());
            System.out.print(">Nhap gia nhap: ");
            double giaNhap = Double.parseDouble(sc.nextLine());

            danhSachSanPham.add(new SanPham(tenSanPham, soLuong, giaNhap));

            System.out.print(">Ban co muon nhap them san pham khac khong? (y/n): ");
            String chon = sc.nextLine();
            isNhapSanPham = chon.equals("y") ? true : false;
        }

        // Tao phieu nhap va them vao danh sach
        PhieuNhap phieuNhap = new PhieuNhap(maPhieuNhap, tenNcc, tenNv, danhSachSanPham);
        quanLyPhieuNhap.themPhieuNhap(phieuNhap);
        System.out.println(">Da them phieu nhap thanh cong!");
    }

    public void xuatDanhSachPhieuNhap(QuanLyPhieuNhap quanLyPhieuNhap, Menu menu) {
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
            menu.handleEndline(1);
        });
    }
}
