package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ExportCommandTest {

    @TempDir
    public Path tempDir;

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_validPath_writesCsv() throws Exception {
        Path csvFile = tempDir.resolve("out").resolve("contacts.csv");

        ExportCommand command = new ExportCommand(csvFile);
        CommandResult result = command.execute(model);

        assertEquals(String.format("Exported %d persons to: %s",
                        model.getAddressBook().getPersonList().size(), csvFile),
                result.getFeedbackToUser());

        assertTrue(Files.exists(csvFile));
        List<String> lines = Files.readAllLines(csvFile);
        assertTrue(lines.size() > 1);
        assertEquals("name,phone,email,address,class,tags", lines.get(0));
        assertTrue(lines.stream().anyMatch(line -> line.contains("Alice Pauline")));
    }
}

