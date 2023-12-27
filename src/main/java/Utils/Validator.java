package Utils;

import Models.Book.Book;

import java.time.Year;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final int CURRENT_YEAR = Year.now().getValue();
    private static final int FIRST_BOOK_YEAR = 1440;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean nameIsValid(String name) {
        return name != null && !name.isBlank();
    }

    public static boolean publishedYearIsValid(int publishedYear) {
        return publishedYear >= FIRST_BOOK_YEAR && publishedYear <= CURRENT_YEAR;
    }

    public static boolean emailIsValid(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean bookIsPresent(String title, HashMap<String, Book> bookRepo) {
        return bookRepo.containsKey(title);
    }
    public static boolean removeBookIfPresent(String title,
                                              HashMap<String, Book> bookRepo1,
                                              HashMap<String, Book> bookRepo2,
                                              HashMap<String, Book> bookRepo3) {

        Book book = null;
        if (bookRepo1.containsKey(title)) {
            book = bookRepo1.remove(title);
        } else if (bookRepo2.containsKey(title)) {
            book = bookRepo2.remove(title);
        } else if (bookRepo3.containsKey(title)) {
            book = bookRepo3.remove(title);
        }

        return book != null;
    }
}
