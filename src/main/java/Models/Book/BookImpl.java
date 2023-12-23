package Models.Book;

import Utils.Validator;


import static Common.ExceptionMessages.ExceptionMessages.*;

public class BookImpl implements Book {

    private String title;
    private String genre;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    public BookImpl(String title, String genre, String author, int publishedYear) {
        setTitle(title);
        setGenre(genre);
        setAuthor(author);
        setPublishedYear(publishedYear);
        this.isAvailable = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (Validator.nameIsValid(title)) {
            this.title = title;
            return;
        }

        throw new IllegalArgumentException(BOOK_NAME_EMPTY_OR_NULL);
    }

    @Override
    public String getGenre() {
        return genre;
    }

    private void setGenre(String genre) {
        if (Validator.nameIsValid(genre)) {
            this.genre = genre;
            return;
        }

        throw new IllegalArgumentException(GENRE_EMPTY_OR_NULL);
    }

    @Override
    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        if (Validator.nameIsValid(author)) {
            this.author = author;
            return;
        }

        throw new IllegalArgumentException(AUTHOR_NAME_EMPTY_OR_NULL);
    }

    @Override
    public int getPublishedYear() {
        return publishedYear;
    }

    private void setPublishedYear(int publishedYear) {
        if (Validator.publishedYearIsValid(publishedYear)) {
            this.publishedYear = publishedYear;
            return;
        }

        throw new IllegalArgumentException(INVALID_PUBLISHED_YEAR);
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    private void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public void checkIn() {
        setAvailable(true);
    }

    @Override
    public void checkOut() {
        setAvailable(false);
    }
}
