package case_study.furama_resort.models;

public abstract class Person {

    private String name;
    private String dayOfBirth;
    private boolean isMale;
    private String nationalID;
    private String phoneNumber;
    private String email;
    private String id;

    public Person(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String id) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.isMale = isMale;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
            ", dayOfBirth='" + dayOfBirth + '\'' +
            ", isMale=" + isMale +
            ", nationalID='" + nationalID + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", email='" + email + '\'' +
            ", id='" + id + '\'';
    }
}
