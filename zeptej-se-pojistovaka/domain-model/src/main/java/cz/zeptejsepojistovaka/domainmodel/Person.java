package cz.zeptejsepojistovaka.domainmodel;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public interface Person {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);
}
