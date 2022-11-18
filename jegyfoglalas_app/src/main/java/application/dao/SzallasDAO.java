package application.dao;

import application.model.Szallas;
import application.model.Varos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SzallasDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Szallas> listSzallasok() {
        String sql = "SELECT szallas_id, varos_kod, nev, ar_per_ej FROM szallas";
            // Összetett lekerdezes
       // String sql = "SELECT szallas.szallas_id, szallas.varos_kod, szallas.nev, szallas.ar_per_ej FROM szallas, varos WHERE szallas.varos_kod = varos.varos_kod AND varos.nev = \"Szeged\"";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Szallas> result = new ArrayList<Szallas>();

        for (Map<String, Object> row : rows) {
            Szallas szallas = new Szallas();
            String szallas_id =  row.get("szallas_id").toString();
            String varos_kod =  row.get("varos_kod").toString();
            String nev =  row.get("nev").toString();
            String ar_per_ej =  row.get("ar_per_ej").toString();
            szallas.setSzallas_id(Integer.parseInt(szallas_id));
            szallas.setVaros_kod(Integer.parseInt(varos_kod));
            szallas.setNev(nev);
            szallas.setAr_per_ej(Integer.parseInt(ar_per_ej));

            result.add(szallas);
        }
        return result;
    }




}
