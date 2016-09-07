package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
	public void testIsSimilar() throws IllegalValueException {
		// null name
		assertFalse(Name.isSimilar(null));
		
		// random name
		assertFalse(Name.isSimilar(new Name("aaa")));
	}

}
