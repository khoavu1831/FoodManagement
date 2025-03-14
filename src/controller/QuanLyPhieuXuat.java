package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.FileHandler;
import config.HandleDraw;
import config.Logic;
import models.PhieuXuat;
import models.SanPham;

public class QuanLyPhieuXuat {
    Scanner sc = new Scanner(System.in);
    private List<PhieuXuat> danhSachPhieuXuat;
    private QuanLySanPham quanLySanPham;

    public QuanLyPhieuXuat(QuanLySanPham quanLySanPham) {
        this.quanLySanPham = quanLySanPham;
        this.danhSachPhieuXuat = FileHandler.readPhieuXuat();
    }

    public void themPhieuXuat(PhieuXuat phieuXuat) {
        this.danhSachPhieuXuat.add(phieuXuat);
        FileHandler.writePhieuXuat(danhSachPhieuXuat);
    }

    public List<PhieuXuat> getDanhSachPhieuXuat() {
        return danhSachPhieuXuat;
    }

    public void taoPhieuXuat(QuanLyNhanVien quanLyNhanVien, QuanLyPhieuXuat quanLyPhieuXuat) {
        if (quanLySanPham.getDanhSachSanPham().isEmpty()) {
            HandleDraw.handleSystemTxt("Danh sach san pham rong!");
            return;
        }

        String tenNv = quanLyNhanVien.getTenNhanVien();
        HandleDraw.handleReplyTxt("Ma phieu xuat");
        String maPhieuXuat = Logic.autoCreateID("PX", danhSachPhieuXuat);
        HandleDraw.handlePrintln(maPhieuXuat, HandleDraw.REPLY_TXT);

        List<SanPham> danhSachSanPhamXuat = new ArrayList<>();
        boolean isSanPham = true;

        while (isSanPham) {
            HandleDraw.handleEndline(2);
            HandleDraw.handleSystemTxt("Nhap thong tin san pham");
            HandleDraw.handleReplyTxt("Nhap ten san pham can xuat");
            String tenSanPhamXuat = sc.nextLine();

            SanPham sanPham = quanLySanPham.timSanPham(tenSanPhamXuat);
            if (sanPham == null) {
                HandleDraw.handleSystemTxt("Khong tim thay san pham!");
                HandleDraw.handleReplyTxt("Nhap san pham khac? (y/n)");
                String chon = sc.nextLine();
                isSanPham = chon.equalsIgnoreCase("y");
                continue;
            }

            if (sanPham.getSoLuongNhap() <= 0) {
                HandleDraw.handleSystemTxt("San pham da het hang!");
                HandleDraw.handleReplyTxt("Nhap san pham khac? (y/n)");
                String chon = sc.nextLine();
                isSanPham = chon.equalsIgnoreCase("y");
                continue;
            }

            String soLuongString = "(1 - " + String.valueOf(sanPham.getSoLuongNhap()) + ")";
            HandleDraw.handleReplyTxt("Nhap so luong can xuat " + soLuongString);
            int soLuongXuat = Integer.parseInt(sc.nextLine());

            if (soLuongXuat <= 0 || soLuongXuat > sanPham.getSoLuongNhap()) {
                HandleDraw.handleSystemTxt("So luong xuat khong hop le!");
                continue;
            }

            // Tao 1 danh sach san pham moi de luu vao phieu xuat
            SanPham sanPhamXuat = new SanPham(sanPham.getTenSanPham(), soLuongXuat, sanPham.getGiaNhap());
            sanPhamXuat.setGiaBan(sanPham.getGiaBan());
            sanPhamXuat.setSoLuongXuat(soLuongXuat);
            sanPham.setSoLuongNhap(sanPham.getSoLuongNhap() - soLuongXuat);

            danhSachSanPhamXuat.add(sanPhamXuat);

            HandleDraw.handleReplyTxt("Ban co muon xuat them san pham khac khong? (y/n)");
            String chon = sc.nextLine();
            isSanPham = chon.equalsIgnoreCase("y");
        }

        if (danhSachSanPhamXuat.isEmpty()) {
            HandleDraw.handleSystemTxt("Tao phieu xuat that bai!");
            return;
        }

        PhieuXuat phieuXuat = new PhieuXuat(maPhieuXuat, tenNv, danhSachSanPhamXuat);
        quanLyPhieuXuat.themPhieuXuat(phieuXuat);
        HandleDraw.handleSystemTxt("Tao phieu xuat thanh cong!");
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
            HandleDraw.handleTitleList("Danh sach san pham:", "");
            phieuXuat.getDanhSachSanPham().forEach(sanPham -> {
                HandleDraw.handleChildTitleList("San pham:", sanPham.getTenSanPham());
                HandleDraw.handleChildTitleList("So luong xuat:", String.valueOf(sanPham.getSoLuongXuat()));
                HandleDraw.handleChildTitleList("Gia ban:", String.valueOf(sanPham.getGiaBan()));
                HandleDraw.handleChildTitleList("Thanh tien:",
                        String.format("%.2f", sanPham.getGiaBan() * sanPham.getSoLuongXuat()));
                HandleDraw.handlePrintln("     ----------------------", "");
            });
            HandleDraw.handleTitleList("Tong tien:", String.valueOf(phieuXuat.tongTien()));
            HandleDraw.handlePrintln("----------------------------------", "");
            HandleDraw.handleEndline(1);
        });
    }

}
