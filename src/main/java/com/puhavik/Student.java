package com.puhavik;

public class Student {
    // если использовать примитивы, то по умолчанию значение 0, а если референсы, то по умаолчанию - null
    private Long id;
    private String name;
    private String surname;
    private Double avgGrade;

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade) {
        this.avgGrade = avgGrade;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String  toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }
}