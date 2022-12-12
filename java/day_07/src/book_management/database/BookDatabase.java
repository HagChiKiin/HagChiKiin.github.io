package book_management.database;

import book_management.model.Book;

// Fake database books
public class BookDatabase {
    public static Book[] books = {
            new Book(1, "Người khốn khổ","Victor Hugo","Tiểu thuyết","A. Lacroix",1862),
            new Book(2, "Dế mèn phiêu lưu ký","Tô Hoài","Thiếu nhi","Kim Đồng",1941),
            new Book(3, "Đắc nhân tâm","Dale Carnegie","Sách tự lực","Phạm Văn Tươi",1936),
            new Book(4, "Con mèo con","Nguyễn Kiên","Con vật","HarryKien",2022),
            new Book(5, "Con lợn con","Kiên con","Thiếu nhi","Con Kiên",2022),
    };
}