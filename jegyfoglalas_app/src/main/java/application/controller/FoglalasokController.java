package application.controller;

import application.dao.FoglalasokDAO;
import application.dao.JaratDAO;
import application.dao.UgyfelDAO;
import application.dao.VarosDAO;
import application.model.Foglalasok;
import application.model.Jarat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class FoglalasokController {

    @Autowired
    private FoglalasokDAO foglalasokDAO;

    @Autowired
    private UgyfelDAO ugyfelDAO;

    @Autowired
    private JaratDAO jaratDAO;

    @Autowired
    private VarosDAO varosDAO;

   // @GetMapping(value ="mukodj")
    public String listFoglalasok() {
        List<Foglalasok> foglalasokList = foglalasokDAO.listFoglalasok();
        for (int i = 0; i < foglalasokList.size(); i++) {
            System.out.println(foglalasokList.get(i).toString());
        }
        return "redirect:/";
    }

    /**
     * Ebben belerakom a selectbe a jaratokat űgy hogy hozzáfűzöm ID szerint a varosok nevet.
     * @param model
     * @return
     */
    @GetMapping(value = "foglalasok_site")
    public String getFoglalasok(Model model){

        List<Jarat> jaratList = jaratDAO.listJarat();
        for (int i = 0; i < jaratList.size(); i++) {
            jaratList.get(i).setIndulovaros_string(
                    varosDAO.getVarosByVarosKod(jaratList.get(i).getIndulovaros_kod()).getNev()
            );

            jaratList.get(i).setVegallomasvaros_string(
                    varosDAO.getVarosByVarosKod(jaratList.get(i).getVegallomasvaros_kod()).getNev()
            );
        }


         model.addAttribute("foglalas_ugyfelek",ugyfelDAO.listUgyfel());
         model.addAttribute("foglalas_jaratok",jaratList);
        return "foglalasok";
    }


}
