package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;


import java.util.List;

public interface Library {

    List<Book> getAvailableBooks();
    List<Book> getBorrowedBooks();
    List<Book> getReservedBooks();
    List<LibraryMember> getMembers();
    List<String> getTransactions();
    String setTransaction(String str);


    void addAvailableBook(Book book);
    void removeAvailableBook(String title);
    void addReservedBook(String title);
    void removeReservedBook(String title);
    void addBorrowedBook(String title);
    void removeBorrowedBook(String title);
    void addMember(LibraryMember member);
    void removeMember(LibraryMember member);
    LibraryMember searchMember(String name);
    Book bookIsAvailable(String title);

}
