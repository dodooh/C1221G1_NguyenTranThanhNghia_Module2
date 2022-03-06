package collection_review.views;

import collection_review.controllers.CandidateController;
import collection_review.models.Candidate;

public class Views {

    public static void main(String[] args) {
        CandidateController candidateController = new CandidateController();
        candidateController.showMainMenu();
    }
}
