package application.controller;

import application.dao.JaratDAO;
import application.model.Jarat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class JaratController {

    @Autowired
    private JaratDAO jaratDAO;

    @GetMapping(value ="mukodj")
    public String listJarat() {
        List<Jarat> jaratList = jaratDAO.listJarat();
        for (int i = 0; i < jaratList.size(); i++) {
            System.out.println(jaratList.get(i).toString());
        }
        return "redirect:/";
    }
}
