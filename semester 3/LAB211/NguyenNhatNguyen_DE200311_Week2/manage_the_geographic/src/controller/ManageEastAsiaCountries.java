package controller;


import model.EastAsiaCountryList;
import view.ConsoleForm;
import view.DataInput;
import view.Menu;

public class ManageEastAsiaCountries {
    EastAsiaCountryList eastAsiaCountryList = new EastAsiaCountryList();
    ConsoleForm consoleForm = new ConsoleForm();

    public void execute(){
        while (true){
            int choice = Menu.getChoice();
            switch (choice){
                case 1:
                    do {
                        eastAsiaCountryList.addCountryInformation(consoleForm.inputInformation());
                    }while (DataInput.inputYN());
                    break;
                case 2:
                    consoleForm.displayRecently(eastAsiaCountryList.getRecentlyEnteredInformation());
                    break;

                case 3:
                    consoleForm.displayList(eastAsiaCountryList.searchInformationByName(
                            consoleForm.enterNameToSearch()));
                    break;
                case 4:
                    consoleForm.displayList(eastAsiaCountryList.sortInformationByAscendingOrder());
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }


}
