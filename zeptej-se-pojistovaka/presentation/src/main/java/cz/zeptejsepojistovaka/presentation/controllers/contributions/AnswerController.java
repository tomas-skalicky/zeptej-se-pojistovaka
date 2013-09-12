package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.zeptejsepojistovaka.businesslogic.AnswerService;
import cz.zeptejsepojistovaka.domainmodel.Answer;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Controller
public class AnswerController {

    private final Logger log = Logger.getLogger(AnswerController.class);

    @Inject
    private AnswerService answerService;

    @Transactional
    @RequestMapping(value = AnswerUrlParts.SAVE_NEW, method = RequestMethod.POST)
    @ResponseBody
    public SaveNewAnswerResponse saveNewAnswer(@ModelAttribute(value = "answer") Answer answer,
            BindingResult result) {
        this.log.debug("in Controller");
        SaveNewAnswerResponseBuilder responseBuilder = SaveNewAnswerResponseBuilder
                .newSaveNewAnswerResponseBuilder();

        if (result.hasErrors()) {
            return responseBuilder.failed().build();
        }

        try {
            Answer savedAnswer = this.answerService.save(answer);
            return responseBuilder.succeeded().with(savedAnswer).build();
        } catch (Exception e) {
            this.log.error(e);
            return responseBuilder.failed().build();
        }
    }
}
