import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Scanner;


@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Injection {
    static int id = 100;
    int maXuong;
    String tenXuong;
    String moTa;
    double heSoCongViec;

    public Injection() {
        id++;
        this.maXuong = id;
    }

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten xuong: ");
        tenXuong = sc.nextLine();
        System.out.print("Nhap mo ta: ");
        moTa = sc.nextLine();
        System.out.print("Nhap he so cong viec: ");
        heSoCongViec = Integer.parseInt(sc.nextLine());
    }
}
