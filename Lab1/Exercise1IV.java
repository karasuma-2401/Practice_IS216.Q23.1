import java.util.Scanner;

public class Bai1 {

    static Scanner sc = new Scanner(System.in);

    public static void tinhChuVi() {
        System.out.print("Nhập bán kính: ");
        double r = sc.nextDouble();

        double chuVi = 2 * Math.PI * r;
        System.out.println("Chu vi đường tròn: " + chuVi);
    }

    public static void run() {
        tinhChuVi();
    }
}