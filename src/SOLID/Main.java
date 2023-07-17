package SOLID;

import SOLID.Controller.Controller;
import SOLID.Model.Book;
import SOLID.Model.ContactGroup;
import SOLID.Model.FileType;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createContact("John", "+79991001010", ContactGroup.FRIENDS, Book.PHONE);
        controller.createContact("Carry", "+79991001011", ContactGroup.FRIENDS, Book.SIM);
        controller.createContact("Mom", "+79991001012", ContactGroup.FAMILY, Book.PHONE);
        controller.createContact("Dad", "+79991001013", ContactGroup.FAMILY, Book.SIM);
        controller.createContact("Anna", "+79991001014", ContactGroup.WORK, Book.PHONE);
        controller.createContact("Boss", "+79991001015", ContactGroup.WORK, Book.SIM);

        controller.getAllContacts();
        System.out.println();
        controller.getFriendsContacts();
        System.out.println();
        controller.getSimContacts();
        System.out.println();
        controller.exportPhoneBookToTXT();
        controller.exportSimBookToCSV();
        controller.updateContact(2, "John", "+79991001010", ContactGroup.FRIENDS, Book.PHONE);
        controller.removeContact(1);
        controller.importContactsSimBook("contacts.csv");
        controller.getAllContacts();
    }
}
