package cz.zeptejsepojistovaka.presentation.controllers.contributions;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.zeptejsepojistovaka.businesslogic.ContributionThreadService;
import cz.zeptejsepojistovaka.domainmodel.ContributionThread;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 */
@Controller
public class QuestionController {

    private final Logger log = Logger.getLogger(QuestionController.class);

    @Inject
    private ContributionThreadService threadService;

    @Transactional
    @RequestMapping(value = QuestionUrlParts.SAVE, method = RequestMethod.POST)
    public @ResponseBody
    SaveQuestionResponse saveQuestion(@RequestBody @Valid ContributionThread thread, BindingResult result) {
        this.log.debug("in Controller");
        SaveQuestionResponseBuilder responseBuilder = SaveQuestionResponseBuilder
                .newSaveQuestionResponseBuilder();

        if (result.hasErrors()) {
            return responseBuilder.failed().withFieldErrors(result.getFieldErrors())
                    .withGlobalErrors(result.getGlobalErrors()).build();
        }

        try {
            ContributionThread savedThread = this.threadService.save(thread);
            return responseBuilder.succeeded().with(savedThread).build();
        } catch (Exception e) {
            this.log.error(e);
            return responseBuilder.failed().withExceptionMessage(e.getMessage()).build();
        }
    }
        }
    }
}
