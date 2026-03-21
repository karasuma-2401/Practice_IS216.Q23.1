import java.util.*;

public class Exercise5V {
    public static int[] Input(Scanner sc, int n) {
        int[] Array = new int[n];
        System.out.println("Nhap phan tu cho mang A:");
        for (int i = 0; i < Array.length; i++) {
            Array[i] = sc.nextInt();
        }
        return Array;
    }

    public static void Print(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }   
        System.out.println("]");
    }

    public static int[] CreateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nguyen n: ");
        int n = sc.nextInt();
        int[] A = Input(sc, n);

        System.out.print("Nhap so nguyen m: ");
        int m = sc.nextInt();
        int[] B = CreateRandomArray(m);
        System.out.print("Cac phan tu cua mang B duoc tao ngau nhien: ");
        Print(B);

        int[] C = Arrays.copyOf(A, A.length);
        System.arraycopy(B, B.length - 3, C, 0, 3);
        Arrays.sort(C);

        System.out.print("Mang C sau khi duoc thay the va sap xep: ");
        Print(C);

        sc.close();
    }
}
