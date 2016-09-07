package seedu.addressbook.common;

import java.util.ArrayList;
import java.util.Collection;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {
	private Object[] hasNullObjects;
	private Object[] testObjects;
	private Collection<?> uniqueItems;
	private Collection<?> repeatedItems;
	
	@Before
    public void setup() throws IllegalValueException {
		Name tempName1 = new Name("John Doe");
		Name tempName2 = new Name("John Doe");
		Name tempName3 = new Name("Charles Dickens");
		
		Address tempAddress = new Address("222, beta street", false);
		Phone tempPhone = new Phone("123456", false);
		Email tempEmail = new Email("john@gmail.com", false);
		
		hasNullObjects = new Object[]{tempName1, null, tempPhone, null};
		testObjects = new Object[]{tempName1, tempAddress, tempPhone, tempEmail};
        uniqueItems  = new ArrayList<Name>() {
        	{
        		add(tempName1);
        		add(tempName3);
        	}
        };
        repeatedItems = new ArrayList<Name>() {
        	{
        		add(tempName1);
        		add(tempName2);
        	}
        };
    }	
}
