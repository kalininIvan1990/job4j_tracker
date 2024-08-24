package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    void whenJobAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int result = comparator.compare(
                new Job("Fix bugs", 1),
                new Job("Play videogames", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenJobAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int result = comparator.compare(
                new Job("Fix bugs", 2),
                new Job("Play videogames", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenJobAscByNameAndPriority() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = comparator.compare(
                new Job("Fix bugs", 2),
                new Job("Fix bugs", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenJobDescByNameAndPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = comparator.compare(
                new Job("Fix bugs", 2),
                new Job("Fix bugs", 1)
        );
        assertThat(result).isLessThan(0);
    }
}