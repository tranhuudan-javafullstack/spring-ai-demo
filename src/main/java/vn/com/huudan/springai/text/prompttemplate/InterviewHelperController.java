package vn.com.huudan.springai.text.prompttemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class InterviewHelperController {
	private final OpenAiService service;

    public InterviewHelperController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showInterviewHelper")
	public String showInterviewHelper() {
		return "interviewHelper";
	}

	@PostMapping("/interviewHelper")
	public String interviewHelper(@RequestParam("company") String company,
			@RequestParam("jobTitle") String jobTitle,
			@RequestParam("strength") String strength, 
			@RequestParam("weakness") String weakness, Model model) {
		return "interviewHelper";
	}

}
