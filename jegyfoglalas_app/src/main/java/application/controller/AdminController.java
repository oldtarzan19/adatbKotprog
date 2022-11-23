package application.controller;

import application.dao.*;
import application.model.Hotel;
import application.model.Jarat;
import application.model.Szallas;
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

    @Autowired
    private SzallasDAO szallasDAO;

    @Autowired
    private HotelDAO hotelDAO;


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

    public String insertSzallas(int varos_kod, String nev, int ar_per_ej){
        Szallas uj_szallas = new Szallas(varos_kod,nev, ar_per_ej);
        szallasDAO.insertSzallas(uj_szallas);

        return "admin";
    }

    public String deleteSzallas(int szallas_id){
        szallasDAO.deleteSzallas(szallas_id);
        return "admin";
    }

    public String updateSzallas(int szallas_id, String nev, int ar_per_ej){
       szallasDAO.updateSzallas(szallas_id, nev, ar_per_ej);
        return "admin";

    }

    public String insertHotel(int szallas_id, int van_e_medence, int csillagok_szama){
        Hotel newHotel = new Hotel(szallas_id,csillagok_szama, van_e_medence);
        hotelDAO.insertHotel(newHotel);
        return "admin";
    }

    public String deleteHotel(int szallas_id){
        hotelDAO.deleteHotel(szallas_id);
        return "admin";
    }

    public String updateHotel(int szallas_id, int csillagok_szama_uj, int van_e_medence_uj){
        hotelDAO.updateHotel(szallas_id, csillagok_szama_uj, van_e_medence_uj);
        return "admin";
    }







    @GetMapping(value = "admin_site")
    public String getAdmin(){
        //insertJarat(1001,"Vonat","Jóska",30,100,"01:01:01","09:09:09",1,2);
       //deleteJarat(1001);
       // updateJarat(1001,"jarat","alma",100,100,"01:01:01","09:09:09",5,6);

        //updateFoglalas(13,"2022-11-23 19:11:25",60,1);

       // insertSzallas(1,"Szeged Motel", 10000);

        //updateSzallas(12, "Szegedi Motel",11000 );

       // insertHotel(12,1,5);
       // updateHotel(12,1,0);
       // deleteHotel(12);



        return "admin";
    }


}
