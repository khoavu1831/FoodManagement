package views;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    NhanVienView nvView;

    public Menu() {
        this.nvView = new NhanVienView(this);
    }

    public void getEqualByString(String str) {
        System.out.println("=".repeat(str.length()));
        System.out.println(str);
        System.out.println("=".repeat(str.length()));
    }

    public void handleEndline(int line) {
        for (int i = 0; i < line; i++) {
            System.out.println();
        }
    }

    public void showMenu() {
        String chao1String = "   HE THONG QUAN LY KHO THUC PHAM LEGIT2.0   ";
        getEqualByString(chao1String);
        handleEndline(1);
        
        // Thong bao nhap ten nhan vien
        nvView.showNhanVienMenu();

        // Hien thi menu chinh
        showMainMenu();
    }

    public void showMainMenu() {
        String mainMenuString = "        MAIN MENU        ";
        getEqualByString(mainMenuString);
        System.out.println(" 1. Quan ly phieu nhap ");
        System.out.println(" 2. Quan ly phieu xuat ");
        System.out.println(" 3. Quan ly san pham ");
        System.out.println(" 4. Thoat chuong trinh ");
        System.out.println("=".repeat(mainMenuString.length()));
        System.out.print(">Chon chuc nang: ");

        // Xu ly chon menu
        int chon = sc.nextInt();
        handleEndline(1);

        switch (chon) {
            case 1:
                showPhieuNhapMenu();
                handleEndline(2);
                break;
            case 2:
                showPhieuXuatMenu();
                break;
            case 3:
                showSanPhamMenu();
                break;
            case 4:
                System.out.println("Ket thuc chuong trinh!");
                break;
            default:
                System.out.println("Chuc nang khong ton tai!");
                break;
        }
    }

    public void showPhieuNhapMenu() {
        String nhapMenuString = "        QUAN LY PHIEU NHAP        ";
        getEqualByString(nhapMenuString);
        System.out.println(" 1. Tao phieu nhap ");
        System.out.println(" 2. Xem danh sach phieu nhap ");
        System.out.println(" 3. Xoa phieu nhap ");
        System.out.println(" 4. Quay lai ");
        System.out.println("=".repeat(nhapMenuString.length()));
        System.out.print(">Chon chuc nang: ");

        int chon = sc.nextInt();
        handleEndline(1);
        
        switch (chon) {
            case 1:
                System.out.println("Tao phieu nhap");
                break;
            case 2:
                System.out.println("Xem danh sach phieu nhap");
                break;
            case 3:
                System.out.println("Xoa phieu nhap");
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
        getEqualByString(xuatMenuString);
        System.out.println(" 1. Tao phieu xuat ");
        System.out.println(" 2. Xem danh sach phieu xuat ");
        System.out.println(" 3. Quay lai ");
        System.out.println("=".repeat(xuatMenuString.length()));
        System.out.print(">Chon chuc nang: ");

        int chon = sc.nextInt();
        handleEndline(1);

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
        getEqualByString(spMenuString);
        System.out.println(" 1. Xem danh sach san pham ");
        System.out.println(" 2. Sua san pham ");
        System.out.println(" 3. Xoa san pham ");
        System.out.println(" 4. Quay lai ");
        System.out.println("=".repeat(spMenuString.length()));
        System.out.print(">Chon chuc nang: ");

        int chon = sc.nextInt();
        handleEndline(1);

        switch (chon) {
            case 1:
                System.out.println("Xem danh sach san pham");
                break;
            case 2:
                System.out.println("Sua san pham");
                break;
            case 3:
                System.out.println("Xoa san pham");
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
