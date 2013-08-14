package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public interface User extends Serializable {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);
}
