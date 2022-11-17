package application.model;

public class Ugyfel {
    private int ugyfel_azonosito;
    private String nev;
    private String lakcim;
    private String telefonszam;

    public Ugyfel() {
    }

    public Ugyfel(int ugyfel_azonosito, String nev, String lakcim, String telefonszam) {
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.nev = nev;
        this.lakcim = lakcim;
        this.telefonszam = telefonszam;
    }

    public Ugyfel(String nev, String lakcim, String telefonszam) {
        this.nev = nev;
        this.lakcim = lakcim;
        this.telefonszam = telefonszam;
    }

    public int getUgyfel_azonosito() {
        return ugyfel_azonosito;
    }

    public void setUgyfel_azonosito(int ugyfel_azonosito) {
        this.ugyfel_azonosito = ugyfel_azonosito;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    @Override
    public String toString() {
        return "ugyfel{" +
                "ugyfel_azonosito=" + ugyfel_azonosito +
                ", nev='" + nev + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", telefonszam='" + telefonszam + '\'' +
                '}';
    }
}
