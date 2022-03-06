package collection_review.controllers;

import collection_review.services.Services;
import collection_review.services.impl.ExperienceCandidateServicesImpl;
import collection_review.services.impl.FresherCandidateServicesImpl;
import collection_review.services.impl.InternCandidateServicesImpl;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

public class CandidateController {

    public static Scanner scanner = new Scanner(System.in);
    private Services experienceService = new ExperienceCandidateServicesImpl();
    private Services fresherService = new FresherCandidateServicesImpl();
    private Services internService = new InternCandidateServicesImpl();

    public void showMainMenu() {
        boolean flag = true;
        do {
            System.out.println("========CANDIDATE MANAGEMENT SYSTEM=========");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.println("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewCandidate(experienceService);
                    break;
                case 2:
                    addNewCandidate(fresherService);
                    break;
                case 3:
                    addNewCandidate(internService);
                    break;
                case 4:
                    searchCandidateByName();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    void addNewCandidate(Services services) {
        char c;
        do {
            services.add();
            System.out.print("Do you want to continue (Y/N)?");
            c = scanner.nextLine().toLowerCase().charAt(0);
        } while (c != 'n');
        services.showGeneralList();
    }

    void searchCandidateByName() {
        experienceService.showGeneralList();
        fresherService.showGeneralList();
        internService.showGeneralList();
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = scanner.nextLine();
        System.out.print("Input type of candidate (0,1,2): ");
        int type = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 0:
                experienceService.searchByName(name);
                break;
            case 1:
                fresherService.searchByName(name);
                break;
            case 2:
                internService.searchByName(name);
                break;
            default:
                System.err.println("Type error (0,1,2 ONLY)!!!");
        }
    }

}
