package cz.zeptejsepojistovaka.persistence.db.migration;

import static org.junit.Assert.*;

import org.junit.Test;

import cz.zeptejsepojistovaka.persistence.db.migration.SqlSnippet.ForeignConstraintActionType;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class SqlSnippetTest {

    @Test
    public void testBuildForeignConstraint() throws Exception {
        String constraintName = "FK_tag_patterns_tags";
        String tagId = "tag_id";
        String tags = "tags";
        String id = "id";

        String actualSnippet = SqlSnippet.buildForeignConstraint(constraintName, tagId, tags, id,
                ForeignConstraintActionType.CASCADE, ForeignConstraintActionType.CASCADE);
        String expectedSnippet = " CONSTRAINT " + constraintName + " FOREIGN KEY (" + tagId + ") REFERENCES "
                + tags + " (" + id + ") ON UPDATE CASCADE ON DELETE CASCADE ";
        assertEquals(expectedSnippet, actualSnippet);
    }
}
