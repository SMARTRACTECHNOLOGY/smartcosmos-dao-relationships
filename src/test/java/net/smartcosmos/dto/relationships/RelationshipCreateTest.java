package net.smartcosmos.dto.relationships;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RelationshipCreateTest {

    @Test
    public void thatVersionIsSet() {
        RelationshipCreate relationshipCreate = RelationshipCreate.builder().build();

        assertNotNull(relationshipCreate.getVersion());
        assertEquals(1, relationshipCreate.getVersion());
    }
}
