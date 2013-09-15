package cz.zeptejsepojistovaka.domainmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = AbstractUser.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractUser implements User {

    private static final long serialVersionUID = -2685209162891734528L;

    public static final int MIN_NAME_LENGTH = 3;
    public static final String TABLE_NAME = "users";
    public static final String ID_COLUMN_NAME = "id";

    @Min(1)
    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = ID_COLUMN_NAME)
    private Integer id;
}
