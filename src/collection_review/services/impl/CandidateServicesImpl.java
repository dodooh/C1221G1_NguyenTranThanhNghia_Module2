package collection_review.services.impl;

import collection_review.models.Candidate;
import collection_review.services.Services;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import static collection_review.controllers.CandidateController.scanner;

public abstract class CandidateServicesImpl implements Services {

    private Candidate candidate;

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }


    public void createNewCandidate() {
        int candidateID = getCandidateIDFromInput();
        String firstName = getFirstNameFromInput();
        String lastName = getLastNameFromInput();
        int birthDay = getBirthDayFromInput();
        String address = getAddressFromInput();
        String phoneNumber = getPhoneNumberFromInput();
        String email = getEmailFromInput();
        candidate = new Candidate(candidateID, firstName, lastName, birthDay, address, phoneNumber,
            email);
    }

    protected void searchByName(ArrayList<Candidate> listCandidate, String name) {
        ArrayList<Candidate> result = new ArrayList<>();
        name = name.toLowerCase();
        for (Candidate candidate : listCandidate) {
            if (candidate.getFirstName().toLowerCase().contains(name)
                || candidate.getLastName().toLowerCase().contains(name)) {
                result.add(candidate);
            }
        }
        if (result.size() != 0) {
            System.out.println("The candidates found: ");
            showDetailList(result);
        } else {
            System.out.println("Found 0 candidate with name " + name);
        }

    }

    private void showDetailInformation(Candidate candidate) {
        System.out.println(candidate.getFirstName() + " " +
            candidate.getLastName() + " | " +
            candidate.getBirthDay() + " | " +
            candidate.getAddress() + " | " +
            candidate.getPhoneNumber() + " | " +
            candidate.getEmail() + " | " +
            candidate.getCandidateType());
    }

    protected void showDetailList(ArrayList<Candidate> listCandidate) {
        for (Candidate candidate : listCandidate) {
            showDetailInformation(candidate);
        }
    }

    protected void showGeneralList(ArrayList<Candidate> listCandidate) {
        for (Candidate candidate : listCandidate) {
            System.out.println(candidate.getFirstName() + " " +
                candidate.getLastName());
        }
    }

    private int getCandidateIDFromInput() {
        int candidateID = 0;
        do {
            System.out.print("Enter Candidate ID:");
            candidateID = Integer.parseInt(scanner.nextLine());
            if (candidateID < 0) {
                System.err.println("Invalid ID input!!!");
            } else {
                break;
            }
        } while (true);
        return candidateID;
    }

    private String getFirstNameFromInput() {
        String firstName;
        do {
            System.out.print("Enter First Name:");
            firstName = scanner.nextLine();
            if (firstName.length() <= 0) {
                System.err.println("First Name Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return firstName;
    }

    private String getLastNameFromInput() {
        String lastName;
        do {
            System.out.print("Enter Last Name:");
            lastName = scanner.nextLine();
            if (lastName.length() <= 0) {
                System.err.println("Last Name Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return lastName;
    }

    private String getAddressFromInput() {
        String address;
        do {
            System.out.print("Enter Address:");
            address = scanner.nextLine();
            if (address.length() <= 0) {
                System.err.println("Address Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return address;
    }

    private int getBirthDayFromInput() {
        int birthday = 0;
        int thisYear = new Date().getYear();
        do {
            System.out.print("Enter Birthday:");
            birthday = Integer.parseInt(scanner.nextLine());
            if (birthday < 1900 || birthday > (1900 + thisYear)) {
                System.err.println("Invalid Birthday input!!!");
            } else {
                break;
            }
        } while (true);
        return birthday;
    }

    private String getPhoneNumberFromInput() {
        String phoneNumber;
        do {
            System.out.print("Enter Phone Number:");
            phoneNumber = scanner.nextLine();
            if (Pattern.matches("\\d{10,20}", phoneNumber)) {
                break;
            } else {
                System.err.println("Invalid Phone Number!!!");
            }
        } while (true);
        return phoneNumber;
    }

    private String getEmailFromInput() {
        String email;
        do {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            int firstIndexOfAddress = email.indexOf('@');
            int lastIndexOfAddress = email.lastIndexOf('@');
            int lastIndexOfDot = email.lastIndexOf('.');
            if (firstIndexOfAddress == lastIndexOfAddress
                && lastIndexOfDot >= firstIndexOfAddress + 2
                && lastIndexOfDot != email.length() - 1
                && firstIndexOfAddress >= 3) {
                break;

            } else {
                System.err.println("Invalid Email Format!!!");
            }
        } while (true);
        return email;
    }
}
