
import java.util.Scanner;

public class Exercise2V {
    public static void cd( int n ) {
        for (int i = 1; i <= n; i++) {
            if (n % i ==0) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n = sc.nextInt();
        cd(n);

        sc.close();
    }
}
