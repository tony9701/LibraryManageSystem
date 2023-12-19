package Models.Library;

import Models.Book.Book;

import java.lang.reflect.Member;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LibraryImpl implements Library {

    private HashMap<String, Book> books;
    private HashMap<String, Book> reservedBooks;
    private HashMap<String, Member> members;



    //returns unmodifiable list of books.
    @Override
    public List<Book> getBooks() {
        return Collections.unmodifiableCollection(books.values()).stream().toList();
    }

    //returns unmodifiable list of reserved books.
    @Override
    public List<Book> getReservedBooks() {
        return Collections.unmodifiableCollection(reservedBooks.values()).stream().toList();
    }

    //returns unmodifiable list of members.
    @Override
    public List<Member> getMembers() {
        return Collections.unmodifiableCollection(members.values()).stream().toList();
    }

    @Override
    public boolean addBook() {
        return false;
    }

    @Override
    public boolean removeBook() {
        return false;
    }

    @Override
    public boolean addMember() {
        return false;
    }

    @Override
    public boolean removeMember() {
        return false;
    }
}
