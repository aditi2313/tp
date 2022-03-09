package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Patron;
import seedu.address.testutil.PatronBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPatron_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_patronAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPatronAdded modelStub = new ModelStubAcceptingPatronAdded();
        Patron validPerson = new PatronBuilder().build();

        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPerson), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.patronsAdded);
    }

    @Test
    public void execute_duplicatePatron_throwsCommandException() {
        Patron validPatron = new PatronBuilder().build();
        AddCommand addCommand = new AddCommand(validPatron);
        ModelStub modelStub = new ModelStubWithPerson(validPatron);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PATRON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Patron alice = new PatronBuilder().withName("Alice").build();
        Patron bob = new PatronBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPatron(Patron patron) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPatron(Patron patron) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePatron(Patron target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPatron(Patron target, Patron editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Patron> getFilteredPatronList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPatronList(Predicate<Patron> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Patron person;

        ModelStubWithPerson(Patron person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasPatron(Patron person) {
            requireNonNull(person);
            return this.person.isSamePerson(person);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPatronAdded extends ModelStub {
        final ArrayList<Patron> patronsAdded = new ArrayList<>();

        @Override
        public boolean hasPatron(Patron person) {
            requireNonNull(person);
            return patronsAdded.stream().anyMatch(person::isSamePerson);
        }

        @Override
        public void addPatron(Patron person) {
            requireNonNull(person);
            patronsAdded.add(person);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
