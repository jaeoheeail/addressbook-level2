package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {

	@Test
	public void testIsSimilar() {
		// null name
		assertFalse(Name.isSimilar(null));
	}

}
