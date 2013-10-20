package cz.zeptejsepojistovaka.persistence.db.migration;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
final class SqlSnippet {

    static final String DROP_TABLE_STATEMENT_PREFIX = " DROP TABLE IF EXISTS ";
    static final String CREATE_TABLE_STATEMENT_PREFIX = " CREATE TABLE ";
    static final String CREATE_TABLE_STATEMENT_SUFFIX = " ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    private SqlSnippet() {
    }

    static String buildForeignConstraint(String constraintName, String foreignKeyColumnName,
            String referencedTableName, String referencedColumnName,
            ForeignConstraintActionType onUpdateAction, ForeignConstraintActionType onDeleteAction) {
        return String.format(" CONSTRAINT %s FOREIGN KEY (%s) REFERENCES %s (%s) ON UPDATE %s ON DELETE %s ",
                constraintName, foreignKeyColumnName, referencedTableName, referencedColumnName,
                onUpdateAction.name(), onDeleteAction.name());
    }

    enum ForeignConstraintActionType {
        CASCADE
    }
}
