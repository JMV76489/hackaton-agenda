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
        if (this.isFull()) {
            System.out.printf("Lista de contactos llena, no se pueden ingresar más (maximo %d contactos)\n",this.capacity);
            return;
        }

        for (Contact curContact : this.contacts) {
            if (curContact.getName().equals(contact.getName()) && curContact.getLastName().equals(contact.getLastName())) {
                System.out.printf("Contacto %s %s ya se encuentra registrado\n", contact.getName(), contact.getLastName());
                return;
            }
        }

        contacts.add(contact);
        System.out.println("Contacto registrado correctamente");
    }

    public boolean contactExists(Contact contact) {
        return false;
    }

    public void listContacts() {

    }

    public void searchContact(String name) {

    }

    public void removeContact(Contact contact) {
        if(!this.contacts.removeIf(curContact -> curContact.getName().equals(contact.getName()) && curContact.getLastName().equals(contact.getLastName()))){
            System.out.printf("No se encontró contacto %s %s\n",contact.getName(),contact.getLastName());
        }

        System.out.printf("Contacto %s %s eliminado correctamente\n",contact.getName(),contact.getLastName());
    }

    public void updatePhone(String name, String lastName, String newPhone) {
        for (Contact curContact : contacts) {
            if (curContact.getName().equals(name) && curContact.getLastName().equals(lastName)) {
                curContact.setPhoneNumber(newPhone);
                System.out.printf("No se encontró contacto %s %s\n", name, lastName);
                return;
            }
        }
        System.out.printf("Número de teléfono cambiado correctamente\n", name, lastName);
    }

    public boolean isFull() {
        return false;
    }

    public int freeSpaces() {
        return 10;
    }
}
