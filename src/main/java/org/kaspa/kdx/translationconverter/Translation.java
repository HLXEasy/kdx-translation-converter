package org.kaspa.kdx.translationconverter;

public class Translation {

    private String en = "";
    private String de = "";
    private String ja = "";
    private String zh_HANS = "";
    private String ko = "";
    private String it = "";
    private String id = "";

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

    public String getZh_HANS() {
        return zh_HANS;
    }

    public void setZh_HANS(String zh_HANS) {
        this.zh_HANS = zh_HANS;
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
            "\n    de=" + de +
            "\n    id=" + id +
            "\n    it=" + it +
            "\n    ja=" + ja +
            "\n    ko=" + ko +
            "\n    zh_HANS=" + zh_HANS +
            "\n}";
    }
}
