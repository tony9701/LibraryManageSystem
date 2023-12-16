package Models.Book;

import static Common.ExceptionMessages.ExceptionMessages.*;

public class Book {

    private String title;
    private String genre;
    private String author;
    private String publishedYear;
    private boolean isAvailable;

    public Book(String title, String genre, String author, String publishedYear) {
        setTitle(title);
        this.genre = genre;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(BOOK_NAME_EMPTY_OR_NULL);
        }

        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private void setAvailable(boolean available) {
        this.isAvailable = available;
    }


    public void checkIn() {
        setAvailable(true);
    }

    public void checkOut() {
        setAvailable(false);
    }
}
