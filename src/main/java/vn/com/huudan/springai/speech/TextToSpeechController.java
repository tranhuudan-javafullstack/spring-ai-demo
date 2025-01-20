package vn.com.huudan.springai.speech;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.huudan.springai.services.OpenAiService;

@Controller
public class TextToSpeechController {

    private final OpenAiService service;

    public TextToSpeechController(OpenAiService service) {
        this.service = service;
    }

    // Display the image upload form
    @GetMapping("/showTextToSpeech")
    public String showUploadForm() throws IOException {
        return "textToSpeech";
    }

    @GetMapping("/textToSpeech")
    public ResponseEntity<byte[]> streamAudio(@RequestParam String text) throws IOException {
    
            // Set headers to indicate streaming audio
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "audio/mpeg");
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=output.mp3");

            return new ResponseEntity<>(service.textToSpeech(text),headers,HttpStatus.OK);

    
    }
}