package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class RightKey implements Serializable {

    private static final long serialVersionUID = -2011790501836422973L;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private VerifiedUser user;

    @NotNull
    @NonNull
    @Getter
    @Setter
    private RightType rightType;
}
