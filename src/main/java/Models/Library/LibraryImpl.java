package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;

import java.lang.reflect.Member;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LibraryImpl implements Library {

    private HashMap<String, Book> books;
    private HashMap<String, Book> reservedBooks;
    private HashMap<String, LibraryMember> members;

    public LibraryImpl() {
        this.books = new HashMap<>();
        this.reservedBooks = new HashMap<>();
        this.members = new HashMap<>();
    }

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
    public List<LibraryMember> getMembers() {
        return Collections.unmodifiableCollection(members.values()).stream().toList();
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean removeBook(Book book) {
        return false;
    }

    @Override
    public Book searchBook(String title) {
        return false;
    }

    @Override
    public boolean addMember(LibraryMember member) {
        return false;
    }

    @Override
    public boolean removeMember(LibraryMember member) {
        return false;
    }
}
