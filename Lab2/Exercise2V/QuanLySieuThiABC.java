package Lab2_JavaOOP.Exercise2V;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySieuThiABC {
    private static ArrayList<HangHoa> danhSachHang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("QUAN LY SIEU THI ABC");
            System.out.println("1. Nhap hang hoa");
            System.out.println("2. Xuat muc do danh gia ban buon");
            System.out.println("3. Xuat thuong hieu dien may ban duoc");
            System.out.println("4. Tinh thanh tien cho mot san pham");
            System.out.println("5. Hien thi tat ca san pham");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    nhapHangHoa();
                    break;
                case 2:
                    xuatMucDoDanhGia();
                    break;
                case 3:
                    xuatThuongHieuDienMayBanDuoc();
                    break;
                case 4:
                    tinhThanhTienSanPham();
                    break;
                case 5:
                    hienThiTatCaSanPham();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung he thong!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
        
        scanner.close();
    }
    
    private static void nhapHangHoa() {
        System.out.println("\n--- NHAP HANG HOA ---");
        System.out.println("Chon loai hang:");
        System.out.println("1. Hang dien may");
        System.out.println("2. Hang thuc pham");
        System.out.println("3. Hang gia dung");
        System.out.print("Chon: ");
        int loaiHang = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ma hang (nhap trong de dung): ");
        String maHang = scanner.nextLine();
        
        if (maHang.isEmpty()) {
            System.out.println("Ket thuc nhap hang!");
            return;
        }
        
        // Kiem tra trung ma hang
        if (kiemTraMaHangTrung(maHang)) {
            System.out.println("Ma hang da ton tai! Khong the them hang.");
            return;
        }
        
        System.out.print("Ten hang: ");
        String tenHang = scanner.nextLine();
        
        System.out.print("Don gia: ");
        double donGia = scanner.nextDouble();
        
        System.out.print("So luong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();
        
        HangHoa hang = null;
        
        if (loaiHang == 1) {
            System.out.print("Thuong hieu: ");
            String thuongHieu = scanner.nextLine();
            
            System.out.print("Loai may: ");
            String loaiMay = scanner.nextLine();
            
            System.out.print("Thoi gian bao hanh (thang): ");
            int thoiGianBaoHanh = scanner.nextInt();
            scanner.nextLine();
            
            hang = new HangDienMay(maHang, tenHang, donGia, soLuong, thuongHieu, loaiMay, thoiGianBaoHanh);
            
        } else if (loaiHang == 2) {
            System.out.print("Ngay san xuat (dd/MM/yyyy): ");
            String ngaySanXuat = scanner.nextLine();
            
            System.out.print("Ngay het han (dd/MM/yyyy): ");
            String ngayHetHan = scanner.nextLine();
            
            System.out.print("Nha cung cap: ");
            String nhaCungCap = scanner.nextLine();
            
            hang = new HangThucPham(maHang, tenHang, donGia, soLuong, ngaySanXuat, ngayHetHan, nhaCungCap);
            
        } else if (loaiHang == 3) {
            System.out.print("Nha san xuat: ");
            String nhaSanXuat = scanner.nextLine();
            
            System.out.print("Ngay nhap kho (dd/MM/yyyy): ");
            String ngayNhapKho = scanner.nextLine();
            
            System.out.println("Loai san pham:");
            System.out.println("0. Ly  1. Chen  2. Noi  3. Khac");
            System.out.print("Chon: ");
            int loai = scanner.nextInt();
            scanner.nextLine();
            
            LoaiSanPhamGiaDung loaiSP = LoaiSanPhamGiaDung.KHAC;
            if (loai == 0) loaiSP = LoaiSanPhamGiaDung.LY;
            else if (loai == 1) loaiSP = LoaiSanPhamGiaDung.CHEN;
            else if (loai == 2) loaiSP = LoaiSanPhamGiaDung.NOI;
            
            hang = new HangGiaDung(maHang, tenHang, donGia, soLuong, nhaSanXuat, ngayNhapKho, loaiSP);
        } else {
            System.out.println("Loai hang khong hop le!");
            return;
        }
        
        danhSachHang.add(hang);
        System.out.println("+ Them hang thanh cong!");
    }
    
    private static void xuatMucDoDanhGia() {
        System.out.println("\n--- MUC DO DANH GIA BAN BUON ---");
        System.out.println(String.format("%-10s | %-20s | %-10s | %s", "Ma hang", "Ten hang", "So luong", "Muc do"));
        System.out.println("=".repeat(65));
        
        for (HangHoa hang : danhSachHang) {
            String danhGia = hang.danhGiaMucDoBanBuon();
            System.out.println(String.format("%-10s | %-20s | %-10d | %s", 
                hang.getMaHang(), hang.getTenHang(), hang.getSoLuong(), danhGia));
        }
    }
    
    private static void xuatThuongHieuDienMayBanDuoc() {
        System.out.println("\n--- THUONG HIEU DIEN MAY BAN DUOC ---");
        System.out.println(String.format("%-15s | %-20s | %s", "Thuong hieu", "Ten hang", "Loai"));
        System.out.println("=".repeat(60));
        
        boolean found = false;
        for (HangHoa hang : danhSachHang) {
            if (hang instanceof HangDienMay) {
                HangDienMay dienMay = (HangDienMay) hang;
                if (dienMay.danhGiaMucDoBanBuon().equals("Ban duoc")) {
                    System.out.println(String.format("%-15s | %-20s | %s", 
                        dienMay.getThuongHieu(), dienMay.getTenHang(), dienMay.getLoaiMay()));
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("Khong co thuong hieu dien may nao ban duoc.");
        }
    }
    
    private static void tinhThanhTienSanPham() {
        System.out.print("\nNhap ma hang: ");
        String maHang = scanner.nextLine();
        
        HangHoa hang = timHangTheoMa(maHang);
        if (hang == null) {
            System.out.println("Khong tim thay hang!");
            return;
        }
        
        System.out.print("Nhap so luong ban: ");
        int soLuongBan = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("\nThong tin tinh toan:");
        double tongCong = hang.tinhThanhTien(soLuongBan);
        System.out.println("Ma hang: " + hang.getMaHang() + " - Ten: " + hang.getTenHang());
    }
    
    private static void hienThiTatCaSanPham() {
        System.out.println("\n--- TAT CA SAN PHAM ---");
        for (HangHoa hang : danhSachHang) {
            hang.xuat();
        }
    }
    
    private static boolean kiemTraMaHangTrung(String maHang) {
        for (HangHoa hang : danhSachHang) {
            if (hang.getMaHang().equals(maHang)) {
                return true;
            }
        }
        return false;
    }
    
    private static HangHoa timHangTheoMa(String maHang) {
        for (HangHoa hang : danhSachHang) {
            if (hang.getMaHang().equals(maHang)) {
                return hang;
            }
        }
        return null;
    }
}
