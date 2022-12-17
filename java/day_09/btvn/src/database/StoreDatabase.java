package database;

import model.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreDatabase {
    public static ArrayList<Store> store = new ArrayList<>(List.of(
            new Store(1,"Leesin","Nộ Long Cước",7,40000),
            new Store(2,"Kalista","Định Mệnh Vẫy Gọi",2,60000),
            new Store(3,"Thres","Án Tử",3,70000),
            new Store(4,"Lissandra","Hầm Mộ Hàn Băng",4,110000),
            new Store(5,"Sett","Hủy Diệt Đấu Trường",9,200000),
            new Store(6,"Malphite","Không Thể Cản Phá",6,20000)

    ));
}
