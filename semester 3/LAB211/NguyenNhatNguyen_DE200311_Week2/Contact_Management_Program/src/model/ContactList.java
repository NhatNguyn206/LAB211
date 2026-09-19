package model;

import java.util.ArrayList;
import java.util.List;

public class ContactList {
    List <Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return contactList;
    }

    public boolean addContact(Contact contact){
        if (contact != null){
            int newId = contactList.isEmpty() ? 1 : contactList.get(contactList.size()-1)
                    .getId() +1;
            contact.setId(newId);
            return contactList.add(contact);
        }
        return false;
    }

    public Contact getContactById(int id) {
        for (Contact c : contactList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteContact(int id){
        Contact contactToDelete = getContactById(id);
        if (contactToDelete != null) {
            return contactList.remove(contactToDelete);
        }
        return false;
    }

}
