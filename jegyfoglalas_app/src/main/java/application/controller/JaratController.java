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


    @RequestMapping(value={"/jarat_listazas"},method = RequestMethod.POST)
    public String getInduloVaros(Model model, HttpSession session, HttpServletRequest request ) {
       String id_string = request.getParameter("varos_kod");
       int id = Integer.parseInt(id_string);
        Varos varos = varosDAO.getVarosByVarosKod(id);
        System.out.println(varos.getNev());

        model.addAttribute("varosok",varosDAO.listVarosok());

        return "jaratok";
    }


    @GetMapping(value = "jaratok_site")
    public String elerhetoVarosokListazasa(Model model) {
        model.addAttribute("varosok",varosDAO.listVarosok());
        return "jaratok";
    }

}
