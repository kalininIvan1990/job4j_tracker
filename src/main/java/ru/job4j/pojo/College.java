package ru.job4j.pojo;

import java.sql.Date;
import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван");
        student.setSurname("Калинин");
        student.setGroup(2);
        student.setAdmission(Date.valueOf(LocalDate.of(2024, 2, 16)));

        System.out.println(student.getName() + " " + student.getSurname() + ", учащийся " + student.getGroup()
                            + " группы. Дата поступления : " + student.getAdmission());
    }
}
