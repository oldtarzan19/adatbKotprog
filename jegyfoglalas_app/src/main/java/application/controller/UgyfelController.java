package application.controller;

import application.dao.UgyfelDAO;
import application.model.Ugyfel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

   /* @GetMapping("/ugyfel_site")
    public void ugyfelekListazasa(Model model) {
        model.addAttribute("ugyfelek",ugyfelDAO.listUgyfel());
    } */

    @GetMapping(value = "ugyfel_site")
    public String ugyfelekListazasa(Model model) {
        model.addAttribute("ugyfelek",ugyfelDAO.listUgyfel());
        return "ugyfel";
    }

    @RequestMapping("/ugyfel_site/{ugyfel_azonosito}")
    public String deleteUgyfel(@PathVariable("ugyfel_azonosito") int id) {
        ugyfelDAO.deleteUgyfel(id);

        return "redirect:/ugyfel_site";
    }
}
