package MVC.Service;

import MVC.Model.Book;
import MVC.Model.Contact;
import MVC.Model.ContactGroup;
import MVC.Model.FileType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
    private List<Contact> contactList = new ArrayList<>();

    public void create(String name, String number, ContactGroup group, Book book) {
        int id = getId();
        Contact contact = new Contact(id, name, number, group, book);
        contactList.add(contact);
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

    public void exportContacts(FileType type, List<Contact> contactList) {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(',');
        sb.append("Name");
        sb.append(',');
        sb.append("Number");
        sb.append(',');
        sb.append("Group");
        sb.append(',');
        sb.append("Book");
        sb.append('\n');
        for (Contact contact : contactList) {
            sb.append(contact.getId());
            sb.append(',');
            sb.append(contact.getName());
            sb.append(',');
            sb.append(contact.getNumber());
            sb.append(',');
            sb.append(contact.getGroup().toString());
            sb.append(',');
            sb.append(contact.getBook().toString());
            sb.append('\n');
        }
        if (type == FileType.CSV) {
            try (PrintWriter writer = new PrintWriter(new File("contacts.csv"))) {
                writer.write(sb.toString());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        if (type == FileType.TXT) {
            try (PrintWriter writer = new PrintWriter(new File("contacts.txt"))) {
                writer.write(sb.toString());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> readFile(String fileName) {
        List<String> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
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
