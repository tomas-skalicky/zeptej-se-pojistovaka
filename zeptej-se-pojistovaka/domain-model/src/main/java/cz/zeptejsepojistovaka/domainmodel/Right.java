package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@NoArgsConstructor
@ToString
@Entity
@Table(name = Right.TABLE_NAME)
@IdClass(value = RightKey.class)
public class Right implements GrantedAuthority {

    private static final long serialVersionUID = -6965401950684956798L;

    public static final String TABLE_NAME = "rights";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String RIGHT_TYPE_ID_COLUMN_NAME = "right_type_id";

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Id
    @Column(name = USER_ID_COLUMN_NAME)
    private int userId;
    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = RIGHT_TYPE_ID_COLUMN_NAME)
    private RightType rightType;

    @Override
    public String getAuthority() {
        return String.valueOf(this.rightType.getId());
    }
}
