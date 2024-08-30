package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftElement = left.split("/");
        String[] rightElement = right.split("/");
        int cmp = rightElement[0].compareTo(leftElement[0]);
        return cmp != 0 ? cmp : left.compareTo(right);
    }
}