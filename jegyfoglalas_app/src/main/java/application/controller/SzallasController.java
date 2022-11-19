package application.controller;

import application.dao.SzallasDAO;
import application.dao.VarosDAO;
import application.model.Szallas;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SzallasController {

    @Autowired
    private SzallasDAO szallasDAO;

    @Autowired
    private VarosDAO varosDAO;

   // @GetMapping(value ="mukodj")
    public String listSzallasok() {
        List<Szallas> szallasokList = szallasDAO.listSzallasok();
        for (int i = 0; i < szallasokList.size(); i++) {
            System.out.println(szallasokList.get(i).toString());
        }
        return "redirect:/";
    }

    /***
     * Ezzel a metoddal lehet listázni azokat a városokat amiben vannak a Szállások
     * @return Csak visszatér a főoldalra
     */
    @GetMapping(value ="mukodj")
    public String getVarosSzallasSzerint(){
        List<Szallas> szallasokList = szallasDAO.listSzallasok();
        List<Varos> varos = new ArrayList<Varos>();
        for (int i = 0; i < szallasokList.size(); i++) {
            varos.add(varosDAO.getVarosByVarosKod(szallasokList.get(i).getVaros_kod()));
            System.out.println(varos.get(i).getNev());
        }
        return "redirect:/";
    }
}
