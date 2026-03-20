package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String ODD_ROW_COLOUR = "-fx-background-color: #514654;";
    private static final String EVEN_ROW_COLOUR = "-fx-background-color: #383c50;";

    private static final String FXML = "PersonListPanel.fxml";

    private static final int ENTRY_HEIGHT = 400;
    private static final int MIN_ENTRY_WIDTH = 340;
    private static final int SCROLL_BAR_WIDTH = 15;

    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);
    private final ObservableList<Person> personList;
    private int numColumns;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane personGridPane;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     *
     * Code rewritten with help from ChatGPT.
     */
    public PersonListPanel(ObservableList<Person> personList, double primaryStageWidth) {
        super(FXML);
        this.personList = personList;
        this.numColumns = 1;

        int usableWidth = (int) primaryStageWidth - SCROLL_BAR_WIDTH;
        updateEntryWidth(usableWidth);
        updateDisplay();
    }

    private void updateEntryWidth(int usableWidth) {
        System.out.println("!!!" + usableWidth);
    }

    private void updateDisplay() {
        this.scrollPane.setVvalue(0); // reset scroll to top
    }

    /**
     * Sets up listeners so the display updates when personList changes or window resizes.
     */
    public void setUpListeners() {
        this.personList.addListener((ListChangeListener<Person>) change -> {
            updateDisplay();
        });

        this.scrollPane.viewportBoundsProperty().addListener((obs, oldBounds, newBounds) -> {
            int scrollPaneWidth = (int) newBounds.getWidth();
            updateEntryWidth(scrollPaneWidth);
            updateDisplay();
        });
    }
}
