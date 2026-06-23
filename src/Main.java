import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        boolean salir = false;

        while (!salir) {

            System.out.println("\n===== MENÚ AGENDA =====");
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Verificar si existe contacto");
            System.out.println("3.- Listar todos los contactos");
            System.out.println("4.- Buscar contacto");
            System.out.println("5.- Eliminar contacto");
            System.out.println("6.- Actualizar teléfono");
            System.out.println("7.- Comprobar si la agenda está llena");
            System.out.println("8.- Ver espacios libres");
            System.out.println("9.- Salir");
            System.out.print("Elige una opción: ");

            try {

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1 -> {
                        Contact c = readContactFull(scanner);
                        addressBook.addContact(c);
                    }

                    case 2 -> {
                        Contact c = readContactBasic(scanner);

                        System.out.println(addressBook.contactExists(c)
                                ? "El contacto existe."
                                : "El contacto NO existe.");
                    }

                    case 3 -> addressBook.listContacts();

                    case 4 -> {
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine().trim();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine().trim();

                        addressBook.searchContact(nombre, apellido);
                    }

                    case 5 -> {
                        Contact c = readContactBasic(scanner);
                        addressBook.removeContact(c);
                    }

                    case 6 -> {

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine().trim();

                        System.out.print("Apellido: ");
                        String apellido = scanner.nextLine().trim();

                        System.out.print("Nuevo teléfono: ");
                        String telefono = scanner.nextLine().trim();

                        addressBook.updatePhone(nombre, apellido, telefono);
                    }

                    case 7 -> System.out.println(
                            addressBook.isFull()
                                    ? "La agenda está llena."
                                    : "Aún hay espacio disponible."
                    );

                    case 8 -> System.out.println(
                            "Espacios disponibles: " + addressBook.freeSpaces()
                    );

                    case 9 -> {
                        salir = true;
                        System.out.println("Cerrando agenda...");
                    }

                    default -> System.out.println("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static Contact readContactFull(Scanner scanner) {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();

        return new Contact(nombre, apellido, telefono);
    }

    private static Contact readContactBasic(Scanner scanner) {

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        return new Contact(nombre, apellido, "");
    }
}