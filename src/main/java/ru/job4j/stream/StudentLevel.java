package ru.job4j.stream;

import java.util.List;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(student -> student != null)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(student -> student.getScore() >= bound)
                .toList();
    }
}
