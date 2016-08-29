package seedu.addressbook.data.exception;

/**
 * Signals that user deletes the storage file while the AddressBook program is running.
 */
public class StorageFileDeletedException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s)
     */
    public StorageFileDeletedException(String message) {
        super(message);
    }
}
