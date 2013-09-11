package cz.zeptejsepojistovaka.domainmodel;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cz.zeptejsepojistovaka.domainmodel.builder.RightBuilder;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
public class VerifiedUser extends AbstractUser implements ContributionAuthor, MessageAuthor, UserDetails {

    private static final long serialVersionUID = 4376233966414060002L;

    public static final String IS_MALE_COLUMN_NAME = "is_male";
    public static final String PASSWORD_HASH_COLUMN_NAME = "password_hash";

    /**
     * First name and last name
     */
    @NotBlank
    @Size(min = AbstractUser.MIN_NAME_LENGTH)
    @NonNull
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Email
    @NonNull
    @Getter
    @Setter
    private String email;

    @NonNull
    @Getter
    @Setter
    @Column(name = IS_MALE_COLUMN_NAME, columnDefinition = HibernateConstants.BIT_TYPE)
    private boolean isMale;

    @NotBlank
    @NonNull
    @Getter
    @Setter
    @Column(name = PASSWORD_HASH_COLUMN_NAME)
    private String passwordHash;

    @NonNull
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Right> rights;

    @Getter
    @Setter
    @Column(columnDefinition = HibernateConstants.BIT_TYPE)
    private boolean enabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rights;
    }

    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.email);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void addRight(RightType rightType) {
        if (this.rights == null) {
            setRights(new HashSet<Right>());
        }
        this.rights.add(RightBuilder.newRight().withUser(this).withRightType(rightType).build());
    }
}
