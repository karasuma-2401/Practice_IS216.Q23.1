import java.util.Scanner;

public class Exercise3IV {
    public static void main(String[] args) {
        run();
    }

    private static PhanSo nhapPhanSoTuConsole(Scanner sc) {
        System.out.print("Nhap Tu So: ");
        int tu = sc.nextInt();
        System.out.print("Nhap Mau So: ");
        int mau = sc.nextInt();
        return new PhanSo(tu, mau);
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Nhap Phan So 1");
            PhanSo ps1 = nhapPhanSoTuConsole(sc);

            System.out.println("Nhap Phan So 2");
            PhanSo ps2 = nhapPhanSoTuConsole(sc);

            System.out.println("\nKet Qua");
            System.out.println("Phan So 1: " + ps1);
            System.out.println("Phan So 2: " + ps2);

            System.out.println("Tong: " + ps1.cong(ps2));
            System.out.println("Hieu: " + ps1.tru(ps2));
            System.out.println("Tich: " + ps1.nhan(ps2));
            System.out.println("Thuong: " + ps1.chia(ps2));

        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

class PhanSo {
    private int tu;
    private int mau;

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }
        this.tu = tu;
        this.mau = mau;
        rutGon(); 
    }

    // Tim UCLN 
    private int timUCLN(int a, int b) {
        if(b == 0){
            return a;
        }
        return timUCLN(b, a % b);
    }

    private void rutGon() {
        int ucln = timUCLN(this.tu, this.mau);
        this.tu /= ucln;
        this.mau /= ucln;
        
        if (this.mau < 0) {
            this.tu = -this.tu;
            this.mau = -this.mau;
        }
    }

    public PhanSo cong(PhanSo ps) {
        int tuMoi = this.tu * ps.mau + ps.tu * this.mau;
        int mauMoi = this.mau * ps.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo tru(PhanSo ps) {
        int tuMoi = this.tu * ps.mau - ps.tu * this.mau;
        int mauMoi = this.mau * ps.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo nhan(PhanSo ps) {
        int tuMoi = this.tu * ps.tu;
        int mauMoi = this.mau * ps.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo chia(PhanSo ps) {
        if (ps.tu == 0) {
            throw new IllegalArgumentException("So bi chia khong the la 0");
        }
        int tuMoi = this.tu * ps.mau;
        int mauMoi = this.mau * ps.tu;
        return new PhanSo(tuMoi, mauMoi);
    }

    @Override
    public String toString() {
        if (mau == 1) return String.valueOf(tu); 
        if (tu == 0) return "0";
        return tu + "/" + mau;
    }
}