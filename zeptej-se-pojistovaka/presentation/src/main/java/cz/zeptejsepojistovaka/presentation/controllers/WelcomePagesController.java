package cz.zeptejsepojistovaka.presentation.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Controller
public class WelcomePagesController {

    private final Logger log = Logger.getLogger(WelcomePagesController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(HttpServletRequest request, ModelMap model) {
        this.log.debug("in Controller");
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