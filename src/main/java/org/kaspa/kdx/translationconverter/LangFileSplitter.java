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
                    case BG -> currentTranslation = translation.getBg();
                    case CS -> currentTranslation = translation.getCs();
                    case DA -> currentTranslation = translation.getDa();
                    case DE -> currentTranslation = translation.getDe();
                    case EL -> currentTranslation = translation.getEl();
                    case ES -> currentTranslation = translation.getEs();
                    case FA -> currentTranslation = translation.getFa();
                    case FI -> currentTranslation = translation.getFi();
                    case FR -> currentTranslation = translation.getFr();
                    case HI -> currentTranslation = translation.getHi();
                    case HR -> currentTranslation = translation.getHr();
                    case HU -> currentTranslation = translation.getHu();
                    case ID -> currentTranslation = translation.getId();
                    case IT -> currentTranslation = translation.getIt();
                    case JA -> currentTranslation = translation.getJa();
                    case KO -> currentTranslation = translation.getKo();
                    case NL -> currentTranslation = translation.getNl();
                    case NO -> currentTranslation = translation.getNo();
                    case PL -> currentTranslation = translation.getPl();
                    case PT_BR -> currentTranslation = translation.getPt_BR();
                    case RO -> currentTranslation = translation.getRo();
                    case RU -> currentTranslation = translation.getRu();
                    case SQ -> currentTranslation = translation.getSq();
                    case SR -> currentTranslation = translation.getSr();
                    case SV -> currentTranslation = translation.getSv();
                    case TR -> currentTranslation = translation.getTr();
                    case UK -> currentTranslation = translation.getUk();
                    case UR -> currentTranslation = translation.getUr();
                    case ZH -> currentTranslation = translation.getZh();
                    case ZH_HANS -> currentTranslation = translation.getZh_HANS();
                    default -> currentTranslation = "";
                }
                translationTargetMap.put(translation.getEn(), currentTranslation);
            }
            objectMapper.writeValue(new File(translationFileFolder + File.separator + "kdx_" + translationsEnum.getTranslation() + ".json"), translationTargetMap);
        }
    }
}
