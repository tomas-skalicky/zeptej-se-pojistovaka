package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@NoArgsConstructor
@Entity
@Table(name = Right.TABLE_NAME)
public class Right implements GrantedAuthority {

    private static final long serialVersionUID = -6965401950684956798L;

    public static final String TABLE_NAME = "rights";

    public Right(int userId, RightType rightType) {
        setId(new RightKey(userId, rightType));
    }

    public Right(int userId, int rightTypeId) {
        this(userId, RightType.getType(rightTypeId));
    }

    @NotNull
    @NonNull
    @Getter
    @Setter
    @EmbeddedId
    private RightKey id;

    @Override
    public String getAuthority() {
        return String.valueOf(this.id.getRightType().getId());
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
