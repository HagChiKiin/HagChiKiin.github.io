import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 1, 2};
//        selectionSort(arr);
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        String[] name = {"Tai" , "Anh" ,"Kien","Dung"};
        Student[] students = {
                new Student("Nguyễn Kiên",16 ,8),
                new Student("Phạm Anh",18 ,9),
                new Student("Trần Tiên",10 ,7)};
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        });
        System.out.println(Arrays.toString(students));

        System.out.println("List");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nguyễn Kiên",16 ,8));
        studentList.add(new Student("Phạm Anh",18 ,9));
        studentList.add(new Student("Trần Tiên",10 ,7));
        Collections.sort(studentList);
        System.out.println(studentList);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.print(i + ": "); // in ra từng lượt sort
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int keyNumber = arr[i];
            int j = i - 1; // Vị trí bắt đầu duyệt của mảng phía trái
            while (j >= 0 && arr[j] > keyNumber) {
                arr[j + 1] = arr[j]; // dịch sang để chèn
                j--;
            }
            arr[j + 1] = keyNumber; // tại j thì arr[j]  < keyNumber
            System.out.println(i + ": "); // in ra từng lượt sort
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapper = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapper = true;
                }
            }
            System.out.println(i + ": "); // in ra từng lượt sort
            System.out.println(Arrays.toString(arr));
            if (!isSwapper) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
