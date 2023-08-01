package com.example.demo.employee;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee{
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String full_name;
    private String extension_name;
    private String email;
    private LocalDate birthdate;
    @Transient
    private Integer age;
    private String civil_status;
    private String citizenship;

    public Employee() {

    }

    public Employee(Long id,
                    String full_name,
                    String extension_name,
                    String email,
                    LocalDate birthdate,
                    String civil_status,
                    String citizenship) {
        this.id = id;
        this.full_name = full_name;
        this.extension_name = extension_name;
        this.email = email;
        this.birthdate = birthdate;
        this.civil_status = civil_status;
        this.citizenship = citizenship;
    }

    public Employee(String full_name,
                    String extension_name,
                    String email,
                    LocalDate birthdate,
                    String civil_status,
                    String citizenship) {
        this.full_name = full_name;
        this.extension_name = extension_name;
        this.email = email;
        this.birthdate = birthdate;
        this.civil_status = civil_status;
        this.citizenship = citizenship;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getExtension_name() {
        return extension_name;
    }

    public void setExtension_name(String extension_name) {
        this.extension_name = extension_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", extension_name='" + extension_name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", civil_status='" + civil_status + '\'' +
                ", citizenship='" + citizenship + '\'' +
                '}';
    }

}
