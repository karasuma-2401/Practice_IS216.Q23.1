package Lab2.Lab2_JavaOOP.Lab2_JavaOOP.Exercise2V.1.Lab2.Exercise2V;

/**
 * Lop TestQuanLySieuThi - Chuong trinh kiem tra chuc nang
 * Tu dong them mot so hang hoa mau de kiem tra
 */
public class TestQuanLySieuThi {
    public static void main(String[] args) {
        System.out.println("========== TEST QUAN LY SIEU THI ABC ==========");
        
        // Tao cac san pham mau
        
        // Hang dien may 1
        HangDienMay dienMay1 = new HangDienMay(
            "DM001", 
            "Laptop Dell XPS 13", 
            15000000, 
            2, 
            "Dell", 
            "Laptop", 
            24
        );
        
        // Hang dien may 2
        HangDienMay dienMay2 = new HangDienMay(
            "DM002", 
            "iPhone 15", 
            20000000, 
            5, 
            "Apple", 
            "Dien thoai", 
            12
        );
        
        // Hang thuc pham 1
        HangThucPham thucPham1 = new HangThucPham(
            "TP001", 
            "Sua tuoi TH true milk", 
            25000, 
            3, 
            "05/04/2026",  // Ngay san xuat
            "20/04/2026",  // Ngay het han
            "TH Dairy"
        );
        
        // Hang thuc pham 2 (het han)
        HangThucPham thucPham2 = new HangThucPham(
            "TP002", 
            "Banh quy",
            15000,
            5,
            "20/03/2026",
            "10/04/2026",  // Da het han
            "Kinh Do"
        );
        
        // Hang gia dung 1
        HangGiaDung giaDung1 = new HangGiaDung(
            "GD001", 
            "Tach su trang", 
            50000, 
            15, 
            "Ceramic Co.", 
            "15/03/2026",  // Nhap kho cach day hon 20 ngay
            LoaiSanPhamGiaDung.CHEN
        );
        
        // Hang gia dung 2
        HangGiaDung giaDung2 = new HangGiaDung(
            "GD002", 
            "Noi nau an", 
            200000, 
            8, 
            "Sunhouse", 
            "10/04/2026",  // Vua nhap kho
            LoaiSanPhamGiaDung.NOI
        );
        
        System.out.println("\n--- THONG TIN CAC SAN PHAM ---\n");
        
        dienMay1.xuat();
        dienMay2.xuat();
        thucPham1.xuat();
        thucPham2.xuat();
        giaDung1.xuat();
        giaDung2.xuat();
        
        // Test phuong thuc tinh thanh tien
        System.out.println("\n--- TEST TINH THANH TIEN ---");
        System.out.println("Mua 1 chiec Laptop Dell XPS 13:");
        double tienDienMay = dienMay1.tinhThanhTien(1);
        System.out.println("So luong sau mua: " + dienMay1.getSoLuong());
        
        System.out.println("\nMua 2 goi sua tuoi:");
        double tienThucPham = thucPham1.tinhThanhTien(2);
        System.out.println("So luong sau mua: " + thucPham1.getSoLuong());
        
        // Test phuong thuc danh gia muc do ban buon
        System.out.println("\n--- DANH GIA MUC DO BAN BUON ---\n");
        System.out.println("Hang dien may 1 (Dell, SL=1): " + dienMay1.danhGiaMucDoBanBuon());
        System.out.println("Hang dien may 2 (iPhone, SL=5): " + dienMay2.danhGiaMucDoBanBuon());
        System.out.println("Hang thuc pham 1 (Sua, SL=1): " + thucPham1.danhGiaMucDoBanBuon());
        System.out.println("Hang thuc pham 2 (Banh quy, het han, SL=5): " + thucPham2.danhGiaMucDoBanBuon());
        System.out.println("Hang gia dung 1 (Tach, SL=15, 29 ngay): " + giaDung1.danhGiaMucDoBanBuon());
        System.out.println("Hang gia dung 2 (Noi, SL=8, 3 ngay): " + giaDung2.danhGiaMucDoBanBuon());
        
        // Test phuong thuc dac biet cho hang gia dung
        System.out.println("\n--- TEST TINH NGAY TRONG KHO ---");
        System.out.println("Tach su da o trong kho " + giaDung1.tinhSoNgayTrongKho() + " ngay");
        System.out.println("Noi nau an da o trong kho " + giaDung2.tinhSoNgayTrongKho() + " ngay");
        
        // Test phuong thuc dac biet cho hang thuc pham
        System.out.println("\n--- TEST HET HAN THUC PHAM ---");
        System.out.println("Sua tuoi het han?: " + thucPham1.kiemTraHetHan());
        System.out.println("Banh quy het han?: " + thucPham2.kiemTraHetHan());
        
        System.out.println("\n========== KET THUC TEST ==========");
    }
}
