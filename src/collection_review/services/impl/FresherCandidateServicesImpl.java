package collection_review.services.impl;

import static collection_review.controllers.CandidateController.scanner;

import collection_review.models.Candidate;
import collection_review.models.ExperienceCandidate;
import collection_review.models.FresherCandidate;
import java.util.ArrayList;

public class FresherCandidateServicesImpl extends CandidateServicesImpl {

    static ArrayList<Candidate> fresherCandidates = new ArrayList<>();

    static {
        fresherCandidates.add(new FresherCandidate(201, "Barbosa", "De Souza", 1996, "Sydney", "0596525142", "barbosa@mail.com", 2020,
            FresherCandidate.RANK_OF_GRADUATION[0], "University Of Sydney"));
        fresherCandidates.add(new FresherCandidate(202, "Cabrera", "Cornice", 1992, "London", "0652125412", "cabera@mail.com", 2019,
            FresherCandidate.RANK_OF_GRADUATION[1], "MIT"));
        fresherCandidates.add(new FresherCandidate(203, "Calderon", "Cuevas", 1998, "Saint Patrick", "0963523652", "calderon@mail.com", 2022,
            FresherCandidate.RANK_OF_GRADUATION[2], "Harvard"));

    }

    @Override
    public void add() {
        super.createNewCandidate();
        Candidate newCandidate = super.getCandidate();
        int graduationDate = getGraduationDateFromInput();
        String graduationRank = getGraduationRankFromInput();
        String universityName = getUniversityNameFromInput();
        fresherCandidates.add(
            new FresherCandidate(newCandidate, graduationDate, graduationRank, universityName));
        System.out.println("New Fresher Created");
        System.out.println(fresherCandidates.get(fresherCandidates.size() - 1));
    }

    @Override
    public void showGeneralList() {
        System.out.println("===========FRESHER CANDIDATE============");
        super.showGeneralList(fresherCandidates);
    }

    @Override
    public void showDetailList() {
        super.showDetailList(fresherCandidates);
    }

    @Override
    public void searchByName(String name) {
        super.searchByName(fresherCandidates, name);
    }

    private String getGraduationRankFromInput() {
        int choice;
        System.out.println("Choose Graduation Rank");
        for (int i = 0; i < FresherCandidate.RANK_OF_GRADUATION.length; i++) {
            System.out.print(i + ". " + FresherCandidate.RANK_OF_GRADUATION[i]);
        }
        do {
            System.out.print("\nYour choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice >= FresherCandidate.RANK_OF_GRADUATION.length) {
                System.out.println("Invalid choice!!!");
            } else {
                break;
            }
        } while (true);
        return FresherCandidate.RANK_OF_GRADUATION[choice];
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

    private int getGraduationDateFromInput() {
        int graduationDate;
        do {
            System.out.print("Enter Graduation Date: ");
            graduationDate = Integer.parseInt(scanner.nextLine());
            if (graduationDate < 1900 || graduationDate > 2040) {
                System.err.println("Invalid Graduation Date!!!");
            } else {
                break;
            }
        } while (true);
        return graduationDate;
    }


}
