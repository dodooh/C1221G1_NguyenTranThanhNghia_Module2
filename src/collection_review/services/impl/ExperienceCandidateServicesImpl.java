package collection_review.services.impl;

import static collection_review.controllers.CandidateController.scanner;

import collection_review.models.Candidate;
import collection_review.models.ExperienceCandidate;
import java.util.ArrayList;

public class ExperienceCandidateServicesImpl extends CandidateServicesImpl {

    static ArrayList<Candidate> experienceCandidates = new ArrayList<>();

    static {
        experienceCandidates.add(new ExperienceCandidate(101, "Aelbrecht", "Stefan", 1992, "Paris", "0521565251", "stefan@mail.com", 5, "C++"));
        experienceCandidates.add(new ExperienceCandidate(102, "Aguirre", "Eva", 1994, "Sao paulo", "0521145201", "aguirre@mail.com", 6, "Java"));
        experienceCandidates.add(new ExperienceCandidate(103, "Ahlgren", "Maria", 1993, "LA", "052115251", "hlgren@mail.com", 9, "php"));
    }

    @Override
    public void add() {
        super.createNewCandidate();
        Candidate newCandidate = super.getCandidate();
        int expInYear = getExpInYearFromInput();
        String proSkill = getProSkillFromInput();
        experienceCandidates.add(new ExperienceCandidate(newCandidate, expInYear, proSkill));
        System.out.println("New Experience Created");
        System.out.println(experienceCandidates.get(experienceCandidates.size() - 1));
    }

    public void showDetailList() {
        super.showDetailList(experienceCandidates);
    }

    @Override
    public void searchByName(String name) {
        super.searchByName(experienceCandidates, name);
    }

    @Override
    public void showGeneralList() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        super.showGeneralList(experienceCandidates);
    }

    private int getExpInYearFromInput() {
        int expInYear;
        do {
            System.out.print("Enter Experience In Year:");
            expInYear = Integer.parseInt(scanner.nextLine());
            if (expInYear < 0 || expInYear > 100) {
                System.err.println("Invalid Experience In Year!!!");
            } else {
                break;
            }
        } while (true);
        return expInYear;
    }

    private String getProSkillFromInput() {
        String proSkill;
        do {
            System.out.print("Enter Pro Skill:");
            proSkill = scanner.nextLine();
            if (proSkill.length() <= 0) {
                System.err.println("Pro Skill Can't Be Empty!!!");
            } else {
                break;
            }
        } while (true);
        return proSkill;
    }
}
