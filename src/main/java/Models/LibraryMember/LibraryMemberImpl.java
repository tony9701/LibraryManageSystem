package Models.LibraryMember;

import Models.Book.Book;
import Utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class LibraryMemberImpl implements LibraryMember {

    private static int NEXT_ID;
    private final int id;
    private String name;
    private String email;
    private List<Book> borrowedBooks;


    public LibraryMemberImpl(String name, String email) {
        setName(name);
        setEmail(email);
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
        return Collections.unmodifiableList(borrowedBooks);
    }

    @Override
    public Book borrowBook(String title) {
        return null; //TODO IMPLEMENTATION
    }

    @Override
    public Book returnBook(String title) {
        return null; //TODO IMPLEMENTATION
    }

    @Override
    public Book reserveBook(String title) {
        return null; //TODO IMPLEMENTATION
    }
}
