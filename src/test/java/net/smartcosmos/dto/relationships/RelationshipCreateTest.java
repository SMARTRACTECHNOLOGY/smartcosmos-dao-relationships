package net.smartcosmos.dto.relationships;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RelationshipCreateTest {

    @Test
    public void thatRelationshipCreateVersionIsSet() {
        RelationshipCreate relationshipCreate = RelationshipCreate.builder().build();

        assertNotNull(relationshipCreate.getVersion());
        assertEquals(1, relationshipCreate.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test
    public void thatRelationshipCreateVersionHasNoSetter() {
        Method getVersion = null;
        try {
            getVersion = RelationshipCreate.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
