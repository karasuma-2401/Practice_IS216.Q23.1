import java.util.*;

public class Exercise6V {
    private int[][] Array;

    public class MaxValue{
        private int value;
        private ArrayList<Integer> rowPositions = new ArrayList<Integer>();
        private ArrayList<Integer> colPositions = new ArrayList<Integer>();

        public MaxValue(int val, int r, int c) {
            value = val;
            rowPositions.add(r);
            colPositions.add(c);
        }

        // public int GetValue() {
        //     return value;
        // }

        // public ArrayList<Integer> GetRowPositions() {
        //     return rowPositions;
        // }

        // public ArrayList<Integer> GetColumnPositions() {
        //     return colPositions;
        // }

        public void SetNewValue(int val, int r, int c) {
            value = val;
            rowPositions.clear(); rowPositions.add(r);
            colPositions.clear(); colPositions.add(c);
        }

        public void AddPosition(int r, int c) {
            rowPositions.add(r);
            colPositions.add(c);
        }
    }

    public Exercise6V(int n, int m) {
        Array = new int[n][m];
    }

    public void Input(Scanner sc) {
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                Array[i][j] = sc.nextInt();
            }
        }
    }

    public static void Print(int[][] Array) {
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                System.out.print(Array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public MaxValue FindIndexOfMax() {
        MaxValue max = new MaxValue(Array[0][0], 0, 0);

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                int val = Array[i][j];
                if (val > max.value) {
                    max.SetNewValue(val, i, j);
                }
                else if (val == max.value) {
                    max.AddPosition(i, j);
                }
            }
        }

        return max;
    }

    public int[][] CreatePrimeArray(int n, int m) {
        int[][] primeArray = new int[n][m];

        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                primeArray[i][j] = Exercise7IV.isPrime(Array[i][j]) ? Array[i][j] : 0;
            }
        }

        return primeArray;
    }

    public void SortByColumn() {
        for (int j = 0; j < Array[0].length; j++) {
            int[] temp = new int[Array.length];

            for (int i = 0; i < Array.length; i++) {
                temp[i] = Array[i][j];
            }

            Arrays.sort(temp);

            for (int i = 0; i < Array.length; i++) {
                Array[i][j] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so nguyen n: ");
        int n = sc.nextInt();
        System.out.print("Nhap so nguyen m: ");
        int m = sc.nextInt();

        Exercise6V ex = new Exercise6V(n, m);
        ex.Input(sc);

        MaxValue max = ex.FindIndexOfMax();
        System.out.println("Phan tu lon nhat trong mang la: " + max.value);
        System.out.print("Chi so cua phan tu lon nhat: ");
        for (int i = 0; i < max.rowPositions.size(); i++) {
            System.out.print("[ " + max.rowPositions.get(i) + ", " + max.colPositions.get(i) + " ] ");
        }
        System.out.println();

        int[][] prime = ex.CreatePrimeArray(n, m);
        System.out.println("Ma tran so nguyen to tu ma tran A:");
        Print(prime);

        ex.SortByColumn();
        System.out.println("Ma tran A sau khi sap xep tang dan theo cot: ");
        Print(ex.Array);

        sc.close();
    }
}
