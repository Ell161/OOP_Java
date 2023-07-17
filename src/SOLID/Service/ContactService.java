package SOLID.Service;

import SOLID.Model.Book;
import SOLID.Model.Contact;
import SOLID.Model.ContactGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactService implements DataService, FileReader {
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void create(Object... args) {
        Object[] data = args;
        int id = getId();
        String name = (String) args[0];
        String number = (String) args[1];
        ContactGroup group = (ContactGroup) args[2];
        Book book = (Book) args[3];
        Contact contact = new Contact(id, name, number, group, book);
        contactList.add(contact);
    }

    @Override
    public void update(Object... args) {
        Object[] data = args;
        int id = (int) args[0];
        contactList.get(id).setName((String) args[1]);
        contactList.get(id).setNumber((String) args[2]);
        contactList.get(id).setGroup((ContactGroup) args[3]);
        contactList.get(id).setBook((Book) args[4]);
    }

    @Override
    public void delete(Object... args) {
        Object[] data = args;
        int id = (int) args[0];
        contactList.remove(id - 1);
    }

    private int getId() {
        int lastId = 0;
        for (Contact contact : contactList) lastId++;
        return ++lastId;
    }

    public List<Contact> readPhonebook() {
        return contactList;
    }

    public List<Contact> readByGroupContacts(ContactGroup group) {
        List<Contact> groupContacts = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getGroup() == group) groupContacts.add(contact);
        }
        return groupContacts;
    }

    public List<Contact> readBookContacts(Book book) {
        List<Contact> bookContacts = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getBook() == book) bookContacts.add(contact);
        }
        return bookContacts;
    }

    public void importContacts(String filename, Book book) {
        List<String> contacts = readFile(filename);
        for (String contact : contacts) {
            String[] dataContact = contact.split(",");
            String name = dataContact[1];
            String number = dataContact[2];
            ContactGroup group = null;
            if (dataContact[3].equals("FAMILY")) group = ContactGroup.FAMILY;
            else if (dataContact[3].equals("FRIENDS")) {
                group = ContactGroup.FRIENDS;
            } else if (dataContact[3].equals("WORK")) {
                group = ContactGroup.WORK;
            }
            create(name, number, group, book);
        }
    }
}
