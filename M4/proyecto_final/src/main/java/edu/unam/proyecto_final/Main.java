package edu.unam.proyecto_final;

import edu.unam.proyecto_final.hibernate.HibernateUtil;
import edu.unam.proyecto_final.model.Rol;
import edu.unam.proyecto_final.model.Usuario;
import edu.unam.proyecto_final.model.UsuarioRol;
import edu.unam.proyecto_final.service.RolService;
import edu.unam.proyecto_final.service.UsuarioRolService;
import edu.unam.proyecto_final.service.UsuarioService;
import edu.unam.proyecto_final.service.impl.RolServiceImpl;
import edu.unam.proyecto_final.service.impl.UsuarioRolServiceImpl;
import edu.unam.proyecto_final.service.impl.UsuarioServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final RolService rolService = RolServiceImpl.getInstance();
    private static final UsuarioService usuarioService = UsuarioServiceImpl.getInstance();
    private static final UsuarioRolService usuarioRolService = UsuarioRolServiceImpl.getInstance();

    public static void main(String[] args) {
        HibernateUtil.init();
        cargarMenuPrincipal();
    }

    public static void cargarMenuPrincipal() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int eleccion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (eleccion) {
                case 1:
                    gestionarRoles(scanner);
                    break;
                case 2:
                    gestionarUsuarios(scanner);
                    break;
                case 3:
                    gestionarAsignacionRoles(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n==================================");
        System.out.println("=           Menú Principal       =");
        System.out.println("==================================");
        System.out.println("1.- Administrar roles");
        System.out.println("2.- Administrar usuarios");
        System.out.println("3.- Administrar asignación de roles");
        System.out.println("4.- Salir");
        System.out.println("==================================\n");
    }

    private static void gestionarRoles(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Roles --");
            System.out.println("1. Crear un nuevo rol");
            System.out.println("2. Ver roles");
            System.out.println("3. Actualizar un rol");
            System.out.println("4. Eliminar un rol");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearRol(scanner);
                    break;
                case 2:
                    verRoles();
                    break;
                case 3:
                    actualizarRol(scanner);
                    break;
                case 4:
                    eliminarRol(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void crearRol(Scanner scanner) {
        System.out.print("Ingrese el nombre del rol: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del rol: ");
        String descripcion = scanner.nextLine();

        Rol nuevoRol = new Rol();
        nuevoRol.setNombre(nombre);
        nuevoRol.setDescripcion(descripcion);

        boolean resultado = rolService.create(nuevoRol);
        if (resultado) {
            System.out.println("Rol creado exitosamente.");
        } else {
            System.out.println("Error al crear el rol.");
        }
    }

    private static void verRoles() {
        List<Rol> roles = rolService.findAll();
        if (roles.isEmpty()) {
            System.out.println("No hay roles registrados.");
        } else {
            roles.forEach(rol -> System.out.println("ID: " + rol.getId() + ", Nombre: " + rol.getNombre() + ", Descripción: " + rol.getDescripcion()));
        }
    }

    private static void actualizarRol(Scanner scanner) {
        System.out.print("Ingrese el ID del rol a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Rol rol = rolService.get(id);
        if (rol == null) {
            System.out.println("Rol no encontrado.");
        } else {
            System.out.print("Ingrese el nuevo nombre del rol: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del rol: ");
            String descripcion = scanner.nextLine();

            rol.setNombre(nombre);
            rol.setDescripcion(descripcion);
            boolean resultado = rolService.update(rol);
            if (resultado) {
                System.out.println("Rol actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el rol.");
            }
        }
    }

    private static void eliminarRol(Scanner scanner) {
        System.out.print("Ingrese el ID del rol a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Rol rol = rolService.get(id);
        if (rol == null) {
            System.out.println("Rol no encontrado.");
        } else {
            boolean resultado = rolService.delete(rol);
            if (resultado) {
                System.out.println("Rol eliminado exitosamente.");
            } else {
                System.out.println("Error al eliminar el rol.");
            }
        }
    }

    private static void gestionarUsuarios(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Usuarios --");
            System.out.println("1. Crear un nuevo usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Actualizar un usuario");
            System.out.println("4. Eliminar un usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearUsuario(scanner);
                    break;
                case 2:
                    verUsuarios();
                    break;
                case 3:
                    actualizarUsuario(scanner);
                    break;
                case 4:
                    eliminarUsuario(scanner);
                    break;
                case 5:
                    return; // Vuelve al menú principal
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void crearUsuario(Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido paterno: ");
        String apellidoPaterno = scanner.nextLine();
        System.out.print("Ingrese el apellido materno: ");
        String apellidoMaterno = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasenia = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellidoPaterno(apellidoPaterno);
        nuevoUsuario.setApellidoMaterno(apellidoMaterno);
        nuevoUsuario.setCorreoElectronico(correoElectronico);
        nuevoUsuario.setContrasenia(contrasenia);

        // Guarda el usuario nuevo en la base de datos
        boolean resultadoUsuario = usuarioService.create(nuevoUsuario);
        if (resultadoUsuario) {
            System.out.println("Usuario creado exitosamente.");

            // Asume que el rol "Cliente" tiene un ID específico, aquí se podría buscar por nombre
            Rol rolCliente = rolService.get(1);  // Obtener el rol "Cliente" según el ID adecuado
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(nuevoUsuario);
            usuarioRol.setRol(rolCliente);
            usuarioRol.setFechaAsignacion(LocalDateTime.now());

            // Guarda la relación UsuarioRol en la base de datos
            boolean resultadoRol = usuarioRolService.create(usuarioRol);

            if (resultadoRol) {
                System.out.println("Rol de Cliente asignado exitosamente.");
            } else {
                System.out.println("Error al asignar el rol de Cliente.");
            }
        } else {
            System.out.println("Error al crear el usuario.");
        }
    }


    private static void verUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(usuario -> System.out.println(usuario));
        }
    }

    private static void actualizarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Usuario usuario = usuarioService.get(id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            System.out.print("Ingrese el nuevo nombre del usuario: ");
            usuario.setNombre(scanner.nextLine());
            System.out.print("Ingrese el nuevo apellido paterno: ");
            usuario.setApellidoPaterno(scanner.nextLine());
            System.out.print("Ingrese el nuevo apellido materno: ");
            usuario.setApellidoMaterno(scanner.nextLine());
            System.out.print("Ingrese el nuevo correo electrónico: ");
            usuario.setCorreoElectronico(scanner.nextLine());
            System.out.print("Ingrese la nueva contraseña: ");
            usuario.setContrasenia(scanner.nextLine());

            boolean resultado = usuarioService.update(usuario);
            if (resultado) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el usuario.");
            }
        }
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Usuario usuario = usuarioService.get(id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
        } else {
            boolean resultado = usuarioService.delete(usuario);
            if (resultado) {
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("Error al eliminar el usuario.");
            }
        }
    }

    private static void gestionarAsignacionRoles(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n-- Gestión de Asignación de Roles --");
            System.out.println("1. Asignar un rol a un usuario");
            System.out.println("2. Quitar un rol de un usuario");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    asignarRolAUsuario(scanner);
                    break;
                case 2:
                    quitarRolDeUsuario(scanner);
                    break;
                case 3:
                    return; // Vuelve al menú principal
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void asignarRolAUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario al que desea asignar un rol: ");
        int usuarioId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el ID del rol que desea asignar: ");
        int rolId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        boolean resultado = usuarioRolService.assignRoleToUser(usuarioId, rolId);
        if (resultado) {
            System.out.println("Rol asignado correctamente al usuario.");
        } else {
            System.out.println("Error al asignar el rol al usuario.");
        }
    }

    private static void quitarRolDeUsuario(Scanner scanner) {
        System.out.print("Ingrese el ID del usuario del que desea quitar un rol: ");
        int usuarioId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el ID del rol que desea quitar: ");
        int rolId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        boolean resultado = usuarioRolService.removeRoleToUser(usuarioId, rolId);
        if (resultado) {
            System.out.println("Rol quitado correctamente del usuario.");
        } else {
            System.out.println("Error al quitar el rol del usuario.");
        }
    }

}
