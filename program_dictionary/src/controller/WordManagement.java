package controller;

import model.Word;
import model.WordMap;
import view.ConsoleForm;
import view.DataInput;
import view.Menu;

public class WordManagement {
    private final WordMap wordMap;
    private final ConsoleForm consoleForm;

    public WordManagement(String filePath) {
        this.wordMap = new WordMap(filePath);
        this.consoleForm = new ConsoleForm();
    }

    public void execute(){
        int choice = Menu.getChoice();
        switch (choice){
            case 1:
                checkAdd();
                break;
            case 2:
                if (wordMap.deleteWord(consoleForm.inputDelete())){
                    consoleForm.displayMessage("Successful!");
                }else{
                consoleForm.displayError("Delete fail!");}
                break;
            case 3:
                Word w = wordMap.searchWord(consoleForm.inputSearch());
                consoleForm.displaySearchResult(w);
                break;
            case 4:
                System.exit(0);
        }
    }

    public void checkAdd() {
        while (true) {
            Word w = consoleForm.inputInformation();
            if (wordMap.isExistWord(w.getEng())) {
                if (!consoleForm.confirmUpdate()) {
                    if (!DataInput.inputYN("Do you want to try again? (Y/N): ")) {
                        return; // Chọn No mới thoát ra menu
                    }
                    continue;
                }
            }
            if (wordMap.addWord(w)) {
                consoleForm.displayMessage("Successful!");
                break;
            } else {
                consoleForm.displayError("Add fail!");
                if (!DataInput.inputYN("Do you want to try again? (Y/N): ")) {
                    break;
                }
            }
        }
    }
}

