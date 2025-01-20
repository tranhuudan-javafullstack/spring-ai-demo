package vn.com.huudan.springai.text;

import vn.com.huudan.springai.services.OpenAiService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerAnyThingStreamingController {

    private final OpenAiService service;

    public AnswerAnyThingStreamingController(OpenAiService service) {
        this.service = service;
    }
}