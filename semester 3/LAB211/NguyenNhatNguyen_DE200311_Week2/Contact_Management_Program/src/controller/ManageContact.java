package controller;


import model.ContactList;
import view.ConsoleForm;
import view.Menu;

public class ManageContact {
    private ContactList contactList = new ContactList();
    private ConsoleForm consoleForm = new ConsoleForm();

    public void execute(){
        while (true){
            int choice = Menu.getChoice();
            switch (choice){
                case 1:
                    if (contactList.addContact(consoleForm.inputContact())){
                        System.out.println("Successful");
                    }
                    break;
                case 2:
                    consoleForm.displayAll(contactList.getContactList());
                    break;
                case 3:
                    if (contactList.deleteContact(consoleForm.enterIdToDelete())){
                        System.out.println("Successful");
                    }else System.out.println("No found contact");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
