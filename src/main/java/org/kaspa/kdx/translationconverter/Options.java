package org.kaspa.kdx.translationconverter;

public enum Options {
    DEFAULT_LANGUAGE("defaultLang", "en"),
    TRANSLATION_FILE_FOLDER("folder", "/tmp/kdx"),
    SPLIT_FILES("split", ""),
    MERGE_FILES("merge", ""),
    SHOW_HELP("help", ""),
    ;
    private final String option;
    private final String defaultValue;

    Options(String option, String defaultValue) {
        this.option = option;
        this.defaultValue = defaultValue;
    }

    public String getOption() {
        return option;
    }

    public static Options getOptionByName(String name) {
        for (Options options : values()) {
            if (options.option.equals(name)) {
                return options;
            }
        }
        return null;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
