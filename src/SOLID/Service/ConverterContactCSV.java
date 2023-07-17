package SOLID.Service;

import SOLID.Model.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ConverterContactCSV implements Converter {
    @Override
    public void toConvert(Object objectList) {
        if (objectList instanceof List<?>) {
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
            for (Contact contact : (List<Contact>) objectList) {
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
            try (PrintWriter writer = new PrintWriter(new File("contacts.csv"))) {
                writer.write(sb.toString());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
