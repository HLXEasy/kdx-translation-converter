package org.kaspa.kdx.translationconverter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LangFileMerger {

    private static final String KDX_LANGUAGE_FILE = "i18n.data";

    private final String translationFileFolder;

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
                for (TranslationsEnum translationsEnum : TranslationsEnum.values()) {
                    if (filename.endsWith("for_use_kdx-wallet_kdx_enjson_1_" + translationsEnum.getTranslation() + ".json")) {
                        System.out.println("Reading file " + filename);
                        HashMap<String, String> map = objectMapper.readValue(new File(translationFileFolder + File.separator + filename), typeRef);
                        System.out.println(map);
//                    } else {
//                        System.out.println("Skipping file " + filename);
                    }
                }
            }
        } else {
            System.out.println(translationFileFolder + " is not a directory!");
        }

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }
}
