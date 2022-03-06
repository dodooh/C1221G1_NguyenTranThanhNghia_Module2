package collection_review.models;

public class ExperienceCandidate extends Candidate {

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate(Candidate candidate, int expInYear,
        String proSkill) {
        super(candidate);
        this.setCandidateType(0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public ExperienceCandidate(int candidateID, String firstName, String lastName, int birthDay,
        String address, String phoneNumber, String email, int expInYear,
        String proSkill) {
        super(candidateID, firstName, lastName, birthDay, address, phoneNumber, email);
        this.setCandidateType(0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "ExperienceCandidate{" +
            super.toString() +
            ", expInYear=" + expInYear +
            ", proSkill='" + proSkill + '\'' +
            '}';
    }
}
