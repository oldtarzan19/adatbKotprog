package application.model;


import java.sql.Date;

public class Jarat {
    private int jarat_szam;
    private String jarat_tipus;
    private String sofor_nev;
    private int ferohelyek_szama;
    private int max_sebesseg;
    private String indulas_ideje;  // EZ IT PROLLY STRING, UGYAN UGY MINDENHOL MÁSHOL IS
    private String erkezes_ideje;
    private int indulovaros_kod;
    private int vegallomasvaros_kod;

    private String vegallomasvaros_string;

    private String indulovaros_string;

    private int darab;

    public Jarat() {
    }

    public Jarat(int jarat_szam, String jarat_tipus, String sofor_nev, int ferohelyek_szama, int max_sebesseg, String indulas_ideje, String erkezes_ideje, int indulovaros_kod, int vegallomasvaros_kod) {
        this.jarat_szam = jarat_szam;
        this.jarat_tipus = jarat_tipus;
        this.sofor_nev = sofor_nev;
        this.ferohelyek_szama = ferohelyek_szama;
        this.max_sebesseg = max_sebesseg;
        this.indulas_ideje = indulas_ideje;
        this.erkezes_ideje = erkezes_ideje;
        this.indulovaros_kod = indulovaros_kod;
        this.vegallomasvaros_kod = vegallomasvaros_kod;
        this.vegallomasvaros_string ="";
        this.indulovaros_string="";
        this.darab =0;
    }

    public Jarat(String jarat_tipus, String sofor_nev, int ferohelyek_szama, int max_sebesseg, String indulas_ideje, String erkezes_ideje, int indulovaros_kod, int vegallomasvaros_kod) {
        this.jarat_tipus = jarat_tipus;
        this.sofor_nev = sofor_nev;
        this.ferohelyek_szama = ferohelyek_szama;
        this.max_sebesseg = max_sebesseg;
        this.indulas_ideje = indulas_ideje;
        this.erkezes_ideje = erkezes_ideje;
        this.indulovaros_kod = indulovaros_kod;
        this.vegallomasvaros_kod = vegallomasvaros_kod;
        this.vegallomasvaros_string ="";
        this.indulovaros_string="";
        this.darab =0;
    }

    public int getJarat_szam() {
        return jarat_szam;
    }

    public void setJarat_szam(int jarat_szam) {
        this.jarat_szam = jarat_szam;
    }

    public String getJarat_tipus() {
        return jarat_tipus;
    }

    public void setJarat_tipus(String jarat_tipus) {
        this.jarat_tipus = jarat_tipus;
    }

    public String getSofor_nev() {
        return sofor_nev;
    }

    public void setSofor_nev(String sofor_nev) {
        this.sofor_nev = sofor_nev;
    }

    public int getFerohelyek_szama() {
        return ferohelyek_szama;
    }

    public void setFerohelyek_szama(int ferohelyek_szama) {
        this.ferohelyek_szama = ferohelyek_szama;
    }

    public int getMax_sebesseg() {
        return max_sebesseg;
    }

    public void setMax_sebesseg(int max_sebesseg) {
        this.max_sebesseg = max_sebesseg;
    }

    public String getIndulas_ideje() {
        return indulas_ideje;
    }

    public void setIndulas_ideje(String indulas_ideje) {
        this.indulas_ideje = indulas_ideje;
    }

    public String getErkezes_ideje() {
        return erkezes_ideje;
    }

    public void setErkezes_ideje(String erkezes_ideje) {
        this.erkezes_ideje = erkezes_ideje;
    }

    public int getIndulovaros_kod() {
        return indulovaros_kod;
    }

    public void setIndulovaros_kod(int indulovaros_kod) {
        this.indulovaros_kod = indulovaros_kod;
    }

    public int getVegallomasvaros_kod() {
        return vegallomasvaros_kod;
    }

    public void setVegallomasvaros_kod(int vegallomasvaros_kod) {
        this.vegallomasvaros_kod = vegallomasvaros_kod;
    }

    public String getVegallomasvaros_string() {
        return vegallomasvaros_string;
    }

    public void setVegallomasvaros_string(String vegallomasvaros_string) {
        this.vegallomasvaros_string = vegallomasvaros_string;
    }

    public String getIndulovaros_string() {
        return indulovaros_string;
    }

    public void setIndulovaros_string(String indulovaros_string) {
        this.indulovaros_string = indulovaros_string;
    }

    @Override
    public String toString() {
        return "Jarat{" +
                "jarat_szam=" + jarat_szam +
                ", jarat_tipus='" + jarat_tipus + '\'' +
                ", sofor_nev='" + sofor_nev + '\'' +
                ", ferohelyek_szama=" + ferohelyek_szama +
                ", max_sebesseg=" + max_sebesseg +
                ", indulas_ideje='" + indulas_ideje + '\'' +
                ", erkezes_ideje='" + erkezes_ideje + '\'' +
                ", indulovaros_kod=" + indulovaros_kod +
                ", vegallomasvaros_kod=" + vegallomasvaros_kod +
                ", vegallomasvaros_string='" + vegallomasvaros_string + '\'' +
                ", indulovaros_string='" + indulovaros_string + '\'' +
                '}';
    }
}
