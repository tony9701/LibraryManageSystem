package Common.ExceptionMessages;

public class ExceptionMessages {

    //Books exceptions
    public static final String BOOK_NAME_EMPTY_OR_NULL = "Invalid book name!";
    public static final String GENRE_EMPTY_OR_NULL = "Invalid genre!";
    public static final String AUTHOR_NAME_EMPTY_OR_NULL = "Invalid author!";
    public static final String INVALID_PUBLISHED_YEAR = "Invalid year!";


    //LibraryMember exceptions
    public static final String MEMBER_NAME_EMPTY_OR_NULL = "Invalid name!";
    public static final String MEMBER_EMAIL_NOT_VALID = "Invalid email address!";



    //Library exceptions
    public static final String BOOK_ALREADY_EXIST = "%s is already added in the library!";
    public static final String BOOK_NOT_EXIST = "%s isn't present in the library!";
    public static final String BOOK_NOT_AVAILABLE = "%s isn't available";
    public static final String MEMBER_ALREADY_EXIST = "%s has already a membership!";
    public static final String MEMBER_NOT_EXIST = "%s isn't valid member!";


    //Reservation exceptions
    public static final String RESERVATION_NOT_EXIST = "Reservation is not existing!";
    public static final String RESERVATION_ALREADY_EXIST = "%s is already reserved!";

}
