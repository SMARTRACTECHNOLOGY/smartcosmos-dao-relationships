package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class RelationshipReferenceTest {

    @Test
    public void thatObjectMapperIgnoresVersion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        RelationshipReference reference = RelationshipReference.builder()
            .type("sourceType")
            .urn("sourceUrn")
            .build();

        assertNotEquals(0, reference.getVersion());

        String jsonString = mapper.writeValueAsString(reference);
        JSONObject jsonObject = new JSONObject(jsonString);

        assertFalse(jsonObject.has("version"));
    }
}
