package case_study.furama_resort.controllers.people_controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.people_controllers.IPeopleController;
import case_study.furama_resort.models.people_models.Person;
import java.util.List;

public abstract class PeopleControllerImpl implements IPeopleController {

    protected String getNameFromInput() {
        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Name is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return name;
    }

    protected String getDayOfBirthFromInput() {
        String dayOfBirth;
        do {
            System.out.print("Enter day of birth: ");
            dayOfBirth = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Day of birth is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return dayOfBirth;
    }

    protected boolean getGenderFromInput() {
        int input;
        do {
            System.out.println("[1] - Male");
            System.out.println("[2] - Female");
            System.out.print("Your choice: ");
            input = Integer.parseInt(scanner.nextLine());
        } while (input != 1 && input != 2);
        return input == 1;
    }

    protected String getNationalIDFromInput() {
        String nationalID;
        do {
            System.out.print("Enter National ID: ");
            nationalID = scanner.nextLine();
            if (false) { // Validator
                System.err.println("National ID is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return nationalID;
    }

    protected String getPhoneNumberFromInput() {
        String phoneNumber;
        do {
            System.out.print("Enter Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Phone Number is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return phoneNumber;
    }

    protected String getEmailFromInput() {
        String email;
        do {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Email is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return email;
    }

    protected String getIDFromInput() {
        String id;
        do {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if (false) { // Validator
                System.err.println("ID is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return id;
    }

    public void display(List<Person> list) {
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Person item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.err.println("Data not found.");
        }

    }
}
