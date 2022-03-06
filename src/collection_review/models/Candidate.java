package collection_review.models;

public class Candidate {

    private int candidateID;
    private String firstName;
    private String lastName;
    private int birthDay;
    private String address;
    private String phoneNumber;
    private String email;
    private int candidateType = -1;

    public Candidate() {
    }

    public Candidate(Candidate clone) {
        this.candidateID = clone.candidateID;
        this.firstName = clone.firstName;
        this.lastName = clone.lastName;
        this.birthDay = clone.birthDay;
        this.address = clone.address;
        this.phoneNumber = clone.phoneNumber;
        this.email = clone.email;
    }


    public Candidate(int candidateID, String firstName, String lastName, int birthDay,
        String address,
        String phoneNumber, String email) {
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return
            "candidateID=" + candidateID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", candidateType=" + candidateType;
    }
}
