package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("arnold@yandex.ru", "Arnold Schwarzenegger");
        map.put("harry@gmail.ru", "Harry Potter");
        map.put("harry@gmail.ru", "Harry Potter");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
