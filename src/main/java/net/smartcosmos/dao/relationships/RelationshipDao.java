package net.smartcosmos.dao.relationships;

import net.smartcosmos.dto.relationships.Page;
import net.smartcosmos.dto.relationships.RelationshipResponse;
import net.smartcosmos.dto.relationships.RelationshipCreate;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface RelationshipDao {

    /**
     * Creates a relationship in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param createRelationship the relationship to create
     * @return an {@link RelationshipResponse} instance for the created object
     * @throws ConstraintViolationException if the {@link RelationshipCreate} violates constraints enforced by the persistence service
     */
    Optional<RelationshipResponse> create(
        String tenantUrn,
        RelationshipCreate createRelationship) throws ConstraintViolationException;

     /**
     * Finds a relationship matching a specified URN in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param urn the relationship's system-assigned URN
     * @return the {@link RelationshipResponse} instance for the retrieved relationship or {@code empty} if the relationship does not exist
     */
    Optional<RelationshipResponse> findByUrn(String tenantUrn, String urn);

    /**
     * Finds a specific relationship between entities with a specified relationshipType in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param sourceType the source entity type
     * @param sourceUrn the source entity's system-assigned URN
     * @param targetType the target entity type
     * @param targetUrn the target entity's system-assigned URN
     * @param relationshipType the relationship type
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
     * Deletes a relationship matching a specified URN in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param urn the relationship's system-assigned URN
     * @return a list of {@link RelationshipResponse} instances for the deleted relationship entities
     */
    List<RelationshipResponse> delete(String tenantUrn, String urn);

    /**
     * Finds all relationships between specified entities in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param sourceType the source entity type
     * @param sourceUrn the source entity's system-assigned URN
     * @param targetType the target entity type
     * @param targetUrn the target entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findBetweenEntities(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        String targetType,
        String targetUrn,
        Integer page,
        Integer size);

    /**
     * Finds all relationships for a given source entity matching a specified relationshipType in the realm of a
     * given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param sourceType the source entity type
     * @param sourceUrn the source entity's system-assigned URN
     * @param relationshipType the relationship type
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findByType(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        String relationshipType,
        Integer page,
        Integer size);

    /**
     * Finds all relationships related to a given target entity matching a specified relationshipType in the realm of a
     * given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param targetType the target entity type
     * @param targetUrn the target entity's system-assigned URN
     * @param relationshipType the relationship type
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findByTypeReverse(
        String tenantUrn,
        String targetType,
        String targetUrn,
        String relationshipType,
        Integer page,
        Integer size);

    /**
     * Finds all relationships for a given source entity in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param sourceType the source entity type
     * @param sourceUrn the source entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAll(
        String tenantUrn,
        String sourceType,
        String sourceUrn,
        Integer page,
        Integer size);

    /**
     * Finds all relationships for a given target entity in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param targetType the target entity type
     * @param targetUrn the target entity's system-assigned URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAllReverse(
        String tenantUrn,
        String targetType,
        String targetUrn,
        Integer page,
        Integer size);

    /**
     * Finds all relationships matching a specified relationshipType in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param relationshipType the relationship type
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAllByRelationshipType(
        String tenantUrn,
        String relationshipType,
        Integer page,
        Integer size);

    /**
     * Finds all relationships between source entities of sourceType and target entities of tagret type in the realm of
     * a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param sourceType the source entity type
     * @param targetType the target entity type
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    Page<RelationshipResponse> findAllBetweenTypes(
        String tenantUrn,
        String sourceType,
        String targetType,
        Integer page,
        Integer size);
}
