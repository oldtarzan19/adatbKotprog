package application.controller;

import application.dao.*;
import application.model.Hotel;
import application.model.Jarat;
import application.model.Szallas;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
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

    @Autowired
    private JaratController jaratController;

    @Autowired
    private SzallasDAO szallasDAO;

    @Autowired
    private HotelDAO hotelDAO;

    @RequestMapping(value={"/jarat_torles"},method = RequestMethod.POST)
    public String deleteJarat(Model model, HttpSession session, HttpServletRequest request ) {
        String id_string = request.getParameter("torlendo_jarat");
        int jarat_szam = Integer.parseInt(id_string);
        jaratDAO.deleteJarat(jarat_szam);

        getModels(model);
        return "admin";
    }
    @PostMapping(value="jarat_hozzaadasa")
    public String insertJarat(@RequestParam("jarat_szam") int jarat_szam,@RequestParam("jarat_tipus") String jarat_tipus,@RequestParam("sofor_nev") String sofor_nev,  @RequestParam("ferohelyek_szama") int ferohelyek_szama,@RequestParam("max_sebbeseg") int max_sebesseg,@RequestParam("indulas_ideje") String indulas_ideje,@RequestParam("erkezes_ideje") String erkezes_ideje,@RequestParam("indulo_varos_kod") int indulovaros_kod,@RequestParam("erkezo_varos_kod") int vegallomasvaros_kod, Model model){

        Jarat jarat = new Jarat(jarat_szam, jarat_tipus,sofor_nev,ferohelyek_szama,max_sebesseg,indulas_ideje,erkezes_ideje,indulovaros_kod,vegallomasvaros_kod);
        jaratDAO.insertJarat(jarat);

        getModels(model);
        return "admin";
    }
    @PostMapping(value="jarat_szerkesztese")
    public String updateJarat(@RequestParam("jarat_szam") int jarat_szam ,@RequestParam("jarat_tipus") String jarat_tipus,@RequestParam("sofor_nev") String sofor_nev,  @RequestParam("ferohelyek_szama") int ferohelyek_szama,@RequestParam("max_sebbeseg") int max_sebesseg,@RequestParam("indulas_ideje") String indulas_ideje,@RequestParam("erkezes_ideje") String erkezes_ideje,@RequestParam("indulo_varos_kod") int indulovaros_kod,@RequestParam("erkezo_varos_kod") int vegallomasvaros_kod, Model model ){

        jaratDAO.updateJarat( jarat_szam,  jarat_tipus, sofor_nev, ferohelyek_szama, max_sebesseg, indulas_ideje, erkezes_ideje, indulovaros_kod, vegallomasvaros_kod);

        getModels(model);
        return "admin";
    }

    @PostMapping(value="foglalas_update")
    public String updateFoglalas(@RequestParam("ugyfel_azonosito") int ugyfel_azonosito,@RequestParam("foglalas_idopontja") String foglalas_idopontja,@RequestParam("helyszam_regi") int helyszam_regi,@RequestParam("helyszam_uj") int helyszam_uj, Model model ){
        foglalasokDAO.updateFoglalas(ugyfel_azonosito, foglalas_idopontja, helyszam_regi, helyszam_uj);

        getModels(model);
        return "admin";
    }
    @PostMapping(value="szallas_hozzaadasa")
    public String insertSzallas(@RequestParam("varos_kod") int varos_kod,@RequestParam("nev") String nev,@RequestParam("ar_per_ej") int ar_per_ej, Model model){
        Szallas uj_szallas = new Szallas(varos_kod,nev, ar_per_ej);
        szallasDAO.insertSzallas(uj_szallas);

        getModels(model);
        return "admin";
    }
    @PostMapping(value="szallas_torlese")
    public String deleteSzallas(@RequestParam("szallas_id") int szallas_id, Model model) {
        szallasDAO.deleteSzallas(szallas_id);

        getModels(model);
        return "admin";
    }
    @PostMapping(value="szallas_update")
    public String updateSzallas(@RequestParam("szallas_id") int szallas_id,@RequestParam("nev") String nev,@RequestParam("ar_per_ej") int ar_per_ej, Model model){
       szallasDAO.updateSzallas(szallas_id, nev, ar_per_ej);

        getModels(model);
        return "admin";

    }

    //Ez akkor megvalósul már mikor betolt az admin site
    public String listHotel(Model model){
        getModels(model);
        return "admin";
    }
    @PostMapping(value="hotel_hozzaadasa")
    public String insertHotel(@RequestParam("szallas_id") int szallas_id,@RequestParam("van_e_medence") int van_e_medence,@RequestParam("csillagok_szama") int csillagok_szama,Model model){
        Hotel newHotel = new Hotel(szallas_id,csillagok_szama, van_e_medence);
        hotelDAO.insertHotel(newHotel);
        getModels(model);
        return "admin";
    }
    @PostMapping(value="hotel_torlese")
    public String deleteHotel(int szallas_id,Model model){
        hotelDAO.deleteHotel(szallas_id);
        getModels(model);
        return "admin";
    }
    @PostMapping(value="hotel_update")
    public String updateHotel(@RequestParam("szallas_id") int szallas_id,@RequestParam("csillagok_szama") int csillagok_szama_uj,@RequestParam("van_e_medence") int van_e_medence_uj,Model model){
        hotelDAO.updateHotel(szallas_id, csillagok_szama_uj, van_e_medence_uj);
        getModels(model);
        return "admin";
    }
    @PostMapping(value="varos_insert")
    public String insertVaros(@RequestParam("nev") String nev,Model model){
        Varos newVaros = new Varos(nev);
        varosDAO.insertVaros(newVaros);

        getModels(model);
        return "admin";
    }
    @PostMapping(value = "varos_update")
    public String updateVaros(@RequestParam("varos_kod") int varos_kod,@RequestParam("uj_nev") String nev,Model model){
        varosDAO.updateVaros(varos_kod,nev);
        getModels(model);
        return "admin";
    }
    @PostMapping(value="varos_delete")
    public String deleteVaros(@RequestParam("varos_kod") int varos_kod,Model model){
        varosDAO.deleteVaros(varos_kod);
        getModels(model);
        return "admin";
    }


    public void getModels(Model model){
        List<Hotel> hotelList = hotelDAO.listHotel();
        for (int i = 0; i < hotelList.size(); i++) {
            hotelList.get(i).setSzallas_nev(szallasDAO.getSzallasBySzallasId(hotelList.get(i).getSzallas_id()).getNev());
        }

        model.addAttribute("apartmanok",osszetett_sql.hotelKereso(1,0,999,0));
        model.addAttribute("hotelek",hotelList);
        model.addAttribute("szallasok", szallasDAO.listSzallasok());
        model.addAttribute("ugyfelek", ugyfelDAO.listUgyfel());
        model.addAttribute("varosok", varosDAO.listVarosok());
        model.addAttribute("jaratok",jaratDAO.listJarat());
    }


    @GetMapping(value = "admin_site")
    public String getAdmin(Model model){
        getModels(model);
        return "admin";
    }


}
