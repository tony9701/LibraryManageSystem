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


    void addBook(Book book);
    void removeBook(String title);
    void addMember(LibraryMember member);
    void removeMember(LibraryMember member);
    LibraryMember searchMember(String name);

}
