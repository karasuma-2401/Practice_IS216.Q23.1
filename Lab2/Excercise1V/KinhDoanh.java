package Lab2.Excercise1V;

import java.time.LocalDate;
import java.util.Scanner;

public class KinhDoanh extends KhachHang {

    public KinhDoanh() {
        super();
    }

    public KinhDoanh(String maKH, String tenKH, LocalDate ngayHD, double soLuongDien, double donGia, double thanhTien) {
        super(maKH, tenKH, ngayHD, soLuongDien, donGia, thanhTien);
    }
    
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
    }

    @Override
    public double calculateThanhTien() {
        if (soLuongDien <= 400) {
            thanhTien = soLuongDien * donGia;
        } else {
            thanhTien = 400 * donGia + (soLuongDien - 400) * donGia * 1.05;
        }
        return thanhTien;
    }

    @Override
    public String toString() {
        return "[Kinh Doanh] MaKH: " + maKH + " | tenKh: " + tenKH + " | Ngay HD: " + getNgayHD() + " | Thanh tien: " + calculateThanhTien();
    }
}