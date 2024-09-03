package ru.job4j.stream;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .flatMap(Stream::ofNullable)
                .filter(product -> product.getStandart() - product.getActual() <= 3)
                .filter(product -> product.getStandart() - product.getActual() >= 0)
                .map(p -> new Label(p.getName(), p.getPrice() / 2))
                .map(Label::toString)
                .collect(Collectors.toList());

    }
}
