package org.kaspa.kdx.translationconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class LangFileSplitter {
    private static final String KDX_LANGUAGE_FILE = "i18n.data";
    private final String translationFileFolder;

    public LangFileSplitter(String translationFileFolder) {
        this.translationFileFolder = translationFileFolder;
    }

    public void doSplit() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Translation[] translations = objectMapper.readValue(new File(translationFileFolder + File.separator + KDX_LANGUAGE_FILE), Translation[].class);

        System.out.println(Arrays.toString(translations));

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        for (TranslationsEnum translationsEnum : TranslationsEnum.values()) {
            LinkedHashMap<String, String> translationTargetMap = new LinkedHashMap<String, String>();
            for (Translation translation : translations) {
                String currentTranslation;
                switch (translationsEnum) {
                    case EN -> currentTranslation = translation.getEn();
                    case CMN -> currentTranslation = translation.getCmn();
                    case DE -> currentTranslation = translation.getDe();
                    case FR -> currentTranslation = translation.getFr();
                    case ID -> currentTranslation = translation.getId();
                    case IT -> currentTranslation = translation.getIt();
                    case JA -> currentTranslation = translation.getJa();
                    case KO -> currentTranslation = translation.getKo();
                    case ZH -> currentTranslation = translation.getZh();
                    default -> currentTranslation = "";
                }
                translationTargetMap.put(translation.getEn(), currentTranslation);
            }
            objectMapper.writeValue(new File("kdx_" + translationsEnum.getTranslation() + ".json"), translationTargetMap);
        }
    }
}
