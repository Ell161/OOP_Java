package MVC;

import MVC.Controller.Controller;
import MVC.Model.Book;
import MVC.Model.ContactGroup;
import MVC.Model.FileType;

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
        controller.exportPhoneBookContacts(FileType.TXT);
        controller.exportSimBookContacts(FileType.CSV);
        controller.importContactsPhonebook("contacts.csv");
        System.out.println();
        controller.getPhoneContacts();
    }
}
