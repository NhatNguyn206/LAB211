package model;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(String candidateId, String firstName, String lastName, int birthDate,
                      String address, String phone, String email,
                      int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, Candidate.EXPERIENCE);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }


    public String getProSkill() {
        return proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + expInYear + " | " + proSkill;
    }
}
