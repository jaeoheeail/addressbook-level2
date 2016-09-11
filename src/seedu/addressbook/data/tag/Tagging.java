package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

/**
 * Association class that establishes a one to many relationship between Person
 * and Tag through a Tagging object.
 * 
 * Assumption: Commands to add and remove tags to a person in address book.
 *
 */
public class Tagging {

    /** Class variable to keep track of all the tags added/deleted **/
    private static ArrayList<Tagging> sessionTagging = new ArrayList<Tagging>();

    private Person taggedPerson;
    private Tag tag;
    private boolean toAdd;

    public Tagging(Person taggedPerson, Tag tag, boolean toAdd) {
        this.taggedPerson = taggedPerson;
        this.tag = tag;
        this.toAdd = toAdd;
    }

    /**
     * Updates sessionTagging after command to add and remove tags.
     */
    public void updateTaggingList(Tagging update) {
        sessionTagging.add(update);
    }

    /**
     * Prints out list of all the tags added/deleted during session when program
     * exits.
     */
    public void printTaggingList() {
        for (Tagging t : sessionTagging) {
            String nameToPrint = t.taggedPerson.getName().toString();
            String tagToPrint = t.tag.toString();
            if (t.toAdd) {
                System.out.println("+ " + nameToPrint + " " + tagToPrint);
            } else {
                System.out.println("-" + nameToPrint + " " + tagToPrint);
            }
        }
    }
}
