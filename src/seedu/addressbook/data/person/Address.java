package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the following format "
    		+ "a/BLOCK, STREET, UNIT, POSTAL_CODE Example: " + EXAMPLE;
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Person block should only contain numbers";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Person unit should start with "
    		+ "'#' and contain '-' to separate the floor and the unit number";
    public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Person postal code should contain 6 numbers";
    
    private static final int ADDRESS_BLOCK_INDEX = 0;
    private static final int ADDRESS_STREET_INDEX = 1;
    private static final int ADDRESS_UNIT_INDEX = 2;
    private static final int ADDRESS_POSTAL_CODE_INDEX = 3;
    
    private static final int NUM_ADDRESS_FIELDS = 4;
    
    public static final String ADDRESS_VALIDATION_REGEX = ".+,.+,.+,.+";
    private static final String ADDRESS_BLOCK_VALIDATION_REGEX = "\\d+";
    private static final String ADDRESS_STREET_VALIDATION_REGEX = ".+";	
    private static final String ADDRESS_UNIT_VALIDATION_REGEX = "#\\d+(-\\d+)*";
    private static final String ADDRESS_POSTAL_CODE_VALIDATION_REGEX = "\\d{6}";
    
    /** The members of Address class */
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;        
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] addressFields = address.trim().split(", ");
        if (isValidAddressFields(addressFields)) {
        	this.block = new Block(addressFields[ADDRESS_BLOCK_INDEX]);
        	this.street = new Street(addressFields[ADDRESS_STREET_INDEX]);
        	this.unit = new Unit(addressFields[ADDRESS_UNIT_INDEX]);
        	this.postalCode = new PostalCode(addressFields[ADDRESS_POSTAL_CODE_INDEX]);
        } else {
        	throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }

	/**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    /**
     * Returns true if a given string is a valid person address.
     */
    private boolean isValidAddressFields(String[] addressFields) {
    	if (addressFields.length == NUM_ADDRESS_FIELDS) {
    		String testBlock = addressFields[ADDRESS_BLOCK_INDEX];
    		String testStreet = addressFields[ADDRESS_STREET_INDEX];
    		String testUnit = addressFields[ADDRESS_UNIT_INDEX];
    		String testPostalCode = addressFields[ADDRESS_POSTAL_CODE_INDEX];
    		return isValidBlock(testBlock) 
						&& isValidStreet(testStreet)
						&& isValidUnit(testUnit)
						&& isValidPostalCode(testPostalCode);
    	}
		return false;
	}
    
    /**
     * Checks if given string is a valid block.
     * 
     */
    public static boolean isValidBlock(String test) {
    	String removePrefix = test.substring(2, test.length());
    	return removePrefix.matches(ADDRESS_BLOCK_VALIDATION_REGEX);
    }
    
    /**
     * Checks if given string is a valid street.
     */
    public static boolean isValidStreet(String test) {
    	return test.matches(ADDRESS_STREET_VALIDATION_REGEX); 
    }
    
    /**
     * Checks if given string is a valid unit.
     */
    public static boolean isValidUnit(String test) {
    	return test.matches(ADDRESS_UNIT_VALIDATION_REGEX);
    }
    
    /**
     * Checks if given string is a valid postal code.
     * 
     */
    public static boolean isValidPostalCode(String test) {
    	return test.matches(ADDRESS_POSTAL_CODE_VALIDATION_REGEX);
    }
        
    @Override
    public String toString() {
        return this.block.getBlock() + ", " + this.street.getStreet() + ", " 
    			+ this.unit.getUnit() + ", " + this.postalCode.getPostalCode();
    }

	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}