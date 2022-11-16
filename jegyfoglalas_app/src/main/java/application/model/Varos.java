package application.model;

public class Varos {
    private int varos_kod;
    private String nev;

    public Varos() {
    }

    public Varos(int varos_kod, String nev) {
        this.varos_kod = varos_kod;
        this.nev = nev;
    }

    public Varos(String nev) {
        this.nev = nev;
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
}
