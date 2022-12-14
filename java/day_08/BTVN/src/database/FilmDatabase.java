package database;

import model.Movie;
import model.Serial;

public class FilmDatabase {
    public static Movie[] movies = {
            new Movie(1, "Con mèo con","hoạt hình","Kiên nguyễn","15 tháng 12 năm 1993",180),
            new Movie(2, "Con vịt con","người lớn","Kiên con","15 tháng 12 năm 2000",185),
            new Movie(3, "Con lợn con","viễn thông","Kiên to","05 tháng 12 năm 2001",190),
            new Movie(4, "Con ngan con","chính trị","Kiên béo","15 tháng 12 năm 2022",200),
    };
    public static Serial[] serials = {
            new Serial(5, "Con heo to","hoạt hình","Hằng nguyên","12 tháng 11 năm 1993",5,80.5),
            new Serial(6, "Con trăn to","khoa học","thu hằng","11 tháng 1 năm 196",6,45.7),
            new Serial(7, "Con hổ to","kiếm hiệp","Quỳnh chi","15 tháng 2 năm 1997",7,40.9),
            new Serial(8, "Con báo to","tiên hiệp","Chi pu","14 tháng 5năm 1998",8,60),
    };
}
