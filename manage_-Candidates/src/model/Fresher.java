package model;

public class Fresher extends Candidate {
    private String Graduation_date;
    private String Graduation_rank;
    private String education;

    public Fresher() {
    }


    public Fresher(String candidateId, String firstName, String lastName, int birthDate, String address, String phone,
                   String email, String graduation_date, String graduation_rank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, Candidate.FRESHER);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        this.education = education;
    }

    public String getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(String graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    @Override
    public String toString() {
        return super.toString() + " | " + Graduation_date + " | " + Graduation_rank + " | " + education;
    }
}
