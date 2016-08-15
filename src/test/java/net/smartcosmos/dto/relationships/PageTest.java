package net.smartcosmos.dto.relationships;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

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
        data.add(RelationshipResponse.builder()
                     .build());

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertFalse(page.getData()
                        .isEmpty());
        assertEquals(1,
                     page.getData()
                         .size());
    }

    @Test
    public void thatBuilderDataWorks() {

        List<RelationshipResponse> data = null;

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .data(data)
            .build();
        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData()
                       .isEmpty());
    }

    @Test
    public void thatBuilderDataWorksWithoutType() {

        List data = new ArrayList();

        Page page = Page.builder()
            .data(data)
            .build();

        assertNotNull(page);
        assertNotNull(page.getData());
        assertTrue(page.getData()
                       .isEmpty());
    }

    @Test
    public void thatBuilderPageWorks() {

        PageInformation pageInfo = PageInformation.builder()
            .build();

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder()
            .page(pageInfo)
            .build();
        assertNotNull(page);
        assertNotNull(page.getPage());
        assertEquals(pageInfo, page.getPage());
    }

    @Test
    public void thatBuilderPageHasDefaultValues() {

        Page<RelationshipResponse> page = Page.<RelationshipResponse>builder().build();

        assertNotNull(page.getData());
        Collection<RelationshipResponse> data = page.getData();
        assertTrue(data.isEmpty());

        assertNotNull(page.getPage());
        PageInformation pageInformation = page.getPage();
        assertEquals(0, pageInformation.getNumber());
        assertEquals(0, pageInformation.getSize());
        assertEquals(0, pageInformation.getTotalPages());
        assertEquals(0, pageInformation.getTotalElements());
    }
}
