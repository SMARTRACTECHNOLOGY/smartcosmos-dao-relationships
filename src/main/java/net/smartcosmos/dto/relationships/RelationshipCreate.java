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
public class RelationshipCreate {

    private static final int VERSION = 1;

    @Setter(AccessLevel.NONE)
    private int version = VERSION; // just in case there is a default constructor sometime

    private RelationshipReference source;
    private RelationshipReference target;
    private String relationshipType;

    @Builder
    @ConstructorProperties({"source", "target", "relationshipType"})
    public RelationshipCreate(
            RelationshipReference source,
            RelationshipReference target,
            String relationshipType)
    {
        this.source = source;
        this.target = target;
        this.relationshipType = relationshipType;

        this.version = VERSION;
    }
}
