package Models.Library;

import Models.Book.Book;

import java.lang.reflect.Member;
import java.util.List;

public interface Library {

    List<Book> getBooks();
    List<Book> getReservedBooks();
    List<Member> getMembers();


    boolean addBook();
    boolean removeBook();
    boolean addMember();
    boolean removeMember();

}
