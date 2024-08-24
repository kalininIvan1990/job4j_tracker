package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void whenItemAscByNameSorted() {
        List<Item> items = Arrays.asList(
                new Item("Купить лошадь"),
                new Item("Гулять"),
                new Item("Выполнить задачки")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Выполнить задачки"),
                new Item("Гулять"),
                new Item("Купить лошадь")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemDescByNameSorted() {
        List<Item> items = Arrays.asList(
                new Item("Купить лошадь"),
                new Item("Ходатайствовать"),
                new Item("Выполнить задачки")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Ходатайствовать"),
                new Item("Купить лошадь"),
                new Item("Выполнить задачки")
        );
        assertThat(items).isEqualTo(expected);
    }
}