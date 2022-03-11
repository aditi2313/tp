package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedBook.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalBooks.ALGORITHM;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.book.BookName;
import seedu.address.model.book.Isbn;

public class JsonAdaptedBookTest {
    private static final String INVALID_BOOK_NAME = "H@rryPotter";
    private static final String INVALID_ISBN = "+97829812";
    private static final String INVALID_TAG = "#Adventure";
    private static final String INVALID_AUTHOR = "J!KRowling";

    private static final String VALID_BOOK_NAME = ALGORITHM.getBookName().fullBookName;
    private static final String VALID_ISBN = ALGORITHM.getIsbn().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = ALGORITHM.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());
    private static final List<JsonAdaptedAuthor> VALID_AUTHORS = ALGORITHM.getAuthors().stream()
            .map(JsonAdaptedAuthor::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validBookDetails_returnsBook() throws Exception {
        JsonAdaptedBook book = new JsonAdaptedBook(ALGORITHM);
        assertEquals(ALGORITHM, book.toModelType());
    }

    @Test
    public void toModelType_invalidBookName_throwsIllegalValueException() {
        JsonAdaptedBook book =
                new JsonAdaptedBook(INVALID_BOOK_NAME, VALID_ISBN, VALID_TAGS, VALID_AUTHORS);
        String expectedMessage = BookName.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, book::toModelType);
    }

    @Test
    public void toModelType_nullBookName_throwsIllegalValueException() {
        JsonAdaptedBook book = new JsonAdaptedBook(null, VALID_ISBN, VALID_TAGS, VALID_AUTHORS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, BookName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, book::toModelType);
    }

    @Test
    public void toModelType_invalidIsbn_throwsIllegalValueException() {
        JsonAdaptedBook book =
                new JsonAdaptedBook(VALID_BOOK_NAME, INVALID_ISBN, VALID_TAGS, VALID_AUTHORS);
        String expectedMessage = Isbn.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, book::toModelType);
    }

    @Test
    public void toModelType_nullIsbn_throwsIllegalValueException() {
        JsonAdaptedBook book = new JsonAdaptedBook(VALID_BOOK_NAME, null, VALID_TAGS, VALID_AUTHORS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Isbn.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, book::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedBook book =
                new JsonAdaptedBook(VALID_BOOK_NAME, VALID_ISBN, invalidTags, VALID_AUTHORS);
        assertThrows(IllegalValueException.class, book::toModelType);
    }

    @Test
    public void toModelType_validTags_throwsIllegalValueException() {
        List<JsonAdaptedAuthor> invalidAuthors = new ArrayList<>(VALID_AUTHORS);
        invalidAuthors.add(new JsonAdaptedAuthor(INVALID_AUTHOR));
        JsonAdaptedBook book =
                new JsonAdaptedBook(VALID_BOOK_NAME, VALID_ISBN, VALID_TAGS, invalidAuthors);
        assertThrows(IllegalValueException.class, book::toModelType);
    }
}