
import java.util.Scanner;



public class Exercise1V {
    public static int gcd (int a, int b) {
        a = Math.abs(a);   
        b = Math.abs(b);
        while ( b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }   
        return a;
    }
    public static  int lcm (int a, int b) {
        if ( a == 0 || b ==0) {
            return 0;
        }
        return Math.abs(a*b) / gcd(a,b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao hai so a va b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("UCLN cua a va b la: " + gcd(a,b)) ;
        System.out.println("BCNN cua a va b la: " + lcm(a, b));

        sc.close();
    }
}
