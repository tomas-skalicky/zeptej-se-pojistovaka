package cz.zeptejsepojistovaka.domainmodel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Entity
@Table(name = Message.TABLE_NAME)
@EqualsAndHashCode
public class Message implements Serializable {

    private static final long serialVersionUID = -5594858420775292615L;

    public static final int MIN_TEXT_LENGTH = 10;
    public static final String TABLE_NAME = "messages";
    public static final String AUTHOR_COLUMN_NAME = "author_id";

    @Min(1)
    @NonNull
    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private MessageType type;

    @NotNull
    @NonNull
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AbstractUser.class)
    @JoinColumn(name = AUTHOR_COLUMN_NAME, referencedColumnName = AbstractUser.ID_COLUMN_NAME)
    private MessageAuthor author;

    @NotBlank
    @Size(min = MIN_TEXT_LENGTH)
    @NonNull
    @Getter
    @Setter
    @Type(type = HibernateConstants.TEXT_TYPE)
    private String text;
}
