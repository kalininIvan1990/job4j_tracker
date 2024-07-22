package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> tasks = new HashSet<>();
        for (Task numbers : list) {
            tasks.add(numbers.getNumber());
        }
        return tasks;
    }
}
