import org.apache.log4j.Logger;

import java.util.*;

public class Main {

    static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<Injection> injections = new ArrayList<>();
        ArrayList<TimeKeeping> time = new ArrayList<>();
        Worker worker = Worker.builder()
                .maCongNhan(1000)
                .name("kien")
                .address("dong anh")
                .phone("012345678")
                .bacTho(6)
                .build();
        System.out.println(worker);
        log.info(worker);
        // 1.Nhập danh sách công nhân mới
        int soCongNhan;
        System.out.print("Nhập số lượng công nhân cần thêm: ");
        soCongNhan = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < soCongNhan; i++) {
            Worker worker1 = new Worker();
            System.out.println("Nhập thông tin công nhân thứ " + (i + 1) + ":");
            worker1.addInfo();
            workers.add(worker1);
        }

        // In ra danh sách các công nhân đã có
        System.out.println("Danh sách các công nhân đã có:");
        for (Worker cn : workers) {
            System.out.println(cn);
        }

        //2. Nhập danh sách xưởng sản xuất
        int soXuongSanXuat;
        System.out.print("Nhập số lượng xưởng sản xuất cần thêm: ");
        soXuongSanXuat = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < soXuongSanXuat; i++) {
            Injection inj = new Injection();
            System.out.println("Nhập thông tin xưởng sản xuất thứ " + (i + 1) + ":");
            inj.addInfo();
            injections.add(inj);
        }

        // In ra danh sách xưởng sản xuất đã có
        System.out.println("Danh sách các xưởng sản xuất đã có:");
        for (Injection sx : injections) {
            System.out.println(sx);
        }

        // 3.Lập Bảng danh sách chấm công cho từng công nhân và in danh sách ra màn hình
        // 5. tính lương công nhân
        for (int i = 0; i < workers.size(); i++) {
            System.out.print("Nhập số lượng ngày công của công nhân " + workers.get(i).getMaCongNhan() + " trong tháng: ");
            int soNgayCong = sc.nextInt();
            TimeKeeping bcc = new TimeKeeping(workers.get(i), injections.get(i), soNgayCong);
            bcc.inBangChamCong();
            double luong = 450000 * workers.get(i).getBacTho() * bcc.getInjection().getHeSoCongViec() * (soNgayCong / 22);
            System.out.println(luong);
        }
        // 4.Sắp xếp bảng chấm công theo công nhân
        Collections.sort(time, Comparator.comparing(o -> o.getWoker().getName()));
        System.out.println("Danh sách bảng chấm công:");
        for (TimeKeeping tk : time) {
            System.out.println(tk);
        }
        // Sap xep theo xuong
        Collections.sort(time, Comparator.comparing(o -> o.getInjection().getTenXuong()));
        for (TimeKeeping tk : time) {
            System.out.println(tk);
        }

        //5. Lập bảng kê thu nhập cho mỗi công nhân


    }
}


