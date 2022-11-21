package application.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Foglalasok {
    private int jaratszam;
    private int ugyfel_azonosito;
    private String foglalas_idopontja;
    private int helyszam;

    private String ugyfel_nev_string;
    private String jaratszam_string;
    private String indulovaros_string;
    private String vegallomasvaros_string;
    private String indulas_ideje_string;
    private String erkezes_ideje_string;

    public Foglalasok() {
    }

    public Foglalasok(int jaratszam, int ugyfel_azonosito, String foglalas_idopontja, int helyszam) {
        this.jaratszam = jaratszam;
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.foglalas_idopontja = foglalas_idopontja;
        this.helyszam = helyszam;

        this.ugyfel_nev_string ="";
        this.jaratszam_string ="";
        this.indulovaros_string ="";
        this.vegallomasvaros_string ="";
        this.indulas_ideje_string ="";
        this.erkezes_ideje_string ="";
    }

    public Foglalasok(int ugyfel_azonosito, String foglalas_idopontja, int helyszam) {
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.foglalas_idopontja = foglalas_idopontja;
        this.helyszam = helyszam;

        this.ugyfel_nev_string ="";
        this.jaratszam_string ="";
        this.indulovaros_string ="";
        this.vegallomasvaros_string ="";
        this.indulas_ideje_string ="";
        this.erkezes_ideje_string ="";
    }


    /**
     * Azért kell ez a constructor, mert mikor feltoltunk az adatb-be az automatikus menti a datumot. Nekunk nem
     * kell azzal foglalkozni.
     * @param jaratszam
     * @param ugyfel_azonosito
     * @param helyszam
     */
    public Foglalasok(int jaratszam, int ugyfel_azonosito, int helyszam) {
        this.jaratszam = jaratszam;
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.helyszam = helyszam;
    }

    public int getJaratszam() {
        return jaratszam;
    }

    public void setJaratszam(int jaratszam) {
        this.jaratszam = jaratszam;
    }

    public int getUgyfel_azonosito() {
        return ugyfel_azonosito;
    }

    public void setUgyfel_azonosito(int ugyfel_azonosito) {
        this.ugyfel_azonosito = ugyfel_azonosito;
    }

    public String getFoglalas_idopontja() {
        return foglalas_idopontja;
    }

    public void setFoglalas_idopontja(String foglalas_idopontja) {
        this.foglalas_idopontja = foglalas_idopontja;
    }

    public int getHelyszam() {
        return helyszam;
    }

    public void setHelyszam(int helyszam) {
        this.helyszam = helyszam;
    }


    public String getUgyfel_nev_string() {
        return ugyfel_nev_string;
    }

    public void setUgyfel_nev_string(String ugyfel_nev_string) {
        this.ugyfel_nev_string = ugyfel_nev_string;
    }

    public String getJaratszam_string() {
        return jaratszam_string;
    }

    public void setJaratszam_string(String jaratszam_string) {
        this.jaratszam_string = jaratszam_string;
    }

    public String getIndulovaros_string() {
        return indulovaros_string;
    }

    public void setIndulovaros_string(String indulovaros_string) {
        this.indulovaros_string = indulovaros_string;
    }

    public String getVegallomasvaros_string() {
        return vegallomasvaros_string;
    }

    public void setVegallomasvaros_string(String vegallomasvaros_string) {
        this.vegallomasvaros_string = vegallomasvaros_string;
    }

    public String getIndulas_ideje_string() {
        return indulas_ideje_string;
    }

    public void setIndulas_ideje_string(String indulas_ideje_string) {
        this.indulas_ideje_string = indulas_ideje_string;
    }

    public String getErkezes_ideje_string() {
        return erkezes_ideje_string;
    }

    public void setErkezes_ideje_string(String erkezes_ideje_string) {
        this.erkezes_ideje_string = erkezes_ideje_string;
    }

    @Override
    public String toString() {
        return "Foglalasok{" +
                "jaratszam=" + jaratszam +
                ", ugyfel_azonosito=" + ugyfel_azonosito +
                ", foglalas_idopontja='" + foglalas_idopontja + '\'' +
                ", helyszam=" + helyszam +
                ", ugyfel_nev_string='" + ugyfel_nev_string + '\'' +
                ", jaratszam_string='" + jaratszam_string + '\'' +
                ", indulovaros_string='" + indulovaros_string + '\'' +
                ", vegallomasvaros_string='" + vegallomasvaros_string + '\'' +
                ", indulas_ideje_string='" + indulas_ideje_string + '\'' +
                ", erkezes_ideje_string='" + erkezes_ideje_string + '\'' +
                '}';
    }
}
