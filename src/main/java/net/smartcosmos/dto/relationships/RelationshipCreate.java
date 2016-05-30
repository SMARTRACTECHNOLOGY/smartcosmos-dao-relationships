package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationshipCreate {
    private String entityReferenceType;
    private String referenceUrn;
    private String type;
    private String relatedEntityReferenceType;
    private String relatedReferenceUrn;
    private String moniker;

    @Builder
    @ConstructorProperties({"entityReferenceType", "referenceUrn", "type",
            "relatedEntityReferenceType", "relatedReferenceUrn", "moniker"})
    public RelationshipCreate(
            String entityReferenceType,
            String referenceUrn,
            String type,
            String relatedEntityReferenceType,
            String relatedReferenceUrn,
            String moniker)
    {
        this.entityReferenceType = entityReferenceType;
        this.referenceUrn = referenceUrn;
        this.type = type;
        this.relatedEntityReferenceType = relatedEntityReferenceType;
        this.relatedReferenceUrn = relatedReferenceUrn;
        this.moniker = moniker;
    }
}
