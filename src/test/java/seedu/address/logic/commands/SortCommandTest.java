package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

public class SortCommandTest {

    private static final Comparator<Person> ADDRESS_COMPARATOR =
            Comparator.comparing((Person p) -> p.getAddress().value, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(p -> p.getName().fullName, String.CASE_INSENSITIVE_ORDER);

    private static final Comparator<Person> NAME_COMPARATOR =
            Comparator.comparing((Person p) -> p.getName().fullName, String.CASE_INSENSITIVE_ORDER)
                    .thenComparing(p -> p.getAddress().value, String.CASE_INSENSITIVE_ORDER);

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_sortByAddress_success() {
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.sortPersonList(ADDRESS_COMPARATOR);
        assertCommandSuccess(new SortCommand(SortCommand.SortField.ADDRESS), model,
                SortCommand.MESSAGE_SUCCESS_ADDRESS, expectedModel);
    }

    @Test
    public void execute_sortByName_success() {
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.sortPersonList(NAME_COMPARATOR);
        assertCommandSuccess(new SortCommand(SortCommand.SortField.NAME), model,
                SortCommand.MESSAGE_SUCCESS_NAME, expectedModel);
    }
}

