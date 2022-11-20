package application.controller;

import application.model.Jarat;
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
public class Osszetett_sql extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}


    /**
     * Ezzel ki lehet listázni, hogy adott varosbol melyikbe lehet eljutni
     * Ezt át lehet alakítani hotel kereső fugvénnyé, alkérdéssel
     * @return Varos lista
     */
    public List<Varos> varosbolMelyVarosba(int varos_id){
        String sql = "SELECT varos.varos_kod ,varos.nev\n" +
                "FROM jarat, varos\n" +
                "WHERE varos.varos_kod in (SELECT jarat.vegallomasvaros_kod from varos, jarat WHERE varos.varos_kod = jarat.indulovaros_kod AND varos.varos_kod =" + varos_id +" ) \n" +
                "GROUP BY varos.nev;";
        List <Map< String, Object >> rows = getJdbcTemplate().queryForList(sql);

        List < Varos > result = new ArrayList< Varos >();
        for (Map<String, Object> row : rows) {
            Varos varos = new Varos();
            String id =  row.get("varos_kod").toString();
            String nev =  row.get("nev").toString();
            varos.setVaros_kod(Integer.parseInt(id));
            varos.setNev(nev);

            result.add(varos);
        }
        return result;
    }

    /**
     * Ki tudom listázni azokat a járatokat amik egy specifikus városból indulnak. A varosbolMelyVarosba fugvénnyel lesz közöses használva.
     */
    public List<Jarat> varosbolMiIndul(int varos_kod){
        String sql = "SELECT jarat_szam, jarat_tipus, sofor_nev, ferohelyek_szama, max_sebesseg, indulas_ideje, erkezes_ideje, indulovaros_kod, vegallomasvaros_kod FROM jarat, varos \n" +
                "WHERE varos.varos_kod = jarat.indulovaros_kod\n" +
                "AND varos.varos_kod =" + varos_kod;
        List <Map< String, Object >> rows = getJdbcTemplate().queryForList(sql);

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
