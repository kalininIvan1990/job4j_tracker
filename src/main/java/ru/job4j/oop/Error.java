package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(true, 2, "Successfully");
        error2.printInfo();
        Error error3 = new Error(false, 0, "Error");
        error3.printInfo();
    }
}
