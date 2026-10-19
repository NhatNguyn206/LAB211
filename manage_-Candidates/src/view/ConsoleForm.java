package view;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

import java.util.List;

public class ConsoleForm {
    public String inputId() {
        return DataInput.inputString("Enter Candidate ID: ");
    }

    public Experience inputExperience(String id) {
        System.out.println("-------- Create Experience Candidate --------");

        String firstName = DataInput.inputString("Enter First Name: ");
        String lastName = DataInput.inputString("Enter Last Name: ");
        int birthDate = DataInput.inputBirthdate();
        String address = DataInput.inputString("Enter Address: ");
        String phone = DataInput.inputPhone("Enter Phone (at least 10 digits): ");
        String email = DataInput.inputEmail("Enter Candidate Email: ");
        int expInYear = DataInput.inputYearExperience();
        String proSkill = DataInput.inputString("Enter Professional Skill: ");

        return new Experience(id, firstName, lastName, birthDate, address, phone, email,
                expInYear, proSkill);
    }

    public Fresher inputFresher(String id) {
        System.out.println("-------- Create Fresher Candidate --------");
        String firstName = DataInput.inputString("Enter First Name: ");
        String lastName = DataInput.inputString("Enter Last Name: ");
        int birthDate = DataInput.inputBirthdate();
        String address = DataInput.inputString("Enter Address: ");
        String phone = DataInput.inputPhone("Enter Phone (at least 10 digits): ");
        String email = DataInput.inputEmail("Enter Candidate Email: ");

        String graduationDate = DataInput.inputString("Enter Graduation Date: ");
        String graduationRank = DataInput.inputRank("Enter Graduation Rank (Excellence, Good, Fair, Poor): ");
        String education = DataInput.inputString("Enter Education (university graduated): ");

        return new Fresher(id, firstName, lastName, birthDate, address, phone, email,
                graduationDate, graduationRank, education);
    }

    public Intern inputIntern(String id) {
        System.out.println("-------- Create Intern Candidate --------");
        String firstName = DataInput.inputString("Enter First Name: ");
        String lastName = DataInput.inputString("Enter Last Name: ");
        int birthDate = DataInput.inputBirthdate();
        String address = DataInput.inputString("Enter Address: ");
        String phone = DataInput.inputPhone("Enter Phone (at least 10 digits): ");
        String email = DataInput.inputEmail("Enter Candidate Email: ");


        String majors = DataInput.inputString("Enter Majors: ");
        String semester = DataInput.inputString("Enter Semester: ");
        String universityName = DataInput.inputString("Enter University Name: ");

        return new Intern(id, firstName, lastName, birthDate, address, phone, email,
                majors, semester, universityName);
    }

    //Search
    public String inputKeyword() {
        return DataInput.inputString("Input Candidate name (First name or Last name): ");
    }

    public int inputType() {
        return DataInput.inputIntLimit("Input type of candidate (0: Experience, 1: Fresher, 2: Intern): ",0, 2);
    }

    public void displayAllByType(List<Candidate> experiences, List<Candidate> freshers, List<Candidate> interns) {
        System.out.println("List of candidate:");
        displayGroup("===========EXPERIENCE CANDIDATE============", experiences);
        displayGroup("==========FRESHER CANDIDATE==============", freshers);
        displayGroup("===========INTERN CANDIDATE==============", interns);
    }

    private void displayGroup(String banner, List<Candidate> list) {
        if (list.isEmpty()) {
            return;
        }
        System.out.println(banner);
        for (Candidate c : list) {
            System.out.println(c.getFullName());
        }
    }

    public void displaySearchResult(List<Candidate> result) {
        if (result.isEmpty()) {
            System.out.println("No candidate found");
            return;
        }
        System.out.println("The candidates found:");
        for (Candidate c : result) {
            System.out.println(c.toString());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public boolean askContinue() {
        return DataInput.inputYN("Do you want to continue (Y/N)? ");
    }
}
