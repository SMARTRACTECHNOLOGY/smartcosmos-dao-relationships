package net.smartcosmos.dto.relationships;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RelationshipResponseTest {

    @Test
    public void thatRelationshipResponseVersionIsSet() {
        RelationshipResponse relationshipResponse = RelationshipResponse.builder().build();

        assertNotNull(relationshipResponse.getVersion());
        assertEquals(1, relationshipResponse.getVersion());
    }

    /**
     * This actually tests if Lombok is properly used.
     */
    @Test
    public void thatRelationshipResponseVersionHasNoSetter() {
        Method getVersion = null;
        try {
            getVersion = RelationshipResponse.class.getDeclaredMethod("setVersion", int.class);
        } catch (NoSuchMethodException e) {
            // that's what we expect
        }
        assertNull(getVersion);
    }
}
