package vn.com.huudan.springai.imageprocessing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class ImageGenerationController {

	private final OpenAiService service;

    public ImageGenerationController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showImageGenerator")
	public String showImageGenerator() {
		return "imageGenerator";

	}

	@PostMapping("/imageGenerator")
	public String imageGenerator(@RequestParam String prompt, Model model) {
		String response = service.generateImage(prompt);
		model.addAttribute("response",response);
		
		return "imageGenerator";

	}

}