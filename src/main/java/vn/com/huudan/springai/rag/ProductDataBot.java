package vn.com.huudan.springai.rag;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class ProductDataBot {

	private final OpenAiService service;

    public ProductDataBot(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showProductDataBot")
	public String showProductDataBot() {
		return "productDataBot";

	}

	@PostMapping("/productDataBot")
	public String productDataBot(@RequestParam String query, Model model) {
		model.addAttribute("response",service.answer(query));
		return "productDataBot";

	}

}