package net.smartcosmos.dto.relationships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class RelationshipLookupSpecific {
    @Setter(AccessLevel.NONE)
    private String version = "1";

    private String entityReferenceType;
    private String referenceUrn;
    private String type;
    private String relatedEntityReferenceType;
    private String relatedReferenceUrn;

    @Builder
    @ConstructorProperties({"entityReferenceType", "referenceUrn", "type",
        "relatedEntityReferenceType", "relatedReferenceUrn"})
    public RelationshipLookupSpecific(
        String entityReferenceType,
        String referenceUrn,
        String type,
        String relatedEntityReferenceType,
        String relatedReferenceUrn)
    {
        this.entityReferenceType = entityReferenceType;
        this.referenceUrn = referenceUrn;
        this.type = type;
        this.relatedEntityReferenceType = relatedEntityReferenceType;
        this.relatedReferenceUrn = relatedReferenceUrn;
    }
}
