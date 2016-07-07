package net.smartcosmos.dao.relationships;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortOrderTest {

    @Test
    public void thatParseAscLowerReturnsAsc() {
        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder("asc"));
    }

    @Test
    public void thatParseAscUpperReturnsDec() {
        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder("ASC"));
    }

    @Test
    public void thatParseDescLowerReturnsAsc() {
        assertEquals(SortOrder.DESC, SortOrder.parseSortOrder("desc"));
    }

    @Test
    public void thatParseDecUpperReturnsDec() {
        assertEquals(SortOrder.DESC, SortOrder.parseSortOrder("desc"));
    }

    @Test
    public void thatParseBlaReturnsAsc() {
        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder("bla"));
    }

    @Test
    public void thatParseNullReturnsAsc() {
        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder(null));
    }
}
