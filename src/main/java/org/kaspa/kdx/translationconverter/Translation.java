package org.kaspa.kdx.translationconverter;

public class Translation {

    private String en = "";
    private String cmn = "";
    private String de = "";
    private String fr = "";
    private String id = "";
    private String it = "";
    private String ja = "";
    private String ko = "";
    private String zh = "";

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

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh_HANS) {
        this.zh = zh_HANS;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nTranslation {" +
            "\n    en=" + en +
            "\n    cmn=" + cmn +
            "\n    de=" + de +
            "\n    fr=" + fr +
            "\n    id=" + id +
            "\n    it=" + it +
            "\n    ja=" + ja +
            "\n    ko=" + ko +
            "\n    zh=" + zh +
            "\n}";
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public void setCmn(String cmn) {
        this.cmn = cmn;
    }

    public String getFr() {
        return fr;
    }

    public String getCmn() {
        return cmn;
    }
}
