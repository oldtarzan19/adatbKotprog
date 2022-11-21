package application.controller;

import application.dao.FoglalasokDAO;
import application.dao.JaratDAO;
import application.dao.UgyfelDAO;
import application.dao.VarosDAO;
import application.model.Foglalasok;
import application.model.Jarat;
import application.model.Ugyfel;
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

    /**
     * Ezzel a fugvennyel hozzaadom a foglalast az adatb-hez, bekerem a from id-it.
     * @param model
     * @param session
     * @param request
     * @return Visszatér az eredeti oldalra és újra betolti a HTML modellbe az adatokat.
     */
    @RequestMapping(value={"/foglalas_hozzaadasa"},method = RequestMethod.POST)
    public String foglalasHozzaadasa(Model model, HttpSession session, HttpServletRequest request ) {

        String foglalo_ugyfel_id = request.getParameter("foglalo_ugyfel");
        String foglalo_jarat_id = request.getParameter("foglalo_jarat");

        int ugyfel_id = Integer.parseInt(foglalo_ugyfel_id);
        int jarat_id = Integer.parseInt(foglalo_jarat_id);

        Ugyfel foglalo_ugyfel = ugyfelDAO.getUgyfelByAzonosito(ugyfel_id);
        Jarat foglalt_jarat = jaratDAO.getJaratByJaratSzam(jarat_id);


        System.out.println(""+foglalo_ugyfel.getNev()+" "+foglalt_jarat.getJarat_szam());




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
