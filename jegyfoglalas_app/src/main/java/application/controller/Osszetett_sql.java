package application.controller;

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
}
