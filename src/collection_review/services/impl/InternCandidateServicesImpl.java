package collection_review.services.impl;

import static collection_review.controllers.CandidateController.scanner;

import collection_review.models.Candidate;
import collection_review.models.FresherCandidate;
import collection_review.models.InternCandidate;
import java.util.ArrayList;

public class InternCandidateServicesImpl extends CandidateServicesImpl {

    static ArrayList<Candidate> internCandidates = new ArrayList<>();

    static {
        internCandidates.add(new InternCandidate(301, "Maria", "Madeleine", 1994, "New York", "0596522341", "madeleine@mail.com", "Marketing",
            2018, "University Of Sydney"));
        internCandidates.add(new InternCandidate(302, "Csokán", "Babett", 1992, "Ohio", "0652125586", "babett@mail.com", "Accountancy",
            2019, "MIT"));
        internCandidates.add(new InternCandidate(303, "Joana", "Filipa", 1989, "Oslo", "0963536598", "joana@mail.com", "Education",
            2020, "Harvard"));

    }

    @Override
    public void add() {
        super.createNewCandidate();
        Candidate newCandidate = super.getCandidate();
        String major = getMajorFromInput();
        int semester = getSemesterFromInput();
        String universityName = getUniversityNameFromInput();
        internCandidates.add(
            new InternCandidate(newCandidate, major, semester, universityName));
        System.out.println("New Intern Created");
        System.out.println(internCandidates.get(internCandidates.size() - 1));
    }

    @Override
    public void showGeneralList() {
        System.out.println("===========INTERN CANDIDATE============");
        super.showGeneralList(internCandidates);
    }

    @Override
    public void showDetailList() {
        super.showDetailList(internCandidates);
    }

    @Override
    public void searchByName(String name) {
        super.searchByName(internCandidates, name);
    }

    private String getMajorFromInput() {
        String major;
        do {
            System.out.print("Enter Major: ");
            major = scanner.nextLine();
            if (major.length() == 0) {
                System.out.println("Major Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return major;
    }

    private int getSemesterFromInput() {
        int semester;
        do {
            System.out.print("Enter Graduation Date: ");
            semester = Integer.parseInt(scanner.nextLine());
            if (semester < 1900 || semester > 2040) {
                System.err.println("Invalid Semester!!!");
            } else {
                break;
            }
        } while (true);
        return semester;
    }

    private String getUniversityNameFromInput() {
        String universityName;
        do {
            System.out.print("Enter University Name: ");
            universityName = scanner.nextLine();
            if (universityName.length() == 0) {
                System.out.println("University Name Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return universityName;
    }
}
