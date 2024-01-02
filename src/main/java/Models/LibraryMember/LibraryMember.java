package Models.LibraryMember;

import Models.Book.Book;

import java.util.List;

public interface LibraryMember {

    int getId();
    String getName();
    String getEmail();
    List<Book> getBorrowedBooks();

    void borrowBook(Book book);
    Book returnBook(String title);
    void reserveBook(Book book);
    Book removeReservedBook(String title);
}
