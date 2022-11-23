package application.controller;

import application.dao.FoglalasokDAO;
import application.dao.JaratDAO;
import application.dao.UgyfelDAO;
import application.dao.VarosDAO;
import application.model.Jarat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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


    public String deleteJarat(int jarat_szam) {
        jaratDAO.deleteJarat(jarat_szam);
        return "admin";
    }

    public String insertJarat(int jarat_szam, String jarat_tipus, String sofor_nev, int ferohelyek_szama, int max_sebesseg, String indulas_ideje, String erkezes_ideje, int indulovaros_kod, int vegallomasvaros_kod){

        Jarat jarat = new Jarat(jarat_szam, jarat_tipus,sofor_nev,ferohelyek_szama,max_sebesseg,indulas_ideje,erkezes_ideje,indulovaros_kod,vegallomasvaros_kod);
        jaratDAO.insertJarat(jarat);

        return "admin";
    }

    public String updateJarat(int jarat_szam, String jarat_tipus, String sofor_nev, int ferohelyek_szama, int max_sebesseg, String indulas_ideje, String erkezes_ideje, int indulovaros_kod, int vegallomasvaros_kod){

        jaratDAO.updateJarat( jarat_szam,  jarat_tipus, sofor_nev, ferohelyek_szama, max_sebesseg, indulas_ideje, erkezes_ideje, indulovaros_kod, vegallomasvaros_kod);
        return "admin";
    }


    public String updateFoglalas(int ugyfel_azonosito, String foglalas_idopontja, int helyszam_regi, int helyszam_uj ){
        foglalasokDAO.updateFoglalas(ugyfel_azonosito, foglalas_idopontja, helyszam_regi, helyszam_uj);

        return "admin";
    }







    @GetMapping(value = "admin_site")
    public String getAdmin(){
        //insertJarat(1001,"Vonat","Jóska",30,100,"01:01:01","09:09:09",1,2);
       //deleteJarat(1001);
       // updateJarat(1001,"jarat","alma",100,100,"01:01:01","09:09:09",5,6);

        updateFoglalas(13,"2022-11-23 19:11:25",60,1);



        return "admin";
    }


}
