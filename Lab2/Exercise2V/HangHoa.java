package Lab2_JavaOOP.Exercise2V;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected double donGia;
    protected int soLuong;
    
    public HangHoa() {
        maHang = "";
        tenHang = "";
        donGia = 0;
        soLuong = 0;
    }

    public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    
    // Getter methods
    public String getMaHang() {
        return maHang;
    }
    
    public String getTenHang() {
        return tenHang;
    }
    
    public double getDonGia() {
        return donGia;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    // Setter methods
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public abstract void xuat();
    
    public abstract double tinhThanhTien(int soLuongBan);
    
    public abstract String danhGiaMucDoBanBuon();
}
