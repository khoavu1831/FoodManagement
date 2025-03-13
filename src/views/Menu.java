package views;

import java.util.Scanner;

import config.HandleDraw;
import controller.QuanLyNhanVien;
import controller.QuanLyPhieuNhap;
import controller.QuanLyPhieuXuat;
import controller.QuanLySanPham;
import controller.QuanLyThongKe;

public class Menu {
    Scanner sc = new Scanner(System.in);
    QuanLyNhanVien quanLyNhanVien;
    QuanLySanPham quanLySanPham;
    QuanLyPhieuNhap quanLyPhieuNhap;
    QuanLyPhieuXuat quanLyPhieuXuat;
    QuanLyThongKe quanLyThongKe;
    NhanVienView nvView;
    PhieuNhapView pnView;
    PhieuXuatView pxView;
    SanPhamView spView;
    ThongKeView tkView;

    public Menu() {
        this.quanLyNhanVien = new QuanLyNhanVien();
        this.quanLySanPham = new QuanLySanPham();
        this.quanLyPhieuNhap = new QuanLyPhieuNhap(quanLySanPham);
        this.quanLyPhieuXuat = new QuanLyPhieuXuat(quanLySanPham);
        this.quanLyThongKe = new QuanLyThongKe(quanLyPhieuNhap, quanLyPhieuXuat);
        this.nvView = new NhanVienView(quanLyNhanVien);
        this.pnView = new PhieuNhapView(quanLyNhanVien, quanLySanPham);
        this.pxView = new PhieuXuatView(quanLyNhanVien, quanLySanPham);
        this.spView = new SanPhamView(quanLySanPham);
        this.tkView = new ThongKeView(quanLyThongKe);
    }

    public void showMenu() {
        HandleDraw.handleDrawBoard("   HE THONG QUAN LY KHO THUC PHAM LEGIT2.0   ", HandleDraw.TITLE_TXT);
        nvView.showNhanVienMenu();
        showMainMenu();
    }

    public void showMainMenu() {
        String mainMenuString = "        MAIN MENU        ";
        HandleDraw.handleDrawBoard(mainMenuString, HandleDraw.TITLE_TXT);
        HandleDraw.handlePrintln(" 1. Quan ly phieu nhap", HandleDraw.WHITE);
        HandleDraw.handlePrintln(" 2. Quan ly phieu xuat", HandleDraw.WHITE);
        HandleDraw.handlePrintln(" 3. Quan ly san pham", HandleDraw.WHITE);
        HandleDraw.handlePrintln(" 4. Thong ke", HandleDraw.WHITE);
        HandleDraw.handlePrintln(" 5. Thoat chuong trinh", HandleDraw.SYSTEM_TXT);
        System.out.println("=".repeat(mainMenuString.length()));
        HandleDraw.handleReplyTxt("Chon chuc nang");

        int chon = sc.nextInt();
        HandleDraw.handleEndline(1);

        switch (chon) {
            case 1:
                showPhieuNhapMenu();
                HandleDraw.handleEndline(2);
                break;
            case 2:
                showPhieuXuatMenu();
                break;
            case 3:
                showSanPhamMenu();
                break;
            case 4:
                tkView.showThongKe();
                showMainMenu();
                break;
            case 5:
                HandleDraw.handleSystemTxt("Chuong trinh ket thuc!");
                break;
            default:
                HandleDraw.handleSystemTxt("Loi: Chuc nang khong ton tai!");
                break;
        }
    }

    public void showPhieuNhapMenu() {
        String nhapMenuString = "        QUAN LY PHIEU NHAP        ";
        HandleDraw.handleDrawBoard(nhapMenuString, HandleDraw.TITLE_TXT);
        HandleDraw.handlePrintln("1. Tao phieu nhap", "");
        HandleDraw.handlePrintln("2. Xem danh sach phieu nhap", "");
        HandleDraw.handlePrintln("3. Xoa phieu nhap", "");
        HandleDraw.handlePrintln("4. Quay lai", HandleDraw.SYSTEM_TXT);
        System.out.println("=".repeat(nhapMenuString.length()));
        HandleDraw.handleReplyTxt("Chon chuc nang");

        int chon = sc.nextInt();
        HandleDraw.handleEndline(1);

        switch (chon) {
            case 1:
                pnView.showTaoPhieuNhap();
                showPhieuNhapMenu();
                break;
            case 2:
                pnView.showDanhSachPhieuNhap();
                showPhieuNhapMenu();
                break;
            case 3:
                pnView.showXoaPhieuNhap();
                showPhieuNhapMenu();
                break;
            case 4:
                showMainMenu();
                break;
            default:
                HandleDraw.handleSystemTxt("Loi: Chuc nang khong ton tai!");
                break;
        }
    }

    public void showPhieuXuatMenu() {
        String xuatMenuString = "        QUAN LY PHIEU XUAT        ";
        HandleDraw.handleDrawBoard(xuatMenuString, HandleDraw.TITLE_TXT);
        HandleDraw.handlePrintln("1. Tao phieu xuat", "");
        HandleDraw.handlePrintln("2. Xem danh sach phieu xuat ", "");
        HandleDraw.handlePrintln("3. Quay lai ", HandleDraw.SYSTEM_TXT);
        System.out.println("=".repeat(xuatMenuString.length()));
        HandleDraw.handleReplyTxt("Chon chuc nang");
        int chon = sc.nextInt();
        HandleDraw.handleEndline(1);

        switch (chon) {
            case 1:
                pxView.showPhieuXuatMenu();
                showPhieuXuatMenu();
                break;
            case 2:
                pxView.showDanhSachPhieuXuat();
                showPhieuXuatMenu();
                break;
            case 3:
                showMainMenu();
                break;
            default:
                HandleDraw.handleSystemTxt("Loi: Chuc nang khong ton tai!");
                break;
        }
    }

    public void showSanPhamMenu() {
        String spMenuString = "        QUAN LY SAN PHAM        ";
        HandleDraw.handleDrawBoard(spMenuString, HandleDraw.TITLE_TXT);
        HandleDraw.handlePrintln(" 1. Xem danh sach san pham", "");
        HandleDraw.handlePrintln(" 2. Sua san pham ", "");
        HandleDraw.handlePrintln(" 3. Xoa san pham ", "");
        HandleDraw.handlePrintln(" 4. Quay lai", HandleDraw.SYSTEM_TXT);
        System.out.println("=".repeat(spMenuString.length()));
        HandleDraw.handleReplyTxt("Chon chuc nang");
        int chon = sc.nextInt();
        HandleDraw.handleEndline(1);

        switch (chon) {
            case 1:
                spView.showDanhSachSanPham();
                showSanPhamMenu();
                break;
            case 2:
                spView.showSuaSanPham();
                showSanPhamMenu();
                break;
            case 3:
                spView.showXoaSanPham();
                showSanPhamMenu();
                break;
            case 4:
                showMainMenu();
                break;
            default:
                HandleDraw.handleSystemTxt("Loi: Chuc nang khong ton tai!");
                break;
        }
    }
}