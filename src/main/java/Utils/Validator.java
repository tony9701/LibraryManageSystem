package Utils;

import java.time.Year;

public class Validator {

    private static final int CURRENT_YEAR = Year.now().getValue();
    private static final int FIRST_BOOK_YEAR = 1440;

    public static boolean nameIsValid(String name) {
        return name != null && !name.isBlank();
    }

    public static boolean publishedYearIsValid(int publishedYear) {
        return publishedYear >= FIRST_BOOK_YEAR && publishedYear <= CURRENT_YEAR;
    }
}
