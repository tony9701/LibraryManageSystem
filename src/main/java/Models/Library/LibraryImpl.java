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
    private HashMap<String, Book> reservedBooks;   //TODO create addBook and removeBook methods!
    private HashMap<String, Book> borrowedBooks;   //TODO create addBook and removeBook methods!
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
    public void addAvailableBook(Book book) {
        //check if book already exist in the library and throw if so.
        if (bookIsPresent(book.getTitle())) {
            throw new IllegalArgumentException(String.format(BOOK_ALREADY_EXIST, book.getTitle()));
        }

        availableBooks.put(book.getTitle(), book);
    }

    @Override
    public void removeAvailableBook(String title) { // check for problems
        boolean bookIsRemoved = Validator.removeBookIfPresent(title, availableBooks, borrowedBooks, reservedBooks);

        if (!bookIsRemoved) {
            throw new IllegalArgumentException(String.format(BOOK_NOT_EXIST, title));
        }
    }

    @Override
    public void addReservedBook(String title) {

    }

    @Override
    public void removeReservedBook(String title) {

    }

    @Override
    public void addBorrowedBook(String title) {

    }

    @Override
    public void removeBorrowedBook(String title) {

    }

    @Override
    public void addMember(LibraryMember member) {
        if (members.containsKey(member.getName())) {
            throw new IllegalArgumentException(String.format(MEMBER_ALREADY_EXIST, member.getName()));
        }

        members.put(member.getName(), member);
    }

    @Override
    public void removeMember(LibraryMember member) { // check if remove properly
        members.remove(member.getName());
    }

    @Override
    public LibraryMember searchMember(String name) {
        LibraryMember member = members.get(name);

        if (member == null) {
            throw new IllegalArgumentException(String.format(MEMBER_NOT_EXIST, name));
        }

        return member;
    }

    @Override
    public Book bookIsAvailable(String title) {
        Book book = availableBooks.get(title);

        if (book == null) {
            throw new IllegalArgumentException(String.format(BOOK_NOT_AVAILABLE, title));
        }

        return book;
    }

    private boolean bookIsPresent(String title) {
        return Validator.bookIsPresent(title, availableBooks) ||
                Validator.bookIsPresent(title, borrowedBooks) ||
                Validator.bookIsPresent(title, reservedBooks);
    }
}
