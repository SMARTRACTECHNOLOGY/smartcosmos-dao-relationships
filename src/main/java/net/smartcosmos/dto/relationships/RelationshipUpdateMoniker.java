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
public class RelationshipUpdateMoniker {
    @Setter(AccessLevel.NONE)
    private String version = "1";

    private String urn;
    private String moniker;

    @Builder
    @ConstructorProperties({"urn", "moniker"})
    public RelationshipUpdateMoniker(String urn, String moniker)
    {
        this.urn = urn;
        this.moniker = moniker;
    }
}
