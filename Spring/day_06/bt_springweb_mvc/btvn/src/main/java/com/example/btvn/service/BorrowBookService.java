package com.example.btvn.service;

import com.example.btvn.entity.Book;
import com.example.btvn.entity.BorrowBook;
import com.example.btvn.entity.Reader;
import com.example.btvn.model.BookModel;
import com.example.btvn.model.BorrowBookModel;
import com.example.btvn.model.ReaderModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowBookService {
    ObjectMapper objectMapper;
    BookService bookService ;
    ReaderService readerService;

    private static List<BorrowBook> borrowBooks = new ArrayList<>();
    private static int AUTO_ID = 1;



    public List<BorrowBookModel> getAllBorrows() {  // do entity và model của borrowbook khác nhau nên phải convert bằng tay
        List<BorrowBookModel> rs = new ArrayList<>();
        borrowBooks.forEach(s->{
            BorrowBookModel borrowBookModel = BorrowBookModel.builder()
                    .id(s.getId())
                    .idBanDoc(s.getReader().getId())
                    .idSach(s.getBook().getId())
                    .tenBanDoc(s.getReader().getName())
                    .tenSach(s.getBook().getName())
                    .quantity(s.getQuantity())
                    .date(s.getDate())
                    .status(s.getStatus())

                    .build();

            rs.add(borrowBookModel);
        });
        return rs;

    }

    public void createNewBorrow(BorrowBookModel borrowBookModel) {
       if(borrowBookModel == null){
           return;
       }
       Integer idSach = borrowBookModel.getIdSach();

       BookModel bookModel = bookService.findById(idSach);
       Book book = objectMapper.convertValue(bookModel,Book.class);
       if(book == null){
           return;
       }
       Integer idBanDoc = borrowBookModel.getIdBanDoc();

        ReaderModel readerModel = readerService.findById(idBanDoc);
        Reader reader = objectMapper.convertValue(readerModel, Reader.class);
        if(reader == null){
            return;
        }
        BorrowBook borrowBook = BorrowBook.builder()
                .book(book)
                .reader(reader)
                .date(borrowBookModel.getDate())
                .quantity(borrowBookModel.getQuantity())
                .status(borrowBookModel.getStatus())
                .build();

        borrowBook.setId(AUTO_ID);
        AUTO_ID++;
        borrowBooks.add(borrowBook);
    }

}
