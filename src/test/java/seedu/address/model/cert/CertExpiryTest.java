package seedu.address.model.cert;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CertExpiryTest {

    @Test
    public void constructor_null_success() {
        CertExpiry forever = new CertExpiry(null);
        assertFalse(forever.hasExpiry());
    }

    @Test
    public void isBefore_comparisonWithNull() {
        CertExpiry specificDate = new CertExpiry(LocalDate.parse("2026-01-01"));
        CertExpiry forever = new CertExpiry(null);

        // A specific date is before forever
        assertTrue(specificDate.isBefore(forever));

        // forever is not before a specific date
        assertFalse(forever.isBefore(specificDate));

        // forever is not before forever
        assertFalse(forever.isBefore(new CertExpiry(null)));
    }

    @Test
    public void equals() {
        CertExpiry expiry = new CertExpiry(LocalDate.parse("2026-03-17"));
        assertTrue(expiry.equals(new CertExpiry(LocalDate.parse("2026-03-17"))));

        assertTrue(expiry.equals(expiry));

        assertFalse(expiry.equals(5));

        assertFalse(expiry.equals("2026-03-08"));
    }
}
