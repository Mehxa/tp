package seedu.address.model.person;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Tests that a {@code Person}'s set of {@code Tags} matches any of the keywords given.
 */
public class TagContainsKeywordsPredicate implements Predicate<Person> {
    private final List<Set<Tag>> tagGroups;

    public TagContainsKeywordsPredicate(List<Set<Tag>> tagGroups) {
        this.tagGroups = tagGroups;
    }

    @Override
    public boolean test(Person person) {
        return tagGroups.stream().anyMatch(group ->
            group.stream()
            .allMatch(keywordTag -> person.getTags().stream()
            .anyMatch(personTag -> personTag.containsTagNameIgnoreCase(keywordTag)))
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TagContainsKeywordsPredicate)) {
            return false;
        }

        TagContainsKeywordsPredicate otherTagContainsKeywordsPredicate = (TagContainsKeywordsPredicate) other;
        return tagGroups.equals(otherTagContainsKeywordsPredicate.tagGroups);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", tagGroups).toString();
    }
}
