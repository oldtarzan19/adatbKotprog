package application.dao;

import application.model.Ugyfel;
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
public class VarosDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {setDataSource(dataSource);}

    public List<Varos> listVarosok() {
        String sql = "SELECT * FROM varos";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Varos> result = new ArrayList<Varos>();

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

    public Varos getVarosByVarosKod(int varos_kod) {
        String sql = "SELECT * FROM varos WHERE varos_kod=" + varos_kod;
        List < Map < String, Object >> rows = getJdbcTemplate().queryForList(sql);

        List < Varos > result = new ArrayList < Varos > ();
        for (Map<String, Object> row : rows) {
            Varos varos = new Varos();
            String id =  row.get("varos_kod").toString();
            String nev =  row.get("nev").toString();
            varos.setVaros_kod(Integer.parseInt(id));
            varos.setNev(nev);

            result.add(varos);
        }

        return result.get(0);
    }

    public void insertVaros(Varos varos) {
        String sql = "INSERT INTO varos(nev) VALUES (?)";
        getJdbcTemplate().update(sql, new Object[] {
                varos.getNev()
        });
    }

    public void deleteVaros(int varos_kod) {
        String sql = "DELETE FROM varos WHERE varos_kod=" + varos_kod;
        getJdbcTemplate().update(sql);
    }

    public void updateVaros(int varos_kod, String nev) {
        String sql = "UPDATE varos SET nev='" + nev + "' WHERE varos_kod=" + varos_kod;
        getJdbcTemplate().update(sql);
    }
}
