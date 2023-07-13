package MVC.Model;

public class Contact {
    private int id;
    private String name;
    private String number;
    private ContactGroup group;
    private Book book;

    public Contact(int id, String name, String number, ContactGroup group, Book book) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.group = group;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactGroup getGroup() {
        return group;
    }

    public void setGroup(ContactGroup group) {
        this.group = group;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", group=" + group +
                ", book=" + book +
                '}';
    }

    public int getId() {
        return id;
    }
}
