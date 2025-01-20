package vn.com.huudan.springai.functioncalling;

import vn.com.huudan.springai.services.OpenAiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FCController {

    private final OpenAiService service;

    public FCController(OpenAiService service) {
        this.service = service;
    }

    @GetMapping("/showFunctionCalling")
    public String showChatPage() {
        return "functionCalling";
    }

    @PostMapping("/functionCalling")
    public String getChatResponse(@RequestParam("company") String company, Model model) {

        String response = service.getStockPrice(company);
        model.addAttribute("response", response);
        return "functionCalling";
    }

}
