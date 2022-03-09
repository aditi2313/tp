package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Patron;

/**
 * Panel containing the list of persons.
 */
public class PatronListPanel extends UiPart<Region> {
    private static final String FXML = "PatronListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PatronListPanel.class);

    @FXML
    private ListView<Patron> personListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PatronListPanel(ObservableList<Patron> personList) {
        super(FXML);
        personListView.setItems(personList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Patron> {
        @Override
        protected void updateItem(Patron person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PatronCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
