import java.util.ArrayList;

public class AddressBook {

    private ArrayList<Contact> contacts;
    private int capacity;

    public AddressBook() {
        this(10);
    }

    public AddressBook(int capacity) {
        this.capacity = capacity;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {

        if (isFull()) {
            System.out.println("La agenda está llena.");
            return;
        }

        if (contact.getName().trim().isEmpty() || contact.getLastName().trim().isEmpty()) {
            System.out.println("Nombre y apellido no pueden estar vacíos.");
            return;
        }

        if (contactExists(contact)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contacto agregado correctamente.");
    }

    public boolean contactExists(Contact contact) {
        return contacts.stream().anyMatch(c -> c.equals(contact));
    }

    public void listContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        System.out.println("====================================");

        contacts.stream()
                .sorted((c1, c2) -> {
                    int nombre = c1.getName()
                            .compareToIgnoreCase(c2.getName());

                    if (nombre == 0) {
                        return c1.getLastName()
                                .compareToIgnoreCase(c2.getLastName());
                    }

                    return nombre;
                })
                .forEach(c -> System.out.println(
                        c.getName() + " " + c.getLastName() + " - " + c.getPhoneNumber()
                ));
    }

    public void searchContact(String name, String lastName) {

        contacts.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name)
                        && c.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .ifPresentOrElse(
                        c -> System.out.println("Teléfono: " + c.getPhoneNumber()),
                        () -> System.out.println("Contacto no encontrado.")
                );
    }

    public void removeContact(Contact contact) {

        boolean removed = contacts.removeIf(c -> c.equals(contact));

        System.out.println(removed
                ? "Contacto eliminado."
                : "Contacto no encontrado.");
    }

    public void updatePhone(String name, String lastName, String newPhone) {

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)
                    && c.getLastName().equalsIgnoreCase(lastName)) {

                c.setPhoneNumber(newPhone);
                System.out.println("Teléfono actualizado correctamente.");
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }

    public boolean isFull() {
        return contacts.size() >= capacity;
    }

    public int freeSpaces() {
        return capacity - contacts.size();
    }
}