package vn.com.huudan.springai.moderations;

import org.springframework.ai.moderation.ModerationResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class ModerationController {

    private final OpenAiService service;

    public ModerationController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showModeration")
    public String showModeration() {
         return "moderation";
    }

    @PostMapping("/moderation")
    public String moderation(@RequestParam("text") String text, Model model) {
    	ModerationResult moderationResult = service.moderate(text);
    	model.addAttribute("response",moderationResult);
        return "moderation";
    }
}