package application.controller;

import application.dao.UgyfelDAO;
import application.model.Ugyfel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UgyfelController {
    @Autowired
    private UgyfelDAO ugyfelDAO;

   // @GetMapping(value ="mukodj")
    public String listUgyfel() {
        List<Ugyfel> ugyfelList = ugyfelDAO.listUgyfel();
        for (int i = 0; i < ugyfelList.size(); i++) {
            System.out.println(ugyfelList.get(i).toString());
        }
        return "redirect:/";
    }

    @PostMapping(value="ugyfel_hozzaadasa")
    public String ugyfelHozzaadasa(@RequestParam("nev") String nev, @RequestParam("lakcim") String lakcim, @RequestParam("telefonszam") String telefonszam){
        Ugyfel ugyfel = new Ugyfel(nev, lakcim, telefonszam);
        ugyfelDAO.insertUgyfel(ugyfel);
        return "redirect:/ugyfel_site";
    }

}
