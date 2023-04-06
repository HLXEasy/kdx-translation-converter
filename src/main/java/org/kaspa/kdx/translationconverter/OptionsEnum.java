package org.kaspa.kdx.translationconverter;

public enum OptionsEnum {
    DEFAULT_LANGUAGE("defaultLang", "en"),
    TRANSLATION_FILE_FOLDER("folder", "/tmp/kdx"),
    SPLIT_FILES("split", ""),
    MERGE_FILES("merge", ""),
    SHOW_HELP("help", ""),
    ;
    private final String option;
    private final String defaultValue;

    OptionsEnum(String option, String defaultValue) {
        this.option = option;
        this.defaultValue = defaultValue;
    }

    public String getOption() {
        return option;
    }

    public static OptionsEnum getOptionByName(String name) {
        for (OptionsEnum optionsEnum : values()) {
            if (optionsEnum.option.equals(name)) {
                return optionsEnum;
            }
        }
        return null;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
