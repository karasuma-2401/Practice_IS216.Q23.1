package Lab2_JavaOOP.Exercise2V;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;
    
    public HangThucPham() {
        super();
        ngaySanXuat = LocalDate.now();
        ngayHetHan = LocalDate.now();
        nhaCungCap = "";
    }
    
    public HangThucPham(String maHang, String tenHang, double donGia, int soLuong,
                        String ngaySanXuat, String ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, donGia, soLuong);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngaySanXuat = LocalDate.parse(ngaySanXuat, formatter);
        this.ngayHetHan = LocalDate.parse(ngayHetHan, formatter);
        this.nhaCungCap = nhaCungCap;
    }
    
    // Getter methods
    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }
    
    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }
    
    public String getNhaCungCap() {
        return nhaCungCap;
    }
    
    // Setter methods
    public void setNgaySanXuat(String ngaySanXuat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngaySanXuat = LocalDate.parse(ngaySanXuat, formatter);
    }
    
    public void setNgayHetHan(String ngayHetHan) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngayHetHan = LocalDate.parse(ngayHetHan, formatter);
    }
    
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    
    public boolean kiemTraHetHan() {
        return LocalDate.now().isAfter(ngayHetHan);
    }
    
    @Override
    public void xuat() {
        System.out.println("========== HANG THUC PHAM ==========");
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Ngay san xuat: " + ngaySanXuat);
        System.out.println("Ngay het han: " + ngayHetHan);
        System.out.println("Nha cung cap: " + nhaCungCap);
        System.out.println("====================================\n");
    }
    
    @Override
    public double tinhThanhTien(int soLuongBan) {
        if (soLuongBan > soLuong) {
            System.out.println("So luong ban vuot qua so luong ton kho!");
            return 0;
        }
        soLuong -= soLuongBan;
        double thanhTien = soLuongBan * donGia;
        double vat = thanhTien * 0.05; // 5% VAT
        double tongCong = thanhTien + vat;
        System.out.println("Thanh tien (chua VAT): " + thanhTien);
        System.out.println("VAT (5%): " + vat);
        System.out.println("Tong cong: " + tongCong);
        System.out.println("So luong ton moi: " + soLuong + "\n");
        return tongCong;
    }
    
    @Override
    public String danhGiaMucDoBanBuon() {
        if (kiemTraHetHan() && soLuong > 2) {
            return "Kho ban";
        }
        return "Khong danh gia";
    }
}
