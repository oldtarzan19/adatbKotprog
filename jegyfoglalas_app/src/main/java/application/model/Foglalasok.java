package application.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Foglalasok {
    private int jaratszam;
    private int ugyfel_azonosito;
    private Timestamp foglalas_idopontja;
    private int helyszam;

    public Foglalasok() {
    }

    public Foglalasok(int jaratszam, int ugyfel_azonosito, Timestamp foglalas_idopontja, int helyszam) {
        this.jaratszam = jaratszam;
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.foglalas_idopontja = foglalas_idopontja;
        this.helyszam = helyszam;
    }

    public Foglalasok(int ugyfel_azonosito, Timestamp foglalas_idopontja, int helyszam) {
        this.ugyfel_azonosito = ugyfel_azonosito;
        this.foglalas_idopontja = foglalas_idopontja;
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

    public Timestamp getFoglalas_idopontja() {
        return foglalas_idopontja;
    }

    public void setFoglalas_idopontja(Timestamp foglalas_idopontja) {
        this.foglalas_idopontja = foglalas_idopontja;
    }

    public int getHelyszam() {
        return helyszam;
    }

    public void setHelyszam(int helyszam) {
        this.helyszam = helyszam;
    }

    @Override
    public String toString() {
        return "Foglalasok{" +
                "jaratszam=" + jaratszam +
                ", ugyfel_azonosito=" + ugyfel_azonosito +
                ", foglalas_idopontja=" + foglalas_idopontja +
                ", helyszam=" + helyszam +
                '}';
    }
}
