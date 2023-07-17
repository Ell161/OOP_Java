package SOLID.Controller;

import SOLID.Model.Book;
import SOLID.Model.Contact;
import SOLID.Model.ContactGroup;
import SOLID.Service.ContactService;
import SOLID.Service.Converter;
import SOLID.Service.ConverterContactCSV;
import SOLID.Service.ConverterContactsTXT;
import SOLID.View.ContactView;

import java.util.List;

public class Controller {
    private final ContactService contactService = new ContactService();
    private final ContactView contactView = new ContactView();
    private final Converter converterTXT = new ConverterContactsTXT();
    private final Converter converterCSV = new ConverterContactCSV();

    /**
     * @apiNote создает эксземпляр класса Контакт
     * @param name строковое значение имени контакта
     * @param number строковое значение номера контакта
     * @param group экземпляр класса Группы контакта (FAMILY, WORK, FRIENDS)
     * @param book экзмепляр класса Книги контакта (телефон, sim)
     */
    public void createContact(String name, String number, ContactGroup group, Book book) {
        contactService.create(name, number, group, book);
    }

    /**
     *
     * @param id целочисленное значение идентификатора экземпляра класса Контакт
     * @param name строковое значение имени контакта
     * @param number строковое значение номера контакта
     * @param group экземпляр класса Группы контакта (FAMILY, WORK, FRIENDS)
     * @param book экзмепляр класса Книги контакта (телефон, sim)
     */
    public void updateContact(int id, String name, String number, ContactGroup group, Book book) {
        contactService.update(id, name, number, group, book);
    }

    /**
     * @param id целочисленное значение идентификатора экземпляра класса Контакт
     */
    public void removeContact(int id) {
        contactService.delete(id);
    }

    /**
     * @apiNote вывод списка экземпляров класса Контакт по значению группы Семья
     */
    public void getFamilyContacts() {
        List<Contact> familyContacts = contactService.readByGroupContacts(ContactGroup.FAMILY);
        for (Contact contact : familyContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote вывод списка экземпляров класса Контакт по значению группы Работа
     */
    public void getWorkContacts() {
        List<Contact> workContacts = contactService.readByGroupContacts(ContactGroup.WORK);
        for (Contact contact : workContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote вывод списка экземпляров класса Контакт по значению группы Друзья
     */
    public void getFriendsContacts() {
        List<Contact> friendsContacts = contactService.readByGroupContacts(ContactGroup.FRIENDS);
        for (Contact contact : friendsContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote вывод списка всех экземпляров класса Контакт
     */
    public void getAllContacts() {
        List<Contact> allContacts = contactService.readPhonebook();
        for (Contact contact : allContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote вывод списка экземпляров класса Контакт, сохраненных в книге телефона
     */
    public void getPhoneContacts() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.PHONE);
        for (Contact contact : phoneBookContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote вывод списка экземпляров класса Контакт, сохраненных в книге sim-карты
     */
    public void getSimContacts() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.SIM);
        for (Contact contact : phoneBookContacts) contactView.printContact(contact);
    }

    /**
     * @apiNote экспорт списка экземпляров класса Контакт, сохраненных в книге телефона,
     * в файл с расширением .txt
     */
    public void exportPhoneBookToTXT() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.PHONE);
        converterTXT.toConvert(phoneBookContacts);
    }

    /**
     * @apiNote экспорт списка экземпляров класса Контакт, сохраненных в книге телефона,
     * в файл с расширением .csv
     */
    public void exportPhoneBookToCSV() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.PHONE);
        converterCSV.toConvert(phoneBookContacts);
    }

    /**
     * @apiNote экспорт списка экземпляров класса Контакт, сохраненных в книге sim-карты,
     * в файл с расширением .txt
     */
    public void exportSimBookToTXT() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.SIM);
        converterTXT.toConvert(phoneBookContacts);
    }

    /**
     * @apiNote экспорт списка экземпляров класса Контакт, сохраненных в книге sim-карты,
     * в файл с расширением .csv
     */
    public void exportSimBookToCSV() {
        List<Contact> phoneBookContacts = contactService.readBookContacts(Book.SIM);
        converterCSV.toConvert(phoneBookContacts);
    }

    /**
     * @apiNote импорт списка экземпляров класса Контакт из файла в книгу телефона
     */
    public void importContactsPhoneBook(String fileName) {
        contactService.importContacts(fileName, Book.PHONE);
    }

    /**
     * @apiNote импорт списка экземпляров класса Контакт из файла в книгу sim-карты
     */
    public void importContactsSimBook(String fileName) {
        contactService.importContacts(fileName, Book.SIM);
    }
}