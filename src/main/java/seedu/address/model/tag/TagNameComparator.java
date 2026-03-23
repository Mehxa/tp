package seedu.address.model.tag;

import java.util.Comparator;

public class TagNameComparator implements Comparator<Tag> {
    @Override
    public int compare(Tag o1, Tag o2) {
        return o1.tagName.compareTo(o2.tagName);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof TagNameComparator);
    }
}