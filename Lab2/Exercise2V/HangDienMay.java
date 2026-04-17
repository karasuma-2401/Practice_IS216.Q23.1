package Lab2.Lab2_JavaOOP.Exercise2V;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HangDienMay extends HangHoa {
    private String thuongHieu;
    private String loaiMay;
    private int thoiGianBaoHanh; // tinh theo thang
    
    public HangDienMay() {
        super();
        thuongHieu = "";
        loaiMay = "";
        thoiGianBaoHanh = 0;
    }
    
    public HangDienMay(String maHang, String tenHang, double donGia, int soLuong, 
                       String thuongHieu, String loaiMay, int thoiGianBaoHanh) {
        super(maHang, tenHang, donGia, soLuong);
        this.thuongHieu = thuongHieu;
        this.loaiMay = loaiMay;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    
    // Getter methods
    public String getThuongHieu() {
        return thuongHieu;
    }
    
    public String getLoaiMay() {
        return loaiMay;
    }
    
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    
    // Setter methods
    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }
    
    public void setLoaiMay(String loaiMay) {
        this.loaiMay = loaiMay;
    }
    
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    
    @Override
    public void xuat() {
        System.out.println("========== HANG DIEN MAY ==========");
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
        System.out.println("Thuong hieu: " + thuongHieu);
        System.out.println("Loai may: " + loaiMay);
        System.out.println("Thoi gian bao hanh: " + thoiGianBaoHanh + " thang");
        System.out.println("==================================\n");
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
        if (soLuong < 3) {
            return "Ban duoc";
        }
        return "Khong danh gia";
    }
}
