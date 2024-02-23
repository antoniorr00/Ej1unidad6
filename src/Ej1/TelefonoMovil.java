package Ej1;

import java.util.ArrayList;

public class TelefonoMovil {
    String myNumber;
    private ArrayList<Contacto> myContacts= new ArrayList<>();

    public TelefonoMovil() {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto);
    }

    private int findContact(String name) {
        for (int n = 0; n < myContacts.size(); n++) {
            if (myContacts.get(n).getName().equalsIgnoreCase(name)) {
                return n; //devuelve la posicion del contacto porque existe
            }
        }
        return -1; // -1 si no existe
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) == -1) { //condicion: si el contacto es -1 no existe y se añade
            myContacts.add(contacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contacto antiguocontacto, Contacto nuevoContacto) {
        int index = findContact(antiguocontacto); //renombro el contacto antiguo
        int indexNuevoContacto= findContact(nuevoContacto.getName()); //renombro el contacto nuevo  //OJO: Pongo getName() para que compare solo los nombres de los contactos en lugar de compararlo todo
        if ((index != -1 && indexNuevoContacto == -1) || indexNuevoContacto==index) {  //condicion: si el contacto antiguo es diferenmte a -1 existe y el nuevo si es -1 no existe o el contacto nuevo ya existe
            myContacts.set(index, nuevoContacto);
            return true;
        }else {
            return false;}
    }


    public boolean removeContact(Contacto contacto) {
        if (findContact(contacto) != -1) { //condicion: si el contacto es diferente a -1 existe
            myContacts.remove(contacto);
        }
        return false;
    }

    public Contacto queryContact(String name) {
        int index = findContact(name);
        if (findContact(name) != -1) { //si el contacto es diferente a -1 existe y devuelve la posicion
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Tenemos " + myContacts.size() + " elementos en la lista de contactos.");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(myContacts.get(i));
        }
    }
}









