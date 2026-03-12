package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.person.StudentEmail.MESSAGE_CONSTRAINTS;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.DOUBLE_AT;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.MISSING_AT;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.MISSING_DOMAIN;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.MISSING_LOCAL_PART;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.MISSING_TLD;
import static seedu.address.model.person.StudentEmailTest.InvalidEmail.WITH_SPACES;
import static seedu.address.model.person.StudentEmailTest.ValidEmail.STANDARD_EMAIL;
import static seedu.address.model.person.StudentEmailTest.ValidEmail.WITH_DOTS;
import static seedu.address.model.person.StudentEmailTest.ValidEmail.WITH_HYPHENS;
import static seedu.address.model.person.StudentEmailTest.ValidEmail.WITH_NUMBERS;
import static seedu.address.model.person.StudentEmailTest.ValidEmail.WITH_SUBDOMAIN;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@code StudentEmail}.
 */
public class StudentEmailTest {

    /**
     * Valid emails for testing.
     */
    public static class ValidEmail {
        public static final String STANDARD_EMAIL = "alex@email.com";
        public static final String WITH_DOTS = "alex.tan@email.com";
        public static final String WITH_NUMBERS = "alex123@email.com";
        public static final String WITH_HYPHENS = "alex-tan@email.com";
        public static final String WITH_SUBDOMAIN = "alex@mail.email.com";
    }

    /**
     * Invalid emails for testing.
     */
    public static class InvalidEmail {
        public static final String MISSING_AT = "alexemail.com";
        public static final String DOUBLE_AT = "alex@@email.com";
        public static final String MISSING_LOCAL_PART = "@email.com";
        public static final String MISSING_DOMAIN = "alex@";
        public static final String MISSING_TLD = "alex@email";
        public static final String WITH_SPACES = "alex @email.com";
    }

    @Test
    public void constructor_validEmail_success() {
        // Standard email
        assertTrue(new StudentEmail(STANDARD_EMAIL) != null);

        // Email with dots
        assertTrue(new StudentEmail(WITH_DOTS) != null);

        // Email with numbers
        assertTrue(new StudentEmail(WITH_NUMBERS) != null);

        // Email with hyphens
        assertTrue(new StudentEmail(WITH_HYPHENS) != null);

        // Email with subdomain
        assertTrue(new StudentEmail(WITH_SUBDOMAIN) != null);
    }

    @Test
    public void constructor_null_throwsNullPointerException() {
        // Null email should throw NullPointerException
        org.junit.jupiter.api.Assertions.assertThrows(
            NullPointerException.class,
            () -> new StudentEmail(null)
        );
    }

    @Test
    public void constructor_invalidEmail_throwsIllegalArgumentException() {
        // Missing @ symbol
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(MISSING_AT),
            MESSAGE_CONSTRAINTS
        );

        // Double @ symbol
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(DOUBLE_AT),
            MESSAGE_CONSTRAINTS
        );

        // Missing local part
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(MISSING_LOCAL_PART),
            MESSAGE_CONSTRAINTS
        );

        // Missing domain
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(MISSING_DOMAIN),
            MESSAGE_CONSTRAINTS
        );

        // Missing TLD
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(MISSING_TLD),
            MESSAGE_CONSTRAINTS
        );

        // Email with spaces
        org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new StudentEmail(WITH_SPACES),
            MESSAGE_CONSTRAINTS
        );
    }

    @Test
    public void isValidEmail_validEmail_returnsTrue() {
        // Standard email
        assertTrue(StudentEmail.isValidEmail(STANDARD_EMAIL));

        // Email with dots
        assertTrue(StudentEmail.isValidEmail(WITH_DOTS));

        // Email with numbers
        assertTrue(StudentEmail.isValidEmail(WITH_NUMBERS));

        // Email with hyphens
        assertTrue(StudentEmail.isValidEmail(WITH_HYPHENS));

        // Email with subdomain
        assertTrue(StudentEmail.isValidEmail(WITH_SUBDOMAIN));
    }

    @Test
    public void isValidEmail_invalidEmail_returnsFalse() {
        // Missing @ symbol
        assertFalse(StudentEmail.isValidEmail(MISSING_AT));

        // Double @ symbol
        assertFalse(StudentEmail.isValidEmail(DOUBLE_AT));

        // Missing local part
        assertFalse(StudentEmail.isValidEmail(MISSING_LOCAL_PART));

        // Missing domain
        assertFalse(StudentEmail.isValidEmail(MISSING_DOMAIN));

        // Missing TLD
        assertFalse(StudentEmail.isValidEmail(MISSING_TLD));

        // Email with spaces
        assertFalse(StudentEmail.isValidEmail(WITH_SPACES));
    }

    @Test
    public void equals() {
        StudentEmail email = new StudentEmail("alex@email.com");

        // same values -> returns true
        assertTrue(email.equals(new StudentEmail("alex@email.com")));

        // same object -> returns true
        assertTrue(email.equals(email));

        // null -> returns false
        assertFalse(email.equals(null));

        // different types -> returns false
        assertFalse(email.equals(5.0f));

        // different email -> returns false
        assertFalse(email.equals(new StudentEmail("bob@email.com")));
    }

    @Test
    public void toString_method() {
        StudentEmail email = new StudentEmail("alex@email.com");
        String expected = "alex@email.com";
        assertTrue(email.toString().contains(expected));
    }
}
