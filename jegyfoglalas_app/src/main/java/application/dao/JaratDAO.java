package application.dao;

import application.model.Jarat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JaratDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Jarat> listJarat() {
        String sql = "SELECT * FROM jarat";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jarat> result = new ArrayList<Jarat>();

        for (Map<String, Object> row : rows) {
            Jarat jarat = new Jarat();

            String jaratszam =  row.get("jarat_szam").toString();
            String jarat_tipus =  row.get("jarat_tipus").toString();
            String sofor_nev =  row.get("sofor_nev").toString();
            String ferohelyek_szama = row.get("ferohelyek_szama").toString();
            String max_sebesseg = row.get("max_sebesseg").toString();
            String indulas_ideje = row.get("indulas_ideje").toString();
            String erkezes_ideje = row.get("erkezes_ideje").toString();
            String indulovaros_kod = row.get("indulovaros_kod").toString();
            String vegallomasvaros_kod = row.get("vegallomasvaros_kod").toString();

            jarat.setJarat_szam(Integer.parseInt(jaratszam));
            jarat.setJarat_tipus(jarat_tipus);
            jarat.setSofor_nev(sofor_nev);
            jarat.setFerohelyek_szama(Integer.parseInt(ferohelyek_szama));
            jarat.setMax_sebesseg(Integer.parseInt(max_sebesseg));
            jarat.setIndulas_ideje(indulas_ideje);
            jarat.setErkezes_ideje(erkezes_ideje);
            jarat.setIndulovaros_kod(Integer.parseInt(indulovaros_kod));
            jarat.setVegallomasvaros_kod(Integer.parseInt(vegallomasvaros_kod));

            result.add(jarat);
        }
        return result;
    }
}
