package org.kaspa.kdx.translationconverter;

public enum TranslationsEnum {
    EN("en"),
    DA("da"),
    DE("de"),
    ES("es"),
    FA("fa"),
    FI("fi"),
    FR("fr"),
    HI("hi"),
    HU("hu"),
    ID("id"),
    IT("it"),
    JA("ja"),
    KO("ko"),
    NL("nl"),
    PL("pl"),
    PT_BR("pt_BR"),
    RU("ru"),
    SQ("sq"),
    UK("uk"),
    UR("ur"),
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
