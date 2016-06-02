package net.smartcosmos.dao.relationships;

import net.smartcosmos.dto.relationships.RelationshipResponse;
import net.smartcosmos.dto.relationships.RelationshipUpsert;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface RelationshipDao {

    /**
     * Creates a relationship in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param upsertRelationship the relationship to upsert
     * @return an {@link RelationshipResponse} instance for the created object
     * @throws ConstraintViolationException if the {@link RelationshipUpsert} violates constraints enforced by the persistence service
     */
    RelationshipResponse upsert(
            String accountUrn,
            RelationshipUpsert upsertRelationship)
        throws ConstraintViolationException;

     /**
     * Finds a relationship matching a specified URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @return the {@link RelationshipResponse} instance for the retrieved relationship or {@code empty} if the relationship does not exist
     */
    Optional<RelationshipResponse> findByUrn(String accountUrn, String urn);

    /**
     * Finds a specific relationship between entities with a specified type in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the entity reference type
     * @param referenceUrn the reference entity's system-assigned URN
     * @param relatedEntityReferenceType the entity reference type of the related entity
     * @param relatedReferenceUrn the related reference entity's system-assigned URN
     * @param type the relationship type
     * @return the {@link RelationshipResponse} instance for the retrieved relationship or {@code empty} if the relationship does not exist
     */
    Optional<RelationshipResponse> findSpecific(
            String accountUrn,
            String entityReferenceType,
            String referenceUrn,
            String relatedEntityReferenceType,
            String relatedReferenceUrn,
            String type);

    /**
     * Deletes a relationship matching a specified URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param urn the relationship's system-assigned URN
     * @return an {@link RelationshipResponse} instance for the deleted object
     */
    Optional<RelationshipResponse> delete(String accountUrn, String urn);


    /**
     * Finds all relationships between specified entities in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the entity reference type
     * @param referenceUrn the reference entity's system-assigned URN
     * @param relatedEntityReferenceType the entity reference type of the related entity
     * @param relatedReferenceUrn the related reference entity's system-assigned URN
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    List<RelationshipResponse> findBetweenEntities(
        String accountUrn,
        String entityReferenceType,
        String referenceUrn,
        String relatedEntityReferenceType,
        String relatedReferenceUrn);

    /**
     * Finds all relationships for a given reference entity matching a specified type in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the entity reference type
     * @param referenceUrn the reference entity's system-assigned URN
     * @param type the relationship type
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    List<RelationshipResponse> findByType(
        String accountUrn,
        String entityReferenceType,
        String referenceUrn,
        String type);

    /**
     * Finds all relationships related to a given reference entity matching a specified type in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param relatedEntityReferenceType the related entity reference type
     * @param relatedReferenceUrn the related reference entity's system-assigned URN
     * @param type the relationship type
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    List<RelationshipResponse> findByTypeReverse(
        String accountUrn,
        String relatedEntityReferenceType,
        String relatedReferenceUrn,
        String type);

    /**
     * Finds all relationships for a given reference entity in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the entity reference type
     * @param referenceUrn the reference entity's system-assigned URN
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    List<RelationshipResponse> findAll(
        String accountUrn,
        String entityReferenceType,
        String referenceUrn);

    /**
     * Finds all reflexive relationships for a given entity in the realm of a given account.
     * <p></p>
     * A matching set of relationship contains two bidirectional relationships of the same type between reference
     * entity and related reference entity respectively.
     *
     * @param accountUrn the account URN
     * @param entityReferenceType the entity reference type
     * @param referenceUrn the reference entity's system-assigned URN
     * @return a list of matching {@link RelationshipResponse} instances for the retrieved relationships
     */
    List<RelationshipResponse> findAllReflexive(
        String accountUrn,
        String entityReferenceType,
        String referenceUrn);
}
