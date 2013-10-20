package cz.zeptejsepojistovaka.commons.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile(InDevelopment.PROFILE_NAME)
public @interface InDevelopment {

    public static final String PROFILE_NAME = "DEV";
}
