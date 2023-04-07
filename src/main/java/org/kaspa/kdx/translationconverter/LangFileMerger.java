package org.kaspa.kdx.translationconverter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LangFileMerger {

    private static final String KDX_LANGUAGE_FILE = "i18n.data";

    private final String translationFileFolder;

    Translation[] translations = new Translation[0];

    public LangFileMerger(String translationFileFolder) {
        this.translationFileFolder = translationFileFolder;
    }

    public void doMerge() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);

        TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
        };

        File dir = new File(translationFileFolder);
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {
            for (File child : directoryListing) {
                String filename = child.getName();
                if (filename.equals("kdx-wallet_kdx_enjson_1_en.json")) {
                    System.out.println("Found master language file " + filename);
                    HashMap<String, String> map = objectMapper.readValue(new File(translationFileFolder + File.separator + filename), typeRef);
//                    System.out.println(map);
                    for (Map.Entry<String, String> translationEntry : map.entrySet()) {
                        Translation translation = new Translation();
                        translation.setEn(translationEntry.getKey());
                        addTranslationEntry(translation);
                    }
//                    System.out.println(Arrays.toString(translations));
                    break;
                }
            }
            System.out.println("\n===================================\n");
            for (File child : directoryListing) {
                String filename = child.getName();
                for (TranslationsEnum translationsEnum : TranslationsEnum.values()) {
                    if (filename.endsWith("for_use_kdx-wallet_kdx_enjson_1_" + translationsEnum.getTranslation() + ".json")) {
                        System.out.println("Reading file " + filename);
                        HashMap<String, String> map = objectMapper.readValue(new File(translationFileFolder + File.separator + filename), typeRef);
//                        System.out.println(map);
                        addTranslation(map, translationsEnum);

//                    } else {
//                        System.out.println("Skipping file " + filename);
                    }
                }
            }
        } else {
            System.out.println(translationFileFolder + " is not a directory!");
        }
        System.out.println("\n===================================\n");
        System.out.println(Arrays.toString(translations));
        System.out.println("\n===================================\n");

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        objectMapper.writeValue(new File(translationFileFolder + File.separator + KDX_LANGUAGE_FILE), translations);
    }

    private void addTranslation(HashMap<String, String> map, TranslationsEnum translationsEnum) {
        System.out.println("Adding translation " + translationsEnum);
        int i;
        for (i = 0; i < translations.length; i++) {
            String currentKey = translations[i].getEn();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(currentKey)) {
                    switch (translationsEnum) {
                        case CMN -> translations[i].setCmn(entry.getValue());
                        case DE -> translations[i].setDe(entry.getValue());
                        case FR -> translations[i].setFr(entry.getValue());
                        case ID -> translations[i].setId(entry.getValue());
                        case IT -> translations[i].setIt(entry.getValue());
                        case JA -> translations[i].setJa(entry.getValue());
                        case KO -> translations[i].setKo(entry.getValue());
                        case ZH -> translations[i].setZh(entry.getValue());
                        case ZH_HANS -> translations[i].setZh_HANS(entry.getValue());
                    }
                }
            }
        }
    }

    private void addTranslationEntry(Translation x) {
        int i;

        // Create a new array of size n+1
        Translation[] newTranslationsArray = new Translation[translations.length + 1];

        // Insert elements from old array into the new array
        // Insert all elements till old size, then insert x at n+1
        for (i = 0; i < translations.length; i++) {
            newTranslationsArray[i] = translations[i];
        }
        newTranslationsArray[translations.length] = x;
        translations = newTranslationsArray;
    }
}
