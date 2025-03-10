package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.HandleDraw;
import models.SanPham;

public class QuanLySanPham {
    private List<SanPham> danhSachSanPham;
    private Scanner sc = new Scanner(System.in);

    public QuanLySanPham() {
        this.danhSachSanPham = new ArrayList<>();
    }

    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void themSanPham(SanPham sanPham) {
        SanPham sp = timSanPham(sanPham.getTenSanPham());
        if (sp != null) {
            sp.setSoLuong(sp.getSoLuong() + sanPham.getSoLuong());
        } else {
            danhSachSanPham.add(sanPham);
        }
    }

    public SanPham timSanPham(String tenSanPham) {
        return danhSachSanPham.stream()
                .filter(sp -> sp.getTenSanPham().equalsIgnoreCase(tenSanPham))
                .findFirst()
                .orElse(null);
    }

    public void xemDanhSachSanPham() {
        if (danhSachSanPham.isEmpty()) {
            HandleDraw.handleSystemTxt("Danh sach san pham rong!");
            return;
        }

        HandleDraw.handleTitleYellowTxt("Danh sach san pham", 0);
        System.out.format(" %s%-25s %s%-15s %s%-15s %s%-15s %s %n", HandleDraw.RED, "Ten san pham", HandleDraw.GREEN,"So luong", HandleDraw.BLUE," Gia nhap", HandleDraw.YELLOW, "Gia ban", HandleDraw.RESET);
        for (SanPham sp : danhSachSanPham) {
            System.out.format(" %-25s %-15d %-15.2f %-15.2f %n", sp.getTenSanPham(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan());
        }
    }

    // Thieu dieu kien sua ten san pham trung nhau
    public void suaSanPham() {
        HandleDraw.handleReplyTxt("Nhap ten san pham can sua: ");
        String tenSanPham = sc.nextLine();
        SanPham sp = timSanPham(tenSanPham);

        if (sp == null) {
            HandleDraw.handleSystemTxt("Khong tim thay san pham!");
            return;
        }

        HandleDraw.handleReplyTxt("Nhap ten moi (nhan Enter de giu nguyen): ");
        String tenMoi = sc.nextLine();
        if (!tenMoi.isEmpty()) {
            sp.setTenSanPham(tenMoi);
        }

        HandleDraw.handleReplyTxt("Nhap gia ban moi (nhap 0 de giu nguyen): ");
        double giaBanMoi = Double.parseDouble(sc.nextLine());
        if (giaBanMoi > 0) {
            sp.setGiaBan(giaBanMoi);
        }

        HandleDraw.handleSystemTxt("Da sua san pham thanh cong!");
    }

    // Thieu dieu kien chi xoa san pham khi so luong = 0
    public void xoaSanPham() {
        HandleDraw.handleReplyTxt("Nhap ten san pham can xoa: ");
        String tenSanPham = sc.nextLine();
        SanPham sp = timSanPham(tenSanPham);

        if (sp == null) {
            HandleDraw.handleSystemTxt("Khong tim thay san pham!");
            return;
        }

        danhSachSanPham.remove(sp);
        HandleDraw.handleSystemTxt("Da xoa san pham thanh cong!");
    }
}