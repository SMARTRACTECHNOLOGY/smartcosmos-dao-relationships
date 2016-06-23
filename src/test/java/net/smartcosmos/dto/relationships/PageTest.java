package net.smartcosmos.dto.relationships;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PageTest {

    @Test
    public void thatBuilderEmptyWorks() {
        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .build();
        assertNotNull(page);
    }

    @Test
    public void thatBuilderEmptyDataWorks() {
        List<RelationshipResponse> data = new ArrayList<>();

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertEquals(data, page.getData());
    }

    @Test
    public void thatBuilderNullDataWorks() {
        List<RelationshipResponse> data = new ArrayList<>();
        data.add(RelationshipResponse.builder().build());

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertFalse(page.getData().isEmpty());
        assertEquals(1, page.getData().size());
    }

    @Test
    public void thatBuilderDataWorks() {
        List<RelationshipResponse> data = null;

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData().isEmpty());
    }

    @Test
    public void thatBuilderDataWorksWithoutType() {
        List data = new ArrayList();

        Page page = Page.builder()
            .data(data)
            .build();

        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData().isEmpty());
    }

    @Test
    public void thatBuilderPageWorks() {
        PageInformation pageInfo = PageInformation.builder().build();

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .page(pageInfo)
            .build();
        assertNotNull(page);
        assertNotNull(page.getPage());
        assertEquals(pageInfo, page.getPage());
    }
}
