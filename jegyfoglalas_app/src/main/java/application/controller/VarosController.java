package application.controller;

import application.dao.VarosDAO;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VarosController {

    @Autowired
    private VarosDAO varosDAO;

    @GetMapping(value="mukodj")
    public String listArucikk() {
        List<Varos> varosok_listaja = varosDAO.listVarosok();
        for (int i = 0; i < varosok_listaja.size(); i++) {
            System.out.println(varosok_listaja.get(i).getNev());
        }
        return "redirect:/";
    }
}
