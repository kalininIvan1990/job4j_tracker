package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftElement = left.split("/");
        String[] rightElement = right.split("/");
        int cmp = rightElement[0].compareTo(leftElement[0]);
        if (cmp != 0) {
            return cmp;
        }
        int length = Math.min(leftElement.length, rightElement.length);
        for (int i = 0; i < length; i++) {
            cmp = leftElement[i].compareTo(rightElement[i]);
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(leftElement.length, rightElement.length);
    }
}