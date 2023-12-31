package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;
import Models.Reservation.Reservation;


import java.util.List;

public interface Library {

    List<Book> getAvailableBooks();
    List<Book> getBorrowedBooks();
    List<Book> getReservedBooks();
    List<LibraryMember> getMembers();
    List<String> getTransactions();
    String setTransaction(String str);


    void addBook(Book book);
    void removeBook(String title);
    Book removeAvailableBook(String title);
    Book addReservedBook(String title);
    Reservation removeReservation(String title);
    void addBorrowedBook(String title);
    Book removeBorrowedBook(String title);
    void addMember(LibraryMember member);
    void removeMember(LibraryMember member);
    LibraryMember searchMember(String name);
    Book getAvailableBook(String title);
    boolean reservedBookChecker(String title);
}
