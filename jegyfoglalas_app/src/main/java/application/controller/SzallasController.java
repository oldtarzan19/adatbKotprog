package application.controller;

import application.dao.SzallasDAO;
import application.dao.VarosDAO;
import application.model.Jarat;
import application.model.Szallas;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SzallasController {

    @Autowired
    private SzallasDAO szallasDAO;

    @Autowired
    private VarosDAO varosDAO;

    @Autowired
    private Osszetett_sql osszetett_sql;

   // @GetMapping(value ="mukodj")
    public String listSzallasok() {
        List<Szallas> szallasokList = szallasDAO.listSzallasok();
        for (int i = 0; i < szallasokList.size(); i++) {
            System.out.println(szallasokList.get(i).toString());
        }
        return "redirect:/";
    }

    @GetMapping(value = "szallasok_site")
    public String getSzallasok(Model model){
        model.addAttribute("varosok",varosDAO.listVarosok());
        return "szallasok";
    }


    /***
     * Ezzel a metoddal lehet listázni azokat a városokat amiben vannak a Szállások
     * @return Csak visszatér a főoldalra
     */
   // @GetMapping(value ="mukodj")
    public String getVarosSzallasSzerint(){
        List<Szallas> szallasokList = szallasDAO.listSzallasok();
        List<Varos> varos = new ArrayList<Varos>();
        for (int i = 0; i < szallasokList.size(); i++) {
            varos.add(varosDAO.getVarosByVarosKod(szallasokList.get(i).getVaros_kod()));
            System.out.println(varos.get(i).getNev());
        }
        return "redirect:/";
    }


    @RequestMapping(value={"/szallasok_listazasa"},method = RequestMethod.POST)
    public String getParameterSzerintiSzallasok(Model model, HttpSession session, HttpServletRequest request ) {
        String varos_kod_string = request.getParameter("varos_kod");
        String hotel_e_string = request.getParameter("hotel_e");
        String csillagok_szama_string = request.getParameter("csillagok_szama");
        String van_e_medence_string = request.getParameter("van_e_medence");

        int varos_kod = Integer.parseInt(varos_kod_string);
        int hotel_e = Integer.parseInt(hotel_e_string);
        int csillagok_szama = Integer.parseInt(csillagok_szama_string);
        int van_e_medence = Integer.parseInt(van_e_medence_string);

        List<Szallas> elerheto_szallasok = osszetett_sql.hotelKereso(csillagok_szama,van_e_medence,varos_kod,hotel_e);


        model.addAttribute("elerheto_szallasok",elerheto_szallasok);
        model.addAttribute("varosok",varosDAO.listVarosok());
        return "szallasok";
    }
}
