package application.controller;

import application.dao.JaratDAO;
import application.dao.VarosDAO;
import application.model.Jarat;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JaratController {

    @Autowired
    private JaratDAO jaratDAO;

    @Autowired
    private VarosDAO varosDAO;

    @Autowired
    private Osszetett_sql osszetett_sql;

   // @GetMapping(value ="mukodj")
    public String listJarat() {
        List<Jarat> jaratList = jaratDAO.listJarat();
        for (int i = 0; i < jaratList.size(); i++) {
            System.out.println(jaratList.get(i).toString());
        }
        return "redirect:/";
    }
    @PostMapping("/kill")
    public String getInduloVaros(@ModelAttribute("id") int id) {
       List<Varos> varos = osszetett_sql.varosbolMelyVarosba(1);
        for (int i = 0; i < varos.size(); i++) {
            System.out.println(varos.get(i).toString());
        }

        return "redirect:/";
    }

    @GetMapping(value = "jaratok_site")
    public String ugyfelekListazasa(Model model) {
        model.addAttribute("varosok",varosDAO.listVarosok());
        return "jaratok";
    }

}
