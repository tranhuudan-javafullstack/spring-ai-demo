package vn.com.huudan.springai.embeddings;

import vn.com.huudan.springai.services.OpenAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimilarityFinder {

    private final OpenAiService service;

    public SimilarityFinder(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showSimilarityFinder")
    public String showSimilarityFinder() {
        return "similarityFinder";

    }

    @PostMapping("/similarityFinder")
    public String findSimilarity(@RequestParam String text1, @RequestParam String text2, Model model) {
        double response = service.findSimilarity(text1, text2);
        model.addAttribute("response", response);
        return "similarityFinder";

    }


}