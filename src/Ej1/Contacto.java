package Ej1;

import java.util.Objects;

public class Contacto {
     String name;
     String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Contacto createContact(String name, String phoneNumber){
        return new Contacto(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (!name.equalsIgnoreCase(contacto.name)) return false;
        return phoneNumber.equalsIgnoreCase(contacto.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
