import java.util.Scanner;

public class Exercise2IV {

    static Scanner sc = new Scanner(System.in);

    public static void chiaHaiSo() {
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();

        System.out.print("Nhập b: ");
        double b = sc.nextDouble();

        if (b == 0) {
            System.out.println("Không thể chia cho 0");
            return;
        }

        System.out.printf("Kết quả a/b = %.3f\n", a / b);
    }

    public static void run() {
        chiaHaiSo();
    }
}