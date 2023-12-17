package Models.Book;
import java.time.Year;


import static Common.ExceptionMessages.ExceptionMessages.*;

public class Book {
    private static final int CURRENT_YEAR = Year.now().getValue();

    private String title;
    private String genre;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    protected Book(String title, String genre, String author, int publishedYear) {
        setTitle(title);
        setGenre(genre);
        setAuthor(author);
        setPublishedYear(publishedYear);
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

    private void setGenre(String genre) {
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException(GENRE_EMPTY_OR_NULL);
        }

        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(AUTHOR_NAME_EMPTY_OR_NULL);
        }

        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    private void setPublishedYear(int publishedYear) {
        if (publishedYear < 0 || publishedYear > CURRENT_YEAR) {
            throw new IllegalArgumentException(INVALID_PUBLISHED_YEAR);
        }

        this.publishedYear = publishedYear;
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
