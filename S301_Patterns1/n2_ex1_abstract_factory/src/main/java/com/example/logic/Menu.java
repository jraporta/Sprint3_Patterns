package com.example.logic;

import com.example.exceptions.AddressBookDuplicateKeyException;
import com.example.exceptions.TelephoneBookDuplicateKeyException;
import com.example.factory.AbstractFactory;
import com.example.model.ContactBook;
import com.example.model.Address;
import com.example.exceptions.CountryNotImplementedException;
import com.example.exceptions.TelephoneFormatException;
import com.example.model.Telephone;
import com.example.util.Entrada;
import static com.example.logic.AddressCollectorDialog.askForAddress;
import com.example.factory.Countries;

public class Menu {


    static ContactBook contactBook = ContactBook.getInstance();

    public void run() {

        boolean quit = false;
        do {
            switch(menu()) {
                case 1:
                    setAddress();
                    break;
                case 2:
                    setTelephone();
                    break;
                case 3:
                    retrieveAddress();
                    break;
                case 4:
                    retrieveTelephone();
                    break;
                case 5:
                    System.out.println(contactBook);
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Select a valid option.");
            }
        }while(!quit);
    }


    public static int menu() {
        return Entrada.llegirInt("""
                Select an option:
                1. Add an address.
                2. Add a telephone number.
                3. Retrieve an address.
                4. Retrieve a telephone number.
                5. About.
                0. Quit.
                """);
    }

    private static void setAddress() {
        String name;
        Address address;
        AbstractFactory factory;


        try {
            factory = AbstractFactory.getInstance(Entrada.llegirString("Write the country: "));
            name = Entrada.llegirString("Write the contact name: ");
            contactBook.addressBookCheckNameIsAvailable(name);
            address = factory.createAddress(askForAddress(factory.createAddressValidator()));
            contactBook.setAddress(name, address);
        } catch (CountryNotImplementedException e) {
            System.out.printf("The trial version includes %s. Go to the appStore now and buy the full version!%n",
                    Countries.getList());
        } catch (AddressBookDuplicateKeyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setTelephone() {
        String name;
        Telephone telephone;
        AbstractFactory factory;

        try {
            factory = AbstractFactory.getInstance(Entrada.llegirString("Write the country: "));
            name = Entrada.llegirString("Write the contact name: ");
            contactBook.telephoneBookCheckNameIsAvailable(name);
            do {
                try {
                    telephone = factory.createTelephone(
                            Entrada.llegirString("Write the telephone number: "));
                } catch (TelephoneFormatException e) {
                    System.out.println(e.getMessage());
                    telephone = null;
                }
            } while (telephone == null);
            contactBook.setTelephone(name, telephone);
        } catch (CountryNotImplementedException e) {
            System.out.printf("The trial version includes %s. Go to the appStore now and buy the full version!%n",
                    Countries.getList());
        } catch (TelephoneBookDuplicateKeyException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void retrieveAddress() {
        String name;
        Address address;

        name = Entrada.llegirString("Write the contact name: ");
        address = contactBook.getAddress(name);
        System.out.print(address != null ? String.format("%s -> %n%s%n", name, address.getAddress()) :
                String.format("No entry found for: %s.%n", name));
    }

    public static void retrieveTelephone() {
        String name;
        Telephone telephone;

        name = Entrada.llegirString("Write the contact name: ");
        telephone = contactBook.getTelephone(name);
        System.out.print(telephone != null ? String.format("%s -> %s%n", name, telephone) :
                String.format("No entry found for: %s.%n", name));
    }

}
