package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipResponse {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private final String urn;

    private final String entityReferenceType;
    private final String referenceUrn;
    private final String type;
    private final String relatedEntityReferenceType;
    private final String relatedReferenceUrn;

    private final String accountUrn;
    private final Long lastModifiedTimestamp;
    private final String moniker;

    @Builder
    @ConstructorProperties({"urn", "entityReferenceType", "referenceUrn", "type", "relatedEntityReferenceType", "relatedReferenceUrn", "accountUrn", "lastModifiedTimestamp", "moniker"})
    public RelationshipResponse(String urn, String entityReferenceType, String referenceUrn, String type, String relatedEntityReferenceType, String relatedReferenceUrn, String accountUrn, Long lastModifiedTimestamp, String moniker) {
        this.urn = urn;
        this.entityReferenceType = entityReferenceType;
        this.referenceUrn = referenceUrn;
        this.type = type;
        this.relatedEntityReferenceType = relatedEntityReferenceType;
        this.relatedReferenceUrn = relatedReferenceUrn;
        this.accountUrn = accountUrn;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        this.moniker = moniker;

        this.version = VERSION;
    }
}
