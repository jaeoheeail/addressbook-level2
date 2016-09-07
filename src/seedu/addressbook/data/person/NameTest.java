package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	private Name tester;
	
	@Before
	public void setUp() throws IllegalValueException {
		tester = new Name("Tester");
	}

	@Test
	public void testIsSimilar() throws IllegalValueException {
		// null name
		assertFalse(tester.isSimilar(null));
		
		// random name
		assertFalse(tester.isSimilar(new Name("aaa")));
	}

}
