package Models.LibraryMember;

import Models.Book.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryMemberImpl implements LibraryMember {

    private static int NEXT_ID;
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;

    public LibraryMemberImpl(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = ++NEXT_ID;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    @Override
    public Book borrowBook(String name) {
        return null;
    }

    @Override
    public Book returnBook(String name) {
        return null;
    }

    @Override
    public Book reserveBook(String name) {
        return null;
    }
}
