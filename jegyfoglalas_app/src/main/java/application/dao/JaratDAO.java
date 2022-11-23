package application.dao;

import application.model.Jarat;
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
public class JaratDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Jarat> listJarat() {
        String sql = "SELECT * FROM jarat";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jarat> result = new ArrayList<Jarat>();

        for (Map<String, Object> row : rows) {
            Jarat jarat = new Jarat();

            String jaratszam = row.get("jarat_szam").toString();
            String jarat_tipus = row.get("jarat_tipus").toString();
            String sofor_nev = row.get("sofor_nev").toString();
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

    public void deleteJarat(int jarat_szam) {
        String sql = "DELETE FROM jarat WHERE jarat_szam=" + jarat_szam;
        getJdbcTemplate().update(sql);
    }

    public Jarat getJaratByJaratSzam(int jarat_szam) {
        String sql = "SELECT * FROM jarat WHERE jarat_szam=" + jarat_szam;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Jarat> result = new ArrayList<Jarat>();
        for (Map<String, Object> row : rows) {
            Jarat jarat = new Jarat();

            String jaratszam = row.get("jarat_szam").toString();
            String jarat_tipus = row.get("jarat_tipus").toString();
            String sofor_nev = row.get("sofor_nev").toString();
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
        return result.get(0);
    }

    public void insertJarat(Jarat jarat) {
        String sql = "INSERT INTO jarat(jarat_szam,jarat_tipus,sofor_nev,ferohelyek_szama,max_sebesseg,indulas_ideje, erkezes_ideje, indulovaros_kod,vegallomasvaros_kod) VALUES (?,?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
                jarat.getJarat_szam(), jarat.getJarat_tipus(), jarat.getSofor_nev(), jarat.getFerohelyek_szama(), jarat.getMax_sebesseg(), jarat.getIndulas_ideje(), jarat.getErkezes_ideje(), jarat.getIndulovaros_kod(), jarat.getVegallomasvaros_kod()
        });
    }

    public void updateJarat(int jarat_szam, String jarat_tipus, String sofor_nev, int ferohelyek_szama, int max_sebesseg, String indulas_ideje, String erkezes_ideje, int indulovaros_kod, int vegallomasvaros_kod) {
        indulas_ideje = "'" + indulas_ideje + "'";
        erkezes_ideje = "'" + erkezes_ideje+"'";
        jarat_tipus = "'" + jarat_tipus + "'";
        sofor_nev = "'" + sofor_nev + "'";

        String sql = "UPDATE jarat SET jarat_tipus= " + jarat_tipus + ", sofor_nev= " + sofor_nev + ", ferohelyek_szama= " + ferohelyek_szama + ", max_sebesseg= " + max_sebesseg + ", indulas_ideje= " + indulas_ideje + ", erkezes_ideje= " + erkezes_ideje + ", indulovaros_kod= " + indulovaros_kod + ",vegallomasvaros_kod= " + vegallomasvaros_kod + " WHERE jarat_szam= " + jarat_szam;
        getJdbcTemplate().update(sql);
    }

}
