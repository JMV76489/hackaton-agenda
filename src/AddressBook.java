import java.util.ArrayList;

public class AddressBook {



    private ArrayList<Contact> contacts;
    private int capacity;

    public AddressBook() {
        this.capacity = 10;
        this.contacts = new ArrayList<>();
    }


    public AddressBook(int capacity) {
        this.capacity = capacity;
        this.contacts = new ArrayList<>();
    }


    public void addContact(Contact contact) {
        if (isFull()) {
            System.out.println("Agenda llena, no se pueden agregar más contactos (máximo 10).");
            return;
        }

        contacts.add(contact);
        System.out.println("Contacto agregado.");
    }

    public boolean contactExists(Contact contact) {
        return false;
    }

    public void listContacts() {

    }

    public void searchContact(String name) {

    }

    public void removeContact(Contact contact) {

    }

    public void updatePhone(String name, String lastName, String newPhone) {
        
    }

    public boolean isFull() {
        return contacts.size() >= capacity;
    }

    public int freeSpaces() {
        return 0;
    }
}
