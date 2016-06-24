package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class RelationshipResponseTest {

    private RelationshipReference source;
    private RelationshipReference target;

    @Before
    public void createReferences() {
        RelationshipReference source = RelationshipReference.builder()
            .type("sourceType")
            .urn("sourceUrn")
            .build();

        RelationshipReference target = RelationshipReference.builder()
            .type("targetType")
            .urn("targetUrn")
            .build();
    }


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
            .tenantUrn("tenantUrn")
            .source(source)
            .target(target)
            .relationshipType("relationshipType")
            .urn("urn")
            .build();

        assertNotEquals(0, relationshipResponse.getVersion());

        String jsonString = mapper.writeValueAsString(relationshipResponse);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }

    /* TODO: Remove (reciprocal)
    @Test
    public void thatObjectMapperDoesNotIncludeReciprocalIfNotSet() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        RelationshipResponse relationshipResponse = RelationshipResponse.builder()
            .tenantUrn("tenantUrn")
            .source(source)
            .target(target)
            .relationshipType("relationshipType")
            .urn("urn")
            .build();

        String jsonString = mapper.writeValueAsString(relationshipResponse);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("reciprocal"));
    }

    @Test
    public void thatObjectMapperIncludeReciprocalIfSet() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        RelationshipResponse relationshipResponse = RelationshipResponse.builder()
            .tenantUrn("tenantUrn")
            .source(source)
            .target(target)
            .relationshipType("relationshipType")
            .urn("urn")
            .build();

        relationshipResponse.setReciprocal(true);

        String jsonString = mapper.writeValueAsString(relationshipResponse);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertTrue(jsonObject.has("reciprocal"));
    }
    */
}
