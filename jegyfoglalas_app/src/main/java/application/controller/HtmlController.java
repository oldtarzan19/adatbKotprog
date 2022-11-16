package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping(value = "second")
    public String get_second(){
        return "second";
    }
}
