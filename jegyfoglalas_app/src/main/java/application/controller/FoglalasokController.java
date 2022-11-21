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
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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

    @Autowired
    private Osszetett_sql osszetett_sql;

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

        List<Foglalasok> foglalasokFromDataBase = foglalasokDAO.listFoglalasok();
        List<Foglalasok> stringFoglalasok = toStringConverter(foglalasokFromDataBase);



         model.addAttribute("foglalt_jegyek",stringFoglalasok);
         model.addAttribute("foglalas_ugyfelek",ugyfelDAO.listUgyfel());
         model.addAttribute("foglalas_jaratok",jaratList);
        return "foglalasok";
    }

    /**
     * Random ad egy helyszámot, de csak olyat ami éppen nem foglalt.
     * @param helyek_helyek_listaja Egy SQL lekérdezés által létrehozott lista. A foglalt helyeket tartalmazza.
     * @param foglalt_jarat Az a járat amire foglalunk. Ebből nyerjük ki a járat számot.
     * @return Egy helyszám ami nem foglalt.
     */
    public int helyKiosztas(List<Integer> helyek_helyek_listaja, Jarat foglalt_jarat){
        Random rand = new Random();
        if(Objects.equals(foglalt_jarat.getJarat_tipus(), "Repülő")){
            int range = 200 - 1 + 1;

           int random = rand.nextInt(range) + 1;
            while(helyek_helyek_listaja.contains(random)) {
                random = rand.nextInt(range) + 1;
            }

            return random;
        }

        if (Objects.equals(foglalt_jarat.getJarat_tipus(),"Vonat")){
            int range = 150 - 1 + 1;

            int random = rand.nextInt(range) + 1;
            while(helyek_helyek_listaja.contains(random)) {
                random = rand.nextInt(range) + 1;
            }

            return random;
        }

        if (Objects.equals(foglalt_jarat.getJarat_tipus(), "Busz")){
            int range = 23 - 1 + 1;

            int random = rand.nextInt(range) + 1;
            while(helyek_helyek_listaja.contains(random)) {
                random = rand.nextInt(range) + 1;
            }

            return random;
        }
        return 0;
    }


    /**
     * Ezzel a fugvennyel hozzaadom a foglalast az adatb-hez, bekerem a from id-it, kiosztom a helyeket a vonaton, és beküldöm a foglalást az adatbázisba.
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

        int helyszam = helyKiosztas(osszetett_sql.foglaltHelyek(foglalt_jarat.getJarat_szam()),foglalt_jarat);
        foglalasokDAO.insertFoglalas(foglalo_ugyfel,foglalt_jarat,helyszam);
        //

        List<Foglalasok> foglalasokFromDataBase = foglalasokDAO.listFoglalasok();
        List<Foglalasok> stringFoglalasok = toStringConverter(foglalasokFromDataBase);

        // TODO Fordított sorrendebn hozzáadni az elemeket a weblaphoz.

        //
        List<Jarat> jaratList = jaratDAO.listJarat();
        for (int i = 0; i < jaratList.size(); i++) {
            jaratList.get(i).setIndulovaros_string(
                    varosDAO.getVarosByVarosKod(jaratList.get(i).getIndulovaros_kod()).getNev()
            );

            jaratList.get(i).setVegallomasvaros_string(
                    varosDAO.getVarosByVarosKod(jaratList.get(i).getVegallomasvaros_kod()).getNev()
            );
        }

        model.addAttribute("foglalt_jegyek",stringFoglalasok);
        model.addAttribute("foglalas_ugyfelek",ugyfelDAO.listUgyfel());
        model.addAttribute("foglalas_jaratok",jaratList);
        return "foglalasok";


    }

    /**
     * Megcsinálja a beérkező Foglalás adatokbol a stinges formátumot.
     * @param input_list
     * @return Frissített input list.
     */
    public List<Foglalasok> toStringConverter(List<Foglalasok> input_list){
        for (int i = 0; i < input_list.size(); i++) {
            input_list.get(i).setUgyfel_nev_string(ugyfelDAO.getUgyfelByAzonosito(input_list.get(i).getUgyfel_azonosito()).getNev());
            input_list.get(i).setJaratszam_string(Integer.toString(jaratDAO.getJaratByJaratSzam(input_list.get(i).getJaratszam()).getJarat_szam()));

            input_list.get(i).setIndulovaros_string(varosDAO.getVarosByVarosKod(jaratDAO.getJaratByJaratSzam(input_list.get(i).getJaratszam()).getIndulovaros_kod()).getNev());
            input_list.get(i).setVegallomasvaros_string(varosDAO.getVarosByVarosKod(jaratDAO.getJaratByJaratSzam(input_list.get(i).getJaratszam()).getVegallomasvaros_kod()).getNev());

            input_list.get(i).setIndulas_ideje_string(jaratDAO.getJaratByJaratSzam(input_list.get(i).getJaratszam()).getIndulas_ideje());
            input_list.get(i).setErkezes_ideje_string(jaratDAO.getJaratByJaratSzam(input_list.get(i).getJaratszam()).getErkezes_ideje());
        }
        return input_list;
    }

}
