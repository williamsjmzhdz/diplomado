/**
 * PENDIENTES
 * 1.- Terminar el método actualizar contactos (falta poder actualizar los MeansContacts)
 * 2.- Terminar la parte del método getPhoneTypes
 */

package edu.unam.agenda;

import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.model.Contact;
import edu.unam.agenda.model.ContactType;
import edu.unam.agenda.model.MeansContacts;
import edu.unam.agenda.model.PhoneType;
import edu.unam.agenda.service.MeansContactsService;
import edu.unam.agenda.service.ContactService;
import edu.unam.agenda.service.PhoneTypeService;
import edu.unam.agenda.service.ContactTypeService;
import edu.unam.agenda.service.impl.MeansContactsServiceImpl;
import edu.unam.agenda.service.impl.ContactServiceImpl;
import edu.unam.agenda.service.impl.PhoneTypeServiceImpl;
import edu.unam.agenda.service.impl.ContactTypeServiceImpl;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class AgendaAPP {
    private final PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
    private final ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
    private final ContactService contactService = ContactServiceImpl.getInstance();
    private final MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();

    public static void main(String[] args) {
        HibernateUtil.init();
        AgendaAPP catalogosAPP = new AgendaAPP();
        catalogosAPP.cargaMenu();
    }

    private Scanner sn = new Scanner(System.in); // Crear una única instancia del Scanner

    public void cargaMenu() {
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Catálogos");
            System.out.println("2. Ver Contactos");
            System.out.println("3. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine(); // limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú catálogos --");
                        cargarMenuCatalogos();
                        break;
                    case 2:
                        System.out.println("-- Entrando Contactos --");
                        cargarMenuContactos();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next(); // Limpiar buffer de entrada
            }
        } while (!salir);
    }

    public void cargarMenuCatalogos() {
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
        do {
            System.out.println("1. Catálogos tipo contacto");
            System.out.println("2. Catálogos tipo teléfono");
            System.out.println("3. Volver");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine(); // limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú catálogos tipo contacto --");
                        cargarMenuCatalogoTipoContacto();
                        break;
                    case 2:
                        System.out.println("-- Entrando catálogos tipo teléfono --");
                        cargarMenuCatalogoTipoTelefono();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next(); // Limpiar buffer de entrada
            }
        } while (!salir);
    }

    public void cargarMenuContactos() {
        int id, age;
        String name, lastName, address;
        ContactType contactType;
        Set<MeansContacts> meansContacts;
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver todos los contactos");
            System.out.println("2. Buscar contacto por ID");
            System.out.println("3. Crear contacto");
            System.out.println("4. Actualizar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Volver");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine(); // limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Lista completa de contactos --");
                        List<Contact> contacts = contactService.getAllContacts();
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                        break;
                    case 2:
                        System.out.println("-- Búsqueda de contacto por ID --");
                        System.out.print("Ingrese el ID del contacto: ");
                        id = sn.nextInt();
                        Contact contact = contactService.getContactById(id);
                        System.out.println(contact);
                        break;
                    case 3:
                        System.out.println("-- Creación de contacto --");
                        contact = new Contact();

                        // Pidiendo los datos
                        System.out.print("Ingrese el nombre: ");
                        name = sn.nextLine();
                        System.out.print("Ingrese el apellido: ");
                        lastName = sn.nextLine();
                        System.out.print("Ingrese la edad: ");
                        age = sn.nextInt();
                        sn.nextLine();
                        System.out.print("Ingrese la dirección: ");
                        address = sn.nextLine();
                        contactType = cargarSubMenuTipoContacto();
                        meansContacts = cargarSubMenuMeansContacts(contact);

                        // Creando el contacto
                        contact.setName(name);
                        contact.setLastName(lastName);
                        contact.setAge(age);
                        contact.setAddress(address);
                        contact.setContactType(contactType);
                        contact.setMeansContacts(meansContacts);

                        // Persistiendo el contacto en la BD
                        contactService.insertContact(contact);

                        // Mostrando el contacto creado
                        System.out.println("El contacto creado es: " + contact);
                        break;
                    case 4:
                        System.out.println("-- Actualización de contacto --");

                        // Recuperar el contacto a actualizar
                        System.out.print("Ingrese el ID del contacto: ");
                        id = sn.nextInt();
                        sn.nextLine(); // Limpieza de buffer
                        contact = contactService.getContactById(id);

                        if (contact == null) {
                            System.out.println("No se encontró un contacto con id: " + id);
                        } else {

                            // Pidiendo los datos
                            System.out.print("Ingrese el nombre: ");
                            name = sn.nextLine();
                            System.out.print("Ingrese el apellido: ");
                            lastName = sn.nextLine();
                            System.out.print("Ingrese la edad: ");
                            age = sn.nextInt();
                            sn.nextLine();
                            System.out.print("Ingrese la dirección: ");
                            address = sn.nextLine();
                            contactType = cargarSubMenuTipoContacto();
                            meansContacts = cargarSubMenuMeansContacts(contact);

                            // Elimina MeansContacts viejos
                            meansContactsService.deleteAllMeansContactsByContactId(id);

                            // Inserta los nuevos MeansContacts
                            for(MeansContacts meansContact : meansContacts) {
                                meansContactsService.insertMeansContacts(meansContact);
                            }

                            // Actualiza los valores del objeto
                            contact.setName(name);
                            contact.setLastName(lastName);
                            contact.setAge(age);
                            contact.setAddress(address);
                            contact.setContactType(contactType);
                            contact.setMeansContacts(meansContactsService.getAllMeansContactsByContactId(id));

                            // Persiste el contacto actualizado en la bd
                            contactService.updateContact(contact);

                            System.out.println("El contacto actualizado es: " + contact);
                        }
                        break;
                    case 5:
                        System.out.println("-- Eliminación de contacto --");

                        System.out.print("Ingrese el ID del contacto: ");
                        id = sn.nextInt();
                        sn.nextLine(); // Limpieza de buffer
                        contact = contactService.getContactById(id);
                        if (contact == null) {
                            System.out.println("No se encontró un contacto con id: " + id);
                        } else {
                            // Elimina MeansContacts asociados al contacto
                            meansContactsService.deleteAllMeansContactsByContactId(id);

                            // Elimina el contacto
                            boolean isDeleted = contactService.deleteContact(contact);
                            if (isDeleted) {
                                System.out.println("Contacto eliminado: " + contact);
                            } else {
                                System.out.println("No se pudo eliminar el contacto con id: " + id);
                            }
                        }
                        break;

                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next(); // Limpiar buffer de entrada
            }
        } while (!salir);
    }

    private ContactType cargarSubMenuTipoContacto() {
        ContactType contactType = null;
        boolean salir = false;
        int opcion;
        List<ContactType> contactTypes = contactTypeService.getAllContactType();

        do {
            System.out.println("Sub Menú: Elige un tipo de contacto");
            for (ContactType ct : contactTypes) {
                System.out.println(ct.getId() + ".- " + ct.getName());
            }
            System.out.print("Ingresa el número de tipo de contacto: ");

            try {
                opcion = sn.nextInt();
                sn.nextLine(); // Limpieza de buffer

                contactType = contactTypeService.getContactTypeById(opcion);
                if (contactType == null) {
                    System.out.println("Valor inválido: Por favor ingrese un tipo de contacto válido.");
                } else {
                    salir = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next(); // Limpiar buffer de entrada
            }

        } while (!salir);

        return contactType;
    }

    private Set<MeansContacts> cargarSubMenuMeansContacts(Contact contact) {
        Set<MeansContacts> meansContacts = new HashSet<>();
        List<PhoneType> phoneTypes;
        Set<Integer> phoneTypesIds = new HashSet<>();
        boolean salir = false;
        int opcion;

        do {
            phoneTypes = phoneTypeService.getAllPhoneTypes();

            Set<Integer> ptIds = new HashSet<>();
            for (PhoneType phoneType : phoneTypes) {
                ptIds.add(phoneType.getId());
            }

            System.out.println("Sub Menú: Elige tipos de teléfono para el contacto");

            for (PhoneType pt : phoneTypes) {
                System.out.println(pt.getId() + ".- " + pt.getName());
            }
            System.out.println("0.- Terminar");
            System.out.println("Tipos de teléfonos agregados: " + phoneTypesIds);
            System.out.print("Ingresa el número de tipo de teléfono: ");

            try {
                opcion = sn.nextInt();
                sn.nextLine(); // Limpieza de buffer

                if (opcion == 0) {
                    salir = true;
                } else if (!ptIds.contains(opcion)) {
                    System.out.println("La opción " + opcion + " no es válida. Ingresa una opción válida");
                } else {
                    phoneTypesIds.add(opcion);
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next(); // Limpiar buffer de entrada
            }

        } while (!salir);

        for (Integer ptId : phoneTypesIds) {
            PhoneType phoneType = phoneTypeService.getPhoneTypeById(ptId);
            if (phoneType != null) {
                MeansContacts meansContact = new MeansContacts();
                meansContact.setValue("Sin valor");
                meansContact.setContact(contact);
                meansContact.setPhoneType(phoneType);
                meansContacts.add(meansContact);
            }
        }

        return meansContacts;
    }

    private void cargarMenuCatalogoTipoContacto() {
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario

        Scanner scanner = new Scanner(System.in);
        ContactType contactType = null;
        int id;
        String name, estatus;

        do {
            System.out.println("1. Ver todos los tipos de contactos");
            System.out.println("2. Buscar por contacto por ID");
            System.out.println("3. Insertar tipo de contacto");
            System.out.println("4. Actualizar tipo de contacto");
            System.out.println("5. Eliminar tipo de contacto");
            System.out.println("6. Salir");
            System.out.println("Escribe una de las opciones");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpieza

                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando: Ver todos los tipos de contacto --");
                        List<ContactType> contactTypeList = contactTypeService.getAllContactType();
                        for (ContactType ct : contactTypeList) {
                            System.out.println(ct);
                        }
                        break;

                    case 2:
                        System.out.println("-- Entrando: Buscar tipo de contacto por ID --");
                        System.out.print("Dame el ID: ");
                        id = scanner.nextInt();
                        contactType = contactTypeService.getContactTypeById(id);
                        System.out.println("El tipo de contacto con id " + id + " es: " + contactType);
                        break;

                    case 3:
                        System.out.println("-- Entrando: Insertar tipo de contacto --");
                        System.out.print("Dame el nombre: ");
                        name = scanner.nextLine();
                        System.out.print("Dame el estatus: ");
                        estatus = scanner.nextLine();
                        contactType = new ContactType();
                        contactType.setName(name);
                        contactType.setStatus(estatus);
                        contactTypeService.insertContactType(contactType);
                        System.out.println("El tipo de contacto que se insertó es: " + contactType);
                        break;

                    case 4:
                        System.out.println("-- Entrando: Actualizar tipo de contacto --");
                        System.out.print("Dame el ID del tipo de contacto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea restante
                        contactType = contactTypeService.getContactTypeById(id);

                        if (contactType == null) {
                            System.out.println("El tipo de contacto con id " + id + " no existe.");
                        } else {
                            System.out.print("Dame el nuevo nombre: ");
                            name = scanner.nextLine();
                            System.out.print("Dame el nuevo estatus: ");
                            estatus = scanner.nextLine();
                            contactType.setName(name);
                            contactType.setStatus(estatus);
                            contactTypeService.updateContactType(contactType);
                            System.out.println("El tipo de contacto actualizado es: " + contactType);
                        }
                        break;

                    case 5:
                        System.out.println("-- Entrando: Eliminar tipo de contacto --");
                        System.out.print("Dame el ID del tipo de contacto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea restante
                        contactType = contactTypeService.getContactTypeById(id);

                        if (contactType == null) {
                            System.out.println("El tipo de contacto con id " + id + " no existe.");
                        } else {
                            contactTypeService.deleteContactType(contactType);
                            System.out.println("El tipo de contacto eliminado es: " + contactType);
                        }
                        break;

                    case 6:
                        System.out.println("-- Saliendo del menú de tipos de contacto --");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no existente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next(); // Limpiar buffer de entrada
            }
        } while (!salir);
    }

    public void cargarMenuCatalogoTipoTelefono() {
        boolean salir = false;
        int opcion; // Guardaremos la opcion del usuario

        Scanner scanner = new Scanner(System.in);
        PhoneType phoneType = null;
        int id;
        String name, estatus;

        do {
            System.out.println("1. Ver todos los tipos de teléfonos");
            System.out.println("2. Buscar por tipo de teléfono");
            System.out.println("3. Insertar tipo de teléfono");
            System.out.println("4. Actualizar tipo de teléfono");
            System.out.println("5. Eliminar tipo de teléfono");
            System.out.println("6. Salir");
            System.out.println("Escribe una de las opciones");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpieza

                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando: Ver todos los tipos de teléfono --");
                        List<PhoneType> phoneTypeList = phoneTypeService.getAllPhoneTypes();
                        for (PhoneType pt : phoneTypeList) {
                            System.out.println(pt);
                        }
                        break;

                    case 2:
                        System.out.println("-- Entrando: Buscar tipo de teléfono por ID --");
                        System.out.print("Dame el ID: ");
                        id = scanner.nextInt();
                        phoneType = phoneTypeService.getPhoneTypeById(id);
                        System.out.println("El tipo de teléfono con id " + id + " es: " + phoneType);
                        break;

                    case 3:
                        System.out.println("-- Entrando: Insertar tipo de teléfono --");
                        System.out.print("Dame el nombre: ");
                        name = scanner.nextLine();
                        System.out.print("Dame el estatus: ");
                        estatus = scanner.nextLine();
                        phoneType = new PhoneType();
                        phoneType.setName(name);
                        phoneType.setStatus(estatus);
                        phoneTypeService.insertPhoneType(phoneType);
                        System.out.println("El tipo de teléfono que se insertó es: " + phoneType);
                        break;

                    case 4:
                        System.out.println("-- Entrando: Actualizar tipo de teléfono --");
                        System.out.print("Dame el ID del tipo de teléfono: ");
                        id = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea restante
                        phoneType = phoneTypeService.getPhoneTypeById(id);

                        if (phoneType == null) {
                            System.out.println("El tipo de teléfono con id " + id + " no existe.");
                        } else {
                            System.out.print("Dame el nuevo nombre: ");
                            name = scanner.nextLine();
                            System.out.print("Dame el nuevo estatus: ");
                            estatus = scanner.nextLine();
                            phoneType.setName(name);
                            phoneType.setStatus(estatus);
                            phoneTypeService.updatePhoneType(phoneType);
                            System.out.println("El tipo de teléfono actualizado es: " + phoneType);
                        }
                        break;

                    case 5:
                        System.out.println("-- Entrando: Eliminar tipo de teléfono --");
                        System.out.print("Dame el ID del tipo de teléfono: ");
                        id = scanner.nextInt();
                        scanner.nextLine();  // Consumir la nueva línea restante
                        phoneType = phoneTypeService.getPhoneTypeById(id);

                        if (phoneType == null) {
                            System.out.println("El tipo de teléfono con id " + id + " no existe.");
                        } else {
                            phoneTypeService.deletePhoneType(phoneType);
                            System.out.println("El tipo de teléfono eliminado es: " + phoneType);
                        }
                        break;

                    case 6:
                        System.out.println("-- Saliendo del menú de tipos de teléfono --");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no existente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next(); // Limpiar buffer de entrada
            }
        } while (!salir);
    }

}