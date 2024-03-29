package application.dao;

import application.model.Foglalasok;
import application.model.Hotel;
import application.model.Jarat;
import application.model.Ugyfel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class FoglalasokDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Foglalasok> listFoglalasok() {
        String sql = "SELECT * FROM foglalasok";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Foglalasok> result = new ArrayList<Foglalasok>();

        for (Map<String, Object> row : rows) {
            Foglalasok foglalasok = new Foglalasok();
            String jaratszam =  row.get("jaratszam").toString();
            String ugyfel_azonosito =  row.get("ugyfel_azonosito").toString();
            String foglalas_idopontja =  row.get("foglalas_idopontja").toString();
            foglalas_idopontja = foglalas_idopontja.substring(0, foglalas_idopontja.length() - 2);
            String helyszam = row.get("helyszam").toString();

            foglalasok.setJaratszam(Integer.parseInt(jaratszam));
            foglalasok.setUgyfel_azonosito(Integer.parseInt(ugyfel_azonosito));
            foglalasok.setFoglalas_idopontja(foglalas_idopontja);
            foglalasok.setHelyszam(Integer.parseInt(helyszam));

            result.add(foglalasok);
        }
        return result;
    }

    public void deleteFoglalas(int jaratszam,int ugyfel_azonosito, String foglalas_idopontja, int helyszam ) {
        String sql = "DELETE FROM foglalasok WHERE jaratszam= " + jaratszam + " AND ugyfel_azonosito= " + ugyfel_azonosito + " AND foglalas_idopontja= " +  foglalas_idopontja +  "AND helyszam= "+ helyszam;
        getJdbcTemplate().update(sql);
    }

    public void insertFoglalas(Ugyfel ugyfel, Jarat jarat, int helyszam) {
        String sql = "INSERT INTO foglalasok(jaratszam,ugyfel_azonosito, helyszam) VALUES (?,?,?)";
        getJdbcTemplate().update(sql, new Object[] {
                jarat.getJarat_szam(),ugyfel.getUgyfel_azonosito(),helyszam
        });
    }

    public void updateFoglalas(int ugyfel_azonoito, String foglalas_idopontja, int helyszam_regi, int helyszam_uj) {
        String sql = "UPDATE foglalasok SET foglalasok.helyszam=" + helyszam_uj + " WHERE foglalasok.ugyfel_azonosito=" + ugyfel_azonoito + " AND foglalasok.foglalas_idopontja='" + foglalas_idopontja + "' AND foglalasok.helyszam=" + helyszam_regi;
        getJdbcTemplate().update(sql);
    }

}
