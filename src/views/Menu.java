package views;

import java.util.Scanner;

import config.HandleDraw;
import controller.QuanLyNhanVien;
import controller.QuanLyPhieuNhap;
import controller.QuanLySanPham;

public class Menu {
    Scanner sc = new Scanner(System.in);
    QuanLyNhanVien quanLyNhanVien;
    QuanLySanPham quanLySanPham;
    NhanVienView nvView;
    PhieuNhapView pnView;
    PhieuXuatView pxView;
    SanPhamView spView;

    public Menu() {
        this.quanLyNhanVien = new QuanLyNhanVien();
        this.quanLySanPham = new QuanLySanPham();
        this.nvView = new NhanVienView(this, quanLyNhanVien);
        this.pnView = new PhieuNhapView(this, quanLyNhanVien, quanLySanPham);
        this.spView = new SanPhamView(this, quanLySanPham);
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
        HandleDraw.handlePrintln(" 4. Thoat chuong trinh", HandleDraw.SYSTEM_TXT);
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
        HandleDraw.handlePrintln("=".repeat(nhapMenuString.length()), "");
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
                System.out.println("Chuc nang khong ton tai!");
                break;
        }
    }

    public void showPhieuXuatMenu() {
        String xuatMenuString = "        QUAN LY PHIEU XUAT        ";
        HandleDraw.handleDrawBoard(xuatMenuString, HandleDraw.TITLE_TXT);
        System.out.println(" 1. Tao phieu xuat ");
        System.out.println(" 2. Xem danh sach phieu xuat ");
        System.out.println(" 3. Quay lai ");
        System.out.println("=".repeat(xuatMenuString.length()));
        System.out.print(">Chon chuc nang: ");

        int chon = sc.nextInt();
        HandleDraw.handleEndline(1);

        switch (chon) {
            case 1:
                System.out.println("Tao phieu xuat");
                break;
            case 2:
                System.out.println("Xem danh sach phieu xuat");
                break;
            case 3:
                showMainMenu();
                break;
            default:
                System.out.println("Chuc nang khong ton tai!");
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
        HandleDraw.handlePrintln("=".repeat(spMenuString.length()), "");
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
                System.out.println("Chuc nang khong ton tai!");
                break;
        }
    }
}