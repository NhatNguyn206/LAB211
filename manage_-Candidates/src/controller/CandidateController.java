package controller;

import model.Candidate;
import model.CandidateList;
import view.ConsoleForm;
import view.Menu;

import java.util.List;

public class CandidateController {
    private final CandidateList candidateList;
    private final ConsoleForm consoleForm;

    public CandidateController() {
        this.candidateList = new CandidateList();
        this.consoleForm = new ConsoleForm();
    }

    public void execute(){
        while (true){
            int choice = Menu.getChoice();
            switch (choice){
                case 1:
                    Create(Candidate.EXPERIENCE);
                    break;
                case 2:
                    Create(Candidate.FRESHER);
                    break;
                case 3:
                    Create(Candidate.INTERN);
                    break;
                case 4:
                    Search();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void Create(int type){
        do {
            String id = consoleForm.inputId();
            while (candidateList.isIdExist(id)) {
                consoleForm.displayError("ID already exists, please enter another ID");
                id = consoleForm.inputId();
            }

            Candidate candidate;
            if (type == Candidate.EXPERIENCE) {
                candidate = consoleForm.inputExperience(id);
            } else if (type == Candidate.FRESHER) {
                candidate = consoleForm.inputFresher(id);
            } else {
                candidate = consoleForm.inputIntern(id);
            }

            if (candidateList.addCandidate(candidate)) {
                consoleForm.displayMessage("Successful");
            }
        } while (consoleForm.askContinue());
        displayAll();
    }

    public void Search(){
        if (candidateList.getCandidateList().isEmpty()){
            consoleForm.displayError("Candidate list is empty!");
            return;
        }
        displayAll();
        String key = consoleForm.inputKeyword();
        int type = consoleForm.inputType();
        List<Candidate> result = candidateList.search(key,type);
        consoleForm.displaySearchResult(result);
    }





    private void displayAll() {
        consoleForm.displayAllByType(candidateList.getByType(
                Candidate.EXPERIENCE),
                candidateList.getByType(Candidate.FRESHER),
                candidateList.getByType(Candidate.INTERN));
    }
}
