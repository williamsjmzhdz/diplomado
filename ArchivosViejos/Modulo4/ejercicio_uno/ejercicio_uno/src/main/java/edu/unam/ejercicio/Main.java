package edu.unam.ejercicio;

import edu.unam.ejercicio.model.TableTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;
    public void menu() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do{
            System.out.println("1. Crear registro");
            System.out.println("2. Consultar registros");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Inicio de creacion registro...");
                        createRecord();
                        break;
                    case 2:
                        System.out.println("Cargando registros...");
                        readRecord();
                        break;
                    case 3:
                        System.out.println("Actualización de registros...");
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Introduce el id");
                        int id = Integer.parseInt(scanner.nextLine());
                        updateRecord(id);
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo n�meros entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un n�mero");
                sn.next();
            }
        }
        while (!salir) ;
    }

    public void createRecord() {
        Scanner sn = new Scanner(System.in);
        //TableTest tabla = new TableTest();
        System.out.println("Introduce el nombre");
        String first = sn.nextLine();
        System.out.println("Introduce el apellido");
        String last = sn.nextLine();

        try {
            Session session = this.sessionFactory.openSession();
            // se obtiene la session hibernate
            session = this.sessionFactory.openSession();
            // se inicia una transaccion
            session.beginTransaction();
            TableTest tabla = new TableTest();
            tabla.setName(first);
            tabla.setLastName(last);
            session.persist(tabla);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
            System.out.println(tabla);
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( this.registry );
        }

    }

    public void readRecord() {
        try {
            Session session = this.sessionFactory.openSession();
            // se obtiene la session hibernate
            session = this.sessionFactory.openSession();
            // se inicia una transaccion
            session.beginTransaction();
            List<TableTest> result = session.createQuery("FROM TableTest", TableTest.class).getResultList();
            for (TableTest tabla : result) {
                System.out.println(tabla);
            }
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( this.registry );
        }
    }

    public void updateRecord(int id) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce el nuevo nombre");
        String first = sn.nextLine();
        System.out.println("Introduce el nuevo apellido");
        String last = sn.nextLine();

        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();

            // Cargar el registro existente usando el id
            TableTest tabla = session.get(TableTest.class, id);
            if (tabla == null) {
                System.out.println("Registro no encontrado con ID: " + id);
                return;
            }

            // Actualizar los datos
            tabla.setName(first);
            tabla.setLastName(last);

            // Guardar los cambios
            session.merge(tabla);
            session.getTransaction().commit();
            System.out.println("Registro actualizado: " + tabla);
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void init() {
        registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // se carga la configuracion hibernate
                .build();
        try {
            // se crea una fabrica de sessiones hibernate
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public static void main(String[] args) {
        Main mapping = new Main();
        mapping.init();
        mapping.menu();
    }
}
