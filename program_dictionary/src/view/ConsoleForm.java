package view;


import model.Word;

public class ConsoleForm {
    public Word inputInformation(){
        System.out.println("\n------------- Add -------------");
        String english = DataInput.checkInputString("Enter English: ");
        String vietnamese = DataInput.checkInputString("Enter Vietnamese: ");
        return new Word(english, vietnamese);
    }


    public String inputDelete(){
        System.out.println("\n------------ Delete ------------");
        return DataInput.checkInputString("Enter English: ");
    }

    public String inputSearch(){
        System.out.println("\n------------ Translate ------------");
        return DataInput.checkInputString("Enter English: ");
    }

    public void displaySearchResult (Word w){
        if (w != null) {
            System.out.println("Vietnamese: " + w.getVie());
        } else {
            System.out.println("Cannot find this word in dictionary!");
        }
    }

    public boolean confirmUpdate() {
        return DataInput.inputYN("Word existed! Do you want to update it? (Y/N): ");
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public void displayError(String msg) {
        System.err.println(msg);
    }
}
