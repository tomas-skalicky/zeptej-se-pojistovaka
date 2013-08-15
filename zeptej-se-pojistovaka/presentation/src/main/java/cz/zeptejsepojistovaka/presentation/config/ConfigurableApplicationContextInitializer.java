package cz.zeptejsepojistovaka.presentation.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import cz.zeptejsepojistovaka.commons.Profile;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class ConfigurableApplicationContextInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static final String PROFILE_PROPERTY_NAME = "profile";

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        String profileName = System.getProperty(PROFILE_PROPERTY_NAME);

        Profile profileToBeActivated = null;
        if (profileName == null) {
            profileToBeActivated = Profile.DEV;
        } else {
            profileToBeActivated = Profile.getType(profileName);
        }
        applicationContext.getEnvironment().setActiveProfiles(profileToBeActivated.getName());
    }
}
