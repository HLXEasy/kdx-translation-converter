package org.kaspa.kdx.translationconverter;

public enum TranslationsEnum {
    EN("en"),
    BG("bg"),
    CS("cs"),
    DA("da"),
    DE("de"),
    EL("el"),
    ES("es"),
    FA("fa"),
    FI("fi"),
    FR("fr"),
    HI("hi"),
    HR("hr"),
    HU("hu"),
    ID("id"),
    IT("it"),
    JA("ja"),
    KA("ka"),
    KO("ko"),
    NL("nl"),
    NO("no"),
    PL("pl"),
    PT_BR("pt_BR"),
    RO("ro"),
    RU("ru"),
    SQ("sq"),
    SR("sr"),
    SV("sv"),
    TR("tr"),
    UK("uk"),
    UR("ur"),
    VI("vi"),
    ZH("zh"),
    ZH_HANS("zh_HANS"),
    ;

    private final String translation;
    TranslationsEnum(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public static TranslationsEnum getOptionByName(String name) {
        for (TranslationsEnum options : values()) {
            if (options.translation.equals(name)) {
                return options;
            }
        }
        return null;
    }
}
