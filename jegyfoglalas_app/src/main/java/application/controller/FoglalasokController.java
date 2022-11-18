package application.controller;

import application.dao.FoglalasokDAO;
import application.model.Foglalasok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class FoglalasokController {

    @Autowired
    private FoglalasokDAO foglalasokDAO;

   // @GetMapping(value ="mukodj")
    public String listFoglalasok() {
        List<Foglalasok> foglalasokList = foglalasokDAO.listFoglalasok();
        for (int i = 0; i < foglalasokList.size(); i++) {
            System.out.println(foglalasokList.get(i).toString());
        }
        return "redirect:/";
    }
}
