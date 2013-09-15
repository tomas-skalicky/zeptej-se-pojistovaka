package cz.zeptejsepojistovaka.domainmodel;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({ @Type(value = VerifiedUser.class, name = VerifiedUser.JSON_TYPE_NAME),
        @Type(value = UnverifiedMessageAuthor.class, name = UnverifiedMessageAuthor.JSON_TYPE_NAME) })
public interface MessageAuthor extends User {
}
