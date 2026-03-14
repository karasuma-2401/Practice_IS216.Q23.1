import java.util.Scanner;

public class Exercise4V {

    public static boolean isPerfect (int n) {
        long sum  = 0;
        for (int i = 1; i < n; i++) {
            if (n % i ==0) {
                sum += i;
            }
        }
        System.out.println(sum);
        return sum == n;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen n: ");
        int n = sc.nextInt();

        if (isPerfect(n)) {
            System.out.println(n + " la so hoan hao");
        }
        else {
            System.out.println(n + " khong phai so hoan hao");
        }
        sc.close();
    }
}
