package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties({"version"})
@Builder
public class RelationshipResponse {

    private static final int VERSION = 1;
    private final int version = VERSION;

    private final RelationshipReference source;

    private final RelationshipReference target;

    private final String relationshipType;

    private final String urn;

    private final String tenantUrn;
}
