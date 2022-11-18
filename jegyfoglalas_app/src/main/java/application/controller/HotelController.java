package application.controller;

import application.dao.HotelDAO;
import application.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelDAO hotelDAO;

   // @GetMapping(value ="mukodj")
    public String listHotel() {
        List<Hotel> hotelList = hotelDAO.listHotel();
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println(hotelList.get(i).toString());
        }
        return "redirect:/";
    }

}
