import java.util.Scanner;

public class Bai5 {

    static Scanner sc = new Scanner(System.in);

    public static void tinhTienDien() {
        System.out.print("Nhập số điện sử dụng (kWh): ");
        int soDien = sc.nextInt();

        int tien = 0;

        if (soDien <= 50) {
            tien = soDien * 2000;
        } 
        else if (soDien <= 100) {
            tien = 50 * 2000 + (soDien - 50) * 2500;
        } 
        else {
            tien = 50 * 2000 + 50 * 2500 + (soDien - 100) * 3500;
        }

        System.out.println("Tiền điện phải trả: " + tien + " đ");
    }

    public static void run() {
        tinhTienDien();
    }
}