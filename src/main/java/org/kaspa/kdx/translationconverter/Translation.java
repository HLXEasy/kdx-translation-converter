package org.kaspa.kdx.translationconverter;

public class Translation {

    private String en = "";
    private String de = "";
    private String fr = "";
    private String id = "";
    private String it = "";
    private String ja = "";
    private String ko = "";
    private String pt_BR = "";
    private String zh = "";
    private String zh_HANS = "";

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getPt_BR() {
        return pt_BR;
    }

    public void setPt_BR(String pt_BR) {
        this.pt_BR = pt_BR;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh_HANS) {
        this.zh = zh_HANS;
    }

    public String getZh_HANS() {
        return zh_HANS;
    }

    public void setZh_HANS(String zh_HANS) {
        this.zh_HANS = zh_HANS;
    }

    @Override
    public String toString() {
        return "\nTranslation {" +
            "\n    en=" + en +
            "\n    de=" + de +
            "\n    fr=" + fr +
            "\n    id=" + id +
            "\n    it=" + it +
            "\n    ja=" + ja +
            "\n    ko=" + ko +
            "\n    pt_BR=" + pt_BR +
            "\n    zh=" + zh +
            "\n    zh_HANS=" + zh_HANS +
            "\n}";
    }
}
