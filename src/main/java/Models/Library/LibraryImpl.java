package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;
import Utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class LibraryImpl implements Library {

    private HashMap<String, Book> availableBooks;
    private HashMap<String, Book> reservedBooks;
    private HashMap<String, Book> borrowedBooks;
    private HashMap<String, LibraryMember> members;
    private List<String> transactions;

    public LibraryImpl() {
        this.availableBooks = new HashMap<>();
        this.reservedBooks = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
        this.members = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    //returns unmodifiable list of books.
    @Override
    public List<Book> getAvailableBooks() {
        return Collections.unmodifiableCollection(availableBooks.values()).stream().toList();
    }

    @Override
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableCollection(borrowedBooks.values()).stream().toList();
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
    public List<String> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }


    @Override
    public String setTransaction(String str) {
        transactions.add(str);
        return str;
    }

    @Override
    public void addBook(Book book) {
        //check if book already exist in the library and throw if so.
        if (Validator.isBookExist(book, availableBooks) ||
            Validator.isBookExist(book, borrowedBooks) ||
            Validator.isBookExist(book, reservedBooks)) {

            throw new IllegalArgumentException(String.format(BOOK_ALREADY_EXIST, book.getTitle()));
        }

        availableBooks.put(book.getTitle(), book);
    }

    @Override
    public void removeBook(Book book) {
        if (Validator.isBookExist(book, availableBooks)) {
            availableBooks.remove(book.getTitle());
        } else if (Validator.isBookExist(book, borrowedBooks)) {
            borrowedBooks.remove(book.getTitle());
        } else if (Validator.isBookExist(book, reservedBooks)) {
            reservedBooks.remove(book.getTitle());
        }
    }

    @Override
    public boolean addMember(LibraryMember member) {
        return false;
    }

    @Override
    public boolean removeMember(LibraryMember member) {
        return false;
    }

    @Override
    public Book searchBook(String title) {
        return null;
    }

    @Override
    public LibraryMember searchMember(String name) {
        return null;
    }
}
