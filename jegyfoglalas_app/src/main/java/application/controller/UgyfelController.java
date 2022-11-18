package application.controller;

import application.dao.UgyfelDAO;
import application.model.Szallas;
import application.model.Ugyfel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UgyfelController {
    @Autowired
    private UgyfelDAO ugyfelDAO;

   // @GetMapping(value ="mukodj")
    public String listUgyfel() {
        List<Ugyfel> ugyfelList = ugyfelDAO.listUgyfel();
        for (int i = 0; i < ugyfelList.size(); i++) {
            System.out.println(ugyfelList.get(i).toString());
        }
        return "redirect:/";
    }

}
