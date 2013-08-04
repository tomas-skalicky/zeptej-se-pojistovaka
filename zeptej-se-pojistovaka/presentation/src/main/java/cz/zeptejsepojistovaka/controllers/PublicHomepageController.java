package cz.zeptejsepojistovaka.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Controller
public class PublicHomepageController {

    private final Logger log = Logger
            .getLogger("cz.zeptejsepojistovaka.controllers.PublicHomepageController");

    @RequestMapping(value = "/public-homepage/", method = RequestMethod.GET)
    public String init(HttpServletRequest request, ModelMap model) {
        this.log.debug("in Controller");
        return "publicHomepage";
    }
}