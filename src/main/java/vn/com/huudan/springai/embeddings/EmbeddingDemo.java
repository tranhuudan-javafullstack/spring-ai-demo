package vn.com.huudan.springai.embeddings;

import vn.com.huudan.springai.services.OpenAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmbeddingDemo {

    private final OpenAiService service;

    public EmbeddingDemo(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showEmbedding")
    public String showEmbedDemo() {
        return "embedDemo";

    }

    @PostMapping("/embedding")
    public String embed(@RequestParam String text, Model model) {
        float[] resposne = service.embed(text);
        model.addAttribute("response", resposne);
        return "embedDemo";

    }


}