package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.MULTI_TAG_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.MULTI_TAG_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.TagCommandParser.MESSAGE_USELESS_COLOUR;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.TagCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagColour;

public class TagCommandParserTest {
    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, TagCommand.MESSAGE_USAGE);

    private TagCommandParser parser = new TagCommandParser();

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    private String defaultTagFlags = "a/TEST1 d/TEST2";

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", TagCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);

        // only colour specified
        assertParseFailure(parser, "c/blue", MESSAGE_USELESS_COLOUR);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + defaultTagFlags, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + defaultTagFlags, MESSAGE_INVALID_FORMAT);

        assertParseFailure(parser, "a" + defaultTagFlags, ParserUtil.MESSAGE_INVALID_INDEX);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_allFieldsPresent_success() {
        assertParseSuccess(parser, "1 a/TEST1 d/TEST2 c/red",
                new TagCommand(INDEX_FIRST_PERSON,
                        Set.of(new Tag("TEST1", TagColour.RED)),
                        Set.of(new Tag("TEST2"))
                        ));
    }

    @Test
    public void parse_someFieldsPresent_success() {
        assertParseSuccess(parser, "1 d/TEST1 TEST2",
                new TagCommand(INDEX_FIRST_PERSON,
                        Set.of(),
                        Set.of(new Tag("TEST1"), new Tag("TEST2"))
                ));


        assertParseSuccess(parser, "1 a/TEST1 TEST2",
                new TagCommand(INDEX_FIRST_PERSON,
                        Set.of(new Tag("TEST1"), new Tag("TEST2")),
                        Set.of()
                ));

        assertParseSuccess(parser, "1 a/TEST1 TEST2 c/purple",
                new TagCommand(INDEX_FIRST_PERSON,
                        Set.of(new Tag("TEST1", TagColour.PURPLE), new Tag("TEST2", TagColour.PURPLE)),
                        Set.of()
                ));
    }

    @Test
    public void parse_invalidColourFieldsPresent_failure() {
        assertParseFailure(parser, "1 d/TEST1 c/GREEN", MESSAGE_USELESS_COLOUR);

        assertParseFailure(parser, "1 c/RED", MESSAGE_USELESS_COLOUR);

        assertParseFailure(parser, "1 a/BOB c/WHITE", TagColour.MESSAGE_INVALID_COLOUR);
    }


    @Test
    public void execute_invalidPersonIndexUnfilteredList_failure() {
        assertParseFailure(parser, "a" + MULTI_TAG_DESC_AMY + MULTI_TAG_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, TagCommand.MESSAGE_USAGE));
    }


}
