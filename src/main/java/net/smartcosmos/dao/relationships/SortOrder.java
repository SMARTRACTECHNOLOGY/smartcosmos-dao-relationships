package net.smartcosmos.dao.relationships;

public enum SortOrder {
    ASC,
    DESC;

    public static final SortOrder DEFAULT = ASC;

    public static SortOrder parseSortOrder(String s) {

        try {
            return SortOrder.valueOf(s.toUpperCase());
        } catch (NullPointerException | IllegalArgumentException e) {
            return DEFAULT;
        }
    }
}
