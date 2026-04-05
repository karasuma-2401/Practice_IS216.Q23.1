package Lab2.Excercise1V;

import java.time.LocalDate;
import java.util.Scanner;

public class SinhHoat extends KhachHang {
    private double dinhMuc;

    public SinhHoat() {
        super();
        this.dinhMuc = 0;
    }

    public SinhHoat(String maKH, String tenKH, LocalDate ngayHD, double soLuongDien, double donGia, double thanhTien, double dinhMuc) {
        super(maKH, tenKH, ngayHD, soLuongDien, donGia, thanhTien);
        this.dinhMuc = dinhMuc;
    }
    
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhap dinh muc: ");
        this.dinhMuc = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double calculateThanhTien() {
        if (soLuongDien <= dinhMuc) {
            thanhTien = soLuongDien * donGia;
        } else {
            thanhTien = dinhMuc * donGia + (soLuongDien - dinhMuc) * donGia * 2;
        }
        return thanhTien;
    }

    @Override
    public String toString() {
        return "[Sinh Hoat] MaKH: " + maKH + " | tenKh: " + tenKH + " | Ngay HD: " + getNgayHD() + " | Dinh muc: " + dinhMuc + " | Thanh tien: " + calculateThanhTien();
    }
}