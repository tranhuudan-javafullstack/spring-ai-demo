package vn.com.huudan.springai.ollama;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AnswerAnyThingController {

    private final OllamaService service;

    public AnswerAnyThingController(OllamaService service) {
        this.service = service;
    }

    @GetMapping("/showAskAnything")
    public String showAskAnything() {
        return "askAnything";
    }

    @PostMapping("/askAnything")
    public String askAnything(@RequestParam("question") String question, Model model) {
        ChatResponse response = service.generateAnswer(question);
        System.out.println(response);
        model.addAttribute("question", question);
        model.addAttribute("answer", response.getResult().getOutput().getContent());
        return "askAnythingOllama";
    }
}