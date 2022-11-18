package application.controller;

import application.dao.SzallasDAO;
import application.model.Szallas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SzallasController {

    @Autowired
    private SzallasDAO szallasDAO;

   // @GetMapping(value ="mukodj")
    public String listSzallasok() {
        List<Szallas> szallasokList = szallasDAO.listSzallasok();
        for (int i = 0; i < szallasokList.size(); i++) {
            System.out.println(szallasokList.get(i).toString());
        }
        return "redirect:/";
    }
}
