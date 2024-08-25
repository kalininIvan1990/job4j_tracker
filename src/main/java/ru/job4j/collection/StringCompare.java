package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < Math.min(left.length(), right.length()); index++) {
            char leftChar = left.charAt(index);
            char rightChar = right.charAt(index);
            if (leftChar != rightChar) {
                return Character.compare(leftChar, rightChar);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
