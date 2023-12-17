package Models.Book;
import Utils.Validator;

import java.time.Year;


import static Common.ExceptionMessages.ExceptionMessages.*;

public class Book {

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
        if (Validator.nameIsValid(title)) {
            this.title = title;
        }

        throw new IllegalArgumentException(BOOK_NAME_EMPTY_OR_NULL);
    }

    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        if (Validator.nameIsValid(genre)) {
            this.genre = genre;
        }

        throw new IllegalArgumentException(GENRE_EMPTY_OR_NULL);
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (Validator.nameIsValid(author)) {
            this.author = author;
        }

        throw new IllegalArgumentException(AUTHOR_NAME_EMPTY_OR_NULL);
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    private void setPublishedYear(int publishedYear) {
        if (Validator.publishedYearIsValid(publishedYear)) {
            this.publishedYear = publishedYear;
        }

        throw new IllegalArgumentException(INVALID_PUBLISHED_YEAR);
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
