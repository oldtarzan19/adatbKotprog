package application.model;

public class Hotel {
    private int szallas_id;
    private String szallas_nev;
    private int csillagok_szama;
    private int van_e_medence;
    private String van_e_medence_szoveg;

    public Hotel() {
    }

    public Hotel(int szallas_id, int csillagok_szama, int van_e_medence) {
        this.szallas_id = szallas_id;
        this.csillagok_szama = csillagok_szama;
        this.van_e_medence = van_e_medence;
        this.szallas_nev ="";
        if (van_e_medence == 0){
            this.van_e_medence_szoveg = "Nincs";
        }else {
            this.van_e_medence_szoveg = "Van";
        }
    }

    public Hotel(int csillagok_szama, int van_e_medence) {
        this.csillagok_szama = csillagok_szama;
        this.van_e_medence = van_e_medence;
        this.szallas_nev ="";
        if (van_e_medence == 0){
            this.van_e_medence_szoveg = "Nincs";
        }else {
            this.van_e_medence_szoveg = "Van";
        }
    }

    public int getSzallas_id() {
        return szallas_id;
    }

    public void setSzallas_id(int szallas_id) {
        this.szallas_id = szallas_id;
    }

    public int getCsillagok_szama() {
        return csillagok_szama;
    }

    public void setCsillagok_szama(int csillagok_szama) {
        this.csillagok_szama = csillagok_szama;
    }

    public int getVan_e_medence() {
        return van_e_medence;
    }

    public void setVan_e_medence(int van_e_medence) {
        this.van_e_medence = van_e_medence;
        if (van_e_medence == 0){
            this.van_e_medence_szoveg = "Nincs";
        }else {
            this.van_e_medence_szoveg = "Van";
        }
    }

    public String getVan_e_medence_szoveg() {
        return van_e_medence_szoveg;
    }

    public String getSzallas_nev() {
        return szallas_nev;
    }

    public void setSzallas_nev(String szallas_nev) {
        this.szallas_nev = szallas_nev;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "szallas_id=" + szallas_id +
                ", szallas_nev='" + szallas_nev + '\'' +
                ", csillagok_szama=" + csillagok_szama +
                ", van_e_medence_szoveg='" + van_e_medence_szoveg + '\'' +
                '}';
    }
}
