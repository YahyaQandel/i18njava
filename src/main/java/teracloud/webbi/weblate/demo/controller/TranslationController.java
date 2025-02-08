package teracloud.webbi.weblate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class TranslationController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greeting")
    public String getGreeting(@RequestHeader(value = "Accept-Language", defaultValue = "en") String language) {
        Locale locale = Locale.forLanguageTag(language);
        return messageSource.getMessage("greeting", null, locale);
    }

    @GetMapping("/farewell")
    public String getFarewell(@RequestHeader(value = "Accept-Language", defaultValue = "en") String language) {
        Locale locale = Locale.forLanguageTag(language);
        return messageSource.getMessage("farewell", null, locale);
    }
}