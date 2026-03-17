package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private TilePane personTilePane;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     *
     * Code rewritten with help from ChatGPT.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);

        int i = 1;
        for (Person person : personList) {
            personTilePane.getChildren().add(new PersonCard(person, i++).getRoot());
        }

        personList.addListener((ListChangeListener<Person>) change -> {
            personTilePane.getChildren().clear();

            int j = 1;
            for (Person person : personList) {
                personTilePane.getChildren().add(new PersonCard(person, j++).getRoot());
            }
        });
    }
}
