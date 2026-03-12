package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.person.StudentPhone.MESSAGE_CONSTRAINTS;
import static seedu.address.model.person.StudentPhoneTest.InvalidPhone.FOURTEEN_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.InvalidPhone.SIXTEEN_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.InvalidPhone.THREE_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.InvalidPhone.WITH_LETTERS;
import static seedu.address.model.person.StudentPhoneTest.InvalidPhone.WITH_SYMBOLS;
import static seedu.address.model.person.StudentPhoneTest.ValidPhone.EIGHT_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.ValidPhone.FIFTEEN_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.ValidPhone.FOUR_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.ValidPhone.SEVEN_DIGITS;
import static seedu.address.model.person.StudentPhoneTest.ValidPhone.TEN_DIGITS;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@code StudentPhone}.
 */
public class StudentPhoneTest {

    /**
     * Valid phone numbers for testing.
     */
    public static class ValidPhone {
        public static final String FOUR_DIGITS = "1234";
        public static final String SEVEN_DIGITS = "1234567";
        public static final String EIGHT_DIGITS = "91234567";
        public static final String TEN_DIGITS = "1234567890";
        public static final String FIFTEEN_DIGITS = "123456789012345";
    }

    /**
     * Invalid phone numbers for testing.
     */
    public static class InvalidPhone {
        public static final String THREE_DIGITS = "123";
        public static final String SIXTEEN_DIGITS = "1234567890123456";
        public static final String FOURTEEN_DIGITS = "12345678901234";
        public static final String WITH_LETTERS = "91234567a";
        public static final String WITH_SYMBOLS = "9123-4567";
    }

    @Test
    public void constructor_validPhone_success() {
        // Valid 4-digit phone
        assertTrue(new StudentPhone(FOUR_DIGITS) != null);

        // Valid 7-digit phone
        assertTrue(new StudentPhone(SEVEN_DIGITS) != null);

        // Valid 8-digit phone (Singapore standard)
        assertTrue(new StudentPhone(EIGHT_DIGITS) != null);

        // Valid 10-digit phone
        assertTrue(new StudentPhone(TEN_DIGITS) != null);

        // Valid 15-digit phone (max length)
        assertTrue(new StudentPhone(FIFTEEN_DIGITS) != null);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        // Null phone should throw NullPointerException
        org.junit.jupiter.api.Assertions.assertThrows(
            NullPointerException.class,
            () -> new StudentPhone(null)
        );
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        // 3-digit phone (too short)
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentPhone(THREE_DIGITS),
            MESSAGE_CONSTRAINTS
        );

        // 16-digit phone (too long)
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentPhone(SIXTEEN_DIGITS),
            MESSAGE_CONSTRAINTS
        );

        // Phone with letters
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentPhone(WITH_LETTERS),
            MESSAGE_CONSTRAINTS
        );

        // Phone with symbols
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentPhone(WITH_SYMBOLS),
            MESSAGE_CONSTRAINTS
        );
    }

    @Test
    public void isValidPhone_validPhone_returnsTrue() {
        // Valid 4-digit phone
        assertTrue(StudentPhone.isValidPhone(FOUR_DIGITS));

        // Valid 7-digit phone
        assertTrue(StudentPhone.isValidPhone(SEVEN_DIGITS));

        // Valid 8-digit phone
        assertTrue(StudentPhone.isValidPhone(EIGHT_DIGITS));

        // Valid 10-digit phone
        assertTrue(StudentPhone.isValidPhone(TEN_DIGITS));

        // Valid 15-digit phone
        assertTrue(StudentPhone.isValidPhone(FIFTEEN_DIGITS));
    }

    @Test
    public void isValidPhone_invalidPhone_returnsFalse() {
        // 3-digit phone (too short)
        assertFalse(StudentPhone.isValidPhone(THREE_DIGITS));

        // 16-digit phone (too long)
        assertFalse(StudentPhone.isValidPhone(SIXTEEN_DIGITS));

        // Phone with letters
        assertFalse(StudentPhone.isValidPhone(WITH_LETTERS));

        // Phone with symbols
        assertFalse(StudentPhone.isValidPhone(WITH_SYMBOLS));
    }

    @Test
    public void equals() {
        StudentPhone phone = new StudentPhone("91234567");

        // same values -> returns true
        assertTrue(phone.equals(new StudentPhone("91234567")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different phone -> returns false
        assertFalse(phone.equals(new StudentPhone("81234567")));
    }

    @Test
    public void toString_method() {
        StudentPhone phone = new StudentPhone("91234567");
        String expected = "91234567";
        assertTrue(phone.toString().contains(expected));
    }
}
