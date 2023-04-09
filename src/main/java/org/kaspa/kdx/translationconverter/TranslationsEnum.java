package org.kaspa.kdx.translationconverter;

public enum TranslationsEnum {
    EN("en"),
    DE("de"),
    FR("fr"),
    ID("id"),
    IT("it"),
    JA("ja"),
    KO("ko"),
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
