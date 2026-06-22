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
            System.out.println("4.- Buscar contacto (por nombre).");
            System.out.println("5.- Eliminar contacto");
            System.out.println("6.- Actualizar contacto");
            System.out.println("7.- Comprobar si la agenda esta llena");
            System.out.println("8.- Ver espacios libres");
            System.out.println("9.- Salir");
            System.out.print("Elige una opción: ");
            try {

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia la linea
                String nombre, apellido, telefono;
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese nombre: ");
                        nombre = scanner.nextLine();
                        System.out.print("Ingrese apellido: ");
                        apellido = scanner.nextLine();
                        System.out.print("Ingrese No. teléfono: ");
                        telefono = scanner.nextLine();
                        addressBook.addContact(new Contact(nombre, apellido, telefono));
                        break;
                    case 2:
                        System.out.println("Ingrese nombre a buscar: ");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese apellido a buscar: ");
                        apellido = scanner.nextLine();
                        if (addressBook.contactExists(new Contact(nombre, apellido, ""))){
                            System.out.println("Este contacto YA existe en la agenda");
                        } else {
                            System.out.println("No existe el contacto.");
                        }
                        break;
                    case 3:
                        addressBook.listContacts();
                        break;
                    case 4:
                        System.out.print("Escribe el nombre a buscar: ");
                        nombre = scanner.nextLine();
                        addressBook.searchContact(nombre);
                        break;
                    case 5:
                        System.out.print("Escribe el nombre del contacto a eliminar: ");
                        nombre = scanner.nextLine();
                        System.out.println("Ingrese Apellido del contacto a eliminar");
                        apellido = scanner.nextLine();
                        addressBook.removeContact(new Contact(nombre, apellido, ""));
                        break;
                    case 6:
                        System.out.print("Nombre del contacto: ");
                        nombre = scanner.nextLine();
                        System.out.print("Apellido del contacto: ");
                        apellido = scanner.nextLine();
                        System.out.print("NUEVO Teléfono: ");
                        telefono = scanner.nextLine();
                        addressBook.updatePhone(nombre, apellido, telefono);
                        break;
                    case 7:
                        if (addressBook.isFull()) {
                            System.out.println("La agenda está llena.");
                        } else {
                            System.out.println("Aún hay espacio en la agenda.");
                        }
                        break;
                    case 8:
                        System.out.println("Quedan " + addressBook.freeSpaces() + " espacios libres.");
                        break;
                    case 9:
                        salir = true;
                        System.out.println("Cerrando agenda");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}