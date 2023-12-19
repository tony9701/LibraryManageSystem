package Models.LibraryMember;

import Models.Book.Book;
import Utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class LibraryMemberImpl implements LibraryMember {

    private static int NEXT_ID;
    private int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks;

    protected LibraryMemberImpl(String name, String email) {
        setName(name);
        setEmail(email);
        this.id = ++NEXT_ID;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
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
        }

        throw new IllegalArgumentException(MEMBER_EMAIL_NOT_VALID);
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    @Override
    public List<Book> getReservedBooks() {
        return Collections.unmodifiableList(reservedBooks);
    }

    @Override
    public Book borrowBook(String name) {
        return null; //TODO IMPLEMENTATION
    }

    @Override
    public Book returnBook(String name) {
        return null; //TODO IMPLEMENTATION
    }

    @Override
    public Book reserveBook(String name) {
        return null; //TODO IMPLEMENTATION
    }
}
