package vn.com.huudan.springai.text.prompttemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class TravelGuideController {
	private final OpenAiService service;

    public TravelGuideController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showTravelGuide")
	public String showChatPage() {
		return "travelGuide";
	}

	@PostMapping("/travelGuide")
	public String getChatResponse(@RequestParam("city") String city, @RequestParam("month") String month,
			@RequestParam("language") String language, @RequestParam("budget") String budget, Model model) {

		String response = service.getTravelGuidance(city,month,language,budget);
		model.addAttribute("city",city);
		model.addAttribute("response",response);
		return "travelGuide";
	}

}
