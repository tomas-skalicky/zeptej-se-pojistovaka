package cz.zeptejsepojistovaka.presentation.controllers;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.domain.Page;

import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
public class WelcomePageViewModel {

    @Getter
    @Setter
    private Page<ContributionThread> threads;
}
