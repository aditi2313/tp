package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Patron;
import seedu.address.testutil.PatronBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPatron_success() {
        Patron validPatron = new PatronBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPatron(validPatron);

        assertCommandSuccess(new AddCommand(validPatron), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validPatron), expectedModel);
    }

    @Test
    public void execute_duplicatePatron_throwsCommandException() {
        Patron patronInList = model.getAddressBook().getPatronList().get(0);
        assertCommandFailure(new AddCommand(patronInList), model, AddCommand.MESSAGE_DUPLICATE_PATRON);
    }

}
