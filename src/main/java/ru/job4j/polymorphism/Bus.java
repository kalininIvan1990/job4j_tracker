package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус начинает движение");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобусе " + count + " пассажиров");
    }

    @Override
    public double fill(double fuel) {
        return fuel * 64.3;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.drive();
        bus.passengers(32);
        System.out.println(bus.fill(100));
    }
}
