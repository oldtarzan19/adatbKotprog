package application.controller;

import application.dao.SzallasDAO;
import application.dao.VarosDAO;
import application.model.Jarat;
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
public class Osszetett_sql extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    @Autowired
    SzallasDAO szallasDAO;


    /**
     * A szallas oldalon listázza vagy azokat a szallasokat amik hotel minősítésűek vagy csak a szallasokat.
     * @param csillagok_szama Ha hotelt keres akkor a csillagok_szama
     * @param van_e_medence Ha hotelt keres van e medence
     * @param varos_id Melyik varosban keres szallast v hotelt
     * @param mit_keres Ha Hotelt keres akkor egy, minden más esetben csak szallast fog keresni.
     * @return Szűrt szallasokbol allo lista.
     */
    public List<Szallas> hotelKereso(int csillagok_szama, int van_e_medence, int varos_id, int mit_keres){
        List <Szallas> result = new ArrayList< Szallas >();

        String sql = "SELECT *\n" +
                "FROM szallas, hotel\n" +
                "WHERE szallas.szallas_id NOT IN (SELECT hotel.szallas_id FROM hotel) AND szallas.varos_kod = "+ varos_id +"\n" +
                "GROUP BY szallas.szallas_id";
        // 1 ha hotel
        if(mit_keres == 1){
             sql = "SELECT * \n" +
                    "FROM szallas\n" +
                    "WHERE szallas.szallas_id in (SELECT hotel.szallas_id from hotel WHERE hotel.csillagok_szama= "+csillagok_szama + " AND hotel.van_e_medence = "+van_e_medence + ") AND szallas.varos_kod = "+ varos_id;
        }



        List <Map< String, Object >> rows = getJdbcTemplate().queryForList(sql);

        for (Map<String, Object> row : rows) {
            Szallas szallas = new Szallas();

            String id =  row.get("szallas_id").toString();
            String varos_kod =  row.get("varos_kod").toString();
            String nev =  row.get("nev").toString();
            String ar_per_ej =  row.get("ar_per_ej").toString();

            szallas.setSzallas_id(Integer.parseInt(id));
            szallas.setVaros_kod(Integer.parseInt(varos_kod));
            szallas.setNev(nev);
            szallas.setAr_per_ej(Integer.parseInt(ar_per_ej));


            result.add(szallas);
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

    /**
     * SQL lekérdéz segítségével megnézi hogy az adott jarat_számu járművön mely szekek foglaltak.
     * @return A foglalt székek számából álló lista.
     */
    List<Integer> foglaltHelyek(int jarat_szam){
        String sql = "SELECT helyszam\n" +
                "FROM foglalasok, jarat\n" +
                "WHERE jarat.jarat_szam = foglalasok.jaratszam AND\n" +
                "jaratszam = " + jarat_szam;
        List <Map< String, Object >> rows = getJdbcTemplate().queryForList(sql);

        List<Integer> helyszamok = new ArrayList<Integer>();

        for (Map<String, Object> row : rows) {
            String hely = row.get("helyszam").toString();
            int hely_szam = Integer.parseInt(hely);
            helyszamok.add(hely_szam);
        }
        return helyszamok;
    }


}
