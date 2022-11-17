package application.model;

public class Szallas {
    private int szallas_id;
    private int varos_kod;
    private String nev;
    private int ar_per_ej;

    public Szallas() {
    }

    public Szallas(int szallas_id, int varos_kod, String nev, int ar_per_ej) {
        this.szallas_id = szallas_id;
        this.varos_kod = varos_kod;
        this.nev = nev;
        this.ar_per_ej = ar_per_ej;
    }

    public Szallas(int varos_kod, String nev, int ar_per_ej) {
        this.varos_kod = varos_kod;
        this.nev = nev;
        this.ar_per_ej = ar_per_ej;
    }

    public int getSzallas_id() {
        return szallas_id;
    }

    public void setSzallas_id(int szallas_id) {
        this.szallas_id = szallas_id;
    }

    public int getVaros_kod() {
        return varos_kod;
    }

    public void setVaros_kod(int varos_kod) {
        this.varos_kod = varos_kod;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr_per_ej() {
        return ar_per_ej;
    }

    public void setAr_per_ej(int ar_per_ej) {
        this.ar_per_ej = ar_per_ej;
    }

    @Override
    public String toString() {
        return "Szallas{" +
                "szallas_id=" + szallas_id +
                ", varos_kod=" + varos_kod +
                ", nev='" + nev + '\'' +
                ", ar_per_ej=" + ar_per_ej +
                '}';
    }
}
