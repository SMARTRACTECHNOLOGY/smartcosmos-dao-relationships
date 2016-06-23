package net.smartcosmos.dao.relationships;

import net.smartcosmos.dto.relationships.Page;
import net.smartcosmos.dto.relationships.RelationshipResponse;
import net.smartcosmos.dto.relationships.RelationshipCreate;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface RelationshipDao {

    /**
     * Creates a relationship in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param createRelationship the relationship to create
     * @return an {@link RelationshipResponse} instance for the created object
     * @throws ConstraintViolationException if the {@link RelationshipCreate} violates constraints enforced by the persistence service
     */
    Optional<RelationshipResponse> create(
            String tenantUrn,
            RelationshipCreate createRelationship)
        throws ConstraintViolationException;

     /**
     * Finds a relationship matching a specified URN in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @return the {@link RelationshipResponse} instance for the retrieved relationship or {@code empty} if the relationship does not exist
     */
    Optional<RelationshipResponse> findByUrn(String tenantUrn, String urn);

    /**
     * Finds a specific relationship between entities with a specified relationshipType in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param sourceType the entity reference relationshipType
     * @param sourceUrn the reference entity's system-assigned URN
     * @param targetType the entity reference relationshipType of the related entity
     * @param targetUrn the related reference entity's system-assigned URN
     * @param relationshipType the relationship relationshipType
     * @return the {@link RelationshipResponse} instance for the retrieved relationship or {@code empty} if the relationship does not exist
     */
    Optional<RelationshipResponse> findSpecific(
            String tenantUrn,
            String sourceType,
            String sourceUrn,
            String targetType,
            String targetUrn,
            String relationshipType);

    /**
     * Deletes a relationship matching a specified URN in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @return a list of {@link RelationshipResponse} instances for the deleted relationship entities
     */
    List<RelationshipResponse> delete(String tenantUrn, String urn);

    /**
     * Finds all relationships between specified entities in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param sourceType the entity reference relationshipType
     * @param sourceUrn the reference entity's system-assigned URN
     * @param targetType the entity reference relationshipType of the related entity
     * @param targetUrn the related reference entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findBetweenEntities(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        String targetType,
        String targetUrn,
        Long page,
        Integer size);

    /**
     * Finds all relationships for a given reference entity matching a specified relationshipType in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param sourceType the entity reference relationshipType
     * @param sourceUrn the reference entity's system-assigned URN
     * @param relationshipType the relationship relationshipType
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findByType(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        String relationshipType,
        Long page,
        Integer size);

    /**
     * Finds all reverse relationships related to a given reference entity matching a specified relationshipType in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param targetType the related entity reference relationshipType
     * @param targetUrn the related reference entity's system-assigned URN
     * @param relationshipType the relationship relationshipType
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findByTypeReverse(
        String tenantUrn,
        String targetType,
        String targetUrn,
        String relationshipType,
        Long page,
        Integer size);

    /**
     * Finds all relationships for a given reference entity in the realm of a given account.
     *
     * @param tenantUrn the account URN
     * @param sourceType the entity reference relationshipType
     * @param sourceUrn the reference entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAll(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        Long page,
        Integer size);

    /**
     * Finds all relationships for a given reference entity in the realm of a given account and includes a
     * {@code reciprocal} flag in the response if {@code checkReciprocal} is set to {@code true}.
     *
     * @param tenantUrn the account URN
     * @param targetType the related entity reference relationshipType
     * @param targetUrn the related reference entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAllReverse(
        String tenantUrn,
        String targetType,
        String targetUrn,
        Long page,
        Integer size);
}
