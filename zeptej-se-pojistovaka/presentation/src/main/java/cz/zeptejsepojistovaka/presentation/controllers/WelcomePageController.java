package cz.zeptejsepojistovaka.presentation.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.zeptejsepojistovaka.businesslogic.ContributionThreadService;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Controller
public class WelcomePageController {

    private static final String VIEW_MODEL_NAME = "welcomePagesViewModel";

    private final Logger log = Logger.getLogger(WelcomePageController.class);

    @Inject
    private ContributionThreadService threadService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(HttpServletRequest request, ModelMap model) {
        this.log.debug("in Controller");
        WelcomePageViewModel viewModel = new WelcomePageViewModel();
        viewModel.setThreads(this.threadService.findLatest());
        model.addAttribute(VIEW_MODEL_NAME, viewModel);
        return "publicHomepage";
    }

    /**
     * Populates a home URL.
     */
    @ModelAttribute("requestContextPath")
    public String populateRequestContextPath(HttpServletRequest request) {
        return request.getContextPath();
    }
}
