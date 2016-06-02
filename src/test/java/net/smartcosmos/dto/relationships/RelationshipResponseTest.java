package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RelationshipResponseTest {

    @Test
    public void thatRelationshipResponseVersionIsSet() {
        RelationshipResponse relationshipResponse = RelationshipResponse.builder().build();

        assertNotEquals(0, relationshipResponse.getVersion());
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

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        RelationshipResponse relationshipResponse = RelationshipResponse.builder()
            .accountUrn("accountUrn")
            .entityReferenceType("entityReferenceType")
            .referenceUrn("referenceUrn")
            .relatedEntityReferenceType("relatedEntityReferenceType")
            .relatedReferenceUrn("relatedReferenceUrn")
            .lastModifiedTimestamp(123L)
            .type("type")
            .urn("urn")
            .moniker("moniker")
            .build();

        assertNotEquals(0, relationshipResponse.getVersion());

        String jsonString = mapper.writeValueAsString(relationshipResponse);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
