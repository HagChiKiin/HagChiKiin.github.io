package generic;

public class GenericMethod {
    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArray = { 10, 20, 30, 40, 50 };
        Character[] charArray = { 'J', 'A', 'V', 'A' };

        System.out.print("Mang so nguyen: ");
        printArray(intArray);

        System.out.print("Mang ky tu: ");
        printArray(charArray);

    }
}
