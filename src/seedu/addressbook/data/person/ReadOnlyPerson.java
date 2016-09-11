package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;


/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    Name getName();
    Phone getPhone();
    Email getEmail();
    Address getAddress();

    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if the values inside this object is same as those of the other (Note: interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName()) // state checks here onwards
                && other.getPhone().equals(this.getPhone())
                && other.getEmail().equals(this.getEmail())
                && other.getAddress().equals(this.getAddress()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
    	   	    	
        final StringBuilder builder = new StringBuilder();
        final String detailIsPrivate = "(private) ";
        builder.append(getName())
                .append(" Phone: ");
        if (getPhone().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getPhone())
                .append(" Email: ");
        if (getEmail().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getEmail())
                .append(" Address: ");
        if (getAddress().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getAddress())
                .append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate(String personDetails) {
    	    	
    	String[] splitDetails = splitDetails(personDetails);
    	
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        if (!getPhone().isPrivate()) {
            builder.append(" " + splitDetails[0]);
        }
        if (!getEmail().isPrivate()) {
            builder.append(" "+ splitDetails[1]);
        }
        if (!getAddress().isPrivate()) {
            builder.append(" " + splitDetails[2]);
        }
        builder.append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }
    
    /**
     * Splits phone, email and address from person details string to string array.
     */
    default String[] splitDetails(String personDetails) {
    	int phoneIndex = personDetails.indexOf("Phone: ");
    	int emailIndex = personDetails.indexOf("Email: ");
    	int addressIndex = personDetails.indexOf("Address: ");
    	
    	String[] splitDetails = {personDetails.substring(phoneIndex, emailIndex).trim(),
    			personDetails.substring(emailIndex, addressIndex).trim(),
    			personDetails.substring(addressIndex, personDetails.length())
    			};
    	return splitDetails;
    }
    
    /**
     * Returns a concatenated version of the printable strings of each object.
     */
    static String getPrintableString(Printable... printables) {
        String concatString = "";
        for (Printable p : printables) {
            concatString += p.getPrintableString() + " ";
        }
        return concatString.trim();
    }
}
