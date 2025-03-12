package config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.PhieuNhap;
import models.PhieuXuat;
import models.SanPham;

// From GROK3
public class FileHandler {

    private static final String PHIEUNHAP_FILE = "./txt/phieunhap.txt";
    private static final String PHIEUXUAT_FILE = "./txt/phieuxuat.txt";
    private static final String SANPHAM_FILE = "./txt/sanpham.txt";

    // Tao thu muc neu chua ton tai
    private static void createParentDirectory(String filePath) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
    }

    // Ghi danh sach san pham vao file
    public static void writeSanPham(List<SanPham> danhSachSanPham) {
        createParentDirectory(SANPHAM_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SANPHAM_FILE))) {
            for (SanPham sp : danhSachSanPham) {
                writer.write(String.format("%s|%d|%d|%.2f|%.2f",
                        sp.getTenSanPham(),
                        sp.getSoLuongNhap(),
                        sp.getSoLuongXuat(),
                        sp.getGiaNhap(),
                        sp.getGiaBan()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file san pham: " + e.getMessage());
        }
    }

    // Doc danh sach san pham tu file
    public static List<SanPham> readSanPham() {
        List<SanPham> danhSachSanPham = new ArrayList<>();
        File file = new File(SANPHAM_FILE);
        if (!file.exists()) {
            // System.out.println("File san pham khong ton tai!");
            return danhSachSanPham;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(SANPHAM_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    SanPham sp = new SanPham(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[3]));
                    sp.setSoLuongXuat(Integer.parseInt(parts[2]));
                    sp.setGiaBan(Double.parseDouble(parts[4]));
                    danhSachSanPham.add(sp);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file san pham: " + e.getMessage());
        }
        return danhSachSanPham;
    }

    // Ghi danh sach phieu nhap vao file
    public static void writePhieuNhap(List<PhieuNhap> danhSachPhieuNhap) {
        // System.out.println("Dang ghi file phieu nhap vao: " + PHIEUNHAP_FILE);
        createParentDirectory(PHIEUNHAP_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PHIEUNHAP_FILE))) {
            for (PhieuNhap pn : danhSachPhieuNhap) {
                StringBuilder sanPhamStr = new StringBuilder();
                for (SanPham sp : pn.getDanhSachSanPham()) {
                    sanPhamStr.append(String.format("%s:%d:%.2f;",
                            sp.getTenSanPham(), sp.getSoLuongNhap(), sp.getGiaNhap()));
                }
                writer.write(String.format("%s|%s|%s|%s",
                        pn.getMaPhieuNhap(),
                        pn.getTenNhaCungCap(),
                        pn.getTenNhanVienNhap(),
                        sanPhamStr.toString()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file phieu nhap: " + e.getMessage());
        }
    }

    // Doc danh sach phieu nhap tu file
    public static List<PhieuNhap> readPhieuNhap() {
        List<PhieuNhap> danhSachPhieuNhap = new ArrayList<>();
        File file = new File(PHIEUNHAP_FILE);
        if (!file.exists()) {
            // System.out.println("File phieu nhap khong ton tai!");
            return danhSachPhieuNhap;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(PHIEUNHAP_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    List<SanPham> danhSachSanPham = new ArrayList<>();
                    String[] sanPhamParts = parts[3].split(";");
                    for (String spStr : sanPhamParts) {
                        if (!spStr.isEmpty()) {
                            String[] spDetails = spStr.split(":");
                            if (spDetails.length == 3) {
                                SanPham sp = new SanPham(spDetails[0], Integer.parseInt(spDetails[1]), Double.parseDouble(spDetails[2]));
                                danhSachSanPham.add(sp);
                            }
                        }
                    }
                    PhieuNhap pn = new PhieuNhap(parts[0], parts[1], parts[2], danhSachSanPham);
                    danhSachPhieuNhap.add(pn);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file phieu nhap: " + e.getMessage());
        }
        return danhSachPhieuNhap;
    }

    // Ghi danh sach phieu xuat vao file
    public static void writePhieuXuat(List<PhieuXuat> danhSachPhieuXuat) {
        // System.out.println("Dang ghi file phieu xuat vao: " + PHIEUXUAT_FILE);
        createParentDirectory(PHIEUXUAT_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PHIEUXUAT_FILE))) {
            for (PhieuXuat px : danhSachPhieuXuat) {
                StringBuilder sanPhamStr = new StringBuilder();
                for (SanPham sp : px.getDanhSachSanPham()) {
                    sanPhamStr.append(String.format("%s:%d:%.2f:%.2f;",
                            sp.getTenSanPham(), sp.getSoLuongXuat(), sp.getGiaNhap(), sp.getGiaBan()));
                }
                writer.write(String.format("%s|%s|%s",
                        px.getMaPhieuXuat(),
                        px.getTenNhanVienXuat(),
                        sanPhamStr.toString()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi file phieu xuat: " + e.getMessage());
        }
    }

    // Doc danh sach phieu xuat tu file
    public static List<PhieuXuat> readPhieuXuat() {
        // System.out.println("Dang doc file phieu xuat tu: " + PHIEUXUAT_FILE);
        List<PhieuXuat> danhSachPhieuXuat = new ArrayList<>();
        File file = new File(PHIEUXUAT_FILE);
        if (!file.exists()) {
            // System.out.println("File phieu xuat khong ton tai!");
            return danhSachPhieuXuat;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(PHIEUXUAT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    List<SanPham> danhSachSanPham = new ArrayList<>();
                    String[] sanPhamParts = parts[2].split(";");
                    for (String spStr : sanPhamParts) {
                        if (!spStr.isEmpty()) {
                            String[] spDetails = spStr.split(":");
                            if (spDetails.length == 4) {
                                SanPham sp = new SanPham(spDetails[0], 0, Double.parseDouble(spDetails[2]));
                                sp.setSoLuongXuat(Integer.parseInt(spDetails[1]));
                                sp.setGiaBan(Double.parseDouble(spDetails[3]));
                                danhSachSanPham.add(sp);
                            }
                        }
                    }
                    PhieuXuat px = new PhieuXuat(parts[0], parts[1], danhSachSanPham);
                    danhSachPhieuXuat.add(px);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file phieu xuat: " + e.getMessage());
        }
        return danhSachPhieuXuat;
    }
}