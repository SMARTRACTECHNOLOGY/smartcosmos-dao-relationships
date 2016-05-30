package net.smartcosmos.dto.relationships;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipResponse {
    private final String urn;

    private final String entityReferenceType;
    private final String referenceUrn;
    private final String type;
    private final String relatedEntityReferenceType;
    private final String relatedReferenceUrn;

    private final String accountUrn;
    private final Long lastModifiedTimestamp;
    private final String moniker;
}
