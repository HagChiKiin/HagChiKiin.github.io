import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeKeeping {
    Worker woker;
    Injection injection;
    int numberOfWorkingDays;

    public void inBangChamCong() {
        System.out.println("Bảng chấm công của công nhân " + woker.getMaCongNhan() + " - " + woker.getName());
        System.out.println("Xưởng sản xuất: " + injection.getTenXuong() + " - Hệ số công việc: " + injection.getHeSoCongViec());
        System.out.println("Số ngày công trong tháng: " + numberOfWorkingDays);

    }
}

