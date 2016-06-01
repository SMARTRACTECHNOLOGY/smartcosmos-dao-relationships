package net.smartcosmos.dto.relationships;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Setter;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class RelationshipResponse {
    @Setter(AccessLevel.NONE)
    private String version = "1";

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
