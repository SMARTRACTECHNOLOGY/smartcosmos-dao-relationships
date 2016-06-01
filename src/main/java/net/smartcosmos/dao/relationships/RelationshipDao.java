package net.smartcosmos.dao.relationships;

import net.smartcosmos.dto.relationships.RelationshipCreate;
import net.smartcosmos.dto.relationships.RelationshipLookupSpecific;
import net.smartcosmos.dto.relationships.RelationshipResponse;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

public interface RelationshipDao {

    /**
     * Creates a relationship in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param relationshipCreate the object to create
     * @return an {@link RelationshipResponse} instance for the created object
     * @throws ConstraintViolationException if the {@link RelationshipCreate} violates constraints enforced by the persistence service
     */
    RelationshipResponse create(
            String accountUrn,
            RelationshipCreate relationshipCreate)
        throws ConstraintViolationException;

     /**
     * Finds a relationship matching a specified URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @return the {@link RelationshipResponse} instance for the retrieved object or {@code empty} if the object does not exist
     */
    Optional<RelationshipResponse> findByUrn(String accountUrn, String urn);

    /**
     * Finds a relationship matching specified entity, related entity and type.
     *
     * @param accountUrn
     * @param relationshipLookupSpecific
     * @return
     * @throws ConstraintViolationException if the {@link RelationshipLookupSpecific} violates constraints enforced by the persistence service
     */
    Optional<RelationshipResponse> findSpecific(
            String accountUrn,
            RelationshipLookupSpecific relationshipLookupSpecific)
        throws ConstraintViolationException;

    /**
     * Deletes a relationship matching a specified URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @throws IllegalArgumentException if the relationship references by URN does not exist.
     */
    void delete(String accountUrn, String urn) throws IllegalArgumentException;

    // TODO: add Look Up All Relationships Between Entities

    // TODO: add Look Up Relationships By Type

    // TODO: add Look Up All Relationships
}
