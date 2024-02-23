package Ej1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefonoMovil=new TelefonoMovil();

        public static void imprimirMenu() {
            System.out.println("0 - Para salir");
            System.out.println("1 - Para imprimir los contactos");
            System.out.println("2 - Para agregar un nuevo contacto");
            System.out.println("3 - Para actualizar un contacto existente");
            System.out.println("4 - Para eliminar un contacto de la lista");
            System.out.println("5 - Buscar un contacto (por su nombre)");
            System.out.println("6 - Volver a imprimir el menú");
        }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        imprimirMenu();
try {
    while(continuar) {
        System.out.println("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 0:
                continuar = false;
                break;

            case 1:
                telefonoMovil.printContacts();
                break;

            case 2:
                System.out.print("Ingrese el nombre del contacto: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el número de teléfono: ");
                String telefono = scanner.nextLine();
                Contacto contactoNuevo = Contacto.createContact(nombre, telefono);
                if (telefonoMovil.addNewContact(contactoNuevo)) {
                    System.out.println("Contacto añadido con éxito.");
                } else {
                    System.out.println("Error: No se pudo añadir el contacto. El contacto ya existe.");
                }
                break;

            case 3:
                System.out.println("Ingrese el nombre del contacto que desea actualizar: ");
                String nombreExistente=scanner.nextLine();
                Contacto contactoExistente=telefonoMovil.queryContact(nombreExistente);
                if (contactoExistente!=null){
                    System.out.print("Ingrese el nombre del nuevo contacto: ");
                    String nombreNuevo = scanner.nextLine();
                    System.out.print("Ingrese el número nuevo de teléfono: ");
                    String telefonoNuevo = scanner.nextLine();
                    Contacto contactoNuevo2 = Contacto.createContact(nombreNuevo, telefonoNuevo);
                    if (telefonoMovil.updateContact(contactoExistente, contactoNuevo2)) {
                        System.out.println("Contacto actualizado con éxito.");
                    } else {
                        System.out.println("Error: No se pudo actualizar el contacto. El nuevo contacto ya existe.");
                    }
                } else {
                    System.out.println("Error: El contacto no existe.");
                }
                break;

            case 4:
                System.out.print("Ingrese el nombre del contacto que desea eliminar: ");
                String nombreEliminar = scanner.nextLine();
                Contacto contactoEliminar = telefonoMovil.queryContact(nombreEliminar);
                if (contactoEliminar != null) {
                    telefonoMovil.removeContact(contactoEliminar);
                    System.out.println("Contacto eliminado con éxito.");
                } else {
                    System.out.println("Error: El contacto no existe.");
                }
                break;

            case 5:
                System.out.println("Ingrese el nombre del contacto que desea buscar");
                String nombreBuscar=scanner.nextLine();
                Contacto contactoBuscar=telefonoMovil.queryContact(nombreBuscar);
                if (contactoBuscar!=null){
                    System.out.println("El contacto se ha encontrado con éxito:");
                    System.out.println("Nombre: " + contactoBuscar.getName());
                    System.out.println("Número de teléfono: " + contactoBuscar.getPhoneNumber());
                } else {
                    System.out.println("Error: El contacto no existe.");
                }
                break;

            case 6:
                imprimirMenu();
                break;
            default:
                System.out.println("Opción no válida");
                continuar=true;
                break;

        }
    }
    scanner.close();
}
catch (InputMismatchException e){
    System.out.println("Carácter no válido");
    scanner.nextLine();
    continuar=true;
}
}

}


