package com.javaquery.util.json;

import org.json.JSONObject;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
public class JSON {

    /**
     * Merges newJson into original JSONObject. If a key exists in both JSONObjects and the values are also JSONObjects,
     * it merges them recursively. Otherwise, it overwrites the value in the original with the value from newJson.
     *
     * @param original The original JSONObject to be merged into.
     * @param newJson  The new JSONObject whose values will be merged into the original.
     */
    public static void merge(JSONObject original, JSONObject newJson) {
        for (String key : newJson.keySet()) {
            Object newValue = newJson.get(key);
            if (original.has(key)) {
                Object originalValue = original.get(key);
                if (originalValue instanceof JSONObject && newValue instanceof JSONObject) {
                    merge((JSONObject) originalValue, (JSONObject) newValue);
                } else {
                    original.put(key, newValue);
                }
            } else {
                original.put(key, newValue);
            }
        }
    }
}
