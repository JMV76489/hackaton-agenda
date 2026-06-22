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
        return false;
    }

    public int freeSpaces() {
        return 0;
    }
}
