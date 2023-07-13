package MVC.Controller;

import MVC.Model.Book;
import MVC.Model.Contact;
import MVC.Model.ContactGroup;
import MVC.Model.FileType;
import MVC.Service.ContactService;
import MVC.View.ContactView;

import java.util.List;

public class Controller {
    private final ContactService contactService = new ContactService();
    private final ContactView contactView = new ContactView();

    public void createContact(String name, String number, ContactGroup group, Book book) {
        contactService.create(name, number, group, book);
    }

    public void getFamilyContacts() {
        List<Contact> familyContacts = contactService.readByGroupContacts(ContactGroup.FAMILY);
        for (Contact contact : familyContacts) contactView.printContact(contact);
    }

    public void getWorkContacts() {
        List<Contact> workContacts = contactService.readByGroupContacts(ContactGroup.WORK);
        for (Contact contact : workContacts) contactView.printContact(contact);
    }

    public void getFriendsContacts() {
        List<Contact> friendsContacts = contactService.readByGroupContacts(ContactGroup.FRIENDS);
        for (Contact contact : friendsContacts) contactView.printContact(contact);
    }

    public void getAllContacts() {
        List<Contact> allContacts = contactService.readPhonebook();
        for (Contact contact : allContacts) contactView.printContact(contact);
    }

    public void getPhoneContacts() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.PHONE);
        for (Contact contact : phoneBookContacts) contactView.printContact(contact);
    }

    public void getSimContacts() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.SIM);
        for (Contact contact : phoneBookContacts) contactView.printContact(contact);
    }

    public void exportPhoneBookContacts(FileType type) {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.PHONE);
        contactService.exportContacts(type, phoneBookContacts);
    }

    public void exportSimBookContacts(FileType type) {
        List<Contact> simBookContacts = contactService.readBookContacts(Book.SIM);
        contactService.exportContacts(type, simBookContacts);
    }

    public void importContactsPhonebook(String fileName) {
        contactService.importContacts(fileName, Book.PHONE);
    }

    public void importContactsSimbook(String fileName) {
        contactService.importContacts(fileName, Book.SIM);
    }
}
