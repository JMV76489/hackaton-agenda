import java.util.ArrayList;
import java.util.List;

public class AddressBook {


    private ArrayList<Contact> contacts;
    private int capacity;

    public AddressBook() {
        this.capacity = 10;
        this.contacts = new ArrayList<Contact>();
    }


    public AddressBook(int capacity) {
        this.capacity = capacity;
        this.contacts = new ArrayList<Contact>();
    }


    public void addContact(Contact contact) {

    }

    public boolean contactExists(Contact contact) {
        return false;
    }

    public void listContacts() {

    }

    public void searchContact(String name) {

        List<Contact> filteredContacts = this.contacts.stream().filter(contact -> {

            String fullName = (contact.getName() + " " + contact.getLastName()).toLowerCase();
            String stringToSearch = name.toLowerCase();
            Boolean containsName = fullName.contains(stringToSearch);

            return containsName;
        }).toList();

        if (filteredContacts.isEmpty()) {
            System.out.println("No se encontro el contacto");
            return;
        }
        Contact found = filteredContacts.getFirst();
        System.out.println(name + ": " + found.getPhoneNumber());
    }

    public void removeContact(Contact contact) {

    }

    public void updatePhone(String name, String lastName, String newPhone) {
        
    }

    public boolean isFull() {
        return false;
    }

    public int freeSpaces() {
        return this.capacity - contacts.size();
    }
}
