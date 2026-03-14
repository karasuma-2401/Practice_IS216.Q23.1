import java.util.Scanner;

public class Exercise3V {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Nhap Phan So");
            PhanSo ps = nhapPhanSoTuConsole(sc);

            System.out.println("\nKet qua sau khi rut gon");
            System.out.println("Phan So: " + ps);
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static PhanSo nhapPhanSoTuConsole(Scanner sc) {
        System.out.print("Nhap Tu So: ");
        int tu = sc.nextInt();
        System.out.print("Nhap Mau So: ");
        int mau = sc.nextInt();
        return new PhanSo(tu, mau);
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
}