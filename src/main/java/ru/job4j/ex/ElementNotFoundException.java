package ru.job4j.ex;

public class ElementNotFoundException extends Exception {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"1", "2", "3"};
        String key = "5";
        try {
            indexOf(value, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
