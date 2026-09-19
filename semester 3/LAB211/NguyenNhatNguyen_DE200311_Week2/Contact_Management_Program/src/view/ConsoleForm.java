package view;

import model.Contact;

import java.util.List;

public class ConsoleForm {

    public Contact inputContact(){
        System.out.println("-------- Add a Contact --------");
        System.out.print("Enter First Name: ");
        String firstName = DataInput.inputString();

        System.out.print("Enter Last Name: ");
        String lastName = DataInput.inputString();

        String fullName = firstName + " " + lastName;

        System.out.print("Enter Group: ");
        String group = DataInput.inputString();

        System.out.print("Enter Address: ");
        String address = DataInput.inputString();

        System.out.print("Enter Phone: ");
        String phone = DataInput.inputPhone();

        return new Contact(0, fullName, firstName, lastName, group, address, phone);
    }

    public int enterIdToDelete() {
        System.out.println("-------- Delete a Contact --------");
        System.out.print("Enter ID: ");
        return DataInput.inputPositiveInteger();
    }

    public void displayAll(List<Contact> contactList){
        System.out.println("--------------------------------- Display all Contact ---------------------------------");
        if (contactList.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        System.out.printf("%-5s %-20s %-12s %-12s %-10s %-10s %-15s\n",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");

        for (Contact c : contactList){
            System.out.println(c.toString());
        }


    }

}
