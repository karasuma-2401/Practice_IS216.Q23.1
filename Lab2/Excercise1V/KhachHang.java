package Lab2.Excercise1V;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class KhachHang {
    protected String maKH;
    protected String tenKH;
    protected LocalDate ngayHD;
    protected double soLuongDien;
    protected double donGia;
    protected double thanhTien;

    public KhachHang() {
        this.maKH = "";
        this.tenKH = "";
        this.ngayHD = null;
        this.soLuongDien = 0;
        this.donGia = 0;
        this.thanhTien = 0;
    }

    public KhachHang(String maKH, String tenKH, LocalDate ngayHD, double soLuongDien, double donGia, double thanhTien) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayHD = ngayHD;
        this.soLuongDien = soLuongDien;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    public void setThongTinCoBan(String maKH, String tenKH, LocalDate ngayHD) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayHD = ngayHD;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap so luong dien: ");
        this.soLuongDien = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap don gia: ");
        this.donGia = Double.parseDouble(sc.nextLine());
    }

    public String getNgayHD() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngayHD.format(formatter);
    }

    @Override
    public abstract String toString();
    public abstract double calculateThanhTien();
}