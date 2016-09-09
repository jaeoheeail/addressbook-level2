package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email extends Contact {

    public static final String EXAMPLE = "valid@e.mail";
    private static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    private static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email, boolean isPrivate) throws IllegalValueException {
        super(email, isPrivate, EMAIL_VALIDATION_REGEX, MESSAGE_EMAIL_CONSTRAINTS);
    }
}