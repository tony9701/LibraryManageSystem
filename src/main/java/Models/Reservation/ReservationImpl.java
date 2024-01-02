package Models.Reservation;

import Models.Book.Book;

public class ReservationImpl implements Reservation {
    private String personName;
    private Book reservedBook;

    public ReservationImpl(String name, Book book) {
        this.personName = name;
        this.reservedBook = book;
    }

    @Override
    public String getPersonName() {
        return personName;
    }

    @Override
    public Book getBook() {
        return reservedBook;
    }
}
