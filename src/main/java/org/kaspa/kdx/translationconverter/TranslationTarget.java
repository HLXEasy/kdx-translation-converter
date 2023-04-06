package org.kaspa.kdx.translationconverter;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TranslationTarget {

    LinkedHashMap<String, String> translationMap = new LinkedHashMap<>();
    public void add(String key, String value) {
        translationMap.put(key, value);
    }

    public HashMap<String, String> getTranslationMap() {
        return translationMap;
    }
}
