import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 6;
        for (int i = arr.length - 1; i > 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[1] = 3;
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        for (int i : arr
        ) {
            System.out.print(i);
        }

    }
}

