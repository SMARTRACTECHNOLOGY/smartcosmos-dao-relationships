package net.smartcosmos.dao.relationships;

import org.junit.*;

import static org.junit.Assert.*;

public class SortOrderTest {

    @Test
    public void thatParseAscLowerReturnsAsc() {

        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder("asc"));
    }

    @Test
    public void thatParseAscUpperReturnsAsc() {

        assertEquals(SortOrder.ASC, SortOrder.parseSortOrder("ASC"));
    }

    @Test
    public void thatParseDescLowerReturnsDesc() {

        assertEquals(SortOrder.DESC, SortOrder.parseSortOrder("desc"));
    }

    @Test
    public void thatParseDecUpperReturnsDesc() {

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
