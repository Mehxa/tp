package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command, use 'help' to view available commands.";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    public static final String MESSAGE_ADD_PERSON_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book.";
    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    public static final String LIST_MESSAGE_SUCCESS = "Listed all persons";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    public static final String MESSAGE_TAG_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    public static final String MESSAGE_NOT_TAGS_PROVIDED = "At least one field to edit must be provided.";
    public static final String MESSAGE_NOT_TAGS_EDITED = "No tags were changed.";

    public static final String MESSAGE_CERT_ADD_SUCCESS = "New certificate added: %1$s";
    public static final String MESSAGE_CERT_EDIT_SUCCESS = "Certificate edited: %1$s";
    public static final String MESSAGE_CERT_DELETE_SUCCESS = "Certificate deleted: %1$s";
    public static final String MESSAGE_MISSING_CERT = "This person does not have this certificate.";
    public static final String MESSAGE_DUPLICATE_CERT = "This person already has this certificate.";

    public static final String UNDO_MESSAGE_SUCCESS = "Undid the previous command.";
    public static final String UNDO_MESSAGE_FAILURE = "No previous commands to undo.";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Tags: ");
        person.getTags().forEach(builder::append);
        builder.append("; Certificates: ");
        person.getCertificates().forEach(builder::append);
        return builder.toString();
    }

}
