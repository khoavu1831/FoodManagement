package views;

import java.util.Scanner;

import models.NhanVien;

public class NhanVienView {
    Scanner sc = new Scanner(System.in);
    NhanVien nv = new NhanVien();
    Menu menu;

    public NhanVienView(Menu menu) {
        this.menu = menu;
    }

    public void showNhanVienMenu() {        
        System.out.print(">Nhap ten cua ban: ");

        String tenNv = sc.nextLine();        
        nv.setTenNv(tenNv);

        menu.handleEndline(1);
        String chao2String = " Xin chao, " + tenNv + "! ";
        menu.getEqualByString(chao2String);
        menu.handleEndline(1);

    }
    
    
}
