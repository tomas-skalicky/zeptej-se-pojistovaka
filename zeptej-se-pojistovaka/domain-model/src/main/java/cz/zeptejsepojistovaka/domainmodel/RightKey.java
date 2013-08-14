package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Helper with the representation of the composite primary key of {@link Right}.
 * 
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Embeddable
public class RightKey implements Serializable {

    private static final long serialVersionUID = -2011790501836422973L;

    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String RIGHT_TYPE_ID_COLUMN_NAME = "right_type_id";

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Column(name = USER_ID_COLUMN_NAME)
    private int userId;

    @NotNull
    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Column(name = RIGHT_TYPE_ID_COLUMN_NAME)
    private RightType rightType;
}
