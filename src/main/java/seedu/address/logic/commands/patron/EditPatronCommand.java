package seedu.address.logic.commands.patron;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PATRONS;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Email;
import seedu.address.model.person.Id;
import seedu.address.model.person.Name;
import seedu.address.model.person.Patron;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing patron in the address book.
 */
public class EditPatronCommand extends Command {

    public static final String MESSAGE_USAGE = PATRON_COMMAND_GROUP + EDIT_COMMAND_WORD
            + ": Edits the details of the patron identified "
            + "by the index number used in the displayed patron list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_NAME + "NAME] "
            + "[" + PREFIX_PHONE + "PHONE] "
            + "[" + PREFIX_EMAIL + "EMAIL] "
            + "[" + PREFIX_ID + "ID] "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + PATRON_COMMAND_GROUP + EDIT_COMMAND_WORD + " 1 "
            + PREFIX_PHONE + "91234567 "
            + PREFIX_EMAIL + "johndoe@example.com";

    public static final String MESSAGE_EDIT_PATRON_SUCCESS = "Edited Patron: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PATRON = "This patron already exists in the address book.";

    private final Index index;
    private final EditPersonDescriptor editPatronDescriptor;

    /**
     * @param index of the patron in the filtered patron list to edit
     * @param editPatronDescriptor details to edit the patron with
     */
    public EditPatronCommand(Index index, EditPersonDescriptor editPatronDescriptor) {
        requireNonNull(index);
        requireNonNull(editPatronDescriptor);

        this.index = index;
        this.editPatronDescriptor = new EditPersonDescriptor(editPatronDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Patron> lastShownList = model.getFilteredPatronList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATRON_DISPLAYED_INDEX);
        }

        Patron patronToEdit = lastShownList.get(index.getZeroBased());
        Patron editedPatron = createEditedPatron(patronToEdit, editPatronDescriptor);

        if (!patronToEdit.isSamePatron(editedPatron) && model.hasPatron(editedPatron)) {
            throw new CommandException(MESSAGE_DUPLICATE_PATRON);
        }

        model.setPatron(patronToEdit, editedPatron);
        model.updateFilteredPatronList(PREDICATE_SHOW_ALL_PATRONS);
        return new CommandResult(String.format(MESSAGE_EDIT_PATRON_SUCCESS, editedPatron));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code patronToEdit}
     * edited with {@code editPatronDescriptor}.
     */
    private static Patron createEditedPatron(Patron patronToEdit, EditPersonDescriptor editPatronDescriptor) {
        assert patronToEdit != null;

        Name updatedName = editPatronDescriptor.getName().orElse(patronToEdit.getName());
        Phone updatedPhone = editPatronDescriptor.getPhone().orElse(patronToEdit.getPhone());
        Email updatedEmail = editPatronDescriptor.getEmail().orElse(patronToEdit.getEmail());
        Id updatedId = editPatronDescriptor.getId().orElse(patronToEdit.getId());
        Set<Tag> updatedTags = editPatronDescriptor.getTags().orElse(patronToEdit.getTags());

        return new Patron(updatedName, updatedPhone, updatedEmail, updatedId, updatedTags);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditPatronCommand)) {
            return false;
        }

        // state check
        EditPatronCommand e = (EditPatronCommand) other;
        return index.equals(e.index)
                && editPatronDescriptor.equals(e.editPatronDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditPersonDescriptor {
        private Name name;
        private Phone phone;
        private Email email;
        private Id id;
        private Set<Tag> tags;

        public EditPersonDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditPersonDescriptor(EditPersonDescriptor toCopy) {
            setName(toCopy.name);
            setPhone(toCopy.phone);
            setEmail(toCopy.email);
            setId(toCopy.id);
            setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, phone, email, id, tags);
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Optional<Name> getName() {
            return Optional.ofNullable(name);
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public Optional<Phone> getPhone() {
            return Optional.ofNullable(phone);
        }

        public void setEmail(Email email) {
            this.email = email;
        }

        public Optional<Email> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setId(Id id) {
            this.id = id;
        }

        public Optional<Id> getId() {
            return Optional.ofNullable(id);
        }

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditPersonDescriptor)) {
                return false;
            }

            // state check
            EditPersonDescriptor e = (EditPersonDescriptor) other;

            return getName().equals(e.getName())
                    && getPhone().equals(e.getPhone())
                    && getEmail().equals(e.getEmail())
                    && getId().equals(e.getId())
                    && getTags().equals(e.getTags());
        }
    }
}