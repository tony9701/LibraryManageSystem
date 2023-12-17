package Models.Book;

public interface Book {
    String getTitle();
    String getGenre();
    String getAuthor();
    int getPublishedYear();
    boolean isAvailable();


    void checkIn();
    void checkOut();
}
