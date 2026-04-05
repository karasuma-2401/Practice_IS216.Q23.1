package Lab2.Excercise1V;

import java.time.LocalDate;
import java.util.Scanner;

public class SanXuat extends KhachHang {
    private String loaiDien;

    public SanXuat() {
        super();
        this.loaiDien = "";
    }

    public SanXuat(String maKH, String tenKH, LocalDate ngayHD, double soLuongDien, double donGia, double thanhTien, String loaiDien) {
        super(maKH, tenKH, ngayHD, soLuongDien, donGia, thanhTien);
        this.loaiDien = loaiDien;
    }
    
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap loai dien (2 pha / 3 pha): ");
        this.loaiDien = sc.nextLine();
    }

    @Override
    public double calculateThanhTien() {
        if (loaiDien.equals("2 pha")) {
            thanhTien = soLuongDien * donGia;
            if (soLuongDien > 200) {
                thanhTien *= 0.98;
            }
        } else if (loaiDien.equals("3 pha")) {
            thanhTien = soLuongDien * donGia;
            if (soLuongDien > 150) {
                thanhTien *= 0.97;
            }
        }
        return thanhTien;
    }

    @Override
    public String toString() {
        return "[San xuat] MaKH: " + maKH + " | tenKh: " + tenKH + " | Ngay HD: " + getNgayHD() + " | Loai dien: " + loaiDien + " | Thanh tien: " + calculateThanhTien();
    }
}