package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;


import java.lang.reflect.Member;
import java.util.List;

public interface Library {

    List<Book> getBooks();
    List<Book> getReservedBooks();
    List<LibraryMember> getMembers();


    boolean addBook(Book book);
    boolean removeBook(Book book);
    Book searchBook(String title);
    boolean addMember(LibraryMember member);
    boolean removeMember(LibraryMember member);

}
