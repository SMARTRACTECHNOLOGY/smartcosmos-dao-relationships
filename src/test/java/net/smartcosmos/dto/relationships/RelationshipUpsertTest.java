package net.smartcosmos.dto.relationships;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RelationshipUpsertTest {

    @Test
    public void thatRelationshipCreateVersionIsSet() {
        RelationshipUpsert relationshipUpsert = RelationshipUpsert.builder().build();

        assertNotNull(relationshipUpsert.getVersion());
        assertEquals(1, relationshipUpsert.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test
    public void thatRelationshipCreateVersionHasNoSetter() {
        Method getVersion = null;
        try {
            getVersion = RelationshipUpsert.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
