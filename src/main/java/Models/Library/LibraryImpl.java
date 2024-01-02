package Models.Library;

import Models.Book.Book;
import Models.LibraryMember.LibraryMember;
import Models.Reservation.Reservation;
import Models.Reservation.ReservationImpl;
import Utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class LibraryImpl implements Library {

    private HashMap<String, Book> availableBooks;
    private HashMap<String, Reservation> reservedBooks; //TODO fix this create reservation class
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
        return Collections.unmodifiableCollection(reservedBooks.values())
                .stream()
                .map(Reservation::getBook)
                .collect(Collectors.toList());
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
        if (bookIsPresent(book.getTitle())) {
            throw new IllegalArgumentException(String.format(BOOK_ALREADY_EXIST, book.getTitle()));
        }

        availableBooks.put(book.getTitle(), book);
    }

    @Override
    public void removeBook(String title) {

        if (availableBooks.containsKey(title)) {
            availableBooks.remove(title);
        } else if (borrowedBooks.containsKey(title)) {
            borrowedBooks.remove(title);
        } else if (reservedBooks.containsKey(title)) {
            reservedBooks.remove(title);
        } else {
            throw new IllegalArgumentException(String.format(BOOK_NOT_EXIST, title));
        }

    }

    @Override
    public Book removeAvailableBook(String title) {
        Book book = availableBooks.remove(title);

        throwIfBookNull(title, book);

        return book;
    }

    @Override
    public Book addReservedBook(String title) { //TODO  need reserve method
        Book book = borrowedBooks.get(title);

        throwIfBookNull(title, book);
        Reservation reservation = createReservation(title, book);

        reservedBooks.put(title, reservation);

        return book;
    }

    @Override
    public Book removeReservedBook(String title) { // check if remove
        Book book = reservedBooks.remove(title).getBook();

        throwIfBookNull(title, book);

        return book;
    }

    @Override
    public void addBorrowedBook(String title) {
        Book book = availableBooks.remove(title);

        throwIfBookNull(title, book);

        borrowedBooks.put(title, book);
    }

    @Override
    public Book removeBorrowedBook(String title) {
        Book book = borrowedBooks.remove(title);

        throwIfBookNull(title, book);

        return book;
    }

    @Override
    public void addMember(LibraryMember member) {
        if (members.containsKey(member.getName())) {
            throw new IllegalArgumentException(String.format(MEMBER_ALREADY_EXIST, member.getName()));
        }

        members.put(member.getName(), member);
    }

    @Override
    public void removeMember(LibraryMember member) {
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

    private static void throwIfBookNull(String title, Book book) {
        if (book == null) {
            throw new IllegalArgumentException(String.format(BOOK_NOT_EXIST, title));
        }
    }

    @Override
    public Book getAvailableBook(String title) {
        Book book = availableBooks.get(title);

        if (book == null) {
            throw new IllegalArgumentException(String.format(BOOK_NOT_AVAILABLE, title));
        }

        return book;
    }

    private boolean bookIsPresent(String title) {
        return Validator.bookIsPresent(title, availableBooks) ||
                Validator.bookIsPresent(title, borrowedBooks);
    }

    private Reservation createReservation(String name, Book book) {
        return new ReservationImpl(name, book);
    }
}
