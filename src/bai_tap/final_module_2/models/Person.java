package bai_tap.final_module_2.models;

import static bai_tap.final_module_2.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.final_module_2.models.enums.Gender;
import java.util.Date;

public abstract class Person {

    private String name;
    private Date dOB;
    private Gender gender;
    private String phoneNumber;

    public Person(String name, Date dOB, Gender gender, String phoneNumber) {
        this.name = name;
        this.dOB = dOB;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
            ", name='" + name + '\'' +
                ", dOB=" + simpleDateFormat.format(dOB) +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'';
    }

    public String toCSVFormat() {
        return name + "," + simpleDateFormat.format(dOB) + "," + gender + "," + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
