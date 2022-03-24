package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalContents.getTypicalContent;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalContactList;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskList;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

class ContentTest {
    private final Content typicalContent = getTypicalContent();

    @Test
    void constructor() {
        assertEquals(typicalContent.getContactList(), getTypicalContactList());
    }

    @Test
    void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Content(null, getTypicalTaskList()));
        assertThrows(NullPointerException.class, () -> new Content(getTypicalContactList(), null));
    }

    @Test
    void getContactList() {
        assertEquals(typicalContent.getContactList(), getTypicalContactList());
    }

    @Test
    void getTaskList() { assertEquals(typicalContent.getTaskList(), getTypicalTaskList());}

    @Test
    void testEquals() {
        assertEquals(typicalContent, new Content(getTypicalContactList(), getTypicalTaskList()));
    }

    @Test
    void testNotEquals() {
        ContactList editedContactList = new ContactList(getTypicalContactList());
        editedContactList.addPerson(new PersonBuilder(ALICE).withName("TEST").build());
        Content editedContent = new Content(editedContactList, getTypicalTaskList());
        assertNotEquals(typicalContent, editedContent);
    }
}
