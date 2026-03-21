import java.util.Scanner;

public class Exercise4IV {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Nhap chuoi x: ");
        String x = scanIn.nextLine();
        System.out.print("Nhap chuoi y: ");
        String y = scanIn.nextLine();

        System.out.println("Do dai chuoi x: " + x.length());

        if (x.length() >= 3) {
            System.out.println("3 ky tu dau cua x: " + x.substring(0, 3));
            System.out.println("3 ky tu cuoi cua x: " + x.substring(x.length() - 3));
        } else {
            System.out.println("3 ky tu dau/cuoi cua x: (x qua ngan) " + x);
        }

        if (x.length() >= 6) {
            System.out.println("Ky tu thu 6 cua x: " + x.charAt(5));
        } else {
            System.out.println("Ky tu thu 6 cua x: (x co it hon 6 ky tu)");
        }

        String dauX = x.length() >= 3 ? x.substring(0, 3) : x;
        String cuoiY = y.length() >= 3 ? y.substring(y.length() - 3) : y;
        System.out.println("Chuoi moi (3 dau x + 3 cuoi y): " + dauX + cuoiY);

        System.out.println("x equals y (phan biet hoa thuong): " + x.equals(y));
        System.out.println("x equals y (khong phan biet): " + x.equalsIgnoreCase(y));

        int viTri = x.indexOf(y);
        if (viTri >= 0) {
            System.out.println("y xuat hien trong x tai vi tri dau tien: " + viTri);
            System.out.print("Tat ca vi tri y trong x: ");
            int pos = 0;
            while ((pos = x.indexOf(y, pos)) != -1) {
                System.out.print(pos + " ");
                pos++;
            }
            System.out.println();
        } else {
            System.out.println("y khong xuat hien trong x.");
        }
        scanIn.close();
    }
}
