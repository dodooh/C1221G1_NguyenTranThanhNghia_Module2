package collection_review.models;

public class FresherCandidate extends Candidate {

    public static final String[] RANK_OF_GRADUATION = {"Excellence", "Good", "Fair", "Poor"};
    private int graduationDate;
    private String graduationRank;
    private String universityName;

    public FresherCandidate(Candidate clone, int graduationDate, String graduationRank,
        String universityName) {
        super(clone);
        this.setCandidateType(1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = universityName;
    }

    public FresherCandidate(int candidateID, String firstName, String lastName, int birthDay,
        String address, String phoneNumber, String email, int graduationDate,
        String graduationRank, String university) {
        super(candidateID, firstName, lastName, birthDay, address, phoneNumber, email);
        this.setCandidateType(1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.universityName = university;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "FresherCandidate{" +
            super.toString() +
            ", graduationDate=" + graduationDate +
            ", graduationRank='" + graduationRank + '\'' +
            ", universityName='" + universityName + '\'' +
            '}';
    }
}
