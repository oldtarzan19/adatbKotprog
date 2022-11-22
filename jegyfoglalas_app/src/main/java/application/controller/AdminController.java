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

    // TODO jarat UPDATE method






    @GetMapping(value = "admin_site")
    public String getAdmin(){
       // insertJarat(1001,"Vonat","Jóska",30,100,"01:01:01","09:09:09",1,2);
       // deleteJarat(1001);



        return "admin";
    }


}