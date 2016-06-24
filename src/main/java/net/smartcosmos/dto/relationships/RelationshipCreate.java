package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class RelationshipCreate {

    private static final int VERSION = 1;
    private final int version = VERSION;

    private RelationshipReference source;
    private RelationshipReference target;
    private String relationshipType;
}
