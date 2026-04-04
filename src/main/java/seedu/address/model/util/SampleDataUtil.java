package seedu.address.model.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.cert.CertExpiry;
import seedu.address.model.cert.CertName;
import seedu.address.model.cert.Certificate;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Salary;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagColour;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        ArrayList<Certificate> oscpCert = new ArrayList<>();
        oscpCert.add(new Certificate(
                new CertName("OSCP Plus"),
                new CertExpiry(LocalDate.parse("2028-12-31"))));

        ArrayList<Certificate> burpCert = new ArrayList<>();
        burpCert.add(new Certificate(
                new CertName("Burp Suite Certified Practitioner"),
                new CertExpiry(LocalDate.parse("2027-06-21"))));

        ArrayList<Certificate> uiCert = new ArrayList<>();
        uiCert.add(new Certificate(
                new CertName("Google UX Certificate"),
                new CertExpiry(LocalDate.parse("2027-02-21"))));


        return new Person[] {
            new Person(
                    new Name("John Kler"),
                    new Phone("+65 81234567"),
                    new Email("johnkler@example.co"),
                    new Address("123D Pine Road, #12-345, Singapore 123456"),
                    Set.of(new Tag("CEO", TagColour.YELLOW)),
                    new Salary("6500"),
                    oscpCert),
            new Person(
                    new Name("John Doe"),
                    new Phone("+65 87654321"),
                    new Email("johndoe@example.co"),
                    new Address("321D Einp Road, #54-321, Singapore 654321"),
                    Set.of(new Tag("IT", TagColour.YELLOW), new Tag("Security", TagColour.GREEN)),
                    new Salary("6500"),
                    burpCert),
            new Person(
                    new Name("Jane Do"),
                    new Phone("+65 84321765"),
                    new Email("janedo@example.co"),
                    new Address("987A Nepi Road, #21-543, Singapore 321654"),
                    Set.of(new Tag("Development", TagColour.YELLOW), new Tag("UI-UX", TagColour.GREEN),
                            new Tag("Intern", TagColour.PURPLE)),
                    new Salary("1300")),
            new Person(
                    new Name("Johny Doeh"),
                    new Phone("+65 81357246"),
                    new Email("johnydoeh@example.co"),
                    new Address("654B Enpi Road, #45-123, Singapore 246135"),
                    Set.of(new Tag("Admin", TagColour.YELLOW), new Tag("HR", TagColour.GREEN),
                            new Tag("Intern", TagColour.PURPLE)),
                    new Salary("1300")),
            new Person(
                    new Name("Bernice Yu"),
                    new Phone("+65 99272758"),
                    new Email("berniceyu@example.co"),
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    Set.of(new Tag("Development", TagColour.YELLOW), new Tag("UI-UX", TagColour.GREEN)),
                    new Salary("1300"),
                    uiCert),
            new Person(
                    new Name("Charlotte Oliveiro"),
                    new Phone("+65 93210283"),
                    new Email("charlotte@example.co"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    Set.of(new Tag("IT", TagColour.YELLOW), new Tag("Security", TagColour.GREEN)),
                    new Salary("6700")),
            new Person(
                    new Name("David Li"),
                    new Phone("+65 91031282"),
                    new Email("lidavid@example.co"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    Set.of(new Tag("Admin", TagColour.YELLOW), new Tag("HR", TagColour.GREEN)),
                    new Salary("5500")),
            new Person(
                    new Name("Irfan Ibbrahim"),
                    new Phone("+65 92492021"),
                    new Email("irfan@example.co"),
                    new Address("Blk 47 Tampines Street 20, #17-35"),
                    Set.of(new Tag("Admin", TagColour.YELLOW), new Tag("HR", TagColour.GREEN)),
                    new Salary("5500")),
            new Person(
                    new Name("Roy Balakrishnan"),
                    new Phone("+65 92624417"),
                    new Email("royb@example.co"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"),
                    Set.of(new Tag("Development", TagColour.YELLOW), new Tag("FrontEnd", TagColour.GREEN)),
                    new Salary("6700"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
