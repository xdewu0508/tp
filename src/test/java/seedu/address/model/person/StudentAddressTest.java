package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.person.StudentAddress.MESSAGE_CONSTRAINTS;
import static seedu.address.model.person.StudentAddressTest.InvalidAddress.BLANK;
import static seedu.address.model.person.StudentAddressTest.InvalidAddress.EMPTY;
import static seedu.address.model.person.StudentAddressTest.InvalidAddress.WHITESPACE_ONLY;
import static seedu.address.model.person.StudentAddressTest.ValidAddress.LONG_ADDRESS;
import static seedu.address.model.person.StudentAddressTest.ValidAddress.SIMPLE_ADDRESS;
import static seedu.address.model.person.StudentAddressTest.ValidAddress.WITH_NUMBERS;
import static seedu.address.model.person.StudentAddressTest.ValidAddress.WITH_SPECIAL_CHARS;
import static seedu.address.model.person.StudentAddressTest.ValidAddress.WITH_UNITS;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@code StudentAddress}.
 */
public class StudentAddressTest {

    /**
     * Valid addresses for testing.
     */
    public static class ValidAddress {
        public static final String SIMPLE_ADDRESS = "123 Orchard Road";
        public static final String LONG_ADDRESS = "123, Jurong West Ave 6, #08-111";
        public static final String WITH_NUMBERS = "Block 123 Street 45";
        public static final String WITH_SPECIAL_CHARS = "123 Main St. #05-123";
        public static final String WITH_UNITS = "#05-123 Little Tokyo";
    }

    /**
     * Invalid addresses for testing.
     */
    public static class InvalidAddress {
        public static final String EMPTY = "";
        public static final String BLANK = "   ";
        public static final String WHITESPACE_ONLY = "    \t   ";
    }

    @Test
    public void constructor_validAddress_success() {
        // Simple address
        assertTrue(new StudentAddress(SIMPLE_ADDRESS) != null);
        
        // Long address
        assertTrue(new StudentAddress(LONG_ADDRESS) != null);
        
        // Address with numbers
        assertTrue(new StudentAddress(WITH_NUMBERS) != null);
        
        // Address with special characters
        assertTrue(new StudentAddress(WITH_SPECIAL_CHARS) != null);
        
        // Address with units
        assertTrue(new StudentAddress(WITH_UNITS) != null);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        // Null address should throw NullPointerException
        org.junit.jupiter.api.Assertions.assertThrows(
            NullPointerException.class, 
            () -> new StudentAddress(null)
        );
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        // Empty address
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentAddress(EMPTY),
            MESSAGE_CONSTRAINTS
        );
        
        // Blank address (spaces only)
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentAddress(BLANK),
            MESSAGE_CONSTRAINTS
        );
        
        // Whitespace only address
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> new StudentAddress(WHITESPACE_ONLY),
            MESSAGE_CONSTRAINTS
        );
    }

    @Test
    public void isValidAddress_validAddress_returnsTrue() {
        // Simple address
        assertTrue(StudentAddress.isValidAddress(SIMPLE_ADDRESS));
        
        // Long address
        assertTrue(StudentAddress.isValidAddress(LONG_ADDRESS));
        
        // Address with numbers
        assertTrue(StudentAddress.isValidAddress(WITH_NUMBERS));
        
        // Address with special characters
        assertTrue(StudentAddress.isValidAddress(WITH_SPECIAL_CHARS));
        
        // Address with units
        assertTrue(StudentAddress.isValidAddress(WITH_UNITS));
    }

    @Test
    public void isValidAddress_invalidAddress_returnsFalse() {
        // Empty address
        assertFalse(StudentAddress.isValidAddress(EMPTY));
        
        // Blank address (spaces only)
        assertFalse(StudentAddress.isValidAddress(BLANK));
        
        // Whitespace only address
        assertFalse(StudentAddress.isValidAddress(WHITESPACE_ONLY));
    }

    @Test
    public void equals() {
        StudentAddress address = new StudentAddress("123 Orchard Road");

        // same values -> returns true
        assertTrue(address.equals(new StudentAddress("123 Orchard Road")));

        // same object -> returns true
        assertTrue(address.equals(address));

        // null -> returns false
        assertFalse(address.equals(null));

        // different types -> returns false
        assertFalse(address.equals(5.0f));

        // different address -> returns false
        assertFalse(address.equals(new StudentAddress("321 Pasir Ris Road")));
    }

    @Test
    public void toString_method() {
        StudentAddress address = new StudentAddress("123 Orchard Road");
        String expected = "123 Orchard Road";
        assertTrue(address.toString().contains(expected));
    }
}
