package Lab2.Excercise1V;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDienLuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> danhSachKH = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("Nhap ma khach hang (Nhan enter de ket thuc nhap): ");
            String maKH = sc.nextLine();
            if (maKH.trim().isEmpty()) {
                break;
            }

            System.out.print("Nhap ten khach hang: ");
            String tenKH = sc.nextLine();

            System.out.print("Nhap loai khach hang (1. Sinh hoat, 2.Kinh doanh, 3.San xuat): ");
            int loaiKH = Integer.parseInt(sc.nextLine());

            System.out.print("Nhap ngay hoa don (dd/MM/yyyy): ");
            LocalDate ngayHD;
            try {
                ngayHD = LocalDate.parse(sc.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("=> Loi: Sai dinh dang ngay! Hay nhap lai.");
                continue;
            }

            boolean hopLe = true;
            for (KhachHang k : danhSachKH) {
                if (k.maKH.equals(maKH)) {
                    if (!k.tenKH.equals(tenKH)) {
                        System.out.println("=> Loi: Ma khach hang da ton tai");
                        hopLe = false; break;
                    }
                    int currentType = (k instanceof SinhHoat) ? 1 : (k instanceof KinhDoanh) ? 2 : 3;
                    if (currentType != loaiKH) {
                        System.out.println("=> Loi: khach hang khong duoc su dung loai dien khac!");
                        hopLe = false; break;
                    }
                    if (k.ngayHD.equals(ngayHD)) {
                        System.out.println("=> Loi: hoa don nay cua khach hang da ton tai!");
                        hopLe = false; break;
                    }
                }
            }

            if (!hopLe) continue;

            KhachHang kh = null;
            switch (loaiKH) {
                case 1: kh = new SinhHoat(); break;
                case 2: kh = new KinhDoanh(); break;
                case 3: kh = new SanXuat(); break;
                default: 
                    System.out.println("=> Loi: Loai khach hang khong hop le!");
                    continue;
            }

            kh.setThongTinCoBan(maKH, tenKH, ngayHD);
            kh.nhap(sc);
            kh.calculateThanhTien();
            danhSachKH.add(kh);
            System.out.println("=> Them hoa don thanh cong!");
        }

        System.out.println("Nhap thang can tra cuu: ");
        int thang = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap nam can tra cuu: ");
        int nam = Integer.parseInt(sc.nextLine());

        System.out.println("--- DANH SACH HOA DON THANG " + thang + "/" + nam + " ---");
        System.out.printf("%-10s | %-20s | %-15s | %-15s\n", "Ma KH", "Ten KH", "So luong dien", "Thanh tien");
        System.out.println("----------------------------------------------------------------------");
        
        boolean found = false;
        for (KhachHang k : danhSachKH) {
            if (k.ngayHD.getMonthValue() == thang && k.ngayHD.getYear() == nam) {
                System.out.printf("%-10s | %-20s | %-15.1f | %-15.1f\n", 
                        k.maKH, k.tenKH, k.soLuongDien, k.thanhTien);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Khong tim thay hoa don nao trong thang " + thang + " nam " + nam + ".");
        }
        sc.close();
    }
}