import java.util.Scanner;

public class Exercise6IV {

    static Scanner sc = new Scanner(System.in);

    public static void run() {
        int choice;

        do {
            System.out.println("#######################################");
            System.out.println("1. Bài 1");
            System.out.println("2. Bài 2");
            System.out.println("3. Bài 3");
            System.out.println("4. Bài 4");
            System.out.println("5. Bài 5");
            System.out.println("6. Thoát");
            System.out.println("#######################################");

            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Exercise1IV.run();
                    break;
                case 2:
                    Exercise2IV.run();
                    break;
                case 3:
                    Exercise3IV.run(); 
                    break;
                case 4:
                    Exercise4IV.run(); 
                    break;
                case 5:
                    Exercise5IV.run(); 
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Chọn từ 1 đến 6");
            }

        } while (choice != 6);
    }

    public static void main(String[] args) {
        run();
    }
}