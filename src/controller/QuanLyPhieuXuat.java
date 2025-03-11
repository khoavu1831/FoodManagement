package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.HandleDraw;
import models.PhieuXuat;
import models.SanPham;
import views.Menu;

public class QuanLyPhieuXuat {
    Scanner sc = new Scanner(System.in);
    private List<PhieuXuat> danhSachPhieuXuat;
    private QuanLySanPham quanLySanPham;
    private List<SanPham> danhSachSanPham;
    private List<SanPham> danhSachSanPhamXuat = new ArrayList<>();


    public QuanLyPhieuXuat(QuanLySanPham quanLySanPham) {
        this.danhSachPhieuXuat = new ArrayList<>();
        this.quanLySanPham = quanLySanPham;
    }

    public void themPhieuXuat(PhieuXuat phieuXuat) {
        this.danhSachPhieuXuat.add(phieuXuat);
    }

    public List<PhieuXuat> getDanhSachPhieuXuat() {
        return danhSachPhieuXuat;
    }

    public void taoPhieuXuat(QuanLyNhanVien quanLyNhanVien, Menu menu, QuanLyPhieuXuat quanLyPhieuXuat) {
        String tenNv = quanLyNhanVien.getTenNhanVien();
        HandleDraw.handleReplyTxt("Nhap ma phieu xuat: ");
        String maPhieuXuat = sc.nextLine();

        boolean isSanPham = true;
        while (isSanPham) {
            if (quanLySanPham.getDanhSachSanPham().isEmpty()) {
                HandleDraw.handleSystemTxt("Danh sach san pham rong!");
                return;
            }
            HandleDraw.handleEndline(2);
            HandleDraw.handleSystemTxt("Nhap thong tin san pham");
            HandleDraw.handleReplyTxt("Nhap ten san pham can xuat");
            String tenSanPhamXuat = sc.nextLine();
            
            for (SanPham sanPham : quanLySanPham.getDanhSachSanPham()) {
                if (sanPham.getTenSanPham().equals(tenSanPhamXuat)) {
                    String soLuongString = "(1 - " + String.valueOf(sanPham.getSoLuong()) + ")";
                    HandleDraw.handleReplyTxt("Nhap so luong can xuat " + soLuongString);
                    int soLuongXuat = Integer.parseInt(sc.nextLine());
                    if (soLuongXuat > 0 && soLuongXuat <= sanPham.getSoLuong()) {
                        danhSachSanPhamXuat.add(sanPham);
                        int soLuongTonKho = sanPham.getSoLuong() - soLuongXuat;
                        sanPham.setSoLuong(soLuongTonKho);
                    }
                }
            }
            PhieuXuat phieuXuat = new PhieuXuat(maPhieuXuat, tenNv, danhSachSanPhamXuat);
            quanLyPhieuXuat.themPhieuXuat(phieuXuat);

            // xuat phieu xuat - test
            quanLyPhieuXuat.getDanhSachPhieuXuat().forEach(px -> {
                System.out.println(phieuXuat.getMaPhieuXuat());
                phieuXuat.getDanhSachSanPham().forEach(sp -> {
                    System.out.println(sp.getTenSanPham());
                    System.out.println(sp.getSoLuong());
                });
            });
            isSanPham = false;
        }
    } 

    public void xuatDanhSachPhieuXuat(QuanLyPhieuXuat quanLyPhieuXuat) {
        if (quanLyPhieuXuat.getDanhSachPhieuXuat().isEmpty()) {
            HandleDraw.handleSystemTxt("Danh sach phieu xuat rong!");
            return;
        }
        HandleDraw.handleTitleYellowTxt("Danh sach phieu xuat", 6);
        quanLyPhieuXuat.getDanhSachPhieuXuat().forEach(phieuXuat -> {
            HandleDraw.handleTitleList("Ma phieu xuat:", phieuXuat.getMaPhieuXuat());
            HandleDraw.handleTitleList("Nhan vien xuat:", phieuXuat.getTenNhanVienXuat());
            phieuXuat.getDanhSachSanPham().forEach(sanPham -> {
                HandleDraw.handleChildTitleList("San pham:", sanPham.getTenSanPham());
                HandleDraw.handleChildTitleList("So luong ton:", String.valueOf(sanPham.getSoLuong()));
                
            });
        });
    }

}
