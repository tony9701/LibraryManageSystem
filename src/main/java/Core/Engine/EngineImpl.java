package Core.Engine;

import Models.Book.Book;
import Models.Book.BookImpl;
import Models.Library.Library;
import Models.Library.LibraryImpl;
import Models.LibraryMember.LibraryMember;
import Models.LibraryMember.LibraryMemberImpl;

import java.util.Scanner;

import static Common.ConstantMessages.ConstantMessages.*;

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
                    printHelpInfo(); //TODO
                    result = processInput();
                }

            } catch (NullPointerException | IllegalArgumentException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    @Override
    public String processInput() {
        String result = null;
        String[] data = sc.nextLine().split("\\s+");
        String command = data[0];

        switch (command) {
            case "AddBook" -> result = addBook(data);
            case "RemoveBook" -> result = removeBook(data);
            case "AddMember" -> result = addMember(data);
            case "RemoveMember" -> result = removeMember(data);
            case "CheckOutBook" -> result = checkOutBook(data);
            case "CheckInBook" -> result = checkInBook(data);
            case "DisplayAvailableBooks" -> result = displayAvailableBooks();
            case "DisplayBorrowedBooks" -> result = displayBorrowedBooks();
            case "TransactionHistory" -> result = transactionHistory();
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
        return String.format(BOOK_ADDED, book.getTitle());
    }

    private String removeBook(String[] data) {
        String title = data[1];
        book = library.searchBook(title);

        library.removeBook(book);
        return String.format(BOOK_REMOVED, book.getTitle());
    }

    private String addMember(String[] data) {
        String memberName = data[1];
        String email = data[2];

        libraryMember = new LibraryMemberImpl(memberName, email);
        library.addMember(libraryMember);
        return String.format(MEMBER_ADDED, libraryMember.getName());
    }

    private String removeMember(String[] data) {
        String name = data[1];
        libraryMember = library.searchMember(name);

        library.removeMember(libraryMember);
        return String.format(MEMBER_REMOVED, libraryMember.getName());
    }
}
