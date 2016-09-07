package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	private Name tester;
	private Name person;
	
	@Before
	public void setUp() throws IllegalValueException {
		tester = new Name("Tester");
		person = new Name("John K Smith");
	}

	@Test
	public void testIsSimilar() throws IllegalValueException {
		// null name
		assertFalse(tester.isSimilar(null));
		
		// random name
		assertFalse(tester.isSimilar(new Name("aaa")));
		
		// same name
		assertTrue(tester.isSimilar(new Name("Tester")));
		
		// case-insensitive
		assertTrue(person.isSimilar(new Name("John K SMITh")));
	}

}
