package application.controller;

import application.dao.JaratDAO;
import application.dao.VarosDAO;
import application.model.Jarat;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     * Ezzel tudom kinyerni a formbol a select által átaditt dolgokat és
     * @param model
     * @param session
     * @param request
     * @return Csak visszavisz az adott oldalra és újra betölti a varos modelbe a dolgokat.
     */

    @RequestMapping(value={"/jarat_listazas"},method = RequestMethod.POST)
    public String getInduloVaros(Model model, HttpSession session, HttpServletRequest request ) {
       String id_string = request.getParameter("varos_kod");
       int id = Integer.parseInt(id_string);

        List<Jarat> jaratList = osszetett_sql.varosbolMiIndul(id);
        for (int i = 0; i < jaratList.size(); i++) {
            jaratList.get(i).setVegallomasvaros_string(
                    varosDAO.getVarosByVarosKod(jaratList.get(i).getVegallomasvaros_kod()).getNev()
            );
        }

        model.addAttribute("mostVaros",osszetett_sql.getMostUsedCity());
        model.addAttribute("elerheto_jaratok",jaratList);
        model.addAttribute("varosok",varosDAO.listVarosok());
        return "jaratok";
    }


    @GetMapping(value = "jaratok_site")
    public String elerhetoVarosokListazasa(Model model) {
        model.addAttribute("varosok",varosDAO.listVarosok());
        model.addAttribute("mostVaros",osszetett_sql.getMostUsedCity());
        return "jaratok";
    }

}
