package model;

public class Intern extends Candidate {
    private String majors;
    private String semester;
    private String University_name;

    public Intern(){;
    }

    public Intern(String candidateId, String firstName, String lastName, int birthDate, String address, String phone,
                  String email, String majors, String semester, String university_name) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, Candidate.INTERN);
        this.majors = majors;
        this.semester = semester;
        University_name = university_name;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + majors + " | " + semester + " | " + University_name;
    }
}
