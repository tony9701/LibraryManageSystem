package Core.Engine;

import Models.Book.Book;
import Models.Book.BookImpl;
import Models.Library.Library;
import Models.Library.LibraryImpl;
import Models.LibraryMember.LibraryMember;
import Models.LibraryMember.LibraryMemberImpl;
import Models.Reservation.Reservation;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Common.ConstantMessages.ConstantMessages.*;
import static Common.ExceptionMessages.ExceptionMessages.BOOK_NOT_AVAILABLE;

public class EngineImpl implements Engine {

    private Book book;
    private Library library;
    private LibraryMember libraryMember;
    private final Scanner sc;

    public EngineImpl() {
        this.library = new LibraryImpl();
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            String result;

            try {
                result = processInput();

                if ("Exit".equals(result)) {
                    break;
                } else if ("Help".equals(result)) {
                    System.out.println(helpInfo());
                    continue;
                }

            } catch (NullPointerException | IllegalArgumentException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }


    //TODO need to add reserve methods!

    private String helpInfo() {
        return String.format("Commands:%n" +
                "----------------------------------------------------------%n" +
                "-> AddBook {title}, {genre}, {author}, {yearPublished}%n" +
                "-> RemoveBook {title}%n" +
                "-> AddMember {memberName}, {email}%n" +
                "-> RemoveMember {memberName}" +
                "-> BorrowBook {memberName}, {bookTitle}%n" +
                "-> ReturnBook {memberName}, {bookTitle}%n" +
                "-> ReserveBook {memberName}, {bookTitle}%n" +
                "-> Available Books%n" +
                "-> Borrowed Books%n" +
                "-> Transactions%n" +
                "----------------------------------------------------------");
    }

    @Override
    public String processInput() {
        String result;
        String[] data = sc.nextLine().split("\\s+");
        String command = data[0];

        //TODO need to add reserve methods!

        switch (command) {
            case "AddBook" -> result = addBook(data);
            case "RemoveBook" -> result = removeBook(data);
            case "AddMember" -> result = addMember(data);
            case "RemoveMember" -> result = removeMember(data);
            case "BorrowBook" -> result = borrowBook(data);
            case "ReturnBook" -> result = returnBook(data);
            case "ReserveBook" -> result = reserveBook(data);
            case "Available Books" -> result = displayAvailableBooks();
            case "Borrowed Books" -> result = displayBorrowedBooks();
            case "Transactions" -> result = displayTransactionHistory();
            case "Help" -> result = "Help";
            case "Exit" -> result = "Exit";
            default -> result = "Invalid command. Please enter valid command\n" +
                    "or enter \"Help\" for commands list!";
        }

        return result;
    }

    private String addBook(String[] data) {
        String title = data[1];
        String genre = data[2];
        String author = data[3];
        int yearPublished = Integer.parseInt(data[4]);
        book = new BookImpl(title, genre, author, yearPublished);

        library.addBook(book);
        return library.setTransaction(String.format(BOOK_ADDED, book.getTitle()));
    }

    private String removeBook(String[] data) {
        String title = data[1];

        library.removeBook(title);

        return library.setTransaction(String.format(BOOK_REMOVED, book.getTitle()));
    }

    private String addMember(String[] data) {
        String memberName = data[1];
        String email = data[2];

        libraryMember = new LibraryMemberImpl(memberName, email);
        library.addMember(libraryMember);
        return library.setTransaction(String.format(MEMBER_ADDED, libraryMember.getName()));
    }

    private String removeMember(String[] data) {
        String name = data[1];
        libraryMember = library.searchMember(name);

        library.removeMember(libraryMember);
        return library.setTransaction(String.format(MEMBER_REMOVED, libraryMember.getName()));
    }

    private String borrowBook(String[] data) {
        String memberName = data[1];
        String bookTitle = data[2];
        Book book = library.getAvailableBook(bookTitle);

        libraryMember = library.searchMember(memberName);
        libraryMember.borrowBook(book);

        library.addBorrowedBook(bookTitle);
        library.removeAvailableBook(bookTitle);

        return library.setTransaction(String.format(BORROW_BOOK, libraryMember.getName(), book.getTitle()));
    }

    private String returnBook(String[] data) {
        String memberName = data[1];
        String bookTitle = data[2];

        libraryMember = library.searchMember(memberName);

        Book book = libraryMember.returnBook(bookTitle);



        //TODO check if the book is reserved when returning!




        // 1. check if book is already reserved
        if (library.reservedBookChecker(bookTitle)) {
            // 2. if it reserved, remove it from reservationList and add it to the person who reserved it.

            Reservation reservation = library.removeReservation(bookTitle);
            String reservationName = reservation.getPersonName();

            library.searchMember(reservationName).removeReservedBook(bookTitle);
            library.searchMember(reservationName).borrowBook(book);
        }
        // 3. if it's not reserved just removed it from the borrowedBooks and add it to availableBooks.

        library.removeBorrowedBook(bookTitle);
        library.addBook(book);



        return library.setTransaction(String.format(RETURN_BOOK, libraryMember.getName(), book.getTitle()));
    }

    private String reserveBook(String[] data) {
        String memberName = data[1];
        String bookTitle = data[2];

        libraryMember = library.searchMember(memberName);
        Book book = library.addReservedBook(bookTitle);
        libraryMember.reserveBook(book);

        return library.setTransaction(String.format(BOOK_RESERVED, memberName, bookTitle));
    }

    private String displayAvailableBooks() {  //TODO
        return "Available books:"
                + System.lineSeparator()
                + library.getAvailableBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String displayBorrowedBooks() {  //TODO
        return "Borrowed books:"
                + System.lineSeparator()
                + library.getBorrowedBooks()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String displayTransactionHistory() {  //TODO
        return "Transactions history:"
                + System.lineSeparator()
                + library.getTransactions().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
