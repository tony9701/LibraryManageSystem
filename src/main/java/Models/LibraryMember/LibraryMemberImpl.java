package Models.LibraryMember;

import Models.Book.Book;
import Utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class LibraryMemberImpl implements LibraryMember {

    private static int NEXT_ID;
    private final int id;
    private String name;
    private String email;
    private HashMap<String, Book> borrowedBooks;
    private HashMap<String, Book> reservedBooks;


    public LibraryMemberImpl(String name, String email) {
        setName(name);
        setEmail(email);
        this.id = ++NEXT_ID;
        this.borrowedBooks = new HashMap<>();
        this.reservedBooks = new HashMap<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (Validator.nameIsValid(name)) {
            this.name = name;
            return;
        }

        throw new IllegalArgumentException(MEMBER_NAME_EMPTY_OR_NULL);
    }

    @Override
    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (Validator.emailIsValid(email)) {
            this.email = email;
            return;
        }

        throw new IllegalArgumentException(MEMBER_EMAIL_NOT_VALID);
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableCollection(borrowedBooks.values()).stream().toList();
    }

    @Override
    public void borrowBook(Book book) {
        borrowedBooks.put(book.getTitle(), book);
    }

    @Override
    public Book returnBook(String title) {
        Book book = borrowedBooks.remove(title);

        if (book == null) {
            throw new IllegalArgumentException(String.format(BOOK_NOT_EXIST, title));
        }

        return book;
    }

    @Override
    public void reserveBook(Book book) {
        reservedBooks.put(book.getTitle(), book);
    }

}
