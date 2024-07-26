package ru.job4j.queue;

import java.util.*;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> deque = new LinkedList<>(evenElements);
        for (int index = 0; index < evenElements.size(); index++) {
            char element = deque.poll();
            if (index % 2 == 0) {
                stringBuilder.append(element);
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> deque = new LinkedList<>(descendingElements);
        for (int index = 0; index < descendingElements.size(); index++) {
            stringBuilder.append(deque.pollLast());
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
