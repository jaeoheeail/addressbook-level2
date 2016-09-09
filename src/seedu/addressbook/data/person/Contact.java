package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
		
	public final String value;
	private boolean isPrivate;
	
	/**
	 * Validates given contact.
	 * 
	 * @param contact can be address, email or phone of person
	 * @param isPrivate indicates if contact is private or not
	 * @param validationRegex to check if given contact is valid
	 * @param messageConstraints for user to handle case when given contact is invalid
	 * @throws IllegalValueException
	 */
	public Contact(String contact, boolean isPrivate, String validationRegex, String messageConstraints) throws IllegalValueException {
		this.isPrivate = isPrivate;
		if (!isValidContact(contact, validationRegex)) {
			throw new IllegalValueException(messageConstraints);
		}
		this.value = contact;
	}
	
	/**
	 * Returns true if a given string is a valid contact.
	 */
	public static boolean isValidContact(String test, String validationRegex) {
		return test.matches(validationRegex);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Contact // instanceof handles nulls
				&& this.value.equals(((Contact) other).value)); // state check
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	public boolean isPrivate() {
		return isPrivate;
	}
}
