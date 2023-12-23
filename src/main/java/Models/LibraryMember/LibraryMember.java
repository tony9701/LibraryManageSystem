package Models.LibraryMember;

import Models.Book.Book;

import java.util.List;

public interface LibraryMember {

    int getId();
    String getName();
    String getEmail();
    List<Book> getBorrowedBooks();

    Book borrowBook(String title);
    Book returnBook(String title);
    Book reserveBook(String title);
}
