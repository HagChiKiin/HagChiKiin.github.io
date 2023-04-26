import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Scanner;


@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Worker {
    static int id = 1000;
    int maCongNhan;
    String name;
    String address;
    String phone;
    int bacTho;

    public Worker() {
        id++;
        this.maCongNhan = id;
    }

    public void addInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        name = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        address = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        phone = sc.nextLine();
        System.out.print("Nhap bac tho (tu 1 den 7): ");
        bacTho = Integer.parseInt(sc.nextLine());
    }

}

