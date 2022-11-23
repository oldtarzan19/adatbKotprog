package application.dao;

import application.model.Hotel;
import application.model.Ugyfel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HotelDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Hotel> listHotel() {
        String sql = "SELECT * FROM hotel";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Hotel> result = new ArrayList<Hotel>();

        for (Map<String, Object> row : rows) {
            Hotel hotel = new Hotel();
            String szallas_id =  row.get("szallas_id").toString();
            String csillagok_szama =  row.get("csillagok_szama").toString();
            String van_e_medence =  row.get("van_e_medence").toString();
            hotel.setSzallas_id(Integer.parseInt(szallas_id));
            hotel.setCsillagok_szama(Integer.parseInt(csillagok_szama));
            hotel.setVan_e_medence(Integer.parseInt(van_e_medence));

            result.add(hotel);
        }
        return result;
    }

    public void insertHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel(szallas_id,csillagok_szama,van_e_medence) VALUES (?,?,?)";
        getJdbcTemplate().update(sql, new Object[] {
                hotel.getSzallas_id(), hotel.getCsillagok_szama(), hotel.getVan_e_medence()
        });
    }

    public void deleteHotel(int szallas_id) {
        String sql = "DELETE FROM hotel WHERE szallas_id=" + szallas_id;
        getJdbcTemplate().update(sql);
    }

    public void updateHotel(int szallas_id, int csillagok_szama, int van_e_medence) {
        String sql = "UPDATE hotel SET csillagok_szama=" + csillagok_szama + ", van_e_medence=" + van_e_medence + " WHERE szallas_id=" + szallas_id;
        getJdbcTemplate().update(sql);
    }

}
