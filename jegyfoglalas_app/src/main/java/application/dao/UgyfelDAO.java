package application.dao;

import application.model.Szallas;
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
public class UgyfelDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Ugyfel> listUgyfel() {
        String sql = "SELECT * FROM ugyfel";
        // Összetett lekerdezes
        // String sql = "SELECT szallas.szallas_id, szallas.varos_kod, szallas.nev, szallas.ar_per_ej FROM szallas, varos WHERE szallas.varos_kod = varos.varos_kod AND varos.nev = \"Szeged\"";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Ugyfel> result = new ArrayList<Ugyfel>();

        for (Map<String, Object> row : rows) {
            Ugyfel ugyfel = new Ugyfel();
            String ugyfel_azonosito =  row.get("ugyfel_azonosito").toString();
            String nev =  row.get("nev").toString();
            String lakcim =  row.get("lakcim").toString();
            String telefonszam =  row.get("telefonszam").toString();
            ugyfel.setUgyfel_azonosito(Integer.parseInt(ugyfel_azonosito));
            ugyfel.setNev(nev);
            ugyfel.setLakcim(lakcim);
            ugyfel.setTelefonszam(telefonszam);

            result.add(ugyfel);
        }
        return result;
    }

    public void deleteUgyfel(int ugyfel_azonosito) {
        String sql = "DELETE FROM ugyfel WHERE ugyfel_azonosito=" + ugyfel_azonosito;
        getJdbcTemplate().update(sql);
    }

}
