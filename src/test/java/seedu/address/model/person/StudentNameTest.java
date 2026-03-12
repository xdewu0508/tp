package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.person.StudentName.MESSAGE_CONSTRAINTS;
import static seedu.address.model.person.StudentNameTest.InvalidName.ASTERISK;
import static seedu.address.model.person.StudentNameTest.InvalidName.BLANK;
import static seedu.address.model.person.StudentNameTest.InvalidName.CONTAINS_NUMBER;
import static seedu.address.model.person.StudentNameTest.InvalidName.CONTAINS_SYMBOL;
import static seedu.address.model.person.StudentNameTest.InvalidName.EMPTY;
import static seedu.address.model.person.StudentNameTest.InvalidName.LEADING_WHITESPACE;
import static seedu.address.model.person.StudentNameTest.ValidName.LOWERCASE;
import static seedu.address.model.person.StudentNameTest.ValidName.MULTIPLE_WORDS;
import static seedu.address.model.person.StudentNameTest.ValidName.SINGLE_WORD;
import static seedu.address.model.person.StudentNameTest.ValidName.UPPERCASE;
import static seedu.address.model.person.StudentNameTest.ValidName.WITH_SPACES;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@code StudentName}.
 */
public class StudentNameTest {

    /**
     * Valid names for testing.
     */
    public static class ValidName {
        public static final String SINGLE_WORD = "Alice";
        public static final String MULTIPLE_WORDS = "Alice Tan";
        public static final String LOWERCASE = "alice";
        public static final String UPPERCASE = "ALICE";
        public static final String WITH_SPACES = "Alice Mary Tan";
    }

    /**
     * Invalid names for testing.
     */
    public static class InvalidName {
        public static final String EMPTY = "";
        public static final String BLANK = "   ";
        public static final String CONTAINS_NUMBER = "Alice123";
        public static final String CONTAINS_SYMBOL = "Alice@Tan";
        public static final String ASTERISK = "*Alice";
        public static final String LEADING_WHITESPACE = " Alice";
    }

    @Test
    public void constructor_validName_success() {
        // Valid single word name
        assertTrue(new StudentName(SINGLE_WORD) != null);
        
        // Valid multiple words name
        assertTrue(new StudentName(MULTIPLE_WORDS) != null);
        
        // Valid lowercase name
        assertTrue(new StudentName(LOWERCASE) != null);
        
        // Valid uppercase name
        assertTrue(new StudentName(UPPERCASE) != null);
        
        // Valid name with spaces
        assertTrue(new StudentName(WITH_SPACES) != null);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        // Null name should throw NullPointerException
        org.junit.jupiter.api.Assertions.assertThrows(
            NullPointerException.class, 
            () -> new StudentName(null)
        );
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        // Empty name
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(EMPTY),
            MESSAGE_CONSTRAINTS
        );
        
        // Blank name (spaces only)
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(BLANK),
            MESSAGE_CONSTRAINTS
        );
        
        // Name with numbers
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(CONTAINS_NUMBER),
            MESSAGE_CONSTRAINTS
        );
        
        // Name with symbols
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(CONTAINS_SYMBOL),
            MESSAGE_CONSTRAINTS
        );
        
        // Name with asterisk
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(ASTERISK),
            MESSAGE_CONSTRAINTS
        );
        
        // Name with leading whitespace
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentName(LEADING_WHITESPACE),
            MESSAGE_CONSTRAINTS
        );
    }

    @Test
    public void isValidName_validName_returnsTrue() {
        // Valid single word name
        assertTrue(StudentName.isValidName(SINGLE_WORD));
        
        // Valid multiple words name
        assertTrue(StudentName.isValidName(MULTIPLE_WORDS));
        
        // Valid lowercase name
        assertTrue(StudentName.isValidName(LOWERCASE));
        
        // Valid uppercase name
        assertTrue(StudentName.isValidName(UPPERCASE));
        
        // Valid name with spaces
        assertTrue(StudentName.isValidName(WITH_SPACES));
    }

    @Test
    public void isValidName_invalidName_returnsFalse() {
        // Empty name
        assertFalse(StudentName.isValidName(EMPTY));
        
        // Blank name (spaces only)
        assertFalse(StudentName.isValidName(BLANK));
        
        // Name with numbers
        assertFalse(StudentName.isValidName(CONTAINS_NUMBER));
        
        // Name with symbols
        assertFalse(StudentName.isValidName(CONTAINS_SYMBOL));
        
        // Name with asterisk
        assertFalse(StudentName.isValidName(ASTERISK));
        
        // Name with leading whitespace
        assertFalse(StudentName.isValidName(LEADING_WHITESPACE));
    }

    @Test
    public void equals() {
        StudentName name = new StudentName("Alice Tan");

        // same values -> returns true
        assertTrue(name.equals(new StudentName("Alice Tan")));

        // same object -> returns true
        assertTrue(name.equals(name));

        // null -> returns false
        assertFalse(name.equals(null));

        // different types -> returns false
        assertFalse(name.equals(5.0f));

        // different name -> returns false
        assertFalse(name.equals(new StudentName("Bob Tan")));
    }

    @Test
    public void toString_method() {
        StudentName name = new StudentName("Alice Tan");
        String expected = "Alice Tan";
        assertTrue(name.toString().contains(expected));
    }
}
