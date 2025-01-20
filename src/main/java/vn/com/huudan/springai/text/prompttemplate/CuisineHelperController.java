package vn.com.huudan.springai.text.prompttemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;
import vn.com.huudan.springai.text.prompttemplate.dtos.CountryCuisines;

@Controller
public class CuisineHelperController {
    private final OpenAiService service;

    public CuisineHelperController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showCuisineHelper")
    public String showChatPage() {
         return "cuisineHelper";
    }

    @PostMapping("/cuisineHelper")
    public String getChatResponse(@RequestParam("country") String country, 
    		@RequestParam("numCuisines") String numCuisines,
    		@RequestParam("language") String language,
    		Model model) {
    	
    	CountryCuisines countryCuisines = service.getCuisines(country,numCuisines,language);
   
    	model.addAttribute("countryCuisines", countryCuisines);
        return "cuisineHelper";
    }
}
