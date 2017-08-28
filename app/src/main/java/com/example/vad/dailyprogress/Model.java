package com.example.vad.dailyprogress;

/**
 * Created by VAD on 10/08/2017.
 */
public class Model {
    String editMitra;
    String editSite;
    String spSite;
    String spTower;
    String spTinggi;
    String spPondasi;
    String tgl;

    public Model() {

    }

    public Model(String editMitra, String editSite, String spSite, String spTinggi, String spTower, String spPondasi, String tgl) {
        this.editMitra = editMitra;
        this.editSite = editSite;
        this.spPondasi = spPondasi;
        this.spSite = spSite;
        this.spTinggi = spTinggi;
        this.spTower = spTower;
        this.tgl = tgl;


    }

    public String getEditMitra() {
        return editMitra;
    }

    public String getEditSite() {
        return editSite;
    }

    public String getSpSite() {
        return spSite;
    }

    public String getSpPondasi() {
        return spPondasi;
    }

    public String getSpTinggi() {
        return spTinggi;
    }

    public String getSpTower() {
        return spTower;
    }

    public String getTgl() {
        return tgl;
    }

    public class tahap {
        public String tv1;

        public tahap(String tv1) {
            this.tv1 = tv1;
        }
    }

}
