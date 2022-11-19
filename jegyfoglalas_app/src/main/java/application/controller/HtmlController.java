package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping(value = "index_site")
    public String getIndex(){
        return "redirect:/";
    }

   /* @GetMapping(value = "ugyfel_site")
    public String getNewUgyfel(){
        return "ugyfel";
    } */

    @GetMapping(value = "jaratok_site")
    public String getJaratok(){
        return "jaratok";
    }

    @GetMapping(value = "foglalasok_site")
    public String getFoglalasok(){
        return "foglalasok";
    }

    @GetMapping(value = "szallasok_site")
    public String getSzallasok(){
        return "szallasok";
    }
}
