package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;


import java.util.List;

public interface Library {

    List<Book> getAvailableBooks();
    List<Book> getBorrowedBooks();
    List<Book> getReservedBooks();
    List<LibraryMember> getMembers();


    boolean addBook(Book book);
    boolean removeBook(Book book);
    boolean addMember(LibraryMember member);
    boolean removeMember(LibraryMember member);
    Book searchBook(String title);
    LibraryMember searchMember(String name);

}
