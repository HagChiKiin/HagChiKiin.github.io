import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Cách 1 : Khai báo sô lượng phần tử cho mảng
        int[] numbers = new int[3]; // Mảng có 3 phần tử

        // Khai báo giá trị cho các phần tử theo chỉ số
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers));

        // Cách 2 : Khai báo và khởi tạo giá trị cho mảng
        String[] names = {"hiên", "an", "huy"};
        System.out.println(Arrays.toString(names));

                    // Tương đương
                    String[] namesOther = new String[]{"hiên", "an", "huy"};
                    System.out.println(Arrays.toString(namesOther));
        // Cập nhật giá trị cho phần tử mảng
        int[] numbers1 = {1,2,3,4,5};
        numbers1[0] = 10;
        numbers1[1] = 20;

        System.out.println(Arrays.toString(numbers1)); // {10, 20, 3, 4, 5}

        // Reference Type
        String [] emails = {" a@gmail.com" , "b@gmail.com" , "c@gmail.com"};
        String [] emailsOther = emails; // địa chỉ ô nhớ
        System.out.println("emails : "+ Arrays.toString(emails));
        System.out.println("emailsOther" + Arrays.toString(emailsOther));

        emailsOther[0] = "d@gmail.com";
        System.out.println("email after "+Arrays.toString(emails));
        System.out.println("emailOther after "+Arrays.toString(emailsOther));
            // duyệt mảng  duyệt qua chỉ số phần tử (fori + while + dowhile)
        String[] name1 = {"Nguyễn Văn A", "Trần Văn B", "Ngô Thị C"};

        int i = 0;
        while(i < name1.length){
            System.out.println(names[i]);
            i++;
        }
        // duyệt mảng for each : duyệt qua giá trị
        for (String name2 : name1
             ) {
            System.out.println(name2);

        }

        //Tính tổng các giá trị trong mảng

// Khai báo mảng numbers
        int[] number3 = {1, 2, 3, 4, 5, 6};
        int sum = 0;

// Duyệt qua các mảng numbers để tính tổng
        for (int number: number3) {
            sum += number;
        }

        System.out.println("Sum = " + sum);

        // convert
        String message = "  Một ngàY nào  Đó";

    }

}
