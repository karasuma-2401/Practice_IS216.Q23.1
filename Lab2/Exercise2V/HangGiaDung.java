package Lab2.Exercise2V;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

enum LoaiSanPhamGiaDung {
    LY,
    CHEN,
    NOI,
    KHAC
}

public class HangGiaDung extends HangHoa {
    private String nhaSanXuat;
    private LocalDate ngayNhapKho;
    private LoaiSanPhamGiaDung loaiSanPham; 
    
    public HangGiaDung() {
        super();
        nhaSanXuat = "";
        ngayNhapKho = LocalDate.now();
        loaiSanPham = LoaiSanPhamGiaDung.KHAC;
    }
    
    public HangGiaDung(String maHang, String tenHang, double donGia, int soLuong, 
                       String nhaSanXuat, String ngayNhapKho, LoaiSanPhamGiaDung loaiSanPham) {
        super(maHang, tenHang, donGia, soLuong);
        this.nhaSanXuat = nhaSanXuat;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngayNhapKho = LocalDate.parse(ngayNhapKho, formatter);
        this.loaiSanPham = loaiSanPham;
    }
    
    // Getter methods
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }
    
    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }
    
    public LoaiSanPhamGiaDung getLoaiSanPham() {
        return loaiSanPham;
    }
    
    // Setter methods
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    
    public void setNgayNhapKho(String ngayNhapKho) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ngayNhapKho = LocalDate.parse(ngayNhapKho, formatter);
    }
    
    public void setLoaiSanPham(LoaiSanPhamGiaDung loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
    
    public long tinhSoNgayTrongKho() {
        return ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
    }
    
    @Override
    public void xuat() {
        System.out.println("========== HANG GIA DUNG ==========");
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Nha san xuat: " + nhaSanXuat);
        System.out.println("Ngay nhap kho: " + ngayNhapKho);
        System.out.println("Loai san pham: " + loaiSanPham);
        System.out.println("===================================\n");
    }
    
    @Override
    public double tinhThanhTien(int soLuongBan) {
        if (soLuongBan > soLuong) {
            System.out.println("So luong ban vuot qua so luong ton kho!");
            return 0;
        }
        soLuong -= soLuongBan;
        double thanhTien = soLuongBan * donGia;
        double vat = thanhTien * 0.1; // 10% VAT
        double tongCong = thanhTien + vat;
        System.out.println("Thanh tien (chua VAT): " + thanhTien);
        System.out.println("VAT (10%): " + vat);
        System.out.println("Tong cong: " + tongCong);
        System.out.println("So luong ton moi: " + soLuong + "\n");
        return tongCong;
    }
    
    @Override
    public String danhGiaMucDoBanBuon() {
        long soNgay = tinhSoNgayTrongKho();
        if (soLuong > 10 && soNgay > 20) {
            return "Ban cham";
        }
        return "Khong danh gia";
    }
}
