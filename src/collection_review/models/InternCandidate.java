package collection_review.models;

public class InternCandidate extends Candidate {

    private String majors;
    private int semester;
    private String universityName;

    public InternCandidate(Candidate clone, String majors, int semester,
        String universityName) {
        super(clone);
        this.setCandidateType(2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public InternCandidate(int candidateID, String firstName, String lastName, int birthDay,
        String address, String phoneNumber, String email, String majors,
        int semester,
        String universityName) {
        super(candidateID, firstName, lastName, birthDay, address, phoneNumber, email);
        this.setCandidateType(2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "InternCandidate{" +
            super.toString() +
            ", majors='" + majors + '\'' +
            ", semester=" + semester +
            ", universityName='" + universityName + '\'' +
            '}';
    }
}
