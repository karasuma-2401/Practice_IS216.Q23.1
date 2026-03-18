package Lab1;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise8IV {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Nhap so phan tu n: ");
        int n = scanIn.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanIn.nextInt();
        }

        System.out.println("Mang: " + Arrays.toString(arr));

        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println("Phan tu lon nhat: " + max);
        System.out.println("Phan tu nho nhat: " + min);

        System.out.print("Nhap so x can kiem tra: ");
        int x = scanIn.nextInt();
        int[] arrSorted = arr.clone();
        Arrays.sort(arrSorted);
        int idx = Arrays.binarySearch(arrSorted, x);
        if (idx >= 0) {
            System.out.println("x co trong mang (sau khi sap xep, tai chi so " + idx + ").");
        } else {
            System.out.println("x khong nam trong mang.");
        }

        int dem = 0;
        for (int v : arr) {
            if (v == x) dem++;
        }
        System.out.println("So phan tu co gia tri bang x: " + dem);

        Arrays.sort(arr);
        System.out.println("Mang sau khi sap xep tang dan: " + Arrays.toString(arr));
        scanIn.close();
    }
}
