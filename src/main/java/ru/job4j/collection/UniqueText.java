package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String words : origin) {
            check.add(words);
        }
        for (String text : duplicate) {
            if (!check.contains(text)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
